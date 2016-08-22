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
    
    <title>郑州二手车_价格_图片</title>
    
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
<link rel="stylesheet" type="text/css" href="css/my.css">
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

function sendRequest(sel){
  var brand=sel.value;
  var sel2=document.all("sel2");
  if(sel.value!="选择品牌"){
  var url = "Model.action?brand="+brand+"&nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getResult; 
     xmlhttp.send(null); 
  }
  }
  else{
   sel2.length=0;
    sel2.options.add(new Option("请先选择品牌","请先选择品牌"))
  }
} 

function getResult(){
  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){ //完成请求正确返回
     var data=xmlhttp.responseText;
     var json=eval("("+data+")");
     var sel2=document.all("sel2");
     sel2.length=0;
     sel2.options.add(new Option("选择车系","选择车系"))
     for(var i=0;i<json.length;i++){
      sel2.options.add(new Option(json[i].mName,json[i].mId));
     }
  }
}


</script>
<script type="text/javascript">
 $(document).ready(
 function(){
 $("#sel2").change(
 function(){
  var brand=$("#sel1 :selected").text();
  var ser=$("#sel2 :selected").text();
  var tname=$("#tname").val();
  var distance=$("#distance").val();
  var age=$("#age").val();
  var price=$("#price").val();
  var emsi=$("#emsi").val()
  var url="CarInfo_showList.action?bname="+brand+"&cser="+ser+"&tname="+tname+"&distance="+distance+"&price="+price+"&age="+age+"&emsi="+emsi+"";
    window.location.href=url;
 }
 )
 }
 )
