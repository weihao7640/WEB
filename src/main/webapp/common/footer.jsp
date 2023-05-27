<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
.footer
{
    position: relative;
    width: 100%;
    height: 500px;
    margin-top: 150px;
    background-color: #EEE;
}
.diachi
{

    top: 0;
    width: 500px;

}
.container1 {
    position: absolute;
    width: fit-content;
    height: fit-content;
    color: rgb(66, 62, 62);
    display: flex;
    margin-top: 70px;
    border-bottom: 1px solid #b3a3a3;
    padding-bottom: 100px;
    margin-left: 180px;
}
.phone
{
    padding-top: 25px;
}
.ds_anh>img{
    padding: 10px 5px;
}
.footer > img {
    position: absolute;
}

.ds_anh
{
    display: flex;
    margin-top: 20px;
}
.vechungtoi
{
    margin-left: 100px;
    list-style: none;
    margin-top: 35px;
}
.vechungtoi>li>a
{
    display: block;
    padding: 10px 0;
    text-decoration: none;
    color:rgb(54, 55, 54);
    font-size: 18px;
}
.vechungtoi>li>a:hover{
    color:#D92414;
}

.lienhe
{
    margin-top: 20px;
    list-style: none;

}.lienhe>input
{
    width: 150px;
    height: 40px;
    margin-top: 20px;
    margin-right: 0;
    padding: 10px;
}
.lienhe>button
{
    width: 50px;
    height: 40px;
    margin-left: -10px;
    background-color: #3F3FDB;
    border: 1px solid #3F3FDB;
    color:white;
    font-weight: bold;
}
.lienhe>button:hover{
    background-color: #3d3c3c;
}
.copyright
{
    position: absolute;
    color:white;
   top:330px;
    left: calc( 50% - 150px);
}</style> 
<div class="footer">
   

    <div class="container1">
        <div class="diachi">
            <img src="image/logo.webp" width="250px" alt="">
            <div class="phone">
                <ion-icon name="heart-outline"></ion-icon>
                Số 1,Võ Văn Ngân, Phường Linh Trung, Thành Phố Thủ Đức, Thành phố Hồ Chí Minh
            </div>
            <div class="phone">
                <ion-icon name="heart-outline"></ion-icon>
                0911950758
            </div>
            <div class="phone">
                <ion-icon name="heart-outline"></ion-icon>
                tranbuuquyen@gmail.com
            </div>
        </div>
        <ul class="vechungtoi">
            <li><h4>VỀ CHÚNG TÔI</h4></li>
            <li><a asp-controller="NguoiDungs" asp-action="Loadsanpham">Trang chủ</a></li>
            <li><a href="">Giới Thiệu</a></li>
            <li><a href="">Sản phẩm</a></li>
            <li><a href="">Tin Tức</a></li>
            <li><a href="">Liên hệ</a></li>
        </ul>
        <ul class="vechungtoi">
            <li><h4>CHÍNH SÁCH</h4></li>
            <li><a asp-controller="NguoiDungs" asp-action="Loadsanpham">Trang chủ</a></li>
            <li><a href="">Giới Thiệu</a></li>
            <li><a href="">Sản phẩm</a></li>
            <li><a href="">Tin Tức</a></li>
            <li><a href="">Liên hệ</a></li>
        </ul>
        <ul class="vechungtoi">
         
            
            <ul class="lienhe">
                <li><h4>THEO DÕI CHÚNG TÔI</h4></li>
                <input type="text" placeholder="Nhập địa chỉ gmail">
                <button>Gửi</button>
            </ul>
        </ul>


       
    </div>
</div>