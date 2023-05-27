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
						<div class="col-md-13"
							style="padding-right: 5px; padding-top: 25px; font-family: inherit;">
							<div style="border: 2px outset #eeeeee;">
								<div class="brg">
									<img src="image/brg/brg1.jpg" alt="">
								</div>
								<div class="title" style="display: flex">
									<c:url value="/image?fname=${store.avatar}" var="imgUrl"></c:url>
									<img width="100px" height="100px" src="${imgUrl}">
									<div
										style="text-align: center; margin-top: 20px; magrin-left: 10px">
										<h3>${store.storeName}</h3>
									</div>
								</div>

								<p style="padding-left: 10%; margin-bottom: 5px">Chủ store:
									${store.ownerName}</p>
								<p style="padding-left: 10%">
									<c:if test="${store.open == true}">
										<span class="label label-sm label-success"> Đang mở bán</span>
									</c:if>
									<c:if test="${store.open ==false}">
										<span class="label label-sm label-warning"> Đóng cửa</span>
									</c:if>
								</p>
							</div>
							<div class="header__menu">
								<a class="item__menu"
									style="font-size: 16px; color: #3366CC; background: #f5f5f5; display: inline-block; padding: 7px 26px 5px; margin-right: 6px; margin-bottom: 10px;"
									href="<c:url value='/admin/stores-detail?storeID=${store.storeId }'/>">Tất
									cả</a>

								<c:forEach var="cate" items="${categorys }">

									<a class="item__menu"
										style="font-size: 16px; color: #3366CC; background: #f5f5f5; display: inline-block; padding: 7px 26px 5px; margin-right: 6px; margin-bottom: 10px;"
										href="<c:url value='/admin/stores-detail?storeID=${store.storeId }&categoryID=${cate.cateid }&index=1'/>">${cate.namecate }</a>

								</c:forEach>
							</div>


							<div class="col-md-13" style="display: flex; flex-wrap: wrap;">
								<c:forEach items="${products}" var="item">
									<div class="form group"
										style="padding-left: 20px; padding-bottom: 20px">
										<tr class="odd gradeX">

											<c:url value="/image?fname=${item.img }" var="imgUrl"></c:url>
											<td><img height="150" width="200" src="${imgUrl}" /></td>
											<br />
											<td>${item.productName }</td>
											<br />
											<td>${item.price}</td>
											<br />
											<td><c:if test="${item.isSelling == false}">
													<span class="label label-sm label-success"> Ngừng
														bán</span>
												</c:if> <c:if test="${item.isSelling ==true}">
													<span class="label label-sm label-warning"> Đang bán
													</span>
												</c:if></td>
											<td><a
												href="<c:url value='/admin/product-edit?id=${item.productId }'/>"
												class="center">Edit</a> | <a
												href="<c:url value='/admin/product-delete?id=${item.productId }'/>"
												class="center">Delete</a></td>
										</tr>
									</div>
								</c:forEach>
							</div>

							<div class="col-md-6 col-sm-12" style="padding-top: 0">
								<ul class="pagination pull-right">
									<c:if test="${tag>1}">
										<c:if test="${cateid==null}">
											<li><a
												href="${pageContext.request.contextPath }/admin/stores-detail?storeID=${store.storeId }&index=${tag-1}">&laquo;</a></li>

										</c:if>
										<c:if test="${cateid!=null }">
											<li><a
												href="${pageContext.request.contextPath }/admin/stores-detail?storeID=${store.storeId }&categoryID=${cateid}&index=${tag-1}">&laquo;</a></li>
										</c:if>
									</c:if>
									<c:forEach begin="1" end="${endP}" var="i">


										<c:if test="${cateid==null}">
											<li class='${tag==i?"active":"" }'><a
												href="${pageContext.request.contextPath}/admin/stores-detail?storeID=${store.storeId }&index=${i}">${i}</a></li>

										</c:if>
										<c:if test="${cateid!=null }">
											<li class='${tag==i?"active":"" }'><a
												href="${pageContext.request.contextPath}/admin/stores-detail?storeID=${store.storeId }&categoryID=${cateid}&index=${i}">${i}</a></li>
										</c:if>

									</c:forEach>
									<c:if test="${tag<endP}">
										<c:if test="${cateid==null}">
											<li><a
												href="${pageContext.request.contextPath }/admin/stores-detail?storeID=${store.storeId }&index=${tag+1}">&raquo;</a></li>

										</c:if>
										<c:if test="${cateid!=null }">
											<li><a
												href="${pageContext.request.contextPath }/admin/stores-detail?storeID=${store.storeId }&categoryID=${cateid}&index=${tag+1}">&raquo;</a></li>
										</c:if>

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