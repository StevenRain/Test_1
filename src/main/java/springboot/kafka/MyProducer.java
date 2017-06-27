package springboot.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/6/27
 * Time:10:55
 */
@Component
@Slf4j
public class MyProducer {


	@Resource
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send() {
		kafkaTemplate.send("my-topic","123456");
		kafkaTemplate.send("my-topic","123456");

		kafkaTemplate.metrics();

		kafkaTemplate.execute(new KafkaOperations.ProducerCallback<String, String, Object>() {
			@Override
			public Object doInKafka(Producer<String, String> producer) {
				return null;
			}
		});

		kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
			@Override
			public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
				log.warn("消息发送成功");
			}

			@Override
			public void onError(String topic, Integer partition, String key, String value, Exception exception) {
				log.error("消息发送成功");
			}

			@Override
			public boolean isInterestedInSuccess() {
				return false;
			}
		});
	}

}
