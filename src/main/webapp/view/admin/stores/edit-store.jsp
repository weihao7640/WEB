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
					
					
					<div>${thu }</div>
					
					
					<div class="form-group" hidden="hidden">
						<label for="UserID">Store ID:</label> <input type="text"
							name="storeId" value="${store.storeId }" id="storeId"
							class="form-control" readonly />
					</div>
					
					<div class="form-group">
										<c:url value="/image?fname=${store.avatar}"
						var="imgUrl"></c:url><img width="100px" height="100px"
															src="${imgUrl}">
					
					</div>
					<div class="form-group">
						<label for="storeName">Tên cửa hàng:</label> <input
							type="text" class="form-control" name="storeName"
							id="storeName" value="${store.storeName }" />
					</div>
					<div class="form-group" hidden="hidden">
						<label for="ownerID">ID Chủ:</label> <input
							type="text" class="form-control" name="ownerID"
							id="ownerID" value="${store.ownerID}" />
					</div>
					
					<div class="form-group">
						<label for="ownerName">Chủ:</label> <input
							type="text" class="form-control" name="ownerName"
							id="ownerName" value="${store.ownerName}" />
					</div>
					<div class="form-group">
						<label for="point">Điểm:</label> <input
							type="text" class="form-control" name="point"
							id="point" value="${store.point }" />
					</div>
					<div class="form-group">
						<label for="rating">Đánh giá:</label> <input
							type="text" class="form-control" name="rating"
							id="rating" value="${store.rating }" />
					</div>
					<div class="form-group">
						<label for="createAt">Ngày mở:</label> <input
							type="text" class="form-control" name="createAt"
							id="createAt" value="${store.createAt}" />
					</div>
					<div class="form-group">
						<label for="updateAt">Cập nhật lần cuối:</label> <input
							type="text" class="form-control" name="updateAt"
							id="updateAt" value="${store.updateAt}" />
					</div>
					<div class="form-check form-check-inline">
						<label for="isActive">Tình trạng:</label> <input id="isActive"
							class="form-check-input" type="radio" name="isActive"
							${store.active?'checked':''} value="true"> <label
							for="isActive" class="form-check-label">Đang hoạt động</label> <input
							id="isActive" class="form-check-input" type="radio" name="isActive"
							${!store.active?'checked':''} value="false"> <label
							for="statusoff" class="form-check-label">Ngừng hoạt động</label>
					</div>
					<br />
					<div class="form-check form-check-inline">
						<label for="isOpen">Trạng thái:</label> <input id="isOpen"
							class="form-check-input" type="radio" name="isOpen"
							${store.open?'checked':''} value="true"> <label
							for="isOpen" class="form-check-label">Đang mở cửa</label> <input
							id="isOpen" class="form-check-input" type="radio" name="isOpen"
							${!store.open?'checked':''} value="false"> <label
							for="statusoff" class="form-check-label">Đang đóng cửa</label>
					</div>
					<br />
					<hr>
					<div class="form-group">
						<button class="btn btn-warning"
							formaction="<c:url value="/admin/stores-edit"/>">
							Update <i class="fa fa-edit"></i>
						</button>
						<a href="<c:url value="/admin/store-list"/>"><button class="btn btn-success">
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