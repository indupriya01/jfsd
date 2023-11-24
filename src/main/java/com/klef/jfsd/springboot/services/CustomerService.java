package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.model.Customer;

public interface CustomerService 
{
	  public List<Customer>viewallcus();
	public String addcustomer(Customer customer );
	public Customer checkcustomerlogin(String email,String pwd);
}
