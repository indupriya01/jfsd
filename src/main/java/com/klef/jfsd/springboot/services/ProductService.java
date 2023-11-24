package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.klef.jfsd.springboot.model.Product;

public interface ProductService {
	   public String AddProduct(Product product) ;
	   public List<Product> ViewAllProducts();
	   public Product ViewProductByID(int productid);
	   public List<Product>viewproductsbycost( @Param("minCost") double minCost, @Param("maxCost") double maxCost);
}
