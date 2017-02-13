package com.gilmour.repository;

import java.util.ArrayList;
import java.util.List;

import com.gilmour.model.Customer;
import com.gilmour.model.CustomerHelperObject;

public class CustomerRepositoryStub implements CustomerRepository {

	public List<Customer> findAllCustomers() {
		List<Customer> customers = new ArrayList<>();

		Customer customer = new Customer();
		customer.setEmail("deneme@mail.com");
		customer.setPassword("123456");

		Customer customer2 = new Customer();
		customer2.setEmail("deneme2@mail.com");
		customer2.setPassword("abcdefg");

		customers.add(customer);
		customers.add(customer2);

		return customers;
	}

	@Override
	public Customer findCustomer(String customerId) {

		Customer customer = new Customer();
		customer.setEmail("deneme@mail.com");
		customer.setPassword("123456");

		return customer;
	}

	@Override
	public Customer findCustomerObject(String customerId) {

		CustomerHelperObject customerHelperObject = new CustomerHelperObject();
		customerHelperObject.setId("12312312");
		customerHelperObject.setName("helper");

		Customer customer = new Customer();
		customer.setEmail("deneme@mail.com");
		customer.setPassword("123456");
		customer.setCustomerHelperObject(customerHelperObject);

		return customer;

	}

	@Override
	public void create(Customer customer) {
		// should insert statement to DB
	}

	@Override
	public Customer update(Customer customer) {
		// search the database to see if we have an customer with that id already
		// select * from Customer where id = ?
		// if rs size == 0
		// insert into Customer table
		// else
		// update the customer

		return customer;
	}

}
