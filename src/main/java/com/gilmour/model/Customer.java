package com.gilmour.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * WARNING
 *
 * 1- JERSEY CONVERTS POJO to XML using JAXB
 * 2- Then XML transformed into JSON !!!
 *
 * XML Annotations affects JSON output
 *
 */

@XmlRootElement
public class Customer {

	private String email;
	private String password;
	private CustomerHelperObject customerHelperObject;

	@XmlElement(name = "user-mail")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerHelperObject getCustomerHelperObject() {
		return customerHelperObject;
	}

	public void setCustomerHelperObject(CustomerHelperObject customerHelperObject) {
		this.customerHelperObject = customerHelperObject;
	}
}
