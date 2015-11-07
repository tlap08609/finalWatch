<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin-header.jsp"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>


<c:if test='${empty allMembers}'>
		查無會員資料<br>
</c:if>
<form action="adminUpdateMember" method="POST" class="form-horizontal"
	role="form">

	<table class='table table-bordered'>


		<thead>
			<tr>
				<th>會員資料</th>
				<th><input type="hidden" name="pk"     value="${mb.id}" ></th>
				<th><input type="hidden" name="id"     value="${mb.memberName}" ></th>
				<th><input type="hidden" name="finalDecision" value="" ></th>
			</tr>
		</thead>
		<c:if test='${not empty allMembers}'>
			<c:forEach var='mb' varStatus='vs' items='${allMembers}'>
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
						<td><a href='findMember.do?key=${mb.id}'>更新</a></td>
						<td>${mb.id}</td>
						<td>${mb.memberName}</td>
						<td>${mb.memberPs}</td>
						<td>${mb.memberEmail}</td>
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