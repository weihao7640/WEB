<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
<style>
.shop {
	margin-left: 150px;
	margin-right: 130px;
	padding: 20px 20px;
	border: 1px solid rgba(108, 104, 104, 0.2);
	display: flex;
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

.comment {
	padding: 10px
}

.item-comment {
	
}

.item-comment img {
	border-radius: 50%;
}

.nick {
	display: flex;
}

.nick p {
	line-height: 15px;
	padding: 0 0 0 10px;
}

.locsao>a {
	padding: 20px 20px
}

.shop img {
	border-radius: 50%;
}

.shop-content {
	margin-left: 10px;
	padding: 5px 0 0 0;
}

.shop-content>a {
	text-decoration: none;
}

.ttshop {
	display: flex;
	padding-right: 150px;
	border-right: 1px solid rgba(108, 104, 104, 0.2);
}

.chitietshop {
	display: flex;
}

.chitietshop span {
	color: #9BD031;
}

.chitietshop p {
	padding: 0 20px;
}
</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Favicon -->
<link rel="shortcut icon" href="~/Adminassets/images/logo/favicon.png">

<!-- page css -->
<link href="css/bootstrap-datepicker.min.css" rel="stylesheet" />

<!-- CSS only -->
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
    <h2 class="header-title">Chi Tiết sản phẩm: </h2>
    <div class="header-sub-title">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb breadcrumb-dash list-inline">
                <li class="breadcrumb-item list-inline-item">
                    <i class="anticon anticon-home m-r-5"></i>
                    <a class="breadcrumb-item" >Home</a>
                </li>
                <li class="breadcrumb-item list-inline-item">
                    <a class="breadcrumb-item">Quản lý mặt hàng</a>
                </li>
                <li class="breadcrumb-item active list-inline-item" aria-current="page">
                    ${sp.productName}
                </li>
            </ol>
        </nav>
    </div>

</div>
<div class="page-header no-gutters has-tab">
    <div class="d-md-flex m-b-15 align-items-center justify-content-between">
        <div class="media align-items-center m-b-15">
            <div class="avatar avatar-image rounded" style="height: 70px; width: 70px">
            <c:url value="/image?fname=${sp.img}" var="imgUrl"></c:url>
													<img class="img-fluid rounded" src="${imgUrl}">
            </div>
            <div class="m-l-15">
                <h4 class="m-b-0">${sp.productName}</h4>
                <p class="text-muted m-b-0">Mã mặt hàng:${sp.productId}</p>
            </div>
        </div>
        <div class="m-b-15">
            <a asp-area="Admin" asp-controller="AdminMatHangs" asp-action="Edit" asp-route-id="@Model.MaMatHang" class="btn btn-primary">   
                Chỉnh sửa
                <i class="anticon anticon-edit"></i>
            </a>
        </div>
    </div>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#mathang-thongtin">Thông tin mặt hàng</a>
        </li>
       <li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#MatHang-Anh">Phản hồi của khách hàng</a></li>
    </ul>
</div>
<div class="container-fluid">
    <div class="tab-content m-t-15">
        <div class="tab-pane fade show active" id="mathang-thongtin">
            <div class="row">
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="media align-items-center">
                               
                                <div class="m-l-15">
                                    <p class="m-b-0 text-muted">
										${sp.rating}
                                    </p>
                                    <div class="star-rating m-t-5">
                                    
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
                                               
                                                    
                                              
                                                <rect width="${sp.rating/5*100}%" class='rating__value' clip-path="url(#stars)"></rect>

                                            </svg>
                                
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="media align-items-center">
                               
                                <div class="m-l-15">
                                    <p class="m-b-0 text-muted">Đã bán</p>
                                    <h3 class="m-b-0 ls-1">${sp.sold}</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="media align-items-center">
                               
                                <div class="m-l-15">
                                    <p class="m-b-0 text-muted">Đánh giá</p>
                                    <h3 class="m-b-0 ls-1">${slcmt}</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="media align-items-center">
                               
                                <div class="m-l-15">
                                    <p class="m-b-0 text-muted">Mặt hàng trong kho</p>
                                    <h3 class="m-b-0 ls-1">${sp.quantity}</h3>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Thông tin cơ bản</h4>
                    <div class="table-responsive">
                        <table class="product-info-table m-t-20">
                            <tbody>
                                <tr>
                                    <td>Giá bán:</td>
                                    <td class="text-dark font-weight-semibold">${sp.price}</td>
                                </tr>
                                
                                <tr>
                                    <td>Danh mục:</td>
                                    <td>${catename}</td>
                                </tr>
                              
                                <tr>
                                    <td>Trạng thái:</td>
                                    <td>
                                       	<c:if test="${sp.isSelling ==true}">
                                            <label class="badge badge-pill badge-cyan">Đang được bán</label>
                                       </c:if>
                                       
                                        <c:if test="${sp.isSelling ==false}">
                                             <label class="badge badge-pill badge-danger">Không được bán</label>
                                       </c:if>
                                           
                                       
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Thông tin chi tiết</h4>
                    <div class="table-responsive">
                        <table class="product-info-table m-t-20">
                            <tbody>
                               
                                <tr>
                                    <td>Nhà cung cấp :</td>
                                    <td>${shopname}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Mô tả</h4>
                </div>
                <div class="card-body">
                  ${sp.description}
                </div>
            </div>
        </div>
       <div class="tab-pane fade" id="MatHang-Anh">
								 <c:forEach items="${cmt}" var="o">
        <div class="comment">
          <div class="item-comment">
            <div class="nick">
             <c:url value="/image?fname=${o.avatar}" var="imgUrl"></c:url> 
            <img src="${imgUrl}" width="30px" height="30px" alt="">
            <div class="sao">
            <p >${o.name}</p>
           	<c:if test="${o.rating==1}">
					<a  ><ion-icon name="star"></ion-icon></a>
					<a  ><ion-icon name="star-outline"></ion-icon></a>
					<a  ><ion-icon name="star-outline"></ion-icon></a>
					<a  ><ion-icon name="star-outline"></ion-icon></a>
					<a ><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					
					
					<c:if test="${o.rating==2}">
					<a ><ion-icon name="star"></ion-icon></a>
					<a ><ion-icon name="star"></ion-icon></a>
					<a ><ion-icon name="star-outline"></ion-icon></a>
					<a  ><ion-icon name="star-outline"></ion-icon></a>
					<a><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					<c:if test="${o.rating==3}">
					<a ><ion-icon name="star"></ion-icon></a>
					<a  ><ion-icon name="star"></ion-icon></a>
					<a ><ion-icon name="star"></ion-icon></a>
					<a><ion-icon name="star-outline"></ion-icon></a>
					<a ><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					<c:if test="${o.rating==4}">
					<a ><ion-icon name="star"></ion-icon></a>
					<a ><ion-icon name="star"></ion-icon></a>
					<a  ><ion-icon name="star"></ion-icon></a>
					<a><ion-icon name="star"></ion-icon></a>
					<a  ><ion-icon name="star-outline"></ion-icon></a>
					</c:if>
					<c:if test="${o.rating==5}">
					<a  ><ion-icon name="star"></ion-icon></a>
					<a  ><ion-icon name="star"></ion-icon></a>
					<a  ><ion-icon name="star"></ion-icon></a>
					<a  ><ion-icon name="star"></ion-icon></a>
					<a ><ion-icon name="star"></ion-icon></a>
					</c:if>
        </div>
        </div>
            <div class="content">${o.content}</div>
          </div>
        </div>
       </c:forEach>

							</div>
    <div >
        <a  class="btn btn-primary">Quay Lại</a>
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
