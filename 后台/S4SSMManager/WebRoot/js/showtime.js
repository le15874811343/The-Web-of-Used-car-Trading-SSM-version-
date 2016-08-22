
function time()
{var now=new Date();
var year=now.getFullYear();
var month=now.getMonth()+1;
var day=now.getDate();
var hour=now.getHours();
var minute=now.getMinutes()
var second=now.getSeconds();
var s=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second
document.all('time').value=s;
setTimeout("time()",1000);


}

