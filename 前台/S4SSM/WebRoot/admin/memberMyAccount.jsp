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

/*
用途：检查输入字符串是否符合身份证格式
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/

function isIDno(strIDno) 
{  
    var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}; 
  
    var iSum = 0; 
    var info = ""; 
    //var strIDno = obj.value; 
    var idCardLength = strIDno.length;   
    if(!/^\d{17}(\d|x)$/i.test(strIDno)&&!/^\d{15}$/i.test(strIDno))  
    {
        //alert("非法身份证号"); 
        return false; 
    } 
  
    //在后面的运算中x相当于数字10,所以转换成a 
    strIDno = strIDno.replace(/x$/i,"a"); 
 
    if(aCity[parseInt(strIDno.substr(0,2))]==null) 
    { 
        //alert("非法地区"); 
        return false; 
    } 
     
    if (idCardLength==18) 
    { 
        sBirthday=strIDno.substr(6,4)+"-"+Number(strIDno.substr(10,2))+"-"+Number(strIDno.substr(12,2)); 
        var d = new Date(sBirthday.replace(/-/g,"/")) 
        if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate())) 
        {        
            //alert("非法生日"); 
            return false; 
        } 
 
        for(var i = 17;i>=0;i --) 
            iSum += (Math.pow(2,i) % 11) * parseInt(strIDno.charAt(17 - i),11); 
 
        if(iSum%11!=1) 
        { 
            //alert("非法身份证号"); 
            return false; 
        } 
    } 
    else if (idCardLength==15) 
    { 
        sBirthday = "19" + strIDno.substr(6,2) + "-" + Number(strIDno.substr(8,2)) + "-" + Number(strIDno.substr(10,2)); 
        var d = new Date(sBirthday.replace(/-/g,"/")) 
        var dd = d.getFullYear().toString() + "-" + (d.getMonth()+1) + "-" + d.getDate();    
        if(sBirthday != dd) 
        { 
            //alert("非法生日"); 
            return false; 
        } 
    } 
    return true;
}

function chekCard(){
var flag=false;
 var card= document.all("card");
 var div=document.all("d2");
 if(card.value.length>0){
     if(isIDno(card.value)){
     flag=true;
     div.style.display="none";
     }
     else{
     div.innerHTML="<font color='red'>请输入正确的身份证</font>";
    div.style.display="inline";
     }
 }
 else{
 flag=true;
  div.style.display="none";
 }
 return flag;
}
/*
用途：检查输入字符串是否是数字
输入：
str：字符串
返回：
如果通过验证返回true,否则返回false
*/

function isNumber(str) 
{         
    var reg = /^\d+$/;
    if (reg.test(str))
       return true; 
    else  
       return false; 
}

