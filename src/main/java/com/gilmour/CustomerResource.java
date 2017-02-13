package com.gilmour;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.gilmour.model.Customer;
import com.gilmour.model.CustomerHelperObject;
import com.gilmour.repository.CustomerRepository;
import com.gilmour.repository.CustomerRepositoryStub;

@Path("customers")
public class CustomerResource {

	/**
	 * 1- JERSEY CONVERTS POJO to XML using JAXB 2- Then XML transformed into JSON !!!
	 */

	private CustomerRepository customerRepository = new CustomerRepositoryStub();

	@POST
	@Path("customer")
	@Consumes("application/json")
	@Produces({ "application/json", "application/xml" })
	public Customer createCustomer(Customer customer) {

		System.out.println(customer.getEmail());
		System.out.println(customer.getPassword());

		customerRepository.create(customer);

		return customer;
	}

	@POST
	@Path("customer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ "application/xml", "application/json" })
	public Customer createCustomer(MultivaluedMap<String, String> formParams) {
		System.out.println(formParams.getFirst("par1"));
		System.out.println(formParams.getFirst("par2"));

		Customer customer = new Customer();
		customer.setEmail(formParams.getFirst("par1"));
		customer.setPassword(formParams.getFirst("par2"));

		customerRepository.create(customer);

		return customer;
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public List<Customer> getAllCustomers() {
		return customerRepository.findAllCustomers();
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("{customerId}")
	public Response getCustomer(@PathParam("customerId") String customerId) {

		System.out.println("get customer");

		if (customerId == null || customerId.length() < 4) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		System.out.println("getting customer id " + customerId);

		Customer customer = customerRepository.findCustomer(customerId);

		if (customer == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		return Response.ok().entity(customer).build();

		//		return customerRepository.findCustomer(customerId);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("{customerId}/helper")
	public CustomerHelperObject getCustomerObject(@PathParam("customerId") String customerId) {
		Customer customer = customerRepository.findCustomerObject(customerId);
		return customer.getCustomerHelperObject();
	}

	@PUT
	@Path("{customer}")
	@Consumes("application/json")
	@Produces({ "application/json", "application/xml" })
	public Response update(Customer customer) {

		System.out.println(customer.getId());

		customer = customerRepository.update(customer);

		return Response.ok().entity(customer).build();

	}

}
