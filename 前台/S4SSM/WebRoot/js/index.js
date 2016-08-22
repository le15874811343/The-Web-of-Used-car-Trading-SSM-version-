
$(function(){
	 
	/*$('.banShow').cycle(
	{
		
		fx:'fade',
		timeout:6000,
		next:'.nexts',
		prev:'.prevs'
	}
	); */
   
	$('.c-item').hover(function(){
		
		$(this).toggleClass('active');
	});
	
	$(window).bind('scroll',function(e){
		var sTop=$(window).scrollTop();
		if(sTop<=460){
			
			$('.head-search').hide();
			$('#header .logo').hide();
			$('.nav a:first').css('padding-left','0px');
		}else{
			$('.head-search').fadeIn();
			$('#header .logo').show();
			$('.nav a:first').css('padding-left','20px');
		}
	});
	
	$(".slide").slide({titCell:'.hd li',mainCell:".bd ul",effect:"fold",autoPlay:true,vis:1});
	
	$('.mDiv').hover(function(){
		$(this).addClass('active');
	})
	$('.jpTit a').each(function(index){
		$(this).click(function(){
			$(this).addClass('on').siblings().removeClass('on');
			$('.jpDl').eq(index).fadeIn().siblings().hide();
		})
	});
})