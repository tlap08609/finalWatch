<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@include file="admin-header.jsp"%>
<c:if test='${empty allOrder}'>
		查無會員資料<br>
</c:if>
<form action="adminUpdateMember" method="POST" class="form-horizontal"
	role="form">

	<table class='table table-bordered'>


		<thead>
			<tr>
				<th>訂單資料</th>
				<th><input type="hidden" name="pk" <%-- value="${order.id}" --%>></th>
				<th><input type="hidden" name="id" <%-- value="${order.memberName}" --%>></th>
				<th><input type="hidden" name="finalDecision" value=""></th>
			</tr>
		</thead>
		<c:if test='${not empty allOrder}'>
			<c:forEach var='order' varStatus='vs' items='${allOrder}'>
				<c:if test='${vs.first}'>
					<c:out value="" escapeXml='false' />
					<c:out
						value="<tbody><tr class='warning'>
<th></th><th>編號</th>
					<th>帳號</th><th>密碼</th><th>email</th></tr></tbody>"
						escapeXml='false' />
				</c:if>
				<tbody>
					<tr>
						<td><a><%-- <a href='findMember.do?key=${order.orderNo}'> --%>刪除</a></td>
						<td>${order.orderNo}</td>
						<td>${order.userId}</td>
						<td>${order.totalAmount}</td>
						<td>${order.shippingAddress}</td>
						<td>${order.bno}</td>
						<td>${order.invoiceTitle}</td>
						<td>${order.orderDate}</td>
						<td>${order.shippingDate}</td>
						<td>${order.cancelTag}</td>
						
					</tr>
				</tbody>
				<c:if test='${vs.last}'>
					<c:out value='</table>' escapeXml='false' />
				</c:if>
			</c:forEach>
		</c:if>
		</form>
		<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle
			Menu</a>
		<%@include file="admin-footer.jsp"%>