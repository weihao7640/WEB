<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="nav-item">
	<div class="tren">
		<img src="image/logo.webp" alt="">
	</div>
	<ul class="duoi">
		<li><a href="home">Trang Chủ</a></li>
		<li><a href="">Giới thiệu</a></li>
		<li><a href=""> Sản phẩm</a>
			<ul class="subnav">
				<li><a href="">Trái cây</a></li>
			</ul></li>
		<li><a href="">Tin Tức</a></li>
		<li><a href="">Liên Hệ</a></li>
		<li><a href="">Bản Đồ </a></li>
	</ul>
	<ul class="icon-menu">
		<li><a href=""><ion-icon name="heart"></ion-icon></a></li>
		<li><a href=""><ion-icon name="person"></ion-icon></a>
			<ul class="sub_language">
			<c:if test="${not empty id}">
				<li><a href="ChiTietND">Tài Khoản</a></li>
				<li><a href="dangxuat">Đăng xuất</a></li>
			</c:if>
			<c:if test="${empty id}">
			<li><a href="login">Đăng nhập</a></li>
				<li><a href="dangky">Đăng ký</a></li>
			</c:if>
				
			</ul></li>
		<li><a href="viewGH"><ion-icon name="cart"></ion-icon></a></li>
	</ul>
</div>