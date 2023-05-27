<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fesh food.vn</title>
    <link rel="stylesheet" href="css/2.css">
    <link href="css/app.min.css" rel="stylesheet">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <style>
    .shop
{
    margin-left: 150px;
    margin-right: 130px;
    padding:20px 20px;
    border:1px solid rgba(108, 104, 104, 0.2);
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
  .comment
  {
    padding:10px
  }
  .item-comment
  {
    
  }
  .item-comment img
  {
    border-radius: 50%;
  }
  .nick{
    display: flex;
  }
  .nick p
  {
    line-height: 15px;
    padding:0 0 0 10px;
  }
  .locsao>a{
    padding:20px 20px
  }
.shop img{
    border-radius: 50%;
}
.shop-content
{
    margin-left: 10px;
    padding:5px 0 0 0 ;
}
.shop-content>a{
    text-decoration: none;
}
.ttshop
{
    display: flex;
    padding-right: 150px;
    border-right: 1px solid rgba(108, 104, 104, 0.2);
}
.chitietshop
{
    display: flex  ;
}
.chitietshop span{
    color: #9BD031;
}
.chitietshop p{
    padding: 0 20px;
}	</style>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
    <ul class="link">
        <li><a href="home">Trang Chủ ></a></li>
        <li><a href="">Sản phẩm mới ></a></li>
        <li><a href="">${sp.namePro}</a></li>
    </ul>
    <c:if test="${not empty mess}">
				
					<div class="alert alert-success" role="alert">${mess}</div>
				
				</c:if>
    <div class="ten">
        <p>${sp.namePro}</p>
    </div>
    <div class="section_chinh">
        <div class="anh">
        <c:url value="/image?fname=${sp.img}" var="imgUrl"></c:url> 
        <img src="${imgUrl}"  alt="">
        </div>
        <div class="section_tuongtac">
            <div class="gia">
                <p id="gia">${sp.price}</p>
                Chưa bao gồm VAT-Còn hàng
            </div>
            <form class="nutmua" action="Thanhtoan" method="get">
                 <p>Số Lượng:<b id="soluong">1</b></p>
                <div class="dulieu">
                <div class="group-form">
                <button type="button" onclick="tru()">-</button>
                <input name="soluong" onchange="nhap()" id="id1" type="number" value="1" min="0">
                <button type="button"  onclick="cong()">+</button>
                </div>
                <div class="nutmua">
                    <button type="submit">Mua Ngay</button>
                </div>
            </div>
                  <div class="tong" style="margin-top:20px;"><h3>Tổng tiền:</h3><p style="margin-bottom:4px" id="tong">0 </p></div>
                
            </form>
           
        </div>
        <div class="anh_banner">
            <img src="image/anh.jpg" alt="">
        </div>
    </div>
    <div class="shop">
        <div class="ttshop">
        <c:url value="/image?fname=${st.avatar}" var="imgUrl"></c:url> 
        
        <img src="${imgUrl}" width="50px" height="50px" alt="">
        <div class="shop-content">
            <h3>${st.storeName}</h3>
             <c:if test="${empty flowed}">
            <a href="theodoi?id=${sp.proid}"><label class="badge badge-pill badge-cyan">Theo Dõi</label></a>
            </c:if>
            <c:if test="${not empty flowed}">
            <a href="huytheodoi?id=${sp.proid}"><label class="badge badge-pill badge-cyan">Đang Theo Dõi</label></a>
            </c:if>
        </div>
       
    </div>
    <div class="chitietshop">
        <p>Sản phẩm: <span>${slsp}</span></p>
        <p>Người theo dõi:  <span>${slflow}</span></p>
        <p>Đánh giá:  <span>${shop.rating}</span></p>
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
    <div class="thongtin">
        <div class="tieude2">
            <h5>Thông Tin Sản Phẩm</h5>
        </div>
        <div class="Mota">
            ${sp.des}
        </div>
    </div>
     <div class="thongtin">
        <div class="tieude2">
            <h3>Đánh giá</h3>

            <div class="sao"><svg width="120px" height="22px" viewBox="0 0 1000 200" class='rating'>
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
        <div class="locsao">
    
            <a href="locsao?sao=5" class="btn btn-outline-warning" >5 sao</a>
            <a href="locsao?sao=4" class="btn btn-outline-warning" >4 sao</a>
            <a href="locsao?sao=3" class="btn btn-outline-warning" >3 sao</a>
            <a href="locsao?sao=2" class="btn btn-outline-warning" >2 sao</a>
               <a href="locsao?sao=1" class="btn btn-outline-warning" >1 sao</a>
        </div>
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
    
   
	 <script>
         function nhap() {
        let x = document.getElementById("id1").value;
        document.getElementById("soluong").innerHTML = x;
        Tong();

    }
    function tru() {
        let x = Number(document.getElementById("id1").value);
        if (x <= 0) { return x; }
        else {
            x -= 1;
            document.getElementById("id1").value = x;
            document.getElementById("soluong").innerHTML = x;
        }
        Tong();
        
    }
    function cong() {
        let x = Number(document.getElementById("id1").value);
        console.log(x);
        x += 1;
    
        document.getElementById("id1").value = x;
        document.getElementById("soluong").innerHTML = x;
        Tong();
    }
    function Tong() {
        let x = Number(document.getElementById("id1").value);
        let y = Number(document.getElementById("gia").innerHTML.replace(/[,]+/g, ""));
        let z = x * y;

        document.getElementById("tong").innerHTML = z.toLocaleString('it-IT', { style: 'currency', currency: 'VND' });

        console.log(z)


    }
    </script>
</body>
</html>