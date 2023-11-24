package com.klef.jfsd.springboot.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Product;
import com.klef.jfsd.springboot.model.Seller;
import com.klef.jfsd.springboot.services.AdminService;
import com.klef.jfsd.springboot.services.CustomerService;
import com.klef.jfsd.springboot.services.EmailService;
import com.klef.jfsd.springboot.services.ProductService;
import com.klef.jfsd.springboot.services.SellerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController
{ 
	@Autowired
	private ProductService productService;
	@Autowired
	private AdminService adminService;
	@Autowired
	 private EmailService emailService;

	@Autowired 
	private SellerService sellerService;

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	  public String main()
	  {
		  return "index";
	  }
	
	@GetMapping("adminlogin")  
	 public ModelAndView adminlogin()
	 {
	   ModelAndView mv = new ModelAndView();
	   mv.setViewName("adminlogin");
	   return mv;
	 }
	
	 
	 @PostMapping("checkadminlogin")
	 public ModelAndView checkadminlogin(HttpServletRequest request) {
	  
	  
	  ModelAndView mv = new ModelAndView();
	  
	  
	  
	  String uname = request.getParameter("uname");
	  String pwd = request.getParameter("pwd");
	  
	  Admin a  = adminService.checkadminlogin(uname, pwd);
	  
	  if(a!=null) {
	   mv.setViewName("adminhome");
	   
	  }
	  
	  else {  
	   
	   mv.setViewName("adminlogin");
	   mv.addObject("message","Login Failed");
	  }
	  
	  return mv;
	  
	 }
	 @GetMapping("customerlogin") // URI (Uniform Resource identifier) & Method Name
		public ModelAndView customerlogin() {
			ModelAndView mv= new ModelAndView();
			mv.setViewName("customerlogin");
			return mv;
		}
@GetMapping("sellerlogin")
public ModelAndView sellerlogin()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("sellerlogin");
	return mv;
}
		@PostMapping("checksellerlogin")
		public ModelAndView checksellerlogin(HttpServletRequest request) {
			
	ModelAndView mv = new ModelAndView();
			
			String email = request.getParameter("email");
		     String pwd = request.getParameter("password");
		     
		   Seller  s =  sellerService. checksellerlogin(email, pwd);
		    
		    //very imp
		    if(s!=null)
		    {
		    	
		      // session
		    	HttpSession session= request.getSession();
		    	
		    	session.setAttribute("eid", s.getId()); // eid is a session variable 
		    	session.setAttribute("ename", s.getName()); // ename is a session variable 
		    	
		    	//session
		    	mv.setViewName("sellerhome");
		    }
		    else
		    {
		      mv.setViewName("login");
		      mv.addObject("message", "Login Failed");
		    }
		    return mv;                                                                                                               
		}
		
		@GetMapping("sellerregistration")
		public ModelAndView sellerregistration() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("sellerregistration");
			return mv;
			                                                                                          
		}
		
		@PostMapping("insertseller")
		public ModelAndView insertseller(HttpServletRequest request) {
			
			
			ModelAndView mv = new ModelAndView();
			String msg = null;
			
			
			
			try {
				String name = request.getParameter("name");
			    String pwd = request.getParameter("password");
			    String email = request.getParameter("email");
			   
			    
			    
			   Seller c = new Seller();
			   
			    c.setName(name);
			    c.setPassword(pwd);
			    c.setEmail(email);
			    
			      msg=sellerService.addseller(c);
			     // emailService.sendEmail(c.getEmail(),"Demo mail","Hi we are testing");
			    mv.setViewName("sellerlogin");
			    mv.addObject("message", msg);
			    
			}
			catch(Exception e){
				
				msg=e.getMessage();
				
			    mv.setViewName("displayerror");
				mv.addObject("message", msg);
			}
			
			return mv;
		}
		@PostMapping("checkcustomerlogin")
		public ModelAndView checkcustomerlogin(HttpServletRequest request) {
			
			ModelAndView mv = new ModelAndView();
			
			String email = request.getParameter("email");
		     String pwd = request.getParameter("password");
		     
		    Customer  cus =  customerService.checkcustomerlogin(email, pwd);
		    
		    //very imp
		    if(cus!=null)
		    {
		    	
		      // session
		    	HttpSession session= request.getSession();
		    	
		    	session.setAttribute("eid", cus.getId()); // eid is a session variable 
		    	session.setAttribute("ename", cus.getName()); // ename is a session variable 
		    	
		    	//session
		    	mv.setViewName("aftergallary");
		    }
		    else
		    {
		      mv.setViewName("login");
		      mv.addObject("message", "Login Failed");
		    }
		    return mv;                                                                                                               
		}
		
		@GetMapping("registration")
		public ModelAndView empregistration() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("registration");
			return mv;
		}
		
		@PostMapping("insertcustomer")
		public ModelAndView insertcustomer(HttpServletRequest request) {
			
			
			ModelAndView mv = new ModelAndView();
			String msg = null;
			
			
			
			try {
				String name = request.getParameter("name");
			    String pwd = request.getParameter("password");
			    String email = request.getParameter("email");
			   
			    
			    
			   Customer c = new Customer();
			   
			    c.setName(name);
			    c.setPassword(pwd);
			    c.setEmail(email);
			    
			      msg=customerService.addcustomer(c);
			     // emailService.sendEmail(c.getEmail(),"Demo mail","Hi we are testing");
			    mv.setViewName("index");
			    mv.addObject("message", msg);
			    
			}
			catch(Exception e){
				
				msg=e.getMessage();
				
			    mv.setViewName("displayerror");
				mv.addObject("message", msg);
			}
			
			return mv;
		}
		@GetMapping("viewallcus")
		public ModelAndView viewallcus()
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("viewallcus");
			List<Customer>  customerlist=customerService.viewallcus();
			mv.addObject("customerdata",customerlist);
			return mv;
		}
		
		  @GetMapping("addproduct")
		   public ModelAndView addproductdemo()
		   {
			   ModelAndView mv = new ModelAndView("addproduct");
			   return mv;
		   }
		  
		  @GetMapping("displaycategory")
		   public ModelAndView displaypcategorydemo()
		   {
			   ModelAndView mv=new ModelAndView("displaycategory");
			   return mv;
		   }
		  
		  @PostMapping("insertproduct")
		   public ModelAndView insertproductdemo(HttpServletRequest request,@RequestParam("productimage") MultipartFile file) throws IOException, SerialException, SQLException
		   {
			   String msg = null;
			   
			   ModelAndView mv = new ModelAndView();
			   
			   try
			   {
			   String name = request.getParameter("name");
			   Double cost = Double.valueOf(request.getParameter("cost"));
			   String description = request.getParameter("description");
		
			   
				  byte[] bytes = file.getBytes();
				  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
				  
				  Product p = new Product();
				  p.setName(name);
				  p.setCost(cost);
				  p.setDescription(description);
				  p.setProductimage(blob);
				  msg=productService.AddProduct(p);
				  System.out.println(msg);
				  mv.setViewName("productmsg");
				  mv.addObject("message",msg);
			   }	  
			   catch(Exception e)
			   {
				   msg = e.getMessage();
				   System.out.println(msg.toString());
				   mv.setViewName("producterror");
				   mv.addObject("message",msg);
			   }
			   return mv;
		   }
		  @GetMapping("viewallprods")
		   public ModelAndView viewallprodsdemo()
		   {
			   List<Product> productlist = productService.ViewAllProducts();
			   
			   ModelAndView mv = new ModelAndView("viewallproducts");
			   
			   mv.addObject("productlist", productlist);
			   
			   return mv;
		   }
		  @GetMapping("aftergallary")
		   public ModelAndView aftergallary()
		   {
			   List<Product> productlist = productService.ViewAllProducts();
			   
			   ModelAndView mv = new ModelAndView("aftergallary");
			   
			   mv.addObject("productlist", productlist);
			   
			   return mv;
		   }
		  @GetMapping("viewallemps")
		   public ModelAndView viewallemps()
		   {
			   List<Product> productlist = productService.ViewAllProducts();
			   
			   ModelAndView mv = new ModelAndView("viewallemps");
			   
			   mv.addObject("productlist", productlist);
			   
			   return mv;
		   }
		  @GetMapping("displayprodimage")
		  public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("id") int id) throws IOException, SQLException
		  {
		    Product product =  productService.ViewProductByID(id);
		    byte [] imageBytes = null;
		    imageBytes = product.getProductimage().getBytes(1,(int) product.getProductimage().length());
		    return ResponseEntity.ok().contentType(org.springframework.http.MediaType.IMAGE_JPEG).body(imageBytes);
		  }
		  @PostMapping("displayproduct")
		   public ModelAndView displayproductdemo(HttpServletRequest request)
		   {
			   int pid=Integer.parseInt(request.getParameter("pid"));
			   Product product=productService.ViewProductByID(pid);
			   ModelAndView mv=new ModelAndView("displayproduct");
			   mv.addObject("product",product);
			   return mv;
		   }
		  @GetMapping("viewallsellers")
			public ModelAndView viewallsellers()
			{
				ModelAndView mv=new ModelAndView();
				mv.setViewName("viewallseller");
				List<Seller>  sellerlist=sellerService.viewallsellers();
				mv.addObject("sellerdata",sellerlist);
				return mv;
			}
		  
		  @PostMapping("viewproductsbycost")
		  public ModelAndView viewproductsbycost(HttpServletRequest request) {
		      double minCost = Double.parseDouble(request.getParameter("minCost"));
		      double maxCost = Double.parseDouble(request.getParameter("maxCost"));
		      List<Product> productlist = productService.viewproductsbycost(minCost, maxCost);
		      
		      ModelAndView mv = new ModelAndView("viewproductsbycost");
		      mv.addObject("productlist", productlist);
		      return mv;
		  }

		   
}







 
