<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>HAVA DURUMU 2017</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicons -->
    <link href="img/favicon.png" rel="icon">
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">

    <!-- Bootstrap CSS File -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Libraries CSS Files -->
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">

    <!-- Main Stylesheet File -->
    <link href="css/style.css" rel="stylesheet">

    <!-- =======================================================
      Theme Name: Regna
      Theme URL: https://bootstrapmade.com/regna-bootstrap-onepage-template/
      Author: BootstrapMade.com
      License: https://bootstrapmade.com/license/
    ======================================================= -->
</head>

<body>

<!--==========================
Header
============================-->
<header id="header">
    <div class="container">




    </div>

</header><!-- #header -->





<!--==========================


<!--==========================
  Facts Section
============================-->
<section id="hero">
    <c:forEach var="tempHavaDurumu" items="${havaDurumuListesi}">
    <div class="container wow fadeIn">

        <div class="section-header">
            <h6 class="section-title"></h6>
            <p class="section-description"></p>
        </div>


        <div class="section-header">
            <h6 class="section-title">${tempHavaDurumu.sehir}</h6>
            <p class="section-description">Verinin son guncellendigi tarih : ${tempHavaDurumu.zaman} </p>
        </div>

        <div class="row counters">

            <div class="col-lg-3 col-6 text-center">
                <span  style="font-weight:bold ">${tempHavaDurumu.durum}</span>
                <p style="font-weight:bold ">GOKYUZU</p>
            </div>

            <div class="col-lg-3 col-6 text-center">
                <span data-toggle="counter-up" style="font-weight:bold ">${tempHavaDurumu.sicaklik}</span>
                <p style="font-weight:bold ">SICAKLIK(Celsius)</p>
            </div>

            <div class="col-lg-3 col-6 text-center">
                <span data-toggle="counter-up" style="font-weight:bold ">${tempHavaDurumu.basinc}</span>
                <p style="font-weight:bold ">BASINC(mb)</p>
            </div>

            <div class="col-lg-3 col-6 text-center">
                <span data-toggle="counter-up" style="font-weight:bold ">${tempHavaDurumu.nem_orani}</span>
                <p style="font-weight:bold " >NEM ORANI(%)</p>
                <br>

            </div>



        </div>

    </div>
    </c:forEach>

        <a href="anasayfaOffline.html" class="btn-get-started" >Tekrar Arama Yap</a>

</section><!-- #facts -->



<!--==========================









<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="lib/jquery/jquery.min.js"></script>
<script src="lib/jquery/jquery-migrate.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8HeI8o-c1NppZA-92oYlXakhDPYR7XMY"></script>

<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/counterup/counterup.min.js"></script>
<script src="lib/superfish/hoverIntent.js"></script>
<script src="lib/superfish/superfish.min.js"></script>

<!-- Contact Form JavaScript File -->
<script src="contactform/contactform.js"></script>

<!-- Template Main Javascript File -->
<script src="js/main.js"></script>

</body>
</html>

