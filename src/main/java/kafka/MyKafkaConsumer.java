package kafka;

import com.google.common.collect.Lists;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;


/**
 * Created by Steven
 * Date:2017/6/26
 * Time:16:16
 */
@SpringBootApplication
public class MyKafkaConsumer {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.1.251:9092");
//		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");


		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

		String topic = "topic";
		consumer.subscribe(Lists.newArrayList(topic));
		ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);

		for(ConsumerRecord<String, String> consumerRecord : consumerRecords) {
			String pattern = "%s  %s  %s";
			System.out.println(String.format(pattern, consumerRecord.topic(), consumerRecord.key(), consumerRecord.value()));
		}


		consumer.close();
	}
}
