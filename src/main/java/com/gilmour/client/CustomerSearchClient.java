package com.gilmour.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.gilmour.model.Customer;

/**
 * Created by alicana on 15/02/2017.
 */
public class CustomerSearchClient {


	private Client client;

	public CustomerSearchClient() {
		this.client = ClientBuilder.newClient();
	}

	public List<Customer> search(String param, List<String> searchValues){

		URI uri = UriBuilder.fromUri("http://localhost:8080/myapp/")
				.path("search/customers")
				.queryParam(param, searchValues)
				.build();

		WebTarget target = client.target(uri);

		List<Customer> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Customer>>() {});

		System.out.println(response);

		return response;
	}

}
