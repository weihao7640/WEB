
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<link rel="stylesheet" href="css/1.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Fesh Food.vn</title>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>

	<div class="slider">
		<div class="swiper">

			<div class="swiper-wrapper">

				<div class="swiper-slide">
					<img src="image/slide4.jpg" width="100%" height="100%" alt="">
					<div class="layer">
						<p>THỰC PHẨM SẠCH TỐT CHO SỨC KHỎE</p>
					</div>
				</div>
				<div class="swiper-slide">
					<img src="image/slider3.png" width="100%" height="100%" alt="">
				</div>
				<div class="swiper-slide">
					<img src="image/slide2.webp" width="100%" height="100%" alt="">
				</div>
				<div class="swiper-slide">
					<img src="image/slide.jpg" width="100%" height="100%" alt="">
				</div>
				<div class="swiper-slide">
					<img src="image/slider.jpeg" width="100%" height="100%" alt="">
				</div>
			</div>

			<div class="swiper-pagination"></div>

			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
	<div class="banner">
		<img src="image/banner_1.webp" alt=""> <img
			src="image/banner_2.webp" alt=""> <img
			src="image/banner_3.webp" alt="">
	</div>
	<div class="tieude">
		<img src="image/title.webp" alt="">
		<h2>Sản phẩm bán chạy</h2>
		<ul class="danhmuc">
			<c:forEach items="${listcate}" var="o">
				<li><a href="home?cateid=${o.cateid}">${o.namecate} /</a></li>
			</c:forEach>
		</ul>
	</div>
	<div class="sanpham">
		<div id="content" class="menu">

			<c:forEach items="${listP}" var="o">
				<div class="menu-item">
					<a href="chitiet?id=${o.proid}"><c:url
							value="/image?fname=${o.img}" var="imgUrl"></c:url> <img
						src="${imgUrl}" width="190px" alt=""></a> <span
						class="item_text"> <a href="chitiet?id=${o.proid}">
							${o.namePro}</a>
					</span> <span class="item_gia"> ${o.price}/KG </span> <span
						class="item_daban"> Đã bán ${o.sold} </span> <a
						href="chitiet?id=${o.proid}">
						<div class="layer2">
							<div class="icon">
								<a href="GioHang?idsp=${o.proid}"><ion-icon
										name="cart-outline"></ion-icon></a>
							</div>
							<div class="icon">
								<ion-icon name="search-outline"></ion-icon>
							</div>


						</div>
					</a>
					<div class="after">35%</div>
				</div>
			</c:forEach>

		</div>
	</div>
	<ul class="pagination">

		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
		<c:forEach begin="1" end="${sotrang}" var="i">
			<li class="page-item"><a class="page-link" href="home?id=${i}">${i}</a></li>
		</c:forEach>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
	<div class="banner">
		<img src="image/banner_4.jpg" width="370px" alt=""> <img
			src="image/banner_5.jpg" width="370px" alt=""> <img
			src="image/banner_6.jpg" width="370px" alt="">
	</div>
	<div class="tieude">
		<img src="image/title.webp" alt="">
		<h2>Sản phẩm bán chạy</h2>

		<div class="giamgia">
			<div style="width: 420px; height: 615px; border: 1px solid red;"
				class="menu-item">
				<img src="image/sp11_1.webp" width="410px" alt=""> <span
					class="item_text"> <a href=""> ${o.namePro}</a>
				</span> <span class="item_gia"> 66.000/KG </span> <span class="item_daban">
					Đã bán 926 </span>
				<div class="layer2">
					<div class="icon">
						<ion-icon name="cart-outline"></ion-icon>
					</div>
					<div class="icon">
						<ion-icon name="search-outline"></ion-icon>
					</div>
				</div>
				<div class="after">35%</div>

			</div>
			<div class="giamgia_item">
				<c:forEach items="${listC}" var="o">
					<div class="menu-item">
						 <c:url value="/image?fname=${o.img}" var="imgUrl"></c:url> 
						<img src="${imgUrl}" width="190px" alt=""> <span
							class="item_text"> <a href="chitiet?id=${o.proid}">
								${o.namePro}</a>
						</span> <span class="item_gia"> ${o.price}/KG </span> <span
							class="item_daban"> Đã bán ${o.sold} </span> <a
							href="chitiet?id=${o.proid}">
							<div class="layer2">
								<div class="icon">
									<ion-icon name="cart-outline"></ion-icon>
								</div>
								<div class="icon">
									<ion-icon name="search-outline"></ion-icon>
								</div>

							</div>
						</a>
						<div class="after">35%</div>
					</div>
				</c:forEach>

			</div>

		</div>
	</div>

<jsp:include page="/common/footer.jsp"></jsp:include>
	<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
	<script>
		const swiper = new Swiper('.swiper', {
			autoplay : {
				delay : 5000,
				disableOnInteraction : false,
			},
			loop : true,
			pagination : {
				el : '.swiper-pagination',
				clickable : true,
			},
			navigation : {
				nextEl : '.swiper-button-next',
				prevEl : '.swiper-button-prev',
			},
		});
	</script>
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script module
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
		
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript">
		
	</script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript">
		
	</script>
</body>
</html>