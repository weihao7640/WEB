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
							style="padding-right: 25px; padding-top: 25px;">
							<div class="form-group">
								<a href="<c:url value="/admin/add-category"/>"><button
										class="btn green">
										Create <i class="fa fa-plus"></i>
									</button></a>
							</div>
							<div class="col-md-12">
				<c:forEach var="cate" items="${categorys }">
			
					<a class="item__menu" style="font-size: 16px;color: #3366CC; background: #f5f5f5;display: inline-block; padding: 7px 26px 5px;margin-right: 6px;margin-bottom: 10px;"
					 href="<c:url value='/admin/categorylist?categoryID=${cate.cateid }'/>">${cate.namecate }</a>
				
				</c:forEach>
				</div>
				<table class="table table-striped table-bordered table-hover"
					id="sample_2">
					<thead>
						<tr>
							<th>Ảnh đại diện</th>
							<th>Tên sản phẩm</th>
							<th>Số lượng</th>
							<th>Giá</th>
							<th>Danh mục</th>
							<th>Cửa hàng</th>
							<th>Trạng thái</th>
							<th>Selling</th>
							<th>Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${products}">
							<tr class="odd gradeX">
								<td><c:url value="/image?fname=${item.img }" var="imgUrl"></c:url>
									<img width="50px" height="50px" src="${imgUrl}"></td>
								<td>${item.productName }</td>
								<td>${item.quantity}</td>
								<td>${item.price}</td>
								<td>${item.categoryId }</td>
								<td>${item.storeId }</td>
								<td><c:if test="${item.isActive == true}">
										<span class="label label-sm label-success"> Khả dụng </span>
									</c:if> <c:if test="${item.isActive ==false}">
										<span class="label label-sm label-warning"> Không còn
											khả dụng</span>
									</c:if></td>
								<td><c:if test="${item.isSelling == true}">
										<span class="label label-sm label-success"> Đang được
											bán </span>
									</c:if> <c:if test="${item.isSelling ==false}">
										<span class="label label-sm label-warning"> Ngừng bán</span>
									</c:if></td>
								<td><a
									href="<c:url value='/admin/product/edit?id=${item.productId }'/>"
									class="center">Edit</a> | <a
									href="<c:url value='/admin/product/delete?id=${item.productId }'/>"
									class="center">Delete</a></td>
							</tr>
						</c:forEach>
						
						
						
						
						
						
					</tbody>
				</table>
				<div class="col-md-6 col-sm-12" style="padding-top:0">
							<ul class="pagination pull-right">
								<c:if test="${tag>1}">
									<li><a
										href="${pageContext.request.contextPath }/admin/categorylist?categoryID=${cateid }&index=${tag-1}">&laquo;</a></li>
								</c:if>
								<c:forEach begin="1" end="${endP}" var="i">
									<li class='${tag==i?"active":"" }'><a
										href="${pageContext.request.contextPath}/admin/categorylist?categoryID=${cateid }&index=${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${tag<endP}">
									<li><a
										href="${pageContext.request.contextPath}/admin/categorylist?categoryID=${cateid }&index=${tag+1}">&raquo;</a></li>
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