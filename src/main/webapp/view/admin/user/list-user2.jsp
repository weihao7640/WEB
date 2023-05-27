<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file='/view/admin/common/header.jsp'%>
<link rel="stylesheet" href="/css/admin/style.css">


<div class="page-content-wrapper" style="height: 565px; ">
	<div class="page-content">
		
		<div class="row" style="width: 100%">
		<div class="col-md-3">
		<%@ include file='/view/admin/common/left-tool.jsp'%>
		</div>
		<div class="col-md-9" style="padding-right:25px; padding-top: 25px">
			<table class="table table-striped table-bordered table-hover"
				id="sample_2">
				<thead>
					<tr>
						<th>Ảnh đại diện</th>
						<th>Tên người dùng</th>
						<th>Email</th>
						<th>Số điện thoại</th>
						<th>Điểm</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${users}">
						<tr class="odd gradeX">
							<td><c:url
									value="/image?fname=category/${item.avatar}"
									var="imgUrl"></c:url> <img width="50px" height="50px"
								src="${imgUrl}"></td>
							<td><a href="<c:url value='/admin/user/detail?userId=${item.userID }'/>">${item.name }</a></td>
							<td>${item.email }</td>
							<td>${item.phone }</td>
							<td>${item.point }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="col-md-6 col-sm-12" style="padding-top:0">
							<ul class="pagination pull-right">
								<c:if test="${tag>1}">
									<li><a
										href="${pageContext.request.contextPath }/admin/user/list?index=${tag-1}">&laquo;</a></li>
								</c:if>
								<c:forEach begin="1" end="${endP}" var="i">
									<li class='${tag==i?"active":"" }'><a
										href="${pageContext.request.contextPath}/admin/user/list?index=${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${tag<endP}">
									<li><a
										href="${pageContext.request.contextPath}/admin/user/list?index=${tag+1}">&raquo;</a></li>
								</c:if>
							</ul>
						</div>
			</div>
		</div>
		
	</div>
</div>


<%@ include file='/view/admin/common/footer.jsp'%>
