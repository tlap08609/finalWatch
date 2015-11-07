<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin-header.jsp"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body">
				
<h3> <span class="label label-default">商品管理</span></h3><a href="AddCart.jsp"><button type="button" class="btn btn-primary">新增</button></a>
					<table class='table table-bordered' style="color: black">
						<c:if test='${not empty allProduct}'>
							<c:forEach var='pro' varStatus='vs' items='${allProduct}'>
								<c:if test='${vs.first}'>
									<c:out value="" escapeXml='false' />
									<c:out
										value="<tbody><tr class='warning'>
<td>商品編號</td>
					<td>商品名稱</td><td>商品內容</td><td>價格</td><td>商品庫存</td><td>圖片</td><td>更新或刪除</td></tbody>"
										escapeXml='false' />
								</c:if>
								<tbody>
									<tr>
										<td>${pro.productNo}</td>
										<td>${pro.productName}</td>
										<td>${pro.productContent}</td>
										<td>${pro.productPrice}</td>
										<td>${pro.productStock}</td>
										<td><img height='100' width='80'
											src='${pageContext.servletContext.contextPath}/getImage?id=${pro.productNo}'>

										</td>
										<td><a href='findProduct.do?key=${pro.productNo}'>更新</a></td>
									</tr>
								</tbody>
								<c:if test='${vs.last}'>
									<c:out value='</table>' escapeXml='false' />
								</c:if>
							</c:forEach>
						</c:if>
					</table>

				</div>
			</div>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="pro" scope="request" />
			</c:if>
			</form>
		</div>
	</div>
</div>







<%@include file="admin-footer.jsp"%>