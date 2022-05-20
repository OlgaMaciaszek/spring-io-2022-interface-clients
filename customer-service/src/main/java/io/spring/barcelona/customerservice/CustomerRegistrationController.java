package io.spring.barcelona.customerservice;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Olga Maciaszek-Sharma
 */
@RestController
public class CustomerRegistrationController {

	private final CustomerRegistrationService registrationService;

	public CustomerRegistrationController(CustomerRegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@PostMapping("/register")
	CustomerApplicationResult register(@RequestBody CustomerApplication customerApplication) {
		return registrationService.register(customerApplication);
	}

	@GetMapping("/test")
	CustomerApplicationResult register() {
		return registrationService.register(new CustomerApplication(UUID.randomUUID(),
				"Anna", "Smith"));
	}
}

