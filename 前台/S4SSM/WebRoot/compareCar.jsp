<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我要买车-郑州高品质二手车专家_亿金汽车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="郑州二手车,河南二手车,郑州二手名车">
	<meta http-equiv="description" content="亿金汽车">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/layout.css">
<link rel="stylesheet" type="text/css" href="css/sell.css">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>



<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG.js"></script>
<script>
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->
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
    var yzmi=document.all("uiyzm");
     var data=xmlhttp.responseText;
   var _yzm=document.all("_yzm");
     _yzm.value=parseInt(data);
     var _regyzm=document.all("_regyzm");
     _regyzm.value=parseInt(data);
      yzm.innerHTML="<a onclick='sendUpdateYzm()'><img src='images/"+data+".jpg' ></a>";
        yzmi.innerHTML="<a onclick='sendUpdateYzm()'><img src='images/"+data+".jpg' ></a>";
  
  }
}

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

function sendLogin(){

 var url = "<%=basePath%>UserInfo_needLogin.action?nocahe="+new Date().getTime()+"";
  
  CreateXMLHttp();
  if(xmlhttp){
  
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getLogin; 
     xmlhttp.send(null); 
  } 
} 


function getLogin(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
    var popbox=document.all("popBox");
    
    var login=document.all("login");
    var reg=document.all("uureg");
    var ptab=document.all("ptab");
    
     popbox.style.display="inline";
    ptab.innerHTML="<a class='on'  onclick='sendLogin()' >会员登录<i></i></a><a onclick='sendReg()'>会员注册<i></i></a>";
    reg.style.display="none";
    login.style.display="inline";
     var yzm=document.all("uyzm");
    var yzmi=document.all("uiyzm");
     var data=xmlhttp.responseText;
    var _yzm=document.all("_yzm");
      var datas=data.split(",");
   
    if(datas.length>1){
    var username=document.all("username");
    var checkbox=document.all("checkbox");
    checkbox.checked=true;
   
    username.value=datas[1].replace(/\s+/g,"");
    }
    
     _yzm.value=parseInt(datas[0]);
      yzm.innerHTML="<a onclick='sendUpdateYzm()'><img src='images/"+datas[0]+".jpg' ></a>";
        yzmi.innerHTML="<a onclick='sendUpdateYzm()'><img src='images/"+datas[0]+".jpg' ></a>";
 
 
    
 
  }
}

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

function sendReg(){
 var url = "<%=basePath%>UserInfo_needReg.action?nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getReg; 
     xmlhttp.send(null); 
  } 
} 


function getReg(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
    var popbox=document.all("popBox");
    
    var reg=document.all("uureg");
   
    var ptab=document.all("ptab");
   var login=document.all("login");
     popbox.style.display="inline";
    ptab.innerHTML="<a onclick='sendLogin()' >会员登录<i></i></a><a class='on' onclick='sendReg()'>会员注册<i></i></a>";
     login.style.display="none";
     reg.style.display="inline";
    var yzm=document.all("uyzm");
    var yzmi=document.all("uiyzm");
     var data=xmlhttp.responseText;
     var _regyzm=document.all("_regyzm");
     
     _regyzm.value=parseInt(data);
      yzm.innerHTML="<a onclick='sendUpdateYzm()'><img src='images/"+data+".jpg' ></a>";
        yzmi.innerHTML="<a onclick='sendUpdateYzm()'><img src='images/"+data+".jpg' ></a>";
    
 
  }
}

</script>
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

/*
用途：检查输入对象的值是否符合E-Mail格式
输入：str 输入的字符串
返回：如果通过验证返回true,否则返回false
*/
function isEmail(str) {
var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
if (myReg.test(str)) return true;
return false;
} 

