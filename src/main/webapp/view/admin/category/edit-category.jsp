<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<!-- Required meta tags-->
<!-- Title Page-->
<title>Dashboard</title>

<!-- Fontfaces CSS-->
<link href="/view/admin/template/css/font-face.css" rel="stylesheet" media="all">
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
<link href="/view/admin/template/vendor/wow/animate.css" rel="stylesheet"
	media="all">
<link href="/view/admin/template/vendor/css-hamburgers/hamburgers.min.css"
	rel="stylesheet" media="all">
<link href="/view/admin/template/vendor/slick/slick.css" rel="stylesheet"
	media="all">
<link href="/view/admin/template/vendor/select2/select2.min.css" rel="stylesheet"
	media="all">
<link href="/view/admin/template/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="/view/admin/template/css/theme.css" rel="stylesheet" media="all">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="col-md-12">
				<form action="#" method="post" enctype="multipart/form-data">
					<br />
					<div class="form-group" hidden="hidden">
						<label for="UserID">Category ID:</label> <input type="text"
							name="cateid" value="${category.cateid }" id="cateid"
							class="form-control" readonly />
					</div>
					
					<div class="form-group">
										<c:url value="/image?fname=${category.img}"
						var="imgUrl"></c:url><img width="100px" height="100px"
															src="${imgUrl}">
					
					</div>
					<div class="form-group">
						<label for="namecate">Category Name:</label> <input type="text"
							class="form-control" name="namecate" id="namecate"
							value="${category.namecate }" />
					</div>
					<div class="form-group">
						<label for="img">Images:</label> <input type="file"
							class="form-control" name="img" id="img"
							value="${category.img}" />
					</div>
					<div class="form-check form-check-inline">
						<label for="isDel">Status:</label> <input id="isDel"
							class="form-check-input" type="radio" name="isDel"
							${category.isDel?'checked':''} value="false"> <label
							for="isDel" class="form-check-label">Hiển thị</label> <input
							id="isDel" class="form-check-input" type="radio" name="isDel"
							${!category.isDel?'checked':''} value="true"> <label
							for="statusoff" class="form-check-label">Xóa</label>
					</div>
					<div class="form-group" hidden="hidden">
						<label for="createCateDate">Created Date:</label> <input type="text"
							class="form-control" name="createCateDate" id="createCateDate"
							value="${category.createCateDate }" />
					</div>
					<div class="form-group" hidden="hidden">
						<label for="updateCateDate">Updated Date:</label> <input type="text"
							class="form-control" name="updateCateDate" id="updateCateDate"
							value="${category.updateCateDate }" />
					</div>
					<br />
					<hr>
					<div class="form-group">
						<button class="btn btn-warning"
							formaction="<c:url value="/admin/category-edit"/>">
							Update <i class="fa fa-edit"></i>
						</button>
						<br /> <br />
						<button class="btn btn-danger"
							formaction="<c:url value="/admin/category-delete"/>">
							Delete <i class="fa fa-trash"></i>
						</button>
						<a href="<c:url value="/admin/category"/>"><button class="btn btn-success">
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