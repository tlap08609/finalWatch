<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="header.jsp"%>
<script type="text/javascript">
function confirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='UpdateItem.do?cmd=DEL&bookID=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}
function modify(key, qty, index) {
	var x = "newQty" + index;
	var newQty = document.getElementById(x).value;
	if  (newQty < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newQty == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = qty;
		return ; 
	}
	if  (newQty == qty ) {
		window.alert ("新、舊數量相同，不必修改");
		return ; 
	}
	if (confirm("確定將此商品的數量由" + qty + " 改為 " + newQty + " ? ") ) {
		document.forms[0].action="<c:url value='UpdateItem.do?cmd=MOD&bookID=" + key + "&newQty=" + newQty +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = qty;
	}
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57)){
      return false;
   }
   return true;
}
function Checkout(qty) {
	if (qty == 0)  {
		alert("無購買任何商品，不需結帳");
		return false;
	}
	if (confirm("再次確認訂單內容 ? ") ) {
		return true;
	} else {
		return false;
	}
}
function Abort() {
	if (confirm("確定放棄購物 ? ") ) {
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
				<div class="panel-body">

					<c:choose>
						<c:when test="${ShoppingCart.subtotal > 0}">
							<c:set var="subtotalMessage"
								value="金額小計:${ShoppingCart.subtotal} 元" />
							<c:set var="subtotal" value="${ShoppingCart.subtotal}" />
						</c:when>
						<c:otherwise>
							<c:set var="subtotalMessage" value="金額小計:  0 元" />
							<c:set var="subtotal" value="0" />
						</c:otherwise>
					</c:choose>
					<h3>
						<span class="label label-default">購物清單</span>
					</h3>
					<hr>
					<table class="table" style="color: black">

						<tr>
							<td class="info">手錶名稱</td>
							<td class="info">單價</td>
							<td class="info">數量</td>
							<td class="info">小計</td>
							<td class="info">修改</td>
						</tr>
						<c:forEach varStatus="vs" var="anEntry"
							items="${ShoppingCart.content}">
							<tr>
								<td class="active">${anEntry.value.productName}</td>
								<td class="active">${anEntry.value.price}</td>
								<td class="active"><Input id="newQty${vs.index}"
									style="width: 28px; text-align: right" name="newQty"
									type="text"
									value="<fmt:formatNumber value="${anEntry.value.qty}" />"
									name="qty" onkeypress="return isNumberKey(event)" /></td>
								<td class="active"><fmt:formatNumber
										value="${anEntry.value.price  * anEntry.value.qty}"
										pattern="#,###,###" /></td>
								<td class="active"><Input type="button" name="update"
									value="修改"
									onClick="modify(${anEntry.key}, ${anEntry.value.qty}, ${vs.index})">
									<Input type="button" name="delete" value="刪除"
									onClick="confirmDelete(${anEntry.key})"></td>

							</tr>
						</c:forEach>
						<tr>
							<td class="active" colspan='4' align='right'>合計金額：</td>
							<td class="active"><fmt:formatNumber value="${subtotal}"
									pattern="#,###,###" />元</td>

						</tr>

					</table>
					<table class="table" style="color: black">
						<tr>
							<td class="active" align='center'><a
								href="<c:url value='../_03_listBooks/DisplayPageProducts?pageNo=1' />"><button type="button" class="btn btn-default">繼續購物</button></a></td>
							<td class="active" align='center'><a
								href="<c:url value='checkout.do' />"
								onClick="return Checkout(${subtotal});"><button
										type="button" class="btn btn-success">再次確認</button></a></td>
							<td class="active" align='center'><A
								href="<c:url value='abort.do' />" onClick="return Abort();"><button type="button" class="btn btn-warning">放棄購物</button></A></td>

						</tr>



					</table>
					<%-- <TABLE border='2' width="820" style="color:black" >
							<TR>
								<TD colspan='4'>
									<!--          購物車的標題          -->
									
									<TABLE width="820">
										<TR height='40'>
											<TD width="270">&nbsp;</TD>
											<TD width="280" align='center'><FONT size='+2'>${AppName}</FONT></TD>
											<TD width="270" align='right'></TD>
										</TR>
										<TR height='18'>
											<TD width="270">&nbsp;</TD>
											<TD width="280" align='center'><FONT size='+2'>購
													物 清 單</FONT></TD>
											<TD width="270" align='right'></TD>
										</TR>
									</TABLE>
								</TD>
							</TR>

							<TR>
								<TD><font size='-1' face='標楷體, Arial'>
										<TABLE border='1'>
											<TR>
												<TH width="280">手錶編號</TH>
												<TH width="70">手錶名稱</TH>
												<TH width="60">單價</TH>
												<TH width="60">數量</TH>
												<TH width="40">小計</TH>
												<TH width="110">修改</TH>
					
											</TR>
											<c:forEach varStatus="vs" var="anEntry"
												items="${ShoppingCart.content}">
												<TR height='16'>
													<TD>${anEntry.value.productName}</TD>
													<TD style="text-align: center;">${anEntry.value.productContent}</TD>
													<TD style="text-align: center;">${anEntry.value.price}</TD>
													<TD style="text-align: right;"><Input
														id="newQty${vs.index}"
														style="width: 28px; text-align: right" name="newQty"
														type="text"
														value="<fmt:formatNumber value="${anEntry.value.qty}" />"
														name="qty" onkeypress="return isNumberKey(event)" /></TD>
													<TD style="text-align: right;"><fmt:formatNumber
															value="${anEntry.value.price  * anEntry.value.qty}"
															pattern="#,###,###" />元</TD>
													<TD><Input type="button" name="update" value="修改"
														onClick="modify(${anEntry.key}, ${anEntry.value.qty}, ${vs.index})">
														<Input type="button" name="delete" value="刪除"
														onClick="confirmDelete(${anEntry.key})"></TD>
												</TR>
											</c:forEach>
											<TR height='16'>
												<TD colspan='5' align='right'>合計金額：</TD>
												<TD align='right'><fmt:formatNumber value="${subtotal}"
														pattern="#,###,###" />元</TD>
												<TD align='right'>&nbsp;</TD>
											</TR>


										</TABLE>
								</font></TD>
							</TR>
							<TR height='80'>
								<TD>
									<TABLE border='1'>
										<TR>
											<TD width="260" align='center'><A
												href="<c:url value='../_03_listBooks/DisplayPageProducts?pageNo=1' />">繼續購物</A>
											</TD>
											<TD width="260" align='center'><A
												href="<c:url value='checkout.do' />"
												onClick="return Checkout(${subtotal});">再次確認</A></TD>
											<TD width="260" align='center'><A
												href="<c:url value='abort.do' />" onClick="return Abort();">放棄購物</A>
											</TD>
										</TR>
									</TABLE>
								</TD>
							</TR>
						</TABLE>
					

					<form>
						<input type="hidden" name="a" />
					</form> --%>











				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>