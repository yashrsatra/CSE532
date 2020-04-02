package com.stonybrook.politech.controllers;

import com.stonybrook.politech.kafka.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/sendMessage")
    public void sendMessagetoKafka(){
        System.out.println("In RestController, about to send message to Kafka ! ");
        kafkaTemplate.send("topic","This is a dummy message");
    }

    @GetMapping("/")
    public String root(){
        return "Hello World";
    }

}
