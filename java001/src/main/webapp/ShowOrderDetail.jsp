<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body">
					<table class="table table-condensed" style="color: black">
						<tr>
							<th><h3>${LoginOK.memberName}的訂單明細</h3></th>
						</tr>
						<tr>
							<td class="info">出貨地址:${Order.shippingAddress}</td>
							<td class="info">訂購日期:${Order.orderDate}</td>
							<td class="info">訂單編號:${Order.orderNo}</td>
						</tr>
						<tr>
							<td class="active">訂單編號</td>
							<td class="active">產品編號</td>
							<td class="active">商品敘述</td>
							<td class="active">購買數量</td>
							<td class="active">價格</td>
						</tr>
						<tr>
							<c:forEach var="item" varStatus="stat" items="${OrderItem}">
								<%-- ${OrderBean.orderitems} --%>
								<td class="active">${item.seqno}</td>
								<td class="active">${item.productNo}</td>
								<td class="active">${item.description}</td>
								<td class="active">${item.amount}</td>
								<td class="active">${item.unitPrice}</td>
						</tr>
						</c:forEach>

					</table>




				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>