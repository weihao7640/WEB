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
 <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
<style>
        svg {
          margin-bottom: 2em;
        }

        .rating__background {
          fill: gray;
          stroke: red;
          stroke-width: 1;
          height: 100%;
          width: 100%;
        }

        .rating__value {
          fill: #FFB94B;
          height: 100%;
        }

    </style>
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
				<div class="main-content">

					<div class="row">
						<div class="col-md-6 col-lg-3">
							<div class="card">
								<div class="card-body">
									<div class="media align-items-center">
										<div class="avatar avatar-icon avatar-lg avatar-blue">
											<ion-icon style="font-size:30px" name="cash-outline"></ion-icon>
										</div>
										<div class="m-l-15">
											<h2 class="m-b-0">${doanhthu}</h2>
											<p class="m-b-0 text-muted">Doanh Thu</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-lg-3">
							<div class="card">
								<div class="card-body">
									<div class="media align-items-center">
										<div class="avatar avatar-icon avatar-lg avatar-cyan">
											<ion-icon style="font-size:30px" name="star-half-outline"></ion-icon>
										</div>
										<div class="m-l-15">
										<h2 class="m-b-0">${shop.rating}</h2>
											<svg width="120px" height="22px" viewBox="0 0 1000 200" class='rating'>
                                                <defs>

                                                    <polygon id="star" points="100,0 131,66 200,76 150,128 162,200 100,166 38,200 50,128 0,76 69,66 " />

                                                    <clipPath id="stars">
                                                        <use xlink:href="#star" />
                                                        <use xlink:href="#star" x="20%" />
                                                        <use xlink:href="#star" x="40%" />
                                                        <use xlink:href="#star" x="60%" />
                                                        <use xlink:href="#star" x="80%" />
                                                    </clipPath>

                                                </defs>

                                                <rect class='rating__background' clip-path="url(#stars)"></rect>

                                                <!-- Change the width of this rect to change the rating -->
                                               
                                                    
                                              
                                                <rect width="${shop.rating/5*100}%" class='rating__value' clip-path="url(#stars)"></rect>

                                            </svg>
											
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-lg-3">
							<div class="card">
								<div class="card-body">
									<div class="media align-items-center">
										<div class="avatar avatar-icon avatar-lg avatar-gold">
											<ion-icon style="font-size:30px" name="calendar-outline"></ion-icon>
										</div>
										<div class="m-l-15">
											<h2 class="m-b-0">${sl_dh}</h2>
											<p class="m-b-0 text-muted">Số đơn hàng</p>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-lg-3">
							<div class="card">
								<div class="card-body">
									<div class="media align-items-center">
										<div class="avatar avatar-icon avatar-lg avatar-purple">
											<ion-icon style="font-size:30px" name="people-circle-outline"></ion-icon>
										</div>
										<div class="m-l-15">
											<h2 class="m-b-0">${follow}</h2>
											<p class="m-b-0 text-muted">Số người theo dõi</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
						<div class="card">
						<div class="card-body">
							<div class="row m-b-30">
								<div class="col-lg-8">
									<div class="d-md-flex">
										<div class="m-b-10">
											<select class="custom-select" style="min-width: 200px;" id="yyy" name="trangthaidonhang" onchange="chuyenNam(this);">
												<option selected>Chọn năm</option>
												<c:forEach items="${dsnam }" var="nam">
												<option value="${nam }">${nam }</option>
												</c:forEach>
												
											</select>
										</div>
									</div>
								</div>
							</div>
					<div class="row">
						<div class="col-md-12 col-lg-12">
							<canvas id="doanhthu"></canvas>
						</div>
						<div class="col-md-12 col-lg-4">
							<div class="card">

								<div class="card-body">

									<div class="d-flex justify-content-between align-items-center">
										
									</div>
									<c:forEach items="${doanhthu_T}" var="o">
									<div class="m-t-15" style="height: 5px">
										<p>Tháng : ${o}</p>
									</div>
									</c:forEach>
								
									<div class="m-t-30" style="height: 5px">
										<br />
									</div>
									<div class="d-flex justify-content-between align-items-center">
										<div>
											<h2 class="m-b-0">Tổng năm: ${doanhthunam}VND</h2>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-12 col-lg-8">
							<div class="card">
								<div class="card-body">
									<div class="d-flex justify-content-between align-items-center">
										<h5>Các mặt hàng bán chạy</h5>
									</div>
									<div class="m-t-30">
										<div class="table-responsive">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>Mặt hàng</th>
														<th>Tên Mặt hàng</th>
														<th>Đã bán</th>
														<th>Giá bán</th>
														<th style="max-width: 70px">Còn lại</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${listtop6}" var="o">
													<tr>
														<td>
															<div class="media align-items-center">
																<div class="avatar avatar-image rounded">
																<c:url value="/image?fname=${o.img}" var="imgUrl"></c:url>
													<img class="img-fluid rounded" src="${imgUrl}"
													style="width: 60px;">	
																
																</div>
																
															</div>
														</td>
														<td>
																	<span>${o.namePro}</span>
																</td>
														<td>${o.sold }</td>
														<td>${o.price} VND</td>
														<td>
															<div class="d-flex align-items-center">
																<div class="m-l-10">
																	${o.quan}</div>
															</div>
														</td>
													</tr>
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
			<!-- Page Container END -->
			<!-- Search Start-->
			<!-- Search End-->
			<!-- Quick View START -->
			<!-- Quick View END -->
		</div>
	</div>
	<!-- page js -->
	<script>
        var bienx = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'];
        var bieny = [${doanhthu_T[0]}+1,${doanhthu_T[1]}+1,${doanhthu_T[2]}+1,${doanhthu_T[3]}+1,${doanhthu_T[4]}+1,${doanhthu_T[5]}+1,${doanhthu_T[6]}+1,${doanhthu_T[7]}+1,${doanhthu_T[8]}+1,${doanhthu_T[9]}+1,${doanhthu_T[10]}+1,${doanhthu_T[11]}+1];
        var CHART = document.getElementById('doanhthu').getContext('2d');
        var line_chart = new Chart(CHART, {
            type: 'line',
            data: {
                labels: bienx,
                datasets: [{
                    label: "Doanh thu biến động theo tháng",
                    data: bieny
                }]
            }
        })

    </script>

<script>
	function chuyenNam(yyyy) {
        window.location="./homeseller?storeid="+${store.storeId}+"&YearSelected="+yyyy.value;
     }
	
	
	</script>

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
