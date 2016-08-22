package cn.com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dao.*;
import cn.com.pojo.*;
import cn.com.service.*;
import cn.com.util.*;

@Controller
public class TrendsController {
	@Resource
	 private ITrendsService trendsService=null;
	@Resource(name="trendsServiceImpl")
	   private IPageDao trendsPage=null;
	@Resource
	   private ICommentService commentService=null;
	@Resource(name="commentServiceImpl")
	   private IPageDao commentsPage=null;
	public ITrendsService getTrendsService() {
		return trendsService;
	}
	public void setTrendsService(ITrendsService trendsService) {
		this.trendsService = trendsService;
	}
	public IPageDao getTrendsPage() {
		return trendsPage;
	}
	public void setTrendsPage(IPageDao trendsPage) {
		this.trendsPage = trendsPage;
	}
	public ICommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	public IPageDao getCommentsPage() {
		return commentsPage;
	}
	public void setCommentsPage(IPageDao commentsPage) {
		this.commentsPage = commentsPage;
	}
	@RequestMapping("/Trends_shownewslist.action")
	public String shownewslist(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Trends trends=new Trends();
		trends.setTrType("新闻");
		fenye(request, trends);
		
		
		return "admin/news";
	}
	@RequestMapping("/Trends_showtei.action")
	public String showtei(HttpServletRequest request) throws Exception{
		String tr_id=	request.getParameter("tr_id");
		Trends trends=new Trends();
		trends.setTrId(Long.parseLong(tr_id));
	 Trends _Trends=	 trendsService.getTrendsByWhere(trends);
	 request.setAttribute("_trends", _Trends);

		return "news_show";
	}
	@RequestMapping("/Trends_showactive.action")
	public String showactive(HttpServletRequest request) throws Exception{
		Trends trends=new Trends();
		trends.setTrType("活动");
		fenye(request,  trends);

		return "admin/active";
	}
	@RequestMapping("/Trends_showteia.action")
	public String showteia(HttpServletRequest request) throws Exception{
		String tr_id=	request.getParameter("tr_id");
		Trends trends=new Trends();
		trends.setTrId(Long.parseLong(tr_id));
	 Trends _Trends=	 trendsService.getTrendsByWhere(trends);
	 request.setAttribute("_trends", _Trends);
	 
		return "active_show";
	}
	@RequestMapping("/Trends_showcom.action")
	public String showcom(HttpServletRequest request) throws Exception{
		Comment1 comment=new Comment1();
		fenyec(request, comment);

		return "admin/comment";
	}
	@RequestMapping("/Trends_showcomd.action")
	public String showcomd(HttpServletRequest request) throws Exception{
		String tr_id=	request.getParameter("cid");
		Comment1 comment=new Comment1();
		comment.setcId(Long.parseLong(tr_id));
		
	comment=	commentService.getComment(comment);
	request.setAttribute("_trends", comment);

		return "comment_show";
	}
	@RequestMapping("/Trends_showalltrends.action")
	public String showalltrends(HttpServletRequest request) throws Exception{
		Trends trends=new Trends();
		
		fenye(request, trends);

		return "admin/alltrends";
	}
	@RequestMapping("/Trends_addtrends.action")
	public String addtrends(HttpServletRequest request) throws Exception{
		String title=request.getParameter("maxAge");
		String text=request.getParameter("zm");
		String type=request.getParameter("sel1");
		String img=request.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTrTitle(title);
		trends.setTrText(text);
		trends.setTrType(type);
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date=new Date();
	   trends.setTrDate(dateFormat.format(date));
	   trends.setTrImg("");
	   if(img!=null&&!img.equals("")){
		   trends.setTrImg("tepimages/"+img);
	     }
	   if(trendsService.addTrends(trends)){
		   request.setAttribute("mea", "添加成功");
		 
	   }
		return "admin/alltrend-add";
	}
	@RequestMapping("/Trends_uptrends.action")
	public String uptrends(HttpServletRequest request,HttpSession session) throws Exception{
		String id=request.getParameter("tid");
		Trends trends=new Trends();
		trends.setTrId(Long.parseLong(id));
	trends=	trendsService.getTrendsByWhere(trends);

	session.setAttribute("utrends",trends );
		return "redirect:/admin/alltrend-up.jsp";
	}
	@RequestMapping("/Trends_tjuptrends.action")
	public String tjuptrends(HttpServletRequest request,HttpSession session) throws Exception{
		String id=request.getParameter("tid");
		
		String title=request.getParameter("maxAge");
		String text=request.getParameter("zm");
		String type=request.getParameter("sel1");
		String img=request.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTrTitle(title);
		trends.setTrText(text);
		trends.setTrType(type);
		trends.setTrId(Long.parseLong(id));
		
	   trends.setTrImg(request.getParameter("qtp"));
	   if(img!=null&&!img.equals("")){
		 
	      
	           
			   trends.setTrImg("tepimages/"+img);
		
	     }
	   if(trendsService.updateTrends(trends)){
		   session.setAttribute("utrends",trends );
		   session.setAttribute("tmea","修改成功" );
			
	   }
		return "redirect:/admin/alltrend-up.jsp";
	}
	@RequestMapping("/Trends_deltrends.action")
	public void deltrends(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id=request.getParameter("tid");
		Trends trends=new Trends();
		trends.setTrId(Long.parseLong(id));
		if(trendsService.deleteTrends(trends)){
			 response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(1);
			 response.getWriter().flush();//清空缓存,刷新
			   response.getWriter().close();
		}
		
	}
	@RequestMapping("/Trends_addnews.action")
	public String addnews(HttpServletRequest request) throws Exception{
		String title=request.getParameter("maxAge");
		String text=request.getParameter("zm");
		
		String img=request.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTrTitle(title);
		trends.setTrText(text);
		trends.setTrType("新闻");
		
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date=new Date();
	   trends.setTrDate(dateFormat.format(date));
	   trends.setTrImg("");
	   if(img!=null&&!img.equals("")){
		   trends.setTrImg("tepimages/"+img);
	     }
	   if(trendsService.addTrends(trends)){
		   request.setAttribute("mea", "添加成功");
		   
	   }
		return "admin/allnews-add";
	}
	@RequestMapping("/Trends_upnews.action")
	public String upnews(HttpServletRequest request,HttpSession session) throws Exception{
		String id=request.getParameter("tid");
		Trends trends=new Trends();
		trends.setTrId(Long.parseLong(id));
	trends=	trendsService.getTrendsByWhere(trends);

	session.setAttribute("utrends",trends );

		return "redirect:/admin/allnews-up.jsp";
	}
	@RequestMapping("/Trends_tjupnews.action")
	public String tjupnews(HttpServletRequest request,HttpSession session) throws Exception{
		String id=request.getParameter("tid");
		
		String title=request.getParameter("maxAge");
		String text=request.getParameter("zm");
		
		String img=request.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTrTitle(title);
		trends.setTrText(text);
		trends.setTrType("新闻");
		trends.setTrId(Long.parseLong(id));
		
		   trends.setTrImg(request.getParameter("qtp"));
	   if(img!=null&&!img.equals("")){
		 
	     
	       
		   trends.setTrImg("tepimages/"+img);
	     }
	   if(trendsService.updateTrends(trends)){
		   session.setAttribute("utrends",trends );
		   session.setAttribute("tmea","修改成功" );
			
	   }
		return "redirect:/admin/allnews-up.jsp";
	}
	@RequestMapping("/Trends_addactive.action")
	public String addactive(HttpServletRequest request) throws Exception{
		String title=request.getParameter("maxAge");
		String text=request.getParameter("zm");
		
		String img=request.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTrTitle(title);
		trends.setTrText(text);
		trends.setTrType("活动");
		DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date=new Date();
	   trends.setTrDate(dateFormat.format(date));
	   trends.setTrImg("");
	   if(img!=null&&!img.equals("")){
		   trends.setTrImg("tepimages/"+img);
	     }
	   if(trendsService.addTrends(trends)){
		   request.setAttribute("mea", "添加成功");
		  
	   }
		return "admin/active-add";
	}
	@RequestMapping("/Trends_upactive.action")
	public String upactive(HttpServletRequest request,HttpSession session) throws Exception{
		String id=request.getParameter("tid");
		Trends trends=new Trends();
		trends.setTrId(Long.parseLong(id));
	trends=	trendsService.getTrendsByWhere(trends);

	session.setAttribute("utrends",trends );

		return "redirect:/admin/active-up.jsp";
	}
	@RequestMapping("/Trends_tjupactive.action")
	public String tjupactive(HttpServletRequest request,HttpSession session) throws Exception{
		String id=request.getParameter("tid");
		
		String title=request.getParameter("maxAge");
		String text=request.getParameter("zm");
		
		String img=request.getParameter("ttp");
		Trends trends=new Trends();
		trends.setTrTitle(title);
		trends.setTrText(text);
		trends.setTrType("活动");
		trends.setTrId(Long.parseLong(id));
		
		   trends.setTrImg(request.getParameter("qtp"));
	   if(img!=null&&!img.equals("")){
		
	     
	       
		   trends.setTrImg("tepimages/"+img);
	     }
	   if(trendsService.updateTrends(trends)){
		   session.setAttribute("utrends",trends );
		   session.setAttribute("tmea","修改成功" );
			
	   }
		return "redirect:/admin/active-up.jsp";
	}
	@RequestMapping("/Trends_upcom.action")
	public String upcom(HttpServletRequest request,HttpSession session) throws Exception{
		String cid=request.getParameter("cid");
		Comment1 comment=new Comment1();
		comment.setcId(Long.parseLong(cid));
		
		comment=commentService.getComment(comment);
		session.setAttribute("ucomment", comment);
		
		
		return "redirect:/admin/comment-up.jsp";
	}
	@RequestMapping("/Trends_tjupcom.action")
	public String tjupcom(HttpServletRequest request,HttpSession session) throws Exception{
		String cid=request.getParameter("cid");
		String bt=request.getParameter("maxAge");
		String admin=request.getParameter("sel1");
		String text=request.getParameter("zm");
		Comment1 comment=new Comment1();
		comment.setcId(Long.parseLong(cid));
		comment.setcBt(bt);
		comment.setcAdmin(admin);
		comment.setcText(text);
		comment.setcImg(request.getParameter("qtp"));	
		String img=request.getParameter("ttp");
	   if(img!=null&&!img.equals("")){     
		   comment.setcImg("tepimages/"+img);
	     }
	  
	   if(commentService.updateComment(comment)){
		   session.setAttribute("ucomment", comment);
		   session.setAttribute("cmea", "修改成功");
			
	   }
		return "redirect:/admin/comment-up.jsp";
	}
	@RequestMapping("/Trends_delcom.action")
	public void delcom(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String cid=request.getParameter("cid");
		Comment1 comment=new Comment1();
		comment.setcId(Long.parseLong(cid));
		
		if(commentService.deleteComment(comment)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		
	}
	private void fenye(HttpServletRequest req,Trends trends){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		

	 long maxRowsCount=trendsPage.queryPersonCarCount(trends);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(2, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=trendsPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), trends);
		DbUtil.closeAll();
		Map<Long, Trends> _trendsMap=new HashMap<Long, Trends>();
		for(Long key:trendsMap.keySet()){
			Trends _trends=(Trends) trendsMap.get(key);
		_trendsMap.put(_trends.getTrId() ,_trends);
		}
		req.setAttribute("trends", _trendsMap);
		req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
		req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
		req.setAttribute("maxPage", pageUtil.getMaxPage());
		req.setAttribute("jumpPage", curPage);
		req.setAttribute("curPage", pageUtil.getCurPage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	 }
	private void fenyec(HttpServletRequest req,Comment1 comment){

	try {
	int curPage=0;
	if(req.getParameter("jumpPage")!=null){
	 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	}



	long maxRowsCount=commentsPage.queryPersonCarCount(comment);
	//处理分页逻辑<=>调用
	PageUtil pageUtil=new PageUtil(2, maxRowsCount);
	// 处理页码逻辑
	if (curPage <= 1) {

		pageUtil.setCurPage(1);
	} else if (curPage >= pageUtil.getMaxPage()) {

		pageUtil.setCurPage(pageUtil.getMaxPage());
	} else {
		pageUtil.setCurPage(curPage);
	}


	Map<Long, Object> trendsMap=commentsPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), comment);
	DbUtil.closeAll();
	Map<Long, Comment1> _trendsMap=new HashMap<Long, Comment1>();
	for(Long key:trendsMap.keySet()){
		Comment1 _trends=(Comment1) trendsMap.get(key);
	_trendsMap.put(_trends.getcId() ,_trends);
	}
	req.setAttribute("trends", _trendsMap);
	req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
	req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
	req.setAttribute("maxPage", pageUtil.getMaxPage());
	req.setAttribute("jumpPage", curPage);
	req.setAttribute("curPage", pageUtil.getCurPage());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



	}

}
