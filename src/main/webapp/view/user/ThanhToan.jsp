<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/4.css">
<link rel="stylesheet" href="css/3.css">
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
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
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<ul class="link">
		<li><a href="">Trang Chủ ></a></li>
		<li><a href="">Thanh Toán</a></li>

	</ul>
	<div class="khungThanhToan">
		<c:if test="${not empty sp }">
			<form action="Thanhtoan" method="post">
				<section>
					<div class="khung1">
						<div class="khung1_1">
							<div class="khung1_1_1">
								<div class="tieude_TT">
									<h3>Thông tin nhận hàng</h3>
									<div class="exit_TT">
										<ion-icon name="arrow-forward-outline"></ion-icon>
										<a href="index.html">Thoát</a>
									</div>
								</div>

								<div class="khungDienTT">

									<input name="ten" type="text" placeholder="Họ và tên"
										value="${user.name}"><br> <input name="email"
										type="email" placeholder="Email" value="${user.email}"><br>
									<input name="phone" type="text" placeholder="Số điện thoại"
										value="${user.phone}"><br> <input name="diachi"
										type="text" placeholder="Địa chỉ số"><br>

								</div>
							</div>
							<div class="khung1_1_2">
								<div class="VanChuyen">
									<h3>Cách vận chuyển</h3>
									<div class="CachThucVanChuyen">
										<input type="radio" id="VCh" name="fav_vanchuyen"
											value="CachVanChuyen"> <label for="VCh">Giao
											hàng tận nơi</label>
									</div>
								</div>
								<div class="KThanhToan">
									<h3>Cách thức thanh toán</h3>
									<div class="CachThucThanhToan">
										<input type="radio" id="tt_tien" name="fav_thanhtoan"
											value="TT_TienMat"> <label for="tt_tien">Thanh
											toán khi nhận hàng</label><br>

									</div>
								</div>
							</div>
						</div>
						<div class="khung1_2">
							<div class="tongDonHang">
								<h3>Đơn hàng</h3>
							</div>
							<div class="sanphamtrongDonHang">
								<c:if test="${not empty sp}">
									<div class="sp_1">
										<c:url value="/image?fname=${sp.img}" var="imgUrl"></c:url>
										<img src="${imgUrl}" style="width: 70px;" class="anh_sp">
										<p class="ten_sp" style="line-height: 50px;">${sp.namePro}</p>
										<p class="gia_sp" style="line-height: 50px;">${sp.price}<sup>đ</sup>
										</p>
										<ion-icon name="close-outline"></ion-icon>
									</div>
								</c:if>
								<c:if test="${not empty listgh}">
									<c:forEach items="${listgh}" var="o">
										<div class="sp_1">
											<c:url value="/image?fname=${sp.img}" var="imgUrl"></c:url>
										<img src="${imgUrl}" style="width: 70px;" class="anh_sp">
											<p class="ten_sp" style="line-height: 50px;">${o.namepro}</p>
											<p class="gia_sp" style="line-height: 50px;">${o.price}<sup>đ</sup>
											</p>
											<ion-icon name="close-outline"></ion-icon>
										</div>
									</c:forEach>
								</c:if>
							</div>
							<div class="tinhTien">
								<div class="tongTienSp">
									<p class="ten_phi">Tạm tính</p>
									<p class="phi">${tong}<sup>vnd</sup>
									</p>
								</div>
								<div class="phiVanChuyen">
									<p class="ten_phi">Phí vận chuyển</p>
									<p class="phi">80 000vnd</p>
								</div>
							</div>
							<div class="TongTien">
								<div class="Hang_chot_tien">
									<p class="gia_cuoi">Tổng cộng</p>
									<p>${tong}<sup>vnd</sup>
									</p>
								</div>
								<div class="khung1_2_5_2">
									<div class="back_voHang">
										<ion-icon name="chevron-back-outline"></ion-icon>
										<a href="">Quay về vỏ hàng</a>
									</div>
									<div class="btn_datHang">
										<button>Đặt hàng</button>
									</div>
								</div>
							</div>

						</div>


					</div>










				</section>
			</form>
		</c:if>
		<c:if test="${not empty listgh }">
			<form action="ThanhToanGH" method="post">
				<section>
					<div class="khung1">
						<div class="khung1_1">
							<div class="khung1_1_1">
								<div class="tieude_TT">
									<h3>Thông tin nhận hàng</h3>
									<div class="exit_TT">
										<ion-icon name="arrow-forward-outline"></ion-icon>
										<a href="index.html">Thoát</a>
									</div>
								</div>

								<div class="khungDienTT">

									<input name="ten" type="text" placeholder="Họ và tên"
										value="${user.name}"><br> <input name="email"
										type="email" placeholder="Email" value="${user.email}"><br>
									<input name="phone" type="text" placeholder="Số điện thoại"
										value="${user.phone}"><br> <input name="diachi"
										type="text" placeholder="Địa chỉ số"><br>  
								</div>
							</div>
							<div class="khung1_1_2">
								<div class="VanChuyen">
									<h3>Cách vận chuyển</h3>
									<div class="CachThucVanChuyen">
										<input type="radio" id="VCh" name="fav_vanchuyen"
											value="CachVanChuyen"> <label for="VCh">Giao
											hàng tận nơi</label>
									</div>
								</div>
								<div class="KThanhToan">
									<h3>Cách thức thanh toán</h3>
									<div class="CachThucThanhToan">
										<input type="radio" id="tt_tien" name="fav_thanhtoan"
											value="TT_TienMat"> <label for="tt_tien">Thanh
											toán khi nhận hàng</label><br>

									</div>
								</div>
							</div>
						</div>
						<div class="khung1_2">
							<div class="tongDonHang">
								<h3>Đơn hàng</h3>
							</div>
							<div class="sanphamtrongDonHang">

								<c:if test="${not empty listgh}">
									<c:forEach items="${listgh}" var="o">
										<div class="sp_1">
											<img src="${o.img}" style="width: 70px;" class="anh_sp">
											<p class="ten_sp" style="line-height: 50px;">${o.namepro}</p>
											<p class="gia_sp" style="line-height: 50px;">${o.price}<sup>đ</sup>
											</p>
											<ion-icon name="close-outline"></ion-icon>
										</div>
									</c:forEach>
								</c:if>
							</div>
							<div class="tinhTien">
								<div class="tongTienSp">
									<p class="ten_phi">Tạm tính</p>
									<p class="phi">${tong}<sup>vnd</sup>
									</p>
								</div>
								<div class="phiVanChuyen">
									<p class="ten_phi">Phí vận chuyển</p>
									<p class="phi">80 000vnd</p>
								</div>
							</div>
							<div class="TongTien">
								<div class="Hang_chot_tien">
									<p class="gia_cuoi">Tổng cộng</p>
									<p>${tong}<sup>vnd</sup>
									</p>
								</div>
								<div class="khung1_2_5_2">
									<div class="back_voHang">
										<ion-icon name="chevron-back-outline"></ion-icon>
										<a href="">Quay về vỏ hàng</a>
									</div>
									<div class="btn_datHang">
										<button>Đặt hàng</button>
									</div>
								</div>
							</div>

						</div>


					</div>










				</section>
			</form>
		</c:if>








	</div>
</body>
</html>