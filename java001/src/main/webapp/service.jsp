<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<script>
	$(function() {
		var $hr = $('.hrGroup');
		var $min = $('.minGroup');
		var $sec = $('.secGroup');
		var mon, dat, hou, minu;
		var h = 0, m = 0;
		var fnc = function() {
			var d = new Date();
			var hr = d.getHours() + d.getMinutes() / 60;
			var min = d.getMinutes();
			var sec = d.getSeconds() + d.getMilliseconds() / 1000;
			if (h == hou && m == minu) {
			} else {
				$hr.css('transform', 'rotate(' + (hr * 30) + 'deg)');
				$min.css('transform', 'rotate(' + (min * 6) + 'deg)');
				$sec.css('transform', 'rotate(' + (sec * 6) + 'deg)');

				setTimeout(fnc, 50);
			}

		};

		fnc();

		var doSearch = function() {
			var $hr2 = $('.hrGroup2');
			var $min2 = $('.minGroup2');
			var $sec2 = $('.secGroup2');
			var min2 = $('#minn').val();
			var hr2 = 3 + $('#hrr').val() / 60;
			var sec2 = 0;
			var month = $('#month').val();
			var day = $('#day').val();
			var getMonth = $('.getMonth');
			var getDate = $('.getDate');

			$hr2.css('transform', 'rotate(' + (hr2 * 30) + 'deg)');
			$min2.css('transform', 'rotate(' + (min2 * 6) + 'deg)');
			$sec2.css('transform', 'rotate(' + (0) + 'deg)');

		};
		/* 		$('#send').click(doSearch);
		 $('.btn').click(function() {
		 alert('已收到您的預約，我們會盡快與您連絡！');

		 }); */

	});
</script>

<!-- 內容請填在這，填完視情況把style的tim刪掉 -->
<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body" style="color: black">

					<h1 style="color: black">維修服務</h1>
					<br>
					<h2>預約到店時間</h2>
					<p>您可選擇預約到店時間，好讓我們為您提供個人的維修服務。</p>
					<form id="serviceForm" class="form-horizontal" method="post"
						action="serviceMail">
						<div class="form-group">
							<label for="name" class="col-md-3 control-label ">姓名</label>
							<div class="col-md-4 ">
								<input type="text" class="form-control" id="name" name="name">

							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label ">Email</label>
							<div class="col-md-4 ">
								<input type="email" class="form-control" id="email" name="email">
							</div>
						</div>


						<div class="form-group">
							<label for="address" class="col-md-3 control-label ">來店時間</label>
							<div class="col-md-4">
								<textarea class="form-control" name="service_time"
									id="service_address"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="explanation" class="col-md-3 control-label ">手錶說明</label>
							<div class="col-md-4">
								<textarea class="form-control" id="problem" name="problem"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-4 text-center">
								<input class="btn" type=submit value="送出" onclick="">
							</div>
						</div>




						<h3>商品維修流程</h3>
						本專賣店之商品均附有產品保固卡，皆享有保固服務，請直接與維修售後聯<br>繫。
						<h3>商品維修注意事項</h3>
						故障品送修請務必妥善包裝，若是於運送過程中因包裝問題造成損壞的部分<br>，您需自行承擔損 失，再請見諒。
						維修商品若已超過保固期或因人為造成<br>之損壞，將視情況酌收費用，維修售後服務中心會先與 您聯繫報價後，再<br>依意願進行維修或寄回。
						維修及零配件寄送運費，依維修售後服務中心報<br>價為主。


					</form>
					<div class="clock">
						<div class="hrGroup">
							<div class="hrHand"></div>
						</div>
						<div class="minGroup">
							<div class="minHand"></div>
						</div>
						<div class="secGroup">
							<div class="secHand"></div>
						</div>
					</div>




				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>