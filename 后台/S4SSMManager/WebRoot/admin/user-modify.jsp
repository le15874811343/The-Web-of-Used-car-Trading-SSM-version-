<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/showtime.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/checkuser.js"></script>
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

</head>

<body onload="time()">
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="/S4SSM/CarInfo.action">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li ><a href="/S4SSMManager/admin/index.jsp">首页</a></li>
			<li   class="current"><a href="/S4SSMManager/Manager_showalluser.action">用户</a></li>
			<li  ><a href="/S4SSMManager/MgCar_showlist.action">商品</a></li>
			<li  ><a href="/S4SSMManager/Mgord_showallord.action">订单</a></li>
			<li   ><a href="/S4SSMManager/Trends_showcom.action">留言</a></li>
			<li ><a href="/S4SSMManager/Trends_showalltrends.action">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
管理员<a href="/S4SSMManager/MgUsIn_showdeauser.action?uid=${userinfo.uId }">${userinfo.uName }</a>您好，今天是<input type="text" name='time' id="time" style="border: 0px;background:#fc7e31" readonly size='16' />，欢迎回到管理后台。	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="/S4SSMManager/admin/user-add.jsp">新增</a></em><a href="/S4SSMManager/Manager_showalluser.action">所有用户</a></dd>
			    <dd><em><a href="/S4SSMManager/admin/user-add.jsp">新增</a></em><a href="/S4SSMManager/Manager_showuser.action">普通用户</a></dd>
				<dd><em><a href="/S4SSMManager/admin/user-add.jsp">新增</a></em><a href="/S4SSMManager/Manager_showadmin.action">管理员</a></dd>
				<dt>汽车信息</dt>
				<dd><em><a href="/S4SSMManager/admin/brand-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showbrand.action">品牌管理</a></dd>
				<dd><em><a href="/S4SSMManager/Model_addseries.action">新增</a></em><a href="/S4SSMManager/Model_showseries.action">车系管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/age-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showage.action">车龄管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/price-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showprice.action">车价管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/distance-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showdistance.action">行驶距离管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/emsi-add.jsp	">新增</a></em><a href="/S4SSMManager/Model_showemsi.action">排放标准管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/type-add.jsp">新增</a></em><a href="/S4SSMManager/Model_showtype.action">车型管理</a></dd>				
				<dt>商品管理</dt>
				<dd><a href="/S4SSMManager/MgCar_showlist.action">所有商品</a></dd>
				<dd><a href="/S4SSMManager/MgCar_showzs.action">在售商品</a></dd>
				<dd><a href="/S4SSMManager/MgCar_showsh.action">审核中的商品</a></dd>
				<dd><a href="/S4SSMManager/MgCar_showxj.action">下架的商品</a></dd>
				<dd><a href="/S4SSMManager/MgCar_showwtg.action">审核未通过的商品</a></dd>
				<dt>订单管理</dt>
				<dd><a href="/S4SSMManager/Mgord_showallord.action">所有订单</a></dd>
				<dd><a href="/S4SSMManager/Mgord_showzzjy.action">中止交易申请</a></dd>
				<dd><a href="/S4SSMManager/Mgord_showjyz.action">正在交易</a></dd>
				<dd><a href="/S4SSMManager/Mgord_showjywc.action">出售完成</a></dd>
				<dt>留言管理</dt>
				<dd><a href="/S4SSMManager/Trends_showcom.action">留言管理</a></dd>
				<dt>私人定制</dt>
				<dd><a href="/S4SSMManager/Manager_showsrdz.action">私人定制</a></dd>
				<dd><a href="/S4SSMManager/Manager_showclzsrdz.action">处理中的私人定制</a></dd>
				<dd><a href="/S4SSMManager/Manager_showyclsrdz.action">已处理的私人定制</a></dd>
				<dt>企业动态消息管理</dt>
                <dd><em><a href="/S4SSMManager/admin/alltrend-add.jsp">新增</a></em><a href="/S4SSMManager/Trends_showalltrends.action">所有动态</a></dd>
				<dd><em><a href="/S4SSMManager/admin/allnews-add.jsp">新增</a></em><a href="/S4SSMManager/Trends_shownewslist.action">新闻管理</a></dd>
				<dd><em><a href="/S4SSMManager/admin/active-add.jsp">新增</a></em><a href="/S4SSMManager/Trends_showactive.action">活动管理</a></dd>
			    <dt>业务分析</dt>
			    <dd><a href="/S4SSMManager/admin/chaxunche.jsp">卖出车情况</a></dd>
			    <dd><a href="/S4SSMManager/admin/pricechaxun.jsp">交易额情况</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form action="MgUsIn_update.action"  method="post"    onsubmit="return cheksubmit()">
			<input type="hidden" name="op" value="update" />
				<table class="form">
				<c:if test="${!empty getuser}">
				<input type="hidden" name="getuser" id="getuser" value="1"></input>
				</c:if>
					<tr>
						<td class="field">手机号码(登录账号)：</td>
						<td><input type="text" class="text" name="mobile" id="mobile" value="${getuser.uTel }" disabled="disabled" onblur="checkphone()"/>
						<div  id="phonediv" style="display:inline;" ><font color="red">${mesg }</font></div>
						</td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text" class="text" name="realname" id="realname" value="${getuser.uName }" onblur="chekName()" size="5"/>
						<div  id="d1" style="display:none"></div>
						</td>
				
					</tr>
					<tr>
						<td class="field">性别：</td>
						<c:if test="${getuser.uSex=='男' }">
						<td><input type="radio" name="gender" id="gender" checked="checked" value="男" />男
						<input type="radio" name="gender" id="gender" value="女" />女</td>
						</c:if>
						<c:if test="${getuser.uSex=='女' }">
						<td><input type="radio" name="gender" id="gender"  value="男"  />男
						<input type="radio" name="gender" id="gender" value="女" checked="checked" />女</td>
						</c:if>
						<c:if test="${getuser.uSex!='男' and getuser.uSex!='女'}">
						<td><input type="radio" name="gender" id="gender"  value="男"  checked="checked"/>男
						<input type="radio" name="gender" id="gender" value="女" />女</td>
						
						</c:if>
					</tr>
					
					<tr>
						<td class="field">QQ：</td>
						<c:if test="${ getuser.uQq==0}">
						<td><input type="text" class="text" name="qq" id="qq" onblur="chekqq()"/>
						<div  id="d4" style="display:none"></div></td>
						</c:if>
							<c:if test="${ getuser.uQq>0}">
						<td><input type="text" class="text" name="qq" id="qq" value="${getuser.uQq }" onblur="chekqq()"/><div  id="d4" style="display:none"></div></td>
						
						</c:if>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="email" id="email" value="${getuser.uEmail }" onblur="chekemail()"/>
						<div  id="d5" style="display:none" ></div>
						</td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<c:if test="${ getuser.uCard==0}">
						<td><input type="text" class="text" name="card" id="card" onblur="chekCard()" />
						<div  id="d2" style="display:none"></div>
						</td>
						</c:if>
							<c:if test="${ getuser.uCard>0}">
						<td><input type="text" class="text" name="card" id="card" value="${getuser.uCard }" onblur="chekCard()"/>
							<div  id="d2" style="display:none"></div>
						</td>
						</c:if>
							
						
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address" id="address" value="${getuser.uAdr }" onblur="checkadd()"/>
						<div  id="adiv" style="display:none"></div>
						</td>
					</tr>
					<tr>
						<td><input type="hidden" id="uid" name="uid" value="${getuser.uId }"/></td>
						<td><label class="ui-blue"><input type="submit"  value="更新"  onclick="sendRequest()" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010  All Rights Reserved. 京ICP证1000001号</div>
</body>
</html>
