package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Seller;
import com.klef.jfsd.springboot.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService
 {
	  @Autowired
	  private SellerRepository sellerRepository;

	@Override
	public String addseller(Seller seller) {
		sellerRepository.save(seller);
		return "Registrartion Successfull";
	}

	@Override
	public Seller checksellerlogin(String email, String pwd) {

		return sellerRepository.checksellerlogin(email, pwd);
	}
 
	@Override
	public List<Seller> viewallsellers() {
		return sellerRepository.findAll();	
	}
	 

}
