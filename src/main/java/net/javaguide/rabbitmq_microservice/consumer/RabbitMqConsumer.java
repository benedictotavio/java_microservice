package net.javaguide.rabbitmq_microservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqConsumer.class);

    @RabbitListener(queues = { "${rabbitmq.queue.name}" })
    public void receive(String message) {
        LOGGER.info(String.format("Receive message -> %s", message));
    }
}
