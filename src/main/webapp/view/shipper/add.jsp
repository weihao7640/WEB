<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Favicon -->
<link rel="shortcut icon" href="~/Adminassets/images/logo/favicon.png">

<!-- page css -->
<link href="css/bootstrap-datepicker.min.css" rel="stylesheet" />

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
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<!-- Core css -->
<link href="css/app.min.css" rel="stylesheet">

</head>

<body>
	<div class="app">
		<div class="layout">
			<!-- Header START -->

			<jsp:include page="/view/seller/commonseller/header.jsp"></jsp:include>
			<!-- Header END -->

			<!-- Side Nav START -->
			<jsp:include page="/view/seller/commonseller/slider.jsp"></jsp:include>
			<!-- Side Nav END -->

			<!-- Page Container START -->
			<div class="page-container">

				<!-- Content Wrapper START -->
				<div class="main-content">
					<div class="page-header">
						<h2 class="header-title">Thêm shipper:</h2>
						<div class="header-sub-title">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb breadcrumb-dash list-inline">
									<li class="breadcrumb-item list-inline-item"><a
										class="breadcrumb-item" asp-area="Admin" asp-controller="Home"
										asp-action="Index">Home</a></li>
									<li class="breadcrumb-item list-inline-item"><a
										class="breadcrumb-item" asp-area="Admin"
										asp-controller="AdminMatHangs" asp-action="Index">Quản lý
											nhân viên</a></li>
									<li class="breadcrumb-item active list-inline-item"
										aria-current="page"></li>
								</ol>
							</nav>
						</div>

					</div>
					<form action="dangkyshipper" method="post">

						<div asp-validation-summary="ModelOnly" class="text-danger"></div>
						<div class="page-header no-gutters has-tab">
							<ul class="nav nav-tabs">
								<li class="nav-item"><a class="nav-link active"
									data-toggle="tab" href="#MatHang-luachon">Thông tin cơ bản</a>
								</li>

							</ul>
						</div>
						<div class="tab-content m-t-15">
							<div class="tab-pane fade show active" id="MatHang-luachon">
								<div class="card">
									<div class="card-body">
										<div class="col-md-12">
											<c:if test="${not empty error}">
												<div class="col-md-12">
													<div class="alert alert-danger" role="alert">${error}</div>
												</div>
											</c:if>
											<div class="form-group" style="margin-top: 20px;">
												<label for="exampleInputEmail1">Nhập Họ Và Tên<span
													class="required">*</span></label> <input name="ten"
													class="form-control" id="exampleInputEmail1"
													placeholder="Nhập Họ và tên"
													class="form-control form-control-lg"
													data-validation-error-msg="Email sai định dạng" value=""
													id="email" required="">
											</div>
										</div>
										<div class="col-md-12" style="margin-top: 20px;">
											<div class="form-group">
												<label for="exampleInputEmail1">Nhập Số Điện Thoại<span
													class="required">*</span></label> <input class="form-control"
													id="exampleInputEmail1" placeholder="Nhập Số Điện Thoại"
													name="sdt" class="form-control form-control-lg"
													data-validation="email"
													data-validation-error-msg="Email sai định dạng" value=""
													id="email" required="">
											</div>
										</div>
										<div class="col-md-12">
											<div class="form-group" style="margin-top: 20px;">
												<label for="exampleInputEmail1">Nhập Email<span
													class="required">*</span></label> <input type="email"
													class="form-control" id="exampleInputEmail1"
													placeholder="Nhập Địa chỉ Email" name="email"
													class="form-control form-control-lg"
													data-validation="email"
													data-validation-error-msg="Email sai định dạng" value=""
													name="email" id="email" required="">
											</div>
										</div>
										<div class="col-md-12">
											<div class="form-group" style="margin-top: 20px;">
												<label for="exampleInputPassword1">Nhập Mật Khẩu<span
													class="required">*</span></label> <input type="password"
													class="form-control" id="exampleInputPassword1" required=""
													placeholder="Password" name="pass">
											</div>
										</div>


									</div>
								</div>
							</div>
						</div>

						<div class="form-group">
							<input type="submit" value="Thêm" class="btn btn-primary" /> <a
								class="btn btn-primary">Quay Lại</a>
						</div>
					</form>




				</div>
				<!-- Content Wrapper END -->
				<!-- Footer START -->
				@await Html.PartialAsync("Footer.cshtml")
				<!-- Footer END -->



			</div>
			<!-- Page Container END -->
			<!-- Search Start-->
			<!-- Search End-->
			<!-- Quick View START -->
			<!-- Quick View END -->
		</div>
	</div>



	<!-- Core Vendors JS -->
	<script src="js/vendors.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.perfect-scrollbar/0.6.7/js/min/perfect-scrollbar.jquery.min.js"></script>

	<!-- page js -->
	<script src="js/Chart.min.js"></script>

	<!-- Core JS -->
	<script src="js/app.min.js"></script>
</body>

</html>