</script>
<script type="text/javascript">
 function chek1 (str){
 var text=document.all(str);
 var flag=false;
 if(text.value.length>0){
 if(!isNaN(text.value)){
   if(text.value>0){
   flag=true;
   }
   else{
   alert("请输入正数");
   }
 }
 else{
 alert("请输入数字")
 }
 }
 else{
 flag=true;
 }
 return flag;
 }
 

 function chekSubMi(str,str1,str2,str3){
 var flag=false;
  
 var text=document.all(str);
 

 var text1=document.all(str1);
 var where=document.all(str3);
  if(chek1 (str)&&chek1(str1)){
    
     if(text1.value.length>0&&text.value.length>0){
     if(text1.value>text.value){
      where.value=text.value+"-"+text1.value+str2;
     flag=true;
    
     }
     else {
     alert("上限值小于等于下限值！请重新输入");
   
     flag=false;
    
     }
     }
     else if(text1.value.length==0&&text.value.length>0){
      
       where.value=text.value+str2+"以上";
     
       
       flag=true;
     }
     else if(text1.value.length>0&&text.value.length==0){
     where.value=text1.value+str2+"以内";
    
       flag=true;
     }
     else{
    
     flag=false;
      alert("最大值或最小值至少输入一项");
    
     }
    
  }
   
   return flag;
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

function sendUpdateYzm(){
 var url = "<%=basePath%>UserInfo_updateYzm.action?nocahe="+new Date().getTime()+"";
  CreateXMLHttp();
  
  if(xmlhttp){
     xmlhttp.open("GET",url, true); 
     xmlhttp.onreadystatechange = getResul; 
     xmlhttp.send(null); 
  } 
} 

  
function getResul(){
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

function sendSc(c_id,c_uid,nop){

 var url = "<%=basePath%>MemberCenter_"+nop+".action?c_id="+c_id+"&c_uid="+c_uid+"&nocahe="+new Date().getTime()+"";
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
  var sel2=document.all("sel8");
  var div=document.all("scx");
  var div2=document.all("cx");
  var selq=document.all("selq");
  if(sel.value!="选择品牌"){
  var url = "<%=basePath%>Model.action?brand="+brand+"&op=bindModel&nocahe="+new Date().getTime()+"";
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
     var sel2=document.all("sel8");
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
     flag=false;
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
     flag=false;
     div.style.display="inline";
     }
    
  }
   
   return flag;
 }
 function chekdayy(){
  var flag=false;
  
  var sj= document.all("buytimett");

  var date=new Date();
  var div=document.all("timedivt");
  
  if(sj.value.length==0){
    div.innerHTML="<font color='red'>请选择购买时间</font>";
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
 if(sendSpp(str)&&(chekcx(str1,str2,str3,str4,str5)||cheksrcx(str6,str7,str8))&&(chekcx(str9,str10,str11,str12,str13)||chekSubMit(str14,str15,str16,str17,str18))&&chekSubMit(str19,str20,str21,str22,str23)&&chekdayy()){
   flag=true;
 }
 
  return flag;
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
if(cheksuub("sel7","sel8","cx","scx","ccx","srcx","srcx","scx","ccx","years","cxi","scxi","ccxi","srcxi","dage","hage","年","ccxi","chekagee","ddprice","hhprice","万","ccprice","chekpricee")){
 var sel1=$("#sel7 :selected").text();
 
 var ccx=document.all("ccx").value;
 
 var ccxi=document.all("ccxi").value;
 
 var cprice=document.all("ccprice").value;

 var buytime=document.all("buytimett").value;
 
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
     
      <a  href="CarInfo.action">首页</a>
      <a href="about.jsp">关于亿金</a>
      <a class="on" href="CarInfo_op=showList.action">我要买车</a>
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
   
      </a>|
      <a  onclick="document.getElementById('zhuxiaoform').submit();" >注销</a>|&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/tel.png"/>			
      <form action="UserInfo_zhuXiao.action" method="get" id="zhuxiaoform">
      <table>
      <tr><td>            
        <input type="hidden" name="tname"  value="${tname}">
             <input type="hidden" name="bname"  value="${bname}">
             <input type="hidden" name="cser"  value="${cser}">
             <input type="hidden" name="price"  value="${price}">
             <input type="hidden" name="distance"  value="${distance}">
             <input type="hidden" name="age"  value="${age}">
             <input type="hidden" name="emsi"  value="${emsi}">
            
             <input type="hidden" name="url" value="forward:/CarInfo_showList.action">
      </td></tr>
      </table>
      </form>
      </c:if>
      </span> </div>
  </div>
  <div class="head-search">
    <div class="wrap clearfix">
      <div class="yjxj clearfix left" action="/index/keyword/" method="post" enctype="multipart/form-data">
         <form action="CarInfo.action" method="get">
        <input type="hidden" name="op" value="showlist">
        <input type="text" name="bname" placeholder="请输入您想要的品牌搜索" class="left" />
        <input type="submit" value="搜 索" class="right" />
        </form>
      </div>
      <div class="hotWords left dInline"> 热门品牌：
       <c:if test="${!empty showcar }">
            <c:forEach var="showcar" items="${showcar }">
                        <a href="CarInfo_showList.action?&bname=${ showcar.value.cBrand}&cser=${showcar.value.cSeries}" >${ showcar.value.cBrand}${showcar.value.cSeries}</a>
            
            </c:forEach>
            </c:if>
  
      </div>
    </div>
  </div>
</div>
<style>
.s-form { margin-top:5px;}
.toselect{background-color: rgb(64, 100, 156); color:#FFF}
</style>
<div id="about">
  <div class="mTags" style="margin-bottom:20px">
    <div class="wrap"> <a href="#">亿金名车广场</a><a >我要买车</a> </div>
  </div>
  <div class="wrap text-left">
    <div class="carfliter-box">
      <div class="carfl-tit clearfix">
        <div class="result-box left dInline" style="height:auto;"> <span class="left">您的当前选择：</span>
         
         
          <c:if test="${!empty bname }">
                    <div class="s-form left clearfix" style="white-space:normal; width:auto">	<p class="left" style="width:auto;">&nbsp;${bname }<a href="CarInfo_showList.action?tname=${tname}&cser=${cser}&price=${price}&distance=${distance}&age=${age}&emsi=${emsi}"><span class="close right"></span></a>	</p></div>   
          </c:if>
           <c:if test="${!empty tname }">
                    <div class="s-form left clearfix" style="white-space:normal; width:auto">	<p class="left" style="width:auto;">&nbsp;${tname }<a href="CarInfo_showList.action?bname=${bname}&cser=${cser}&price=${price}&distance=${distance}&age=${age}&emsi=${emsi}"><span class="close right"></span></a>	</p></div>   
                     </c:if>
                     <c:if test="${!empty cser }">
                    <div class="s-form left clearfix" style="white-space:normal; width:auto">	<p class="left" style="width:auto;">&nbsp;${cser }<a href="CarInfo_showList.action?tname=${tname}&bname=${bname}&price=${price}&distance=${distance}&age=${age}&emsi=${emsi}"><span class="close right"></span></a>	</p></div>   
                     </c:if>
                     <c:if test="${!empty distance }">
                    <div class="s-form left clearfix" style="white-space:normal; width:auto">	<p class="left" style="width:auto;">&nbsp;${distance }<a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price}&age=${age}&emsi=${emsi}"><span class="close right"></span></a>	</p></div>   
                     </c:if>
                     <c:if test="${!empty price }">
                    <div class="s-form left clearfix" style="white-space:normal; width:auto">	<p class="left" style="width:auto;">&nbsp;${price }<a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&distance=${distance}&age=${age}&emsi=${emsi}"><span class="close right"></span></a>	</p></div>   
                     </c:if>
                     <c:if test="${!empty age }">
                    <div class="s-form left clearfix" style="white-space:normal; width:auto">	<p class="left" style="width:auto;">&nbsp;${age }<a href="CarInfo_showList.action?tname=${tname}&bname=${bname}&cser=${cser}&price=${price}&distance=${distance}&emsi=${emsi}"><span class="close right"></span></a>	</p></div>   
                     </c:if>
                     <c:if test="${!empty emsi }">
                    <div class="s-form left clearfix" style="white-space:normal; width:auto">	<p class="left" style="width:auto;">&nbsp;${emsi }<a href="CarInfo_showList.action?tname=${tname}&bname=${bname}&cser=${cser}&price=${price}&distance=${distance}&age=${age}"><span class="close right"></span></a>	</p></div>   
                     </c:if>
                     
        
        </div>
        
        <input type="hidden" id="tname" value=${tname }>
         <input type="hidden" id="emsi" value=${emsi }>
        <input type="hidden" id="distance" value=${distance }>
        <input type="hidden" id="price" value=${price }>
        <input type="hidden" id="age" value=${age }>
         <c:if test="${!empty userinfo }"><a href="CarInfo_showsrdz.action" class="dBtn right">在线私人订制</a></c:if>
       <c:if test="${empty userinfo }"><a onclick="sendLogin()"  class="dBtn right">在线私人订制</a></c:if>
        </div>
      <div class="condition">
        <ul>
          <li class=""> <span class="c-name left">品牌：</span>
            <div class="spec-moudle left dInline"> 
            <c:if test="${!empty showBrandMap }">
            <c:forEach var="showbrand" items="${showBrandMap }">
                        <a href="CarInfo_showList.action?tname=${tname}&bname=${showbrand.value.bName }&price=${price}&distance=${distance}&age=${age}&emsi=${emsi}" ><img src="${showbrand.value.bImg }" style="height:32px;"/></a>
            
            </c:forEach>
            </c:if>
      
            
              <div class="pro_smore">
                <div class="clearfix ps-a">
                  <select class="left" name="sel1"  id="sel1"  placeholder="所属品牌" onchange="sendRequest(this)">
                    <option value="选择品牌"> 选择品牌</option>
                    <c:if test="${!empty allbrand }">
                    <c:forEach var="allbrand" items="${allbrand }">
                    <option value=${allbrand.value.bId }>${allbrand.value.bName }</option>
                    </c:forEach>
                    </c:if>
                    
                  </select>
                  <select class="left" name="sel2"  id="sel2" placeholder="所属车型">
                    <option value=""> 请先选择品牌</option>
                  </select>
                </div>
              </div>
            </div>
          </li>
          <li class=""> <span class="c-name left">价格：</span>
            <div class="spec-moudle left dInline"> 
            <c:if test="${!empty priceMap }">
            <c:forEach var="priceMap" items="${priceMap }">
             <a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${priceMap.value.pName}&distance=${distance}&age=${age}&emsi=${emsi}" >${priceMap.value.pName }</a>
            </c:forEach>
            </c:if>
              <div class="pro_smore">
                <div class="clearfix ps-b">
                <form action="CarInfo_showList.action" method="get" onsubmit="return chekSubMi('minPrice','maxPrice','万','_price')">
                  <table>
                    <tr>
                      <td><input type="text" class="sTxt" id="minPrice" value="" /></td>
                      <td>-</td>
                      <td><input type="text" class="sTxt" id="maxPrice" value="" /></td>
                      <td>万元</td>
                      <td><input type="submit" value="确定" class="sBtn" id="dd" style="line-height:10px" /></td>
                    </tr>
                     <tr><td> <input type="hidden" name="distance" value="${distance }" ></td></tr>
                    <tr><td> <input type="hidden" name="tname" value="${tname}" ></td></tr>
                    <tr><td> <input type="hidden" name="bname" value="${bname }" ></td></tr>
                    <tr><td> <input type="hidden" name="cser" value="${cser}" ></td></tr>
                    <tr><td> <input type="hidden" name="price" id="_price" ></td></tr>
                    <tr><td> <input type="hidden" name="age" value="${age}" ></td></tr>
                    <tr><td><input type="hidden" name="emsi" value="${emsi }"></td></tr>
                   
                  </table>
                  </form>
                </div>
              </div>
            </div>
          </li>
          <li class="" style="height:48px;"> <span class="c-name left">车型：</span>
            <div class="spec-moudle left dInline" style="height:auto;">
            <c:if test="${!empty showType }">
            <c:forEach var="showType" items="${showType }">
             <a href="CarInfo_showList.action?tname=${showType.value.tName}&bname=${bname }&cser=${cser}&price=${price}&distance=${distance}&age=${age}&emsi=${emsi}"  ><img src="${showType.value.tClass }" height="30"/><br/>
            ${showType.value.tName }</a>
            </c:forEach>
            </c:if>
     </div>
          </li>
          <li class=""> <span class="c-name left">车龄：</span>
            <div class="spec-moudle left dInline">
             <c:if test="${!empty ageMap }">
             <c:forEach var="ageMap" items="${ageMap }">
             <a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price}&distance=${distance}&age=${ageMap.value.aName}&emsi=${emsi}"> ${ageMap.value.aName }</a>
             </c:forEach>
             </c:if> 
              <div class="pro_smore">
                <div class="clearfix ps-b">
                 <form action="CarInfo_showList.action" method="get" onsubmit="return chekSubMi('minAge','maxAge','年','_age')">
                  <table>
                    <tr>
                      <td><input type="text" class="sTxt" id="minAge" value="" /></td>
                      <td>-</td>
                      <td><input type="text" class="sTxt" id="maxAge" value="" /></td>
                      <td>年</td>
                      <td><input type="submit" value="确定" class="sBtn" id="" style="line-height:10px" /></td>
                    </tr>
                     <tr><td> <input type="hidden" name="distance" value="${distance }" ></td></tr>
                    <tr><td> <input type="hidden" name="tname" value="${tname}" ></td></tr>
                    <tr><td> <input type="hidden" name="bname" value="${bname }" ></td></tr>
                    <tr><td> <input type="hidden" name="cser" value="${cser}" ></td></tr>
                    <tr><td> <input type="hidden" name="price" value="${price }" ></td></tr>
                    <tr><td> <input type="hidden" name="age" id="_age" ></td></tr>
                   <tr><td><input type="hidden" name="emsi" value="${emsi }"></td></tr>
                   
                  </table>
                  </form>
                </div>
              </div>
            </div>
          </li>
          <li class=""> <span class="c-name left">里程：</span>
            <div class="spec-moudle left dInline">
            <c:if test="${!empty distanceMap }">
            <c:forEach var="distanceMap" items="${distanceMap }">
            <a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distanceMap.value.dName }&age=${age}&emsi=${emsi}">${distanceMap.value.dName }</a>
            </c:forEach>
            </c:if>
              <div class="pro_smore">
                <div class="clearfix ps-b">
                <form action="CarInfo_showList.action"  method="get"   onsubmit="chekSubMi('minDisTance','maxDisTance','万公里','_distance')">
                  <table>
                    <tr>
                      <td><input type="text" class="sTxt" id="minDisTance" value="" /></td>
                      <td>-</td>
                      <td><input type="text" class="sTxt" id="maxDisTance" value="" /></td>
                      <td>万公里</td>
                      <td><input type="submit" value="确定" class="sBtn" id="" style="line-height:10px" /></td>
                    </tr>
                    <tr><td> <input type="hidden" name="distance" id="_distance" ></td></tr>
                    <tr><td> <input type="hidden" name="tname" value="${tname}" ></td></tr>
                    <tr><td> <input type="hidden" name="bname" value="${bname }" ></td></tr>
                    <tr><td> <input type="hidden" name="cser" value="${cser}" ></td></tr>
                    <tr><td> <input type="hidden" name="price" value="${price}" ></td></tr>
                    <tr><td> <input type="hidden" name="age" value="${age}" ></td></tr>
                    <tr><td><input type="hidden" name="emsi" value="${emsi }"></td></tr>
                   
                  </table>
                  </form>
                </div>
              </div>
            </div>
          </li>
          <li class=""> <span class="c-name left">排放标准：</span>
            <div class="spec-moudle left dInline">
            <c:if test="${!empty emisMap }">
            <c:forEach var="emisMap" items="${emisMap }">
             <a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age}&emsi=${emisMap.value.eName}" id="1" >${emisMap.value.eName }</a>
            </c:forEach>
            </c:if>
            
             </div>
          </li>  
        </ul>
      </div>
    </div>
  </div>
  <div class="aWrap clearfix wrap">
    <div class="left dInline aLeft">
      <div class="carSou">
        <div class="cs-tit">
          <div class="clearfix">
            <div class="ctLeft left dInline">
              <div class="ct-a left dInline"> <a class="on" href="#" ><i>全部</i></a>  </div>
              <div class="cs_sub"> 排序： <a class="cs-a1" href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age}&emsi=${emsi}">默认<img src="images/down.gif"/></a> <a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=c_count">点击量<img src="images/down.gif"/></a> <a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=c_sccount">收藏量<img src="images/down.gif"/></a> <a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=c_price">价格<img src="images/up.gif"/></a> <a href="CarInfo_showList.action?tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=c_distance">里程<img src="images/up.gif"/></a> </div>
            </div>
            <div class="right cpages"> <c:if test="${curPage > 1}">
		 		<a href="CarInfo_showList.action?jumpPage=${curPage - 1}&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">&lt;</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		&lt;
		 		</c:if> ${curPage}/${maxPage} <c:if test="${curPage < maxPage}">
					<a href="CarInfo_showList.action?jumpPage=${curPage + 1}&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">&gt;</a>
		 		
				</c:if> <c:if test="${curPage >= maxPage}">
					&gt;
		 					 		
		 		</c:if></div>
          </div>
          <div class="cs-tit1"></div>
        </div>
        <div class="cs-list">
          <ul>
          <c:if test="${!empty carMap }">
          <c:forEach var="carMap" items="${carMap }">
           <li class="clearfix" style="position: relative;"> <span class="carImg left dInline">
            <a href="CarInfo_showDetails.action?uid=${carMap.uId }&cid=${carMap.cId }" target="_blank">
              <div class="car_bg"> </div>
              <img src="${carMap.cImg }"  width="300" /></a> </span>
              <div class="carTxt right dInline">
                <h2><a href="CarInfo_showDetails.action?uid=${carMap.uId }&cid=${carMap.cId }" target="_blank">${carMap.cBrand }${carMap.cSeries } ${carMap.cReleaseyear } 款 ${carMap.cVolume }T ${carMap.cGeartype } ${carMap.cCode } ${carMap.cModel }</a></h2>
                <p> <span>上牌时间：${carMap.cLicencetime }</span> <span>行驶里程：${carMap.cDistance }万公里</span> <span>排量：${carMap.cVolume }T</span> <span>排放标准：${carMap.cEmissionstandard }</span> </p>
                <div class="price clearfix" style="margin:8px 0;">
                  <div class="left dInline pNum" style="width:110px;"> <font>一口价</font><br/>
                    <span class="num nBlue">${carMap.cPrice } </span><font> 万元</font> </div>
                  <span class="num1 left" style="height:43px; width:450px;padding-top:10px;"><em>新车价：${carMap.newprice }万元</em><br/>
                  为您节省：${carMap.newprice-carMap.cPrice }万元 
                  <input type="hidden" class="CarValue_1165" value="{img:'/Uploads/PhotoGalley/2016-02-22/56caabd482cc0.JPG-thumb.JPG',id:'1165',price:'22.8',status:'加入对比',title:'奔驰C级 2013 款 1.8T 自动 C260 CGI时尚型',url:'/Cars/index/channel/2/id/1165.html'}" />
                  </span> </div>
                <div class="cs_bt clearfix" style="padding-top:7px;"> 
               <c:if test="${empty userinfo }"> <a  onclick="sendLogin()"  id="Order_1165">立即抢订</a></c:if>
                 <c:if test="${!empty userinfo }"> <a  onclick="sendDg(${carMap.cId },${carMap.uId },'needdg')" id="Order_1165">立即抢订</a></c:if>
                 <a href="CarInfo_showCompare.action?uid=${carMap.uId }&cid=${carMap.cId }"  class="balance_1165">加入对比</a> 
                 <c:if test="${empty userinfo }"> <a onclick="sendLogin()"  id="collection_1165" >收藏</a></c:if>
                  <c:if test="${!empty userinfo }"> <a onclick="sendSc(${carMap.cId },${carMap.uId },'needsc')"  id="collection_1165" >收藏</a></c:if>
                  <span>已有${carMap.cSccount }人关注此车</span> </div>
              </div>
            </li>
          </c:forEach>
          </c:if>
           
            
          </ul>
          <div class="pages"> <c:if test="${curPage > 1}">
					<a href="CarInfo_showList.action?jumpPage=1&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">首页</a>&nbsp;&nbsp;&nbsp;
		 		<a href="CarInfo_showList.action?jumpPage=${curPage - 1}&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">上一页</a>
				</c:if> <c:if test="${curPage <= 1}">
			 		首页&nbsp;&nbsp;&nbsp;上一页
		 		</c:if> &nbsp;&nbsp;&nbsp; <c:if test="${curPage < maxPage}">
					<a href="CarInfo_showList.action?jumpPage=${curPage + 1}&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">下一页</a>
		 			&nbsp;&nbsp;&nbsp;
		 			<a href="CarInfo_showList.action?jumpPage=${maxPage}&tname=${tname}&bname=${bname }&cser=${cser}&price=${price }&distance=${distance}&age=${age }&emsi=${emsi}&order=${order}">尾页</a>
				</c:if> <c:if test="${curPage >= maxPage}">
					下一页
		 			&nbsp;&nbsp;&nbsp;尾页		 		
		 		</c:if>
				&nbsp;&nbsp;总共${maxRowCount}行&nbsp;&nbsp;每页显示${rowsPrePage}行&nbsp;&nbsp;总共${maxPage}页&nbsp;&nbsp;&nbsp;&nbsp;当前为第${curPage}页</div>
        </div>
      </div>
    </div>
    <div class="right dInline aRight"> 
      <!--<div class="pgBox">
				<a class="userImg" href="#">
					<img src="images/user.gif"/>
				</a>
				<h2>资深评估团队<br/>确保车源品质</h2>
				<p>亿金为您车辆提供免费<br/>评估与检查</p>
				<a href="#" class="pgBtn">马上评估</a>
			</div>-->
      <div class="dBox">
        <link rel="stylesheet" type="text/css" href="css/alert.css">
        <style type="text/css">
