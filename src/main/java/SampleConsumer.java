import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class SampleConsumer {

    public SampleConsumer()
    {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("group.id","test.group");
        properties.put("enable.auto.commit","true");
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);

        kafkaConsumer.subscribe(Arrays.asList("test"));

        while (true)
        {
            ConsumerRecords<String,String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String,String> records1:records) {
                System.out.println(records1.key() +"===="+records1.value());
            }
        }
    }
}
