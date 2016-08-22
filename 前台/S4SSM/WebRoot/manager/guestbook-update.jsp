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
<script type="text/javascript" src="js/update.js"></script></head>

<script>

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
		<h2>回复留言</h2>
		<div class="manage">
			<form action="manage-result.jsp">
				<c:if test="${!empty showcarinfo }">
				<table class="form" >
		             <tr>
						<td class="field">车样：</td>
						<td><img src="${showcarinfo.c_img }">
						<input type="hidden" name="img" id="image" value="${showcarinfo.c_img }">
						</td>
					</tr>
					<tr>
						<td class="field">cID：</td>
						<td><input type="text" class="text" name="cid" id="cid" value="${showcarinfo.c_id}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">UID：</td>
						<td><input type="text" class="text" name="uid" id="uid" value="${showcarinfo.u_id}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">车牌：</td>
						<td><input type="text" class="text" name="brand" id="brand" value="${showcarinfo.c_brand}" onblur="checkbrand()"  />
						<div name="bdiv" id="bdiv" style="display:none"></div>
						</td>
					</tr>
					<tr>
						<td class="field">车系列：</td>
						<td><input type="text" class="text" name="series" id="series" value="${showcarinfo.c_series}" onblur="checkseries()" />
						<div name="csdiv" id="csdiv" style="display:none"></div></td>
					</tr>
					<tr>
						<td class="field">生产日期：</td>
						<td><input type="text" class="text" name="releaseyear" id="releaseyear" value="${showcarinfo.c_releaseyear}" onblur="checkreleaseyear()" />
						<div name="releaseyeardiv" id="releaseyeardiv" style="display:none"></td>
					</tr>
					<tr>
						<td class="field">L：</td>
						<td><input type="text" class="text" name="l" id='l' value="${showcarinfo.c_volume}" onblur="checkl()" />
						<div name="ldiv" id="ldiv" style="display:none"></td>
					</tr>
					<tr>
						<td class="field">离合类型：</td>
						<td><input type="text" class="text" name="lhtype" id="lhtype" value="${showcarinfo.c_gearType}" onblur="checklh()" />
						<div name="lhdiv" id="lhdiv" style="display:none"></td>
					</tr>
					<tr>
						<td class="field">外形版本：</td>
						<td><input type="text" class="text" name="code" id="code" value="${showcarinfo.c_code}" onblur="checkcode()" />
						<div name="codediv" id="codediv" style="display:none"></td>
					</tr>
					<tr>
						<td class="field">model：</td>
						<td><input type="text" class="text" name="model" id="model" value="${showcarinfo.c_model}" onblur="checkmode()" />
						<div name="modediv" id="modediv" style="display:none"></td>
					</tr>
					
					<tr>
						<td class="field">ltime：</td>
						<td><input type="text" class="text" name="ltime" id="ltime" value="${showcarinfo.c_licencetime}" onblur="checkltime()" />
						<div name="ltimediv" id="ltimediv" style="display:none"></td>
					</tr>
					<tr>
						<td class="field">上架：</td>
						<td><input type="text" class="text" name="sjltime" id="sjltime" value="${showcarinfo.c_sjtime}" onblur="checksjtime()" />
						<div name="sjtimediv" id="sjtimediv" style="display:none"></td>
					</tr>
						<tr>
						<td class="field">距离：</td>
						<td><input type="text" class="text" name="distance" id="distance" value="${showcarinfo.c_distance}" onblur="checkdistance()" />
						<div name="distancediv" id="distancediv" style="display:none"></td>
					</tr>
					<tr>
						<td class="field">emission标准：</td>
						<td>
						<select name="emselect" id="emselect">
						<option value="${showcarinfo.c_emissionstandard}">${showcarinfo.c_emissionstandard}</option>
						<c:forEach var="ems" items="${ emissionstandards}">
						<c:if test="${ems.value.e_name!=showcarinfo.c_emissionstandard }">
						<option value="${ems.value.e_name}">${ems.value.e_name}</option>
						</c:if>
						</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td class="field">价格：</td>
						<td><input type="text" class="text" name="price" id="price" value="${showcarinfo.c_price}" onblur="checkprice()" />
						<div name="pricediv" id="pricediv" style="display:none"></td>
					</tr>
					<tr>
						<td class="field">数量：</td>
						<td><input type="text" class="text" name="ccount" id="ccount" value="${showcarinfo.c_count}" onblur="checkccount()" />
					<div name="countdiv" id="countdiv" style="display:none"></td>
					</tr>
						<tr>
						<td class="field">类型：</td>
				<td><select id="typeselect" name="typeselect">
					<option value="${showcarinfo.c_type}">${showcarinfo.c_type}</option>
					<c:forEach var="cartype" items="${cartype }" >
					<c:if test="${cartype.value.t_name!=showcarinfo.c_type }">
					<option value="${cartype.value.t_name} ">${cartype.value.t_name}</option>
					</c:if>
					</c:forEach>
					</select></td>
						</tr>
					<tr>
						<td class="field">出售状态：</td>
						<td><select name="stateselect" id="stateselect"><option value="${showcarinfo.c_state}">${showcarinfo.c_state}</option>
						<c:forEach var="states" items="${states }" >
					<c:if test="${states.value.state!=showcarinfo.c_state }">
					<option value="${states.value.state} ">${states.value.state}</option>
					</c:if>
					</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="field">收藏次数：</td>
						<td><input type="text" class="text" name="sscount" id="sscount" value="${showcarinfo.c_sccount}"  onblutr="checksscount()"/>
						<div name="sscountdiv" id="sscountdiv" style="display:none"></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="button" onclick="update()"  value="修改" /></label></td>
					</tr>
				</table>
				</c:if>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
