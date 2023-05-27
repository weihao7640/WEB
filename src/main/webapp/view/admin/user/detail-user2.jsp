<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file='/view/admin/common/header.jsp'%>
<link rel="stylesheet" href="/css/admin/style.css">

<div class="page-content-wrapper">
	<div class="page-content">

		<div class="row" style="width: 100%">
			<div class="col-md-3">
				<%@ include file='/view/admin/common/left-tool.jsp'%>
			</div>
			<div class="col-md-9"
				style="padding-right: 5px; padding-top: 25px; font-family: inherit;">
				<div style="border: 2px outset #eeeeee;">
					<div class="brg">
						<img src="image/brg/brg1.jpg" alt="">
					</div>
					<div class="title" style="display: flex">
						<c:url value="/image?fname=${user.avatar}" var="imgUrl"></c:url>
						<img width="100px" height="150px" src="${imgUrl}">
						<div style="width:100%">
							<p
								style="padding-left: 10%; text-align: center; margin-top: 20px; magrin-left: 10px">
							<h3>${user.name}</h3>
							</p>


							<p style="padding-left: 5px; margin-bottom: 5px">Số điện
								thoại: ${user.phone}</p>
							<p style="padding-left: 5px;">Email: ${user.email}</p>
							
							<c:if test="${storeID!=0 }">
							<div style="padding-left: 30%;"><a style=" border: 1px solid #EEEEEE; background-color: #EEEEEE; color: black" href="<c:url value='/admin/stores/detail?storeID=${storeID }'/>">Store của ${user.name }</a></div>
							</c:if>
							
							
							
						</div>


					</div>
					
					
				
				</div>
				<table class="table table-striped table-bordered table-hover"
					id="sample_2">
					<thead>
						<tr>
							<th>Mã đơn hàng</th>
							<th>Địa chỉ</th>
							<th>Trạng thái đơn hàng</th>
							<th>Tổng giá</th>
							<th>Cập nhật lần cuối</th>
							<th>Hành động</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${orders}">
							<tr class="odd gradeX">
								<td>${item.oderid}</td>
								<td>${item.diachi }</td>
								<td>${item.trangthai}</td>
								<td>${item.tong }</td>
								<td>${item.ngayup }</td>
								<td><a
									href="<c:url value='#'/>"
									class="center">Detail</a> | <a
									href="<c:url value='#'/>"
									class="center">Delete</a></td>
							</tr>
						</c:forEach>
						
						
						
						
						
						
					</tbody>
					<p></p>
				</table>
				<div class="col-md-6 col-sm-12" style="padding-top:0">
							<ul class="pagination pull-right">
								<c:if test="${tag>1}">
									<li><a
										href="${pageContext.request.contextPath }/admin/order/list?userId=${user.userID }&index=${tag-1}">&laquo;</a></li>
								</c:if>
								<c:forEach begin="1" end="${endP}" var="i">
									<li class='${tag==i?"active":"" }'><a
										href="${pageContext.request.contextPath}/admin/order/list?userId=${user.userID }&index=${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${tag<endP}">
									<li><a
										href="${pageContext.request.contextPath}/admin/order/list?userId=${user.userID }&index=${tag+1}">&raquo;</a></li>
								</c:if>
							</ul>
						</div>
			</div>

		</div>
	</div>
	<%@ include file='/view/admin/common/footer.jsp'%>