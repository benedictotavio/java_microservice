package com.br.auth_control.config;

import com.br.auth_control.consumer.UserRegisteredListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name.owner}")
    private String QUEUE_NAME;

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(listenerAdapter);

        container.setQueueNames(QUEUE_NAME);

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(UserRegisteredListener listener) {
        return new MessageListenerAdapter(listener, "onMessageReceived");
    }

}
