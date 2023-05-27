<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<!-- Required meta tags-->
<!-- Title Page-->
<title>Dashboard</title>

<!-- Fontfaces CSS-->
<link href="/view/admin/template/css/font-face.css" rel="stylesheet"
	media="all">
<link
	href="/view/admin/template/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link
	href="/view/admin/template/vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link
	href="/view/admin/template/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link
	href="/view/admin/view/admin/template/vendor/bootstrap-4.1/bootstrap.min.css"
	rel="stylesheet" media="all">

<!-- Vendor CSS-->
<link href="/view/admin/template/vendor/animsition/animsition.min.css"
	rel="stylesheet" media="all">
<link
	href="/view/admin/template/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="/view/admin/template/vendor/wow/animate.css"
	rel="stylesheet" media="all">
<link
	href="/view/admin/template/vendor/css-hamburgers/hamburgers.min.css"
	rel="stylesheet" media="all">
<link href="/view/admin/template/vendor/slick/slick.css"
	rel="stylesheet" media="all">
<link href="/view/admin/template/vendor/select2/select2.min.css"
	rel="stylesheet" media="all">
<link
	href="/view/admin/template/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="/view/admin/template/css/theme.css" rel="stylesheet"
	media="all">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/css/admin/style.css"/>" rel="stylesheet"
	type="text/css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.0.1/chart.min.js"></script>
</head>
<body>
	<%@ include file='/view/admin/template/left-tool.jsp'%>






	<div class="page-container">
		<!-- HEADER DESKTOP-->
		<%@ include file='/view/admin/template/header.jsp'%>
		<!-- HEADER DESKTOP-->

		<!-- MAIN CONTENT-->
		<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">

					<div class="row" style="width: 100%">
						<div class="col-md-12">
							<div class="col-md-12" style="padding-left: 10%">
								<div class="card">
									<div class="card-header" style="display: flex">
										<strong>Đơn hàng:</strong><h3 style="padding-left:10px">${ord.oderid}</h3>
									</div>
									<div class="card-body card-block" style="display: flex">

										<div style="padding-left: 20px">
											<div class="form-group">
												<label for="company" class=" form-control-label">Tên
													người đặt hàng: ${ord.usersName }</label>
											</div>
											<div class="form-group">
												<label for="vat" class=" form-control-label">Số điện
													thoại: ${ord.phone }</label>
											</div>
											<div class="form-group">
												<label for="street" class=" form-control-label">Địa chỉ:
													${ord.diachi }</label>

											</div>
											<div class="form-group">
												<label for="street" class=" form-control-label">Shop
													cung cấp: ${ord.storeName }</label>

											</div>
											<div class="form-group">
												<label for="street" class=" form-control-label">Danh
													sách sản phẩm</label>
												<table
													class="table table-striped table-bordered table-hover"
													id="sample_2">
													<thead>
														<tr>
															<th>Mã sản phẩm</th>
															<th>Tên sản phẩm</th>
															<th>Số lượng</th>
															<th>Giá</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="i" items="${orditems}">
															<tr class="odd gradeX">
																<td>${i.productid }</td>
																<td>${i.productName }</td>
																<td>${i.count }</td>
																<td>${i.gia }</td>

															</tr>
														</c:forEach>
														<tr>
															<td>Tổng giá:</td>
															<td></td>
															<td></td>
															<td>${ord.tong }</td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="form-group">
												<label for="street" class=" form-control-label">Trạng
													thái thanh toán: ${ord.statusTT }</label>

											</div>
											<div class="form-group">
												<label for="street" class=" form-control-label">Ngày
													đặt hàng: ${ord.ngaynhap }</label>

											</div>
											<div class="form-group">
												<label for="street" class=" form-control-label">Cập
													nhật lần cuối: ${ord.ngayup}</label>

											</div>
											<div class="form-group">
												<label for="street" class=" form-control-label">Trạng
													thái giao hàng: ${ord.trangthai }</label>

											</div>
											<div class="form-group">
												<label for="street" class=" form-control-label">Người giao hàng: ${ord.shipperName }</label>

											</div>




										</div>
									</div>
									<div class="card-body">
										<a href="<c:url value=""/>">
											<button type="button" class="btn btn-success">Xem
												đánh giá</button>
										</a> <a href="<c:url value="/admin/order"/>">
											<button type="button" class="btn btn-secondary">Thoát</button>
										</a>
									</div>
								</div>

							</div>

						</div>
					</div>

				</div>
			</div>
		</div>




		<!-- END MAIN CONTENT-->
		<!-- END PAGE CONTAINER-->
	</div>































	<script src="../template/vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="../template/vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="../template/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script src="../template/vendor/slick/slick.min.js">
		
	</script>
	<script src="../template/vendor/wow/wow.min.js"></script>
	<script src="../template/vendor/animsition/animsition.min.js"></script>
	<script
		src="../template/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script src="../template/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="vendor/counter-up/jquery.counterup.min.js">
		
	</script>
	<script src="../template/vendor/circle-progress/circle-progress.min.js"></script>
	<script src="../template/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="../template/vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="../template/vendor/select2/select2.min.js">
		
	</script>

	<!-- Main JS-->
	<script src="../template/js/main.js"></script>





</body>
</html>