package io.spring.barcelona.verificationservice.person;

import org.apache.commons.lang3.StringUtils;

import org.springframework.stereotype.Service;

/**
 * @author Olga Maciaszek-Sharma
 */
@Service
public class PersonVerificationService {

	PersonVerificationResult verify(Person person) {
		if (StringUtils.isAlphanumeric(person.getFirstName())
				&& StringUtils.isAlphanumeric(person.getLastName())) {
			return new PersonVerificationResult(person.getId(), PersonVerificationResult.Status.APPROVED);
		}
		return new PersonVerificationResult(person.getId(), PersonVerificationResult.Status.REJECTED);
	}
}
