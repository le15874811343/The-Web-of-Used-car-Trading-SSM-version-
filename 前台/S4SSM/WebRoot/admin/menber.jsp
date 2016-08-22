<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员中心-郑州高品质二手车专家_亿金汽车</title>
    
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
<link rel="stylesheet" type="text/css" href="css/hurst.css">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>

<!--[if IE 6]>
<script type="text/javascript" src="js/DD_belatedPNG.js"></script>
<script>
        DD_belatedPNG.fix('*');
    </script>
<![endif]-->
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
      <a href="MemberCenter_needmaiche.action">我要卖车</a>
      <a href="CarInfo_showsrdz.action">私人定制</a>
      <!--<a href="shfw.html">售后服务</a>-->
      <a id="MemberMenuChange" class="b-login" href="MemberCenter_showmenber.action" target="_self">会员中心</a>
      </div>
			<span class="right" id="rightMenuHtml">
       <c:if test="${!empty userinfo }">
       <c:if test="${time<12 }">
          上午好！
      </c:if>
      <c:if test="${time>12 }">
          下午好！
      </c:if>
      <a href="MemberCenter_showmenber.action" class="b-login" id="b-login">
      ${userinfo.uName }
      </a>|<a  href="UserInfo_zhuXiao.action?url=forward:/CarInfo.action" >注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      </c:if>
      			</span>
		</div>
	</div>
	<div class="head-search">
		<div class="wrap clearfix">
			<form class="clearfix left" action="CarInfo_showList.action" method="get" >
				
				<input type="text" name="bname" placeholder="请输入您想要的品牌搜索" style="width:439px;" class="left" />
				<input type="submit" value="搜 索" class="right" />
			</form>
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

<div id="about">
	<div class="mTags wrap">
		<a href="CarInfo.action">亿金名车广场</a>><a>会员中心</a>
	</div>
	<div class="mebBox">
		<div class="meb-cont clearfix wrap">
			<div class="meb-nav left dInline">
				<ul class="clearfix">
					<li class="on"><a href="MemberCenter_showmenber.action">会员中心</a></li>
                    <li ><a href="MemberCenter_showmenberOrder.action">我的需求</a></li>
                    <li><a href="MemberCenter_showmenberYbcar.action">我的车</a></li>
                    <li><a href="admin/memberMyAccount.jsp">账户管理</a></li>				
                </ul>
			</div>
			<div class="meb-right right dInline">
				<div class="mr-top">
    <div class="mr-top-div clearfix">
        <span class="left">
            <img src="images/photo.png"/>
        </span>
        <div class="mr-infor left dInline">
            <h2>  <c:if test="${time<12 }">
          上午好！
      </c:if>
      <c:if test="${time>12 }">
          下午好！
      </c:if>，尊敬的会员 <b> ${userinfo.uName }</b></h2>
            <p>
                手机： ${userinfo.uTel}   邮箱：
                
                <c:if test="${userinfo.uEmail!=null }">
                ${userinfo.uEmail }
                </c:if>
                <c:if test="${userinfo.uEmail==null }">
                                       未填写
                </c:if>
                   [ <a href="admin/memberMyAccount.jsp">管理账户信息</a> ]
            </p>
        </div>
    </div>
</div>
				<div class="mr-detail">
					<div class="me-box">
						<div class="mx-a">
							<ul class="clearfix">
								<li>
									<img src="images/hu1.png"/>
									<span>您目前有 <a href="MemberCenter_showmenberOrder.action"><b>${ydCount }</b></a> 个购买订单在交易中</span>
								</li>
								<li>
									<img src="images/hu2.png"/>
									<span>您共有 <a href="MemberCenter_showmenberSc.action"><b>${scCount }</b></a> 个收藏的车型</span>
								</li>
							</ul>
						</div>
						<div class="mx-b">
							<ul>
								<li class="clearfix">
									<span class="left">
										<img src="images/hu3.png"/>
									</span>
									<div class="mb-txt left dInline">
										<h2>马上参加 <a href="/Tailor/index/channel/4.html">私人定制</a> </h2>
										<p>没有您满意的车型吗，马上参加量身定制可预订指定车型，亿金名车为您量身定制</p>
									</div>
								</li>
								<!--<li class="clearfix last">
									<span class="left">
										<img src="images/hu4.png"/>
									</span>
									<div class="mb-txt left dInline">
										<h2>您可以定制 <a href="#">到车通知</a> </h2>
										<p>不想在每天数以万计的车源中错过自己满意的二手车吗？亿金收集您的需求，第一时间为您推送符合您的信息</p>
									</div>
								</li>-->
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

<script type="text/javascript" src="js/miniBar.js"></script>
<script type="text/javascript" src="js/lg_reg.js"></script>


<script type="text/javascript"> var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://"); document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Faa70c6792578150b40ad413464080efa' type='text/javascript'%3E%3C/script%3E")) </script>

  </body>
</html>