function chekqq(){
var flag=false;
var qq=document.all("qq");
var div=document.all("d4")
if(qq.value.length>0){
  if(qq.value.length<6){
  div.innerHTML="<font color='red'>请输入正确的QQ</font>";
    div.style.display="inline";
  
  }
  else{
      if(isNumber(qq.value)){
      flag=true;
       div.style.display="none";
      
      }
      else{
      div.innerHTML="<font color='red'>请输入正确的QQ</font>";
    div.style.display="inline";
      }
  
  }

}
 else{
 flag=true;
  div.style.display="none";
 }
 return flag;
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

function chekemail(){
var flag=false;
 var email= document.all("email");
  var div=document.all("d5");
  if(email.value.length>0){
  if(isEmail(email.value)){
  flag=true;
   div.style.display="none";
  }
  else{
    div.innerHTML="<font color='red'>请输入正确的邮箱</font>";
    div.style.display="inline";
  }
  
  
  }
  else{
  flag=true;
   div.style.display="none";
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
    function chekName(){
    var flag=false;
     var str=document.all("realname")
      var div=document.all("d1")
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
    function cheksubmit(){
    var flag=false;
    if(chekName()&&chekCard()&&chekqq()&&chekemail()){
    flag=true;
    
    }
    return flag;
    }
</script>
<script type="text/javascript">
  function chekopwd(){
   var flag=false;
  var opwd=document.all("opwd");
  var div=document.all("d6");
  if(opwd.value.length<=0){
    div.innerHTML="<font color='red'>当前密码不能为空</font>";
    div.style.display="inline";
  
  }
  else{
  if(opwd.value.length<=6){
    div.innerHTML="<font color='red'>当前密码必须大于六位</font>";
    div.style.display="inline";
  
  }
  else{
  flag=true;
   div.style.display="none";
  }
  }
  return flag;
  }
  function cheknpwd(){
      var flag=false;
  var opwd=document.all("npwd");
  var div=document.all("d7");
  if(opwd.value.length<=0){
    div.innerHTML="<font color='red'>新密码不能为空</font>";
    div.style.display="inline";
  
  }
  else{
  if(opwd.value.length<=6){
    div.innerHTML="<font color='red'>新密码必须大于六位</font>";
    div.style.display="inline";
  
  }
  else{
   
    if(cheknpwdyz()){
  flag=true;
   div.style.display="none";
   }
   else{
    div.innerHTML="<font color='red'>两次输入的密码不一致</font>";
    div.style.display="inline";
   }
  }
  }
  return flag;
  
  }
  function cheknpwd1(){
   var flag=false;
  var opwd=document.all("npwd1");
  var div=document.all("d8");
  if(opwd.value.length<=0){
    div.innerHTML="<font color='red'>确认密码不能为空</font>";
    div.style.display="inline";
  
  }
  else{
  if(opwd.value.length<=6){
    div.innerHTML="<font color='red'>确认密码必须大于六位</font>";
    div.style.display="inline";
  
  }
  else{
   
    if(cheknpwdyz()){
  flag=true;
   div.style.display="none";
   }
   else{
    div.innerHTML="<font color='red'>两次输入的密码不一致</font>";
    div.style.display="inline";
   }
  }
  }
  return flag;
  
  }
  function cheknpwdyz(){
  var flag=false;
    var npwd= document.all("npwd")
    var npwd1= document.all("npwd1")
    if(npwd.value.length>6&&npwd1.value.length>6){
    if(npwd.value==npwd1.value){
    flag=true;
    }
    }
    else{
    flag=true;
    }
    return flag;
  }
  function cheksub(){
  var flag=false;
  if(chekopwd()&&cheknpwd()&&cheknpwd1()){
  
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
		<div class="wrap clearfix">
			<a href="#" class="logo left" style="margin-top:0px;"><img src="images/logo.png"/></a>
			<div class="nav left dInline" id="headerMenu">
      <a href="CarInfo.action">首页</a>
      <a href="about.jsp">关于亿金</a>
      <a href="CarInfo_showlist.action">我要买车</a>
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
			<form class="clearfix left" action="CarInfo_showlist.action" method="get" >
			
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
		<a href="CarInfo.action">亿金名车广场</a>><a href="MemberCenter_showmenber.action">会员中心</a>><a>账户管理</a>
	</div>
	<div class="mebBox">
		<div class="meb-cont clearfix wrap">
			<div class="meb-nav left dInline">
				<ul class="clearfix">
					<li><a href="MemberCenter_showmenber.action">会员中心</a></li>
                    <li ><a href="MemberCenter_showmenberOrder.action">我的需求</a></li>
                    <li><a href="MemberCenter_showmenberYbcar.action">我的车</a></li>
                    <li class="on"><a href="admin/memberMyAccount.jsp">账户管理</a></li>				
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
           	<c:if test="${empty updatemessage }">
				<div class="mr-detail">
					<div class="mr-tab clearfix">
						<a class="on">个人资料管理 </a>
                        <a>修改密码</a>
					</div>
					<div class="me-box me-box1">
				
						<div class="me-dl" style="display:block;">
							<div class="me-one">
								<div class="accForm">
									<form action="UserInfo_update.action"   method="post" onsubmit="return cheksubmit()">
										 <input type="hidden" name="op" value="update">
										<div class="afl clearfix">
											<label class="left">
												手机号码
											</label>
											<div class="af-r left dInline">
												<input type="text" class="ar-txt" name="mobile" placeholder="请输入手机号码" value="${userinfo.uTel }" disabled="disabled" />
											</div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												姓名
											</label>
											<div class="af-r left dInline">
												<input type="text" class="ar-txt" name="realname" id="realname" placeholder="请输入您的姓名" value="${userinfo.uName }" onblur="chekName()"/>
											<div style="display: none;" id="d1"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												性别
											</label>
											<div class="af-r left dInline">
											<c:if test="${userinfo.uSex=='男' }">
											<span>
													<input type="radio" name="gender" value="男" checked=""> 男
												</span>
												<span>
													<input type="radio" name="gender"  value="女"> 女
												</span>		
											</c:if>
											<c:if test="${userinfo.uSex=='女' }">
											<span>
													<input type="radio" name="gender" value="男" checked=""> 男
												</span>
												<span>
													<input type="radio" name="gender" checked=""  value="女"> 女
												</span>		
											</c:if>
																					</div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												身份证
											</label>
											<div class="af-r left dInline">
											<c:if test="${userinfo.uCard!=0 }">
										<input type="text" class="ar-txt" name="card" id="card" placeholder="请输入您的身份证" value="${userinfo.uCard }" onblur="chekCard()"/>
											</c:if>
											<c:if test="${userinfo.uCard==0 }">
										<input type="text" class="ar-txt" name="card" id="card" placeholder="请输入您的身份证" value="" onblur="chekCard()"/>
											</c:if>
											<div style="display: none;" id="d2"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												地址
											</label>
											<div class="af-r left dInline">
												<input type="text" class="ar-txt" name="adr" id="adr" placeholder="请输入您的地址" value="${userinfo.uAdr }" />
											<div style="display: none;" id="d3"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												QQ
											</label>
											<div class="af-r left dInline">
											 <c:if test="${userinfo.uQq!=0 }">
											<input type="text" class="ar-txt" name="qq" id="qq" placeholder="请输入您的QQ"  value="${userinfo.uQq }" onblur="chekqq()" />
											 </c:if>
											  <c:if test="${userinfo.uQq==0 }">
											<input type="text" class="ar-txt" name="qq" id="qq" placeholder="请输入您的QQ"  value="" onblur="chekqq()" />
											 </c:if>
										<div style="display: none;" id="d4"></div>	</div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												邮箱
											</label>
											<div class="af-r left dInline">
												<input type="text" class="ar-txt" name="email" id="email" placeholder="请输入您的邮箱" value="${userinfo.uEmail}" onblur="chekemail()" />
										<div style="display: none;" id="d5"></div>	</div>
										</div>
										<div class="afl clearfix">
											<label class="left">
											</label>
											<div class="af-r left dInline">
												<input type="submit" value="提 交" class="ar-btn">
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
                        <div class="me-dl" >
							<div class="me-one">
								<div class="accForm">
									<form action="UserInfo_updatePwd.action"  name="editP" method="post" onsubmit="return cheksub();">
										 <input type="hidden" name="op" value="updatepwd">
										<div class="afl clearfix">
											<label class="left">
												当前密码
											</label>
											<div class="af-r left dInline">
												<input type="password" class="ar-txt" name="opwd" id="opwd" placeholder="请输入当前密码" value="" onblur="chekopwd()"/>
											<div style="display: none;" id="d6"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												新密码
											</label>
											<div class="af-r left dInline">
												<input type="password" class="ar-txt" name="npwd" id="npwd" placeholder="请输入新密码" value="" onblur="cheknpwd()" />
											<div style="display: none;" id="d7"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												确认新密码
											</label>
											<div class="af-r left dInline">
												<input type="password" class="ar-txt" name="npwd1" id="npwd1" placeholder="请确认输入的新密码" value="" onblur="cheknpwd1()" />
											<div style="display: none;" id="d8"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
											</label>
											<div class="af-r left dInline">
												<input type="submit" value="提 交" class="ar-btn">
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						
						
					</div>
				</div>
				</c:if>
					  	<c:if test="${!empty updatemessage }">
				<div class="mr-detail">
					<div class="mr-tab clearfix">
						<a >个人资料管理 </a>
                        <a class="on">修改密码</a>
					</div>
					<div class="me-box me-box1">
				
						<div class="me-dl" >
							<div class="me-one">
								<div class="accForm">
									<form action="UserInfo_update.action"   method="post" onsubmit="return cheksubmit()">
										 <input type="hidden" name="op" value="update">
										<div class="afl clearfix">
											<label class="left">
												手机号码
											</label>
											<div class="af-r left dInline">
												<input type="text" class="ar-txt" name="mobile" placeholder="请输入手机号码" value="15138911875" disabled="disabled" />
											</div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												姓名
											</label>
											<div class="af-r left dInline">
												<input type="text" class="ar-txt" name="realname" id="realname" placeholder="请输入您的姓名" value="${userinfo.uName }" onblur="chekName()"/>
											<div style="display: none;" id="d1"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												性别
											</label>
											<div class="af-r left dInline">
											<c:if test="${userinfo.uSex=='男' }">
											<span>
													<input type="radio" name="gender" value="男" checked=""> 男
												</span>
												<span>
													<input type="radio" name="gender"  value="女"> 女
												</span>		
											</c:if>
											<c:if test="${userinfo.uSex=='女' }">
											<span>
													<input type="radio" name="gender" value="男" checked=""> 男
												</span>
												<span>
													<input type="radio" name="gender" checked=""  value="女"> 女
												</span>		
											</c:if>
																					</div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												身份证
											</label>
											<div class="af-r left dInline">
											<c:if test="${userinfo.uCard!=0 }">
										<input type="text" class="ar-txt" name="card" id="card" placeholder="请输入您的身份证" value="${userinfo.uCard }" onblur="chekCard()"/>
											</c:if>
											<c:if test="${userinfo.uCard==0 }">
										<input type="text" class="ar-txt" name="card" id="card" placeholder="请输入您的身份证" value="" onblur="chekCard()"/>
											</c:if>
											<div style="display: none;" id="d2"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												地址
											</label>
											<div class="af-r left dInline">
												<input type="text" class="ar-txt" name="adr" id="adr" placeholder="请输入您的地址" value="${userinfo.uAdr }" />
											<div style="display: none;" id="d3"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												QQ
											</label>
											<div class="af-r left dInline">
											 <c:if test="${userinfo.uQq!=0 }">
											<input type="text" class="ar-txt" name="qq" id="qq" placeholder="请输入您的QQ"  value="${userinfo.uQq }" onblur="chekqq()" />
											 </c:if>
											  <c:if test="${userinfo.uQq==0 }">
											<input type="text" class="ar-txt" name="qq" id="qq" placeholder="请输入您的QQ"  value="" onblur="chekqq()" />
											 </c:if>
										<div style="display: none;" id="d4"></div>	</div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												邮箱
											</label>
											<div class="af-r left dInline">
												<input type="text" class="ar-txt" name="email" id="email" placeholder="请输入您的邮箱" value="${userinfo.uEmail}" onblur="chekemail()" />
										<div style="display: none;" id="d5"></div>	</div>
										</div>
										<div class="afl clearfix">
											<label class="left">
											</label>
											<div class="af-r left dInline">
												<input type="submit" value="提 交" class="ar-btn">
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
                        <div class="me-dl"  style="display:block;">
							<div class="me-one">
								<div class="accForm">
									<form action="UserInfo_updatePwd.action"   method="post" onsubmit="return cheksub();">
										 <input type="hidden" name="op" value="updatepwd">
										<div class="afl clearfix">
											<label class="left">
												当前密码
											</label>
											<div class="af-r left dInline">
												<input type="password" class="ar-txt" name="opwd" id="opwd" placeholder="请输入当前密码" value="" onblur="chekopwd()"/>
											<div style="display: inline;" id="d6"><font color="red">${updatemessage}</font></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												新密码
											</label>
											<div class="af-r left dInline">
												<input type="password" class="ar-txt" name="npwd" id="npwd" placeholder="请输入新密码" value="" onblur="cheknpwd()" />
											<div style="display: none;" id="d7"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
												确认新密码
											</label>
											<div class="af-r left dInline">
												<input type="password" class="ar-txt" name="npwd1" id="npwd1" placeholder="请确认输入的新密码" value="" onblur="cheknpwd1()" />
											<div style="display: none;" id="d8"></div></div>
										</div>
										<div class="afl clearfix">
											<label class="left">
											</label>
											<div class="af-r left dInline">
												<input type="submit" value="提 交" class="ar-btn">
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						
						
					</div>
				</div>
				</c:if>
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
<script type="text/javascript">
$(function(){
	$('.mr-tab a').each(function(index){
		$(this).click(function(){
			$(this).addClass('on').siblings().removeClass('on');
			$('.me-dl').eq(index).show().siblings().hide();
		})
	});
})
</script>
<script>
function checkpost(){
	var realname=editM.realname.value;//手机号
	var gender=editM.gender.value;//验证码
	var email=editM.email.value;//姓名
	var Yemail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; //邮箱验证
	var url='/Member/manage/channel/7/list/15';
	if(realname.length>10){
		alert("姓名要不得大于10个字符");
		editM.realname.focus();
		return false;
	}
	if(!Yemail.exec(email)&&email!=''){
		alert("邮箱格式不正确");
		editM.email.focus();
		return false;
	}
	$.ajax({
		 type: "POST",
		 url: url,
		 data: {realname:realname, gender:gender,email:email},
		 dataType: "json",
		 success: function(data){
			 alert(data.msg);
		}
	 });
	 return false;
}
function checkPasspost(){
	var password=editP.password.value;//性别
	var password1=editP.password1.value;//密码
	var password2=editP.password2.value;//密码
	var Ypass=/\S{6,}/;//密码验证
	var url='/Member/manage/channel/7/list/15';
	if(!password1){
		alert("请输入新密码");
		editP.password1.focus();
		return false;
	}
	if(!password2){
		alert("请重复输入新密码");
		editP.password2.focus();
		return false;
	}
	if(password1!=password2){
		alert("两次新密码输入不同");
		editP.password1.focus();
		return false;
	}
	if(!Ypass.exec(password1)){
		alert("密码格式不正确，必须以字母开头的6-16 字母，数字");
		editP.password1.focus();
		return false;
	}
	$.ajax({
		 type: "POST",
		 url: url,
		 data: {password:password,password1:password1},
		 dataType: "json",
		 success: function(data){
			 alert(data.msg);
		}
	 });
	 return false;
}
</script>

  </body>
</html>
