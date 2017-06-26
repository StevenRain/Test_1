package kafka;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

/**
 * Created by Steven
 * Date:2017/6/26
 * Time:15:41
 */
@SpringBootApplication
public class MyKafkaProducer {

	public static void main(String[] args) throws Exception{

		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.1.251:9092");
//		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);


		String topic = "topic";
		String key = "steven";
		String key2 = "rain";
		String value = "0123456";

		producer.send(new ProducerRecord<>(topic, key, value));
		producer.send(new ProducerRecord<>(topic, key2, value));
		producer.close();
	}
}