function chekUserName(str,div){

   var flag=false;
   var str= document.all(str);
   var div=document.all(div);
  
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
   function chekUserPwd(str,div){
   var flag=false;
 var userpwd=  document.all(str);
 var div=  document.all(div);
   if(userpwd.value.length<=0){
   div.innerHTML="<font color='red'>密码不能为空</font>";
    div.style.display="inline";
   }
       else{
    if(userpwd.value.length<=6){
      div.innerHTML="<font color='red'>密码必须大于六位</font>";
    div.style.display="inline";
    }
    else{
    flag=true;
    div.style.display="none";
    }
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
   function chekLogin(str,str1,str2,str3,div,div1,div2){
    var flag=false;
    if(chekUserName(str,div)&&chekUserPwd(str1,div1)&&chekYzm(str2,str3,div2)){
    flag=true;
    }
    return flag;
   }
   
/*
用途：检查输入字符串是否只由汉字组成
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/

function isZh(str){
 var reg = /^[\u4e00-\u9fa5]+$/;
 if (reg.test(str)) return true;
 return false; 
} 
    function chekName(str,div){
    var flag=false;
     var str=document.all(str)
      var div=document.all(div)
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
   
   function chekReg(str,str1,str2,str3,str4,div,div1,div2,div3){
   var flag=false;
     if(chekUserName(str,div)&&chekName(str4,div3)&&chekUserPwd(str1,div1)&&chekYzm(str2,str3,div2)){
    flag=true;
    }
    return flag;
   }
   function closedd(){

 var d=document.all("popBox");
 d.style.display="none";

}
    </script>
<script type="text/javascript">
function cheklynull(){

 var a= document.all("bankAuthSrc").value;

 var flag=false;
 if(a.length==0){
 alert("留言内容不能为空")
 }
 else{
 flag=true;
 }
 return flag;
}
function udelete()
{

if(cheklynull()){
 var a= document.all("bankAuthSrc").value;
 var b= document.all("bankAuthSrc");
var url="<%=basePath%>MemberCenter_liuyan.action?text="+a;
jQuery.post(url,null,callback)
function callback(data)
{
if(data==1)
{
alert("留言成功")
 b.value="";
}
else
{
alert("留言失败")}
}
}
}
</script>
  </head>
  
  <body>
    <div id="header">
	<div class="top">
		<div class="wrap clearfix">
			<a href="#" class="logo left" style="margin-top:0px;"><img src="images/logo.png"/></a>
			<div class="nav left dInline" id="headerMenu">
      <a  href="CarInfo.action">首页</a>
      <a href="about.jsp">关于亿金</a>
      <a href="CarInfo_showList.action">我要买车</a>
     <c:if test="${!empty userinfo }"><a href="MemberCenter_needmaiche.action">我要卖车</a></c:if>
       <c:if test="${empty userinfo }"><a onclick="sendLogin()">我要卖车</a></c:if>
      <c:if test="${!empty userinfo }"><a href="CarInfo_showsrdz.action">私人订制</a></c:if>
       <c:if test="${empty userinfo }"><a onclick="sendLogin()">私人订制</a></c:if>
      <!--<a href="shfw.html">售后服务</a>-->
<c:if test="${!empty userinfo }"> <a id="MemberMenuChange" href="MemberCenter_showmenber.action" target="_self">会员中心</a></c:if>
          <c:if test="${empty userinfo }"> <a id="MemberMenuChange" onclick="sendLogin()">会员中心</a></c:if>
           </div>
	 <span class="right" id="rightMenuHtml">
      
     <c:if test="${empty userinfo }"><a onclick="sendLogin()" >登录</a>|<a  onclick="sendReg()" >注册</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>
      <c:if test="${!empty userinfo }"> <c:if test="${time<12 }">上午好！</c:if><c:if test="${time>=12 }">  下午好！ </c:if> <a href="MemberCenter_showmenber.action"  >
    ${userinfo.uName } 
   
      </a>|<a  onclick="document.getElementById('zhuxiaoform').submit();" >注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      <form action="UserInfo_zhuXiao.action" method="get" id="zhuxiaoform">
      <table>
      <tr><td>             <input type="hidden" name="url" value="forward:/CarInfo_showCompare.action?cid=${cid}&uid=${uid}">
      </td></tr>
      </table>
      </form>
      </c:if>
      
      </span>
		</div>
	</div>
	<div class="head-search">
		<div class="wrap clearfix">
			<form class="clearfix left" action="CarInfo_showList.action" method="get" >
				
				<input type="text" name="bname" placeholder="请输入您想要的品牌、车系或车辆编号搜索" style="width:439px;" class="left" />
				<input type="submit" value="搜 索" class="right" />
			</form>
			<div class="hotWords left dInline">
				热门品牌：<c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
                        <a href="CarInfo_showList.action?bname=${ showcar.value.cBrand}&cser=${showcar.value.cSeries} " target="_blank" >${ showcar.value.cBrand}${showcar.value.cSeries}</a>
            
            </c:forEach>
            </c:if>    
			</div>
		</div>
	</div>
</div>

<div id="about">
  <div class="mTags">
    <div class="wrap"> <a href="CarInfo.action">启乘名车广场</a>><a >车辆对比</a> </div>
  </div>
  <div class="dbBox wrap">
    <div class="carSoureBody">
      <div class="carSoureList clearfix">
        <ul class="carSul clearfix">
          <li class="l1"></li>
          <c:if test="${!empty pareCarInfo }">
          <c:forEach var="pareCarInfo" items="${pareCarInfo }">
            <li> <a href="CarInfo_showDetails.action?uid=${pareCarInfo.value.uId }&cid=${pareCarInfo.value.cId }" target="_blank">
            <div class="imgOut_3"> <img src="${pareCarInfo.value.cImg}"> </div>
            <h1>${pareCarInfo.value.cBrand }${pareCarInfo.value.cSeries } ${pareCarInfo.value.cReleaseyear } 款 ${pareCarInfo.value.cVolume }L ${pareCarInfo.value.cGeartype } ${pareCarInfo.value.cCode } ${pareCarInfo.value.cModel }</h1>
            </a> 
            <!--<a href="javascript:;" class="delte" onclick="balance('1179')"></a>-->
            <p class="pre"> <span>一口价：</span> <b>${pareCarInfo.value.cPrice }</b>万 </p>
          </li>
          </c:forEach>
          </c:if>
        </ul>
        <div class="carSutl clearfix">
          <ul>
            <li>
              <p class="carSutl_top cur"> <span class="fl">车辆信息</span> <span class="fr"></span> </p>
              <div class="con" style="display:block;">
                <table>
                  <tr>
                    <th><span>行驶里程</span></th>
                    <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <td class="std1"><span>${pareCarInfo.value.cDistance }万公里</span></td>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>初次上牌日期</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <td class="std1"><span> ${pareCarInfo.value.cLicencetime }</span></td>
                   
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>发动机排量</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    
                     <td class="std1"><span>${pareCarInfo.value.cVolume }</span></td>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>变速箱</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.cvt }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                  <tr>
                    <th><span>车型</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                   
                     <td class="std1"><span> ${pareCarInfo.value.cType }</span></td>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>车身颜色</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareBasic" items="${pareBasic }">
                    <c:if test="${pareBasic.key==pareCarInfo.key }">
                    <td class="std1"><span>${pareBasic.value.bodycolor }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>车辆年检时间</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareBasic" items="${pareBasic }">
                    <c:if test="${pareBasic.key==pareCarInfo.key }">
                    <td class="std1"><span>${pareBasic.value.aidd }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                  <tr>
                    <th><span>商业险到期日</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareBasic" items="${pareBasic }">
                    <c:if test="${pareBasic.key==pareCarInfo.key }">
                    <td class="std1"><span>${pareBasic.value.cimd }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>强制险到期日</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareBasic" items="${pareBasic }">
                    <c:if test="${pareBasic.key==pareCarInfo.key }">
                    <td class="std1"><span>${pareBasic.value.srdt }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>行驶证</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareProcedureInfo" items="${pareProcedureInfo }">
                    <c:if test="${pareCarInfo.key==pareProcedureInfo.key }">
                    <td class="std1"><span>${pareProcedureInfo.value.drivinglicense }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>购车发票</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareProcedureInfo" items="${pareProcedureInfo }">
                    <c:if test="${pareCarInfo.key==pareProcedureInfo.key }">
                    <td class="std1"><span>${pareProcedureInfo.value.transferticket }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                  <tr>
                    <th><span>购置税</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareProcedureInfo" items="${pareProcedureInfo }">
                    <c:if test="${pareCarInfo.key==pareProcedureInfo.key }">
                    <td class="std1"><span>${pareProcedureInfo.value.purchasetax }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                </table>
              </div>
            </li>
            <li>
              <p class="carSutl_top"> <span class="fl">销售信息</span> <span class="fr"></span> </p>
              <div class="con">
                <table>
                  <tr>
                    <th><span>指导价</span></th>
                    <td class="std1"><span>42.22（万）</span></td>
                    <td class="std1"><span>27.77（万）</span></td>
                    <td class="std1"><span>38.75（万）</span></td>
                    <td class="std1"><span></span></td>
                  </tr>
                  <tr>
                    <th><span>销售价</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    
                     <td class="std1"><span> ${pareCarInfo.value.cPrice }（万）</span></td>
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                  <tr>
                    <th><span>含过户费</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareSellInfo" items="${pareSellInfo }">
                    <c:if test="${pareSellInfo.key==pareCarInfo.key }">
                    <td class="std1"><span>${pareSellInfo.value.transferfee}</span></td>
                    </c:if>
                    </c:forEach>
                    
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>支持分期</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSellInfo" items="${pareSellInfo }">
                    <c:if test="${pareSellInfo.key==pareCarInfo.key }">
                    <td class="std1"><span>${pareSellInfo.value.pricetype}</span></td>
                    </c:if>
                    </c:forEach>
                    
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                </table>
              </div>
            </li>
            <li>
              <p class="carSutl_top"> <span class="fl">配置信息</span> <span class="fr"></span> </p>
              <div class="con">
                <table>
                  <tr>
                    <th><span>座位数</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.seatnumber }</span></td>
                    </c:if>
                    </c:forEach>
                    
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                 
                  <tr>
                    <th><span>燃料形式</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.fuelform }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                 
                  </tr>
                  <tr>
                    <th><span>变速箱</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                      <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.cvt }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                 
                  </tr>
                  <tr>
                    <th><span>驱动方式</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                      <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.drivingmethod }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>无钥匙进入</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.pke }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>无钥匙启动</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.keylessgo}</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>全景天窗</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.sunroof}</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>真皮座椅</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.leatherseat}</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>前排座椅加热</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.hfs }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                  <tr>
                    <th><span>后排座椅加热</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.hrs }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>前排座椅通风</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.fsv }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>后排座椅通风</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.rsv }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>前排座椅记忆</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.fsm }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>后排座椅记忆</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.rsm }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>导航系统</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.guidancesystem }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>中控台液晶屏</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.consolelcdscreen }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                  <tr>
                    <th><span>自动头灯</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.autolight }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>后视镜加热</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.rvmh }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>发动机启停</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.ess }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>防抱死制动系统</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.alb }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>前驻车雷达</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.fpg }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>后倒车雷达</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.rpg }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                    
                  </tr>
                  <tr>
                    <th><span>氙气大灯</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.headlights }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                  <tr>
                    <th><span>倒车影像系统</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.rcpa }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>驾驶员座椅电动调节</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.dsea }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>副驾驶座椅电动调节</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.fsea }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                  
                  </tr>
                  <tr>
                    <th><span>大灯清洗</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                    <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.lightwash }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                  <tr>
                    <th><span>电动折叠后视镜</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareHardwareConfig" items="${pareHardwareConfig }">
                    <c:if test="${pareCarInfo.key==pareHardwareConfig.key }">
                    <td class="std1"><span>${pareHardwareConfig.value.efgv }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
           
                  </tr>
                  <tr>
                    <th><span>定速巡航</span></th>
                     <c:if test="${ !empty pareCarInfo}">
                    <c:forEach var="pareCarInfo" items="${pareCarInfo }">
                     <c:forEach var="pareSystemConfig" items="${pareSystemConfig }">
                    <c:if test="${pareCarInfo.key==pareSystemConfig.key }">
                     <td class="std1"><span>${pareSystemConfig.value.dlcc }</span></td>
                    </c:if>
                    </c:forEach>
                    </c:forEach>
                    </c:if>
                   
                  </tr>
                </table>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>

<!--底部的开始-->
<div id="footer">
  <div class="foot-a1">
    <div class="wrap">
      <ul class="clearfix">
        <li> <img src="images/db1.png"/>
          <p>365项检测认证</p>
        </li>
        <li> <img src="images/db2.png"/>
          <p>5000公里无需保养</p>
        </li>
        <li> <img src="images/db3.png"/>
          <p>1年或两万公里无忧质保</p>
        </li>
        <li> <img src="images/db4.png"/>
          <p>7天无忧退换</p>
        </li>
        <li> <img src="images/db5.png"/>
          <p> 置换有增值</p>
        </li>
      </ul>
    </div>
  </div>
  <div class="foot-a">
    <div class="wrap clearfix">
      <div class="fDl left dInline "> <strong>亿金承诺</strong>
        <ul>
        <c:if test="${!empty chennuo }">
        <c:forEach var="chennuo" items="${chennuo }">
        <li><a href="Trends_showTei.action?tr_id=${chennuo.trId }" target="_blank">${chennuo.trTitle }</a></li>
        </c:forEach>
        </c:if>
         
        </ul>
      </div>
      <div class="fDl left dInline "> <strong>买卖二手车指南</strong>
        <ul>
        <c:if test="${!empty zhinan }">
        <c:forEach var="zhinan" items="${zhinan }">
        <li><a href="Trends_showTei.action?tr_id=${zhinan.trId }" target="_blank">${zhinan.trTitle }</a></li>
        </c:forEach>
        </c:if>
         
        </ul>
      </div>
      <div class="fDl left dInline "> <strong>售后服务</strong>
        <ul>
          <li><a href="shfw.jsp">24小时道路救援</a></li>
          <li><a href="shfw.jsp">豪车凹陷修复</a></li>
          <li><a href="shfw.jsp">定期上门维修保养服务</a></li>
          <li><a href="shfw.jsp">预约保养工时优惠</a></li>
        </ul>
      </div>
      <div class="fDl left dInline "> <strong>关于亿金</strong>
        <ul>
        <li><a href="about.jsp" target="_blank">亿金简介</a></li>
        <li><a href="Trends_showNewsList.action" target="_blank">亿金动态</a></li>
        <li><a href="Trends_showActive.action" target="_blank">活动中心</a></li>
          
        <li><a href="contact.jsp" target="_blank">联系亿金</a></li>
          
        </ul>
      </div>
     
      <div class="fDl left dInline fDl1">
        <div class="dLx"> <img src="images/dLx.jpg"/> </div>
        <div style="height:50px;"></div>
      </div>
    </div>
  </div>
  <div class="foot-b"> Copyright © 2015 qcauto All Rights Reserved 河南亿金有限公司 版权所有 豫ICP备123456789号<br/>
    地址：郑州市管城区紫荆山东大街裕鸿花园 服务热线：400-888-6666<br/>
     </div>
</div>
<!--底部的结束-->

<!--右侧内容的开始-->
<c:if test="${!empty userinfo }">
<div id="miniBus" style="right:-270px;">
	<div class="mini-bar">
		<div class="mini-barlist">
			<ul>
			
				
				<li class="callItem">
					<div class="mini-mi callback">
						<i class="mini-ease"></i>
						<code></code>
						<span>意见反馈</span>
					</div>
				</li>
				<li class="miItem">
					<div class="mini-mi shopping">
						<i class="mini-ease"></i>
						<code></code>
						<span>对比车辆</span>
						
					</div>
				</li>
			</ul>
		</div>
		<a class="mini-gotop"></a>
		<a class="wx1"><img src="images/wx_1.png"></a>
		<div class="wmImg hide">
			<img src="images/wx_2.png">
		</div>
	</div>
	<div class="mini-cont">
		<div class="mini-contlist">
			
		
			<!--<div class="mini-ni">
				<div class="mini-h clearfix">
					<a class="mini-close mini-ease lf-fl"></a>
					<span class="lf-fr"><code>在线客服</code></span>
				</div>
			</div>-->
			<div class="mini-ni" id="shopping">
				<div class="mini-h clearfix">
					<a class="mini-close mini-ease lf-fl"></a>
					<span class="lf-fr"><code>对比车辆</code></span>
                    <span class="lf-fr" style="margin:auto 10px; font-size:26px; font-weight:bolder" id="deletealldb"><a><code>×</code></a></span>
				</div>
                <div class="miList" id="Carduibi">
					<ul>
											</ul>
					
					 <c:if test="${!empty pareCarInfo }">
					 <a href="CarInfo_zjbj.action" class="mini-fav">立即对比</a>
					 <c:forEach var="pareCarInfo" items="${ pareCarInfo }">
					 <a href="CarInfo_showDetails.action?uid=${pareCarInfo.value.uId }&cid=${pareCarInfo.value.cId }" target="_blank">${pareCarInfo.value.cBrand }${pareCarInfo.value.cSeries } ${pareCarInfo.value.cReleaseyear } 款 ${pareCarInfo.value.cVolume }L ${pareCarInfo.value.cGeartype } ${pareCarInfo.value.cCode } ${pareCarInfo.value.cModel }</a><br>
					 </c:forEach>
					 </c:if>
					 <c:if test="${empty pareCarInfo }">
					 您还没有添加要比较的车辆哦~
					 </c:if>
				</div>
			</div>
		</div>
	</div>
	<div class="lf-view" id="lf-view">
    	<form onsubmit="return Lmessage();" enctype="multipart/form-data" method="post" name="leaveMess" id="leaveMess">
		<b>您对我们的看法~</b>
		<div>
			<textarea placeholder="您的声音对我们很重要哟(必填)~" id="bankAuthSrc" name="bankAuthSrc"></textarea>
		</div>
		<div>
			<a id="viewSubmit" onclick="udelete()"></a>
            		</div>
        </form>
		<a id="viewClose"></a>
		<i id="viewIcon"></i>
		<p id="viewSign"></p>
	</div>
</div>
</c:if>
<!--右侧内容的结束-->
<!--会员登录和注册弹出框开始-->
<c:if test="${empty loginmessage and empty regmessage }">
<div id="popBox"  style="display: none" >
  <div class="popCont"  > <a class="p_closed" onclick="closedd()">关闭</a>
    <div class="p-tab" id="ptab"> <a  onclick="sendLogin()" >会员登录<i></i></a><a onclick="sendLogin()">会员注册<i></i></a> </div>
    <div class="p-detail" >
      <div class="p-dl" id="login" style="display: none"  >
        <form  action="UserInfo.action" method="post" name="form" id="form" onsubmit="return chekLogin('username','userpwd','yzm','_yzm','d1','d2','d3')">
          <input type="hidden" name="op" value="login">
          <input type="hidden" name="url" value="forward:/CarInfo_showCompare.action?cid=${cid}&uid=${uid}">
          <ul class="login-items">
            <li>
              <label>用户名(手机号)</label>
              <input class="input" type="text"  maxlength="32" id="username"  name="username" placeholder="请输入您的手机号" onblur="chekUserName('username','d1')">
           <div id="d1" style="display: inline">
           <c:if test="${loginmessage!='k' }">
           <font color="red">${loginmessage}</font>
           </c:if>
           </div> </li>
            <li>
              <label>密码</label>
              <input class="input" type="password"  maxlength="16" id="userpwd" name="userpwd" placeholder="请输入您的密码" onblur="chekUserPwd('userpwd','d2')">
             <div id="d2" style="display: none"></div></li>
          <li>
              <label>验证码</label>
              <input type="hidden" id="_yzm" name="_yzm" value="${sRand }" >
              <input class="input" type="text"  maxlength="16" id="yzm" name="yzm" placeholder="请输入验证码" onblur="chekYzm('yzm','_yzm','d3')" >
             <div id="uyzm"><a onclick="sendUpdateYzm()" ><img src="images/${sRand }.jpg" ></a></div><div id="d3" style="display: none"></div></li>
          </ul>
          <div class="login-check">
            <input type="checkbox" name="checkbox" style=" width:auto;" />
            <label>记住我</label>
            <a href="Meet/editPass">忘记登录密码？</a> </div>
          <div class="login-button">
          
            <input type="submit"  value="登&nbsp;&nbsp;&nbsp;&nbsp;陆" class="fM"  />
          </div>
          <!--<div class="security-pro">
			            <i class="icons ver-green-down"></i>
			            <b>您的信息已通过256位SGC加密保护，数据传输安全</b>
			        </div>-->
        </form>
      </div>
      <div class="p-dl" id="uureg">
         <form class="registForm" action="UserInfo_regUser.action" onsubmit="return chekReg('regname','regpwd','regyzm','_regyzm','realname','d9','d6','d7','d5')"  method="post" name="reg" id="reg">
          <ul class="login-items">
            <li class="clearfix">
              <input class="input" name="regname" id="regname" type="text"  placeholder="手机号码（登录帐号）" onblur="chekUserName('regname','d9')">
            <div id="d9" style="display: none"></div></li>
           
            <li class="clearfix">
              <input class="input" type="text" id="realname" name="realname" placeholder="姓名" onblur="chekName('realname','d5')">
             <div id="d5" style="display: none"></div></li>
            <li class="clearfix sex">
              <input type="radio" checked="" name="gender" value="男" />
              男&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="gender" value="女" />
              女 </li>
            <li class="clearfix">
              <input id="" class="input" type="password" name="regpwd" id='regpwd' placeholder="输入密码（六位字符）" onblur="chekUserPwd('regpwd','d6')">
             <div id="d6" style="display: none"></div></li>
             <li class="clearfix">
            <input type="hidden" id="_regyzm" name="_regyzm" value=${sRand }>
              <input class="input left" type="text" value=""  name="regyzm" id="regyzm" placeholder="输入验证码" style="width:100px;" onblur="chekYzm('regyzm','_regyzm','d7')" />
              <div id="uiyzm"><a onclick="sendUpdateYzm()"><img src="images/${sRand }.jpg"></a></div>
              <div id="d7"></div>
            </li>
          </ul>
          <div class="login-button">
             <input type="hidden" name="op" value="reguser">
             <input type="hidden" name="url" value="forward:/CarInfo_showCompare.action?cid=${cid}&uid=${uid}">
            <input type="submit"  value="立即注册" class="fM"  />
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</c:if>
<c:if test="${!empty loginmessage }">
<div id="popBox"  style="display: inline" >
  <div class="popCont" > <a class="p_closed" onclick="closedd()">关闭</a>
    <div class="p-tab" id="ptab"> <a class="on" onclick="sendLogin()" >会员登录<i></i></a><a onclick="sendReg()">会员注册<i></i></a> </div>
    <div class="p-detail"  >
      <div class="p-dl" style="display: inline" id="login" >
        <form  action="UserInfo.action" method="post" name="form" id="form" onsubmit="return chekLogin('username','userpwd','yzm','_yzm','d1','d2','d3')">
          <input type="hidden" name="op" value="login">
          <input type="hidden" name="url" value="forward:/CarInfo_showCompare.action?cid=${cid}&uid=${uid}">
          <ul class="login-items">
            <li>
              <label>用户名(手机号)</label>
              <input class="input" type="text"  maxlength="32" id="username"  name="username" placeholder="请输入您的手机号" onblur="chekUserName('username','d1')">
           <div id="d1" style="display: inline">
           <c:if test="${loginmessage!='k' }">
           <font color="red">${loginmessage}</font>
           </c:if>
           </div> </li>
            <li>
              <label>密码</label>
              <input class="input" type="password"  maxlength="16" id="userpwd" name="userpwd" placeholder="请输入您的密码" onblur="chekUserPwd('userpwd','d2')">
             <div id="d2" style="display: none"></div></li>
          <li>
              <label>验证码</label>
              <input type="hidden" id="_yzm" name="_yzm" value="${sRand }" >
              <input class="input" type="text"  maxlength="16" id="yzm" name="yzm" placeholder="请输入验证码" onblur="chekYzm('yzm','_yzm','d3')" >
             <div id="uyzm"><a onclick="sendUpdateYzm()" ><img src="images/${sRand }.jpg" ></a></div><div id="d3" style="display: none"></div></li>
          </ul>
          <div class="login-check">
            <input type="checkbox" name="checkbox" style=" width:auto;" />
            <label>记住我</label>
            <a href="Meet/editPass">忘记登录密码？</a> </div>
          <div class="login-button">
          
            <input type="submit"  value="登&nbsp;&nbsp;&nbsp;&nbsp;陆" class="fM"  />
          </div>
          <!--<div class="security-pro">
			            <i class="icons ver-green-down"></i>
			            <b>您的信息已通过256位SGC加密保护，数据传输安全</b>
			        </div>-->
        </form>
      </div>
      <div class="p-dl" id="uureg">
         <form class="registForm" action="UserInfo_regUser.action" onsubmit="return chekReg('regname','regpwd','regyzm','_regyzm','realname','d9','d6','d7','d5')"  method="post" name="reg" id="reg">
          <ul class="login-items">
            <li class="clearfix">
              <input class="input" name="regname" id="regname" type="text"  placeholder="手机号码（登录帐号）" onblur="chekUserName('regname','d9')">
            <div id="d9" style="display: none"></div></li>
           
            <li class="clearfix">
              <input class="input" type="text" id="realname" name="realname" placeholder="姓名" onblur="chekName('realname','d5')">
             <div id="d5" style="display: none"></div></li>
            <li class="clearfix sex">
              <input type="radio" checked="" name="gender" value="男" />
              男&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="gender" value="女" />
              女 </li>
            <li class="clearfix">
              <input id="" class="input" type="password" name="regpwd" id='regpwd' placeholder="输入密码（六位字符）" onblur="chekUserPwd('regpwd','d6')">
             <div id="d6" style="display: none"></div></li>
             <li class="clearfix">
            <input type="hidden" id="_regyzm" name="_regyzm" value=${sRand }>
              <input class="input left" type="text" value=""  name="regyzm" id="regyzm" placeholder="输入验证码" style="width:100px;" onblur="chekYzm('regyzm','_regyzm','d7')" />
              <div id="uiyzm"><a onclick="sendUpdateYzm()"><img src="images/${sRand }.jpg"></a></div>
              <div id="d7"></div>
            </li>
          </ul>
          <div class="login-button">
             <input type="hidden" name="op" value="reguser">
             <input type="hidden" name="url" value="forward:/CarInfo_showCompare.action?cid=${cid}&uid=${uid}">
            <input type="submit"  value="立即注册" class="fM"  />
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</c:if>
<c:if test="${!empty regmessage }">
<div id="popBox"  style="display: inline" >
  <div class="popCont" > <a class="p_closed" onclick="closedd()">关闭</a>
    <div class="p-tab" id="ptab"> <a onclick="sendLogin()" >会员登录<i></i></a><a  onclick="sendReg()" class="on">会员注册<i></i></a> </div>
    <div class="p-detail" >
      <div class="p-dl"   id="login" >
        <form  action="UserInfo.action" method="post" name="form" id="form" onsubmit="return chekLogin('username','userpwd','yzm','_yzm','d1','d2','d3')">
          <input type="hidden" name="op" value="login">
          <input type="hidden"  name="url" value="forward:/CarInfo_showCompare.action?cid=${cid}&uid=${uid}">
          <ul class="login-items">
            <li>
              <label>用户名(手机号)</label>
              <input class="input" type="text"  maxlength="32" id="username"  name="username" placeholder="请输入您的手机号" onblur="chekUserName('username','d1')">
           <div id="d1" style="display: inline">
            <c:if test="${loginmessage!='k' }">
           <font color="red">${loginmessage}</font>
           </c:if>
           </div> </li>
            <li>
              <label>密码</label>
              <input class="input" type="password"  maxlength="16" id="userpwd" name="userpwd" placeholder="请输入您的密码" onblur="chekUserPwd('userpwd','d2')">
             <div id="d2" style="display: none"></div></li>
          <li>
              <label>验证码</label>
              <input type="hidden" id="_yzm" name="_yzm" value="${sRand }" >
              <input class="input" type="text"  maxlength="16" id="yzm" name="yzm" placeholder="请输入验证码" onblur="chekYzm('yzm','_yzm','d3')" >
       <div id="uyzm"><a onclick="sendUpdateYzm()"><img src="images/${sRand }.jpg" ></a></div><div id="d3" style="display: none"></div></li>
          </ul>
          <div class="login-check">
            <input type="checkbox" name="checkbox" style=" width:auto;" />
            <label>记住我</label>
            <a href="Meet/editPass">忘记登录密码？</a> </div>
          <div class="login-button">
            <input type="hidden" value="" name="carid" class="ordercarid" />
            <input type="hidden" value="" name="carstatus" class="orderstatus" />
            <input type="submit"  value="登&nbsp;&nbsp;&nbsp;&nbsp;陆" class="fM"  />
          </div>
          <!--<div class="security-pro">
			            <i class="icons ver-green-down"></i>
			            <b>您的信息已通过256位SGC加密保护，数据传输安全</b>
			        </div>-->
        </form>
      </div>
      <div class="p-dl" style="display: inline" id="uureg">
        <form class="registForm" action="UserInfo_regUser.action" onsubmit="return chekReg('regname','regpwd','regyzm','_regyzm','realname','d9','d6','d7','d5')"  method="post" name="reg" id="reg">
          <ul class="login-items">
            <li class="clearfix">
              <input class="input" name="regname" id="regname" type="text"  placeholder="手机号码（登录帐号）" onblur="chekUserName('regname','d9')">
            <div id="d9" style="display: inline"><c:if test="${regmessage!='k' }">
           <font color="red">${regmessage}</font>
           </c:if> </div></li>
           
            <li class="clearfix">
              <input class="input" type="text" id="realname" name="realname" placeholder="姓名" onblur="chekName('realname','d5')">
             <div id="d5" style="display: none"></div></li>
            <li class="clearfix sex">
              <input type="radio" checked="" name="gender" value="男" />
              男&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="radio" name="gender" value="女" />
              女 </li>
            <li class="clearfix">
              <input id="" class="input" type="password" name="regpwd" id='regpwd' placeholder="输入密码（六位字符）" onblur="chekUserPwd('regpwd','d6')">
             <div id="d6" style="display: none"></div></li>
             <li class="clearfix">
            <input type="hidden" id="_regyzm" name="_regyzm" value=${sRand }>
              <input class="input left" type="text" value=""  name="regyzm" id="regyzm" placeholder="输入验证码" style="width:100px;" onblur="chekYzm('regyzm','_regyzm','d7')" />
              <div id="uiyzm"><a onclick="sendUpdateYzm()"><img src="images/${sRand }.jpg"></a></div>
              <div id="d7"></div>
            </li>
          </ul>
          <div class="login-button">
             <input type="hidden" name="op" value="reguser">
             <input type="hidden" name="url" value="forward:/CarInfo_showCompare.action?cid=${cid}&uid=${uid}">
            <input type="submit"  value="立即注册" class="fM"  />
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</c:if>
<!--会员登录和注册弹出框结束-->


<script type="text/javascript" src="js/miniBar.js"></script> 
<script type="text/javascript" src="js/lg_reg.js"></script> 
<script type="text/javascript">
$(function(){
	//表单选择
   $(".select").click(function(e){
        e.stopPropagation();
        $(".select-open").addClass("hide");
        $(this.parentNode).find(".select-open").removeClass("hide");
    });
    $(document.body).click(function() {
        $(".select-open").addClass("hide");
    });
   // alert($('.cbDl').length);
    $('.brand-cata li').click(function(){
    	var index=$(this).index();
    	var t=$('#choose-brand .choose-box');
    	var $sH=t.scrollTop()+($('.cont-tit').eq(index).offset().top-t.offset().top);
    	$('#choose-brand .choose-box').animate({scrollTop:$sH},500);
    })
    
  	$('.car-select').each(function(){
  		 var sTxt=$(this).find('.display-text');

  		 $(this).find('.choose-cont').click(function(){
	    	sTxt.text($(this).text());
	    	$(this).find('.select-open').addClass("hide");
	    });
  	})
 	
 	$('.carSutl_top').click(function(){
 		$('.carSutl_top').removeClass('cur')
 		$(this).addClass('cur');
 		$(this).parent('li').find('.con').stop(true,true).slideDown();
 		$(this).parent('li').siblings().find('.con').stop(true,true).slideUp();
 	})

})
</script> 
  </body>
</html>
