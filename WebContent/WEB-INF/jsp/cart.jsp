<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css">


</head>
<body>
	<%@ include file="menu.jsp" %>
	
</div>	<div class="container cart">
		<div class="span24">
			<div class="step step1">
				
			</div>
				<table>
					<tbody><tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					
					<c:forEach  var="c" items="${cart.cartItem }">
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22">
								<img src="${pageContext.request.contextPath}/${c.product.image}">
							</td>
							<td>
								<a target="_blank">${c.product.pname}</a>
							</td>
							<td>
								￥${c.product.shopPrice}
							</td>
							<td class="quantity" width="60">
								${c.count}
							</td>
							<td width="140">
								<span class="subtotal">￥${c.subTotal}</span>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/cart/removeCart.action?pid=${c.product.pid}" class="delete">删除</a>
							</td>
						</tr>
						
						</c:forEach>
				</tbody></table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
							<em>
								登录后确认是否享有优惠
							</em>
					赠送积分: <em id="effectivePoint">${cart.total}</em>
					商品金额: <strong id="effectivePrice">￥${cart.total}元</strong>
				</div>
				<div class="bottom">
					<a href="javascript:;" id="clear" class="clear">清空购物车</a>
					<a href="./会员登录.htm" id="submit" class="submit">提交订单</a>
				</div>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>