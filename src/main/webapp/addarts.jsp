<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Basic -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Site Metas -->
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>ArtGallary</title>

    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

    <!-- fonts style -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
    <!-- owl slider stylesheet -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
    <!-- nice select -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
        integrity="sha256-mLBIhmBvigTFWPSCtvdu6a76T+3Xyt+K571hupeFLg4=" crossorigin="anonymous" />
    <!-- font awesome style -->
    <link href="css/font-awesome.min.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet" />
</head>

<body>
    <div class="hero_area">
        <!-- header section starts -->
        <header class="header_section">
            <div class="header_top">
                <div class="container-fluid header_top_container">
                    <a class="navbar-brand " href="index.jsp"> Art<span>Gallary</span> </a>
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
                        <a class="navbar-brand navbar_brand_mobile" href="index.jsp"> Art<span>Gallary</span> </a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  ">
                                <li class="nav-item active">
                                    <a class="nav-link" href="adminhome.jsp">Home <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="addarts.jsp">Add Arts</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="viewallemps">View Artists</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="viewallcus">View Customers</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="viewallprods">View Collection</a>
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
        
         <body>
        <div class="container">
            <form action="insertproduct" method="post" enctype="multipart/form-data">
                <label for="productName">Artist Name:</label>
                <input type="text" id="productName" name="name" required>

                <label for="productPrice">Art Price:</label>
                <input type="number" id="productPrice" name="cost" min="0.01" step="0.01" required>

                <label for="productDescription">Art Description:</label>
                <textarea id="productDescription" name="description" rows="4" required></textarea>

                <div class="image-upload">
                    <label for="productImage">Art Image:</label>
                    <input type="file" id="productImage" name="productimage" accept="image/*" required>
                    <img id="imagePreview" class="image-preview" src="#" alt="Image Preview">
                </div>

                <button type="submit">Add Product</button>
            </form>
        </div>
        <script>
            const imageInput = document.getElementById("productImage");
            const imagePreview = document.getElementById("imagePreview");

            imageInput.addEventListener("change", function(event) {
                const file = event.target.files[0];
                if (file) {
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        imagePreview.src = e.target.result;
                    };
                    reader.readAsDataURL(file);
                }
            });
        </script>
    </body>
        
    </div>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Products</title>
        <style>

            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            header {
                background-color: #333;
                color: #fff;
                text-align: center;
                padding: 10px;
            }

            .container {
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
                backdrop-filter: blur(10px);
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
            }

            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }

            input[type="text"],
            input[type="number"],
            textarea {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            textarea {
                resize: vertical;
            }

            button {
                background-color: #333;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 3px;
                cursor: pointer;
            }

            button:hover {
                background-color: #555;
            }

            .image-upload {
                margin-top: 10px;
            }

            .image-preview {
                display: block;
                max-width: 100%;
                margin-top: 10px;
            }
        </style>
    </head>

    

</html>
