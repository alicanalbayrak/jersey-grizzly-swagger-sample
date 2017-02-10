package com.gilmour;

import java.util.List;

import com.gilmour.client.CustomerClient;
import com.gilmour.model.Customer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

/**
 * Created by alicana on 10/02/2017.
 */
public class CustomerClientTest {

	@Test
	public void testGet() throws Exception {
		CustomerClient client = new CustomerClient();

		Customer customer = client.get("1234");

		System.out.println(customer);
		assertNotNull(customer);

	}

	@Test
	public void testGetList() {
		CustomerClient client = new CustomerClient();
		List<Customer> customers = client.get();
		assertNotNull(customers);

	}

	@Test(expected = RuntimeException.class)
	public void testGetWithBadRequest() {
		CustomerClient client = new CustomerClient();
		client.get("123");
	}

	@Test
	public void postTest() {

		CustomerClient client = new CustomerClient();

		Customer customer = new Customer();
		customer.setEmail("foo@bar.com");
		customer.setPassword("asdf");

		customer = client.create(customer);
	}

}