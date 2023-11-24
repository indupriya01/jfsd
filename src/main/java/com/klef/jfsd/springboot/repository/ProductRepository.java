package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.klef.jfsd.springboot.model.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> 
{
	 @Query("from Product p where p.cost >= :minCost and p.cost <= :maxCost")
	List<Product> viewproductsbycost(double minCost, double maxCost);
 	
}
