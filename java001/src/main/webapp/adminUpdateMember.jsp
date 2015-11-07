<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin-header.jsp"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
 <script type="text/javascript">
   function confirmDelete(userId){
	  var result = confirm("確定刪除此筆記錄(帳號:" + userId + ")?");
	  if (result) {
		  document.forms[0].finalDecision.value = "DELETE";
	      return true;
	  }
	  return false;
  }
  function confirmUpdate(userId){
	  var result = confirm("確定送出此筆記錄(帳號:" + userId + ")?");
	  if (result) {
		  //document.forms[0].finalDecision.value = "UPDATE";
		  document.getElementById("manageMemberForm").elements["finalDecision"].value = "UPDATE";
		  console.log("log:"+document.forms[0].finalDecision.value);
	      return true;
	  }
	  return false;
  } 
</script> 


<Form id="manageMemberForm" class='center' Action="adminUpdateMember" method="POST">
	更新會員資料 <input type="hidden" name="pk" value="${mb.id}"> <input
		type="hidden" name="id" value="${mb.memberName}"> <input
		type="hidden" name="finalDecision" value="">
	<Table>
		<TR>
			<TD align="RIGHT">編號：</TD>
			<TD align="LEFT">${mb.id}</TD>
		</TR>
		<TR>
			<TD align="RIGHT">帳號：</TD>
			<TD align="LEFT"><input type="text" name="name"
				value="${mb.memberName}" size="30"> <font color='red'
				size='-3'>${error.memberName}</font></TD>
		</TR>

		<TR>
			<TD align="RIGHT">密碼：</TD>
			<TD align="LEFT"><input type="text" name="pswd"
				value="${mb.memberPs}"> <font color='red' size='-3'>${error.memberPs}</font>
			</TD>
		</TR>
		<TR>
			<TD align="RIGHT">email：</TD>
			<TD align="LEFT"><input type="text" name="email"
				value="${mb.memberEmail}" size="30"> <font color='red'
				size='-3'>${error.memberEmail}</font></TD>
		</TR>

		<TR>
			<TD colspan="2" align="center"><input type="submit" value="更新"
				name='updateBtn' onclick="return confirmUpdate('${mb.memberName}');">
				<input type="submit" value="刪除" name='deleteBtn'
				onclick="return confirmDelete('${mb.memberName}');"></TD>
		</TR>
	</Table>
	<c:if test="${not empty requestScope.modify}">
		<c:remove var="member" scope="request" />
	</c:if>
</Form>







<%@include file="admin-footer.jsp"%>