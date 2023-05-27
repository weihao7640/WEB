<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/css/admin/style.css"/>" rel="stylesheet"
	type="text/css">
	
	
	
	
	
	
<div class="nav-left-sidebar sidebar-dark" >
            <div class="menu-list">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="#">Menu</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <li class="nav-divider">
                                Menu
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="<c:url value="/admin/stores"/>" ><i class="fa fa-fw fa-user-circle"></i>Store</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/category"/>" ><i class="fa fa-fw fa-rocket"></i>Category</a>
                           </li>
                           <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/product"/>" ><i class="fa fa-fw fa-rocket"></i>Product</a>
                           </li>
                           <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/admin/user"/>" ><i class="fa fa-fw fa-rocket"></i>Users</a>
                           </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="<c:url value="/admin/order"/>" "><i class="fa fa-wpforms"></i>Đơn hàng</a>
                                
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" ><i class="fa fa-table"></i>Thống kê</a>
                                <div id="submenu-5" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">General Tables</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">Data Tables</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
