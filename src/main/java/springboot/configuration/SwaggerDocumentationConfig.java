package springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Steven
 * Date:2017/5/29
 * Time:14:27
 */
@Profile(value = {"dev", "sit"})
@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Kafka测试")
				.license("")
				.licenseUrl("")
				.termsOfServiceUrl("")
				.version("1.0.0")
				.build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("springboot.web"))
				.build()
				.apiInfo(apiInfo());
	}
}
