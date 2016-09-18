package cn.com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dao.IPageDao;
import cn.com.pojo.Comment1;
import cn.com.pojo.Trends;
import cn.com.service.ICommentService;
import cn.com.service.ITrendsService;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;
/**
 * 公司动态消息控制器类
 * @author lej
 */
@Controller
public class TrendsController {
	@Resource
	 private ITrendsService trendsService=null;  //公司动态消息服务接口的引用
	@Resource(name="trendsServiceImpl")
	   private IPageDao trendsPage=null; //分页处理操作接口的引用（指向公司动态消息操作实现类）
	@Resource
	   private ICommentService commentService=null; //评价信息服务接口的引用
	@Resource(name="commentServiceImpl")
	   private IPageDao commentsPage=null; //分页处理操作接口的引用（指向评价信息操作实现类）
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
/**
 * 展示新闻列表action
 */
	@RequestMapping("/Trends_showNewsList.action")
	public String showNewsList(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
	  Trends trends=new Trends();
		trends.setTrType("新闻");
		fenye(request,  trends);
		
		return "news_list";
	}
/**
 * 展示新闻详情action
 */
	@RequestMapping("/Trends_showTei.action")
	public String showTei(HttpServletRequest request) throws Exception{
		String tr_id=	request.getParameter("tr_id");
		Trends trends=new Trends();
		trends.setTrId(Long.parseLong(tr_id));
	 Trends _Trends=	 trendsService.getTrendsByWhere(trends);
	 request.setAttribute("_trends", _Trends);

		return "news_show";
	}
/**
 * 展示活动列表action
 */
	@RequestMapping("/Trends_showActive.action")
	public String showActive(HttpServletRequest request) throws Exception{
		Trends trends=new Trends();
		trends.setTrType("活动");
		fenye(request,  trends);

		return "active_list";
	}
/**
 * 展示活动详细action
 */
	@RequestMapping("/Trends_showTeia.action")
	public String showTeia(HttpServletRequest request) throws Exception{
		String tr_id=	request.getParameter("tr_id");
		Trends trends=new Trends();
		trends.setTrId(Long.parseLong(tr_id));
	 Trends _Trends=	 trendsService.getTrendsByWhere(trends);
	 request.setAttribute("_trends", _Trends);
	 
		return "active_show";
	}
/**
 * 展示评论列表action
 */
	@RequestMapping("/Trends_showCom.action")
	public String showCom(HttpServletRequest request) throws Exception{
		Comment1 comment=new Comment1();
		fenyec(request, comment);

		return "comment_list";
	}
/**
 * 展示评论详情action
 */
	@RequestMapping("/Trends_showComd.action")
	public String showComd(HttpServletRequest request) throws Exception{
		String tr_id=	request.getParameter("cid");
		Comment1 comment=new Comment1();
		comment.setcId(Long.parseLong(tr_id));
		
	comment=	commentService.getComment(comment);
	request.setAttribute("_trends", comment);

		return "comment_show";
	}
        /**
	 * 分页处理公司动态消息的方法
	 * 
	 * 
	 */
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
	 /**
	  * 分页处理评论信息的方法
	  * 
	  */
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
