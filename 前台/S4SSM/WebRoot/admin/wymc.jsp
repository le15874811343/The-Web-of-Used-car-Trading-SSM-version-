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
    
    <title>我要卖车-郑州高品质二手车专家_亿金汽车</title>
    
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
<link rel="stylesheet" type="text/css" href="css/alert.css">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>


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

function sendRequest(str){
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
     xmlhttp.onreadystatechange = getResult; 
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

function getResult(){
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
    function chekspz(){
    var flag=false;
  var stime=  document.all("buytimeval");
  var div=   document.all("cdate");
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
function cheksub(str,str1,str2,str3,str4,str5,str7,str8,str9,str10,str11,str12,str13,str14,str16,str17,str18,str19,str20){
 var flag=false;
 if(sendRequest(str)&&(chekcx(str1,str2,str3,str4,str5)||cheksrcx(str7,str8,str9))&&(chekcx(str10,str11,str12,str13,str14)||cheksrcx(str16,str17,str18))&&chekspz()&&chekywxs(str19,str20)){
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
  <!--头部的开始-->
<div id="header">
	<div class="top">
		<div class="wrap clearfix">
			<a href="#" class="logo left"><img src="images/logo.png"/></a>
			<div class="nav left dInline" id="headerMenu">
      <a  href="CarInfo.action">首页</a>
      <a href="about.jsp">关于亿金</a>
      <a href="CarInfo_showList.action">我要买车</a>
      <a class="on" href="MemberCenter_needmaiche.action">我要卖车</a>
      <a href="CarInfo_showsrdz.action">私人定制</a>
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
      </c:if>				</span>
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
				热门品牌：
<c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
                        <a href="CarInfo_showList.action?bname=${ showcar.value.cBrand}&cser=${showcar.value.cSeries}" >${ showcar.value.cBrand}${showcar.value.cSeries}</a>
            
            </c:forEach>
            </c:if>			</div>
		</div>
	</div>
</div>

<!--头部的结束-->

<style>
input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {color: #000;}
input:-moz-placeholder, textarea:-moz-placeholder {color:#000;}
input::-moz-placeholder, textarea::-moz-placeholder {color:#000;}
input:-ms-input-placeholder, textarea:-ms-input-placeholder {color:#000;}
.select-item{margin-bottom: 25px;}
</style>
<div id="about">
	<div class="mTags wrap">
		<a href="index.jsp">亿金名车广场</a>><a >我要卖车</a>
	</div>
	<div class="sellBox">
		<div class="sellTop">
			<div class="wrap">
				<div class="selDetail">
					<div class="sel-a left dInline">
						<ul class="clearfix">
							<li>
								<img src="images/sell1_1.png"/>
								<strong>流程简单</strong>
							</li>
							<li>
								<img src="images/sell1_2.png"/>
								<strong>快速回款</strong>
							</li>
							<li class="last">
								<img src="images/sell1.png" style="color:#000" />
								<strong>诚信服务</strong>
							</li>
						</ul>
						<p>
                        	<strong style="font-size:24px;">亿金标准</strong><br/><br/>
                            车龄不超过4年<br/>
                            行驶里程不超过80000公里<br/>
                            无结构性损伤，非事故车、泡水车或火烧车<br/>
                            具有完备、合法的车辆手续
                        </p>
					</div>
					<div class="sell-form right dInline" >
						<form  action="MemberCenter_logincar.action" method="post"  onsubmit="return cheksub('sel1','sel5','cx','scx','ccx','srcx','srcx','scx','ccx','styleCar','cxi','scxi','ccxi','srcxi','srcxi','scxi','ccxi','mialval','cdis')">
							<h3>登记您的爱车信息</h3>
							<div class="sell-info" style="margin-top:5px">
                                <div class="select-item clearfix">
                                	<select class="select car-select" name="sel1" id="sel1" style="width:100%" onchange="sendRequest('sel1')">
										<option value="选择品牌">请选择品牌</option>
								  <c:if test="${!empty allbrand }">
                    <c:forEach var="allbrand" items="${allbrand }">
                    <option value=${allbrand.value.bId }>${allbrand.value.bName }</option>
                    </c:forEach>
                    </c:if>
                    </select>
                    <input type="hidden" name="selq" id="selq">
      <div id="spp" style="display: none"><font color="red">请选择品牌</font></div>
                  
								</div>
								<div class="select-item clearfix">
                                    <select class="select car-select" name="sel5" id="sel5" style="width:100%" onchange="chekcx('sel5','cx','scx','ccx','srcx')">
                                        <option value="请选择">请先选择品牌</option>
                                    </select>
								</div>
								<div  class="select-item clearfix" id="cx" style="display: none"><input type="text" placeholder="请输入您的车系" class="select car-select" id="srcx" onblur="cheksrcx('srcx','scx','ccx')"></div>
                                								 <div id="scx" style="display: none"><font color="red">请录入车系信息</font></div>
                                
                                <input type="hidden" id="ccx" name="ccx"> 
                                <div class="select-item clearfix">
                                    <select class="select car-select" name="styleid" id="styleCar" style="width:100%" onchange="chekcx('styleCar','cxi','scxi','ccxi','srcxi')">
                                        <option value="请选择">请选择车型</option>
                                        <c:if test="${!empty cartype }">
                                        <c:forEach var="cartype" items="${cartype }">
                                         <option value="${cartype.value.tName}">${cartype.value.tName}</option>
                                        </c:forEach>
                                        </c:if>
                                        <option>其他</option>
                                    </select>
                                    
								</div>
								<div  class="select-item clearfix" id="cxi" style="display: none"><input type="text" placeholder="请输入您的车型" class="select car-select" id="srcxi" onblur="cheksrcx('srcxi','scxi','ccxi')"></div>
                                                                 <div id="scxi" style="display: none"><font color="red">请录入车型信息</font></div>
                                
                                <input type="hidden" id="ccxi" name="ccxi"> 
								<!--<div class="select-item clearfix">
									<input id="input-phone" type="text" name="phone" value="手机号" class="cPut" style="width:150px" />
                                    <input type="text" name="verify" value="验证码" style="width:110px; margin:0 5px 0 25px" class="cPut" />
                                    <div id="send_Mess" class="left"><a href="#" class="send_Mess right">获取验证码</a></div>
								</div>-->
                                <div class="select-item clearfix">
                                    <input type="text" value="" placeholder="上牌时间" class="form_datetime cPut" id="buytimeval" name="buytime" data-date-format="yyyy-mm"  style="float:left; width:150px" onblur="chekspz()" />
                                   <input type="text"  placeholder="行驶里程" value="" class="cPut" id="mialval" name="mialval" style="float:right" onblur="chekywxs('mialval','cdis')"/>
                                    <div class="unit">万公里</div>
                                </div>
                                <div>
                                <div style="float:left;display: none" id="cdate"><font color="red">请选择上牌时间</font></div>
                                <div style="float:right;display: none" id="cdis"></div> 
                                </div>
								<div >
          
                                    <input type="submit" value="提交" >		
									<!--<a href="javascript:void(0)" onclick="$('#forms').submit()">登记</a>-->
									<!--<a href="#">评估</a>-->
								</div>
							</div>
						</form>
<input type="hidden" id="ckmobile" value="1" />
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
		$('#forms').submit();
	}
}
</script>
<link rel="stylesheet" type="text/css" href="css/jquery.fancybox-1.3.4.css">
<script type="text/javascript" src="js/jquery.fancybox-1.3.4.js"></script>

					</div>
				</div>
			</div>
		</div>
		<div class="sell-a">
			<div class="wrap">
				<h2>二手车须知及流程</h2>
				<div class="sa-list">
					<ul class="clearfix">
						<li>
							<img src="images/sell2_1.png"/>
							<h4>准备手续</h4>
							<p>
								<!-- <b>车辆手续：</b><br/>
								包括行驶证、机动车登记证、购置附加税凭证、保险单据等，主要是前面三项。
								<b>车主手续：</b><br/>
								个人准备身份证原件；单位准备公章、组织机构代码证原件（正本、副本都可）。 -->
								机动车登记证、行驶证、保养手册、身份证复印件等车辆资料
							</p>
						</li>
						<li>
							<img src="images/sell2_2.png"/>
							<h4>上门评估</h4>
							<p>
								可以通过电话、网络提交评估需求，我们专业评估团队会及时联系您约上门评估时间和地点。

							</p>
						</li>
						<!-- <li>
							<img src="images/sell2_3.png"/>
							<h4>亿金365项检测</h4>
							<p>
								可以通过二手车市场、置换、网上自己出售等多种方式选择出售车辆。选择一家知名度高、信誉好的二手车企业，不仅可以简化交易流程，还可避免不必要的经济损失。
							</p>
						</li> -->
						<li>
							<img src="images/sell2_4.png"/>
							<h4>确定价格</h4>
							<p>
								评估师根据车况反馈评估价格，结合车主售车意愿确定车辆价格。
							</p>
						</li>
						<li class="last">
							<img src="images/sell2_4.png"/>
							<h4>手续办理</h4>
							<p>
								确定交易的车辆准备好相关手续，由车主本人现场签字办理相关手续。
 
							</p>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="main-a">
			<div class="mDiv sell-b">
				<img src="images/sell3.jpg"/>
			</div>
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
                            <img src="../../../Admin/Login/buildVerify.html" id="yzcode" width="100" height="42" alt="点击切换" onclick="this.src='../../../Admin/Login/buildVerify.html'">
			            </li>
			        </ul>
			        <div class="login-button">
			            <input type="button"  value="立即提交" class="fM" onclick="sendtosend()" style="line-height:20px" />
			        </div>
				</form>
        </div>
        <a class="closed">×</a>
	</div>
</div>
<div style="display:none;">
	<div id="showDiv">
		<div class="guBox">
			<h3>您的爱车</h3>
			<p>欧蓝德(进口) 2014款欧蓝德(进口)2.4L四驱豪华超值版7座 </p>
			<span>上牌时间：<font> 2014-12</font> </span><span>行驶里程： <font>1万公里</font></span>
			<h3>评估价：<strong>￥18.14万</strong></h3>
		</div>
		<img src="images/jzgu.png" class="s_gu" />
	</div>
</div>
<style type="text/css">
.sa-list li{width:223px;}
#showDiv{width:800px;height:270px;background:#fff;position:relative;}
#showDiv .s_gu{position:absolute;right:20px;bottom:15px;}
.guBox{padding:20px 30px 0 30px;font-size:20px;}
.guBox h3{color:#000;font-weight: normal;margin-top:30px;font-size:20px;}
.guBox h3 strong{font-weight: bold;color:#0756b5}
.guBox p{color:#427dc6;font-weight: bold;padding:10px 0;}
.guBox span{font-size:14px;display:inline-block;margin-right:15px;}
.guBox span font{font-weight: bold;color:#437ec6;font-size:14px;}
</style>
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
<!--<script type="text/javascript" src="js/borrow.js"></script>-->


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
  </body>
</html>
