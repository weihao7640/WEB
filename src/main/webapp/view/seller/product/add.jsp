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
						<h2 class="header-title">Thêm sản phẩm :</h2>
						<div class="header-sub-title">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb breadcrumb-dash list-inline">
									<li class="breadcrumb-item list-inline-item"><i
										class="anticon anticon-home m-r-5"></i> <a
										class="breadcrumb-item">Home</a></li>
									<li class="breadcrumb-item list-inline-item"><a
										class="breadcrumb-item" >Quản lý
											sản phẩm</a></li>
									<li class="breadcrumb-item active list-inline-item"
										aria-current="page"></li>
								</ol>
							</nav>
						</div>

					</div>
					<form action="addsanpham" method="post"
						enctype="multipart/form-data">

						<div asp-validation-summary="ModelOnly" class="text-danger"></div>
						<div class="page-header no-gutters has-tab">
							<ul class="nav nav-tabs">
								<li class="nav-item"><a class="nav-link active"
									data-toggle="tab" href="#MatHang-luachon">Thông tin cơ bản</a>
								</li>
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#MatHang-luachonthem">Thông tin chi tiết</a></li>
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#MatHang-Mota">Mô tả</a></li>
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#MatHang-Anh">Ảnh</a></li>
							</ul>
						</div>
						<div class="tab-content m-t-15">
							<div class="tab-pane fade show active" id="MatHang-luachon">
								<div class="card">
									<div class="card-body">
										<div class="form-group">
											<label class="font-weight-semibold">Tên sản phẩm</label> <input
												name="productName" type="text" class="form-control">
											<span class="text-danger"></span>
										</div>

										<div class="form-group">
											<label class="font-weight-semibold">Giá bán</label> <input
												type="text" name="price" class="form-control"> <span
												class="text-danger"></span>
										</div>
										<div class="form-group">
											<label asp-for="SoLuong"
												class="control-label font-weight-semibold">Số lượng</label>
											<input name="quantity" type="text" class="form-control" /> <span
												class="text-danger"></span>
										</div>


									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="MatHang-luachonthem">
								<div class="card">
									<div class="card-body">

										<div class="form-group">
										<select class="custom-select" id="txtMaDanhMuc"
												 name="categoryId" style="min-width: 180px;"
												>

												<c:forEach items="${listcate}" var="o">
													<option value="${o.cateid}" selected>${o.namecate}</option>
												</c:forEach>
									
											</select>
											
						
										</div>
									
										<div class="form-check form-check-inline">
											<label for="isSelling">Status:</label> <input id="isSelling"
												class="form-check-input" type="radio" name="isSelling"
												${product.isSelling?'checked':''} value="true"> <label
												for="isSelling" class="form-check-label">Bán</label> <input
												id="isSelling" class="form-check-input" type="radio"
												name="isSelling" ${!product.isSelling?'checked':''}
												value="false"> <label for="statusoff"
												class="form-check-label">Cất</label>
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="MatHang-Mota">
								<div class="card">
									<div class="card-body">
										<textarea class="summernote" name="description"></textarea>
										<span class="text-danger"></span>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="MatHang-Anh">
								<div class="form-group">
									<label for="images">Hình ảnh:</label> <input type="file"
										class="form-control" name="images" id="images"
										value="${product.img}" />
								</div>

							</div>

						</div>
						<div class="form-group">
							<input type="submit" value="Thêm" class="btn btn-primary" /> <a
								class="btn btn-primary">Quay Lại</a>
						</div>
					</form>




				</div>
				



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
