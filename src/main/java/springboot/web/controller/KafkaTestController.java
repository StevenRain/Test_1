package springboot.web.controller;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import springboot.kafka.MyProducer;
import springboot.web.api.KafkaTestApi;

/**
 * Created by Steven
 * Date:2017/6/27
 * Time:11:27
 */
@RestController
public class KafkaTestController implements KafkaTestApi {

	@Resource
	private MyProducer producer;

	@Override
	public void kafkaProduce() {
		producer.send();
	}
}
