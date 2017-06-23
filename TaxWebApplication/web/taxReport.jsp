<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v3.8.4, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" href="assets/images/logo.png" type="image/x-icon">
  <meta name="description" content="">
  
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic&amp;subset=latin">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
  <link rel="stylesheet" href="assets/et-line-font-plugin/style.css">
  <link rel="stylesheet" href="assets/bootstrap-material-design-font/css/material.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/socicon/css/socicon.min.css">
  <link rel="stylesheet" href="assets/animate.css/animate.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
</head>
<body>
<section id="menu-1">

    <nav class="navbar navbar-dropdown bg-color navbar-fixed-top">
       
        <div class="container">

            <div class="mbr-table">
                <div class="mbr-table-cell">

                    <div class="navbar-brand">
                        
                        <a class="navbar-caption" href="#">TAX CALCULATOR</a>
                    </div>

                </div>
                <div class="mbr-table-cell">

                    <button class="navbar-toggler pull-xs-right hidden-md-up" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
                        <div class="hamburger-icon"></div>
                    </button>

                    <ul class="nav-dropdown collapse pull-xs-right nav navbar-nav navbar-toggleable-sm" id="exCollapsingNavbar"><li class="nav-item"><a class="nav-link link" href="index.html">HOME</a></li><li class="nav-item"><a class="nav-link link" href="taxCalculator.html">CALCULATE TAX</a></li><li class="nav-item"><a class="nav-link link" href="TaxRates.html">TAX RATES</a></li></ul>
                    <button hidden="" class="navbar-toggler navbar-close" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
                        <div class="close-icon"></div>
                    </button>

                </div>
            </div>

        </div>
    </nav>

</section>

<section class="engine"><a rel="external" href="https://mobirise.com">easy wysiwyg web page builder</a></section><section class="mbr-section mbr-parallax-background mbr-after-navbar" id="msg-box3-a" style="background-image: url(assets/images/tax-468440-1920-2000x1333-30.jpg); padding-top: 120px; padding-bottom: 120px;">

    <div class="mbr-overlay" style="opacity: 0.5; background-color: rgb(34, 34, 34);">
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2 text-xs-center">
                <h3 style="color:#fff" class="mbr-section-title text-xs-center display-2">TAX REPORT</h3>
                <div class="lead">
				 <table  style="color:#fff; padding-left:30px" width="500" height="50" align="center">
                    <tr>
                        <th scope="col">    </th>
                        <th scope="col">MONTHLY</th>
                        <th scope="col">ANNUALLY</th>
                    </tr>
		   <%
                        double annualPay =(Double)request.getAttribute("annualPay");
                        double monthlypay = (Double)request.getAttribute("monthlyPay");
                        
                        double annualTax =(Double)request.getAttribute("annualTax");
                        double monthlyTax = (Double)request.getAttribute("monthlyTax");
                        
                        double annualPayAfter =(Double)request.getAttribute("annualPayAfter");
                        double monthlyPayAfter = (Double)request.getAttribute("monthlyPayAfter");
                        
                        double netCashMonthly =(Double)request.getAttribute("netCashMonthly");
                        double netCashAnnually = (Double)request.getAttribute("netCashAnnually");
                        
                        DecimalFormat df = new DecimalFormat("#.##");
                        
                        
                    %>
                    <tr>
                        <th scope="col"> PAYE BEFORE TAX </th>
                        <th  style= "padding-left:12px"scope="col"><%=df.format(monthlypay)%></th>
                        <th style= "padding-left:12px" scope="col"><%= df.format(annualPay)%></th>
                    </tr>
					<tr>
                        <th scope="col"> PAYABLE TAX</th>
                        <th  style= "padding-left:12px"scope="col"><%=df.format(monthlyTax)%></th>
                        <th style= "padding-left:12px" scope="col"><%=df.format(annualTax)%></th>
                    </tr>
					<tr>
                        <th scope="col"> PAYE AFTER TAX </th>
                        <th  style= "padding-left:12px"scope="col"><%=df.format(monthlyPayAfter)%></th>
                        <th style= "padding-left:12px" scope="col"><%=df.format(annualPayAfter)%></th>
                    </tr>
					<tr>
                        <th scope="col"> NET INCOME </th>
                        <th  style= "padding-left:12px"scope="col"> <%=df.format(netCashMonthly)%></th>
                        <th style= "padding-left:12px" scope="col"><%=df.format(netCashAnnually)%></th>
                    </tr>
		    <%
                        
                    %>
                </table>
				</div>
            </div>
        </div>
    </div>
	<div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2 text-xs-center">
                <h3 class="mbr-section-title display-2"></h3>
                <div><a class="btn btn-secondary" href="taxCalculator.html">CALCULATE AGAIN</a> <a class="btn btn-secondary" href="TaxRates.html">TAX TABLES</a></div>
            </div>
        </div>
    </div>

</section>

<section class="mbr-section mbr-section-md-padding mbr-footer footer1" id="contacts1-c" style="background-color: rgb(41, 105, 176); padding-top: 90px; padding-bottom: 90px;">
    
    <div class="container">
        <div class="row">
            <div class="mbr-footer-content col-xs-12 col-md-3">
                
            </div>
            <div class="mbr-footer-content col-xs-12 col-md-3">
                <p><strong>Address</strong><br>
8 Santorini<br>
374 Justice Mohammed Street<br>
Pretoria, 0002</p>
            </div>
            <div class="mbr-footer-content col-xs-12 col-md-3">
                <p><strong>Contacts</strong><br>
Email: thusopuding@gmail.com<br>
Phone: +27 (0) 73 580 6143<br>
Fax: +27 (0) 11 465 6102 </p>
            </div>
            <div class="mbr-footer-content col-xs-12 col-md-3">
                <p><strong>Links</strong><br>
<a class="text-primary" href="https://linkedin.com\Thuso-Puding/">LinkedIn</a><br>
<a class="text-primary" href="https://facebook.com">Facebook</a><br>
<a class="text-primary" href="https://twitter.com">Twitter</a></p>
            </div>

        </div>
    </div>
</section>

<footer class="mbr-small-footer mbr-section mbr-section-nopadding" id="footer1-6" style="background-color: rgb(61, 142, 185); padding-top: 1.75rem; padding-bottom: 1.75rem;">
    
    <div class="container">
        <p class="text-xs-center">Copyrights 2017 | All rights reserved. | property of LabourNet by Thuso Puding</p>
    </div>
</footer>


  <script src="assets/web/assets/jquery/jquery.min.js"></script>
  <script src="assets/tether/tether.min.js"></script>
  <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  <script src="assets/smooth-scroll/SmoothScroll.js"></script>
  <script src="assets/viewportChecker/jquery.viewportchecker.js"></script>
  <script src="assets/dropdown/js/script.min.js"></script>
  <script src="assets/touchSwipe/jquery.touchSwipe.min.js"></script>
  <script src="assets/jarallax/jarallax.js"></script>
  <script src="assets/theme/js/script.js"></script>
  
  
  <input name="animation" type="hidden">
  </body>
</html>