
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
			<div class="card-body card-block">
                                    <form action="./user-profile-edit" method="post" enctype="multipart/form-data">
                                    <c:url value="/image?fname=${user.avatar }"
													var="imgUrl"></c:url> <img width="100px" height="150px"
												src="${imgUrl}">
                        
                                    <input type="file"
							class="form-control" name="images" id="images"
							value="${user.avatar}" />
                                    <div style="padding-left: 20px">
                                        <div class="form-group">
                                            <label for="name" class=" form-control-label">Họ và tên:</label>
                                            <input type="text" name="name" id="name" value="${user.name }" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="phone" class=" form-control-label">Số điện thoại:</label>
                                            <input type="text" name="phone" id="phone" value="${user.phone }" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class=" form-control-label">Email:</label>
                                             <input type="text" name="email" id="email" value="${user.email }" class="form-control">
                                        
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <button class="btn btn-success" type="submit">Lưu thông tin chính sửa</button>
                                      <a href="<c:url value="ChitietND"/>"  ><button type="button" class="btn btn-danger">Hủy</button></a>
                                         </div>
                                         </form>
                                    </div>
			
		</div>



	</section>
</body>
</html>
