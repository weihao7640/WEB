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
				<div class="row m-t-25">
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c1">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-account-o"></i>
                                            </div>
                                            <div class="text">
                                                <h2>${countUsers }</h2>
                                                <span>Số tài khoản người dùng</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c2">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-shopping-cart"></i>
                                            </div>
                                            <div class="text">
                                                <h2>${countStores }</h2>
                                                <span>Số cửa hàng</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c3">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-calendar-note"></i>
                                            </div>
                                            <div class="text">
                                                <h2>${countOrderOfMonth }</h2>
                                                <span>Đơn hàng trong tháng</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-lg-3">
                                <div class="overview-item overview-item--c4">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-money"></i>
                                            </div>
                                            <div class="text">
                                                <h2>${sumOfMonth }</h2>
                                                <span>Tổng doanh thu trong tháng hiện tại</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
				
				
				<div class="au-card m-b-30">
                                    <div class="au-card-inner">
                                        <h3 class="title-2 m-b-40">Doanh thu năm ${nam }</h3>
                                      <%--   <select onchange="chuyenNam(this);" id="yyyy"	>
                                 
                                      <option value="${namhientai }">${namhientai }</option>
                                        <option value="${namhientai-1 }">${namhientai-1 }</option>
                                        </select> --%>
                                        <select name="selectSm" id="yyyy" class="form-control-sm form-control" onchange="chuyenNam(this);">
                                                        <option value="">Please select</option>
                                                        <option value="${namhientai }">${namhientai }</option>
                                                        <option value="${namhientai-1 }">${namhientai-1}</option>
                                                        <option value="${namhientai-2 }">${namhientai-2 }</option>
                                                        <option value="${namhientai-3 }">${namhientai-3 }</option>
                                                        <option value="${namhientai-4 }">${namhientai-4 }</option>
                                                    </select>
                                        <canvas id="chart1"></canvas>
                                    </div>
                                    
					</div>
				<div class="row">
                            <div class="col-lg-9">
                                <h2 class="title-1 m-b-25">Top sản phẩm bán chạy</h2>
                                <div class="table-responsive table--no-card m-b-40">
                                    <table class="table table-borderless table-striped table-earning">
                                        <thead>
                                            <tr>
                                                <th>Img</th>
                                                <th>Tên sản phẩm</th>
                                                <th>Đã bán</th>
                                                <th class="text-right">price</th>
                                                <th class="text-right">Danh mục</th>
                                                <th class="text-right">Cửa hàng</th>
                                            </tr>
                                        </thead>
                                        <tbody>
									<c:forEach var="item" items="${top10products}">
										<tr class="odd gradeX">
											<td><c:url value="/image?fname=${item.img }"
													var="imgUrl"></c:url> <img width="50px" height="50px"
												src="${imgUrl}"></td>
											<td>${item.productName }</td>
											<td>${item.sold}</td>
											<td>${item.price}</td>
											<td>${item.nameCategory }</td>
											<td>${item.nameStore }</td>
									</c:forEach>






								</tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <h2 class="title-1 m-b-25">Top stores</h2>
                                <div class="au-card au-card--bg-blue au-card-top-countries m-b-40">
                                    <div class="au-card-inner">
                                        <div class="table-responsive">
                                            <table class="table table-top-countries">
                                                <tbody>
									<c:forEach var="o" items="${top8stores}">
										<tr class="odd gradeX">
											<td>${o.storeName }</td>
											<td>${o.sumCost}</td>
									</c:forEach>






								</tbody>
                                            </table>
                                        </div>
                                    </div>
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



	<script>
		var bienx=['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
		var bieny=[${thang1},${thang2},${thang3},${thang4},${thang5},${thang6},${thang7},${thang8},${thang9},${thang10},${thang11},${thang12}];
		var CHART=document.getElementById('chart1').getContext('2d');
		var line_chart=new Chart(CHART,{
			type: 'line',
			data:{
					
					labels:bienx,
					datasets:[{
						label:'Doanh thu',
						data:bieny
						
					}]
			}
			
			
			
		})
		
	
	
	</script>
	<script>
	function chuyenNam(yyyy) {
        window.location="../admin/thongke?yyyy="+yyyy.value;
     }
	
	
	</script>

</body>
</html>