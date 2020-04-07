package com.stonybrook.politech.kafka;

import com.stonybrook.politech.model.GeometricDetailsGenerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@Service
public class Sender {

    private KafkaTemplate<String, GeometricDetailsGenerated> kafkaTemplate;

    @Autowired
    public Sender(KafkaTemplate<String, GeometricDetailsGenerated> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(GeometricDetailsGenerated payload) {
        kafkaTemplate.send("topic", payload);
    }
}
