import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import scala.collection.convert.JavaCollectionWrappers;
import sun.jvm.hotspot.debugger.bsd.amd64.BsdAMD64CFrame;

import java.util.Properties;

public class SampleProducer {

    public SampleProducer()
    {
        Properties proerties = new Properties();
        proerties.put("bootstrap.servers","localhost:9092");
        proerties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        proerties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        ProducerRecord producerRecord = new ProducerRecord("test","name","producing from application");
        KafkaProducer kafkaProducer = new KafkaProducer(proerties);

        kafkaProducer.send(producerRecord);
        kafkaProducer.close();

    }
}
