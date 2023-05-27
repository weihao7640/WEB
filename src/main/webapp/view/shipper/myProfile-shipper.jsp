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

					
				<div class="col-md-10" style="padding-left:20%">
				<div class="card">
                                    <div class="card-header">
                                        <strong>Profile</strong>
                                        <small> ${admin.userID }</small>
                                    </div>
                                    <div class="card-body card-block" style="display: flex">
                                    <div >
                                    <c:url value="/image?fname=${shipper.avatar }"
													var="imgUrl"></c:url> <img width="100px" height="150px"
												src="${imgUrl}">
                                    </div>
                                    <div style="padding-left: 20px">
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">Họ và tên: ${shipper.name }</label>
                                        </div>
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Số điện thoại: ${shipper.phone }</label>
                                        </div>
                                        <div class="form-group">
                                            <label for="street" class=" form-control-label">Email: ${shipper.email }</label>
                                        
                                        </div>
                                    </div>
                                    </div>
                                    <div class="card-body">
                                    <a href="<c:url value="./shipper-profile-edit"/>">    <button type="button" class="btn btn-secondary">Chỉnh sửa thông tin</button></a>
                                     <a href="<c:url value="./shipper-changePassword"/>">    <button type="button" class="btn btn-success">Đổi mật khẩu</button></a>
                                         </div>
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
