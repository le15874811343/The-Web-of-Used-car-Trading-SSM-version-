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
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/checkuser.js"></script></head>
<script>
function update()
{var id=$("#userid").val();
var address=$("#address").val();
var sex='男';
var userid=id;
var name=$("#name").val();
var r=document.all('r');
for(var i=0;i<r.length;i++)
{if(r[i].checked)
sex=r[i].value
}
var mobile=$("#mobile").val();
var qq=$("#QQ").val();
var email=$("#email").val();
var card=$("#card").val();
var url="<%=basePath%>user.action?op=update&userid="+id+"&address="+address+"&sex="+sex+"&name="+name+"&mobile="+mobile+"&qq="+qq
+"&email="+email+"&card="+card;

if(checkname()&&checkqq()&&checkemail()&&checkadd()&&checkadd()&&checkcard()&&checkphone())
{
jQuery.post(url,null,callback)
function callback(data)
{if(data==1)
{
alert('修改成功')
window.location.href='<%=basePath%>user.action?op=showuser'}
else
{
alert('修改失败')}
}
}
else
{s
alert('修改失败')}
}

</script>
<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
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
		管理员pillys您好，今天是<input type="text" name="time" id="time" style="border:0px;background:#fc7e31" readonly size="15">，欢迎回到管理后台。
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
		<h2>修改用户</h2>
		<div class="manage">
			<form action="manage-result.jsp">
				<table class="form">
				<c:if test="${!empty getuser}">
				<input type="hidden" name="getuser" id="getuser" value="1">
				</c:if>
					<tr>
						<td class="field">用户ID：</td>
						<td><input type="text" class="text" name="userid" id="userid" readonly="readonly" value="${getuser.u_ID }" /></td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text" class="text" name="name" id="name" value="${getuser.u_NAME }" onblur="checkname()" size="5"/>
						<div name="namediv" id="namediv" style="display:none"></div>
						</td>
				
					</tr>
					<tr>
						<td class="field">性别：</td>
						<c:if test="${getuser.u_SEX=='男' }">
						<td><input type="radio" name="r" id="r" checked="checked" value="男" >男
						<input type="radio" name="r" id="r" value="女" >女</td>
						</c:if>
						<c:if test="${getuser.u_SEX=='女' }">
						<td><input type="radio" name="r" id="r"  value="男" >男
						<input type="radio" name="r" id="r" value="女" checked="checked" ">女</td>
						</c:if>
						<c:if test="${getuser.u_SEX!='男' and getuser.u_SEX!='女'}">
						<td><input type="radio" name="r" id="r"  value="男"  checked="checked">男
						<input type="radio" name="r" id="r" value="女" >女</td>
						
						</c:if>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" id="mobile" value="${getuser.u_TEL }" onblur="checkphone()"/>
						<div name="phonediv" id="phonediv" style="display:none"></div>
						</td>
					</tr>
					<tr>
						<td class="field">QQ：</td>
						<c:if test="${ getuser.u_QQ==0}">
						<td><input type="text" class="text" name="QQ" id="QQ" onblur="checkqq()"/>
						<div name="qqdiv" id="qqdiv" style="display:none"></div></td>
						</c:if>
							<c:if test="${ getuser.u_QQ>0}">
						<td><input type="text" class="text" name="QQ" id="QQ" value="${getuser.u_QQ }" onblur="checkqq()"/></td>
						<div name="qqdiv" id="qqdiv" style="display:none"></div>
						</c:if>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="email" id="email" value="${getuser.u_EAMIL }" onblur="checkemail()"/>
						<div name='emaildiv' id="emaildiv" style="display:none" ></div>
						</td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<c:if test="${ getuser.u_CARD==0}">
						<td><input type="text" class="text" name="card" id="card" onblur="checkcard()" />
						<div name="carddiv" id="carddiv" style="display:none"></div>
						</td>
						</c:if>
							<c:if test="${ getuser.u_CARD>0}">
						<td><input type="text" class="text" name="card" id="card" value="${getuser.u_CARD }" onblur="checkcard()"/>
							<div name="carddiv" id="carddiv" style="display:none"></div>
						</td>
						</c:if>
							
						
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address" id="address" value="${getuser.u_ADR }" onblur="checkadd()"/>
						<div name="adiv" id="adiv" style="display:none"></div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="button"  value="更新"  onclick="update()"/></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
