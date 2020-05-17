const KafkaAvro = require('kafka-avro');

// console.log(KafkaAvro.CODES);

const kafkaAvro = new KafkaAvro({
    kafkaBroker: 'localhost:9092',
    schemaRegistry: 'http://localhost:8081',
});

// Query the Schema Registry for all topic-schema's
// fetch them and evaluate them.
kafkaAvro.init()
    .then(function() {
        console.log('Ready to use');
    });