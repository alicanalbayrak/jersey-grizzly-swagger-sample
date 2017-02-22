package com.gilmour.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.gilmour.model.Customer;
import com.gilmour.model.CustomerSearch;

/**
 * Created by alicana on 15/02/2017.
 */
public class CustomerSearchClient {

	private Client client;

	public CustomerSearchClient() {
		this.client = ClientBuilder.newClient();
	}

	public List<Customer> search(String param, List<String> searchValues) {

		URI uri = UriBuilder.fromUri("http://localhost:8080/myapp/").path("search/customers").queryParam(param, searchValues).build();

		WebTarget target = client.target(uri);

		List<Customer> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Customer>>() {
		});

		System.out.println(response);

		return response;
	}

	public List<Customer> search(CustomerSearch search) {

		URI uri = UriBuilder.fromUri("http://localhost:8080/myapp/").path("search/customers").build();

		WebTarget target = client.target(uri);

		// POST
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(search, MediaType.APPLICATION_JSON));

		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " there was an error on the server");
		}

		return response.readEntity(new GenericType<List<Customer>>() {
		});
	}
}
