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
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.0.1/chart.min.js"></script>
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
				<div class="col-md-10" style="padding-left:20%">
				<div class="card">
                                    <div class="card-header">
                                        <strong>Profile</strong>
                                        <small> ${admin.userID }</small>
                                    </div>
                                    <div class="card-body card-block" style="display: flex">
                                    <div >
                                    <c:url value="/image?fname=${admin.avatar }"
													var="imgUrl"></c:url> <img width="100px" height="150px"
												src="${imgUrl}">
                                    </div>
                                    <div style="padding-left: 20px">
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">Họ và tên: ${admin.name }</label>
                                        </div>
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Số điện thoại: ${admin.phone }</label>
                                        </div>
                                        <div class="form-group">
                                            <label for="street" class=" form-control-label">Email: ${admin.email }</label>
                                        
                                        </div>
                                    </div>
                                    </div>
                                    <div class="card-body">
                                    <a href="<c:url value="/admin/profile-edit"/>">    <button type="button" class="btn btn-secondary">Chỉnh sửa thông tin</button></a>
                                     <a href="<c:url value="/admin/profile-changePw"/>">    <button type="button" class="btn btn-success">Đổi mật khẩu</button></a>
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