<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!-- 這邊是投影片slider -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tt1">
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
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
</div>
<!-- slider以下 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 text-center">
			<h1>最新消息</h1>
			<hr>
		</div>
	</div>
</div>




<div class="container tt">
	<div class="row">
		<div class="col-md-4 portfolio-item">
			<a href="#"> <img class="img-responsive"
				src="http://placehold.it/700x400" alt="">
			</a>
			<h3>
				<a href="#">品牌Highlight e.g.男錶近期優惠</a>
			</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
				viverra euismod odio, gravida pellentesque urna varius vitae.</p>
		</div>
		<div class="col-md-4 portfolio-item">
			<a href="#"> <img class="img-responsive"
				src="http://placehold.it/700x400" alt="">
			</a>
			<h3>
				<a href="#">討論區2016即將上線！</a>
			</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
				viverra euismod odio, gravida pellentesque urna varius vitae.</p>
		</div>
		<div class="col-md-4 portfolio-item">
			<a href="#"> <img class="img-responsive"
				src="http://placehold.it/700x400" alt="">
			</a>
			<h3>
				<a href="#">請將建議留言給我們！（或是聊天室系統）</a>
			</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
				viverra euismod odio, gravida pellentesque urna varius vitae.</p>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
