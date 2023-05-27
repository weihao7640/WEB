
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
		<li><a href="">Thông tin của bạn</a></li>

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
		<div class="Noidung2">
			<h2 class="title_Chinh">Thông tin tài khoản</h2>

			<table class="table table-striped table-bordered table-hover"
				id="sample_2">
				<thead>
					<tr>
						<th>Ảnh đại diện</th>
						<th>Tên store</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listfollow}">
						<tr class="odd gradeX">
							<td><c:url value="/image?fname=${item.avatar}" var="imgUrl"></c:url>
								<img width="50px" height="50px" src="${imgUrl}"></td>
							<td><a
								href="<c:url value=''/>" style="display: list-item">
										<strong>${item.storeName }</strong>
										<br/><small>ID_Store: ${item.storeid }</small>
									</a></td>

							<td><a href="<c:url value="./unfollow?storeid=${item.storeid }"/>"><button type="button"
					class="btn btn-danger" style="width:100px; text-align: center">Hủy follow</button></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>





		</div>



	</section>
</body>
</html>
