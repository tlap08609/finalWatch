<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<jsp:useBean id="board" class="board.model.dao.BoardHibernateDAO"
	scope='page' />
<!-- 內容請填在這，填完視情況把style的tim刪掉 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body">
					<h3>
						<span class="label label-default">討論區</span>
					</h3>
					<hr>
					<c:choose>
						<c:when test="${not empty board}">

							<c:forEach var="aBean" items="${board.allBoards}">
								<table class="table table-bordered" style="color: black" tex>
									<tr>
										<td class="info" align="left">編號：${aBean.no}</td>
										<td class="info" align="left">會員名稱：${aBean.name}</td>
										<td class="info" align="left">發文時間：${aBean.time}</td>
									</tr>
									<tr>

										<td colspan="3" align="left">發言內容：${aBean.stringComment}</td>

									</tr>
									<tr>
										<td colspan="3">Email：${aBean.mail}</td>
									</tr>
								</table>
								<BR>
								<BR>
							</c:forEach>



						</c:when>
						<c:otherwise>
							<BR>
							<BR>
							<font>目前未有任何留言</font>
						</c:otherwise>
					</c:choose>

					<form id="board" action="MemberWrite" method="post">
						<input type="hidden" name="memberName"
							value="${LoginOK.memberName}"> <input type="hidden"
							name="memberEmail" value="${LoginOK.memberEmail}">
						<p>
							<label for="editor1" style="color:black">請留言:</label>
							<textarea cols="80" id="editor1" name="mainText" rows="10"></textarea>
						</p>
						<div class="form-group" align="right">

							<button type="submit" class="btn btn-default">送出</button>

						</div>
					</form>
					<script>
						CKEDITOR.replace('editor1');
						CKEDITOR.config.autoParagraph = false;

					</script>


				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>