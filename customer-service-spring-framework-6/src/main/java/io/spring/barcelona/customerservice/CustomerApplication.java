package io.spring.barcelona.customerservice;

import java.util.UUID;

/**
 * @author Olga Maciaszek-Sharma
 */
public class CustomerApplication {

	private UUID id;
	private String firstName;
	private String lastName;

	public CustomerApplication() {
	}

	public CustomerApplication(UUID id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
