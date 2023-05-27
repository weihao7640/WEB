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
			<div class="col-md-12" style="padding-right:25px; padding-top: 25px">
			<table class="table table-striped table-bordered table-hover"
				id="sample_2">
				<thead>
					<tr>
						<th>Ảnh đại diện</th>
						<th>Tên người dùng</th>
						<th>Email</th>
						<th>Số điện thoại</th>
						<th>Vai trò</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${users}">
						<tr class="odd gradeX">
							<td><c:url
									value="/image?fname=${item.avatar}"
									var="imgUrl"></c:url> <img width="50px" height="50px"
								src="${imgUrl}"></td>
							<td><a href="<c:url value='/admin/user-detail?userId=${item.userID }'/>">${item.name }</a></td>
							<td>${item.email }</td>
							<td>${item.phone }</td>
							<td>
							<c:if test="${item.role==1 }">Người dùng</c:if>
							<c:if test="${item.role==2 }">Shipper</c:if>
							<c:if test="${item.role==3 }">Admin</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="col-md-6 col-sm-12" style="padding-top:0">
							<ul class="pagination pull-right">
								<c:if test="${tag>1}">
									<li><a
										href="${pageContext.request.contextPath }/admin/user-list?index=${tag-1}">&laquo;</a></li>
								</c:if>
								<c:forEach begin="1" end="${endP}" var="i">
									<li class='${tag==i?"active":"" }'><a
										href="${pageContext.request.contextPath}/admin/user-list?index=${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${tag<endP}">
									<li><a
										href="${pageContext.request.contextPath}/admin/user-list?index=${tag+1}">&raquo;</a></li>
								</c:if>
							</ul>
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