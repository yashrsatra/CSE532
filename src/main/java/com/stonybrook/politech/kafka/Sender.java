package com.stonybrook.politech.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class Sender {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Sender(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String payload) {
        kafkaTemplate.send("topic", payload);
    }
}
