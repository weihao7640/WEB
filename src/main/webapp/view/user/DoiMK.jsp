<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<link rel="stylesheet" href="css/4.css">
<link rel="stylesheet" href="css/1.css">

<!-- page css -->
<link
	href="~/Adminassets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css"
	rel="stylesheet" />

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery.perfect-scrollbar/0.6.7/css/perfect-scrollbar.min.css" />

<!-- Core css -->
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Fesh Food.vn</title>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>


	<ul class="link">
		<li><a href="">Trang Chủ ></a></li>
		<li><a href="">Đôi Mật Khẩu</a></li>

	</ul>
	<section class="NoidungChinh">
		<div class="Noidung1">
			<div class="title_hello">
				<h5 class="title_trangtaikhoan">Trang Tài Khoản</h5>
				<p>
					Xin chào: <span>Khách hàng </span>
				</p>
			</div>
			<ul class="noidung1_1">
				<li><a class="noidungInfo_active" href="ChiTietND">Thông tin tài
						khoản</a></li>
				<li><a class="noidungInfo_active" href="listFollow">Đang theo dõi</a></li>
				<li><a class="noidungInfo" href="Donhang">Đơn hàng của bạn</a></li>
				<li><a class="noidungInfo" href="DoiMK">Đổi mật khẩu</a></li>
				<li><a class="noidungInfo" href="kennguoiban">Kênh người
						bán</a></li>
				<li><a class="noidungInfo" href="dangxuat">Đăng xuất</a></li>
			</ul>
		</div>
		<form class="Noidung2" action="DoiMK" method="post">
			<c:if test="${not empty error}">
				<div class="col-md-12">
					<div class="alert alert-danger" role="alert">${error}</div>
				</div>
			</c:if>
			<c:if test="${not empty sus}">
				<div class="col-md-12">
					<div class="alert alert-success" role="alert">${sus}</div>
				</div>
			</c:if>
			<h2 class="title_Chinh">Đổi mật khẩu</h2>
			<p>Để đảm bảo tính bảo mật, vui lòng đặt mật khẩu với ít nhất 8
				kí tự</p>
			<div class="KhungDoiMK">
				<div class="MKCu">
					<p>Mật khẩu cũ</p>
					<input class="MKhauCu" name="user" type="password"
						placeholder="Nhập mật khẩu cũ">
				</div>
				<div class="MKMoi1">
					<p>Mật khẩu mới</p>
					<input class="MKhauMoi1" name="pass" type="password"
						placeholder="Nhập lại mật khẩu mới">
				</div>
				<div class="MKMoi2">
					<p>Nhập lại mật khẩu mới</p>
					<input class="MKhauMoi2" name="repass" type="password"
						placeholder="Nhập mật khẩu mới">
				</div>
				<button type="submit" onclick="" class="btn_changePW">Đặt
					lại mật khẩu</button>
			</div>


		</form>



	</section>
</body>
</html>