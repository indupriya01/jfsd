package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;

public interface AdminService {
  public Admin checkadminlogin(String auname,String apwd);

}