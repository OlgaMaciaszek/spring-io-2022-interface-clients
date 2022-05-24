package io.spring.barcelona.customerservice;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * @author Olga Maciaszek-Sharma
 */
@Component
public class RestTemplateVerificationServiceClient implements VerificationServiceClient {

	private final RestTemplate restTemplate;

	public RestTemplateVerificationServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory("http://localhost:9080");
		restTemplate.setUriTemplateHandler(factory);
	}

	@Override
	public CustomerVerificationResult verify(CustomerApplication customerApplication) {
		HttpHeaders headers = buildHeaders();
		HttpEntity<CustomerApplication> request = new HttpEntity<>(customerApplication, headers);
		return restTemplate.postForObject("/verify", request, CustomerVerificationResult.class);
	}

	private HttpHeaders buildHeaders() {
		return buildHeaders(Collections.emptyMap());
	}

	private HttpHeaders buildHeaders(Map<String, String> headerValues) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Custom-Header", "test");
		headers.setAll(headerValues);
		return headers;
	}
}
