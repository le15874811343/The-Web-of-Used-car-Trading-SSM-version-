<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>象山县民情户户清管理系统</title>
<style type="text/css">
<!--
body,td,th {
	font-family: 微软雅黑;
	font-size: 12px;
	color: #333333;
}
body {
    margin:0 auto;
	background-image: url(images/loginbg.jpg);
	background-repeat: no-repeat;
	background-position: center top;
	background-color:#F2F2F2;
	width:1000px;
}
a:link {
	color: #333333;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #333333;
}
a:hover {
	text-decoration: none;
	color: #01A2AA;
}
a:active {
	text-decoration: none;
	color: #01A2AA;
}
.login2016{ width:auto; height:455px; padding-top:305px; padding-left:678px; padding-right:48px;}
#logtab{}
#logtab td{height:55px;}
.reglink{ color:#FFFFFF; font-weight:bold; font-size:14px;}
.reglink a{ color:#FFFFFF!important;}

#logtab input{
	width:224px;
	height:38px;
	line-height:38px;
	background-color:#FFFFFF;
	padding-left:50px;
    border:0px #fff solid;
	color:#666666;
	font-size:14px;
	border-radius:3px;
}
#logtab .input1{
	background-image: url(images/login_3.jpg);
	background-repeat: no-repeat;
	background-position: left center;
}

#logtab .input2{
	background-image: url(images/login_6.jpg);
	background-repeat: no-repeat;
	background-position: left center;
}

#logtab .input3{
    width:100px!important;
	background-image: url(images/login_11.jpg);
	background-repeat: no-repeat;
	background-position: left center;
}

.bottom2016{ width:1000px; height:105px; padding-top:35px; line-height:35px; text-align:center; color:#878787;}
.bottom2016 a{ color:#878787!important;}

-->
</style>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

/*
用途：检查输入手机号码是否正确
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/
function checkMobile(s) {
var regu = /^[1][0-9][0-9]{9}$/;
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
} 

function chekUserName(){
 var username= document.all("username").value;
 var div=document.all("div");
 var flag=false;
 if(username.length==0){
 
    div.innerHTML="<font color='red'>用户名不能为空</font>";
    div.style.display="inline";
 }
 else{
 if(checkMobile(username)){flag=true;
  div.style.display="none";
 }
 else{
 div.innerHTML="<font color='red'>请输入正确的手机号</font>";
    div.style.display="inline";
 }
 }
 return flag;
}
function chekUserPwd(){
var userpwd= document.all("userpwd").value;
 var div1=document.all("div1");
  var flag=false;
 if(userpwd.length==0){
 
    div1.innerHTML="<font color='red'>密码不能为空</font>";
    div1.style.display="inline";
 }
 else{
 flag=true;
 div1.style.display="none";
 }
 return flag;
}
function chekYzm(str,str1,div){
   
   var flag=false;
   var str=  document.all(str);
   var str1=  document.all(str1);
   var div=  document.all(div);
   if(str.value.length<=0){
   div.innerHTML="<font color='red'>验证码不能为空</font>";
    div.style.display="inline";
   }
   else{
   
   if(str.value==str1.value){
   flag=true;
   div.style.display="none";
   }
   else{
   div.innerHTML="<font color='red'>验证码输入错误</font>";
    div.style.display="inline";
   }
   }
   return flag;
   }
function chekSubMit(str,str1,div){
 var flag=false;
 if(chekUserName()&&chekUserPwd()&&chekYzm(str,str1,div)){
       flag=true;
 }
 return flag;
 }
</script>
<script type="text/javascript">
  $(document).ready(
  function (){
  $("#a1").click(
 function (){
 
  $("#f1").submit();
 
 }
 )
  }
  )
  
  
 
</script>
<script type="text/javascript">
  
var xmlhttp = false;
function CreateXMLHttp(){
        try{
            xmlhttp = new XMLHttpRequest();  //尝试创建 XMLHttpRequest 对象，除 IE 外的浏览器都支持这个方法。
        }
        catch (e){
            try{
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");  //使用较新版本的 IE 创建 IE 兼容的对象（Msxml2.XMLHTTP）
            }
            catch (e){
                try{
                  xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //使用较老版本的 IE 创建 IE 兼容的对象（Microsoft.XMLHTTP）。
                }
                catch (failed){
                      xmlhttp = false;  //如果失败则保证 request 的值仍然为 false。
                }
            }
        }
        return xmlhttp;
}

function sendUpdateYzm(){
 var url = "<%=basePath%>UserInfo_updateYzm.action?nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getResult; 
     xmlhttp.send(null); 
  } 
} 

  
function getResult(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
    var yzm=document.all("uyzm");
   
     var data=xmlhttp.responseText;
   var _yzm=document.all("_yzm");
     _yzm.value=parseInt(data);
   
      yzm.innerHTML="<a onclick='sendUpdateYzm()'><img src='images/"+data+".jpg' ></a>";
  
  }
}

  </script>
</head>

<body>

<div class="login2016">
<form action="UserInfo.action" id="f1" method="post" onsubmit=" return  chekSubMit('yzm','_yzm','d3')">
 <input type="hidden" name="op" value="login">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" id="logtab">
    <tr>
      <td><input type="text" name="username" id="username" class="input1" onblur="chekUserName()"/><div id="div" style="display:inline"> <c:if test="${!empty loginmessage}"><font color='red'>${loginmessage}</font></c:if> </div></td>
    </tr>
    <tr>
      <td><input type="password" name="userpwd" id="userpwd" class="input2"  onblur="chekUserPwd()"/><div id="div1" style="display:none"></div></td>
    <td></tr>
    <tr>
      <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><input type="hidden" id="_yzm" name="_yzm" value="${sRand }" ><input type="text" name="yzm"  id="yzm" class="input3" onblur="chekYzm('yzm','_yzm','d3')"  /></td>
          <td> <div id="uyzm"><a onclick="sendUpdateYzm()" ><img src="images/${sRand }.jpg" ></a></div><div id="d3" style="display: none"></div></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td valign="middle"><a id="a1"><img src="images/login_14.jpg" width="274" height="40" border="0" /></a></td>
    </tr>
    <tr>
      <td align="center" class="reglink"><a ></a> <a href="#">忘记密码</a></td>
    </tr>
  </table>
  </form>
</div>


<div class="bottom2016">主办单位：中共象山县委组织部 承办单位：象山县东陈乡人民政府<br />
Copyrigth@象山县东陈乡人民政府 技术支持：<a href="http://www.ydool.com.cn" target="_blank">云朵网络</a> 服务电话：0574-65006161</div>

</body>
</html>
