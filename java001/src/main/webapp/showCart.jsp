<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@include file="/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
	$(document).ready(function() {
		$("span").zoom();
		console.log($("span"));
	});
</script>
<c:set var="funcName" value="CHE" scope="session" />
<!-- 判斷購物車內是否有商品 -->
<c:choose>
	<c:when test="${ShoppingCart.itemNumber > 0}">
		<!-- 購物車內有一項以上的商品 -->
		<c:set var="cartContent" value="購物車內有${ShoppingCart.itemNumber}項商品" />
	</c:when>
	<c:otherwise>
		<!-- 購物車內沒有商品 -->
		<c:set var="cartContent" value="您尚未購買任何商品" />
	</c:otherwise>
</c:choose>






<!-- 內容請填在這，填完視情況把style的tim刪掉 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body">
					<h3>
						<span class="label label-default">購物商城</span>
					</h3>
					<p align="right" style="color: black">${AppName}${cartContent}</p>
					<p align="right" style="color: black">
						金額小計:
						<c:out value="${ShoppingCart.subtotal}" default="0" />
					</p>
					<a href="<c:url value='ShowCartContent.jsp' />"><button
							type="button" class="btn btn-primary pull-right">購物清單</button></a>





					<%-- <TABLE width="820" style="background: #FFE4C4">
						<TR height='2'>
							<TH width="270">&nbsp;</TH>
							<TH width="280">&nbsp;</TH>
							<TH width="270">&nbsp;</TH>
						</TR>
						<TR height='10'>
							<TD width="240">&nbsp;</TD>
							<TD width="320" align='center'><FONT color='#8000FA'
								size='+2' style="font-weight: 900;"> ${AppName} </FONT></TD>
							<TD width="270" align='right'><FONT color='red' size='-1'>
									${cartContent} </FONT></TD>
						</TR>

						<TR height='2'>
							<TD width="270"><A
								href="<c:url value='../_04_ShoppingCart/ShowCartContent.jsp' />">購物清單</A></TD>
							<TD width="280">&nbsp;</TD>
							<TD width="270" align='right'><FONT color='red' size='-1'>金額小計:<c:out
										value="${ShoppingCart.subtotal}" default="0" /> 元
							</FONT></TD>
						</TR>
					</TABLE> --%>










					<hr>
					<c:if test='${not empty products_lp}'>
						<c:forEach var='mb' varStatus='vs' items='${products_lp}'>
						  <%-- <c:set var='zz'  value='${ mb}'  /> --%>
							<div class="col-md-4 portfolio-item ttt" style="color: black">
								<span class='zoom' id='ex1'> <img
									class="img-responsive tti" width="180" height='320' 
									src="${pageContext.servletContext.contextPath}/getImage?id=${mb.productNo}"
									alt="">
								</span>
								<h3>${mb.productName}</h3>
								<p>${mb.productContent}</p>
								<h4>價格：<fmt:formatNumber value="${mb.productPrice}"
									pattern="#,###,###" /> 元</h4>
								<p>庫存數量：${mb.productStock}</p>

								<FORM id="hiddencart" action="<c:url value='BuyBook.do' />"
									method="POST">
									<select name='qty'>
										<c:forEach var='x' begin='1' end='${mb.productStock}'>
											<option value='${x}'>${x}</option>

										</c:forEach>

									</select> </select>
									<!-- 這些隱藏欄位都會送到後端 -->
									<Input type='hidden' name='productNo' value='${mb.productNo}'>

									<Input type='hidden' name='productName'
										value='${mb.productName}'> <Input type='hidden'
										name='productPrice' value='${mb.productPrice}'> <Input
										type='hidden' name='productContent'
										value='${mb.productContent}'> <Input type='hidden'
										name='productStock' value='${mb.productStock}'> <Input
										type='hidden' name='pageNo' value='${param.pageNo}'>

									</p>
									<button type="submit" class="btn btn-danger">加入購物車</button>

									<!-- <Input type='submit' value='加入購物車'> -->
								</FORM>
							</div>
						</c:forEach>
					</c:if>





					<!-- <table class='table table-bordered' style="color: black">

						<thead>
							<tr>
								<th>商城</th>
							</tr>
						</thead>
						<c:if test='${not empty allProduct}'>
							<c:forEach var='mb' varStatus='vs' items='${allProduct}'>
								<c:if test='${vs.first}'>
									<c:out value="" escapeXml='false' />
									<c:out
										value="<tbody><tr class='warning'>
<td></td><td>編號</td>
					<td>帳號</td><td>密碼</td><td>email</td><td></td></tbody>"
										escapeXml='false' />
								</c:if>
								<tbody>
									<tr>

										<td>${mb.productNo}</td>
										<td>${mb.productName}</td>
										<td>${mb.productContent}</td>
										<td>${mb.productPrice}</td>
										<td>${mb.productStock}</td>
										<td><img height='100' width='80'
											src='${pageContext.servletContext.contextPath}/getImage?id=${mb.productNo}'></td>

									</tr>
								</tbody>
								<c:if test='${vs.last}'>
									<c:out value='</table>' escapeXml='false' />
								</c:if>
							</c:forEach>
						</c:if>

					</table> -->





				</div>

				<nav>
					<ul class="pager">
						<c:if test="${pageNo > 1}">
							<li><a href="<c:url value='ShowProductIndex?pageNo=1' />"><span
									aria-hidden="true">&larr;</span> 第一頁</a></li>
						</c:if>
						<c:if test="${pageNo > 1}">
							<li><a
								href="<c:url value='ShowProductIndex?pageNo=${pageNo-1}' />">上一頁</a></li>
						</c:if>
						<c:if test="${pageNo != totalPages}">
							<li><a
								href="<c:url value='ShowProductIndex?pageNo=${pageNo+1}' />">下一頁</a></li>
						</c:if>
						<c:if test="${pageNo != totalPages}">
							<li><a
								href="<c:url value='ShowProductIndex?pageNo=${totalPages}' />">最後一頁<span
									aria-hidden="true">&rarr;</span></a></li>
						</c:if>
						<div style="color: black">第${pageNo}頁 / 共${totalPages}頁</div>
					</ul>

				</nav>
			</div>
		</div>
	</div>
</div>



<jsp:include page="/footer.jsp"></jsp:include>


<!-- 
/*									購買數量: <select  name='qty'>
<script>



$(function(){

		//for(var a = 1 ; a<='${mb.productStock}' ; a++){
			
//			if(a='${mb.productStock}'){
//				break;
//			}
		//}
		for(var xx = 0 ; xx<=9 ; xx++){
			if(var yy < )
			$('select:eq('+xx+')')
		}
		//$("select").append('<option value=' + a + '>' + a + '</option>');
		//var tt = 1 ;
		//if(tt <= '${mb.productStock}'){
			//$("select").append('<option value=' + tt + '>' + tt + '</option>');
			//tt++;
		//}else{
			//tt='${mb.productStock}';
		//}
			
			
		//}

		
})									
</script>								
*/					


 -->