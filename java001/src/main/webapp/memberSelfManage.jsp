<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="orderBeans"
	class="shoppingCart.model.dao.OrderHibernateDAO" scope="page" />
<%-- <jsp:useBean id="Member" class="regis.model.dao.MemberHibernateDAO" scope="page"/> --%>
<div class="container">
	<div class="row">
		<div class="col-md-12 tim">
			<div class="panel panel-default">
				<div class="panel-body">



					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne" aria-expanded="false"
										aria-controls="collapseOne">修改我的會員帳號 </a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body" style="color: black">
									<!-- 這邊是最上面的form -->

									<form id="memberUpdateSelfMemberForm" role="form" action="MemberUpdateHimself" method="post">
										<input type="hidden" name="pk" value="${LoginOK.id}">
										<div class="form-group">
											<label>帳號</label> <input type="text" name="name"
												class="form-control" value="${Member.memberName}">
										</div>
										<div class="form-group">
											<label>密碼</label> <input name="pswd"
												type="text" class="form-control" value="${Member.memberPs}">

										</div>
										<div class="form-group">
											<label>信箱</label> <input name="email"
												type="text" class="form-control" value="${Member.memberEmail}">

										</div>


										<button type="submit" class="btn btn-default">修改</button>
									</form>

									<!--End  -->




								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingTwo">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseTwo"
										aria-expanded="true" aria-controls="collapseTwo">
										我的訂購紀錄 </a>
								</h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingTwo">
								<div class="panel-body">
									<table class="table table-condensed">

										<tr style="color: black">
											<td class="info">訂單編號</td>
											<td class="info">訂購日期</td>
											<td class="info">總金額</td>
											<td class="info">送貨地址${anOrderBean.userId}</td>
										</tr>
										<c:forEach var="anOrderBean" varStatus="stat"
											items="${orderBeans.allOrders}">
											<c:if test="${anOrderBean.userId==LoginOK.memberName}">
												<tr style="color: black">
													<td class="active"><a
														href='orderDetail?orderNo=${anOrderBean.orderNo}'>
															${anOrderBean.orderNo} </a></td>
													<td class="active">${anOrderBean.orderDate}</td>
													<td class="active"><fmt:formatNumber
															value="${anOrderBean.totalAmount}" pattern="#,###,###" />元</td>
													<td class="active">${anOrderBean.shippingAddress}</td>
												</tr>
											</c:if>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingThree">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">
										我的留言紀錄 </a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingThree">
								<div class="panel-body">Anim pariatur cliche
									reprehenderit, enim eiusmod high life accusamus terry
									richardson ad squid. 3 wolf moon officia aute, non cupidatat
									skateboard dolor brunch. Food truck quinoa nesciunt laborum
									eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on
									it squid single-origin coffee nulla assumenda shoreditch et.
									Nihil anim keffiyeh helvetica, craft beer labore wes anderson
									cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
									vice lomo. Leggings occaecat craft beer farm-to-table, raw
									denim aesthetic synth nesciunt you probably haven't heard of
									them accusamus labore sustainable VHS.</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>



<jsp:include page="footer.jsp"></jsp:include>