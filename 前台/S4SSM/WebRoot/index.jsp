<%@page import="javax.imageio.ImageIO"%>
<%@ page language="java" import="java.util.*, java.awt.*,java.awt.image.*,  javax.imageio.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%response.setHeader("Pragma","no-cache");  
			    response.setHeader("Cache-Control","no-catch");  
			    response.setDateHeader("Expires",0);   %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>郑州高品质二手车专家_亿金汽车</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="郑州二手车,河南二手车,郑州二手名车">
	<meta http-equiv="description" content="亿金汽车">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/layout.css">
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <link rel="stylesheet" href="css/jquery.autocomplete.css" type="text/css">
       <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
    <!--[if IE 6]>
    <script type="text/javascript" src="js/DD_belatedPNG.js"></script>
    <script>
        DD_belatedPNG.fix('*');
    </script>
    <![end if]-->
   
    <script   type="text/javascript" >
    
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

function sendSpp(str){
var flag=false;

 var sel=document.all(str)
  var brand=sel.value;
   var div1=document.all("spp");
  var sel2=document.all("sel5");
  var div=document.all("scx");
  var div2=document.all("cx");
  var selq=document.all("selq");
  if(sel.value!="选择品牌"){
  var url = "<%=basePath%>Model.action?brand="+brand+"&nocahe="+new Date().getTime()+"";
  div1.style.display="none";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getSpp; 
     xmlhttp.send(null); 
     flag=true;
     selq.value=sel.options[sel.options.selectedIndex].text;
     
  }
  }
  else{
   sel2.length=0;
    sel2.options.add(new Option("请先选择品牌","请先选择品牌"));
    div.style.display="none";
     div1.style.display="inline";
    div2.style.display="none";
  }
  return flag;
} 

function getSpp(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
     var data=xmlhttp.responseText;
     var div=document.all("cx");
     var json=eval("("+data+")");
     var sel2=document.all("sel5");
     sel2.length=0;
     sel2.options.add(new Option("请选择车系","请选择"))
     for(var i=0;i<json.length;i++){
      sel2.options.add(new Option(json[i].mName,json[i].mName));
     }
      sel2.options.add(new Option("其他","其他"));
      div.style.display="none";
  }
}
 function chekcx(str,str1,str2,str3,str4){
 var div=document.all(str1);
  var div1=document.all(str2);
  var ccx=document.all(str3);
  var srcx=document.all(str4);
 
  var sel2=document.all(str);
  var flag=false;
  if(sel2.value=="请选择"){
  div1.style.display="inline";
  div.style.display="none";
  
  }
  else{
  div1.style.display="none";
  if(sel2.value=="其他"){
  div.style.display="inline";
   ccx.value=srcx.value;
   flag=false;
 }
 else{
  
  div.style.display="none";
  
  ccx.value=sel2.value;
  flag=true;
 }
  }
  return flag;
}
function cheksrcx(str,str1,str2){
 var srcx=document.all(str);
 var div=document.all(str1);
 var ccx=document.all(str2);
 var flag=false;
 if(srcx.value.length==0){
    div.style.display="inline";
   
 }
 else{
     flag=true;
    div.style.display="none";
    ccx.value=srcx.value;
 }
 return flag;
}

