<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

    <!-- 內容請填在這，填完視情況把style的tim刪掉 -->
    <div class="container">
        <div class="row">
            <div class="col-md-12 tim">
                <div class="panel panel-danger">
				<div class="panel-heading">需要登入</div>
				<div class="panel-body" style="color:black">請按此來登入
				<a href="#" role="button" data-toggle="modal"
								data-target="#login-modal">登入</a></div>
			</div>
            </div>
        </div>
    </div>



<jsp:include page="footer.jsp"></jsp:include>