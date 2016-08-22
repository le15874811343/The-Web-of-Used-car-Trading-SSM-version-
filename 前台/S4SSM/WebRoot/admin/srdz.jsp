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
    
    <title>私人定制-郑州高品质二手车专家_亿金汽车</title>
    
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
<link rel="stylesheet" type="text/css" href="css/ding.css">
<!--<link rel="stylesheet" type="text/css" href="css/alert.css">-->
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>

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
      <div class="nav left dInline" id="headerMenu"> <a  href="CarInfo.action">首页</a> <a href="about.jsp">关于亿金</a> <a href="CarInfo_showList.action">我要买车</a> <a href="MemberCenter_needmaiche.action">我要卖车</a> <a  class="on" href="CarInfo_showsrdz.action">私人定制</a> 
        <!--<a href="shfw.html">售后服务</a>--> 
<c:if test="${!empty userinfo }"> <a id="MemberMenuChange" href="MemberCenter_showmenber.action" target="_self">会员中心</a></c:if>
          <c:if test="${empty userinfo }"> <a id="MemberMenuChange" onclick="sendLogin()">会员中心</a></c:if>
             </div>
      <span class="right" id="rightMenuHtml">
 <c:if test="${empty userinfo }"><a href="UserInfo.action?op=needLogin&url=CarInfo.action?op=show"   >登录</a>|<a  href="UserInfo.action?op=needreg&url=CarInfo.action?op=show" >注册</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>
      <c:if test="${!empty userinfo }"> <c:if test="${time<12 }">上午好！</c:if><c:if test="${time>=12 }">  下午好！ </c:if> <a href="MemberCenter_showmenber.action"  class="b-login" >
    ${userinfo.uName } 
   
      </a>|<a  href="UserInfo_zhuXiao.action?url=forward:/CarInfo.action"  id="b-regist">注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>       </span> </div>
  </div>
  <div class="head-search">
    <div class="wrap clearfix">
      <div class="yjxj clearfix left" action="/index/keyword/" method="post" enctype="multipart/form-data">
         <form action="CarInfo_showList.action" method="get">
        
        <input type="text" name="bname" placeholder="请输入您想要的品牌搜索" class="left" />
        <input type="submit" value="搜 索" class="right" />
        </form>
      </div>
      <div class="hotWords left dInline"> 热门品牌：
      
<c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
                        <a href="CarInfo_showList.action?bname=${ showcar.value.cBrand}&cser=${showcar.value.cSeries}" >${ showcar.value.cBrand}${showcar.value.cSeries}</a>
            
            </c:forEach>
            </c:if>    </div>
  </div>
</div>
</div>
<style>
input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {color: #656565;}
input:-moz-placeholder, textarea:-moz-placeholder {color:#656565;}
input::-moz-placeholder, textarea::-moz-placeholder {color:#656565;}
input:-ms-input-placeholder, textarea:-ms-input-placeholder {color:#656565;}
</style>
<div id="about">
  <div class="mTags">
    <div class="wrap"> <a href="index.jsp">亿金汽车</a>><a>私人定制</a> </div>
  </div>
  <div class="dBox">
    <div class="dzDetail">
      <div class="wrap clearfix">
        <div class="dzLeft left dInline"> <strong>私人定制</strong>
          <p> 私人定制是根据您对车辆品牌、车型、颜色、内饰、配置、年限、公里数等的需求进行定制化服务，公司将全国范围内搜寻相匹配的优质车源，供您挑选，让爱车真正成为您的专属座驾。 </p>
        </div>
        <input type="hidden" id="ckmobile" value="1" />
        <div class="diForm">
          <form id="dForm" name="dForm" method="post"  onsubmit="return cheksuub('sel1','sel5','cx','scx','ccx','srcx','srcx','scx','ccx','years','cxi','scxi','ccxi','srcxi','minage','maxage','年','ccxi','chekagee','minprice','maxprice','万','cprice','chekpricee');">
            <h3>提交信息，帮您量身定制！</h3>
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
                  万元<div id="chekpricee" style="display: none"></div><input type="hidden" id="cprice" name="price"> </td>
                  
              </tr>
              <tr>
                <td><input type="text" value="" readonly="readonly" placeholder="计划购买时间" style="width:95%" class="form_datetime cInput" name="buytime" id="buytime" data-date-format="mm-dd"><div id="timediv" style="display: none"></div></td>
              </tr>
              <tr>
                <td><textarea name="content" id="content" placeholder="其他要求（例如车身和内饰颜色、行驶里程要求等）"></textarea></td>
              </tr>
              <tr>
                <td><input id="input-phone" type="hidden" name="mobile" value="" />
                  <input id="input-verify" type="hidden" name="verify" value="" />
                 <c:if test="${!empty userinfo }"> <input type="button" value="提交需求" class="sBtn" style=" padding:0;" id="sendMESS" onclick="sendSrdz()"/></c:if>
       <c:if test="${empty userinfo }"><input type="button" value="提交需求" class="sBtn" style=" padding:0;" id="sendMESS" onclick="sendLogin()" /></c:if></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
    </div>
    <div style="text-align:center;padding:150px 0;"> <img src="images/dz1.jpg"/> </div>
  </div>
</div>
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
            <input type="text" value="" maxlength="16"  name="verify" id="yanzhengma" style="width:120px; margin-right:20px;">
            <img src="../../../Admin/Login/buildVerify.html" id="yzcode" width="100" height="42" alt="点击切换" onclick="this.src='../../../Admin/Login/buildVerify.html'"> </li>
        </ul>
        <div class="login-button">
          <input type="button"  value="立即提交" class="fM" onclick="sendtosend()" style="line-height:20px" />
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
<script type="text/javascript" src="js/miniBar.js"></script> 
<script type="text/javascript" src="js/lg_reg.js"></script> 
<script language="javascript" type="text/javascript" src="datepicker/WdatePicker.js"></script> 
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
<script type="text/livescript">
$("#sendMESS").live("click",function(){
	var ckmobile=$("#ckmobile").val();
	if(ckmobile){
		$("#yzcode").attr("src",'/Admin/Login/buildVerify');
		$('#popBoxYzm').fadeIn();
	}else{
		sendtosend();
	}
});
function sendtosend(){
	if ($('#remembermobile').attr('checked')){
		remember = 2;
	}else{
		remember='';
	}
	var mobile=$("#shoujihao").val();
	var verify=$("#yanzhengma").val();
	var re = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
	if(!re.exec(mobile)){
		alert("手机号格式不正确");
		$("#shoujihao").focus();
		return false;
	}else{
		$("#input-phone").val(mobile);
		$("#input-verify").val(verify);
		$('#popBoxYzm').fadeOut();
		$('#dForm').submit();
	}
}
</script>
<style>
.dzDetail{height:492px;width:100%;background: url(images/dzBg.jpg) no-repeat center top;}
.diForm{float:right;width:402px;height:432px;}
.dzLeft{font-size:14px;color:#166cbe;width:415px;line-height:20px;margin-top:150px;}
.dzLeft strong{font-size:40px;display:block;padding-bottom:15px;}
.diForm table textarea{width:300px;padding:5px;height:60px;}
.diForm table{width:100%;}
.diForm form{padding:0px 44px 0 44px;}
.diForm form h3{font-weight: normal;font-size:18px;color:#166cbe;text-align:left;padding-bottom:13px;}
.diForm table td{padding-bottom:0;color: #656565;height:auto;padding:7px 0;}
.diForm table .dateTxt{padding-left:4px;width:303px;}
.diForm table .btn{font-size:16px;width:165px;margin:0;}
</style>
  </body>
</html>
