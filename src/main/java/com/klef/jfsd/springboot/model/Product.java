package com.klef.jfsd.springboot.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_table")
public class Product 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false,length = 100)
  private String name;
  @Column(nullable = false)
  private double cost;
  @Column(nullable = false,length = 1000)
  private String description;
  private Blob productimage; // blob - binary large object
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Blob getProductimage() {
	return productimage;
}
public void setProductimage(Blob productimage) {
	this.productimage = productimage;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", description=" + description
			+ ", productimage=" + productimage + "]";
}

}