<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin-header.jsp"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<script type="text/javascript">
	function confirmDelete(proNo) {
		var result = confirm("確定刪除此筆記錄(帳號:" + proNo + ")?");
		if (result) {
			document.forms[0].finalDecision.value = "DELETE";
			console.log("log:" + document.forms[0].finalDecision.value);
			return true;
		}
		return false;
	}
	function confirmUpdate(proNo) {
		var result = confirm("確定送出此筆記錄(帳號:" + proNo + ")?");
		console.log(result);
		if (result) {
			
			//document.forms[0].finalDecision.value = "UPDATE";
			document.getElementById("manageProductForm").elements["finalDecision"].value = "UPDATE";
			//console.log("log:" + document.forms[0].finalDecision.value);
			return true;
		}
		return false;
	}
</script>


<Form id="manageProductForm" class='center' Action="adminUpdateProduct" enctype="multipart/form-data"
	method="POST">
	更新會員資料 <input type="hidden" name="pk" value="${pro.productNo}"> <input
		type="hidden" name="id" value="${pro.productName}"> <input
		type="hidden" name="finalDecision" value="">
	<Table>
		<TR>
			<TD align="RIGHT">編號：</TD>
			<TD align="LEFT">${pro.productNo}</TD>
		</TR>
		<TR>
			<TD align="RIGHT">商品名字：</TD>
			<TD align="LEFT"><input type="text" name="proNam"
				value="${pro.productName}" size="30"> <font color='red'
				size='-3'>${error.memberName}</font></TD>
		</TR>

		<TR>
			<TD align="RIGHT">商品內容：</TD>
			<TD align="LEFT"><input type="text" name="proCon"
				value="${pro.productContent}"> <font color='red' size='-3'>${error.memberPs}</font>
			</TD>
		</TR>
		<TR>
			<TD align="RIGHT">商品價格：</TD>
			<TD align="LEFT"><input type="text" name="proPri"
				value="${pro.productPrice}" size="30"> <font color='red'
				size='-3'>${error.memberEmail}</font></TD>
		</TR>
		<TR>
			<TD align="RIGHT">商品庫存：</TD>
			<TD align="LEFT"><input type="text" name="proSto"
				value="${pro.productStock}" size="30"> <font color='red'
				size='-3'>${error.memberEmail}</font></TD>
		</TR>

		<TR>
<label for="exampleInputFile">檔案上傳</label>
			<TD align="LEFT"> <input
				name="productFile" type="file" id="exampleInputFile"></TD>
		</TR>


		<TR>
			<TD colspan="2" align="center"><input type="submit" value="更新"
				name='updateBtn'
				onclick="return confirmUpdate('${pro.productName}');"> <input
				type="submit" value="刪除" name='deleteBtn'
				onclick="return confirmDelete('${pro.productName}');"></TD>
		</TR>
	</Table>
	<c:if test="${not empty requestScope.modify}">
		<c:remove var="member" scope="request" />
	</c:if>
</Form>







<%@include file="admin-footer.jsp"%>