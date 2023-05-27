<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Dashboard</title>

<!-- Fontfaces CSS-->
<link href="../template/css/font-face.css" rel="stylesheet" media="all">
<link
	href="../template/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link
	href="../template/vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link
	href="../template/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link
	href="../view/admin/template/vendor/bootstrap-4.1/bootstrap.min.css"
	rel="stylesheet" media="all">

<!-- Vendor CSS-->
<link href="../template/vendor/animsition/animsition.min.css"
	rel="stylesheet" media="all">
<link
	href="../template/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="../template/vendor/wow/animate.css" rel="stylesheet"
	media="all">
<link href="../template/vendor/css-hamburgers/hamburgers.min.css"
	rel="stylesheet" media="all">
<link href="../template/vendor/slick/slick.css" rel="stylesheet"
	media="all">
<link href="../template/vendor/select2/select2.min.css" rel="stylesheet"
	media="all">
<link href="../template/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="../template/css/theme.css" rel="stylesheet" media="all">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/css/admin/style.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/css/admin/style.css"/>" rel="stylesheet"
	type="text/css">

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
						<div class="col-md-9">
				<form action="#" method="post" enctype="multipart/form-data">
					<br />
					<div class="form-group" hidden="hidden">
						<label for="UserID">Product ID:</label> <input type="text"
							name="productId" value="${product.productId }" id="productId"
							class="form-control" readonly />
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
						<label for="description">Mô tả:</label> <input
							type="text" class="form-control" name="description"
							id="description" value="${product.description }" />
					</div>
					<div class="form-group">
						<label for="categoryId">Danh mục:</label> <input
							type="text" class="form-control" name="categoryId"
							id="categoryId" value="${product.categoryId }" />
					</div>
					<div class="form-group">
						<label for="storeId">Cửa hàng:</label> <input
							type="text" class="form-control" name="storeId"
							id="storeId" value="${product.storeId }" />
					</div>
					<div class="form-group">
						<label for="price">Giá:</label> <input
							type="text" class="form-control" name="price"
							id="price" value="${product.price }" />
					</div>
					<div class="form-group">
						<label for="quantity">Nhập số lượng:</label> <input
							type="text" class="form-control" name="quantity"
							id="quantity" value="${product.quantity }" />
					</div>
					<div class="form-check form-check-inline">
						<label for="isSelling">Status:</label> <input id="isSelling"
							class="form-check-input" type="radio" name="isSelling"
							${product.isSelling?'checked':''} value="true"> <label
							for="isSelling" class="form-check-label">Bán</label> <input
							id="isSelling" class="form-check-input" type="radio" name="isSelling"
							${!product.isSelling?'checked':''} value="false"> <label
							for="statusoff" class="form-check-label">Cất</label>
					</div>
					<br />
					<hr>
					<div class="form-group">
						<button class="btn green"
							formaction="<c:url value="/admin/product-add"/>">
							Create <i class="fa fa-plus"></i>
						</button>
						<a href="<c:url value="/admin/product"/>">
						<button class="btn btn-success">
							Exit <i class="fa fa-undo"></i>
						</button></a>
					</div>
				</form>
			</div>
					</div>

				</div>
			</div>
		</div>
		<!-- END MAIN CONTENT-->
		<!-- END PAGE CONTAINER-->
	</div>































	<!-- Jquery JS-->
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