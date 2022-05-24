package io.spring.barcelona.customerservice;

import org.springframework.stereotype.Service;

/**
 * @author Olga Maciaszek-Sharma
 */
@Service
public class CustomerRegistrationService {
	private final CustomerRepository customerRepository;

	private final VerificationService verificationService;

	public CustomerRegistrationService(CustomerRepository customerRepository, VerificationService verificationService) {
		this.customerRepository = customerRepository;
		this.verificationService = verificationService;
	}

	CustomerApplicationResult register(CustomerApplication customerApplication) {
		CustomerVerificationResult verificationResult = verificationService.verify(customerApplication);
		if (CustomerVerificationResult.Status.APPROVED.equals(verificationResult.getStatus())) {
			Customer customer = customerRepository.create(new Customer(customerApplication));
			return new CustomerApplicationResult(customerApplication.getId(), customer.getId(), CustomerApplicationResult.Status.ACCEPTED);
		}
		return new CustomerApplicationResult(customerApplication.getId(), null, CustomerApplicationResult.Status.REJECTED);
	}

}
