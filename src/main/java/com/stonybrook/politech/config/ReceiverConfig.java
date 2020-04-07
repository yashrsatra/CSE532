package com.stonybrook.politech.config;

import java.util.HashMap;
import java.util.Map;

import com.stonybrook.politech.avro.AvroDeserializer;
import com.stonybrook.politech.kafka.Receiver;
import com.stonybrook.politech.model.GeometricDetailsGenerated;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
@EnableKafka
public class ReceiverConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        // list of host:port pairs used for establishing the initial connections to the Kafka cluster
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                AvroDeserializer.class);
        // allows a pool of processes to divide the work of consuming and processing records
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "helloworld");
        // automatically reset the offset to the earliest offset
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    @Bean
    public ConsumerFactory<String, GeometricDetailsGenerated> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
                new AvroDeserializer<>(GeometricDetailsGenerated.class));
//        return new DefaultKafkaConsumerFactory<String, org.apache.avro.specific.SpecificRecordBase>(consumerConfigs(), new StringDeserializer(), new AvroDeserializer<>(GeometricDetailsGenerated.class));
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, GeometricDetailsGenerated>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, GeometricDetailsGenerated> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}