input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {color: #000;}
input:-moz-placeholder, textarea:-moz-placeholder {color:#000;}
input::-moz-placeholder, textarea::-moz-placeholder {color:#000;}
input:-ms-input-placeholder, textarea:-ms-input-placeholder {color:#000;}
</style>
        <form class="dForm" name="dForm" id="dForm" method="post"  onsubmit="return cheksuub('sel7','sel8','cx','scx','ccx','srcx','srcx','scx','ccx','years','cxi','scxi','ccxi','srcxi','dage','hage','年','ccxi','chekagee','ddprice','hhprice','万','ccprice','chekpricee');">
          <h2>私人订制</h2>
          <p>专业车辆顾问为您服务</p>
            <table>
              <tr>
                <td> 	<select class="select car-select" name="sel7" id="sel7" style="width:100%" onchange="sendSpp('sel7')">
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
                    <select class="select car-select" name="sel8" id="sel8" style="width:100%" onchange="chekcx('sel8','cx','scx','ccx','srcx')">
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
            <div id="cxi" style="display: none">  <input type="text" id="hage" name="dprice" placeholder="最小车龄" value="" class="cInput" onblur="chekSubMit('dage','hage','年','ccxi','chekagee')"/>
                  <input type="text" name="hprice" id="dage" placeholder="最大车龄" value="" class="cInput"  onblur="chekSubMit('dage','hage','年','ccxi','chekagee')" />
              <div id="chekagee" style="display: none"></div>
              </div>
              </td>
              </tr>
              <tr>
                <td><input type="text" name="ddprice" id="ddprice" placeholder="最少预算" value="" class="cInput"  onblur="chekSubMit('ddprice','hhprice','万','ccprice','chekpricee')"/>
                  <input type="text" name="hhprice" id="hhprice"  placeholder="最多预算" value="" class="cInput"  onblur="chekSubMit('ddprice','hhprice','万','ccprice','chekpricee')"/>
                  万元<div id="chekpricee" style="display: none"></div><input type="hidden" id="ccprice" name="ccprice"> </td>
                  
              </tr>
              <tr>
                <td><input type="text" value="" readonly="readonly" placeholder="计划购买时间" style="width:95%" class="form_datetime cInput" name="buytimett" id="buytimett" data-date-format="yyyy-mm"><div id="timedivt" style="display: none"></div></td>
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
      </div>
      <div id="d_gd">
        <div class="gd_box">
          <!--<div class="dWx"> <a href="javascript:;"><img src="images/5678b0dbe039f.jpg-thumb.jpg"/></a> </div>-->
          <div class="txtMarquee-top">
            <div class="sameCar bd">
              <h4>在途同类型车源<a style="float:right; color:#FFF" href="CarInfo.action?op=showlist&tname=${tname}&bname=${bname }&cser=${cser}" target="_blank">更多>></a></h4>
              <ul class="infoList">
              <c:if test="${!empty carMap}">
              <c:forEach var="carMap" items="${carMap }">
              
               <li> <a href="CarInfo.action?op=showdetails&cid=${carMap.cId}&uid=${carMap.uId } " target="_blank">${carMap.cBrand }${carMap.cSeries }${carMap.cReleaseyear }款 ${carMap.cVolume }T ${carMap.cGeartype } ${carMap.cCode } ${carMap.cModel }</a> </li>
              </c:forEach>
              </c:if>
               
              </ul>
            </div>
          </div>
        </div>
      </div>
      <style type="text/css">
			.sameCar{margin-top:20px;padding-bottom:15px;border:1px solid #ccc;border-top:none;}
			.sameCar h4{font-size:14px;color:#fff;padding:10px;background:#3F7DDD;}
			.sameCar ul{}
			.sameCar li{line-height:20px; margin:0px 10px;border-bottom:1px solid #ccc;padding:5px 0;}
			.nav_fixed{position:fixed;top:0px;z-index: 10;}
* html .nav_fixed{position:absolute;bottom:auto;top:expression(eval(document.documentElement.scrollTop));}
			#header{position:absolute;}
			#d_gd,.gd_box{width:253px;overflow:hidden;}
			
			</style>
    </div>
  </div>
</div>
<script type="text/javascript">
$(function(){
	$(window).scroll(function(){
		/*var amNavTop= $('#d_gd').offset().top;*/
		var b=$(window).scrollTop();
		if(b>=amNavTop)
		{
			$('#d_gd').find('.gd_box').addClass('nav_fixed');
		}
		else
		{
			$('#d_gd').find('.gd_box').removeClass('nav_fixed');
		};

	});
})
</script>

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
        <form  action="UserInfo.action" method="get" name="form" id="form" onsubmit="return chekLogin('username','userpwd','yzm','_yzm','d1','d2','d3')">
         <input type="hidden" name="tname"  value="${tname}">
             <input type="hidden" name="bname"  value="${bname}">
             <input type="hidden" name="cser"  value="${cser}">
             <input type="hidden" name="price"  value="${price}">
             <input type="hidden" name="distance"  value="${distance}">
             <input type="hidden" name="age"  value="${age}">
             <input type="hidden" name="emsi"  value="${emsi}">
            
             <input type="hidden" name="url" value="forward:/CarInfo_showList.action">
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
         <form class="registForm" action="UserInfo.action" onsubmit="return chekReg('regname','regpwd','regyzm','_regyzm','realname','d9','d6','d7','d5')"  method="get" name="reg" id="reg">
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
             <input type="hidden" name="tname"  value="${tname}">
             <input type="hidden" name="bname"  value="${bname}">
             <input type="hidden" name="cser"  value="${cser}">
             <input type="hidden" name="price"  value="${price}">
             <input type="hidden" name="distance"  value="${distance}">
             <input type="hidden" name="age"  value="${age}">
             <input type="hidden" name="emsi"  value="${emsi}">
            
             <input type="hidden" name="url" value="forward:/CarInfo_showList.action">
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
        <form  action="UserInfo.action" method="get" name="form" id="form" onsubmit="return chekLogin('username','userpwd','yzm','_yzm','d1','d2','d3')">
           <input type="hidden" name="tname"  value="${tname}">
             <input type="hidden" name="bname"  value="${bname}">
             <input type="hidden" name="cser"  value="${cser}">
             <input type="hidden" name="price"  value="${price}">
             <input type="hidden" name="distance"  value="${distance}">
             <input type="hidden" name="age"  value="${age}">
             <input type="hidden" name="emsi"  value="${emsi}">
            
             <input type="hidden" name="url" value="forward:/CarInfo_showList.action">
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
         <form class="registForm" action="UserInfo.action" onsubmit="return chekReg('regname','regpwd','regyzm','_regyzm','realname','d9','d6','d7','d5')"  method="get" name="reg" id="reg">
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
              <input type="hidden" name="tname"  value="${tname}">
             <input type="hidden" name="bname"  value="${bname}">
             <input type="hidden" name="cser"  value="${cser}">
             <input type="hidden" name="price"  value="${price}">
             <input type="hidden" name="distance"  value="${distance}">
             <input type="hidden" name="age"  value="${age}">
             <input type="hidden" name="emsi"  value="${emsi}">
            
             <input type="hidden" name="url" value="forward:/CarInfo_showList.action">
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
        <form  action="UserInfo.action" method="get" name="form" id="form" onsubmit="return chekLogin('username','userpwd','yzm','_yzm','d1','d2','d3')">
      
            <input type="hidden" name="tname"  value="${tname}">
             <input type="hidden" name="bname"  value="${bname}">
             <input type="hidden" name="cser"  value="${cser}">
             <input type="hidden" name="price"  value="${price}">
             <input type="hidden" name="distance"  value="${distance}">
             <input type="hidden" name="age"  value="${age}">
             <input type="hidden" name="emsi"  value="${emsi}">
            
             <input type="hidden" name="url" value="forward:/CarInfo_showList.action">
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
        <form class="registForm" action="UserInfo.action" onsubmit="return chekReg('regname','regpwd','regyzm','_regyzm','realname','d9','d6','d7','d5')"  method="get" name="reg" id="reg">
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
         
             <input type="hidden" name="tname"  value="${tname}">
             <input type="hidden" name="bname"  value="${bname}">
             <input type="hidden" name="cser"  value="${cser}">
             <input type="hidden" name="price"  value="${price}">
             <input type="hidden" name="distance"  value="${distance}">
             <input type="hidden" name="age"  value="${age}">
             <input type="hidden" name="emsi"  value="${emsi}">
            
             <input type="hidden" name="url" value="forward:/CarInfo_showList.action">
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

<!--右侧搜索加入对比开始-->
<script type="text/javascript" src="js/miniBar.js"></script> 
<script type="text/javascript" src="js/lg_reg.js"></script>
 
<script type="text/javascript" src="js/search_car.js"></script> 
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<!--右侧搜索加入对比结束-->
<!--右侧滚动开始--> 
<script type="text/javascript">
$(function(){
	$(window).scroll(function(){
	})
})
jQuery(".txtMarquee-top").slide({mainCell:".bd ul",autoPlay:true,effect:"topMarquee",vis:5,interTime:50,trigger:"click"});
</script>
<!--右侧滚动结束--> 
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-datetimepicker.css">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script> 
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script> 
<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script> 
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
