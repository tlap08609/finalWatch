<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<!-- 內容請填在這，填完視情況把style的tim刪掉 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tim">


			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">請輸入驗證碼</h3>
				</div>
				<div class="panel-body">
					<form id="memberCheck" role="form-horizontal" name="form"
						action="memberLogin" method="post">
						<div class="form-group">
							<label style="color: black" for="exampleInputEmail1">輸入驗證碼</label><span
								style="color: red" class="info" id="id_info"></span> <input
								id="Check_ver" type="text" class="form-control" name="adId"
								placeholder="您好，請輸入驗證碼">
						</div>

						<button type="submit" class="btn btn-default">送出</button>
					</form>
				</div>
			</div>


		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>