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
					<div class="section__content section__content--p30">
						<div class="container-fluid">

							<div class="row" style="width: 100%">
								<div class="col-md-12">
									<div class="col-md-10" style="padding-left: 20%">
										<div class="card">
											<div class="card-header">
												<strong>Profile</strong> <small> ${store.storeId }</small>
											</div>
											<div class="card-body card-block" style="display: flex">
												<div>
													<c:url value="/image?fname=${store.avatar}" var="imgUrl"></c:url>
													<img width="100px" height="150px" src="${imgUrl}">
												</div>
												<div style="padding-left: 20px">
													<div class="form-group" >
														<label for="company" class=" form-control-label">Họ
															và tên: ${store.storeName }</label>
													</div>
													<div class="form-group" style="margin-bottom: 1px">
														<label for="company" class=" form-control-label">Chủ store: ${store.ownerName }</label>
													</div>
													<div class="form-group" style="margin-bottom: 1px">
														<label for="company" class=" form-control-label">Điểm tích lũy: ${store.point }</label>
													</div>
													<div class="form-group" style="margin-bottom: 1px">
														<label for="company" class=" form-control-label">Đánh giá: ${store.rating }</label>
													</div>
													<div class="form-group" style="margin-bottom: 1px">
													<c:if test="${store.open==true }">
														<label for="company" class=" form-control-label">Trạng thái: Mở cửa</label>
														</c:if>
														<c:if test="${store.open==false }">
														<label for="company" class=" form-control-label">Trạng thái: Đóng cửa</label>
														</c:if>
													</div>
													
													
												</div>
											</div>
											<div class="card-body">
												<a href="<c:url value="/profile-edit"/>">
													<button type="button" class="btn btn-secondary">Chỉnh
														sửa thông tin</button>
												</a> 
											</div>
										</div>

									</div>

								</div>
							</div>

						</div>
					</div>
				</div>



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


