package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="seller_table")
public class Seller {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seller_id")
    private int id;
	
    @Column(name="seller_name",nullable=false,length = 50)
    private String name;
    
    @Column(name="seller_password",nullable=false,length = 30)
    private String password;
    
    @Column(name="seller_email",nullable=true,unique = true,length = 30)
    private String email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
