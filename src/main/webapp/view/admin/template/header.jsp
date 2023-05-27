<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid" >
                        <div class="header-wrap">
                            <form class="form-header" action="../admin/search" method="POST">
                                <input class="au-input au-input--xl" type="text" name="keysearch" id="keysearch" placeholder="Search for id, name, phong or email" />
                                <button class="au-btn--submit" type="submit">
                                    <i class="zmdi zmdi-search"></i>
                                </button>
                            </form>
                            <div class="header-button" style="padding-left:300px">
                                 <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                           <c:url value="/image?fname=${admin.avatar }"
													var="imgUrl"></c:url> <img width="50px" height="50px"
												src="${imgUrl}">
                                        </div>
                                        <div class="content">
                                            <a class="js-acc-btn" href="<c:url value="/admin/profile"/>">${admin.name }</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="<c:url value="/admin/profile"/>">
                                                        <c:url value="/image?fname=${admin.avatar }"
													var="imgUrl"></c:url> <img width="50px" height="50px"
												src="${imgUrl}">
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                        <a href="<c:url value="/admin/profile"/>">${admin.name }</a>
                                                    </h5>
                                                    <span class="email">${admin.email}</span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                    <a href="<c:url value="/admin/profile"/>">
                                                        <i class="zmdi zmdi-account"></i>Account</a>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__footer">
                                                <a href="<c:url value='/admin/logout'/>">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
        
        
        
    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>
  