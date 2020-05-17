const kafka = require('kafka-node');
const bp = require('body-parser');
const avro=require('avsc');
// const config = require('./config');


try {
  var Consumer = kafka.Consumer;
  var client = new kafka.KafkaClient({kafkaHost: 'localhost:9092'});
  var type = avro.Type.forSchema({
    type: 'record',
    name:'GeometricDetailsGenerated',
    namespace:'com.stonybrook.politech.model',
    fields: [
      {
      name:'ID',
      type:'string'
    },
    {
      name:'geometryJSON',
      type: 'string'
    },
    {
      name:'originalDistrictID',
      type: 'string'
    },
    {
      name:'population',
      type: 'int'
    },
    {
      name:'gop_vote',
      type: 'int'
    },
    {
      name:'dem_vote',
      type: 'int'
    }
    ]
  });
  var consumer = new Consumer(
    client,
    [{ topic: 'topic', partition: 0 }],
    {
      autoCommit: true,
      encoding:'buffer'
      // ,
      // fetchMaxWaitMs: 1000,
      // fetchMaxBytes: 1024 * 1024,
      // encoding: 'utf8',
      // fromOffset: false
    }
  );
  consumer.on('message', async function(message) {
    console.log('here');
    console.log(message);
    var buf =  Buffer.from(message.value, 'binary'); // Read string into a buffer.
    console.log(buf)
    var decodedMessage = type.fromBuffer(buf); // Skip prefix..slice(5)
    console.log("testing avsc")
    console.log(decodedMessage);
    console.log(
      'kafka-> ',
      message.value
    );
  })
  consumer.on('error', function(err) {
    console.log('error', err);
  });
}
catch(e) {
  console.log(e);
}
