package io.spring.barcelona.customerservice;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * @author Olga Maciaszek-Sharma
 */
@Service
public class CustomerRegistrationService {

	private final RestTemplate restTemplate;
	private final CustomerRepository customerRepository;

	private final VerificationServiceOFClient verificationServiceOFClient;
	private final VerificationServiceClient verificationServiceClient;

	public CustomerRegistrationService(RestTemplate restTemplate, CustomerRepository customerRepository, VerificationServiceOFClient verificationServiceOFClient, VerificationServiceClient verificationServiceClient) {
		this.restTemplate = restTemplate;
		this.customerRepository = customerRepository;
		this.verificationServiceOFClient = verificationServiceOFClient;
		this.verificationServiceClient = verificationServiceClient;
	}

	CustomerApplicationResult register(CustomerApplication customerApplication) {
//		CustomerVerificationResult verificationResult = verify(customerApplication);
//		CustomerVerificationResult verificationResult = verificationServiceClient.verify(customerApplication);
		CustomerVerificationResult verificationResult = verificationServiceOFClient.verify(customerApplication, "test");
		if (CustomerVerificationResult.Status.APPROVED.equals(verificationResult.getStatus())) {
			Customer customer = customerRepository.create(new Customer(customerApplication));
			return new CustomerApplicationResult(customerApplication.getId(), customer.getId(), CustomerApplicationResult.Status.ACCEPTED);
		}
		return new CustomerApplicationResult(customerApplication.getId(), null, CustomerApplicationResult.Status.REJECTED);
	}

	private CustomerVerificationResult verify(CustomerApplication customerApplication) {
		DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory("http://localhost:9080");
		restTemplate.setUriTemplateHandler(factory);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Custom-Header", "test");
		HttpEntity<CustomerApplication> request = new HttpEntity<>(customerApplication, headers);
		return restTemplate.postForObject("/verify", request, CustomerVerificationResult.class);
	}
}
