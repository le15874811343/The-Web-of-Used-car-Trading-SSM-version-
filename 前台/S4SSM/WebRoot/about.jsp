<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>关于亿金</title>
    
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
<link rel="stylesheet" href="css/about.css">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG.js"></script>
<script>
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->
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
 var url = "<%=basePath%>UserInfo_needReg.action?&nocahe="+new Date().getTime()+"";
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
			<a href="#" class="logo left"><img src="images/logo.png"/></a>
			<div class="nav left dInline" id="headerMenu">
      <a  href="CarInfo.action">首页</a>
      <a class="on" href="about.jsp">关于亿金</a>
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
      <c:if test="${!empty userinfo }"><a  class="b-login" id="b-login">
      <c:if test="${time<12 }">
      上午好！${userinfo.uName }
      </c:if>
      <c:if test="${time>12 }">
      下午好！${userinfo.uName }
      </c:if>
      </a>|<a  href="UserInfo_zhuXiao.action?url=about"  id="b-regist">注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>
      </span>
		</div>
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
            </c:if>  
			</div>
		</div>
	</div>
</div>

<div id="about">
	<div class="mTags wrap">
		<a href="#">亿金名车广场</a>><a >亿金简介</a>
	</div>
	<div class="wAbout">
		<div class="a-wa">
			<div class="wrap a-nav">
				<ul class="clearfix">
					<li class="on"><a >亿金简介</a></li>
					<li><a href="Trends_showCom.action" >客户留言</a></li>
					
					<li><a  href="Trends_showActive.action">活动中心</a></li>
					<li>
				<a href="Trends_showNewsList.action" >亿金动态</a></li>
				<li><a href="shfw.jsp" target="_blank">售后服务</a></li>
				<li class="last"><a href="contact.jsp">联系我们</a></li></ul>
			</div>
		</div>
		<div class="a-wb">
			<div class="wrap" style="display: block;">
				<h1>亿金简介</h1>
				<div class="a-div">
					<p style="text-align: center;"><br/></p><p style="text-align: center;"><span style="font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; font-size: 14px;">&nbsp; &nbsp;<span style="font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;">亿金名车广场，系河南亿金有限公司旗下企业，中部5S二手名车综合服务商，拥有一座10000多平米的双层豪华展厅。主营奥迪、宝马、奔驰、路虎、保时捷、等几十种高档精品二手名车。业务涵盖车辆买卖、车辆置换、名车定制、新车销售、金融按揭、保险、保养维修等，并为客户代办车辆上牌、过户、违章处理、年检等贴心一站式服务。</span></span></p><p style="text-align: center;"><span style="font-size: 14px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;">&nbsp; &nbsp; 自成立以来，公司秉承“诚立中原、信达天下”的经营理念，坚持“一口价”销售理念，引进“认证车”管理模式。所有车辆均经过资深技师<span style="font-size: 16px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(0, 176, 240);">365项专业检测，以杜绝销售事故车，泡水车为原则，为客户承诺所售车辆7天退换，一年或2万公里无忧质保</span>，是中原首家推出在售车辆5000公里无需保养的二手车企业。</span></p><p style="text-align: center;"><span style="font-size: 14px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;">公司凭借精准的战略布局、明晰的市场定位、严苛的品质管理和贴心的全方位服务，在短短的两年时间里飞速发展。便捷的一站式购车平台和优质贴心的全方位服务赢得了客户的青睐和良好的口碑。“亿金名车”高端尊贵、值得信赖的品牌形象逐步树立，目前已成为中原人民购买高端二手车的首选品牌。</span></p><p><br/></p><p style="text-align: center;"><br/></p><p><br/></p>				</div>
				<div class="a-div" id="dizhi">
					<div class="a-xi clearfix">
						<div style="width:697px;height:290px;border:#ccc solid 1px;margin-right:50px;" id="dituContent" class="left"></div>
						<p>
							<strong>联系亿金</strong><br/>
							展厅地址：郑州市管城区紫荆山东大街裕鸿花园<br/>
							联系电话 ：400-888-6666 <br/>
							邮箱：dpy0705@126.com<br/>
							官方网站：http://www.hnyijin.com<br/>
							亿金名车官方微博：@亿金二手名车广场<br/>
							亿金名车微信号：hnyijin
						</p>
					</div>
				</div>
				
			</div>
		</div>
		
	</div>
</div>

<div id="footer">
	<div class="foot-a1">
		<div class="wrap">
			<ul class="clearfix">
            	<li>
                	<img src="images/db1.png"/>
                    <p>365项检测认证</p>
                </li>
                <li>
                	<img src="images/db2.png"/>
                    <p>5000公里无需保养</p>
                </li>
                <li>
                	<img src="images/db3.png"/>
                    <p>1年或两万公里无忧质保</p>
                </li>
                <li>
                	<img src="images/db4.png"/>
                    <p>7天无忧退换</p>
                </li>
                <li>
                	<img src="images/db5.png"/>
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
        <li><a href="Trends.action?op=shownewslist" target="_blank">亿金动态</a></li>
        <li><a href="Trends.action?op=showactive" target="_blank">活动中心</a></li>
          
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
					 <a href="CarInfo_showDetails.action?uid=${pareCarInfo.value.UId }&cid=${pareCarInfo.value.CId }" target="_blank">${pareCarInfo.value.CBrand }${pareCarInfo.value.CSeries } ${pareCarInfo.value.CReleaseyear } 款 ${pareCarInfo.value.CVolume }L ${pareCarInfo.value.CGeartype } ${pareCarInfo.value.CCode } ${pareCarInfo.value.CModel }</a><br>
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
          <input type="hidden" name="url" value="about">
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
             <input type="hidden" name="url" value="about">
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
          <input type="hidden" name="url" value="about">
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
             <input type="hidden" name="url" value="about">
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
          <input type="hidden"  name="url" value="about">
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
             <input type="hidden" name="url" value="about">
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

<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(113.688899,34.753367);//定义一个中心点坐标
        map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
	map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
	map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
    
    //标注点数组
    var markerArr = [{title:"亿金汽车",content:"地址：紫荆山东大街裕鸿花园<br/>电话：400-888-666",point:"113.688297|34.753857",isOpen:0,icon:{w:23,h:25,l:46,t:21,x:9,lb:12}}
		 ];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
			var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
			var iw = createInfoWindow(i);
			var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
			marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                        borderColor:"#808080",
                        color:"#333",
                        cursor:"pointer"
            });
			
			(function(){
				var index = i;
				var _iw = createInfoWindow(i);
				var _marker = marker;
				_marker.addEventListener("click",function(){
				    this.openInfoWindow(_iw);
			    });
			    _iw.addEventListener("open",function(){
				    _marker.getLabel().hide();
			    })
			    _iw.addEventListener("close",function(){
				    _marker.getLabel().show();
			    })
				label.addEventListener("click",function(){
				    _marker.openInfoWindow(_iw);
			    })
				if(!!json.isOpen){
					label.hide();
					_marker.openInfoWindow(_iw);
				}
			})()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    
    initMap();//创建和初始化地图
</script>

  </body>
</html>
