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
    
    <title><c:if test="${!empty detailsMap }">
  <c:forEach var="detailsMap" items="${detailsMap }">
  ${detailsMap.value.cBrand } ${detailsMap.value.cSeries }${detailsMap.value.cReleaseyear } 款 ${detailsMap.value.cVolume }T ${detailsMap.value.cGeartype } ${detailsMap.value.cCode } ${detailsMap.value.cModel }
  </c:forEach>
  </c:if>我要买车-郑州高品质二手车专家_河南亿金名车广场</title>
    
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
<link rel="stylesheet" type="text/css" href="css/pro.css">
<link rel="stylesheet" type="text/css" href="css/alert.css">
<link rel="stylesheet" type="text/css" href="css/my.css">
<!--<link rel="stylesheet" type="text/css" href="css/jquery.fancybox-1.3.4.css">
<link rel="stylesheet" type="text/css" href="css/jquery.ad-gallery.css">-->
<link rel="stylesheet" href="css/quanju.css" type="text/css" media="all">
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

function sendSc(c_id,c_uid){
 var url = "<%=basePath%>MemberCenter_needsc.action?c_id="+c_id+"&c_uid="+c_uid+"&nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getSc; 
     xmlhttp.send(null); 
  } 
} 


function getSc(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
    var data=xmlhttp.responseText;
   
    showDiv(data);
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

function sendDg(c_id,c_uid,nop){
 var url = "<%=basePath%>MemberCenter_"+nop+".action?c_id="+c_id+"&c_uid="+c_uid+"&nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getDg; 
     xmlhttp.send(null); 
  } 
} 


function getDg(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
    var data=xmlhttp.responseText;
    
   
   if(data=="pass"){
   
   window.location.href="admin/submitOrder.jsp";
   }
   else{
    showDiv(data);
    }
  }
}

