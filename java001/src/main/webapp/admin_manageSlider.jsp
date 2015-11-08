<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="admin-header.jsp"%>

<div class="panel panel-default">
	<div class="panel-body">
		<h3>
			廣告管理 <span class="label label-default">預覽</span>
		</h3>
		<hr>
		<div class="container ">
			<div class="row">
				<div class="col-md-4 tt1 ">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						</ol>
						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="images/slider/slide1.jpg" height="708" width="1170"
									alt="...">
								<div class="carousel-caption"></div>
							</div>
							<div class="item">
								<img src="images/slider/slide2.jpg" height="708" width="1170"
									alt="...">
								<div class="carousel-caption"></div>
							</div>
							<div class="item">
								<img src="images/slider/slide3.jpg" height="708" width="1170"
									alt="...">
								<div class="carousel-caption"></div>
							</div>
							<div class="item">
								<img src="images/slider/slide4.jpg" height="708" width="1170"
									alt="...">
								<div class="carousel-caption"></div>
							</div>
						</div>
						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"
							aria-hidden="true"></span> <span class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<!-- 操作列 -->
		<form action="upload.do" method="post" enctype="multipart/form-data">
			投影片一：<input type="file" name="file1" value="" /><br> 投影片二：<input
				type="file" name="file2" value="" /><br> 投影片三：<input
				type="file" name="file3" value="" /><br> 投影片四：<input
				type="file" name="file4" value="" /><br> <input
				type="submit" value="上傳" name="upload" />
		</form>








	</div>
</div>




<a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle
	Menu</a>

<%@include file="admin-footer.jsp"%>