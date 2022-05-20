package io.spring.barcelona.customerservice;

import java.util.UUID;

/**
 * @author Olga Maciaszek-Sharma
 */
public class CustomerVerificationResult {

	private UUID customerId;
	private Status status;

	CustomerVerificationResult() {
	}

	CustomerVerificationResult(UUID customerId, Status status) {
		this.customerId = customerId;
		this.status = status;
	}

	UUID getCustomerId() {
		return customerId;
	}

	void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	Status getStatus() {
		return status;
	}

	void setStatus(Status status) {
		this.status = status;
	}

	enum Status {
		APPROVED, REJECTED
	}
}
