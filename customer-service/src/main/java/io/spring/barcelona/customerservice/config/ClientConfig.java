package io.spring.barcelona.customerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Olga Maciaszek-Sharma
 */
@Configuration
public class ClientConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
