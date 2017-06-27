package springboot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/6/27
 * Time:11:01
 */
@SpringBootApplication
@ComponentScan(basePackages = {"springboot.kafka", "springboot.configuration", "springboot.web"})
@Slf4j
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}
}
