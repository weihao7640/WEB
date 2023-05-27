<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <div class="logo logo-dark bg-gray text-center img-fluid">
        <a class="align-items-center" >
            <img class="w-auto rounded justify-content-center" src="image/logo.webp" alt="Responsive image" />
        </a>
    </div>
    <div class="nav-wrap">
        <ul class="nav-left">
            <li class="desktop-toggle">
                <a href="javascript:void(0);">
                    <i class="anticon"></i>
                </a>
            </li>
            <li class="mobile-toggle">
                <a href="javascript:void(0);">
                    <i class="anticon"></i>
                </a>
            </li>
        </ul>
        <ul class="nav-right">
                <li class="dropdown dropdown-animated scale-left">
                    <div class="pointer" data-toggle="dropdown">
                        <div class="avatar avatar-image  m-h-10 m-r-15">
                            <c:url value="/image?fname=${store.avatar }"
													var="imgUrl"></c:url> <img width="50px" height="50px"
												src="${imgUrl}">
                        </div>
                    </div>
                    <div class="p-b-15 p-t-20 dropdown-menu pop-profile">
                        <a href="./profile" class="dropdown-item d-block p-h-15 p-v-10">
                           <div>
                                   
                                    <span class="m-l-10">Thông tin cửa hàng</span>
                                </div>
                        </a>
                        <a class="dropdown-item d-block p-h-15 p-v-10" href="<c:url value='/home'/>">
                            <div class="d-flex align-items-center justify-content-between">
                            
                                <div>
                                   
                                    <span class="m-l-10">Trở về trang người dùng</span>
                                </div>
                              
                            </div>
                        </a>
                    </div>
                </li>
           
           


        </ul>
    </div>
</div>

