
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
		<li><a href="">Đơn hàng</a></li>

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
				<li><a class="noidungInfo" href="ChiTietND">Thông tin tài
						khoản</a></li>
				<li><a class="noidungInfo_active" href="Donhang">Đơn hàng
						của bạn</a></li>
				<li><a class="noidungInfo" href="DoiMK">Đổi mật khẩu</a></li>
				<li><a class="noidungInfo" href="Diachi">Số địa chỉ(0)</a></li>
				<li><a class="noidungInfo" href="kennguoiban">Kênh người
						bán</a></li>
				<li><a class="noidungInfo" href="dangxuat">Đăng xuất</a></li>
			</ul>
		</div>
		
		<div class="Noidung2">
		<c:if test="${not empty mess}">
				
					<div class="alert alert-success" role="alert">${mess}</div>
				
				</c:if>
			<h2 class="title_Chinh">Đơn hàng của bạn</h2>
			<div class="table-responsive">
				<table class="table table-hover e-commerce-table">
					<thead>
						<tr>
							<th>Đơn hàng</th>
							<th>Tên Mặt Hàng</th>

							<th>Số Lượng</th>

						</tr>
					</thead>
					<tbody>

						<tr>
							<td>${dh.oderID}</td>
							<td>${dh.namepro}</td>
							<td>${dh.count}</td>
							
						</tr>
				</table>
			
					<c:if test="${dh_HT.trangthai.equals( 'Đã giao') }">
					<c:if test="${empty check }">
					<form action="review" method="get">
					<c:if test="${sao==1}">
					<a href="danhgia?sao=1" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=2" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=3" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=4" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=5" ><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					<c:if test="${empty sao}">
					<a href="danhgia?sao=1" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=2" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=3" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=4" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=5" ><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					
					<c:if test="${sao==2}">
					<a href="danhgia?sao=1" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=2" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=3" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=4" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=5" ><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					<c:if test="${sao==3}">
					<a href="danhgia?sao=1" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=2" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=3" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=4" ><ion-icon name="star-outline"></ion-icon></a>
					<a href="danhgia?sao=5" ><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					<c:if test="${sao==4}">
					<a href="danhgia?sao=1" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=2" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=3" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=4" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=5" ><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					<c:if test="${sao==5}">
					<a href="danhgia?sao=1" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=2" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=3" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=4" ><ion-icon name="star"></ion-icon></a>
					<a href="danhgia?sao=5" ><ion-icon name="star"></ion-icon></a>
					</c:if>
					<div class="form-group">
						<label class="font-weight-semibold">Đánh giá</label> 
						<input name="content" type="text" class="form-control">
						<span class="text-danger"></span>
					</div>
					
					<button type="submit" class="btn btn-primary"> Gửi phản hồi </button> 
					</form>
					</c:if>
					</c:if>
					<c:if test="${dh_HT.trangthai.equals( 'Chưa xác nhận')}">
						<div class="form-group">
							<a href="update_TTDH?iddh=${dh.oderID}" class="btn btn-primary"> Xác Nhận </a> 
						</div>
					</c:if>
				
					<c:if test="${dh_HT.trangthai.equals('Đã xác nhận')}">
						<div class="form-group">
							<input type="button" value="Đã xác nhận" class="btn btn-primary" />
						</div>
					</c:if>

			</div>
			<div class="form-group">
				<a class="btn btn-primary" >Quay Lại</a>
			</div>
		</div>

	</section>
</body>
</html>

