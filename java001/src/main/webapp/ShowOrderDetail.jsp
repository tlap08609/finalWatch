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
							<td colspan="7">
								<table class="table table-condensed" style="color: black">
									<tr>
										<td class="info">出貨地址:${Order.shippingAddress}</td>
										<td class="info">訂購日期:${Order.orderDate}</td>
										<td class="info">訂單編號:${Order.orderNo}</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>

							<td class="active">產品編號</td>
							<td class="active">商品敘述</td>
							<td class="active">購買數量</td>
							<td class="active">價格</td>
							<!-- <td class="active">寄送日期</td> -->
						</tr>
						<tr>
							<c:forEach var="item" varStatus="stat" items="${OrderItem}">
								<%-- ${OrderBean.orderitems} --%>

								<td class="active">${item.productNo}</td>
								<td class="active">${item.description}</td>
								<td class="active">${item.amount}</td>
								<td class="active"><fmt:formatNumber
										value="${item.unitPrice}" pattern="#,###,###" />元</td>
								<%-- <td class="active">${item.seqno}</td> --%>
						</tr>

						</c:forEach>
						<tr>
							<td colspan="7">
								<table class="table table-condensed" style="color: black">
									<tr>
										<td class="info">寄送狀態：<c:if test='${empty allOrder.shippingDate}'>
		未寄送<br>
											</c:if>${Order.shippingDate}</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<center>
						<a href="MemberSelfManage?memberId=${LoginOK.id}">回上一頁</a>&nbsp;&nbsp;<a
							href="index.jsp">回首頁</a>
					</center>



				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>