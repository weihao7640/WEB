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


					<div class="page-header">
						<h2 class="header-title">Đơn hàng:</h2>
						<div class="header-sub-title">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb breadcrumb-dash list-inline">
									<li class="breadcrumb-item list-inline-item"><i
										class="anticon anticon-home m-r-5"></i> <a
										class="breadcrumb-item" asp-area="Admin" asp-controller="Home"
										asp-action="Index">Home</a></li>
									<li class="breadcrumb-item active list-inline-item"
										aria-current="page">Đơn hàng</li>
								</ol>
							</nav>
						</div>
					</div>

					<div class="card">
						<div class="card-body">
							<div class="row m-b-30">
								<div class="col-lg-8">
									<div class="d-md-flex">
										<div class="m-b-10">
											<select class="custom-select" style="min-width: 200px;"
												 id="yyyy" class="form-control-sm form-control" onchange="chuyenNam(this);">
									
												<option  selected>Chưa giao</option>
												<option  selected>Đã đóng gói </option>
												<option  selected>Chưa xác nhận</option>
												<option  selected>Đã xác nhận</option>
												<option  selected>Đang giao</option>
												<option selected>Đã giao</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="table-responsive">
								<table class="table table-hover e-commerce-table">
									<thead>
										<tr>
											<th>Người đặt</th>
											<th>Địa chỉ</th>
											<th>Số điện thoại</th>
											<th>Tổng tiền</th>
											<th>Ngày xuất hóa đơn</th>
											<th>Trạng thái đơn hàng</th>
											<th>Người giao hàng</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty donhang}">
											<c:forEach items="${donhang}" var="o">
												<tr>

													<td>${o.name}</td>
													<td>${o.diachi}</td>
													<td>${o.phone}</td>
													<td>${o.tong}</td>
													<td>${o.ngaytao}</td>
													<td>${o.status}</td>
													<td>${o.nameshipper}</td>





													<td>
														<div class="btn-group btn-group-sm ">
															<a href="Chitietdonhang?iddh=${o.oderid}">
																<button class="btn btn-primary ">
																	<ion-icon name="pencil-outline"></ion-icon>
																</button>
															</a> <a href="huy?iddh=${o.oderid}">
																<button class="btn btn-danger ">
																	<ion-icon name="trash-outline"></ion-icon>
																</button>
															</a>

														</div>
													</td>
												</tr>

											</c:forEach>
										</c:if>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div aria-label="Page navigation example">
						<ul class="pagination">

							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
							<c:forEach begin="1" end="${sotrang}" var="i">
								<li class="page-item"><a class="page-link"
									href="donhangseller?id=${i}">${i}</a></li>
							</c:forEach>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
						</ul>
					</div>

					<script>
						$(document)
								.ready(
										function() {
											jQuery("#trangthaidonhang")
													.change(
															function() {
																console.log("quyen");
																var trangthaidonhang = jQuery(
																		this)
																		.children(
																				":selected")
																		.attr(
																				"value");

																$(
																		'#trangthaidonhang option')
																		.removeAttr(
																				'selected');
																$(
																		"#trangthaidonhang > [value='"
																				+ trangthaidonhang
																				+ "']")
																		.attr(
																				"selected",
																				"true");
																$
																		.ajax({
																			url : "/donhangseller",
																			type : "GET",
																			data : {
																				trangthai : trangthaidonhang
																			},
																			async : true,
																			success : function(
																					results) {
																				if (results.status == "success") {
																					window.location.href = results.redirectUrl;
																				}
																			},
																			error : function(
																					xhr) {
																				alert('error');
																			}
																		});
															});

											$("#keyword")
													.keyup(
															function() {
																var strkeyword = $(
																		'#keyword')
																		.val();
																$
																		.ajax({
																			url : '/Admin/Search/FindProduct/',
																			datatype : "json",
																			type : "POST",
																			data : {
																				keyword : strkeyword
																			},
																			async : true,
																			success : function(
																					results) {
																				$(
																						"#records_table")
																						.html(
																								"");
																				$(
																						"#records_table")
																						.html(
																								results);
																			},
																			error : function(
																					xhr) {
																				alert('error');
																			}
																		});
															});
										});
					</script>

				</div>


<script>
	function chuyenNam(yyyy) {
        window.location="donhangseller?TT="+yyyy.value;
     }
	
	
	</script>

			</div>
			<!-- Content Wrapper END -->
			<!-- Footer START -->
			@await Html.PartialAsync("Footer.cshtml")
			<!-- Footer END -->



		</div>
		<!-- Page Container END -->
		<!-- Search Start-->
		<!-- Search End-->
		<!-- Quick View START -->
		<!-- Quick View END -->
	</div>
	</div>



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
