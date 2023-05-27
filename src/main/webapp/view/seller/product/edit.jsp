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
				<!-- MAIN CONTENT-->
		<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">

					<div class="row" style="width: 100%">
						<div class="col-md-12">
							<form action="#" method="post" enctype="multipart/form-data">
								<br />
								<div class="form-group" hidden="hidden">
									<label for="UserID">Product ID:</label> <input type="text"
										name="productId" value="${product.productId }" id="productId"
										class="form-control" readonly />
								</div>

								<div class="form-group">
									<c:url value="/image?fname=${product.img}" var="imgUrl"></c:url>
									<img width="100px" height="100px" src="${imgUrl}">

								</div>
								<div class="form-group">
									<label for="productName">Tên sản phẩm:</label> <input
										type="text" class="form-control" name="productName"
										id="productName" value="${product.productName }" />
								</div>
								<div class="form-group">
									<label for="images">Hình ảnh:</label> <input type="file"
										class="form-control" name="images" id="images"
										value="${product.img}" />
								</div>
								<div class="form-group">
									<label for="description">Mô tả:</label> <input type="text"
										class="form-control" name="description" id="description"
										value="${product.description }" />
								</div>
								<div class="form-group">
									<label for="price">Giá:</label> <input type="text"
										class="form-control" name="price" id="price"
										value="${product.price }" />
								</div>
								<div class="form-group">
									<label for="categoryId">Danh mục:</label> <input type="text"
										class="form-control" name="categoryId" id="categoryId"
										value="${product.categoryId }" />
								</div>
								<div class="form-group">
									<label for="storeId">Cửa hàng:</label> <input type="text"
										class="form-control" name="storeId" id="storeId"
										value="${product.storeId }" />
								</div>
								<div class="form-check form-check-inline">
									<label for="isActive">Status:</label> <input id="isActive"
										class="form-check-input" type="radio" name="isActive"
										${product.isActive?'checked':''} value="true"> <label
										for="isActive" class="form-check-label">Hiện</label> <input
										id="isActive" class="form-check-input" type="radio"
										name="isActive" ${!product.isActive?'checked':''}
										value="false"> <label for="statusoff"
										class="form-check-label">Ẩn</label>
								</div>
								<br />
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
								<br />
								<hr>
								<div class="form-group">
									<button class="btn btn-warning"
										formaction="<c:url value="/product-edit"/>">
										Update 
									</button>
									<br /> <br />
									<button class="btn btn-danger"
										formaction="<c:url value="/product-delete"/>">
										Delete 
									</button>
									<a href="<c:url value="/sanpham"/>"><button
											class="btn btn-success">
											Exit 
										</button></a>
								</div>
							</form>
						</div>
					</div>

				</div>
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
