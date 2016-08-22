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
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/checkuser.js"></script>
<script type="text/javascript">
function checkMobile(s) {
var regu = /^[1][0-9][0-9]{9}$/;
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
} 
function isEmail(str) {
var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
if (myReg.test(str)) return true;
return false;
} 

function chekUserName(){

   var flag=false;
   var str= document.all("mobile");
   var div=document.all("d1");
  
   if(str.value.length<=0){
     div.innerHTML="<font color='red'>用户名(手机号)不能为空</font>";
    div.style.display="inline";
   }
   else{
      if(checkMobile(str.value)){
         flag=true;
        
          div.style.display="none";
      }
      else{
       div.innerHTML="<font color='red'>请输入正确的手机号</font>";
    div.style.display="inline";
      }
   }
   return flag;
   }
function isZh(str){
 var reg = /^[\u4e00-\u9fa5]+$/;
 if (reg.test(str)) return true;
 return false; 
} 
    function chekName(){
    var flag=false;
     var str=document.all("realname")
      var div=document.all("d2")
     if(str.value.length<=0){
         div.innerHTML="<font color='red'>姓名不能为空</font>";
    div.style.display="inline";
     } 
     else{
     
     if(isZh(str.value)){
     flag=true;
      div.style.display="none";
     }
     else{
        div.innerHTML="<font color='red'>请输入正确的姓名</font>";
    div.style.display="inline";
     }
     
     }
    return flag;
    }
    function cheknpwd(){
      var flag=false;
  var opwd=document.all("npwd");
  var div=document.all("d7");
  if(opwd.value.length<=0){
    div.innerHTML="<font color='red'>新密码不能为空</font>";
    div.style.display="inline";
  
  }
  else{
  if(opwd.value.length<=6){
    div.innerHTML="<font color='red'>新密码必须大于六位</font>";
    div.style.display="inline";
  
  }
  else{
   
    if(cheknpwdyz()){
  flag=true;
   div.style.display="none";
   }
   else{
    div.innerHTML="<font color='red'>两次输入的密码不一致</font>";
    div.style.display="inline";
   }
  }
  }
  return flag;
  
  }
  function cheknpwd1(){
   var flag=false;
  var opwd=document.all("npwd1");
  var div=document.all("d8");
  if(opwd.value.length<=0){
    div.innerHTML="<font color='red'>确认密码不能为空</font>";
    div.style.display="inline";
  
  }
  else{
  if(opwd.value.length<=6){
    div.innerHTML="<font color='red'>确认密码必须大于六位</font>";
    div.style.display="inline";
  
  }
  else{
   
    if(cheknpwdyz()){
  flag=true;
   div.style.display="none";
   }
   else{
    div.innerHTML="<font color='red'>两次输入的密码不一致</font>";
    div.style.display="inline";
   }
  }
  }
  return flag;
  
  }
  function cheknpwdyz(){
  var flag=false;
    var npwd= document.all("npwd")
    var npwd1= document.all("npwd1")
    if(npwd.value.length>6&&npwd1.value.length>6){
    if(npwd.value==npwd1.value){
    flag=true;
    }
    }
    else{
    flag=true;
    }
    return flag;
  }
  function cheksub(){
  var flag=false;
  
  if(chekUserName()&&chekName()&&cheknpwd()&&cheknpwd1()){
  flag=true}
   return flag;
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
			<li   class="current"><a href="/S4SSMManager/Manager_showalluser.action">用户</a></li>
			<li  ><a href="/S4SSMManager/MgCar_showlist.action">商品</a></li>
			<li  ><a href="/S4SSMManager/Mgord_showallord.action">订单</a></li>
			<li   ><a href="/S4SSMManager/Trends_showcom.action">留言</a></li>
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
		<h2>新增用户</h2>
		<div class="manage">
			<form action="/S4SSMManager/MgUsIn_reguser.action" method="post" onsubmit="return cheksub()">
				<input type="hidden" name="op" value="reguser"/>
				<table class="form">
				
				
					<tr>
						<td class="field">手机号码(登录账户)：</td>
						<td><input type="text" class="text" name="mobile" id="mobile"  onblur="chekUserName()" />
							<div  id="d1" style="display:none"></div><div>${regmessage }</div></td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text" class="text" name="realname" id="realname" onblur="chekName()" />
						<div  id="d2" style="display:none"></div></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="password" class="text" name="npwd" id="npwd"  onblur="cheknpwd()" />
						<div  id="d7" style="display:none"></div></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input type="password" class="text" name="npwd1" id="npwd1"  onblur="cheknpwd1()" />
						<div  id="d8" style="display:none"></div></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="sex" id="sex" value="男" checked="checked" />男 <input type="radio" name="sex" id="sex" value="女" />女</td>
					</tr>
				<tr>
						<td class="field">权限：</td>
						<td><input type="radio" name="admin" id="admin" value="普通用户" checked="checked" />普通用户 <input type="radio" name="admin" id="admin" value="管理员" />管理员</td>
					</tr>
				
				<!-- 	<tr>
						<td class="field">头像：</td>
						<td><input type="file" class="text" name="photo" /></td>
					</tr> -->
					
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit"  value="添加"  /></label></td>
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
