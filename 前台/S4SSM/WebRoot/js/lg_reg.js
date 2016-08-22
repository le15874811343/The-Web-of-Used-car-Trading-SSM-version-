$(function(){
	$('.p-tab a').each(function(index){
		$(this).click(function(){
			$(this).addClass('on').siblings().removeClass('on');
			$('.p-dl').eq(index).show().siblings().hide();
		})
	});
	$('.b-login').click(function(){
		var idd=$(this).attr('id');
		if(idd){
			var strs=idd.split("_");
			$('.orderstatus').val(strs[0]);
			$('.ordercarid').val(strs[1]);
		}else{
			$('.ordercarid').val('');
		}
		$('#popBox').fadeIn();
		$('.p-tab a:first').addClass('on').siblings().removeClass('on');
		$('.p-dl:first').show().siblings().hide();
	})
	$('#b-tuichu').click(function(){
		alert('退出成功');
		window.location.href='/Member/logout/channel/7';
	})
	$('#b-regist').click(function(){
		$('#popBox').fadeIn();
		$('.p-tab a:last').addClass('on').siblings().removeClass('on');
		$('.p-dl:last').show().siblings().hide();
	})

	$('#popBox').click(function(){
		$('#popBox').fadeOut();
	});
	$('.popCont').click(function(e){
      e.stopPropagation();
    });
	/*$('.closed').click(function(){
		$('#popBox').fadeOut();
	});*/
	/*$('.send_phone').click(function(){
		$('#popBoxYzm').fadeIn();
	});*/
	$('.p_closed').click(function(){
		$('#popBox').fadeOut();
	});
	$('.closed').click(function(){
		$('#popBoxYzm').fadeOut();
	});
	$('#Carduibi li').hover(function(){
		$(this).toggleClass('hover')
	});
	jQuery(".mini-gotop").click("click", function() {jQuery('html, body').stop().animate({scrollTop: 0}, 800);});
	$('.wx1').hover(function(){
		$('.wmImg').removeClass('hide')
	},function(){
		$('.wmImg').addClass('hide')
	})
	$('#deletealldb').click(function(){
		var balancecar=$.cookie('flamingo.compare.car');
		if(balancecar){
			strs=balancecar.split("_");
			for(var i=0;i<strs.length;i++){
				if(strs[i]){
					var sss=strs[i].substr(2);
					$('.balance_'+sss).text('加入对比');
					$('.Cardd_'+sss).hide();
				}
			}
		}
		$.cookie('flamingo.compare.car', '', { expires: 1, path: '/' });
		$('#Dbnumber').text(0);
		$('.shopping').click();
	});
})
function closeDuibi(checkid){
	balance(checkid);
	$(this).parent('li').hide();
}
function balance(checkid){//对比
	var balancecar=$.cookie('flamingo.compare.car');
	if(balancecar){
		strs=balancecar.split("_");
		var len=strs.length-2;
		if(balancecar.indexOf('id'+checkid+'_')>=0){//取消对比
			balancecar=balancecar.replace('id'+checkid+'_',''); 
			$.cookie('flamingo.compare.car', balancecar, { expires: 1, path: '/' });
			$('.balance_'+checkid).text('加入对比');
			$('#Dbnumber').text(len-1);
			$('.Cardd_'+checkid).hide();
			if(len<=1){
				$('.shopping').click();
			}
		}else{//加入对比
			strs=balancecar.split("_");
			if(len>=4){
				$('#Dbnumber').text(len);
				alert('最多只能对比4个');
			}else{
				$('#Dbnumber').text(len+1);
				$.cookie('flamingo.compare.car', balancecar+'id'+checkid+'_', { expires: 1, path: '/' });
				$('.balance_'+checkid).text('取消对比');
				var v=$('.CarValue_'+checkid).val();
				var v = eval("("+v+")");
				var h=' <li class="clearfix Cardd_'+checkid+'">';
				h+='	<a href="'+v.url+'"><img src="'+v.img+'" class="left" width="80" /></a>';
				h+='	<h3><a href="'+v.url+'">'+v.title+'</a></h3>';
				h+='	<div class="mi_a clearfix">';
				h+='		<strong class="left">￥'+v.price+'万元</strong>';
				h+='		<a href="javascript:void(0)" onclick="balance(\''+v.id+'\')" class="right mini-tocar">取消对比</a>';
				h+='<input type="hidden" class="CarValue_'+v.id+'" value="{img:\''+v.img+'\',id:\''+v.id+'\',price:\''+v.price+'\',status:\'取消对比\',title:\''+v.title+'\',url:\''+v.url+'\'}" />';
				h+='	</div>';
				h+='	<a class="mini-m-close" onclick="closeDuibi(\''+v.id+'\')"></a>';
				h+='</li>';
				$("#Carduibi ul").append(h);
				$('.Cardd_'+checkid).hover(function(){
					$(this).toggleClass('hover')
				});
				if($("#shopping").is(":hidden")){
					$('.shopping').click();
				}
			}
		}
	}else{//加入对比
		$('#Dbnumber').text(1);
		$.cookie('flamingo.compare.car', '_id'+checkid+'_', { expires: 1, path: '/' });
		$('.balance_'+checkid).text('取消对比');

		var v=$('.CarValue_'+checkid).val();
		var v = eval("("+v+")");
		var h=' <li class="clearfix Cardd_'+checkid+'">';
		h+='	<a href="'+v.url+'"><img src="'+v.img+'" class="left" width="80" /></a>';
		h+='	<h3><a href="'+v.url+'">'+v.title+'</a></h3>';
		h+='	<div class="mi_a clearfix">';
		h+='		<strong class="left">￥'+v.price+'万元</strong>';
		h+='		<a href="javascript:void(0)" onclick="balance(\''+v.id+'\')" class="right mini-tocar">取消对比</a>';
		h+='<input type="hidden" class="CarValue_'+v.id+'" value="{img:\''+v.img+'\',id:\''+v.id+'\',price:\''+v.price+'\',status:\'取消对比\',title:\''+v.title+'\',url:\''+v.url+'\'}" />';
		h+='	</div>';
		h+='	<a class="mini-m-close" onclick="closeDuibi(\''+v.id+'\')"></a>';
		h+='</li>';
		$("#Carduibi ul").append(h);
		$('.Cardd_'+checkid).hover(function(){
			$(this).toggleClass('hover')
		});
		if($("#shopping").is(":hidden")){
			$('.shopping').click();
		}
	}
}
function collection(carid){
	var url='/Concern/shoucang';
	//alert(carid);
	$.ajax({
		type: "POST",
		url: url,
		data: {carid:carid},
		dataType: "json",
		success: function(data){
			if(data.code==1){
				alert('收藏成功');
				$('.collection_'+carid).text('已收藏');
				var v=$('.CarValue_'+carid).val();
				var v = eval("("+v+")");
				var h=' <li class="clearfix">';
				h+='	<a href="'+v.url+'"><img src="'+v.img+'" class="left" width="80" /></a>';
				h+='	<h3><a href="'+v.url+'">'+v.title+'</a></h3>';
				h+='	<div class="mi_a clearfix">';
				h+='		<strong class="left">￥'+v.price+'万元</strong>';
				h+='		<a href="javascript:void(0)" onclick="balance(\''+v.id+'\')" class="right mini-tocar">'+v.status+'</a>';
				h+='	</div>';
				h+='<input type="hidden" class="CarValue_'+v.id+'" value="{img:\''+v.img+'\',id:\''+v.id+'\',price:\''+v.price+'\',status:\''+v.status+'\',title:\''+v.title+'\',url:\''+v.url+'\'}" />';
				h+='	<a class="mini-m-close"></a>';
				h+='</li>';
				$("#shoucang ul").append(h);
			}else{
				alert(data.msg);
			}
		}
	 });
	 return false;
}
function yudingtongkuan(carId){
	var url='/Concern/yudingtongkuan';
	$.ajax({
		type: "POST",
		url: url,
		data: {carId:carId},
		dataType: "json",
		success: function(data){
			alert(data.msg);
		}
	 });
	 return false;
}