function chek (str,str2){
 var text=document.all(str);
 var div=document.all(str2);
 var flag=false;
 if(text.value.length>0){
 if(!isNaN(text.value)){
   if(text.value>0){
   flag=true;
   }
   else{
   div.innerHTML="<font color='red'>请输入正数</font>";
     div.style.display="inline";
   }
 }
 else{
 div.innerHTML="<font color='red'>请输入数字</font>";
     div.style.display="inline";
 }
 }
 else{
  div.style.display="none	";
 flag=true;
 }
 return flag;
 }
 
 function chekSubMit(str,str1,str2,str3,str4){
 var flag=false;
 
 var text=document.all(str);
 var div=document.all(str4);

 var text1=document.all(str1);

 var where=document.all(str3);
  if(chek (str,str4)&&chek(str1,str4)){
    
     if(text1.value.length>0&&text.value.length>0){
     if(text1.value>text.value){
      where.value=text.value+"-"+text1.value+str2;
     flag=true;
     div.style.display="none";
     }
     else {
     div.innerHTML="<font color='red'>上限值小于等于下限值！请重新输入</font>";
     div.style.display="inline";
     }
     }
     else if(text1.value.length==0&&text.value.length>0){
       where.value=text.value+str2+"以上";
     
       div.style.display="none";
       flag=true;
     }
     else if(text1.value.length>0&&text.value.length==0){
     where.value=text1.value+str2+"以内";
     div.style.display="none";
       flag=true;
     }
     else{
    div.innerHTML="<font color='red'>最大值或最小值至少输入一项</font>";
     div.style.display="inline";
     }
    
  }
  
   return flag;
 }
 function chekday(){
  var flag=false;
  var sj= document.all("buytime");
 
  var date=new Date();
  var div=document.all("timediv");
  
  if(sj.value.length==0){
    div.innerHTML="<font color='red'>请选择购买时间</font>"
    div.style.display="inline";
  }
  else{
   var array=sj.value.split("-");
   if(parseInt(array[0])>parseInt(date.getFullYear())){
      flag=true;
       div.style.display="none";
   }
   else{
     if(parseInt(array[1])>parseInt(date.getMonth())){
      flag=true;
       div.style.display="none";
     }
     else{
     if(parseInt(array[2])>parseInt(date.getDate())){
     flag=true;
       div.style.display="none";
     }
      else{
      div.innerHTML="<font color='red'>请选择一个今天以后的时间</font>"
    div.style.display="inline";
      }
     }
   }
  }
  return flag;
 }
 function cheksuub(str,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16,str17,str18,str19,str20,str21,str22,str23){
 
 var flag=false;
 if(sendSpp(str)&&(chekcx(str1,str2,str3,str4,str5)||cheksrcx(str6,str7,str8))&&(chekcx(str9,str10,str11,str12,str13)||chekSubMit(str14,str15,str16,str17,str18))&&chekSubMit(str19,str20,str21,str22,str23)&&chekday()){
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

function sendSrdz(){
if(cheksuub("sel1","sel5","cx","scx","ccx","srcx","srcx","scx","ccx","years","cxi","scxi","ccxi","srcxi","minage","maxage","年","ccxi","chekagee","minprice","maxprice","万","cprice","chekpricee")){
 var sel1=$("#sel1 :selected").text();
 
 var ccx=document.all("ccx").value;
 
 var ccxi=document.all("ccxi").value;
 
 var cprice=document.all("cprice").value;

 var buytime=document.all("buytime").value;
 
 var content=document.all("content").value;
  
 var url = "<%=basePath%>MemberCenter_comment.action?sel1="+sel1+"&ccx="+ccx+"&ccxi="+ccxi+"&cprice="+cprice+"&buytime="+buytime+"&content="+content+"&nocahe="+new Date().getTime()+"";
  
  CreateXMLHttp();
  if(xmlhttp){
  
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getSrdz; 
     xmlhttp.send(null); 
  } 
} 
}

function getSrdz(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
     var data=xmlhttp.responseText;
    alert(data);
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
  </head>
  
  <body>
  <div id="header">
  <div class="top">
    <div class="wrap clearfix"> <a href="#" class="logo left"><img src="images/logo.png"/></a>
      <div class="nav left dInline" id="headerMenu">
      <a class="on" >首页</a>
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
   
      </a>|<a  href="UserInfo_zhuXiao.action?url=forward:/CarInfo.action"  >注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>
      </span> </div>
  </div>
  <div class="head-search">
    <div class="wrap clearfix">
      <div class="yjxj clearfix left" action="/index/keyword/" method="post" enctype="multipart/form-data">
        <form action="CarInfo_showList.action" method="get">
        
        <input type="text" name="bname" placeholder="请输入您想要的品牌搜索" class="left" />
        <input type="submit" value="搜 索" class="right" />
        </form>
      </div>
      <div class="hotWords left dInline">
        热门品牌：<c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
                        <a href="CarInfo_showList.action?bname=${ showcar.value.cBrand}&cser=${showcar.value.cSeries}" >${ showcar.value.cBrand}${showcar.value.cSeries}</a>
            
            </c:forEach>
            </c:if> </div>
    </div>
  </div>
</div>
<style type="text/css">
#banner .prevs,#banner .nexts{position:absolute;top:220px;z-index: 100;margin-top:-25px;}
#banner .nexts{right:0;}
#banner .banShow a{display:block;width: 100%;height:465px;}
</style>
<div id="banner">
  <div class="banShow clearfix" style="width:100%;"> 
    <a href="#" class="bDiv" style="background: url(images/y77.jpg) no-repeat center top;"></a>  
    <a href="#" class="bDiv" style="background:url(images/1.jpg) no-repeat center top;"></a> 
  </div>
  <div class="b_btn wrap"> 
    <!--<a class="prevs"><img src="images/l1.png"></a> 
    <a class="nexts"><img src="images/r1.png"></a>-->   
  </div>
  
  <div class="searchBox">
   <div class="xbg"></div>
   <div class="xnrj">
   <img src="images/in1.png"/>
    <form class="clearfix" action="CarInfo_showList.action" method="get" >
   
      <input type="text" maxlength="" name="bname" placeholder="请输入您想要的品牌搜索" class="left" />
      <input type="submit" value="" class="right" />
    </form></div>
  </div>
  
</div>
<div id="choose-nav">
  <div class="wrap clearfix"> 
    <!-- 品牌 -->
    <div class="item-brand c-item">
      <div class="trigger-icon"></div>
      <div class="brand-wrapper">
        <div class="hd cBlue">品牌</div>
        <div class="bd clearfix"> 
         <c:if test="${!empty showBrandMap }">
        <c:forEach var="showbrand" items="${showBrandMap }">
         <a href="CarInfo_showList.action?bname=${ showbrand.value.bName}" class="brand-item" target="_blank"><img src="${showbrand.value.bImg }" alt="${showbrand.value.bName }"><span>${showbrand.value.bName }</span></a>
         
        </c:forEach>
        </c:if>
        
        </div>
      </div>
      <div class="brand-all clearfix">
        <div class="title">所有品牌</div>
        <div class="brand-list clearfix">
          <div class="left-list">
          <c:if test="${!empty leftszm }">
          <c:forEach var="leftszm" items="${leftszm }">
            <div class="brand-item-l clearfix">
              <div class="letter">${leftszm}</div>
              <div class="brand-letter"> 
              <c:if test="${!empty allbrand }">
              <c:forEach var="allbrand" items="${allbrand }">
              <c:if test="${allbrand.value.bSzm==leftszm }">
              <a target="_blank" href="CarInfo_showList.action?bname=${ allbrand.value.bName}" class="brand-item">${allbrand.value.bName }</a>
              </c:if>
              </c:forEach>
              </c:if>
              </div>
            </div>
            </c:forEach>
            </c:if>
            
          </div>
          <div class="right-list">
           <c:if test="${!empty rightszm }">
          <c:forEach var="rightszm" items="${rightszm }">
            <div class="brand-item-l clearfix">
              <div class="letter">${rightszm}</div>
              <div class="brand-letter"> 
              <c:if test="${!empty allbrand }">
              <c:forEach var="allbrand" items="${allbrand }">
              <c:if test="${allbrand.value.bSzm==rightszm }">
                            <a target="_blank" href="CarInfo_showList.action?bname=${ allbrand.value.bName}" class="brand-item">${allbrand.value.bName }</a>
              
              </c:if>
              </c:forEach>
              </c:if>
              </div>
            </div>
            </c:forEach>
            </c:if>
          </div>
        </div>
      </div>
    </div>
    <!-- 车型 -->
    <div id="choose_model" class="item-model c-item">
      <div class="trigger-icon"></div>
      <div class="model-wrapper">
        <div class="hd cBlue">车型</div>
        <div class="bd"> 
     
          <c:if test="${!empty showType }">
           <c:forEach var="showtype" items="${showType }">
           
            <a href="CarInfo_showList.action?tname=${ showtype.value.tName}" target="_blank"  class="model-item">
            <div class="${showtype.value.tImg}"></div>
          <span class="car-modal-name">${showtype.value.tName }</span></a>
           </c:forEach>
           </c:if>
                    
           </div>
        <div class="model-all clearfix">
        <c:if test="${!empty showType }">
        <c:forEach var="showtype" items="${showType }">
                  <div class="models-line"><a class="models-item-m"  href="CarInfo_showList.action?tname=${ showtype.value.tName}" target="_blank" >${showtype.value.tName }</a>
                  <c:if test="${!empty typecar}">
                  <c:forEach var="typecar" items="${ typecar}">
                  <c:if test="${typecar.value.cType==showtype.value.tName }">
                  <a target="_blank" href="CarInfo_showList.action?bname=${typecar.value.cBrand }&cser=${typecar.value.cSeries }" class="models-item">${typecar.value.cBrand }${typecar.value.cSeries }</a>
                  </c:if>
                  
                  </c:forEach>
                  </c:if>
                  
                  
                  </div>
        
        </c:forEach>
        </c:if>
         
        </div>
      </div>
    </div>
    <!-- 价格 -->
    <div class="item-price">
      <div class="hd cBlue">价格</div>
      <div class="bd">
       <c:if test="${!empty priceMap }">
            <c:forEach var="priceMap" items="${priceMap }">
             <a href="CarInfo_showList.action?price=${priceMap.value.pName}" >${priceMap.value.pName }</a>
            </c:forEach>
            </c:if>
      </div>
    </div>
  </div>
</div>
</div>
<div id="main">
  <div class="main-a mDiv" id="box1">
    <div class="wrap">
      <div class="in-tit clearfix">
        <h1 class="left dInline"> 今日推荐 </h1>
        <!--<div class="end-time right dInline">
					距离结束只剩下<b>20</b>小时<b>50</b>分<b>18</b>秒
				</div>--> 
      </div>
      <div class="inBox clearfix">
      <c:if test="${!empty active1 }">
              <div class="thPic left dInline pve tBox"> <a href="Trends_showTeia.action?tr_id=${active1.trId }"  target="_blank"> <img src="${active1.trImg }" class="imgVt" /> <span class="icon icon_hd"></span></a> </div>
      
      </c:if>
        <div class="tBox right pve dInline thPicRight">
          <div class="thPic1 left dInline pve">
            <ul class="clearfix">
            <c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
            <li class="pve"> <a href="CarInfo_showDetails.action?uid=${showcar.value.uId }&cid=${showcar.value.cId } " target="_blank"> <span class="icon icon_th"></span>
                <div class="car-pic"> <img src="${showcar.value.cImg }" /> </div>
                <div class="price"> <font>一口价</font> <span class="num nBlue">${showcar.value.cPrice} </span> <font>&nbsp;&nbsp;万元</font> </div>
                <p>${showcar.value.cBrand }${showcar.value.cSeries}  ${showcar.value.cReleaseyear}款   ${showcar.value.cVolume}T ${showcar.value.cGeartype} ${showcar.value.cCode}${showcar.value.cModel}</p>
                </a></li>
            </c:forEach>
            </c:if>
              
             
              
            </ul>
          </div>
          <c:if test="${!empty active2 }">
                    <div class="pve right dInline hdPic"> <a href="Trends_showTeia.action?tr_id=${active2.trId }"  target="_blank"> <img src="${active2.trImg }" class="imgVt" /> <span class="icon icon_hd"></span></a> </div>
          
          </c:if>
        </div>
      </div>
    </div>
  </div>
  <div class="mDiv" id="box2">
    <div class="wrap">
      <div class="in-tit clearfix">
        <h1 class="left dInline"> 最新到店 </h1>
      </div>
      <div class="inBox clearfix">
        <div class="tBox left pve dInline thPicRight">
          <div class="thPic1 left dInline pve">
            <ul class="clearfix">
            <c:if test="${!empty newcar }">
            <c:forEach var="newcar" items="${newcar }">
              <li class="pve"> <a href="CarInfo_showDetails.action?uid=${newcar.value.uId }&cid=${newcar.value.cId }" target="_blank"> <span class="icon icon_npro"></span>
                <div class="car-pic"> <img src="${newcar.value.cImg }" /> </div>
                <div class="price"> <font>一口价</font> <span class="num nBlue">${newcar.value.cPrice }</span> <font>&nbsp;&nbsp;万元</font> </div>
                <p>${newcar.value.cBrand }${newcar.value.cSeries } ${newcar.value.cReleaseyear } 款 ${newcar.value.cVolume  }T ${newcar.value.cGeartype  } ${newcar.value.cCode  }${newcar.value.cModel  }</p>
                </a></li>
            </c:forEach>
            </c:if>
            
                
     <c:if test="${!empty active3 }">
                   <li class="pve liHd"> <a href="Trends_showTeia.action?tr_id=${active3.trId }"  target="_blank"> <img src="${active3.trImg }" class="imgVt" /> <span class="icon icon_hd"></span></a> </li>
     
      </c:if>
              
             <c:if test="${!empty fourthcar }">
            <c:forEach var="fourthcar" items="${fourthcar }">
              <li class="pve"> <a href="CarInfo_showDetails.action?uid=${fourthcar.value.uId }&cid=${fourthcar.value.cId }" target="_blank"> <span class="icon icon_npro"></span>
                <div class="car-pic"> <img src="${fourthcar.value.cImg }" /> </div>
                <div class="price"> <font>一口价</font> <span class="num nBlue">${fourthcar.value.cPrice }</span> <font>&nbsp;&nbsp;万元</font> </div>
                <p>${fourthcar.value.cBrand }${fourthcar.value.cSeries } ${fourthcar.value.cReleaseyear } 款 ${fourthcar.value.cVolume  }T ${fourthcar.value.cGeartype  } ${fourthcar.value.cCode  }${fourthcar.value.cModel  }</p>
                </a></li>
            </c:forEach>
            </c:if>
            </ul>
          </div>
        </div>
        <c:if test="${!empty active4 }">
                <div class="thPic right dInline pve tBox"> <a href="Trends_showTeia.action?tr_id=${active4.trId }"  target="_blank"> <img src="${active4.trImg }" class="imgVt" /> <span class="icon icon_hd"></span></a> </div>
        </c:if>
      </div>
    </div>
  </div>
  <div class="mDiv main-a">
    <div class="wrap">
      <div class="in-tit clearfix">
        <h1 class="left dInline"> 精品车源 </h1>
      </div>
      <div class="jpBox">
        <div class="jpTit"> 
        <a class="on"> <img src="images/cLogo.png"/> <span>推荐车源</span> <i></i></a>
        <c:if test="${!empty showBrandMap }">
        <c:forEach var="showbrand" items="${showBrandMap }">
         <a> <img src="${showbrand.value.bImg }" width="50" height="38" /> <span>${showbrand.value.bName }</span> <i></i></a>
        </c:forEach>
        </c:if>
    
        </div>
        <div class="jpCont">
        <div class="jpDl" style="display: block;">
            <ul class="clearfix">
              
             <c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
        <li class="clearfix" style="position: relative;">    <a href="CarInfo_showDetails.action?uid=${showcar.value.uId }&cid=${showcar.value.cId }" target="_blank">
                <div class="carImg left dInline"> <img src="${showcar.value.cImg}" width="266" /> </div>
                <div class="right carTxt right dInline pve">
                  <div class="c-txt">
                    <h3><a href="CarInfo_showDetails.action?uid=${showcar.value.uId }&cid=${showcar.value.cId }" target="_blank">${showcar.value.cBrand }${showcar.value.cSeries}  ${showcar.value.cReleaseyear}款   ${showcar.value.cVolume}T ${showcar.value.cGeartype} ${showcar.value.cCode}${showcar.value.cModel}</a></h3>
                    <p>${showcar.value.cLicencetime } |  ${showcar.value.cDistance }万公里 | ${showcar.value.cVolume }T | ${showcar.value.cEmissionstandard }</p>
                    <div class="price">
                      <p>亿金一口价：</p>
                      <i>￥</i> <span class="num nBlue">${showcar.value.cPrice} </span><font> 万元</font><font>省:￥ 18.77万</font> </div>
                  </div>
                </div>
                </a></li>
                
            </c:forEach>
            </c:if>
          </li> 
            </ul>
             <div class="proMore"> <a href="CarInfo_showList.action" target="_blank">查看更多>></a> </div> 
              </div>
        <c:forEach var="showbrand" items="${showBrandMap }">
         <div class="jpDl" >
            <ul class="clearfix">
          
           
            <c:if test="${!empty brandcar }">
            <c:forEach var="brandcar" items="${brandcar }">
            <c:if test="${brandcar.value.cBrand==showbrand.value.bName }">
            
              <li class="clearfix" style="position: relative;"> 
            <a href="CarInfo_showDetails.action?uid=${brandcar.value.uId }&cid=${brandcar.value.cId }" target="_blank">
                <div class="carImg left dInline"> <img src="${brandcar.value.cImg }" width="266" /> </div>
                <div class="right carTxt right dInline pve">
                  <div class="c-txt">
                    <h3><a href="CarInfo_showDetails.action?uid=${brandcar.value.uId }&cid=${brandcar.value.cId }" target="_blank">${brandcar.value.cBrand }${brandcar.value.cSeries } ${brandcar.value.cReleaseyear } 款 ${brandcar.value.cVolume  }T ${brandcar.value.cGeartype  } ${brandcar.value.cCode  } ${brandcar.value.cModel }</a></h3>
                    <p>${brandcar.value.cLicencetime  } | ${brandcar.value.cDistance }万公里 | ${brandcar.value.cVolume}T | ${brandcar.value.cEmissionstandard }</p>
                    <div class="price">
                      <p>亿金一口价：</p>
                      <i>￥</i> <span class="num nBlue">${brandcar.value.cPrice  } </span><font> 万元</font> <font> 省：￥ 18.77 万</font> </div>
                  </div>
                </div>
                </a>
            </li>
           
            </c:if>
            </c:forEach>
            </c:if> 
            </ul>
             <div class="proMore"> <a href="CarInfo_showList.action?bname=${ showbrand.value.bName}" target="_blank">查看更多>></a> </div> 
              </div>
       
        </c:forEach>
         </div>
      </div>
       </div>
       </div>
  <div class="mDiv">
    <div class="wrap">
      <div class="in-tit clearfix">
        <h1 class="left dInline"> 亿金榜单 </h1>
      </div>
      <div class="bdBox clearfix">
        <div class="left dLeft dInline">
          <ul class="clearfix">
            <li><a href="CarInfo_jybd.action"  target="_blank"> <img src="images/55d2c89756ef2.jpg" /></a></li>
            <li><a href="CarInfo_jybd.action"  target="_blank"> <img src="images/55d2c8be18345.jpg" /></a></li>
            <li><a href="CarInfo_djbd.action"  target="_blank"> <img src="images/55d2c8d1f2f42.jpg" /></a></li>
            <li><a href="CarInfo_djbd.action"  target="_blank"> <img src="images/55d2c8e954f6f.jpg" /></a></li>
          </ul>
        </div>
        <div class="left dRight dInline">
          <link rel="stylesheet" type="text/css" href="css/alert.css">
          <style type="text/css">
input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {color: #000;}
input:-moz-placeholder, textarea:-moz-placeholder {color:#000;}
input::-moz-placeholder, textarea::-moz-placeholder {color:#000;}
input:-ms-input-placeholder, textarea:-ms-input-placeholder {color:#000;}
</style>
          <form  action="MemberCenter_comment.action"  class="dForm" name="dForm" id="dForm"   method="post"  onsubmit="return cheksuub('sel1','sel5','cx','scx','ccx','srcx','srcx','scx','ccx','years','cxi','scxi','ccxi','srcxi','minage','maxage','年','ccxi','chekagee','minprice','maxprice','万','cprice','chekpricee');">
            <h2>私人订制</h2>
            <p>专业车辆顾问为您服务</p>
           
            <table>
              <tr>
                <td> 	<select class="select car-select" name="sel1" id="sel1" style="width:100%" onchange="sendSpp('sel1')">
										<option value="选择品牌">请选择品牌</option>
								  <c:if test="${!empty allbrand }">
                    <c:forEach var="allbrand" items="${allbrand }">
                    <option value=${allbrand.value.bId }>${allbrand.value.bName }</option>
                    </c:forEach>
                    </c:if>
                    </select>
                    <input type="hidden" name="selq" id="selq">
                          <div id="spp" style="display: none"><font color="red">请选择品牌</font></div>
                    
                    </td>
              </tr>
              <tr>
                <td><div id="xlselect">
                    <select class="select car-select" name="sel5" id="sel5" style="width:100%" onchange="chekcx('sel5','cx','scx','ccx','srcx')">
                                        <option value="请选择">请先选择品牌</option>
                                    </select>
                                    <div  class="select-item clearfix" id="cx" style="display: none"><input type="text" placeholder="请输入您的车系" class="select car-select" id="srcx" onblur="cheksrcx('srcx','scx','ccx')"></div>
                                								 <div id="scx" style="display: none"><font color="red">请录入车系信息</font></div>
                                								 <input type="hidden" id="ccx" name="ccx"> 
                  </div></td>
              </tr>
              <tr>
                <td><select name="years" id="years" onchange="chekcx('years','cxi','scxi','ccxi','srcxi')">
                    <option value="请选择">选择使用年限</option>
                    <option value="不限">不限</option>
                      <c:if test="${!empty ageMap }">
                      <c:forEach var="age" items="${ageMap }">
                      <option value="${age.value.aName }">${age.value.aName }</option>
                      </c:forEach>
                      </c:if>
                      <option value="其他">其他</option>
                      
                  </select>
                   <input type="hidden" id="srcxi">
                        <div id="scxi" style="display: none"><font color="red">请录入需求车龄信息</font></div>
                                
                         <input type="hidden" id="ccxi" name="ccxi"> 
                  
                  </td>
              </tr>
              <tr>
              <td>
            <div id="cxi" style="display: none">  <input type="text" id="minage" name="dprice" placeholder="最小车龄" value="" class="cInput" onblur="chekSubMit('minage','maxage','年','ccxi','chekagee')"/>
                  <input type="text" name="hprice" id="maxage" placeholder="最大车龄" value="" class="cInput"  onblur="chekSubMit('minage','maxage','年','ccxi','chekagee')" />
              <div id="chekagee" style="display: none"></div>
              </div>
              </td>
              </tr>
              <tr>
                <td><input type="text" name="dprice" id="minprice" placeholder="最少预算" value="" class="cInput"  onblur="chekSubMit('minprice','maxprice','万','cprice','chekpricee')"/>
                  <input type="text" name="hprice" id="maxprice"  placeholder="最多预算" value="" class="cInput"  onblur="chekSubMit('minprice','maxprice','万','cprice','chekpricee')"/>
                  万元<div id="chekpricee" style="display: none"></div><input type="hidden" id="cprice" name="cprice"> </td>
                  
              </tr>
              <tr>
                <td><input type="text" value="" readonly="readonly" placeholder="计划购买时间" style="width:95%" class="form_datetime cInput" name="buytime" id="buytime" data-date-format="yyyy-mm-dd"><div id="timediv" style="display: none"></div></td>
              </tr>
              <tr>
                <td><textarea name="content" id="content" placeholder="其他要求（例如车身和内饰颜色、行驶里程要求等）"></textarea></td>
              </tr>
              <tr>
                <td><input id="input-phone" type="hidden" name="mobile" value="" />
                  <input id="input-verify" type="hidden" name="verify" value="" />
                  <c:if test="${!empty userinfo }"> <input type="button" value="提交需求" class="sBtn" style=" padding:0;" id="sendMESS" onclick="sendSrdz()"/></c:if>
       <c:if test="${empty userinfo }"><input type="button" value="提交需求" class="sBtn" style=" padding:0;" id="sendMESS" onclick="sendLogin()" /></c:if>
                 </td>
              </tr>
            </table>
          </form>
          <div id="popBoxYzm" style="display:none">
            <div class="popForm">
              <div class="p-detail">
                <form action="" enctype="multipart/form-data" method="post" name="yzmcheck" id="yzmcheck">
                  <ul class="login-items" style="width:100%">
                    <li>
                      <label>手机号</label>
                      <input type="text" value="" maxlength="32"  name="mobile" id="shoujihao" style="width:120px">
                      <input type="checkbox" name="remembermobile" style=" width:auto; margin:10px 20px 0" id="remembermobile" />
                      <label>记住此号</label>
                    </li>
                    <li>
                      <label>验证码</label>
                     
                      <input type="text"  maxlength="16"  name="verify" id="yanzhengma" style="width:120px; margin-right:20px;" >
                      <img id="yzcode" width="100" height="42" alt="点击切换" > </li>
                  </ul>
                  <div class="login-button">
                    <input type="button"  value="立即提交" class="fM" onclick="sendtosend()" style="line-height:20px" />
                  </div>
                </form>
              </div>
              <a class="closed">×</a> </div>
          </div>
          <input type="hidden" id="ckmobile" value="1" />
          
        </div>
      </div>
    </div>
  </div>
  <div class="mDiv main-a">
    <div class="wrap">
      <div class="in-tit clearfix">
        <h1 class="left dInline"> 亿金新闻 </h1>
      </div>
      <div class="in-news clearfix">
        <div class="new-left dInline left">
          <h3>动态</h3>
          <div class="clearfix">
            <div class="new-dl left dInline">
            <c:if test="${!empty new1 }">
          <a href="Trends_showTei.action?tr_id=${new1.trId }" class='aImg'><img src="${new1.trImg }"  width='262' height='170' /></a>
            </c:if>
              <ul>
              <c:if test="${!empty news1 }">
              <c:forEach var="news1" items="${news1 }">
              <li>·<a href="Trends_showTei.action?tr_id=${news1.trId }">${news1.trTitle }</a></li>
              </c:forEach>
              </c:if>
              </ul>
              <a style="float:right" href="Trends_showNewsList.action" target="_blank">更多>></a> </div>
            <div class="new-dl right dInline">
             <c:if test="${!empty new6}">
          <a href="Trends_showTei.action?tr_id=${new6.trId }" class='aImg'><img src="${new6.trImg }"  width='262' height='170' /></a>
            </c:if>
              <ul>
                <c:if test="${!empty news2 }">
              <c:forEach var="news1" items="${news2 }">
              <li>·<a href="Trends_showTei.action?tr_id=${news1.trId }">${news1.trTitle }</a></li>
              </c:forEach>
              </c:if>
              </ul>
              <a style="float:right" href="Trends_showNewsList.action" target="_blank">更多>></a> </div>
          </div>
        </div>
        
        <div class="nKe left dInline">
          <div class="kTit">
            <h2>客户留言</h2>
          </div>
          <div class="slide">
            <div class="hd"> <a class="prev"><img src="images/in_l.jpg"/></a>
              <ul>
                <li>1</li>
                <li>2</li>
                <li>3</li>
              </ul>
              <a class="next"><img src="images/in_r.jpg"/></a></div>
            <div class="bd">
              <ul>
              <c:if test="${!empty com1 }">
                <li class="clearfix">
                <c:forEach var="com1" items="${com1 }">
                  <div class="bd-dl"> <a href="Trends_showComd.action?cid=${com1.value.cId }" class="aImg"> <img src="${com1.value.cImg }" width="242" height="170" /> </a>
                    <h4>${com1.value.cBt }</h4>
                    <p>${com1.value.cText }</p>
                    <div align="right"> <a href="Trends_showComd.action?cid=${com1.value.cId}" class="cMore">查看详情</a> </div>
                  </div>
                  </c:forEach>
                  
                </li>
                </c:if>
                 <c:if test="${!empty com2 }">
                <li class="clearfix">
                <c:forEach var="com2" items="${com2 }">
                  <div class="bd-dl"> <a href="Trends_showComd.action?cid=${com2.value.cId }" class="aImg"> <img src="${com2.value.cImg }" width="242" height="170" /> </a>
                    <h4>${com2.value.cBt }</h4>
                    <p>${com2.value.cText }</p>
                    <div align="right"> <a href="Trends_showComd.action?cid=${com2.value.cId}" class="cMore">查看详情</a> </div>
                  </div>
                  </c:forEach>
                  
                </li>
                </c:if>
                
                  <c:if test="${!empty com3 }">
                <li class="clearfix">
                <c:forEach var="com3" items="${com3 }">
                  <div class="bd-dl"> <a href="Trends_showComd.action?cid=${com3.value.cId }" class="aImg"> <img src="${com3.value.cImg }" width="242" height="170" /> </a>
                    <h4>${com3.value.cBt }</h4>
                    <p>${com3.value.cText }</p>
                    <div align="right"> <a href="Trends_showComd.action?cid=${com3.value.cId}" class="cMore">查看详情</a> </div>
                  </div>
                  </c:forEach>
                  
                </li>
                </c:if>
               
              </ul>
            </div>
          </div>
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
        
          <input type="hidden" name="url" value="forward:/CarInfo.action">
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
             <input type="hidden" name="url" value="forward:/CarInfo.action">
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
          <input type="hidden" name="url" value="forward:/CarInfo.action">
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
             <input type="hidden" name="url" value="forward:/CarInfo.action">
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
          <input type="hidden"  name="url" value="forward:/CarInfo.action">
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
             <input type="hidden" name="url" value="forward:/CarInfo.action">
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

<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script> 
<script type="text/javascript" src="js/index.js"></script> 
<!--右侧滑动-->
<script type="text/javascript" src="js/miniBar.js"></script>
<script type="text/javascript" src="js/lg_reg.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
       format: 'yyyy-mm',
		language:"zh-CN",        
		startView: 3,
		minView: 3,
		autoclose:true	

    });
</script>
<!--搜索下图片切换-->
<!--<script type="text/javascript">
$(function(){
	$('.b_btn').hide();
	$('#banner').hover(function(){
		$(this).find('.b_btn').fadeIn();
	},function(){
		$(this).find('.b_btn').hide();
	});
	$('.bDiv').width($(window).width());
	$('.banShow').width($(window).width());
	$(window).resize(function(){
		$('.bDiv').width($(window).width());
		$('.banShow').width($(window).width());
	})
})
</script> -->
  
  </body>
  
</html>
