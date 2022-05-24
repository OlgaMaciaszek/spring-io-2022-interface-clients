package io.spring.barcelona.verificationservice.person;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Olga Maciaszek-Sharma
 */
@RestController
public class PersonVerificationController {

	private final PersonVerificationService verificationService;

	public PersonVerificationController(PersonVerificationService verificationService) {
		this.verificationService = verificationService;
	}

	@PostMapping("/verify")
	Mono<PersonVerificationResult> verify(@RequestBody Person person) {
		return Mono.just(verificationService.verify(person));
	}

}
