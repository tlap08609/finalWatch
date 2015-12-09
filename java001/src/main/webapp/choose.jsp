<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<script>

		$(function(){
			var p1 = 0;
			var p2 = 0;
			var p3 = 0;			
			var p4 = 0;
			var p5 = 0;
			var p6 = 0;
			$(".play1").click(
				function(){
					$(this).siblings('.play2').stop(true).animate({left:0,top:230},2000).removeClass('active');
					$(this).siblings('.play3').stop(true).animate({left:0,top:450},2000).removeClass('active');
					if(p1==0){
						$(this).addClass('.active');
						$(this).stop(true).animate({left:365,top:221},2000);
						p1 = 1;
					}else{
						$(this).removeClass('.active');
						$(this).stop(true).animate({left:0,top:0},2000);
						p1 = 0;
					}
					p2 = 0;
					p3 = 0;
				});
			$(".play2").click(
				function(){
					$(this).siblings('.play1').stop(true).animate({left:0,top:0},2000).removeClass('active');
					$(this).siblings('.play3').stop(true).animate({left:0,top:450},2000).removeClass('active');
					if(p2==0){
						$(this).addClass('.active');
						$(this).stop(true).animate({left:365,top:231},2000);
						p2 = 1;
					}else{
						$(this).removeClass('.active');
						$(this).stop(true).animate({left:0,top:230},2000);
						p2 = 0;
					}
					p1 = 0;
					p3 = 0;
				});
			$(".play3").click(
				function(){
					$(this).siblings('.play1').stop(true).animate({left:0,top:0},2000).removeClass('active');
					$(this).siblings('.play2').stop(true).animate({left:0,top:230},2000).removeClass('active');
					if(p3==0){
						$(this).addClass('.active');
						$(this).stop(true).animate({left:365,top:225},2000);
						p3 = 1;
					}else{
						$(this).removeClass('.active');
						$(this).stop(true).animate({left:0,top:450},2000);
						p3 = 0;
					}
					p1 = 0;
					p2 = 0;
				})


			$(".play4").click(
				function(){
					$(this).siblings('.play5').stop(true).animate({left:5,top:230},2000).removeClass('active');
					$(this).siblings('.play6').stop(true).animate({left:0,top:450},2000).removeClass('active');
					if(p4==0){
						$(this).addClass('.active');
						$(this).stop(true).animate({left:-356,top:227},2000);
						p4 = 1;
					}else{
						$(this).removeClass('.active');
						$(this).stop(true).animate({left:0,top:0},2000);
						p4 = 0;
					}
					p5 = 0;
					p6 = 0;
				});
			$(".play5").click(
				function(){
					$(this).siblings('.play4').stop(true).animate({left:0,top:0},2000).removeClass('active');
					$(this).siblings('.play6').stop(true).animate({left:0,top:450},2000).removeClass('active');
					if(p5==0){
						$(this).addClass('.active');
						$(this).stop(true).animate({left:-356,top:230},2000);
						p5 = 1;
					}else{
						$(this).removeClass('.active');
						$(this).stop(true).animate({left:5,top:230},2000);
						p5 = 0;
					}
					p4 = 0;
					p6 = 0;
				});
			$(".play6").click(
				function(){
					$(this).siblings('.play4').stop(true).animate({left:0,top:0},2000).removeClass('active');
					$(this).siblings('.play5').stop(true).animate({left:5,top:230},2000).removeClass('active');
					if(p6==0){
						$(this).addClass('.active');
						$(this).stop(true).animate({left:-356,top:230},2000);
						p6 = 1;
					}else{
						$(this).removeClass('.active');
						$(this).stop(true).animate({left:0,top:450},2000);
						p6 = 0;
					}
					p4 = 0;
					p5 = 0;
				})



			$('.play1').hover(
				function(){
					$('.box1').fadeIn()
				},
				function(){
					$('.box1').fadeOut()
				}
			)
			$('.play2').hover(
				function(){
					$('.box2').fadeIn()
				},
				function(){
					$('.box2').fadeOut()
				}
			)
			$('.play3').hover(
				function(){
					$('.box3').fadeIn()
				},
				function(){
					$('.box3').fadeOut()
				}
			)
			$('.play4').hover(
				function(){
					$('.box4').fadeIn()
				},
				function(){
					$('.box4').fadeOut()
				}
			)
			$('.play5').hover(
				function(){
					$('.box5').fadeIn()
				},
				function(){
					$('.box5').fadeOut()
				}
			)
			$('.play6').hover(
				function(){
					$('.box6').fadeIn()
				},
				function(){
					$('.box6').fadeOut()
				}
			)



			/* $('.buy_btn').click(function(){
                var qn;
                if(p1 == 1){
                	$.get('add_to_cart_text.php', {sid: 36, qn: 1}, function(data){
                	});
                }
                if(p2 == 1){
                	$.get('add_to_cart_text.php', {sid: 32, qn: 1}, function(data){
                	});
                }
                if(p3 == 1){
                	$.get('add_to_cart_text.php', {sid: 35, qn: 1}, function(data){
                	});
                }
                if(p4 == 1){
                	$.get('add_to_cart_text.php', {sid: 37, qn: 1}, function(data){
                	});
                }
                if(p5 == 1){
                	$.get('add_to_cart_text.php', {sid: 40, qn: 1}, function(data){
                	});
                }
                if(p6 == 1){
                	$.get('add_to_cart_text.php', {sid: 41, qn: 1}, function(data){
                	});
                }
                if(p1 == 0 && p2 == 0 && p3 == 0 && p4 == 0 && p5 == 0 && p6 == 0)
                	alert('請先配對情侶對表');
                else
                	alert('感謝加入購物車');
                

            }); */



		})



	</script>





    
    <div class="container">
        <div class="row">
            <div class="col-md-12 tim">
                
             <span>
			<h1 class="text-center">試戴你的情人節對錶</h1><br>
			<div class="saleLogo"><img src="images/choose/long.png" height="" width="" alt=""></div>
			</span>
			<div class="wrapper">
				<div class="box box1"></div>
				<div class="box box2"></div>
				<div class="box box3"></div>
				<div class="box box4"></div>
				<div class="box box5"></div>
				<div class="box box6"></div>

				<div class="box_1 box1_1"></div>
				<div class="box_1 box2_1"></div>
				<div class="box_1 box3_1"></div>
				<div class="box_1 box4_1"></div>
				<div class="box_1 box5_1"></div>
				<div class="box_1 box6_1"></div>


				<div class="boxLeft">
					<div class="play1"></div>
					<div class="play2"></div>
					<div class="play3"></div>
				</div>
				<div class="boxCenter">
					<img src="images/choose/box-lr.png" height="400" width="500" alt="">
				</div>
				<div class="boxRight">
					<div class="play4"></div>
					<div class="play5"></div>
					<div class="play6"></div>
				</div>
				<a href="ShowProductIndex"><div class="buy_btn text-center">點我進入購物商城</div></a>

			</div>
                
                
                
                
                
                
                
            </div>
        </div>
    </div>



<jsp:include page="footer.jsp"></jsp:include>