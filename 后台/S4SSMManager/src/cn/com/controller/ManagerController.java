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
@Controller
public class ManagerController {
	@Resource
	 private IUserInfoService userInfoServiceImpl=null;
	@Resource(name="userInfoServiceImpl")
	   private IPageDao userInfoPage=null;
	@Resource
	   private IPersonNeedService personNeedServiceImpl=null;
	@Resource(name="personNeedServiceImpl")
	   private IPageDao personndPage=null;
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
	@RequestMapping("/Manager_showalluser.action")
	public String showalluser(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		fenye(request,  userInfo);
		request.setAttribute("titile", "所有用户");
		
		return "admin/user";
	}
	@RequestMapping("/Manager_showadmin.action")
	public String showadmin(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		userInfo.setuAdmin("管理员");
		fenye(request, userInfo);
		request.setAttribute("titile", "管理员");
		
		
		return "admin/admin";
	}
	@RequestMapping("/Manager_showuser.action")
	public String showuser(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		userInfo.setuAdmin("普通用户");
		fenye(request,  userInfo);
		request.setAttribute("titile", "普通用户");
		
		return "admin/putong";
	}
	@RequestMapping("/Manager_showsrdz.action")
	public String showsrdz(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Personneed personNeed=new Personneed();
		
		this.fenyepn(request, personNeed);
		DbUtil.closeAll();
	
		return "admin/srdz";
	}
	@RequestMapping("/Manager_showclzsrdz.action")
	public String showclzsrdz(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
	
		Personneed personNeed=new Personneed();
		personNeed.setpState("处理中");
		this.fenyepn(request,personNeed);
		DbUtil.closeAll();
	
		return "admin/clz";
	}
	@RequestMapping("/Manager_showyclsrdz.action")
	public String showyclsrdz(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Personneed personNeed=new Personneed();
		personNeed.setpState("已处理");
		this.fenyepn(request,personNeed);
		DbUtil.closeAll();
	
		
		return "admin/ycl";
	}
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
