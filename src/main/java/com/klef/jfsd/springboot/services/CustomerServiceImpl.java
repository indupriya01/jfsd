package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addcustomer(Customer customer)
	{
		customerRepository.save(customer);
		return "Registrartion Successfull";
	}

	@Override
	public Customer checkcustomerlogin(String email, String pwd) 
	{
		return customerRepository.checkcustomerlogin(email, pwd);
	}

	@Override
	public List<Customer> viewallcus() {
		return customerRepository.findAll();	
	}

}
