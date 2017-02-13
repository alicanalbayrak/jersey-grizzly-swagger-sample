package com.gilmour.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gilmour.model.Customer;

public class CustomerClient {

	private Client client;

	public CustomerClient() {

		client = ClientBuilder.newClient();
	}

	public Customer get(String id) {

		WebTarget target = client.target("http://localhost:8080/myapp/");

		// XML request
		//		Customer response = target.path("customers/" + id).request().get(Customer.class);
		String jsonString = target.path("customers/" + id).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

		System.out.println(jsonString);

		//		Customer response = target.path("customers/" + id).request(MediaType.APPLICATION_JSON_TYPE).get(Customer.class);

		Response response = target.path("customers/" + id).request(MediaType.APPLICATION_JSON_TYPE).get(Response.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(Customer.class);
	}

	public List<Customer> get() {
		WebTarget target = client.target("http://localhost:8080/myapp/");
		List<Customer> response = target.path("customers").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Customer>>() {
		});

		return response;

	}

	public Customer create(Customer customer) {
		WebTarget target = client.target("http://localhost:8080/myapp/");

		Response response = target.path("customers/customer").request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(customer, MediaType.APPLICATION_JSON_TYPE));

		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(Customer.class);
	}


	public Customer update(Customer customer) {
		WebTarget target = client.target("http://localhost:8080/myapp/");

		Response response = target.path("customers/" + customer.getId()).request(MediaType.APPLICATION_JSON_TYPE).put(Entity.entity(customer, MediaType.APPLICATION_JSON_TYPE));

		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}

		return response.readEntity(Customer.class);
	}
}
