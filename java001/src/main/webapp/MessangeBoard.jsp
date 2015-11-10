<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!-- 內容請填在這，填完視情況把style的tim刪掉 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body">
					<h3>
						<span class="label label-default">討論區</span>
					</h3>
					<form action="" method="">
						<p>
							<label for="editor1">Editor 1:</label>
							<textarea cols="80" id="editor1" name="editor1" rows="10"></textarea>
						</p>
						<p>
							<input type="submit" value="Submit" />
						</p>
					</form>
					<script>
						CKEDITOR.replace('editor1');
					</script>

				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>