<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FeshFood.vn</title>
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<link rel="stylesheet" href="css/5.css">
<link rel="stylesheet" href="css/3.css">
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

<!-- Core css -->
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	<ul class="link">
		<li><a href="home">Trang Chủ ></a></li>
		<li><a href="">Đơn hàng</a></li>
	</ul>
	<div class="cart">
		<div class="title">
			<div class="khoi">
				<h2>Giỏ Hàng Của Bạn</h2>
			</div>
			<div class="ten_cot">
				<div class="sanpham">
					<h4>Sản phẩm</h4>
				</div>
				<div class="dongia">
					<h4>Đơn giá</h4>
				</div>
				<div class="soluong">
					<h4>Số lượng</h4>
				</div>
				<div class="thanhtien">
					<h4>Thành tiền</h4>
				</div>
			</div>
			<form action="ThanhToanGH" method="get">
				<c:forEach items="${listgh}" var="o">
					<div class="section">
						<div class="thongtinsp">
							<c:url value="/image?fname=${o.img}" var="imgUrl"></c:url>
							<img src="${imgUrl}" width="150px" alt="">
							<div class="xoa">
								<a href="chitiet?id=${o.productID}">${o.namepro}</a> <a
									href="Xoaitemcart?idsp=${o.productID}"><ion-icon
										name="close-outline"></ion-icon>xóa</a>
							</div>


						</div>
						<div class="dongiasp">
							<p id="gia">${o.price}</p>
						</div>
						<div class="soluong">
							<div class="nutmua">
								<div class="dulieu">
									<div class="group-form">
										<button type="button" onclick="tru()">-</button>
										<input onchange="nhap()" id="id1" type="number"
											value="${o.count}" min="0">
										<button type="button" onclick="cong()">+</button>
									</div>


								</div>

							</div>
						</div>



						<div class="tong">
							<p id="tong">${o.price*o.count}đ</p>
							<a href="ThanhToanGH?idsp=${o.productID}" class="btn btn-warning ">Thanh toán</a>
						</div>
					</div>
				</c:forEach>
			</form>

		</div>
	</div>
	<script>
		function nhap() {
			let x = document.getElementById("id1").value;

			Tong();

		}
		function tru() {
			let x = Number(document.getElementById("id1").value);
			if (x <= 0) {
				return x;
			} else {
				x -= 1;
				document.getElementById("id1").value = x;

			}
			Tong();

		}
		function cong() {
			let x = Number(document.getElementById("id1").value);
			console.log(x);
			x += 1;

			document.getElementById("id1").value = x;

			Tong();
		}
		function Tong() {
			let x = Number(document.getElementById("id1").value);
			let y = Number(document.getElementById("gia").innerHTML);
			let z = x * y;

			document.getElementById("tong").innerHTML = z.toLocaleString(
					'it-IT', {
						style : 'currency',
						currency : 'VND'
					});

			console.log(z)

		}
	</script>
</body>
</html>