package io.spring.barcelona.verificationservice.person;

import java.util.UUID;

/**
 * @author Olga Maciaszek-Sharma
 */
public class PersonVerificationResult {

	private UUID customerId;
	private Status status;

	public PersonVerificationResult() {
	}

	public PersonVerificationResult(UUID customerId, Status status) {
		this.customerId = customerId;
		this.status = status;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	enum Status {
		APPROVED, REJECTED
	}
}
