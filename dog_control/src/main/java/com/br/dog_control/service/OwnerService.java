package com.br.dog_control.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.br.dog_control.config.RabbitMQConfig;
import com.br.dog_control.dtos.owner.OwnerDtoRequest;
import com.br.dog_control.dtos.owner.OwnerDtoResponse;
import com.br.dog_control.models.Owner;
import com.br.dog_control.repository.OwnerRepository;
import com.br.dog_control.utils.interfaces.OwnerServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OwnerService implements OwnerServiceInterface {

    @Value("${rabbitmq.queue.name.owner}")
    private String QUEUE_NAME;

    @Value("${rabbitmq.exchange.name.owner}")
    private String EXCHANGE_NAME;

    @Value("${rabbitmq.routing.key.owner}")
    private String ROUTING_KEY;

    private final OwnerRepository ownerRepository;

    private final RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConfig.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public OwnerService(OwnerRepository ownerRepository, RabbitTemplate rabbitTemplate) {
        this.ownerRepository = ownerRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public OwnerDtoResponse createNewOwner(OwnerDtoRequest ownerDtoRequest) {
        Owner owner = new Owner();
        owner.setDocument(ownerDtoRequest.document());
        owner.setName(ownerDtoRequest.name());
        owner.setEmail(ownerDtoRequest.email());
        owner.setPremium(ownerDtoRequest.premium());

        Owner newOwner = ownerRepository.save(owner);

        try {
            OwnerDtoRequest dto = new OwnerDtoRequest(newOwner.getName(), newOwner.getDocument(), newOwner.getEmail(),
                    newOwner.isPremium());
            sendOwnerMessage(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new OwnerDtoResponse(newOwner.getDocument(), newOwner.getName(), newOwner.getEmail(),
                newOwner.isPremium());
    }

    @Override
    public Optional<Owner> findOwnerByDocument(String document) {
        return ownerRepository.findById(document);
    }

    private void sendOwnerMessage(OwnerDtoRequest registerUser) throws JsonProcessingException {
        OwnerDtoResponse ownerPayload = new OwnerDtoResponse(registerUser.document(), registerUser.name(),
                registerUser.email(), registerUser.premium());
        String ownerPayloadString = OBJECT_MAPPER.writeValueAsString(ownerPayload);
        rabbitTemplate.convertAndSend(QUEUE_NAME, ownerPayloadString);
        LOGGER.info(ownerPayloadString);
    }
}