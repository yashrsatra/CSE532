package com.stonybrook.politech.controllers;

import com.stonybrook.politech.model.GeometricDetailsGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, GeometricDetailsGenerated> kafkaTemplate;

    @GetMapping("/sendMessage")
    public void sendMessagetoKafka(){
        GeometricDetailsGenerated user = GeometricDetailsGenerated.newBuilder().setID("1234")
                .setDemVote(1)
                .setGopVote(10)
                .setGeometryJSON("This is a dummy message")
                .setPopulation(1000)
                .setOriginalDistrictID("!")
                .build();
        System.out.println("In RestController, about to send message to Kafka ! ");
        kafkaTemplate.send("topic",user);
    }

    @GetMapping("/")
    public String root(){
        return "Hello World";
    }

}
