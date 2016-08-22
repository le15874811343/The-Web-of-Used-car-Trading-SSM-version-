function closeload(name){
	var url_form=$('#urlform').val();
	var url='/Cars/index/channel/2';
	$.ajax({
		type: "POST",
		url: url,
		data: {name:name,url_form:url_form,act:'del'},
		dataType: "json",
		success: function(data){
			location.href = data.url;
		}
	 });
	 return false;
}
function changeload(name,value){
	var url_form=$('#urlform').val();
	var url='/Cars/index/channel/2';
	$.ajax({
		type: "POST",
		url: url,
		data: {name:name,url_form:url_form,value:value,act:'search'},
		dataType: "json",
		success: function(data){
			location.href = data.url;
		}
	 });
	 return false;
}
$('#tjkey').click(function(){
	var p1=$('#keyword').val()?$('#keyword').val():'';
	if(p1){
		changeload('nr',p1);
	}else{
		closeload('nr');
	}
})
$('#clear').click(function(){
	var ss=$("#keyword").val();
	if(ss){
		$("#keyword").val("").focus(); // 清空并获得焦点
	}
})
$('#tjlicheng').click(function(){
	var reg=/^[0-9]*$/;
	var licheng1=$('#licheng_L').val()?$('#licheng_L').val():0;
	var licheng2=$('#licheng_R').val()?$('#licheng_R').val():0;
	if(!reg.test(licheng1)||!reg.test(licheng2)){
		alert('请输入数字');
	}else{
		if(licheng1==0&&licheng2==0){
			alert('请输入里程');
		}else{
			var p1=licheng1+'-'+licheng2;
			changeload('lc',p1);
		}
	}
})
$('#tjcheling').click(function(){
	var reg=/^[0-9]*$/;
	var cheling1=$('#cheling_L').val()?$('#cheling_L').val():0;
	var cheling2=$('#cheling_R').val()?$('#cheling_R').val():0;
	if(!reg.test(cheling1)||!reg.test(cheling2)){
		alert('请输入数字');
	}else{
		if(cheling1==0&&cheling2==0){
			alert('请输入车龄');
		}else{
			var p1=cheling1+'-'+cheling2;
			changeload('cl',p1);
		}
	}
})
$('#tjprice').click(function(){
	var reg=/^[0-9]*$/;
	var jiage1=$('#price_L').val()?$('#price_L').val():0;
	var jiage2=$('#price_R').val()?$('#price_R').val():0;
	if(!reg.test(jiage1)||!reg.test(jiage2)){
		alert('请输入数字');
	}else{
		if(jiage1==0&&jiage2==0){
			alert('请输入价格');
		}else{
			var p1=jiage1+'-'+jiage2;
			changeload('jg',p1);
		}
	}
})
$('#Smakeid').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 对，没错
	if(p1){
		changeload('pp',p1);
	}else{
		closeload('pp');
	}
})
$('#Smodeid').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 对，没错
	if(p1){
		changeload('xl',p1);
	}else{
		closeload('xl');
	}
})