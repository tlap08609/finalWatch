<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin-header.jsp"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<div class="container">
	<div class="row">
		<div class="col-md-12 tim">


			<div class="panel panel-default">
				<div class="panel-body">
					<h3>
						<span class="label label-default">新增</span>
					</h3>
					<form role="form" action="add.do" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="exampleInputEmail1">商品名稱</label> <input type="text"
								name="proNam" class="form-control" id="exampleInputEmail1"
								placeholder="輸入商品名稱">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">商品內容</label> <input
								type="text" name="proCon" class="form-control"
								id="exampleInputPassword1" placeholder="輸入商品內容">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">商品價格</label> <input
								type="text" name="proPri" class="form-control"
								id="exampleInputPassword1" placeholder="輸入商品價格">
						</div>

						<div class="form-group">
							<label for="exampleInputPassword1">商品庫存</label> <input
								type="text" name="proSto" class="form-control"
								id="exampleInputPassword1" placeholder="輸入商品庫存">
						</div>
						<div class="form-group">
							<label for="exampleInputFile">檔案上傳</label> <input
								name="productFile" type="file" id="exampleInputFile">
						</div>

						<button type="submit" class="btn btn-default">送出</button>
					</form>

				</div>
			</div>


		</div>
	</div>
</div>







<%@include file="admin-footer.jsp"%>