package springboot.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Steven
 * Date:2017/5/29
 * Time:14:25
 */
@Profile(value = {"dev", "sit"})
@Controller
@Slf4j
public class HomeController {
	@RequestMapping(value = "/")
	public String index() {
		log.info("swagger-ui.html");
		return "redirect:swagger-ui.html";
	}
}