</script>
<script type="text/javascript">
function showDiv(data){
var strs=new Array();
strs=data.split(":");

 var a =document.getElementById("popDiv");
 a.style.display="block";
 a.innerHTML=""+strs[0]+"<br/><a href='MemberCenter_showmenberSc.action'>"+strs[1]+"</a><br/><a href='javascript:closeDiv()'>关闭窗口</a>";
 var b=document.getElementById("popIframe")
b.style.display="block";
var c=document.getElementById("bg")
c.style.display="block";
}
function closeDiv(){
document.getElementById("popDiv").style.display="none";
document.getElementById("bg").style.display="none";
document.getElementById("popIframe").style.display="none";

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
    <div class="wrap clearfix"> <a href="#" class="logo left"><img src="images/logo.png"/></a>
      <div class="nav left dInline" id="headerMenu">
      <a href="CarInfo.action">首页</a>
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
      <tr><td>            

       <input type="hidden" name="url" value="forward:/CarInfo_showDetails.action?cid=${cid}&uid=${uid}">
      </td></tr>
      </table>
      </form>
      </c:if>
      </span> </div>
  </div>
  <div class="head-search">
    <div class="wrap clearfix">
      <div class="yjxj clearfix left" action="/index/keyword/" method="post" enctype="multipart/form-data">
         <form action="CarInfo_showList.action" method="get">
        <input type="hidden" name="op" value="showlist">
        <input type="text" name="bname" placeholder="请输入您想要的品牌搜索" class="left" />
        <input type="submit" value="搜 索" class="right" />
        </form>
      </div>
      <div class="hotWords left dInline"> 热门品牌：
 <c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
                        <a href="CarInfo_showList.action?bname=${ showcar.value.cBrand}&cser=${showcar.value.cSeries}" >${ showcar.value.cBrand}${showcar.value.cSeries}</a>
            
            </c:forEach>
            </c:if>      </div>
    </div>
  </div>
</div>
<style type="text/css">
#header{position:absolute;}
.nav_fixed{position:fixed;top:0px;}
* html .nav_fixed{position:absolute;bottom:auto;top:expression(eval(document.documentElement.scrollTop));}
.mTags span.right{font-size:14px;padding-top:4px;display:inline-block;}
.mTags span.right a{font-size:14px;color:#f60;}
.l_dizhi{height:35px; line-height:35px;}
.l_dizhi img{vertical-align: middle;position:relative;top:-1px;}
#jShow{position:absolute;left:0;top:0;color:#fff;background:#d00;width:20px;text-align: center;z-index: 100;padding:10px;font-size:18px;font-weight: bold;}
</style>
<div id="about">
  <div class="mTags wrap"> <a href="#">亿金名车广场</a>><a href="#">我要买车</a>><a href="#"><c:if test="${!empty detailsMap }">
  <c:forEach var="detailsMap" items="${detailsMap }">
  ${detailsMap.value.cBrand } ${detailsMap.value.cSeries }${detailsMap.value.cReleaseyear } 款 ${detailsMap.value.cVolume }T ${detailsMap.value.cGeartype } ${detailsMap.value.cCode } ${detailsMap.value.cModel }
  </c:forEach>
  </c:if></a> <span class="right">对这辆车不满意，我要 <c:if test="${!empty userinfo }"><a href="CarInfo_showsrdz.action">私人订制</a></c:if>
       <c:if test="${empty userinfo }"><a onclick="sendLogin()">私人订制</a></c:if> </span> </div>
  <div class="wrap clearfix buyTop" style="padding-bottom:40px;">
    <div class="left dInline" style="width:592px;" >
      <!--图片切换部分开始-->
      <div id="play">
  <ul class="img_ul">
    <li style="display:block;">
   <c:if test="${!empty carImagesInfo }">
  <c:forEach var="carImagesInfo" items="${carImagesInfo }">
    <a class="img_a"><img src="${carImagesInfo.value }"></a></li><li>
      </c:forEach>
  </c:if>
    
  </ul>
  <a href="javascript:void(0)" class="prev_a change_a" title="上一张"> <span></span></a> 
  <a href="javascript:void(0)" class="next_a change_a" title="下一张"> <span style="display: inline; "></span> </a> 
</div>
  
<div class="img_hd">
  <ul class=" clearfix1">
  <c:if test="${!empty carImagesInfo }">
  <c:forEach var="carImagesInfo" items="${carImagesInfo }">
  <li><a class="img_a"><img src="${carImagesInfo.value }" onload="imgs_load(this)"></a></li>
  </c:forEach>
  </c:if>
  
  </ul>
  <a class="bottom_a prev_a" style="opacity: 0.7; "></a> 
  <a class="bottom_a next_a" style="opacity: 0.7; "></a> 
</div>
      <!--图片切换部分结束-->
    </div>
    <c:if test="${!empty  detailsMap}">
    <c:forEach var="detailsMap" items="${detailsMap }">
    <div class="buyTxt right dInline">
      <h1>${detailsMap.value.cBrand } ${detailsMap.value.cSeries }${detailsMap.value.cReleaseyear } 款 ${detailsMap.value.cVolume }T ${detailsMap.value.cGeartype } ${detailsMap.value.cCode } ${detailsMap.value.cModel }</h1>
      <div class="byDl clearfix">
        <div class="price" style="width:235px;">
          <p>亿金
            一口                    价：</p>
          <span class="num nBlue"> ${detailsMap.value.cPrice } </span> <font>万元</font>
          <p style="padding-top:6px;"> <span style="color:#666"></span></p>
          <div class="" style="color:#2e71b8;"> </div>
        </div>
        <div class="right dInline jPrice" style="line-height:22px;"> 
     新车价:${detailsMap.value.newprice }万<br>
      为您节省:${detailsMap.value.newprice-detailsMap.value.cPrice }万
          <!--<a id="dBtn" style="display:block;" href="#showdiv"> <img src="images/btn1.png" width="18" /> 计算分期详情 </a> --></div>
      </div>
      <div class="byDl clearfix byDl_tab"> <span class="left bItem">
        <div> 上牌时间
          <p>${detailsMap.value.cLicencetime }</p>
        </div>
        </span> <span class="left bItem">
        <div> 行驶里程
          <p>${detailsMap.value.cDistance }万公里</p>
        </div>
        </span> <span class="left bItem">
        <div> 排量
          <p>${detailsMap.value.cVolume }T</p>
        </div>
        </span> <span class="left bItem">
        <div> 排放标准
          <p>${detailsMap.value.cEmissionstandard }</p>
        </div>
        </span> </div>
      <div class="byBtn clearfix"> <c:if test="${empty userinfo }"><a onclick="sendLogin()" >立即抢定</a> </c:if><c:if test="${!empty userinfo }"><a  onclick="sendDg(${detailsMap.value.cId },${detailsMap.value.uId },'needdg')" >立即抢定</a> </c:if><a href="CarInfo_showCompare.action?uid=${detailsMap.value.uId }&cid=${detailsMap.value.cId }" class="balance_2">加入对比</a>
        <div class="jiathis_style_32x32"> <c:if test="${empty userinfo }"><a onclick="sendLogin()"  class="jiathis " style="text-decoration:none; text-align:center;display:inline-block;height:35px;  margin-right:12px">收藏</a> </c:if> <c:if test="${!empty userinfo }"><a onclick="sendSc(${detailsMap.value.cId },${detailsMap.value.uId })"  class="jiathis " style="text-decoration:none; text-align:center;display:inline-block;height:35px;  margin-right:12px">收藏</a> </c:if></div>
        <!--<a href="#">置换</a>--> 
        
        <!--<a href="javascript:void(0)" onclick="tongzhi('2','fs')">发送到手机</a>没有登录调用-->
        
        <input type="hidden" class="CarValue_2" value="{img:'/Uploads/PhotoGalley/2015-08-31/55e40527bdbd9.JPG-thumb.JPG',id:'2',price:'74.8',status:'加入对比',title:'路虎 发现(进口) 2014 款 3.0T 自动 四代SDV6 HSE',url:'/Cars/index/channel/2/id/2.html'}">
      </div>
      <div class="b_ly clearfix"> <img src="images/tel1.png"/>　看车电话 <b>销售热线 (400-888-666)</b> <span class="right"> <a id="QQZXFR" name=""><img src="images/qq1.png"/> 在线咨询</a> 
        <script type="text/javascript">
BizQQWPA.addCustom({aty: '0', a: '0', nameAccount: 400-888-666, selector: 'QQZXFR'});
</script> 
        <a class="xsWx"> <img src="images/wx1.png"/> 微信咨询
        <div class="wx-img"> <img src="images/55e40d5761eac.jpg"/> </div>
        </a> </span>
   
      </div>
    </div>
    </c:forEach>
    </c:if>
  </div>
  <div class="wrap speciality lazy-mod" id="speciality">
    <ul class="clearfix unstyled">
      <li class="notbad" style="width:148px"> <span> <i></i> </span> <em>杜绝事故车</em> </li>
      <li class="choiceness" style="width:148px"> <span> <i></i> </span> <em>精选优质名车</em> </li>
      <li class="check_360" style="width:148px"> <span> <i></i> </span> <em>365项检测认证</em> </li>
      <li class="new_car_standa" style="width:148px"> <span> <i></i> </span> <em>准新车上市车标准</em> </li>
      <li class="O2O" style="width:148px"> <span> <i></i> </span> <em>待售车辆专人护理</em> </li>
      <li class="km" style="width:148px"> <span> <i></i> </span> <em>5千公里无需保养</em> </li>
      <!--<li class="free_year_check">
	            <span>
	                <i></i>
	            </span>
	            <em>终身免费车辆年检</em>
	        </li>-->
      <li class="one_year_ok" style="width:148px"> <span> <i></i> </span> <em>一年或2万公里无忧质保</em> </li>
      <!--<li class="free_upkeep">
	            <span>
	                <i></i>
	            </span>
	            <em>一年免费保养</em>
	        </li>-->
      <li class="hover_24" style="width:148px"> <span> <i></i> </span> <em>24小时道路救援</em> </li>
    </ul>
  </div>
  <div class="wrap">
    <div class="buyDetail">
      <div class="b_tab_nav">
        <div class="b-tab"> <a class="on b_ta" href="#cBox1" data-scroll data-speed="1000">基本信息<i></i></a>  <!--<a href="../../../../../Apply/Index/channel/5/id/2.html#jisuanqi">贷款计算器<i></i></a>--> <span style="float:right;font-size:14px;color: #2e71b8; margin-right:30px;"><b>看车电话：销售部 (400-888-666)</b></span> </div>
      </div>
      <div class="b-cont">
      <c:forEach var="detailsMap" items="${detailsMap }">
        <div id="cBox1" class="c_box">
          <h2>${detailsMap.value.cBrand } ${detailsMap.value.cSeries }${detailsMap.value.cReleaseyear } 款 ${detailsMap.value.cVolume }T ${detailsMap.value.cGeartype } ${detailsMap.value.cCode } ${detailsMap.value.cModel }</h2>
          <div class="cbox-a">
            <div class="ca-table">
              <table>
                <tr>
                  <td class="ca-td1">上牌时间</td>
                  <td>${detailsMap.value.cLicencetime }</td>
                  <td class="ca-td1">年检到期时间</td>
                  <td>${basicInfo.aidd }</td>
                  <td class="ca-td1">强险到期时间</td>
                  <td>${basicInfo.srdt }</td>
                  <td class="ca-td1">车辆编号</td>
                  <td>${basicInfo.cId }</td>
                </tr>
                <tr>
                  <td class="ca-td1">车身颜色</td>
                  <td>${basicInfo.bodycolor }</td>
                  <td class="ca-td1">车体形式</td>
                  <td>${detailsMap.value.cType }</td>
                  <td class="ca-td1">变速箱</td>
                  <td>${hardwareConfig.cvt }</td>
                  <td class="ca-td1">排量</td>
                  <td>${detailsMap.value.cVolume }T</td>
                </tr>
                <tr>
                  <td colspan="8"><p>亿金名车，您身边的二手车专家！</p></td>
                </tr>
              </table>
            </div>
            <div class="ca-dl"> <span class="caItem on">基本信息</span>
              <div class="clearfix">
                <div class="jb_infor left">
                  <table>
                    <tr>
                      <td width="270">排放标准</td>
                      <td>${detailsMap.value.cEmissionstandard }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">联系人</td>
                      <td class="ca-td1">销售热线  (15737112660)</td>
                    </tr>
                  </table>
                </div>
                <div class="jb_infor right">
                  <table>
                    <tr>
                      <td width="270">行驶里程</td>
                      <td>${detailsMap.value.cDistance }万公里</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">车源状态</td>
                      <td class="ca-td1">${detailsMap.value.cState }</td>
                    </tr>
                  </table>
                </div>
                <div class="jb_infor left">
                  <table>
                    <tr>
                      <td width="270">内饰颜色</td>
                      <td>${basicInfo.interiorcolor }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">出厂日期</td>
                      <td class="ca-td1">${basicInfo.domf }</td>
                    </tr>
                  </table>
                </div>
                <div class="jb_infor right">
                  <table>
                   
                    <tr>
                      <td >产地</td>
                      <td >${basicInfo.orgin }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1" width="270">商业险到期日</td>
                      <td class="ca-td1">${basicInfo.cimd }</td>
                    </tr>
                  </table>
                </div>
                <div class="jb_infor left">
                  <table>
                    
                    <tr></tr>
                  </table>
                </div>
              </div>
            </div>
            <div class="ca-dl" id="cBox2"> <span class="caItem on">配置信息</span>
              <div class="clearfix">
                <div class="jb_infor left">
                  <table>
                    <tr>
                      <td width="270">导航系统</td>
                      <td>${systemConfig.guidancesystem }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">中控台液晶屏</td>
                      <td class="ca-td1">${hardwareConfig.consolelcdscreen }</td>
                    </tr>
                    <tr>
                      <td width="270">自动头灯</td>
                      <td>${hardwareConfig.autolight }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">后视镜加热</td>
                      <td class="ca-td1">${systemConfig.rvmh }</td>
                    </tr>
                    <tr>
                      <td width="270">发动机启停</td>
                      <td>${systemConfig.ess }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">防抱死制动系统</td>
                      <td class="ca-td1">${systemConfig.alb }</td>
                    </tr>
                    <tr>
                      <td width="270">前驻车雷达</td>
                      <td>${systemConfig.fpg }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">后倒车雷达</td>
                      <td class="ca-td1">${systemConfig.rpg }</td>
                    </tr>
                    <tr>
                      <td width="270">氙气大灯</td>
                      <td>${hardwareConfig.headlights }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">倒车影像系统</td>
                      <td class="ca-td1">${systemConfig.rcpa }</td>
                    </tr>
                    <tr>
                      <td width="270">驾驶员座椅电动调节</td>
                      <td>${systemConfig.dsea }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">副驾驶座椅电动调节</td>
                      <td class="ca-td1">${systemConfig.fsea }</td>
                    </tr>
                    <tr>
                      <td width="270">大灯清洗</td>
                      <td>${hardwareConfig.lightwash }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">电动折叠后视镜</td>
                      <td class="ca-td1">${hardwareConfig.efgv }</td>
                    </tr>
                    <tr>
                      <td width="270">定速巡航</td>
                      <td>${systemConfig.dlcc }</td>
                    </tr>
                  </table>
                </div>
                <div class="jb_infor right">
                  <table>
                    <tr>
                      <td width="270">座位数</td>
                      <td>${hardwareConfig.seatnumber }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">排气量</td>
                      <td class="ca-td1">${detailsMap.value.cVolume }T</td>
                    </tr>
                    <tr>
                      <td width="270">燃料形式</td>
                      <td>${hardwareConfig.fuelform }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">变速箱</td>
                      <td class="ca-td1">${hardwareConfig.cvt }</td>
                    </tr>
                    <tr>
                      <td width="270">驱动方式</td>
                      <td>${hardwareConfig.drivingmethod }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">无钥匙进入</td>
                      <td class="ca-td1">${hardwareConfig.pke }</td>
                    </tr>
                    <tr>
                      <td width="270">无钥匙启动</td>
                      <td>${hardwareConfig.keylessgo }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">全景天窗</td>
                      <td class="ca-td1">${hardwareConfig.sunroof }</td>
                    </tr>
                    <tr>
                      <td width="270">真皮座椅</td>
                      <td>${hardwareConfig.leatherseat }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">前排座椅加热</td>
                      <td class="ca-td1">${systemConfig.hfs }</td>
                    </tr>
                    <tr>
                      <td width="270">后排座椅加热</td>
                      <td>${systemConfig.hrs }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">前排座椅通风</td>
                      <td class="ca-td1">${systemConfig.fsv }</td>
                    </tr>
                    <tr>
                      <td width="270">后排座椅通风</td>
                      <td>${systemConfig.rsv }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">前排座椅记忆</td>
                      <td class="ca-td1">${systemConfig.fsm }</td>
                    </tr>
                    <tr>
                      <td width="270">后排座椅记忆</td>
                      <td>${systemConfig.rsm }</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
            <div class="ca-dl"> <span class="caItem on">手续信息</span>
              <div class="clearfix">
                <div class="jb_infor left">
                  <table>
                    <tr>
                      <td width="270">购置税</td>
                      <td>${procedureInfo.purchasetax }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">行驶证</td>
                      <td class="ca-td1">${procedureInfo.drivinglicense}</td>
                    </tr>
                    <tr>
                      <td width="270">新车质保</td>
                      <td>${procedureInfo.ncw}</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">登记证</td>
                      <td class="ca-td1">${procedureInfo.registration}</td>
                    </tr>
                  </table>
                </div>
                <div class="jb_infor right">
                  <table>
                    <tr>
                      <td width="270">新车发票</td>
                      <td>${procedureInfo.newinvoice}</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">钥匙（把）</td>
                      <td class="ca-td1">${procedureInfo.key}</td>
                    </tr>
                    <tr>
                      <td width="270">过户次数</td>
                      <td>${procedureInfo.transfertimes}</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">过户票</td>
                      <td class="ca-td1">${procedureInfo.transferticket}</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
            <div class="ca-dl"> <span class="caItem on">销售信息</span>
              <div class="clearfix">
                <div class="jb_infor left">
                  <table>
                    <tr>
                      <td width="270">销售价</td>
                      <td>${detailsMap.value.cPrice }（万）</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">含过户费</td>
                      <td class="ca-td1">${sellInfo.transferfee }</td>
                    </tr>
                  </table>
                </div>
                <div class="jb_infor right">
                  <table>
                    <tr>
                      <td width="270">价格类型</td>
                      <td>${sellInfo.pricetype }</td>
                    </tr>
                    <tr>
                      <td class="ca-td1">支持分期</td>
                      <td class="ca-td1">${sellInfo.stage }</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
            <div class="ca-dl"> <span class="caItem on">详细描述</span>
              <div class="clearfix">
                <table>
                  <tr>
                    <td colspan="8"><p>${detailsMap.value.cCzzx }</p></td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        <br/>
        <br/>
        <br/>
        <br/>
        <div id="cBox3" class="c_box">
          <ul class="cPic clearfix">
          <c:if test="${!empty carImagesInfo }">
          <c:forEach var="carImagesInfo" items="${carImagesInfo }">
          
           <li class="center"><img height="342"   src="${carImagesInfo.value }"  /></li>
          
           
          </c:forEach>
          </c:if>
          
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="wrap">
    <div class="y_like">
      <h1>您可能会喜欢</h1>
      <ul class="clearfix">
      <c:if test="${!empty bcar }">
      <c:forEach var="bcar" items="${bcar }">
       <li style="width:250px; height:333px;"> <a href="CarInfo_showDetails.action?uid=${bcar.value.uId }&cid=${bcar.value.cId }" style="width:auto; padding:40px 20px;"> <img src="${bcar.value.cImg}" height="120" />
          <h3>${bcar.value.cBrand}${bcar.value.cSeries}${bcar.value.cReleaseyear}款${bcar.value.cVolume}T ${bcar.value.cGeartype}${bcar.value.cCode}${bcar.value.cModel}</h3>
          <div class="price"> 寄售
            价 <span class="num nBlue">${bcar.value.cPrice}</span> 万 <font> 省：￥ ${bcar.value.newprice-bcar.value.cPrice } 万</font> </div>
          <p>${bcar.value.cLicencetime} | ${bcar.value.cDistance}万公里 |${bcar.value.cVolume}T | ${bcar.value.cEmissionstandard}</p>
          </a> </li>
      </c:forEach>
      </c:if>
       <c:if test="${empty bcar }">
       没有其他同类型的车啦,我们正在努力征集中~~~~~~~~~~~~
       </c:if>
        
      </ul>
    </div>
  </div>
</div>
<div id="popBoxYzm" style="display:none">
  <div class="popForm">
    <div class="p-detail">
      <form action="" enctype="multipart/form-data" method="post" onsubmit="return popYzm();" name="yzmcheck" id="yzmcheck">
        <ul class="login-items" style="width:100%">
          <li>
            <label>手机号</label>
            <input type="text" value="" maxlength="32"  name="mobile" style="width:120px">
            <input type="checkbox" style=" width:auto; margin:10px 20px 0" value="1" name="ckmobile" />
            <label>记住此号</label>
          </li>
          <li>
            <label>验证码</label>
            <input type="text" value="" maxlength="16"  name="verify" style="width:120px; margin-right:20px;">
            <img src="../../../../../Admin/Login/buildVerify.html" id="yzcode" width="100" height="42" alt="点击切换" onclick="this.src='../../../../../Admin/Login/buildVerify.html'"> </li>
        </ul>
        <div class="login-button">
          <input type="hidden" value="" name="sta" id="stames" />
          <input type="hidden" value="2" name="carid" id="caridmes" />
          <input type="button"  value="立即提交" class="fM" onclick="$('#yzmcheck').submit()" style="line-height:20px" />
        </div>
      </form>
    </div>
    <a class="closed">×</a> </div>
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
          <input type="hidden" name="url" value="forward:/CarInfo_showDetails.action?cid=${cid}&uid=${uid}">
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
             <input type="hidden" name="url" value="forward:/CarInfo_showDetails.action?cid=${cid}&uid=${uid}">
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
          <input type="hidden" name="url" value="forward:/CarInfo_showDetails.action?cid=${cid}&uid=${uid}">
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
             <input type="hidden" name="url" value="forward:/CarInfo_showDetails.action?cid=${cid}&uid=${uid}">
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
          <input type="hidden"  name="url" value="forward:/CarInfo_showDetails.action?cid=${cid}&uid=${uid}">
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
             <input type="hidden" name="url" value="forward:/CarInfo_showDetails.action?cid=${cid}&uid=${uid}">
            <input type="submit"  value="立即注册" class="fM"  />
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</c:if>
<!--会员登录和注册弹出框结束-->
<div id="popDiv" class="mydiv" style="display:none;">
</div>
<div id="bg" class="bg" style="display:none;"></div>
<iframe id='popIframe' class='popIframe' frameborder='0' ></iframe>

<script type="text/javascript" src="js/miniBar.js"></script> 
<script type="text/javascript" src="js/lg_reg.js"></script> 
<script type="text/javascript" src="js/smooth-scroll.js"></script> 
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script> 

<script type="text/javascript" src="js/CarLoad.js"></script> 
<!--图片切换-->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script>
	var i=0; //图片标识
var img_num=$(".img_ul").children("li").length; //图片个数
$(".img_ul li").hide(); //初始化图片	
play();
$(function(){
	 $(".img_hd ul").css("width",($(".img_hd ul li").outerWidth(true))*img_num); //设置ul的长度
	 
	 $(".bottom_a").css("opacity",0.7);	//初始化底部a透明度
	 //$("#play").css("height",$("#play .img_ul").height());
	 if (!window.XMLHttpRequest) {//对ie6设置a的位置
	 $(".change_a").css("height",$(".change_a").parent().height());}
	 $(".change_a").focus( function() { this.blur(); } );
	 $(".bottom_a").hover(function(){//底部a经过事件
		 $(this).css("opacity",1);	
		 },function(){
		$(this).css("opacity",0.7);	 
			 });
	 $(".change_a").hover(function(){//箭头显示事件
		 $(this).children("span").show();
		 },function(){
		 $(this).children("span").hide();
			 });
	 $(".img_hd ul li").click(function(){
		 i=$(this).index();
		 play();
		 });
	 $(".prev_a").click(function(){
		 //i+=img_num;
		 i--;
		 //i=i%img_num;
		 i=(i<0?0:i);
		 play();
		 }); 
	 $(".next_a").click(function(){
		 i++;
		 //i=i%img_num;
		 i=(i>(img_num-1)?(img_num-1):i);
		 play();
		 }); 
	 }); 
function play(){//动画移动	
	var img=new Image(); //图片预加载
	img.onload=function(){img_load(img,$(".img_ul").children("li").eq(i).find("img"))};
	img.src=$(".img_ul").children("li").eq(i).find("img").attr("src");
	//$(".img_ul").children("li").eq(i).find("img").(img_load($(".img_ul").children("li").eq(i).find("img")));
	
	$(".img_hd ul").children("li").eq(i).addClass("on").siblings().removeClass("on");
	if(img_num>7){//大于7个的时候进行移动
		if(i<img_num-3){ //前3个
		$(".img_hd ul").animate({"marginLeft":(-($(".img_hd ul li").outerWidth()+4)*(i-3<0?0:(i-3)))});
		}
		else if(i>=img_num-3){//后3个
			$(".img_hd ul").animate({"marginLeft":(-($(".img_hd ul li").outerWidth()+4)*(img_num-7))});
			}
	}
	if (!window.XMLHttpRequest) {//对ie6设置a的位置
	$(".change_a").css("height",$(".change_a").parent().height());}
	}
function img_load(img_id,now_imgid){//大图片加载设置 （img_id 新建的img,now_imgid当前图片）
    
    if(img_id.width/img_id.height>1)
	{
		if(img_id.width >=$("#play").width()) $(now_imgid).width($("#play").width());
		}
	else {
		if(img_id.height>=500) $(now_imgid).height(365);
		}
		$(".img_ul").children("li").eq(i).show().siblings("li").hide(); //大小确定后进行显示
	}
function imgs_load(img_id){//小图片加载设置
	if(img_id.width >=$(".img_hd ul li").width()){img_id.width = 80};
	//if(img_id.height>=$(".img_hd ul li").height()) {img_id.height=$(".img_hd ul li").height();}
	}
	</script>

  
  </body>
</html>
