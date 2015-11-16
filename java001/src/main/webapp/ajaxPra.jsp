<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<script>
$(function(){
	
	$('#updateUsername').submit(function(){
		$.ajax({
			url:'update',
			type:'post',
			dataType:'json',
			data:$('#updateUsername').serialize(),
			success:function(data){
				console.log(data);
				if(data.isValid){
					$('#displayName').html('your name is '+data.username);
					$('#displayName').slideDown(500);
				}else{
					alert('Please enter a valid username!!');
				}
			}
			})
		return false;
	})
	


}) 







</script>
<!-- 內容請填在這，填完視情況把style的tim刪掉 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body">
					<form id="updateUsername" class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search" name="username">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					
					<p id="displayName" style="color:black;"></p>
				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>