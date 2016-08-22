<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script></head>
<script>
function delcar(id,a)
{url="<%=basePath%>car.action?op=del&cid="+id;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>car.action?op=showallcar"
}
else
{
alert("删除失败")}
}
}

</script>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li class="current"><a href="guestbook.jsp">留言</a></li>
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
				<dd><a href="guestbook.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">出售申请</a></dd>
				<dd><a href="order.jsp">正在交易</a></dd>
				<dd><a href="order.jsp">出售完成</a></dd>
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
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th></th>
					<th>详细信息</th>
				    <th>操作</th>
				</tr>
				<c:if test="${!empty allcar }">
				<c:forEach var="all" items="${allcar }">
				<tr>
					<td class="first w4 c"><img src="${all.value.c_img }"/></td>
					<td> <a href="#">${all.value.c_brand } ${all.value.c_series } ${all.value.c_releaseyear } ${all.value.c_volume }${all.value.c_gearType }${all.value.c_code }${all.value.c_model }${all.value.c_distance }${all.value.c_emissionstandard }${all.value.c_price }万元${all.value.c_type }</a></td>

					<td class="w1 c"><a href="car.action?op=showcarinfo&uid=${all.value.u_id }">修改</a> <input type="button" value="删除" onclick="delcar(${all.value.c_id })"></td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
			<div class="pager">
				<ul class="clearfix">
				
				<c:if test="${page>1 }">
					<li><a href="car.action?op=showallcar&page=${page-1}">上一页</a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="${maxPage }">
					<li><a href="car.action?op=showallcar&page=${i}">${i }</a></li>
					</c:forEach>
					<c:if test="${page<maxPage }">
					<li><a href="#">下一页</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
