package springboot.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/6/27
 * Time:10:55
 */
@Component
@Slf4j
public class MyConsumer {

	@KafkaListener(topics = {"my-topic","my-topic2"})
	public void processMessage(String content) {
		log.info("收到消息{}", content);
	}
}
