function update()
{var brand=$("#brand").val();
var series=$("#series").val();
var code=$("#code").val()
var ltime=$("#ltime").val()
var sjtime=$("#sjtime").val()
var l=$("#l").val()
var distance=$("#distance").val()
var lh=$("#lhtype").val()
var price=$("#price").val()
var count=$("#ccount").val()
var cid=$("#cid").val()
var uid=$("#uid").val()
var img=$("#img").val()
var mode=$("#mode").val()
var releaseyear=$("#releaseyear").val();
var typeselect=document.all('typeselect')
var emselect=document.all('emselect')
var stateselect=document.all('stateselect')
var sscount=$("#sscount").val()
var type=typeselect.options[typeselect.selectedIndex].text
var em=emselect.options[emselect.selectedIndex].text
var state=stateselect.options[stateselect.selectedIndex].text
if(checkbrand()&&checkseries()&&checkl()&&checklh()&&checkcode()&&checkltime()&&checkltime()&&checkccount()&&checkdistance())
{
var url="<%=basePath%>car.action?op=update&brand="+brand+"&series"+series+"&l"+l+"&lh"+lh+"&code"+code+"&ltime"+time+"&price"+price+"&count"+count+"&distance"+distance+"&em"+em+"&cid"+cid+"&uid"+uid+"&img"+img+"&mode"+mode+"&releaseyear"+releaseyear+"sscount"+sscount+"&sjtime"+sjtime;
jQuery.post(url,null,callback)

function callback(data)
{
alert(data)}

}


}
function checkbrand()
{var flag=false;
var brand=$("#brand").val();
var bdiv=document.all('bdiv');
if(brand=="")
{
bdiv.innerHTML="<font color='red'>车牌不能为空"
bdiv.style.display="inline";
return false;}
else
{var judgebrand= /[a-zA\u4E00-\u9FA5\uf900-\ufa2d]/;
if(judgebrand.exec(brand))
{bdiv.style.display="none";
flag=true;
return flag;
}
else
{bdiv.innerHTML="<font color='red'>车牌不合法"
bdiv.style.display="inline";
return false;
}
}
}
function checkseries()
{var flag=false;
var series=$("#series").val();
var csdiv=document.all('csdiv');
if(series=="")
{
csdiv.innerHTML="<font color='red'>车系列不能为空"
csdiv.style.display="inline";
return false;}
else
{var judgeseries=/[a-zA\u4E00-\u9FA5\uf900-\ufa2d]/;
if(judgeseries.exec(series))
{
csdiv.style.display="none";
flag=true;
return flag;
}
else
{csdiv.innerHTML="<font color='red'>车系列不合法"
csdiv.style.display="inline";
return false;
}
}
}
function checkl()
{
var l=$("#l").val()
var ldiv=document.all('ldiv')
if(l=="")
{ldiv.innerHTML="<font color='red'>排气量不能为空"
ldiv.style.display="inline";
return false;
}
else
{
var judgel=/^\d+(\.\d+)?$/
if(judgel.exec(l))
{ldiv.style.display="none";
return true;
}
else
{ldiv.innerHTML="<font color='red'>排气量不合法"
ldiv.style.display="inline";
return false;
}
}
}
function checklh()
{
var lh=$("#lhtype").val()
var lhdiv=document.all('lhdiv')
if(lh=='')
{lhdiv.innerHTML="<font color='red'>离合类型不能为空"
lhdiv.style.display="inline";
return false;
}
else
{var judgelh=/^[\u4e00-\u9fa5]{0,}$/;
if(judgelh.exec(lh))
{
lhdiv.style.display="none";
return true;
}
else
{lhdiv.innerHTML="<font color='red'>离合类型不合法"
lhdiv.style.display="inline";
return false;
}
}
}
function checkcode()
{
var code=$("#code").val()
var codediv=document.all('codediv')
if(code=="")
{codediv.innerHTML="<font color='red'>外形不能为空"
codediv.style.display="inline";
return false;
}
else
{var judgecode=/[a-zA\u4E00-\u9FA5\uf900-\ufa2d]/
if(judgecode.exec(code))
{
codediv.style.display="none";
return true;
}
else
{
codediv.innerHTML="<font color='red'>外形不合法"
codediv.style.display="inline";
return false;
}
}
}
function checkltime()
{
var ltime=$("#ltime").val()
var ltimediv=document.all('ltimediv')
if(ltime=="")
{ltimediv.innerHTML="<font color='red'>licenseyear不能为空"
ltimediv.style.display="inline";
return false;
}
else
{
var judgel=/^([0-9]{4})-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1])) (([0-1][0-9])|(2[0-3])):([0-5][0-9]):([0-5][0-9])$/
if(judgel.exec(ltime))
{ltimediv.style.display="none";
return true;
}
else
{
ltimediv.innerHTML="<font color='red'>licenseyear不合法"
ltimediv.style.display="inline";
return false;
}
}
}
function checksjtime()
{
var sjtime=$("#sjtime").val()
var sjtimediv=document.all('sjtimediv')
if(sjtime=="")
{
return true;
}
else
{
var judgesjtime=/^([0-9]{4})-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1])) (([0-1][0-9])|(2[0-3])):([0-5][0-9]):([0-5][0-9])$/
if(judgesjtime.exec(sjtime))
{sjtimediv.style.display="none";
return true;
}
else
{
sjtimediv.innerHTML="<font color='red'>上架不合法"
sjtimediv.style.display="inline";
return false;
}
}
}
function checkprice()
{var price=$("#price").val()
var pricediv=document.all('pricediv');
if(price=="")
{pricediv.innerHTML="<font color='red'>价格不能为空"
pricediv.style.display="inline";
return false;
}
else
{var judgeprice=/^\d+(\.\d+)?$/
if(judgeprice.exec(price))
{pricediv.style.display="none";
return true;
}
else
{
pricediv.innerHTML="<font color='red'>价格不合法"
pricediv.style.display="inline";
return false;
}
}
}
function checkreleaseyear()
{var flag=false;
var releaseyear=$("#releaseyear").val();
var releaseyeardiv=document.all('releaseyeardiv');
if(releaseyear=="")
{
releaseyeardiv.innerHTML="<font color='red'>生产日期不能为空"
releaseyeardiv.style.display="inline";
return false;}
else
{var judgeyear=/^[0-9]*$/
if(judgeyear.exec(releaseyear))
{releaseyeardiv.style.display="none";
flag=true;
return flag;
}
else
{
releaseyeardiv.innerHTML="<font color='red'>生产日期必须为数字"
releaseyeardiv.style.display="inline";
return false;
}
}
}
function checkccount()
{var count=$("#ccount").val()
var countdiv=document.all('countdiv')
if(count=='')
{
countdiv.innerHTML="<font color='red'>数量不能为空"
countdiv.style.display="inline"
return false;
}
else
{var judgecount=/^[0-9]*$/
if(judgecount.exec(count))
{countdiv.style.display="none"
return true;
}
else
{countdiv.innerHTML="<font color='red'>数量不合法"
countdiv.style.display="inline";
return false;
}
}
}
function checksscount()
{var sscount=$("#sscount").val()
var sscountdiv=document.all('sscountcountdiv')
if(count=='')
{
	return true;
}
else
{var judgesscount=/^[0-9]*$/
if(judgesscount.exec(sscount))
{countdiv.style.display="none"
return true;
}
else
{sscountdiv.innerHTML="<font color='red'>收藏数量不合法"
sscountdiv.style.display="inline";
return false;
}
}
}
function checkdistance()
{var distance=$("#distance").val()
var distancediv=document.all('distancediv')
if(distance=='')
{
distancediv.innerHTML="<font color='red'>累计行程不能为空"
distancediv.style.display="inline"
return false;
}
else
{var judgedistance=/^\d+(\.\d+)?$/
if(judgedistance.exec(distance))
{distancediv.style.display="none"
return true;
}
else
{distancediv.innerHTML="<font color='red'>累计行程不合法"
distancediv.style.display="inline";
return false;
}
}
}
function checkmode()
{var mode=$("#model").val()
var modediv=document.all('modediv')
if(mode=='')
{
	modediv.innerHTML="<font color='red'>model不能为空"
		modediv.style.display="inline"
return false;
}
else
{var judgemode=/[a-zA\u4E00-\u9FA5\uf900-\ufa2d]/
if(judgemode.exec(mode))
{modediv.style.display="none"
return true;
}
else
{modediv.innerHTML="<font color='red'>model不合法"
modediv.style.display="inline";
return false;
}
}
}

