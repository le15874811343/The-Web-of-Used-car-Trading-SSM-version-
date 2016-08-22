$(function(){
	smoothScroll.init({});
	$('.caItem').click(function(){
		var $table=$(this).siblings('.clearfix');
		if($table.is(':visible')){
			$(this).removeClass('on');
			$table.hide();
		}else{
			$(this).addClass('on');
			$table.show();
		}
	})
	/*$(window).bind('scroll',function(){
		var amNavTop= $('.buyDetail').offset().top;
		var winTop=$(window).scrollTop();
		if(winTop>=amNavTop){
			$('.buyDetail').find('.b-tab').addClass('nav_fixed');
		}else{
			$('.buyDetail').find('.b-tab').removeClass('nav_fixed');
		}
	});*/
	$("#thumblist").slide({mainCell:".bd ul",effect:"leftLoop",autoPlay:false,vis:7});
 /*   $('.jqzoom').jqzoom({
	zoomType: 'standard',
	lens:true,
	preloadImages: true,
	alwaysOn:false
    });*/
})

$('.send_Mess').click(function(){
	var url='/Member/sendMess/channel/7';
	var mobile=$('#input-phone').val();
	var m=/^1\d{10}$/;
	if(!m.exec(mobile)){
		alert("手机号格式不正确");
		$('#input-phone').focus();
		return false;
	}
	$.ajax({
		type: "POST",
		url: url,
		data: {mobile:mobile},
		dataType: "json",
		success: function(data){
			if(data.sta=='1'){
				alert('发送成功');
				$('#send_Mess').html('<a href="#" class="getCode">已发送</a>');
			}else{
				alert('发送失败');
			}
		}
	 });
	 return false;
})
function tongzhi(carid,status){
	$('#stames').val(status);
	$('#caridmes').val(carid);
	$('#popBoxYzm').fadeIn();
}
function popYzm(){
	var mobile=yzmcheck.mobile.value;
	var sta=yzmcheck.sta.value;
	var carid=yzmcheck.carid.value;
	var verify=yzmcheck.verify.value;
	var ckmobile=yzmcheck.ckmobile.value;
	var re = /^1\d{10}$/;
	if(mobile==''){
		alert("请输入手机号");
		yzmcheck.mobile.focus();
		return false;
	}
	if (!re.test(mobile)) {
		alert("手机号不正确");
		yzmcheck.mobile.focus();
		return false;
	}
	if(verify==''){
		alert("验证码不能为空");
		yzmcheck.verify.focus();
		return false;
	}
	var url='/Cars/check';
	$.ajax({
		 type: "POST",
		 url: url,
		 data: {mobile:mobile, sta:sta,carid:carid, verify:verify,ckmobile:ckmobile},
		 dataType: "json",
		 success: function(data){
			 if(data.result>0){
				if(data.sta=='jg'){
					jiangjia(data.carid,data.mobile);
				}else if(data.sta=='dd'){
					daodian(data.carid,data.mobile);
				}else{
					$('#setmobile').val(data.mobile);
					$('#suandk').submit();
				}
			 }else{
				  alert('验证码不正确！');
			 }
		}
	 });
	 return false;
}



function jiangjia(carid,mobile){
	var url='/Cars/jiangjia';
	$.ajax({
		 type: "POST",
		 url: url,
		 data: {carid:carid,mobile:mobile},
		 dataType: "json",
		 success: function(data){
			 alert(data.msg);
			 $('#popBoxYzm').fadeOut();
		}
	 });
	 return false;
}
function daodian(carid,mobile){
	var url='/Cars/daodian';
	$.ajax({
		 type: "POST",
		 url: url,
		 data: {carid:carid,mobile:mobile},
		 dataType: "json",
		 success: function(data){
			alert(data.msg);
			$('#popBoxYzm').fadeOut();
		}
	 });
	 return false;
}