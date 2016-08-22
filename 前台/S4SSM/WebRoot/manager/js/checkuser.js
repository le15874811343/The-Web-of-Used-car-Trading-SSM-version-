/*
验证名字是否合格
*/
function checkname()
{
var flag=false;
var name=document.all('name').value;
var namediv=document.all('namediv');
if(name=="")
{
namediv.innerHTML="<font color='red'>姓名不能为空";
namediv.style.display='inline';
return flag;
}
else
{var judgename=/^[\u4e00-\u9fa5]*$/;
if(judgename.exec(name))
{namediv.style.display="none";
flag=true;
return flag;
}
else
{
namediv.innerHTML="<font color='red'>姓名只能为汉字";
namediv.style.display='inline';
return flag;
}
}
}

/*
检查手机号码是否合格
*/
function checkphone()
{var flag=false;
var mobile=document.all('mobile').value;
var phonediv=document.all('phonediv');
if(mobile=='')
{
phonediv.innerHTML="<font color='red'>手机号码不能为空";
phonediv.style.display="inline"
return flag;
}
else
{
var judgephonelength=/^\d{11,}$/;
var judgephone=/^[0-9]*$/
if(judgephone.exec(mobile))
{
if(judgephonelength.exec(mobile))
{phonediv.style.display="none";
flag=true;
return flag;
}
else
{phonediv.innerHTML="<font color='red'>手机号码必须为11位";
phonediv.style.display="inline";
return flag;
}
}
else
{phonediv.innerHTML="<font color='red'>手机号码必须为数字";
phonediv.style.display="inline";
return flag;
}
}
}
/*
验证身份证是否合法
*/
function checkcard()
{var flag=false;
var card=document.all('card').value;
var carddiv=document.all('carddiv');
if(card=='')
{
carddiv.innerHTML="<font color='red'>身份证号码不能为空";
carddiv.style.display="inline"
return flag;
}
else
{
var judgecardlength=/^\d{18,}$/;
var judgecard=/^[0-9]*$/;
if(judgecard.exec(card))
{
if(judgecardlength.exec(card))
{carddiv.style.display="none";
flag=true;
return flag;
}
else
{carddiv.innerHTML="<font color='red'>身份证号码必须为18位";
carddiv.style.display="inline";
return flag;
}
}
else
{carddiv.innerHTML="<font color='red'>身份证号码必须为数字";
carddiv.style.display="inline";
return flag;
}
}
}
/*
验证email是否合法
*/
function checkemail()
{var flag=false;
var email=$("#email").val();
var emaildiv=document.all('emaildiv')
if(email=='')
{flag=true;
return flag;
}
else
{
var judgeemail= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
if(judgeemail.exec(email))
{
emaildiv.style.display="none"
flag=true;
return flag;
}
else
{emaildiv.innerHTML="<font color='red'>邮箱不合法";
emaildiv.style.dispaly='inline';
return flag;
}
}
}
/*
验证QQ是否合法
*/
function checkqq()
{var flag=false;
var qq=$("#QQ").val()
var qqdiv=document.all('qqdiv')
if(qq=='')
{flag=true;
return flag;
}
else
{
var judgeqq=/^[0-9]*$/
if(judgeqq.exec(qq))
{
qqdiv.style.dispaly="none";
flag=true;
return flag;
}
else
{
qqdiv.innerHTML="<font color='red'>qq不合法";
qqdiv.style.display="inline";
return flag;
}
}
}
/*
验证地址
*/
function checkadd()
{
var flag=false;
var address=document.all('address').value;
var adiv=document.all('adiv');
var judgeadd=/^(?=.*?[\u4E00-\u9FA5])[\dA-Za-z\u4E00-\u9FA5]+(?=.*?[\u4E00-\u9FA5])/
if(address=='')
{adiv.innerHTML="<font color='red'>地址不能为空"
adiv.style.display="inline";
return flag;
}
else
{
if(judgeadd.exec(address))
{adiv.style.display="none";
flag=true;
return flag;
}
else
{adiv.innerHTML="<font color='red'>请输入合适的地址"
adiv.style.display="inline";
return flag;
}
}
}