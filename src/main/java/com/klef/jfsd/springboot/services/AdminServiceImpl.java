package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
  
  @Autowired
  private AdminRepository adminRepository;
  @Override
  public Admin checkadminlogin(String auname, String apwd) {
    
    return adminRepository.checkadminlogin(auname, apwd);
  }


}