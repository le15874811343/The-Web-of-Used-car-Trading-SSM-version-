package cn.com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dao.IPageDao;
import cn.com.pojo.Personneed;
import cn.com.pojo.Userinfo3;
import cn.com.service.IPersonNeedService;
import cn.com.service.IUserInfoService;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;
/**
 * 管理用户控制器
 * 
 */
@Controller
public class ManagerController {
	@Resource
	 private IUserInfoService userInfoServiceImpl=null;  //用户信息服务接口的引用
	@Resource(name="userInfoServiceImpl")
	   private IPageDao userInfoPage=null; //分页处理操作接口的引用（指向用户信息操作实现类）
	@Resource
	   private IPersonNeedService personNeedServiceImpl=null; //个人需求信息服务接口的引用
	@Resource(name="personNeedServiceImpl")
	   private IPageDao personndPage=null; //分页处理操作接口的引用（个人需求信息操作实现类）
	public IUserInfoService getUserInfoServiceImpl() {
		return userInfoServiceImpl;
	}
	public void setUserInfoServiceImpl(IUserInfoService userInfoServiceImpl) {
		this.userInfoServiceImpl = userInfoServiceImpl;
	}
	public IPageDao getUserInfoPage() {
		return userInfoPage;
	}
	public void setUserInfoPage(IPageDao userInfoPage) {
		this.userInfoPage = userInfoPage;
	}
	public IPersonNeedService getPersonNeedServiceImpl() {
		return personNeedServiceImpl;
	}
	public void setPersonNeedServiceImpl(IPersonNeedService personNeedServiceImpl) {
		this.personNeedServiceImpl = personNeedServiceImpl;
	}
	public IPageDao getPersonndPage() {
		return personndPage;
	}
	public void setPersonndPage(IPageDao personndPage) {
		this.personndPage = personndPage;
	}
/**
 * 展示所有用户action
 * 
 */
	@RequestMapping("/Manager_showalluser.action")
	public String showalluser(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		fenye(request,  userInfo);
		request.setAttribute("titile", "所有用户");
		
		return "admin/user";
	}
/**
 * 展示管理员action
 * 
 */
	@RequestMapping("/Manager_showadmin.action")
	public String showadmin(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		userInfo.setuAdmin("管理员");
		fenye(request, userInfo);
		request.setAttribute("titile", "管理员");
		
		
		return "admin/admin";
	}
	/**
	 * 展示普通用户action
	 * 
	 */
	@RequestMapping("/Manager_showuser.action")
	public String showuser(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		userInfo.setuAdmin("普通用户");
		fenye(request,  userInfo);
		request.setAttribute("titile", "普通用户");
		
		return "admin/putong";
	}
	/**
	 * 展示用户个人需求action
	 */
	@RequestMapping("/Manager_showsrdz.action")
	public String showsrdz(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Personneed personNeed=new Personneed();
		
		this.fenyepn(request, personNeed);
		DbUtil.closeAll();
	
		return "admin/srdz";
	}
	/**
	 * 展示处理中的用户个人需求action
	 */
	@RequestMapping("/Manager_showclzsrdz.action")
	public String showclzsrdz(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
	
		Personneed personNeed=new Personneed();
		personNeed.setpState("处理中");
		this.fenyepn(request,personNeed);
		DbUtil.closeAll();
	
		return "admin/clz";
	}
	/**
	 * 展示已处理用户个人需求action
	 */
	@RequestMapping("/Manager_showyclsrdz.action")
	public String showyclsrdz(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Personneed personNeed=new Personneed();
		personNeed.setpState("已处理");
		this.fenyepn(request,personNeed);
		DbUtil.closeAll();
	
		
		return "admin/ycl";
	}
	/**
	 * 分页展示用户信息的方法
	 * 
	 */
private void fenye(HttpServletRequest req, Userinfo3 userInfo){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 long maxRowsCount=userInfoPage.queryPersonCarCount(userInfo);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(6, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=userInfoPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), userInfo);
		DbUtil.closeAll();
		Map<Long, Userinfo3> _usersMap=new HashMap<Long, Userinfo3>();
		for(Long key:trendsMap.keySet()){
			Userinfo3 _userInfo=(Userinfo3) trendsMap.get(key);
			_usersMap.put(_userInfo.getuId() ,_userInfo);
		}
		req.setAttribute("showuser", _usersMap);
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
	  * 分页展示用户需求的方法
	  * 
	  * 
	  */
private void fenyepn(HttpServletRequest req, Personneed personNeed){
	
	
	try {
	int curPage=0;
	if(req.getParameter("jumpPage")!=null){
	 curPage =Integer.parseInt(req.getParameter("jumpPage"));
 }
	
	

 Long maxRowsCount=personndPage.queryPersonCarCount(personNeed);
	//处理分页逻辑<=>调用
	PageUtil pageUtil=new PageUtil(4, maxRowsCount);
	// 处理页码逻辑
	if (curPage <= 1) {

		pageUtil.setCurPage(1);
	} else if (curPage >= pageUtil.getMaxPage()) {

		pageUtil.setCurPage(pageUtil.getMaxPage());
	} else {
		pageUtil.setCurPage(curPage);
	}
	
	
	Map<Long, Object> carMap=personndPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), personNeed);
	DbUtil.closeAll();
	Map<Long, Personneed> _carMap=new HashMap<Long, Personneed>();
	for(Long key:carMap.keySet()){
	Personneed _PersonNeed=(Personneed) carMap.get(key);
	_carMap.put( _PersonNeed.getpId(),_PersonNeed);
	}
	req.setAttribute("szCar", _carMap);
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
