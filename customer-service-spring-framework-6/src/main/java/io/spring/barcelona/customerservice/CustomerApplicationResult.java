package io.spring.barcelona.customerservice;

import java.util.UUID;

/**
 * @author Olga Maciaszek-Sharma
 */
public class CustomerApplicationResult {

	private UUID customerApplicationId;
	private UUID customerId;
	private Status applicationStatus;

	public CustomerApplicationResult() {
	}

	public CustomerApplicationResult(UUID customerApplicationId, UUID customerId, Status applicationStatus) {
		this.customerApplicationId = customerApplicationId;
		this.customerId = customerId;
		this.applicationStatus = applicationStatus;
	}

	public UUID getCustomerApplicationId() {
		return customerApplicationId;
	}

	public void setCustomerApplicationId(UUID customerApplicationId) {
		this.customerApplicationId = customerApplicationId;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public Status getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(Status applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	enum Status {
		ACCEPTED, REJECTED
	}

}
