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
							<td class="active">出貨地址:${OrderBean.shippingAddress}</td>
							<td class="active">訂購日期:${OrderBean.orderDate}</td>
							<td class="active">訂單編號:${OrderBean.orderNo}</td>
						</tr>
						<tr>
							<td class="active"></td>
							<td class="active"></td>
							<td class="active"></td>
							<td class="active"></td>
							<td class="active"></td>
						</tr>
						<tr>
							<td class="active"></td>
							<td class="active"></td>
							<td class="active"></td>
							<td class="active"></td>
							<td class="active"></td>
						</tr>
					</table>




				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>