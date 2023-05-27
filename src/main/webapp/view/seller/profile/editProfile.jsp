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
	<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">

					<div class="row" style="width: 100%">
			<div class="col-md-12">
				<div class="col-md-10" style="padding-left:20%">
				<div class="card">
                                    <div class="card-header">
                                        <strong>Profile</strong>
                                        <small id="userid"> ${store.storeId }</small>
                                        
                                    </div>
                                    <div class="card-body card-block">
                                    <form action="profile-edit" method="post" enctype="multipart/form-data">
                                    <c:url value="/image?fname=${store.avatar }"
													var="imgUrl"></c:url> <img width="100px" height="150px"
												src="${imgUrl}">
                        
                                    <input type="file"
							class="form-control" name="images" id="images"
							value="${store.avatar}" />
                                    <div style="padding-left: 20px">
                                        <div class="form-group">
                                            <label for="name" class=" form-control-label">Tên shop:</label>
                                            <input type="text" name="name" id="name" value="${store.storeName }" class="form-control">
                                        </div>
                                        <div class="form-check form-check-inline">
						<label for="isDel">Status:</label> <input id="isDel"
							class="form-check-input" type="radio" name="isDel"
							${store.open?'checked':''} value="false"> <label
							for="isDel" class="form-check-label">Đóng cửa</label> <input
							id="isDel" class="form-check-input" type="radio" name="isDel"
							${!store.open?'checked':''} value="true"> <label
							for="statusoff" class="form-check-label">Mở cửa</label>
					</div>
                                    </div>
                                    <div class="card-body">
                                        <button class="btn btn-success" type="submit">Lưu thông tin chính sửa</button>
                                      <a href="<c:url value="/profile"/>"  ><button type="button" class="btn btn-danger">Hủy</button></a>
                                         </div>
                                         </form>
                                    </div>
                                    
                                         
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