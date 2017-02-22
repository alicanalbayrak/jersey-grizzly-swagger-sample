package com.gilmour.model;

import java.util.List;

/**
 * Created by alicana on 22/02/2017.
 */
public class CustomerSearch {

	private int age;
	private List<String> descriptions;

	private CustomerSearchType customerSearchType;

	public CustomerSearchType getCustomerSearchType() {
		return customerSearchType;
	}

	public void setCustomerSearchType(CustomerSearchType customerSearchType) {
		this.customerSearchType = customerSearchType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}
}
