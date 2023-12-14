package com.br.auth_control.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.br.auth_control.dtos.RegisteredUserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserRegisteredListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConfig.class);

    public void onMessageReceived(String message) {
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<RegisteredUserDto> mapType = new TypeReference<RegisteredUserDto>() {
        };

        try {
            RegisteredUserDto payloaUserRegisteredDto = objectMapper.readValue(message, mapType);
            LOGGER.info("Message received");
            LOGGER.info("User full name:    " + payloaUserRegisteredDto.name());
            LOGGER.info("Document:     " + payloaUserRegisteredDto.document());
            LOGGER.info("Email:    " + payloaUserRegisteredDto.email());
            isClientPremium(payloaUserRegisteredDto);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void isClientPremium(RegisteredUserDto userDto) {
        if (userDto.premium()) {
            LOGGER.info("Client Premium:   " + userDto.premium());
        } else {
            LOGGER.error("No Premium:  " + userDto.premium());
        }
    }
}
