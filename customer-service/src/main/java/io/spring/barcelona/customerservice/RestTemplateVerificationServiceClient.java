package io.spring.barcelona.customerservice;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Olga Maciaszek-Sharma
 */
@Component
public class RestTemplateVerificationServiceClient implements VerificationServiceClient {

	private final RestTemplate restTemplate;

	public RestTemplateVerificationServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public CustomerVerificationResult verify(CustomerApplication customerApplication) {
		UriComponents uri = buildUri("/verify");
		HttpHeaders headers = buildHeaders();
		HttpEntity<CustomerApplication> request = new HttpEntity<>(customerApplication, headers);
		return restTemplate.postForObject(uri.toString(), request, CustomerVerificationResult.class);
	}

	private HttpHeaders buildHeaders() {
		return buildHeaders(Collections.emptyMap());
	}

	private HttpHeaders buildHeaders(Map<String, String> headerValues) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setAll(headerValues);
		return headers;
	}

	private UriComponents buildUri(String path) {
		return UriComponentsBuilder.newInstance().scheme("http")
				.host("localhost:9080").path(path).build();
	}
}
