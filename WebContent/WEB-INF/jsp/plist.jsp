<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>

</head>
<body>

	<%@ include file="menu.jsp" %>
	
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
			
				<c:forEach var="c" items="${clist }">
						<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm">${c.cname }</a>
							</dt>
								<c:forEach var="cs" items="${c.clists }">
									<dd>
										<a >${cs.csname }</a>
									</dd>
								</c:forEach>	
						</dl>
						
					</c:forEach>	
			</div>
		</div>
		<div class="span18 last">
			
			<form id="productForm" action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm" method="get">
				<input type="hidden" id="brandId" name="brandId" value="">
				<input type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">
					
				<div id="result" class="result table clearfix">
						<ul>
						
						<c:forEach var="p" items="${page.list }">
						<li>
										<a href="${pageContext.request.contextPath}/product/findProductBypid.action?pid=${p.pid}">
											<img src="${pageContext.request.contextPath}/${p.image}" width="170" height="170"  style="display: inline-block;">
											   
		 									<span style='color:green'>
											 ${p.pname }
											</span>
											 
											<span class="price">
												商城价： ￥${p.shopPrice }/份
											</span>
											 
										</a>
						</li>
						</c:forEach>
									
						</ul>
				</div>
				
	<div class="pagination">
			<!-- 首页 -->
			<a href="${pageContext.request.contextPath}/product/findProductByCid.action?pageNum=${page.firstPage}&cid=${cid } "><span class="firstPage">&nbsp;</span></a>
			<!-- 上一页 -->
			<a href="${pageContext.request.contextPath}/product/findProductByCid.action?pageNum=${page.prePage}&cid=${cid } "><span class="previousPage">&nbsp;</span></a>
			
			<!-- 第几页 -->
				<span class="currentPage">${page.pageNum }</span>
			<!-- 下一页 -->	
			<a  href="${pageContext.request.contextPath}/product/findProductByCid.action?pageNum=${page.nextPage}&cid=${cid } "><span class="nextPage">&nbsp;</span></a>
			 <!-- 尾页 -->
			<a  href="${pageContext.request.contextPath}/product/findProductByCid.action?pageNum=${page.lastPage}&cid=${cid}"><span class="lastPage">&nbsp;</span></a>
	</div>
	
			</form>
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
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
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
						<a >官网</a>
						|
					</li>
					<li>
						<a >论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright©2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>