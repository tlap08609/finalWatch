<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="today" class="java.util.Date" scope="session" />
<c:set var="funcName" value="CHE" scope="session" />
<script type="text/javascript">
	function cancelOrder() {
		if (confirm("確定取消此份訂單 ? ")) {
			// 接收此資料的Servlet會使用 finalDecision 參數的值
			document.forms[0].finalDecision.value = "CANCEL";
			return true;
		} else {
			return false;
		}
	}
	function reconfirmOrder() {
		if (confirm("確定送出此份訂單 ? ")) {
			// 接收此資料的Servlet會使用 finalDecision 參數的值
			document.forms[0].finalDecision.value = "ORDER";
			return true;
		} else {
			return false;

		}
	}
</script>
<!-- 內容請填在這，填完視情況把style的tim刪掉 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body" style="color: black">
					<h3>
						<span class="label label-default">個人資料</span>
					</h3>
					<hr>
					<FORM action="<c:url value='ProcessOrder.do' />" method="POST"
						id="OrderConfirm-form" role="form">
						<table class="table">

							<tr>
								<td class="success">會員名字：${LoginOK.memberName}</td>
								<td class="success">客戶Email：${LoginOK.memberEmail}</td>
								<td class="success">訂單日期：<fmt:formatDate value="${today}"
										pattern="yyyy-MM-dd" /></td>
							</tr>
							<tr>
								<td class="success" colspan='3' style="text-align: left;">
									出貨地址：
									<div class="form-group">
										<Input size="60" type="text" name="ShippingAddress" value=""
											class="form-control" placeholder="輸入你的地址">
									</div>
								</td>
							</tr>
							<tr>
								<td class="success" colspan='3' style="text-align: left;">
									統一編號：
									<div class="form-group">
										<Input size="10" type="text" name="BNO" value=""
											class="form-control" placeholder="輸入你要的統一編號">
									</div>
								</td>
							</tr>
							<tr>
								<td class="success" colspan='3' style="text-align: left;">
									發票抬頭：
									<div class="form-group">
										<Input type="text" name="InvoiceTitle" value=""
											class="form-control" placeholder="輸入你要的發票抬頭">
									</div>
								</td>
							</tr>
							<table class="table">
								<h3>
									<span class="label label-default">訂單資料</span>
								</h3>
								<hr>
								<tr>
									<Th>書籍名稱</Th>
									<Th>作者</Th>
									<Th>出版社</Th>
									<Th>數量</Th>
									<Th>小計</Th>
								</tr>

								<c:forEach varStatus="vs" var="anEntry"
									items="${ShoppingCart.content}">
									<TR>
										<TD>${anEntry.value.productName}</TD>
										<TD>${anEntry.value.productContent}</TD>
										<TD>${anEntry.value.price}</TD>
										<TD>${anEntry.value.qty}</TD>
										<TD><fmt:formatNumber
												value="${anEntry.value.price * anEntry.value.qty}"
												pattern="#,###,###" />元</TD>
									</TR>
								</c:forEach>

								<TR height='16'>
									<TD style="text-align: right;" colspan='4'>合計金額：</TD>
									<TD style="text-align: left;"><fmt:formatNumber
											value="${ShoppingCart.subtotal}" pattern="#,###,###" />元</TD>

								</TR>
								<TR>
									<TD colspan='4' style="text-align: right;">總計金額：</TD>
									<TD style="text-align: left; font-size: 11pt; color: #AA0200;"><fmt:formatNumber
											value="${ShoppingCart.subtotal + VAT }" pattern="#,###,###" />元</TD>

								</TR>
							</table>
						</table>




						<%-- <TABLE border='1' width="810" style="background: #F5EBFF; border-color: rgb(100, 100, 255); border-style: outset;">
							<TR>
								<TD
									style="text-align: left; border-color: #FFBD32; border-style: ridge;">會員名字：${LoginOK.memberName}</TD>
								<TD
									style="text-align: left; border-color: #FFBD32; border-style: ridge;">客戶Email：${LoginOK.memberEmail}</TD>
								<TD
									style="text-align: left; border-color: #FFBD32; border-style: ridge;">訂單日期：<fmt:formatDate
										value="${today}" pattern="yyyy-MM-dd" /></TD>
							</TR>
							<TR>
								<TD colspan='3'
									style="text-align: left; border-color: #FFBD32; border-style: ridge;">
									出貨地址：<Input style="background: #ECFFCD;" size="60" type="text"
									name="ShippingAddress" value="">
								</TD>
							</TR>


							<TR>
								<TD colspan='3'
									style="text-align: left; border-color: #FFBD32; border-style: ridge;">
									統一編號：<Input style="background: #ECFFCD;" size="10" type="text"
									name="BNO" value="">
								</TD>
							</TR>
							<TR>
								<TD colspan='3'
									style="text-align: left; border-color: #FFBD32; border-style: ridge;">
									發票抬頭：<Input style="background: #ECFFCD;" size="50" type="text"
									name="InvoiceTitle" value="">
								</TD>
							</TR>

							<TR>
								<TD colspan='3'>

									<TABLE>

										<TR>
											<TH style="text-align: center; font-size: 12pt;" width="350">書籍名稱</TH>
											<TH style="text-align: center; font-size: 12pt;" width="80">作者</TH>
											<TH style="text-align: center; font-size: 12pt;" width="80">出版社</TH>
											<TH style="text-align: center; font-size: 12pt;" width="60">數量</TH>
											<TH style="text-align: center; font-size: 12pt;" width="110">小計</TH>
										</TR>

										<c:forEach varStatus="vs" var="anEntry"
											items="${ShoppingCart.content}">
											<TR height='16'>
												<TD style="text-align: left; font-size: 11pt;">${anEntry.value.productName}</TD>
												<TD style="text-align: center; font-size: 11pt;">${anEntry.value.productContent}</TD>
												<TD style="text-align: center; font-size: 11pt;">${anEntry.value.price}</TD>
												<TD style="text-align: right; font-size: 11pt;">
													${anEntry.value.qty}</TD>
												<TD style="text-align: right; font-size: 11pt;"><fmt:formatNumber
														value="${anEntry.value.price * anEntry.value.qty}"
														pattern="#,###,###" />元</TD>
											</TR>
										</c:forEach>

										<TR height='16'>
											<TD style="text-align: right; font-size: 11pt;" colspan='5'>合計金額：</TD>
											<TD style="text-align: right; font-size: 11pt;"><fmt:formatNumber
													value="${ShoppingCart.subtotal}" pattern="#,###,###" />元</TD>

										</TR>
										<TR>
											<TD colspan='5' style="text-align: right; font-size: 11pt;">總計金額：</TD>
											<TD
												style="text-align: right; font-size: 11pt; color: #AA0200;"><fmt:formatNumber
													value="${ShoppingCart.subtotal + VAT }" pattern="#,###,###" />元</TD>

										</TR>
									</TABLE>

								</TD>
							</TR>

						</TABLE>
						<P /> --%>
						<INPUT  TYPE="hidden" name="finalDecision" value=""> <INPUT 
							TYPE="SUBMIT" name="OrderBtn" value="確定送出"
							onclick="return reconfirmOrder();" > 
							<INPUT TYPE="SUBMIT" 
							name="CancelBtn" value="取消訂單" onclick="return cancelOrder();">
					</FORM>

				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>