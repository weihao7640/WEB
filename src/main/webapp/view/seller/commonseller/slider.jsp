<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
	<script src="js/app.min.js"></script>
	<link href="css/app.min.css" rel="stylesheet">
<div class="side-nav">
    <div class="side-nav-inner">
        <ul class="side-nav-menu scrollable">
            <li class="nav-item ">
                <a class="dropdown-toggle" href="./homeseller?storeid=${stid}" >
                    <span class="icon-holder">
                       <ion-icon name="bar-chart-outline"></ion-icon>
                    </span>
                    <span class="title">Trang chủ</span>
                </a>
            </li>
            <li class="nav-item ">
                <a class="dropdown-toggle" href="donhangseller">
                    <span class="icon-holder">
                       <ion-icon name="calendar-outline"></ion-icon>
                    </span>
                    <span class="title">Quản lý đơn hàng</span>

                </a>
            </li>
            <li class="nav-item ">
                <a class="dropdown-toggle" href="sanpham" >
                    <span class="icon-holder">
                       <ion-icon name="cube-outline"></ion-icon>
                    </span>
                    <span class="title">Quản lý sản phẩm</span>
                </a>
            </li>
            <li class="nav-item ">
                <a class="dropdown-toggle" href="khachhang">
                    <span class="icon-holder">
                        <ion-icon name="person-outline"></ion-icon>
                    </span>
                    <span class="title">Quản lý khách hàng</span>
                </a>
            </li>
            <li class="nav-item ">
                <a class="dropdown-toggle" href="nhanvien">
                    <span class="icon-holder">
                        <i class="fas fa-shipping-fast"></i>
                    </span>
                    <span class="title">Quản lý Shipper</span>
                </a>
            </li>
          
        </ul>
    </div>
</div>
