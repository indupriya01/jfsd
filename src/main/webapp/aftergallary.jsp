<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ArtGallary</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha256-mLBIhmBvigTFWPSCtvdu6a76T+3Xyt+K571hupeFLg4=" crossorigin="anonymous" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet" />
    <link href="css/responsive.css" rel="stylesheet" />
  </head>
<style>
        .product-card {
            border: 2px solid black;
            padding: 20px;
            width: 250px;
            margin: 10px;
            text-align: center;
             background-color: #ffffff; /* Set background color to white */
            
        }

        .product-image {
            width: 100%;
            height: auto;
            margin-bottom: 10px;
        }
    </style>

  <body class="sub_page">
    <div class="hero_area">
      <header class="header_section">
        <div class="header_top">
          <div class="container-fluid header_top_container">
            <a class="navbar-brand " href="index.html"> Art<span>Gallary</span> </a>
            <div class="contact_nav">
               <a href="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7653.328801688457!2d80.61320178375155!3d16.441862015890553!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3a35f0a2a073957d%3A0xe79d66babc83e470!2sK%20L%20UNIVERSITY%2C%20Vaddeswaram%2C%20Andhra%20Pradesh%20522303!5e0!3m2!1sen!2sin!4v1699145953246!5m2!1sen!2sin" target="iframe_target">
              <i class="fa fa-map-marker" aria-hidden="true"></i>
              <span>
                Location
              </span>
            </a>
              <a href="">
                <i class="fa fa-phone" aria-hidden="true"></i>
                <span>
                  Call : +91 9989469456
                </span>
              </a>
              <a href="">
                <i class="fa fa-envelope" aria-hidden="true"></i>
                <span>
                  artgallary@gmail.com
                </span>
              </a>
            </div>
            <div class="social_box">
              <a href="">
                <i class="fa fa-facebook" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-twitter" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-linkedin" aria-hidden="true"></i>
              </a>
              <a href="">
                <i class="fa fa-instagram" aria-hidden="true"></i>
              </a>
            </div>
          </div>
        </div>
        <div class="header_bottom">
          <div class="container-fluid">
            <nav class="navbar navbar-expand-lg custom_nav-container ">
              <a class="navbar-brand navbar_brand_mobile" href="index.html"> Art<span>Gallary</span> </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class=""> </span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav  ">
                  <li class="nav-item ">
                  <a class="nav-link" href="customerhome.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="service.jsp">Services</a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="about.jsp"> About</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="aftergallary.jsp">Gallary</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="contact.jsp">Contact Us</a>
                </li>
                
                  <form class="form-inline">
                    <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
                      <i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                  </form>
                </ul>
              </div>
            </nav>
          </div>
        </div>
      </header>
    </div>

<body>

<li class="nav-item">
                  <a class="nav-link" href="displaybycost.jsp"> Filter</a>
                </li>


        <div class="row" id="productCards">
            <c:forEach items="${productlist}" var="product">
                <div class="col-lg-4 col-md-6">
                    <div class="product-card">
                        <img class="product-image" src='displayprodimage?id=${product.id}' alt="Product Image">
                        <h5>ID: <c:out value="${product.id}" /></h5>
                        <h5>Name: <c:out value="${product.name}" /></h5>
                        <h5>Cost: <c:out value="${product.cost}" /></h5>
                        <h5>Description: <c:out value="${product.description}" /></h5>
                        
                    <input type="hidden" name="productId" value="${product.id}" />
                    <button type="submit" class="btn btn-primary" href=".#">Add to Cart</button>
               
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>

</html>
