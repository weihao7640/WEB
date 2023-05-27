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
						<h2 class="header-title">Home :</h2>
						<div class="header-sub-title">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb breadcrumb-dash list-inline">
									<li class="breadcrumb-item list-inline-item"><i
										class="anticon anticon-home m-r-5"></i></li>
									<li class="breadcrumb-item active list-inline-item"
										aria-current="page">Sản phẩm</li>
								</ol>
							</nav>
						</div>

					</div>
					<div class="card">
						<div class="card-body">
							<div class="row m-b-30">
								<div class="col-lg-8">
									<div class="d-md-flex">
										<div class="m-b-10 m-r-15">
											<select class="custom-select" id="txtMaDanhMuc"
												name="txtMaDanhMuc" style="min-width: 180px;"
												 id="yyyy" class="form-control-sm form-control" onchange="chuyenNam(this);">

												<c:forEach items="${listcate}" var="o">
													<option value="${o.cateid}" selected>${o.namecate}</option>
												</c:forEach>
								
											</select>
											
										</div>
									
									</div>
								</div>
								<div class="col-lg-4 text-right">
									<a class="btn btn-primary btn-tone" href="addsanpham"><ion-icon
											name="add-circle-outline"></ion-icon></i> <span>Thêm mặt
											hàng</span> </a>
								</div>
							</div>
							<div class="table-responsive">
								<table class="table table-hover e-commerce-table">
									<thead>
										<tr>
											<th>Tên Mặt Hàng</th>
											<th>Ảnh</th>
											<th>Giá bán</th>
											<th>Số sao</th>
											<th>Số lượng</th>
											<th>Số lượng đã bán</th>
											<th>Đang được bán</th>
											<th>Danh mục</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pro}" var="o">
											<tr>
												<td>${o.productName}</td>
												<td><c:url value="/image?fname=${o.img}" var="imgUrl"></c:url>
													<img class="img-fluid rounded" src="${imgUrl}"
													style="max-width: 60px;"></td>
												<td>${o.price}VND</td>
												<td>${o.rating}</td>
												<td>${o.quantity}</td>
												<td>${o.sold}</td>
												<td>${o.isSelling}</td>
												<td></td>


												<td>
													<div class="btn-group btn-group-sm ">

														<a href="product-edit?id=${o.productId}">
															<button class="btn btn-primary ">
																<ion-icon name="pencil-outline"></ion-icon>
															</button>
														</a> <a href="detail?masp=${o.productId}">
															<button class="btn btn-warning ">
																<ion-icon name="clipboard-outline"></ion-icon>
															</button>
														</a> <a href="product-delete?id=${o.productId}">
															<button class="btn btn-danger ">
																<ion-icon name="trash-outline"></ion-icon>
															</button>
														</a>


														<form>

															<div class="modal fade" id="deleteModal-@item.MaMatHang"
																role="dialog">
																<div class="modal-dialog">
																	<div class="modal-content">
																		<div class="modal-header">
																			<h5 class="modal-title" id="exampleModalLabel">Xóa
																				mặt hàng này</h5>
																			<button type="button" class="close"
																				data-dismiss="modal">
																				<span aria-hidden="true">&times;</span>
																			</button>
																		</div>
																		<div class="modal-body text-center">
																			<div class="warning">Bạn muốn xóa mặt hàng này?</div>
																			<div class="text-danger ">@item.MaMatHang :
																				@item.TenMatHang</div>

																		</div>
																		<div class="modal-footer">
																			<button type="button"
																				class="btn btn-default btn-tone"
																				data-dismiss="modal">Đóng</button>
																			<button type="submit" class="btn btn-danger btn-tone">Xóa</button>
																		</div>
																	</div>
																</div>
															</div>
														</form>
													</div>
												</td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<div aria-label="Page navigation example">
									<ul class="pagination">

										<li class="page-item"><a class="page-link" href="#">Previous</a></li>
										<c:forEach begin="1" end="${sotrang}" var="i">
											<li class="page-item"><a class="page-link"
												href="sanpham?id=${i}">${i}</a></li>
										</c:forEach>
										<li class="page-item"><a class="page-link" href="#">Next</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>



				</div>
				<!-- Content Wrapper END -->
				<!-- Footer START -->

				<!-- Footer END -->



			</div>
			<!-- Page Container END -->
			<!-- Search Start-->
			<!-- Search End-->
			<!-- Quick View START -->
			<!-- Quick View END -->
		</div>
	</div>

<script>
	function chuyenNam(yyyy) {
        window.location="sanpham?cateid="+yyyy.value;
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
