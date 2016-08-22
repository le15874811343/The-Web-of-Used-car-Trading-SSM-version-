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
function ycl(a)
{

var url="<%=basePath%>Mgord_yclsrdz.action?pid="+a;

jQuery.post(url,null,callback)

function callback(data)
{
if(data==1)
{
alert("处理成功")
window.location.href="<%=basePath%>Manager_showsrdz.action"
}
else
{
alert("处理失败")}
}
}
function del(a)
{

var url="<%=basePath%>Mgord_delsrdz.action?pid="+a;

jQuery.post(url,null,callback)

function callback(data)
{
if(data==1)
{
alert("删除成功")
window.location.href="<%=basePath%>Manager_showsrdz.action"
}
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
	<div class="help"><a href="/S4SSM/CarInfo.action">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li ><a href="/S4SSMManager/admin/index.jsp">首页</a></li>
			<li><a href="/S4SSMManager/Manager_showalluser.action">用户</a></li>
			<li><a href="/S4SSMManager/MgCar_showlist.action">商品</a></li>
			<li class="current"><a href="/S4SSMManager/Mgord_showallord.action">订单</a></li>
			<li><a href="/S4SSMManager/Trends_showcom.action">留言</a></li>
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
		<c:if test="${!empty szCar }">
		
							<c:forEach var="szCar" items="${szCar }">
							 <div class="hPages">用户ID: <a href="MgUsIn_showdeauser.action?uid=${szCar.value.uId }">${szCar.value.uId }</a>   </div>
                            <table width="800" border="1px">
                            <tr align="center"><td colspan="2" >申请编号：</td><td   >${szCar.value.pId }</td><td></td><td  colspan="2">处理状态：</td><td >${szCar.value.pState }</td></tr>
                            <tr align="center"><td colspan="2">需求品牌：</td><td>${szCar.value.pBrand }</td><td></td><td colspan="2">需求车系：</td><td>${szCar.value.pSeries }</td></tr>
                            <tr align="center"><td colspan="2">需求车龄：</td><td>${szCar.value.pAge }</td><td></td><td colspan="2">需求价格：</td><td>${szCar.value.pPrice }</td></tr>
                            <tr align="center"><td colspan="2">预购时间：</td><td>${szCar.value.pTime }</td><td></td><td colspan="2"> 提交时间：</td><td>${szCar.value.pTjtime }</td></tr>
                            <tr><td colspan="2" align="center">需求详述：</td><td colspan="5">${szCar.value.pMiaoshu }</td></tr>
                            </table>
                           
                            <div class="hPages">操作: <input type="button" onclick="ycl(${szCar.value.pId})" value="已处理"></input> <a onclick="del(${szCar.value.pId})">删除</a>   </div>
                            
                            <div class="hPages">    </div>
                             <div class="hPages">    </div>
							</c:forEach>
							</c:if>
							 <div class="pages"> <c:if test="${curPage > 1}">
					<a href="/S4SSMManager/Manager_showclzsrdz.action?jumpPage=1">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="/S4SSMManager/Manager_showclzsrdz.action?jumpPage=${curPage - 1}">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="/S4SSMManager/Manager_showclzsrdz.action?jumpPage=${curPage + 1}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="/S4SSMManager/Manager_showclzsrdz.action?jumpPage=${maxPage}">尾页</a>
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
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
