package com.gilmour;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.gilmour.model.Customer;
import com.gilmour.repository.CustomerRepository;
import com.gilmour.repository.CustomerRepositoryStub;

/**
 * Created by alicana on 15/02/2017.
 */

@Path("search/customers")
public class CustomerSearchResource {

	private CustomerRepository customerRepository = new CustomerRepositoryStub();

	@GET
	@Produces({ "application/json", "application/xml" })
	public Response searchCustomers(@QueryParam(value = "description") List<String> descriptions) {
		System.out.println(descriptions);

		List<Customer> customers = customerRepository.findByDescription(descriptions);

		if (customers == null || customers.size() <= 0) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.ok().entity(new GenericEntity<List<Customer>>(customers) {
		}).build();
	}

}
