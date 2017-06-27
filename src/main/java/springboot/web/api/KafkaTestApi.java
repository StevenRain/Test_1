package springboot.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;

/**
 * Created by Steven
 * Date:2017/6/27
 * Time:11:26
 */
public interface KafkaTestApi {

	@ApiOperation(value = "查询应用列表", response = String.class)
	@RequestMapping(path = "/produce", method = RequestMethod.GET)
	void kafkaProduce();
}
