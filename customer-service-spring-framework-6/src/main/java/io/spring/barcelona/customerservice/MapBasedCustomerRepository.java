package io.spring.barcelona.customerservice;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

/**
 * @author Olga Maciaszek-Sharma
 */
@Repository
public class MapBasedCustomerRepository implements CustomerRepository {

	private final Map<UUID, Customer> customers = new ConcurrentHashMap<>();

	@Override
	public Customer create(Customer customer) {
		customers.put(customer.getId(), customer);
		return customer;
	}

	@Override
	public Customer get(UUID id) {
		return customers.get(id);
	}
}
