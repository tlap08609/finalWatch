<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-12 col-md-offset-4 tim">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">管理者登入</h3>
				</div>
				<div class="panel-body">
					<form id="adminCheck" role="form-horizontal" name="form"
						action="adminLogin" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1" style="color:black">帳號</label><span
								style="color: red" class="info" id="id_info"></span> <input
								id="admin_username" type="text" class="form-control" name="adId"
								placeholder="請輸入帳號">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" style="color:black">密碼<span
								style="color: red" class="info" id="ps_info"></span></label> <input
								id="admin_password" type="password" class="form-control" name="adPs"
								placeholder="請輸入密碼">

						</div>
						<button type="submit" class="btn btn-default">送出</button>
					</form>
				</div>
			</div>



		</div>
	</div>
</div>
<!-- <script src="js/checkAdmin.js"></script> -->



<%@include file="footer.jsp"%>

