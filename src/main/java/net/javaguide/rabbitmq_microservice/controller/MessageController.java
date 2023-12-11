package net.javaguide.rabbitmq_microservice.controller;

import org.springframework.web.bind.annotation.RestController;

import net.javaguide.rabbitmq_microservice.publisher.RabbitMqProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private RabbitMqProducer producer;

    public MessageController(RabbitMqProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        try {
            producer.sendMessage(message);
            return ResponseEntity.ok("Message send to RabbitMQ");
        } catch (ExceptionInInitializerError e) {
            System.out.println(e);
            throw new ExceptionInInitializerError();
        }
    }
}
