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
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG.js"></script>
<script>
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->

  <script type="text/javascript">
  function cheknull(str1,str2){
  
   var flag=false;
  var str1=document.all(str1);
  var str2=document.all(str2);
  
  if(str1.value.length==0){
  
   str2.innerHTML="<font color='red'>不能为空</font>";
   str2.style.display="inline";
  }
  else{
   str2.style.display="none";
   flag=true;
  }
  return flag;
  }
  
  
/*
用途：检查输入字符串是否符合正整数格式
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/
function isNumber(s) {
var regu = "^[0-9]+$";
var re = new RegExp(regu);
if (s.search(re) != -1) {
return true;
} else {
return false;
}
} 

   function chekywxs(str,str1){
     var flag=false;
     var str=document.all(str);
     var str1=document.all(str1);
     var array=new Array();
      array=str.value.split(".");
     if(str.value.length>0){
       if(isNumber(str.value)){
       if(parseInt(str.value)>8){
       str1.innerHTML="<font color='red'>行驶距离大于8万公里的车我们不接受</font>"
         str1.style.display="inline";
       }
         else{
         str1.style.display="none";
         flag=true;
         }
       }
       else if(array.length==2){
         if(isNumber(array[0])&&isNumber(array[1])){
          if(array[1].length>1){
           str1.innerHTML="<font color='red'>小数点后只能带一位</font>"
         str1.style.display="inline";
          }
          else{
           if(parseInt(array[0])>7){
           str1.innerHTML="<font color='red'>行驶距离大于8万公里的车我们不接受</font>"
         str1.style.display="inline";
           }
           else{
             str1.style.display="none";
             flag=true;
           }
          }
         }
         else{
          str1.innerHTML="<font color='red'>请输入一个正整数或者正一位小数</font>"
         str1.style.display="inline";
         }
       }
       else{
       
         str1.innerHTML="<font color='red'>请输入一个正整数或者正一位小数</font>"
         str1.style.display="inline";
       }
     }
     else{
       str1.innerHTML="<font color='red'>不能为空</font>"
         str1.style.display="inline";
     }
     return flag;
   }
   function chekpail(str,str1){
     var flag=false;
     var str=document.all(str);
     var str1=document.all(str1);
     var array=new Array();
      array=str.value.split(".");
     if(str.value.length>0){
       if(isNumber(str.value)){
       if(parseInt(str.value)>10){
       str1.innerHTML="<font color='red'>排量大于10T的车我们不接受</font>"
         str1.style.display="inline";
       }
         else{
         str1.style.display="none";
         flag=true;
         }
       }
       else if(array.length==2){
         if(isNumber(array[0])&&isNumber(array[1])){
          if(array[1].length>1){
           str1.innerHTML="<font color='red'>小数点后只能带一位</font>"
         str1.style.display="inline";
          }
          else{
           if(parseInt(array[0])>9){
           str1.innerHTML="<font color='red'>排量大于10T的车我们不接受</font>"
         str1.style.display="inline";
           }
           else{
             str1.style.display="none";
             flag=true;
           }
          }
         }
         else{
          str1.innerHTML="<font color='red'>请输入一个正整数或者正一位小数</font>"
         str1.style.display="inline";
         }
       }
       else{
       
         str1.innerHTML="<font color='red'>请输入一个正整数或者正一位小数</font>"
         str1.style.display="inline";
       }
     }
     else{
       str1.innerHTML="<font color='red'>不能为空</font>"
         str1.style.display="inline";
     }
     return flag;
   }
   function chekpri(str,str1){
     var flag=false;
     var str=document.all(str);
     var str1=document.all(str1);
     var array=new Array();
      array=str.value.split(".");
     if(str.value.length>0){
       if(isNumber(str.value)){
       if(parseInt(str.value)>100000){
       str1.innerHTML="<font color='red'>价格大于10亿的车我们不接受</font>"
         str1.style.display="inline";
       }
         else{
         str1.style.display="none";
         flag=true;
         }
       }
       else if(array.length==2){
         if(isNumber(array[0])&&isNumber(array[1])){
          if(array[1].length>2){
           str1.innerHTML="<font color='red'>小数点后只能带两位</font>"
         str1.style.display="inline";
          }
          else{
           if(parseInt(array[0])>99999){
           str1.innerHTML="<font color='red'>价格大于10亿的车我们不接受</font>"
         str1.style.display="inline";
           }
           else{
             str1.style.display="none";
             flag=true;
           }
          }
         }
         else{
          str1.innerHTML="<font color='red'>请输入一个正整数或者正两位小数</font>"
         str1.style.display="inline";
         }
       }
       else{
       
         str1.innerHTML="<font color='red'>请输入一个正整数或者正两位小数</font>"
         str1.style.display="inline";
       }
     }
     else{
       str1.innerHTML="<font color='red'>不能为空</font>"
         str1.style.display="inline";
     }
     return flag;
   }
   
    function chekYear(){
     var flag=false;
     var fxn=  document.all("fxn");
     var div=document.all("fxnnn");
     if(fxn.value==0){
     div.innerHTML="<font color='red'>不能为空</font>";
     div.style.display="inline";
     }
     else{
        if(!isNaN(fxn.value)){
          if(parseInt(fxn.value)>1998&&parseInt(fxn.value)<2017){
          flag=true;
          div.style.display="none";
          }
          else{
          div.innerHTML="<font color='red'>暂时只接受1998年到2017年款的车</font>";
          div.style.display="inline";
          }
        }
        else{
        div.innerHTML="<font color='red'>请输入一个如2005格式的年份</font>";
          div.style.display="inline";
        }
     }
     return flag;
    }
    function chekspz(){
    var flag=false;
  var stime=  document.all("stime");
  var div=   document.all("div1");
  if(stime.value.length==0){
  div.innerHTML="<font color='red'>不能为空</font>";
     div.style.display="inline";
  }
  else{
       var array=new Array();
       array=stime.value.split("-");
       if(array.length==2){
        if(isNumber(array[0])&&isNumber(array[1])){
          if(parseInt(array[1])>12){
           div.innerHTML="<font color='red'>月份不会大于12的亲</font>";
          div.style.display="inline";
          }
          else{
            if(parseInt(array[0])>2012&&parseInt(array[0])<2017){
            flag=true;
          div.style.display="none";
            }
            else{
            div.innerHTML="<font color='red'>暂时只接受车龄不超过四年的车</font>";
          div.style.display="inline";
            }
          }
        }
        else{
        div.innerHTML="<font color='red'>请输入一个格式如2005-07的上照年月</font>";
        div.style.display="inline";
        }
       }
       else{
        div.innerHTML="<font color='red'>请输入一个格式如2005-07的上照年月</font>";
        div.style.display="inline";
       }
  }
  return flag;
    }
    function chekbxsj(str,str1){
    var flag=false;
  var stime=  document.all(str);
  var div=   document.all(str1);
  if(stime.value.length==0){
  div.innerHTML="<font color='red'>不能为空</font>";
     div.style.display="inline";
  }
  else{
       var array=new Array();
       array=stime.value.split("-");
       if(array.length==2){
        if(isNumber(array[0])&&isNumber(array[1])){
          if(parseInt(array[1])>12){
           div.innerHTML="<font color='red'>月份不会大于12的亲</font>";
          div.style.display="inline";
          }
          else{
           
            flag=true;
          div.style.display="none";
           
           
          }
        }
        else{
        div.innerHTML="<font color='red'>请输入一个格式如2005-07的时间</font>";
        div.style.display="inline";
        }
       }
       else{
        div.innerHTML="<font color='red'>请输入一个格式如2005-07的时间</font>";
        div.style.display="inline";
       }
  }
  return flag;
    }
     function chekTtp(){
     var flag=false;
     
     var file=document.all("ttp")
     var div=document.all("fa1");
    
     if(file.value.length==0){
     div.innerHTML="<font color='red'>必须提供车的外观图</font>"
     }
     else{
     flag=true;
     }
     return flag;
     }
     function ckzs(str,str1){
     var flag=false;
     var str2=document.all(str);
     var str3=document.all(str1);
     if(str2.value.length==0){
     str3.innerHTML="<font color='red'>不能为空</font>";
     str3.style.display="inline";
     }
     else{
     if(isNumber(str2.value)){
     if(parseInt(str2.value)<100){
     flag=true;
     str3.style.display="none";
     }
     else{
      str3.innerHTML="<font color='red'>限100以内</font>";
     str3.style.display="inline";
     }
     }
     else{
    
     str3.innerHTML="<font color='red'>请输入一个正整数</font>";
     str3.style.display="inline";
     }
     }
     return flag;
     }
     function chekSub(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16,str17,str18,str19,str20,str21,str22,str23,str24,str25,str26,str27,str28,str29,str30){
    
 var flag=false;     
if( chekspz()&&chekTtp()&&cheknull(str1,str2)&&chekpail(str3,str4)&&chekywxs(str11,str12)&&cheknull(str5,str6)&&cheknull(str7,str8)&&chekYear()&&cheknull(str9,str10)&&chekpri(str13,str14)&&cheknull(str15,str16)&&chekbxsj(str17,str18)&&chekbxsj(str19,str20)&&chekbxsj(str21,str22)&&chekbxsj(str23,str24)&&ckzs(str25,str26)&&ckzs(str27,str28)&&ckzs(str29,str30)){
       flag=true;
      }
      return flag;
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
      <a href="CarInfo_showlist.action">我要买车</a>
      <a class="on" href="MemberCenter_needmaiche.action">我要卖车</a>
      <a href="CarInfo_showsrdz.action">私人定制</a>
      <!--<a href="shfw.html">售后服务</a>-->
<c:if test="${!empty userinfo }"> <a id="MemberMenuChange" href="MemberCenter_showmenber.action" target="_self">会员中心</a></c:if>
          <c:if test="${empty userinfo }"> <a id="MemberMenuChange" onclick="sendLogin()">会员中心</a></c:if>
           </div>
      <span class="right" id="rightMenuHtml">
      
      <c:if test="${empty userinfo }"><a onclick="sendLogin()" >登录</a>|<a  onclick="sendReg()" >注册</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>
      <c:if test="${!empty userinfo }"> <c:if test="${time<12 }">上午好！</c:if><c:if test="${time>=12 }">  下午好！ </c:if> <a href="MemberCenter_showmenber.action"  >
    ${userinfo.uName } 
   
      </a>|<a  href="UserInfo_zhuXiao.action?url=forward:/CarInfo.action" >注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
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
            </c:if>		      </div>
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
  </c:if></a></div>
  <div class="wrap">
    <div class="buyDetail">
      <div class="b_tab_nav">
        <div class="b-tab"> <a class="on b_ta" href="#cBox1" data-scroll data-speed="1000">基本信息<i></i></a>  <!--<a href="../../../../../Apply/Index/channel/5/id/2.html#jisuanqi">贷款计算器<i></i></a>--> <span style="float:right;font-size:14px;color: #2e71b8; margin-right:30px;"><b>看车电话：销售部 (400-888-666)</b></span> </div>
      </div>
      <div class="b-cont">
        <div id="cBox1" class="c_box">
          <h2>${brad }${cx }${cxi }</h2>
           <div class="ca-dl"> <span class="caItem on">展示图片</span>
              <div class="clearfix">
              <div style="width:1150px; height:267px; overflow:scroll;">
                <table width="1026px"  >
                  <tr >
           <td ><div align="center" style="height:200;border:5px solid red; " id="fa1"><br><br><br>*必选(展示车的全外观)</div><div style=" height:0px; overflow:hidden; position:absolute;" ><input type="file" id="file" name="file" onchange="fileupload('file','fa1','ttp')"/></div>
           <input type="button" onclick="document.getElementById('file').click();" value="上传"></td>
           <td ><div align="center" style="height:200;border:5px solid red; " id="fa2"><br><br><br>图片越多越容易引人关注哦</div><div style=" height:0px; overflow:hidden; position:absolute;" ><input type="file" id="filePath1" name="filePath1" onchange="fileupload('filePath1','fa2','ftp1')"/></div>
           <input type="button" onclick="document.getElementById('filePath1').click();" value="上传"></td>
           <td ><div style="height:200;border:5px solid red; " id="fa3"><br><br><br>图片越多越容易引人关注哦</div><div style=" height:0px; overflow:hidden; position:absolute;" ><input type="file" id="filePath2" name="filePath2" onchange="fileupload('filePath2','fa3','ftp2')"/></div>
           <input type="button" onclick="document.getElementById('filePath2').click();" value="上传"></td>
           <td ><div align="center" style="height:200;border:5px solid red; " id="fa4"><br><br><br>图片越多越容易引人关注哦</div><div style=" height:0px; overflow:hidden; position:absolute;" ><input type="file" id="filePath3" name="filePath3" onchange="fileupload('filePath3','fa4','ftp3')"/></div>
           <input type="button" onclick="document.getElementById('filePath3').click();" value="上传"></td>
           <td ><div  align="center" style="height:200;border:5px solid red; " id="fa5"><br><br><br>图片越多越容易引人关注哦</div><div style=" height:0px; overflow:hidden; position:absolute;" ><input type="file" id="filePath4" name="filePath4" onchange="fileupload('filePath4','fa5','ftp4')"/></div>
           <input type="button" onclick="document.getElementById('filePath4').click();" value="上传"></td>
            <td ><div align="center" style="height:200;border:5px solid red; " id="fa6"><br><br><br>图片越多越容易引人关注哦</div><div style=" height:0px; overflow:hidden; position:absolute;" ><input type="file" id="filePath5" name="filePath5" onchange="fileupload('filePath5','fa6','ftp5')"/></div>
           <input type="button" onclick="document.getElementById('filePath5').click();" value="上传"></td>
           
                   </tr>
   
                  
                </table>
                </div>
              </div>
            </div>
<form name="upform" action="MemberCenter_tjmc.action" method="post"  onsubmit="return chekSub('carxh','carxxx','dis','div8','cartype','div6','carbh','carbbb','stan','div9','travel','divf','price','priiii','speed','speeee','ytime','div2','ytime1','div3','data','divf1','duedate','divf3','key','keyyy','numm','nummmm','sate','sateaa')">
          <input type="hidden" name="op" value="tjmc">
          <input type="hidden" name="brad" value="${brad }">
          <input type="hidden" name="cx" value="${cx }">
          <input type="hidden" name="cxi" value="${cxi }">
         <input type="hidden" name="ttp" >
         <input type="hidden" name="ftp1" >
         <input type="hidden" name="ftp2" >
         <input type="hidden" name="ftp3" >
         <input type="hidden" name="ftp4" >
         <input type="hidden" name="ftp5" >
          <div class="cbox-a">
            <div class="ca-table">
             <table>
												<tr>
													<td class="ca-td1">上牌时间</td>
													<td><input placeholder="*必选" class="for_datetime cPut" data-date-format="yyyy-mm" type="text" id="stime" name="stime" value="${sptime }" onblur="chekspz()"/>
													<div id="div1" style="display:none"></div>
													</td>
													<td class="ca-td1">年检到期时间</td>
													<td><input type="text" class="for_datetime cPut" data-date-format="yyyy-mm" placeholder="*必填" id="ytime" name="ytime" onblur="chekbxsj('ytime','div2')" />
													<div id="div2" style="display:none"></div>
													</td>
													<td class="ca-td1">强险到期时间</td>
													<td><input type="text" class="for_datetime cPut" data-date-format="yyyy-mm" placeholder="*必填" id="ytime1" name="ytime1" onblur="chekbxsj('ytime1','div3')"/>
													<div id="div3" style="display:none"></div>
													</td>
													<td class="ca-td1">型号</td>
													<td><input type="text" placeholder="*必填(如领先型,时尚型等)" id="carxh" name="carxh" onblur="cheknull('carxh','carxxx')"/>
													<div id="carxxx" style="display:none"></div>
													</td>
												</tr>
												<tr>
													<td class="ca-td1">车身颜色</td>
													<td><input type="text" placeholder="非必填" id="carcolor" name="carcolor" onblur="checkColor()"/>
													<div id="div5" style="display:none"></div>
													</td>
													<td class="ca-td1">车体形式</td>
													<td><input type="text" placeholder="*必填(小型,大型,房车等)" id="cartype" name="cartype" onblur="cheknull('cartype','div6')" value="${cxi }"/>
													<div id="div6" style="display:none"></div>
													</td>
													
													<td class="ca-td1">排量(T)</td>
													<td><input type="text" placeholder="*必填(限正整数或一位小数)" id="dis" name="dis" onblur="chekpail('dis','div8')"/>
													<div id="div8" style="display:none"></div>
													</td>
													<td class="ca-td1">编号</td>
													<td><input type="text" placeholder="*必填(如730li等)" id="carbh" name="carbh" onblur="cheknull('carbh','carbbb')"/>
													<div id="carbbb" style="display:none"></div>
													</td>
												</tr>
												<tr>
													<td colspan="8"><p>亿金名车，您身边的二手车专家！</p>
													</td>
												</tr>
											</table>
										</div>
										<div class="ca-dl">
											<span class="caItem on">基本信息</span>
											<div class="clearfix">
												
													<table>
														<tr>
															<td width="270" class="ca-td1">排放标准</td>
															<td><input type="text" placeholder="*必填(国三,国四,国五等)" id="stan" name="stan" onblur="cheknull('stan','div9')"/>
															<div id="div9" style="display:none"></div>
															</td>
														
													
													
												
												
															<td width="270" class="ca-td1">行驶里程(万公里)</td>
															<td><input type="text" id="travel" name="travel" placeholder="*必填(限8以下正整数或一位小数)" value="${dis }" onblur="chekywxs('travel','divf')"/>
															<div id="divf" style="display:none"></div>
															</td>
														</tr>
														
												
												
														<tr>
															<td width="270" class="ca-td1">内饰颜色</td>
															<td ><input  type="text" placeholder="非必填" id="carincolor" name="carincolor" onblur="checkCarin()"/>
															<div id="divy" style="display:none"></div>
															</td>
														
															<td class="ca-td1">出厂日期</td>
															<td ><input type="text" placeholder="*必填" class="for_datetime cPut" data-date-format="yyyy-mm" id="data" name="data" onblur="chekbxsj('data','divf1')"/>
															<div id="divf1" style="display:none"></div>
															</td>
														</tr>
												
												
													
														<tr>
															<td class="ca-td1">产地</td>
															<td><input type="text" placeholder="非必填" id="area" name="area" onblur="checkArea"/>
															<div id="divf2" style="display:none"></div>
															</td>
														
															<td class="ca-td1" width="270">商业险到期日</td>
															<td ><input type="text" placeholder="*必填" class="for_datetime cPut" data-date-format="yyyy-mm" id="duedate" name="duedate" onblur="chekbxsj('duedate','divf3')"/>
															<div id="divf3" style="display:none"></div>
															</td>
														</tr>
													
												</table>
											</div>
										</div>
										<div class="ca-dl" id="cBox2">
											<span class="caItem on">配置信息</span>
											<div class="clearfix">
												<div class="jb_infor left">
													<table>
														<tr>
															<td width="270">导航系统</td>
															<td><div class="rad left">
																	<input type="radio" id="rad" name="rad" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad" name="rad" value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">中控台液晶屏</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad1" name="rad1" checked value="有" />有
																</div>
																<div class="right">
																	<input type="radio" id="rad1" name="rad1" value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">自动头灯</td>
															<td><div class="rad left">
																	<input type="radio" id="rad2" name="rad2" checked  value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad2" name="rad2" value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">后视镜加热</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad3" name="rad3" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad3" name="rad3"  value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">发动机启停</td>
															<td><div class="rad left">
																	<input type="radio" id="rad4" name="rad4" checked  value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad4" name="rad4" value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">防抱死制动系统</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad5" name="rad5" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad5" name="rad5"  value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">前驻车雷达</td>
															<td><div class="rad left">
																	<input type="radio" id="rad6" name="rad6" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad6" name="rad6" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">后倒车雷达</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad7" name="rad7" checked value="有" />有
																</div>
																<div class="rad right"> 
																	<input type="radio" id="rad7" name="rad7"  value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">氙气大灯</td>
															<td><div class="rad left">
																	<input type="radio" id="rad8" name="rad8" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad8" name="rad8" value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">倒车影像系统</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad9" name="rad9" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad9" name="rad9" value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">驾驶员座椅电动调节</td>
															<td><div class="rad left">
																	<input type="radio" id="rad0" name="rad0" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad0" name="rad0" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">副驾驶座椅电动调节</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-1" name="rad-1" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-1" name="rad-1" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">大灯清洗</td>
															<td><div class="rad left">
																	<input type="radio" id="rad-2" name="rad-2" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-2" name="rad-2" value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">电动折叠后视镜</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-3" name="rad-3" checked  value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-3" name="rad-3"  value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">定速巡航</td>
															<td><div class="rad left">
																	<input type="radio" id="rad-4" name="rad-4" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-4" name="rad-4" value="无" />无
																</div>
															</td>
														</tr>
													</table>
                </div>
                <div class="jb_infor right">
                  <table>
                                                      <tr>
															<td width="270" class="ca-td1">发行年</td>
															<td><input type="text" placeholder="*必选" class="form_datetime cPut" data-date-format="yyyy" id="fxn" name="fxn" onblur="chekYear()" />
															<div id="fxnnn" style="display: none"></div>
															</td>
														</tr>
														<tr>
															<td width="270" class="ca-td1">座位数</td>
															<td><input type="text" id="sate" name="sate" placeholder="*必填" onblur="ckzs('sate','sateaa')"/>
															 <div id="sateaa" style="display: none"></div>
															</td>
														</tr>
														
														<tr>
															<td width="270" class="ca-td1">燃料形式</td>
															<td><input type="text" id="fuel" name="fuel" placeholder="非必填"/>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">变速箱</td>
															<td ><input placeholder="*必填(AT自动,手动等)" type="text" id="speed"
																name="speed"  onblur="cheknull('speed','speeee')"/>
																<div id="speeee" style="display: none"></div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1" width="270">驱动方式</td>
															<td><input type="text" id="method" name="method" placeholder="非必填"/>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">无钥匙进入</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-key" name="rad-key" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-key" name="rad-key" value="无" />无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">无钥匙启动</td>
															<td><div class="rad left">
																	<input type="radio" id="rad-5" name="rad-5" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-5" name="rad-5" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">全景天窗</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-6" name="rad-6" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-6" name="rad-6" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">真皮座椅</td>
															<td><div class="rad left">
																	<input type="radio" id="rad-7" name="rad-7" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-7" name="rad-7" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">前排座椅加热</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-8" name="rad-8" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-8" name="rad-8" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">后排座椅加热</td>
															<td><div class="rad left">
																	<input type="radio" id="rad-9" name="rad-9" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-9" name="rad-9" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">前排座椅通风</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-qtf" name="rad-qtf" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-qtf" name="rad-qtf" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">后排座椅通风</td>
															<td><div class="rad left">
																	<input type="radio" id="rad-htf" name="rad-htf" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-htf" name="rad-htf"  value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">前排座椅记忆</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-0" name="rad-0" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-0" name="rad-0"  value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">后排座椅记忆</td>
															<td > <div class="rad left">
																	<input type="radio" id="rad-hjy" name="rad-hjy" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-hjy" name="rad-hjy" value="无" />无
																</div>
															</td>
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
															<td class="ca-td1"  width="270">购置税</td>
															<td><input type="text" placeholder="非必填" id="buy" name="buy" />
															</td>
														</tr>
														<tr>
															<td class="ca-td1">行驶证</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-a" name="rad-a" checked  value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-a" name="rad-a" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td width="270">新车质保</td>
															<td ><div class="rad left">
																	<input type="radio" id="xczb" name="xczb" checked  value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="xczb" name="xczb" value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">登记证</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-b" name="rad-b" checked value="有" />有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-b" name="rad-b" value="无"/>无
																</div>
															</td>
														</tr>
													</table>
                </div>
                <div class="jb_infor right">
                  <table>
														<tr>
															<td width="270" class="ca-td1">过户次数</td>
															<td><input type="text" placeholder="*必填" id="numm" name="numm" onblur="ckzs('numm','nummmm')" />
															<div id="nummmm" style="display: none"></div>
															</td>
														</tr>
														
														<tr>
															<td class="ca-td1">钥匙（把）</td>
															<td ><input type="text" placeholder="*必填" id="key"
																name="key" onblur="ckzs('key','keyyy')"/>
															<div id="keyyy" style="display: none"></div>
															</td>
														</tr>
														<tr>
															<td width="270">新车发票</td>
															<td><div class="rad left">
																	<input type="radio"  id="rad-c" name="rad-c" checked value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-c" name="rad-c"  value="无"/>无
																</div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">过户票</td>
															<td  class="ca-td1"><div class="rad left">
																	<input type="radio" id="ghp" name="ghp" checked  value="有"/>有
																</div>
																<div class="rad right">
																	<input type="radio" id="ghp" name="ghp" value="无" />无
																</div>
															</td>
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
															<td width="270" class="ca-td1">销售价(万元)</td>
															<td><input placeholder="*限6位以下正整数或两位小数" type="text" id="price" name="price" onblur="chekpri('price','priiii')" />
															<div id="priiii" style="display: none"></div>
															</td>
														</tr>
														<tr>
															<td class="ca-td1">含过户费</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-d" name="rad-d" checked value="是"/>是
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-d" name="rad-d"  value="否"/>否
																</div>
															</td>
														</tr>
													</table>
                </div>
                <div class="jb_infor right">
                 <table>
														<tr>
															<td width="270"  class="ca-td1">价格类型</td>
															<td><input type="text" placeholder="非必填" id="p-type" name="p-type" />
															</td>
														</tr>
														<tr>
															<td class="ca-td1">支持分期</td>
															<td class="ca-td1"><div class="rad left">
																	<input type="radio" id="rad-f" name="rad-f" checked value="是" />是
																</div>
																<div class="rad right">
																	<input type="radio" id="rad-f" name="rad-f" value="否" />否
																</div>
															</td>
														</tr>
													</table>
                </div>
              </div>
            </div>
            <div class="ca-dl"> <span class="caItem on">详细描述</span>
              <div class="clearfix">
                <table>
                  <tr>
                    <td colspan="8"><textarea id="txta" name="txta"style="width:1050px"></textarea></td>
                  </tr>
               
                  <tr>
                  <td colspan="4"><input type="submit" value="提交"></td>
                  <td colspan="4"><input type="reset" value="重置"></td>
                  </tr>
                </table>
              </div>
            </div>
            
             
          </div>
          </form>
        </div>
       
      
      </div>
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

  <script type="text/javascript" src="js/miniBar.js"></script>
<script type="text/javascript" src="js/lg_reg.js"></script>
<!--<script type="text/javascript" src="js/borrow.js"></script>-->


<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
       format: 'yyyy',
		language:"zh-CN",        
		startView: 3,
		minView: 3,
		autoclose:true	

    });
</script>
<script type="text/javascript">
    $('.for_datetime').datetimepicker({
       format: 'yyyy-mm',
		language:"zh-CN",        
		startView: 3,
		minView: 3,
		autoclose:true	

    });
</script>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>  
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>  
      
    <script type="text/javascript">  
        function fileupload(str,div1,str2){
        var str1=document.all(str);
        var div=document.all(div1); 
       var str3=document.all(str2);
      
            if(str1.value.length==0){  
                alert("上传文件不能为空!");  
                return false;  
            }  
            $.ajaxFileUpload({  
                    url:"<%=basePath %>ScImage.action?sctname="+str3.value+"",  
                    secureuri:false,  
                    fileElementId:str,  
                    dataType: 'text/xml', 
                    type:'post',            
                    success: function (msg) {  
                        var start = msg.indexOf(">");
                      if (start != -1) {
                          var end = msg.indexOf("<", start + 1);
                          }
                          if (end != -1) {
                              msg = msg.substring(start + 1, end);
                          }
                        
                         div.innerHTML="<img src='tepimages/"+msg+"'>";
                         str3.value=msg;
                    },error: function (data, status, e){  
                        alert("fail");  
                    }  
                }  
            );  
        }  
        
    </script>  
  </body>
</html>
