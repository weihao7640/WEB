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
			<div class="col-md-12"
				style="padding-right: 5px; padding-top: 25px; font-family: inherit;">
				<div style="border: 2px outset #eeeeee;">
					<div class="brg">
						<img src="image/brg/brg1.jpg" alt="">
					</div>
					<div class="title" style="display: flex">
						<c:url value="/image?fname=${user.avatar}" var="imgUrl"></c:url>
						<img width="100px" height="150px" src="${imgUrl}">
						<div style="width:100%">
							<p
								style="padding-left: 10%; text-align: center; margin-top: 20px; magrin-left: 10px">
							<h3>${user.name}</h3>
							</p>


							<p style="padding-left: 5px; margin-bottom: 5px">Số điện
								thoại: ${user.phone}</p>
							<p style="padding-left: 5px;">Email: ${user.email}</p>
							
							<c:if test="${storeID!=0 }">
							<div style="padding-left: 30%;"><a style=" border: 1px solid #EEEEEE; background-color: #EEEEEE; color: black" href="<c:url value='/admin/stores-detail?storeID=${storeID }'/>">Store của ${user.name }</a></div>
							</c:if>
							
							
							
						</div>


					</div>
					
					
				
				</div>
				<table class="table table-striped table-bordered table-hover"
					id="sample_2">
					<thead>
						<tr>
							<th>Mã đơn hàng</th>
							<th>Địa chỉ</th>
							<th>Trạng thái đơn hàng</th>
							<th>Tổng giá</th>
							<th>Cập nhật lần cuối</th>
							<th>Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${orders}">
							<tr class="odd gradeX">
								<td>${item.oderid}</td>
								<td>${item.diachi }</td>
								<td>${item.trangthai}</td>
								<td>${item.tong }</td>
								<td>${item.ngayup }</td>
								<td><a
									href="<c:url value='#'/>"
									class="center">Detail</a> | <a
									href="<c:url value='#'/>"
									class="center">Delete</a></td>
							</tr>
						</c:forEach>
						
						
						
						
						
						
					</tbody>
					<p></p>
				</table>
				<div class="col-md-6 col-sm-12" style="padding-top:0">
							<ul class="pagination pull-right">
								<c:if test="${tag>1}">
									<li><a
										href="${pageContext.request.contextPath }/admin/order-list?userId=${user.userID }&index=${tag-1}">&laquo;</a></li>
								</c:if>
								<c:forEach begin="1" end="${endP}" var="i">
									<li class='${tag==i?"active":"" }'><a
										href="${pageContext.request.contextPath}/admin/order-list?userId=${user.userID }&index=${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${tag<endP}">
									<li><a
										href="${pageContext.request.contextPath}/admin/order-list?userId=${user.userID }&index=${tag+1}">&raquo;</a></li>
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