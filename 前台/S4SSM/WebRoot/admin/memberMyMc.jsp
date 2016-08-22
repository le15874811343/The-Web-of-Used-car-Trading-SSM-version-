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
    
    <title>会员中心-郑州高品质二手车专家_河南亿金名车广场</title>
    
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
<!--<link rel="stylesheet" type="text/css" href="css/jquery.fancybox-1.3.4.css">-->

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

function sendXj(c_id,c_uid,nop){

 var url = "<%=basePath%>MemberCenter_"+nop+".action?cid="+c_id+"&uid="+c_uid+"&nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getXj; 
     xmlhttp.send(null); 
  } 
} 


function getXj(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
    //在这里填写具体的提取返回数据，并处理
    var data=xmlhttp.responseText;
    showDiv(data);
    window.location.href="MemberCenter_showmenberXj.action";
  }
}

</script>
<script type="text/javascript">
function showDiv(data){
var strs=new Array();
strs=data.split(":");

 var a =document.getElementById("popDiv");
 a.style.display="block";
 a.innerHTML=""+strs[0]+"<br/><a href='MemberCenter_showmenberXj.action'>"+strs[1]+"</a><br/><a href='javascript:closeDiv()'>关闭窗口</a>";
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
      </c:if>			</span>
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
		<a href="CarInfo.action">亿金名车广场</a>><a href="MemberCenter_showmenber.action">会员中心</a>><a>我的需求</a>
	</div>
	<div class="mebBox">
		<div class="meb-cont clearfix wrap">
			<div class="meb-nav left dInline">
				<ul class="clearfix">
					<li><a href="MemberCenter_showmenber.action">会员中心</a></li>
                    <li class="on"><a href="MemberCenter_showmenberOrder.action">我的需求</a></li>
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
					<div class="mr-tab clearfix">
						<a href="MemberCenter_showmenberOrder.action">我的订单</a>
						<a href="MemberCenter_showsrdz.action">私人订制</a>
						<a class="on" href="MemberCenter_showmenberMc.action">出售中的车</a>
						<a href="MemberCenter_showmenberSh.action">审核中的车</a>
                        <a href="MemberCenter_showmenberSc.action">我收藏的车型</a>
										    <a   href="MemberCenter_showmenberzzmr.action" >申请取消买入的车</a>
					
					</div>
					<div class="me-box">
		           <div class="me-dl"></div>
		           <div class="me-dl"></div>
		           <div class="me-dl"></div>
		           <div class="me-dl"  style="display:block;">
							<div class="me-one" id="me-four">
							<c:if test="${!empty szCar }">
							<c:forEach var="szCar" items="${szCar }">
							<ul class="cs-list"><li class="clearfix" style="position: relative;">	<span class="carImg left dInline"><a href="MemberCenter_showdea.action?cid=${szCar.value.cId}&uid=${szCar.value.uId}" target="_blank"><div class="car_bg"> </div>		<img src="${szCar.value.cImg}" onerror="this.src='images/pro4.jpg'" width="300" /></a>	</span>	<div class="carTxt right dInline">		<h2><a href="MemberCenter_showdea.action?cid=${szCar.value.cId}&uid=${szCar.value.uId}" target="_blank">${szCar.value.cBrand }${szCar.value.cSeries}  ${szCar.value.cReleaseyear}款   ${szCar.value.cVolume}T ${szCar.value.cGeartype} ${szCar.value.cCode}${szCar.value.cModel}</a></h2>		<p>			<span>上牌时间：${szCar.value.cReleaseyear}</span> 
							<span>行驶里程：${szCar.value.cDistance}万公里</span>
							<span>排量：${szCar.value.cVolume}T</span><span>
							排放标准：${szCar.value.cEmissionstandard}</span>
							<span>状态：${szCar.value.cState}</span>
							</p><div class="price clearfix" style="margin:5px 0;"><div class="left dInline pNum">	<font>一口价</font><br/><span class="num nBlue">${szCar.value.cPrice}</span><font> 万元</font>			 </div>				 				</div>		<div class="cs_bt clearfix">						<a  onclick="sendXj(${szCar.value.cId},${szCar.value.uId },'needxj')">取消上架</a>		</div>	</div></li></ul><div class="hPages">    </div>
							</c:forEach>
							</c:if>
								</div>
								 <div class="pages"> <c:if test="${curPage > 1}">
					<a href="MemberCenter_showmenberMc.action?jumpPage=1">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="MemberCenter_showmenberMc.action?jumpPage=${curPage - 1}">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="MemberCenter_showmenberMc.action?jumpPage=${curPage + 1}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="MemberCenter_showmenberMc.action?jumpPage=${maxPage}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</div>
						</div>
		          
		           <div class="me-dl"></div>
		   <div class="me-dl"></div>
                        
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="overlay">
	<div class="popup-over t-center" style="margin-left:-380px; height:420px;margin-top: -200px;">
		<div class="popDiv popDiv1">
			<div class="pop-head clearfix">
				<h2 class="left dInline">上传资料</h2>
                <h1 id="p_closedziliao" style="float:right">关闭</h1>
			</div>
			<div class="pop-cont">
            	<form action="/Member/cardImg/channel/7.html"  method="post" id="uploadIdForm" name="uploadIdForm" enctype="multipart/form-data"><!-- onsubmit="subc();"-->
				<dl>
					<dt>必要认证资料</dt>
					<dd>
						<ul class="clearfix verify_ul">
							<li>
								<span>身份认正证</span>
								<div class="ver-a">
                                	<img src="images/qzx.jpg" id="imgPreview1" width="200" height="130" /><br />
                                    <input type="file" name="postfile1" onchange='PreviewImage1(this)' />
								</div>
							</li>
                            <li>
								<span>身份认反证</span>
								<div class="ver-a">
                                	<img src="images/qzx.jpg" id="imgPreview2" width="200" height="130" /><br />
                                    <input type="file" name="postfile2" onchange='PreviewImage2(this)' />
								</div>
							</li>
						</ul>
					</dd>
				</dl>
                	<input type="hidden" name="memId" value="" id="memId" />
				<a class="pop_submit" href="javascript:void(0)" onclick="$('#uploadIdForm').submit()">提交资料</a>
                </form>
			</div>
		</div>
	</div>
</div>
<style type="text/css">
#showdiv{width:586px;background:#fff;overflow: hidden;color:#333;}
#showdiv .showTit{color: #000;font-size:18px;border-bottom:1px solid #a0a0a0;padding:20px;background:#f3f3f3;}
#showdiv .dk_r{width:205px;}
#showdiv .dk_div{width:516px;background:#f3f3f3;height:180px;margin:15px auto;}
.dk_tit{height:37px;line-height:37px;background:#ccd3e0}
.dk_tit span{display:inline-block;float:left;width: 50%;text-align:center;color:#3865c0;font-size:14px;position:relative;height:37px;cursor: pointer;}
.dk_tit span.on{color:#fff;background:#3865c0}
.dk_tit span.on i{position:absolute;left:50%;margin-left:-3px;background:url(images/dk_d.png) no-repeat;width:6px;height:4px;bottom:-4px;}
.dk_dl{padding:30px 0px 0 40px;}
.dk_dl label{width: 70px;display:block;height:25px;margin-right:20px;}
.dk_dl li{height:25px;line-height:25px;font-size:14px;color:#000;margin-bottom:20px}
.dk_tag span{display:inline-block;padding:0 13px;margin-right:10px;cursor: pointer;cursor: pointer;}
.dk_tag span.on{background:#3865c0;color: #fff;}

a.dk_btn{display:block;background-color: #1663B1;color:#fff;font-size:14px;height:30px;line-height:30px;width:215px;margin:0 auto;text-align: center;margin-top:10px}
#showdiv li .yh_s{cursor: pointer;}
.buy_je{text-align: center;font-size:18px;padding:15px 0 0 0;line-height:38px;}
.buy_je strong{font-weight: normal;color: #3865c0;font-size:38px;display:inline-block;padding:0 6px;}
.dk_result{background:#f3f3f3;padding:20px 0;text-align:center;margin-top:25px;}
.dk_tel{font-size:18px;color:#484848;padding:10px 0 4px 0;}
.dk_result p{color:#969696;}
</style>
<script type="text/javascript">
$(function(){
	$('.dk_tit span').each(function(index){
		$(this).click(function(){
			$(this).addClass('on').siblings().removeClass('on');
			$('.dk_dl ul').eq(index).removeClass('hide').siblings().addClass('hide');
		})
	});
	$('.dk_tag span').click(function(){
		$(this).addClass('on').siblings().removeClass('on');
	})
})
</script>
<div style="display:none;">
	<div id="showdiv">
		<div class="showTit">车贷计算器</div>
		<form action="" enctype="multipart/form-data" name="suandk" id="suandk" onsubmit="return daikuanjisuan();">
			<div class="buy_je" id="thisCarPrice">汽车金额 <strong>万</strong>元</div>
			<div class="dk_div">
				<div class="dk_tit clearfix yinhangselect">
<span class="on" data-pk="0" data-type="中国工商银行" onclick="changeprice('yinhang','0','中国工商银行');">中国工商银行<i></i></span>
						<span data-pk="1" data-type="平安银行" onclick="changeprice('yinhang','1','平安银行');">平安银行<i></i></span>				</div>
				<div class="dk_dl">
<ul>
						<li class="clearfix shoufubili">
							<label class="left">首付比例</label>
							<div class="dk_tag left dInline">
<span class="on" data-pk="30" data-type="中国工商银行" onclick="changeprice('shoufu','30');">30%</span>
<span data-pk="50" data-type="中国工商银行" onclick="changeprice('shoufu','50');">50%</span>
							</div>
						</li>
						<li class="clearfix fenqishu">
							<label class="left" style="letter-spacing:8px;">分期数</label>
							<div class="dk_tag left dInline">
<span class="on" data-pk="3" data-type="中国工商银行" onclick="changeprice('fenqi','3');">3年（3×12期）</span>
								<span data-pk="1" data-type="中国工商银行" onclick="changeprice('fenqi','1');" style="display:none" id="openclick">1年（1×12期）</span>
							</div>
						</li>
					</ul>					<ul class="hide">						<li class="clearfix shoufubili">
							<label class="left">首付比例</label>
							<div class="dk_tag left dInline">
<span class="on" data-pk="40" data-type="平安银行" onclick="changeprice('shoufu','40');">40%</span>
								<span data-pk="50" data-type="平安银行" onclick="changeprice('shoufu','50');">50%</span>							</div>
						</li>
						<li class="clearfix fenqishu">
							<label class="left" style="letter-spacing:8px;">分期数</label>
							<div class="dk_tag left dInline">
<span class="on" data-pk="3" data-type="平安银行" onclick="changeprice('fenqi','3');">3年（3×12期）</span>
								<span data-pk="1" data-type="中国工商银行" onclick="changeprice('fenqi','1');" style="display:none" id="openclick">1年（1×12期）</span>
							</div>
						</li>
					</ul>				</div>
			</div>
			<div class="dk_result">
                <input type="hidden" name="mobile" value="" id="setmobile" />
				<input type="hidden" name="carid" value="" id="thisCarId" />
                <span id="changepriceHtml"></span>
				<a href="javascript:void(0)" onclick="$('#suandk').submit()" class="dk_btn">贷款结果发送到手机</a>				<div class="dk_tel">咨询电话：400-003-7777</div>
				<p>注：计算结果仅供查考，此车贷产品由诺信汽车金融提供</p>
			</div>
		</form>
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

<div id="popDiv" class="mydiv" style="display:none;">
</div>
<div id="bg" class="bg" style="display:none;"></div>
<iframe id='popIframe' class='popIframe' frameborder='0' ></iframe>
<script type="text/javascript" src="js/miniBar.js"></script>
<script type="text/javascript" src="js/lg_reg.js"></script>

<script type="text/javascript" src="js/smooth-scroll.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<!--<script type="text/javascript" src="js/CarLoad.js"></script>
<script type="text/javascript" src="js/jquery.fancybox-1.3.4.js"></script>
<script src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=810a1f8c-0ebe-4324-9a03-00c2d328d099&amp;pophcol=2&amp;lang=zh" type="text/javascript" charset="utf-8"></script>
<script src="http://static.bshare.cn/b/bshareC0.js" type="text/javascript" charset="utf-8"></script>-->

<script type="text/javascript">
$('.mr-tab a').each(function(index){
	$(this).click(function(){
		$(this).addClass('on').siblings().removeClass('on');
		$('.me-dl').eq(index).show().siblings().hide();
	})
});
$('.cs_ding a').mouseover(function(){
	this.style.color='blue';
})
$('.cs_ding a').mouseout(function(){
	this.style.color='#4573af';
})
function clsub(id){
	$('#memId').val(id);
	var url='/Member/getCardImg/channel/7.html';
	$.ajax({
		type: "POST",
		url: url,
		data: {id:id},
		dataType: "json",
		success: function(data){
			if(data.idcarda){
				document.getElementById("imgPreview1").src = data.idcarda;
			}else{
				document.getElementById("imgPreview1").src = 'images/qzx.jpg';
			}
			if(data.idcardb){
				document.getElementById("imgPreview2").src = data.idcardb;
			}else{
				document.getElementById("imgPreview2").src = 'images/qzx.jpg';
			}
		}
	});
	$overlay = $('.overlay');
	$overlay.addClass('active');
	 $('.popup-over').show().addClass('active');
	$overlay.click(function(){
		modalHidden($whichPopup);
	});
	var $whichPopup = $('.popup-over');
		$('.popup-over').show().addClass('active');
		$overlay.click(function(){
		modalHidden($whichPopup);
	});
	$('.overBtn').click(function(){
		modalHidden($whichPopup);
	});
	$whichPopup.click(function(e){
		e.stopPropagation();
	});
	function modalHidden($ele) {
		$ele.removeClass('active');
		$overlay.removeClass('active');
	}
	
}

function subc(){
	var postfile1=uploadIdForm.postfile1.value;
	var postfile2=uploadIdForm.postfile2.value;
    var memId=uploadIdForm.memId.value;
	var url='/Member/cardImg/channel/7.html';
	$.ajax({
		type: "POST",
		url: url,
		data: {postfile1:postfile1, postfile2:postfile2,memId:memId},
		dataType: "json",
		headers:{'ClientCallMode':'ajax'},
		data:$('#formid').serialize(),
		success: function(data){
			if(data.result=='1'){
				alert('添加成功');
			}else{
				alert('添加失败');
				window.location.reload();
			}
		}
	});
	return false;
}
$('.auth').click(function(){
	$('.ver_dialog').fadeIn();
})
$('.ui-dialog-close').click(function(){
	$('.ver_dialog').fadeOut();
})
$('#me-one .hPages a').live('click',function(){
	var url=$(this).attr('href');
	$.ajax({
		type: "POST",
		url: url,
		data: {type:'LSDZ'},
		success: function(data){
			$('#me-one').html(data);
		}
	});
	return false;
})
$('#me-tow .hPages a').live('click',function(){
	var url=$(this).attr('href');
	$.ajax({
		type: "POST",
		url: url,
		data: {type:'SELL'},
		success: function(data){
			$('#me-tow').html(data);
		}
	});
	return false;
})
$('#me-three .hPages a').live('click',function(){
	var url=$(this).attr('href');
	$.ajax({
		type: "POST",
		url: url,
		data: {type:'APPLY'},
		success: function(data){
			$('#me-three').html(data);
		}
	});
	return false;
})
$('#me-four .hPages a').live('click',function(){
	var url=$(this).attr('href');
	$.ajax({
		type: "POST",
		url: url,
		data: {type:'CONCERN'},
		success: function(data){
			$('#me-four').html(data);
		}
	});
	return false;
})
$('#me-o .hPages a').live('click',function(){
	var url=$(this).attr('href');
	$.ajax({
		type: "POST",
		url: url,
		data: {type:'ORDER'},
		success: function(data){
			$('#me-o').html(data);
		}
	});
	return false;
})
$('#p_closedziliao').click(function(){
	$('.overlay').removeClass('active');
})

function delNeed(act,meb){
	var url='/Member/delNeed/channel/7.html';
	$.ajax({
		type: "POST",
		url: url,
		data: {act:act,meb:meb},
		success: function(data){
			if(data.result){
				alert('已取消该需求');
				window.location.reload();
			}else{
				alert('需求操作失败');
				window.location.reload();
			}
		}
	});
	return false;
}
function delNeedThis(carid){
	var url='/Member/delCondent/channel/7.html';
	$.ajax({
		type: "POST",
		url: url,
		data: {carid:carid},
		success: function(data){
			if(data.result){
				alert('已取消该收藏');
				 window.location.href="/Member/need/channel/7/list/11/tpl/4";
			}else{
				alert('收藏取消失败');
			}
		}
	});
	return false;
}

function delOrder(act,meb){
	var url='/Member/delOrder/channel/7.html';
	$.ajax({
		type: "POST",
		url: url,
		data: {act:act,meb:meb},
		success: function(data){
			if(data.result){
				alert('已取消该订单');
				window.location.reload();
			}else{
				alert('订单取消失败');
			}
		}
	});
	return false;
}
</script>
<!--<script>
function PreviewImage1(imgFile){
	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	if(!pattern.test(imgFile.value)){
		alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
		imgFile.focus();
	}else{
		var path;
		if(document.all){
			imgFile.select();
			path = document.selection.createRange().text;
			document.getElementById("imgPreview1").src="";
			document.getElementById("imgPreview1").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\"" + path + "\")";//使用滤镜效果
		}else{
			path = URL.createObjectURL(imgFile.files[0]);
			document.getElementById("imgPreview1").src = path;
		}
	}
}
function PreviewImage2(imgFile){
	var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
	if(!pattern.test(imgFile.value)){
		alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
		imgFile.focus();
	}else{
		var path;
		if(document.all){
			imgFile.select();
			path = document.selection.createRange().text;
			document.getElementById("imgPreview2").src="";
			document.getElementById("imgPreview2").style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='scale',src=\"" + path + "\")";//使用滤镜效果
		}else{
			path = URL.createObjectURL(imgFile.files[0]);
			document.getElementById("imgPreview2").src = path;
		}
	}
}

</script>
-->

  </body>
</html>
