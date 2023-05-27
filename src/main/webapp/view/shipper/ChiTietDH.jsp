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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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

			<jsp:include page="/view/shipper/commonseller/header.jsp"></jsp:include>
			<!-- Header END -->

			<!-- Side Nav START -->
			<jsp:include page="/view/shipper/commonseller/slider.jsp"></jsp:include>
			<!-- Side Nav END -->

			<!-- Page Container START -->
			<div class="page-container">

				<!-- Content Wrapper START -->
				<div class="main-content">

					<h1>Chi Tiết Đơn Hàng</h1>
					<div>
						<h4>Đơn Hàng</h4>
						<hr />
						<dl class="row">
							<dt class="col-sm-2">Địa Chỉ:</dt>
							<dd class="col-sm-10">${dh.diachi}</dd>
							<dt class="col-sm-2">Số điện thoại:</dt>
							<dd class="col-sm-10">${dh.phone}</dd>
							<dt class="col-sm-2">Tình trạng đơn Hàng:</dt>
							<dd class="col-sm-10">${dh.status}</dd>
							<dt class="col-sm-2">Tình trạng Thanh Toán:</dt>
							<dd class="col-sm-10">${dh.statusTT}</dd>
							<dt class="col-sm-2">Tổng:</dt>
							<dd class="col-sm-10">${dh.tong} VND</dd>
							<dt class="col-sm-2">Số DT người mua:</dt>
							<dd class="col-sm-10">${dh.phone}</dd>
							<dt class="col-sm-2">Người Nhận:</dt>
							<dd class="col-sm-10">${dh.name}</dd>
							<dt class="col-sm-2">Người giao hàng:</dt>
							<dd class="col-sm-10">${dh.nameshipper}</dd>
						</dl>
					</div>

					<form asp-action="Details">

						<c:if test="${dh.status.equals('Đang giao')}">
							<div class="form-group">
								<a href="dagiao?iddh=${dh.oderid}"  class="btn btn-primary">Đã giao</a>
							</div>
						</c:if>
						


					</form>
					

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
	<!-- page js -->
	


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

