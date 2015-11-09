<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="memberName" value="${ LoginOK.memberName }" />
<c:remove var="LoginOK" scope="session" />
<c:remove var="ShoppingCart" scope="session" />
<%-- <c:set var="funcName" value="OUT" scope="session" /> --%>

<!-- 內容請填在這，填完視情況把style的tim刪掉 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tim" style="color:white">
<%-- 			<c:set var="logoutMessage" scope="request">
			訪客${ memberName }，感謝您使用本系統。<BR>
您已經登出
			</c:set> --%>
			<%
				session.invalidate();
			%>
			<jsp:forward page="/index.jsp"/> 
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>