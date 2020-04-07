package com.stonybrook.politech.kafka;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.concurrent.TimeUnit;

import com.stonybrook.politech.model.GeometricDetailsGenerated;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1,
        topics = {SpringKafkaApplicationIT.HELLOWORLD_TOPIC})
public class SpringKafkaApplicationIT {

    static final String HELLOWORLD_TOPIC = "topic";

    @Autowired
    private Receiver receiver;

    @Autowired
    private Sender sender;

//    @Test
//    public void testReceive() throws Exception {
//        sender.send("Hello Spring Kafka!");
//
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
//    }

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

//    @ClassRule
//    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "helloworld.topic");

//    @Before
//    public void setUp() throws Exception {
//        // wait until the partitions are assigned
//        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
//                .getListenerContainers()) {
//            ContainerTestUtils.waitForAssignment(messageListenerContainer,
//                    embeddedKafka.getPartitionsPerTopic());
//        }
//    }

    @Test
    public void testReceiver() throws Exception {
        GeometricDetailsGenerated user = GeometricDetailsGenerated.newBuilder().setID("1234")
                .setDemVote(1)
                .setGopVote(10)
                .setGeometryJSON("This is a dummy message")
                .setPopulation(1000)
                .setOriginalDistrictID("!")
                .build();
        sender.send(user);

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
    }
}
