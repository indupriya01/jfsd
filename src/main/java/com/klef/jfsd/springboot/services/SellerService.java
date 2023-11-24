package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Seller;

public interface SellerService {
	 public List<Seller>viewallsellers();
	public String addseller(Seller seller );
	public Seller checksellerlogin(String email,String pwd);
	
}
