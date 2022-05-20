package io.spring.barcelona.verificationservice.person;

import java.util.UUID;

/**
 * @author Olga Maciaszek-Sharma
 */
public class Person {

	private UUID id;
	private String firstName;
	private String lastName;

	public Person() {
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
