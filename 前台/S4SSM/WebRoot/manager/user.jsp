<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js" ></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script>
function udelete(a)
{
var url="<%=basePath%>user.action?op=del&id="+a;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>user.action?op=showuser"}
else
{
alert("删除失败")}
}
}

</script>
</head>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="admin/index.jsp">首页</a></li>
			<li class="current"><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${userinfo.u_name }您好，今天是<input type="text" name='time' id="time" style="border: 0px;background:#fc7e31" readonly size='15' >，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="manager/user-add.jsp">新增</a></em><a href="manager/user.jsp">用户管理</a></dd>
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
		<h2>用户管理</h2>
		<div class="manage">
		<div style="width:750px; height:267px; overflow:scroll;">
			<table class="list"  >
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>QQ</th>
					<th>手机</th>
					<th>身份证</th>
					<th>住址</th>
					<th>操作</th>
				</tr>
				<c:forEach var="u" items="${showuser}" >
				<tr>
					<td class="first w4 c">${u.value.u_id }</td>
					<td class="first w5 c">${u.value.u_name }</td>
					<td class="w1 c">${u.value.u_sex }</td>
					<td class="w2 c">${u.value.u_email }</td>
					<td>${u.value.u_qq }</td>
					<td >${u.value.u_tel }</td>
					<td >${u.value.u_card }</td>
					<td >${u.value.u_adr }</td>
					<td class="w1 c"><a href="user.action?op=userinfo&uid=${u.value.u_id }">修改</a> <input type="button" value="删除" onclick="udelete(${u.value.u_id })"></td>
				</tr>
				</c:forEach>
			</table>
			</div>
			 <div class="pages" align="center"> <c:if test="${curPage > 1}">
					<a href="Manager.action?op=showalluser&jumpPage=1&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="Manager.action?op=showalluser&jumpPage=${curPage - 1}&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="Manager.action?op=showalluser&jumpPage=${curPage + 1}&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="Manager.action?op=showalluser&jumpPage=${maxPage}&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</div>
			
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
