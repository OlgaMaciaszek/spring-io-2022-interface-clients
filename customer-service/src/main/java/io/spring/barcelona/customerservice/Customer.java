package io.spring.barcelona.customerservice;

import java.util.UUID;

/**
 * @author Olga Maciaszek-Sharma
 */
public class Customer {

	private final UUID id;
	private final String firstName;
	private final String lastName;


	public Customer(UUID id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer(CustomerApplication customerApplication) {
		this(UUID.randomUUID(), customerApplication.getFirstName(), customerApplication.getLastName());
	}

	UUID getId() {
		return id;
	}

	String getFirstName() {
		return firstName;
	}

	String getLastName() {
		return lastName;
	}
}
