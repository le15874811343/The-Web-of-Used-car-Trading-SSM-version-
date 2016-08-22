<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script type="text/javascript" src="js/showtime.js"></script>
</head>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是<input type="text" name='time' id="time" style="border: 0px;background:#fc7e31" readonly size='15' >，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.jsp">新增</a></em><a href="user.action?op=showuser">用户管理</a></dd>
				<dt>汽车信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="car.action?op=show">分类管理</a></dd>
				<dt>商品管理</dt>
				<dd><a href="car.action?op=showallcar">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="car.action?op=checking&state=审核"">出售申请</a></dd>
				<dd><a href="car.action?op=checking&state=在售">正在交易</a></dd>
				<dd><a href="car.action?op=checking&state=交易完成">出售完成</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>
				<dt>私人定制</dt>
				<dd><a href="guestbook.jsp">私人定制</a></dd>
				<dt>企业动态消息管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.jsp">动态管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>分类原则</th>
				</tr>
				
				<tr>
					<td class="first w4 c">品牌</td>
					<c:forEach var="lb" items="${lbrandmap }">
					<td ><a href="car.action?op=showcar&name=${lb.value.b_name }">${lb.value.b_name }</a></td>
					</c:forEach>
				</tr>
				<c:if test="${!empty rbrandmap}">
				<tr>
					<td class="first w4 c"></td>
					<c:forEach var="rb" items="${rbrandmap }">
					<td ><a href="car.action?op=showcar&name=${rb.value.b_name }">${rb.value.b_name }</a></td>
					</c:forEach>
				</tr>
				</c:if>
				<tr>
					<td class="first w4 c">车型</td>
					<c:forEach var="t" items="${typemap }">
					<td><a href="car.action?op=showcar&type=${t.value.t_name }">${t.value.t_name }</a></td>
					</c:forEach>
				
				</tr>
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
