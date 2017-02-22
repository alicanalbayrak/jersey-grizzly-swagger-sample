package com.gilmour.repository;

import java.util.List;

import com.gilmour.model.Customer;
import com.gilmour.model.CustomerSearch;

public interface CustomerRepository {

	List<Customer> findAllCustomers();

	Customer findCustomer(String customerId);

	Customer findCustomerObject(String customerId);

	void create(Customer customer);

	Customer update(Customer customer);

	void delete(String customerId);

	List<Customer> findByDescription(List<String> descriptions);

	List<Customer> findByConstraint(CustomerSearch search);
}
