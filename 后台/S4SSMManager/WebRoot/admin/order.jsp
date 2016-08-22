<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script>
function pass(cid,state)
{

var url="<%=basePath%>car_changestate.action?cid="+cid+"&state="+state;
jQuery.post(url,null,callback)
function callback(data)
{if(data==1)
{
alert('操作成功')
window.location.href="car_checking.action?state=审核"}
else
{
alert('操作失败')}
}
}

</script>
</head>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="/S4SSM/CarInfo.action">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li ><a href="/S4SSMManager/admin/index.jsp">首页</a></li>
			<li><a href="/S4SSMManager/Manager_showalluser.action">用户</a></li>
			<li ><a href="/S4SSMManager/MgCar_showlist.action">商品</a></li>
			<li  class="current" ><a href="/S4SSMManager/Mgord_showallord.action">订单</a></li>
			<li ><a href="/S4SSMManager/Trends_showcom.action">留言</a></li>
			<li ><a href="/S4SSMManager/Trends_showalltrends.action">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
管理员<a href="/S4SSMManager/MgUsIn_showdeauser.action?uid=${userinfo.uId }">${userinfo.uName }</a>您好，今天是<input type="text" name='time' id="time" style="border: 0px;background:#fc7e31" readonly size='16' />，欢迎回到管理后台。	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="/S4SSMManager/admin/user-add.jsp">新增</a></em><a href="/S4SSMManager/Manager_showalluser.action">所有用户</a></dd>
			    <dd><em><a href="/S4SSMManager/admin/user-add.jsp">新增</a></em><a href="/S4SSMManager/Manager_showuser.action">普通用户</a></dd>
				<dd><em><a href="/S4SSMManager/admin/user-add.jsp">新增</a></em><a href="/S4SSMManager/Manager_showadmin.action">管理员</a></dd>
				<dt>汽车信息</dt>
				<dd><em><a href="/S4SSMManager/admin/brand-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showbrand.action">品牌管理</a></dd>
				<dd><em><a href="/S4SSMManager/Model_addseries.action">新增</a></em><a href="/S4SSMManager/Model_showseries.action">车系管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/age-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showage.action">车龄管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/price-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showprice.action">车价管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/distance-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showdistance.action">行驶距离管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/emsi-add.jsp	">新增</a></em><a href="/S4SSMManager/Model_showemsi.action">排放标准管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/type-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showtype.action">车型管理</a></dd>				
				<dt>商品管理</dt>
				<dd><a href="/S4SSMManager/MgCar_showlist.action">所有商品</a></dd>
				<dd><a href="/S4SSMManager/MgCar_showzs.action">在售商品</a></dd>
				<dd><a href="/S4SSMManager/MgCar_showsh.action">审核中的商品</a></dd>
				<dd><a href="/S4SSMManager/MgCar_showxj.action">下架的商品</a></dd>
				<dd><a href="/S4SSMManager/MgCar_showwtg.action">审核未通过的商品</a></dd>
				<dt>订单管理</dt>
				<dd><a href="/S4SSMManager/Mgord_showallord.action">所有订单</a></dd>
				<dd><a href="/S4SSMManager/Mgord_showzzjy.action">中止交易申请</a></dd>
				<dd><a href="/S4SSMManager/Mgord_showjyz.action">正在交易</a></dd>
				<dd><a href="/S4SSMManager/Mgord_showjywc.action">出售完成</a></dd>
				<dt>留言管理</dt>
				<dd><a href="/S4SSMManager/Trends_showcom.action">留言管理</a></dd>
				<dt>私人定制</dt>
				<dd><a href="/S4SSMManager/Manager_showsrdz.action">私人定制</a></dd>
				<dd><a href="/S4SSMManager/Manager_showclzsrdz.action">处理中的私人定制</a></dd>
				<dd><a href="/S4SSMManager/Manager_showyclsrdz.action">已处理的私人定制</a></dd>
				<dt>企业动态消息管理</dt>
                <dd><em><a href="/S4SSMManager/admin/alltrend-add.jsp">新增</a></em><a href="/S4SSMManager/Trends_showalltrends.action">所有动态</a></dd>
				<dd><em><a href="/S4SSMManager/admin/allnews-add.jsp">新增</a></em><a href="/S4SSMManager/Trends_shownewslist.action">新闻管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/active-add.jsp">新增</a></em><a href="/S4SSMManager/Trends_showactive.action">活动管理</a></dd>
			    <dt>业务分析</dt>
			    <dd><a href="/S4SSMManager/admin/chaxunche.jsp">卖出车情况</a></dd>
			    <dd><a href="/S4SSMManager/admin/pricechaxun.jsp">交易额情况</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
		<!--<form method="get">
					订单号：<input type="text" class="text" name="orderId" /> 订货人：<input type="text" class="text" name="userName" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form> -->	
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>车辆信息</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:if test="${!empty shmap }">
				<c:forEach var="sm" items="${shmap }">
				<tr>
					<td class="first w4 c">${sm.value.cId }</td>
					<td class="w1 c"><img src="${sm.value.cImg }"><a href="#">${sm.value.cBrand }${sm.value.cSeries }</a></td>
					<td class="w1 c">${sm.value.cState }</td>
					<td class="w1 c"><input type="button" value="通过" onclick="pass(${sm.value.cId },'在售')"><input type="button" value="拒绝" onclick="pass(${sm.value.cId },'审核失败')"></td>
				</tr>
				</c:forEach>
				</c:if>
				<c:if test="${!empty szCar }">
				<c:forEach var="cs" items="${szCar }">
				<tr>
					<td class="first w4 c">${szCar.value.uId }</td>
					<td class="w1 c"></td>
					<td class="w1 c">${cs.value.cState }</td>
					<td class="w1 c"><input type="button" value="下架"></td>
				</tr>
				</c:forEach>
				</c:if>
				
				<c:if test="${!empty finishmap }">
				<c:forEach var="fm" items="${finishmap }">
				<tr>
					<td class="first w4 c">${fm.value.uId }</td>
					<td class="w1 c"><img src="${fm.value.cImg }"><a href="#">${fm.value.cBrand }${fm.value.cSeries }</a></td>
					<td class="w1 c">${fm.value.CState }</td>
					<td class="w1 c"></td>
				</tr>
				</c:forEach>
				</c:if>
			</table>
			<div class="pager">
				<ul class="clearfix">
				<c:if test="${!empty csmaxPage }">
				<c:if test="${cspage>1 }">
					<li><a href="car_checking.action?page=${cspage-1}&state=在售">上一页</a></li>
					</c:if>
				<c:forEach var="i" begin="1" end="${csmaxPage }">
				<a href="car_checking.action?page=${i}&state=在售">${i}</a>
				</c:forEach>
				<c:if test="${cspage<csmaxPage }">
					<li><a href="car_checking.action?page=${cspage+1}&state=在售">下一页</a></li>
					</c:if>
				</c:if>
				<c:if test="${!empty shmaxPage }">
				<c:if test="${shpage>1 }">
					<li><a href="car_checking.action?page=${shpage-1}&state=审核">${shpage }上一页</a></li>
					</c:if>
				<c:forEach var="i" begin="1" end="${shmaxPage }">
				<a href="car_checking.action?page=${i}&state=审核">${i}</a>
				</c:forEach>
				<c:if test="${shpage<shmaxPage }">
					<li><a href="car_checking.action?page=${shpage+1}&state=审核">下一页</a></li>
					</c:if>
				</c:if>
				<c:if test="${!empty finishmaxPage }">
				<c:if test="${finishpage>1 }">
					<li><a href="car_checking.action?page=${finishpage-1}&state=交易完成">上一页</a></li>
					</c:if>
				<c:forEach var="i" begin="1" end="${finishmaxPage }">
				<a href="car_checking.action?page=${i}&state=交易完成">${i}</a>
				</c:forEach>
				<c:if test="${finishpage<finishmaxPage }">
					<li><a href="car_checking.action?page=${finishpage+1}&state=交易完成">下一页</a></li>
					</c:if>
				</c:if>
					
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
