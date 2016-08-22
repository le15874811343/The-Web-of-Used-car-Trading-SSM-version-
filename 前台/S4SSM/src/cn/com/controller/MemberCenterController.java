package cn.com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dao.IPageDao;
import cn.com.pojo.Basicinfo;
import cn.com.pojo.Carinfo;
import cn.com.pojo.Cartype;
import cn.com.pojo.Comment1;
import cn.com.pojo.Hardwareconfig;
import cn.com.pojo.Imagesinfo;
import cn.com.pojo.Personcar;
import cn.com.pojo.Personneed;
import cn.com.pojo.Procedureinfo;
import cn.com.pojo.Sellinfo;
import cn.com.pojo.Systemconfig;
import cn.com.pojo.Userinfo3;
import cn.com.service.IBasicInfoService;
import cn.com.service.ICarImagesInfoService;
import cn.com.service.ICarInfoService;
import cn.com.service.ICarTypeService;
import cn.com.service.ICommentService;
import cn.com.service.IHardwareConfigService;
import cn.com.service.IPerSonCarService;
import cn.com.service.IPersonNeedService;
import cn.com.service.IProcedureInfoService;
import cn.com.service.ISellInfoService;
import cn.com.service.ISystemConfigService;
import cn.com.service.impl.BasicInfoServiceImpl;
import cn.com.service.impl.PersonNeedServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

@Controller
public class MemberCenterController {
	@Resource
	private IPerSonCarService perSonCarService = null;
	@Resource(name = "personCarServiceImpl")
	private IPageDao personCarPage = null;
	@Resource
	private ICarInfoService carInfoService = null;
	@Resource
	private IPersonNeedService personNeedService = null;
	@Resource(name = "personNeedServiceImpl")
	private IPageDao personNeedPage = null;
	@Resource
	private ICarTypeService carTypeService = null;
	@Resource
	private IBasicInfoService basicInfoService = new BasicInfoServiceImpl();
	@Resource
	private IHardwareConfigService hardwareConfigService = null;
	@Resource
	private ISystemConfigService systemConfigService = null;
	@Resource
	private IProcedureInfoService procedureInfoService = null;
	@Resource
	private ISellInfoService sellInfoService = null;
	@Resource
	private ICarImagesInfoService carImagesInfoService = null;
	@Resource
	private ICommentService commentServiceImpl = null;
	public IPerSonCarService getPerSonCarService() {
		return perSonCarService;
	}
	public void setPerSonCarService(IPerSonCarService perSonCarService) {
		this.perSonCarService = perSonCarService;
	}
	public IPageDao getPersonCarPage() {
		return personCarPage;
	}
	public void setPersonCarPage(IPageDao personCarPage) {
		this.personCarPage = personCarPage;
	}
	public ICarInfoService getCarInfoService() {
		return carInfoService;
	}
	public void setCarInfoService(ICarInfoService carInfoService) {
		this.carInfoService = carInfoService;
	}
	public IPersonNeedService getPersonNeedService() {
		return personNeedService;
	}
	public void setPersonNeedService(IPersonNeedService personNeedService) {
		this.personNeedService = personNeedService;
	}
	public IPageDao getPersonNeedPage() {
		return personNeedPage;
	}
	public void setPersonNeedPage(IPageDao personNeedPage) {
		this.personNeedPage = personNeedPage;
	}
	public ICarTypeService getCarTypeService() {
		return carTypeService;
	}
	public void setCarTypeService(ICarTypeService carTypeService) {
		this.carTypeService = carTypeService;
	}
	public IBasicInfoService getBasicInfoService() {
		return basicInfoService;
	}
	public void setBasicInfoService(IBasicInfoService basicInfoService) {
		this.basicInfoService = basicInfoService;
	}
	public IHardwareConfigService getHardwareConfigService() {
		return hardwareConfigService;
	}
	public void setHardwareConfigService(
			IHardwareConfigService hardwareConfigService) {
		this.hardwareConfigService = hardwareConfigService;
	}
	public ISystemConfigService getSystemConfigService() {
		return systemConfigService;
	}
	public void setSystemConfigService(ISystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}
	public IProcedureInfoService getProcedureInfoService() {
		return procedureInfoService;
	}
	public void setProcedureInfoService(IProcedureInfoService procedureInfoService) {
		this.procedureInfoService = procedureInfoService;
	}
	public ISellInfoService getSellInfoService() {
		return sellInfoService;
	}
	public void setSellInfoService(ISellInfoService sellInfoService) {
		this.sellInfoService = sellInfoService;
	}
	public ICarImagesInfoService getCarImagesInfoService() {
		return carImagesInfoService;
	}
	public void setCarImagesInfoService(ICarImagesInfoService carImagesInfoService) {
		this.carImagesInfoService = carImagesInfoService;
	}
	public ICommentService getCommentServiceImpl() {
		return commentServiceImpl;
	}
	public void setCommentServiceImpl(ICommentService commentServiceImpl) {
		this.commentServiceImpl = commentServiceImpl;
	}
	@RequestMapping("/MemberCenter_showmenber.action")
	public String showmenber(HttpSession session,HttpServletRequest request)  {	
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar = new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("收藏");
	 long scCount=perSonCarService.getCarCountByWhere(perSonCar);

	 perSonCar.setpState("已定");
	 long ydCount=perSonCarService.getCarCountByWhere(perSonCar);

	 request.setAttribute("scCount", scCount);
	 request.setAttribute("ydCount", ydCount);
	         return "admin/menber";

		}
		else{
			return "forward:/CarInfo.action";
		}
		
	}
	@RequestMapping("/MemberCenter_showmenberSc.action")
	public String showmenberSc(HttpSession session,HttpServletRequest request)  {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("收藏");
	     fenye(request, perSonCar);

	         return "admin/memberMySc";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberOrder.action")
	public String showmenberOrder(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("已定");
			 fenye(request,  perSonCar);
	     
	        return "admin/memberMyOrder";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberMc.action")
	public String showmenberMc(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("出售");
			 fenye(request,  perSonCar);
	           DbUtil.closeAll();
	         
	        return "admin/memberMyMc";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberYbcar.action")
	public String showmenberYbcar(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			 perSonCar.setuId(chekUser(session).getuId());
				perSonCar.setpState("交易完成");
				 fenye(request,  perSonCar);
		           DbUtil.closeAll();
		          
	        return "admin/memberMyCar";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberSh.action")
	public String showmenberSh(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("审核中");
			 fenye(request, perSonCar);
	           DbUtil.closeAll();
	          
	        return "admin/memberMyRz";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberbjj.action")
	public String showmenberbjj(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("未通过");
			 fenye(request,  perSonCar);
	           DbUtil.closeAll();
	        return "admin/memberMyBjj";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberJyz.action")
	public String showmenberJyz(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("被定");
			 fenye(request,  perSonCar);
	           DbUtil.closeAll();
	       
	        return "admin/memberMyJyz";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberymw.action")
	public String showmenberymw(HttpSession session,HttpServletRequest request)  {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("卖出完成");
			 fenye(request,  perSonCar);
	           DbUtil.closeAll();
	        
	        return "admin/memberMyYmc";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberzzmr.action")
	public String showmenberzzmr(HttpSession session,HttpServletRequest request)  {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("暂停交易");
			 fenye(request, perSonCar);
		       DbUtil.closeAll();
		    
	        return "admin/memberMyzzmr";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberXj.action")
	public String showmenberXj(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setpState("下架");
			 fenye(request, perSonCar);
	           DbUtil.closeAll();
	          
	        return "admin/memberMyXj";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showmenberSj.action")
	public String showmenberSj(HttpSession session,HttpServletRequest request)  {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			 Carinfo carInfo=new Carinfo();
			 Personcar perSonCar=new Personcar();
				this.finishop(request, perSonCar, chekUser(session),carInfo);
			   perSonCar.setpState("下架");
			   carInfo.setcState("在售");
				if(perSonCarService.updatePerSoncar(perSonCar, "出售")){
					if(carInfoService.updateCarInfo(carInfo)){
						return "forward:/MemberCenter_showmenberMc.action";
				
				}
					else{
						 return "ERROR";
					}
				}
				else{
					 return "ERROR";
				}
	        

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_qxsc.action")
	public String qxsc(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			this.finishop(request, perSonCar, chekUser(session),null);
			perSonCar.setpState("收藏");
		  perSonCar=perSonCarService.getPersoncar(perSonCar);
			if(perSonCarService.deletePerSoncar(perSonCar)){
			
				 return "forward:/MemberCenter_showmenberSc.action";
				
			}
	       
			else{
				 return "ERROR";
			}
		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_qrsh.action")
	public String qrsh(HttpSession session,HttpServletRequest request)  {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			Carinfo carInfo=new Carinfo();
	        
			this.finishop(request, perSonCar, chekUser(session),carInfo);
		   perSonCar.setpState("已定");
		   carInfo.setcState("交易完成");
		  
		   DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    Date date=new Date();
		   carInfo.setcMcsj( dateFormat.format(date));
			if(perSonCarService.updatePerSoncar(perSonCar, "交易完成")){
				if(carInfoService.updateCarInfo(carInfo)){
					perSonCar.setuId(perSonCar.getcUid());
					perSonCar.setpState("被定");
					if(perSonCarService.updatePerSoncar(perSonCar, "卖出完成")){
						  return "forward:/MemberCenter_showmenberYbcar.action";
					}
					else{
						 return "ERROR";
					}
			}
				else{
					 return "ERROR";
				}
			}
			else{
				 return "ERROR";
			}

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_qxdd.action")
	public String qxdd(HttpSession session,HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			Carinfo carInfo=new Carinfo();
	        
			this.finishop(request, perSonCar, chekUser(session),carInfo);
		   perSonCar.setpState("已定");
		 
			if(perSonCarService.updatePerSoncar(perSonCar, "暂停交易")){
				
					perSonCar.setuId(perSonCar.getcUid());
					perSonCar.setpState("被定");
					if(perSonCarService.updatePerSoncar(perSonCar, "暂停交易")){
						return "forward:/MemberCenter_showmenberzzmr.action";
				
					}
					else{
						 return "ERROR";
					}
			}
			else{
				 return "ERROR";
			}

		}
		else{
			return "forward:/CarInfo.action";
		}
		}
	@RequestMapping("/MemberCenter_tjbjj.action")
	public String tjbjj(HttpSession session,HttpServletRequest request)  {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			Carinfo carInfo=new Carinfo();
	   	 this.finishop(request, perSonCar, chekUser(session),carInfo);
	        perSonCar.setpState("未通过");
	        carInfo.setcState("审核中");
	        if(perSonCarService.updatePerSoncar(perSonCar, "审核中")){
				if(carInfoService.updateCarInfo(carInfo)){
					  return "forward:/MemberCenter_showmenberSh.action";
	       	
				}
				else{
					 return "ERROR";
				}
	        }
	        else{
				 return "ERROR";
			}

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_needsc.action")
	public String needsc(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			String c_uid=request.getParameter("c_uid");
			String c_id=request.getParameter("c_id");
				perSonCar.setcUid(Long.parseLong(c_uid));
				perSonCar.setcId(Long.parseLong(c_id));
					perSonCar.setuId(chekUser(session).getuId());
					perSonCar.setpState("收藏");
					Carinfo carInfo=new Carinfo();
					carInfo.setcId(Long.parseLong(c_id));
					carInfo.setuId(Long.parseLong(c_uid));
				Map<Long, Carinfo> car=	carInfoService.getCarByWhere(carInfo);
				Carinfo _car=car.get(carInfo.getcId());
				 _car.setcSccount(_car.getcSccount()+1);
				 String scmessage=null;
				
				if(!chekUser(session).getuId().toString().equals(carInfo.getuId().toString()))
				 {if(perSonCarService.getPerSonCarMapByWhere(perSonCar).size()>0){
					 scmessage="抱歉!:你已经收藏过这辆车了,去会员中心-我的需求-我的收藏中看看吧";
				}
				else{ 
				if(perSonCarService.addPerSonCar(perSonCar)&&carInfoService.updateCarInfo(_car)){
					 scmessage="恭喜!:收藏成功,去会员中心-我的需求-我的收藏中看看吧";
					
				 }
				}
				}
				else{
					scmessage="不允许收藏自己的车";
				}
				response.setContentType("text/html;charset=utf-8");
				 
				response.getWriter().println(scmessage);
				response.getWriter().flush();//清空缓存,刷新
				response.getWriter().close();
	        return null;

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_needdg.action")
	public String needdg(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			String c_uid=request.getParameter("c_uid");
			String c_id=request.getParameter("c_id");
					Carinfo carInfo=new Carinfo();
					carInfo.setcId(Long.parseLong(c_id));
					carInfo.setuId(Long.parseLong(c_uid));
				Map<Long, Carinfo> car=	carInfoService.getCarByWhere(carInfo);
				Carinfo _car=car.get(carInfo.getcId());
			           
				 String scmessage=null;
				if(!chekUser(session).getuId().toString().equals(carInfo.getuId().toString()))
				 {
					scmessage="pass";
				   session.setAttribute("ydcarr", _car);
				   
				
				}
				else{
					scmessage="不允许购买自己的车";
				}
				response.setContentType("text/html;charset=utf-8");
				 
				response.getWriter().print(scmessage);
				response.getWriter().flush();//清空缓存,刷新
				response.getWriter().close();
			
	        return null;

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_fukuan.action")
	public String fukuan(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
		
			Personcar perSonCar=new Personcar();
			String uid=request.getParameter("uid");
			String cid=request.getParameter("cid");
			
			String meeag=null;
			Carinfo carInfo1=new Carinfo();
			carInfo1.setcId(Long.parseLong(cid));
			carInfo1.setuId(Long.parseLong(uid));
			if(carInfoService.getCarByWhere(carInfo1).get(carInfo1.getcId()).getcState().equals("在售")){
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setcUid(Long.parseLong(uid));
			perSonCar.setcId(Long.parseLong(cid));
			perSonCar.setpState("已定");
			
			carInfo1.setcState("已定");
			
			Personcar _PerSonCar=new Personcar();
		 _PerSonCar.setuId(Long.parseLong(uid));
		 _PerSonCar.setcId(Long.parseLong(cid));
		 _PerSonCar.setcUid(Long.parseLong(uid));
		 _PerSonCar.setpState("出售");
			if(perSonCarService.addPerSonCar(perSonCar)&&perSonCarService.updatePerSoncar(_PerSonCar, "被定")){
				if(carInfoService.updateCarInfo(carInfo1)){
					meeag="恭喜!:订车成功,去会员中心-我的需求-我的订单中看看吧";
				}
				else{
					meeag="产生错误了";
				}
			}
			}
			else{
			
				meeag="该车已经被别人抢先订单啦,再看看别的车吧!";
			}
			response.setContentType("text/html;charset=utf-8");
			 response.getWriter().print(meeag);
			 response.getWriter().flush();//清空缓存,刷新
			 response.getWriter().close();
	        return null;

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_needxj.action")
	public String needxj(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personcar perSonCar=new Personcar();
			String uid=request.getParameter("uid");
			String cid=request.getParameter("cid");
			
			perSonCar.setuId(chekUser(session).getuId());
			perSonCar.setcUid(Long.parseLong(uid));
			perSonCar.setcId(Long.parseLong(cid));
			perSonCar.setpState("出售");
			String state="下架";
			Carinfo carInfo1=new Carinfo();
			carInfo1.setcId(Long.parseLong(cid));
			carInfo1.setuId(Long.parseLong(uid));
			carInfo1.setcState("下架");
			String meeag=null;
			if(perSonCarService.updatePerSoncar(perSonCar, state)){
				
				if(carInfoService.updateCarInfo(carInfo1)){
					meeag="提示:下架成功,去会员中心-我的车-下架的车看看吧";					}
				else{
					meeag="产生错误了";
				}
		
				
				
			}
			 response.getWriter().print(meeag);
			 response.getWriter().flush();//清空缓存,刷新
			 response.getWriter().close();
	        return null;

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_needmaiche.action")
	public String needmaiche(HttpSession session,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			
			
			  Map<Integer, Cartype> typeMap=		 carTypeService.getAllCarType();
			  request.setAttribute("cartype", typeMap);
			 
					
	        return "admin/wymc";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_logincar.action")
	public String logincar(HttpSession session,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			String brand=request.getParameter("selq");
			String cx=request.getParameter("ccx");
			String cxi=request.getParameter("ccxi");
			String sptime=request.getParameter("buytime");
			String dis=request.getParameter("mialval");
			request.setAttribute("brad", brand);
			request.setAttribute("cx", cx);
			request.setAttribute("cxi", cxi);
			request.setAttribute("sptime", sptime);
			request.setAttribute("dis", dis);
			
			
	        return "admin/logincarinfo";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_tjmc.action")
	public String tjmc(HttpSession session,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		 Userinfo3 userInfo=chekUser(session);
		if(userInfo!=null){
			try{
			Personcar perSonCar=new Personcar();
		
				//carinfo
				Carinfo carInfo=new Carinfo();
				carInfo.setuId(chekUser(session).getuId());
				carInfo.setcSccount(new Long(0));
				carInfo.setcState("审核中");
				carInfo.setcCount(new Long(0));
				
				DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			    Date date=new Date();
			   carInfo.setcSjtime( dateFormat.format(date));
				
		String brand=		request.getParameter("brad");
		carInfo.setcBrand(brand);
		String series=request.getParameter("cx");
		carInfo.setcSeries(series);
		String releaseyear=request.getParameter("fxn");
		carInfo.setcReleaseyear(Integer.parseInt(releaseyear));
		String volume=request.getParameter("dis");
		carInfo.setcVolume(Double.parseDouble(volume));
		String geartype=request.getParameter("speed");
		carInfo.setcGeartype(geartype);
		String code=request.getParameter("carbh");
		carInfo.setcCode(code);
		String model=request.getParameter("carxh");
		carInfo.setcModel(model);
		String licencetime=request.getParameter("stime");
		
		carInfo.setcLicencetime(licencetime);
		String distance=request.getParameter("travel");
		carInfo.setcDistance(Double.parseDouble(distance));
		String emissonstandard=request.getParameter("stan");
		carInfo.setcEmissionstandard(emissonstandard);
		String price=request.getParameter("price");
		carInfo.setcPrice(Double.parseDouble(price));
		String img=request.getParameter("ttp");
		carInfo.setcImg("tepimages/"+img+"");
		String type=request.getParameter("cxi");
		carInfo.setcType(type);
		String czzx=request.getParameter("txta");
		carInfo.setcCzzx(czzx);
		
		if(carInfoService.addCarInfo(carInfo)){
			//basicinfo
	Carinfo _carInfo=	  carInfoService.getCarInfoByUMN(carInfo);

	Basicinfo basicInfo=new Basicinfo();
			basicInfo.setuId(userInfo.getuId());
			basicInfo.setcId(_carInfo.getcId());
			String aidd=request.getParameter("ytime");
			basicInfo.setAidd(aidd);
			String srdt=request.getParameter("ytime1");
			basicInfo.setSrdt(srdt);
			String bodycolor=request.getParameter("carcolor");
			basicInfo.setBodycolor(bodycolor);
			String interiorcolor=request.getParameter("carincolor");
			basicInfo.setInteriorcolor(interiorcolor);
			String domf=request.getParameter("data");
			basicInfo.setDomf(domf);
			String orgin=request.getParameter("area");
			basicInfo.setOrgin(orgin);
			String cimd=request.getParameter("duedate");
			basicInfo.setCimd(cimd);
		  if(	basicInfoService.addBasicInfo(basicInfo)){
			  //hardware
			 
			  Hardwareconfig hardwareConfig=new Hardwareconfig();
			  hardwareConfig.setuId(userInfo.getuId());
			  hardwareConfig.setcId(_carInfo.getcId());
			  String  consolelcdscreen=request.getParameter("rad1");
			  hardwareConfig.setConsolelcdscreen(consolelcdscreen);
			  String   autolight=request.getParameter("rad2");
			  hardwareConfig.setAutolight(autolight);
			  String   headlights=request.getParameter("rad8");
			  hardwareConfig.setHeadlights(headlights);
			  String  lightwash=request.getParameter("rad-2");
			  hardwareConfig.setLightwash(lightwash);
			  String  efgv=request.getParameter("rad-3");
			  hardwareConfig.setEfgv(efgv);
			  String   seatnumber=request.getParameter("sate");
			  hardwareConfig.setSeatnumber(Integer.parseInt(seatnumber));
			  String   fuelform=request.getParameter("fuel");
			  hardwareConfig.setFuelform(fuelform);
			  String  cvt=request.getParameter("speed");
			  hardwareConfig.setCvt(cvt);
			  String   drivingmethod=request.getParameter("method");
			  hardwareConfig.setDrivingmethod(drivingmethod);
			  String  pke=request.getParameter("rad-key");
			  hardwareConfig.setPke(pke);
			  String  keylessgo=request.getParameter("rad-5");
			  hardwareConfig.setKeylessgo(keylessgo);
			  String  sunroof=request.getParameter("rad-6");
			  hardwareConfig.setSunroof(sunroof);
			  String  leatherseat=request.getParameter("rad-7");
			  hardwareConfig.setLeatherseat(leatherseat);
			if(  hardwareConfigService.addHardwareConfig(hardwareConfig)){
				Systemconfig systemConfig=new Systemconfig();
				
				systemConfig.setuId(userInfo.getuId());
				systemConfig.setcId(_carInfo.getcId());
				String  guidancesystem=request.getParameter("rad");
				systemConfig.setGuidancesystem(guidancesystem);
				String alb=request.getParameter("rad5");
				systemConfig.setAlb(alb);
				String fpg=request.getParameter("rad6");
				systemConfig.setFpg(fpg);
				String rpg=request.getParameter("rad7");
				systemConfig.setRpg(rpg);
				String rcpa=request.getParameter("rad9");
				systemConfig.setRcpa(rcpa);
				String dsea=request.getParameter("rad0");
				systemConfig.setDsea(dsea);
				String fsea=request.getParameter("rad-1");
				systemConfig.setFsea(fsea);
				String dlcc=request.getParameter("rad-4");
				systemConfig.setDlcc(dlcc);
				String hfs=request.getParameter("rad-8");
				systemConfig.setHfs(hfs);
				String hrs=request.getParameter("rad-9");
				systemConfig.setHrs(hrs);
				String fsv=request.getParameter("rad-qtf");
				systemConfig.setFsv(fsv);
				String rsv=request.getParameter("rad-htf");
				systemConfig.setRsv(rsv);
				String fsm=request.getParameter("rad-0");
				systemConfig.setFsm(fsm);
				String rsm=request.getParameter("rad-hjy");
				systemConfig.setRsm(rsm);
				String rvmh=request.getParameter("rad3");
				systemConfig.setRvmh(rvmh);
				String ess=request.getParameter("rad4");
			    systemConfig.setEss(ess);
			  if(  systemConfigService.addSystemConfig(systemConfig)){
				  Procedureinfo procedureInfo=new Procedureinfo();
				 
				  procedureInfo.setuId(userInfo.getuId());
				  procedureInfo.setcId(_carInfo.getcId());
				  String purchasetax=request.getParameter("buy");
				  procedureInfo.setPurchasetax(purchasetax);
				  String drivinglicense =request.getParameter("rad-a");
				  procedureInfo.setDrivinglicense(drivinglicense);
				  String ncw=request.getParameter("xczb");
				  procedureInfo.setNcw(ncw);
				  String registration =request.getParameter("rad-b");
				  procedureInfo.setRegistration(registration);
				  String newinvoice =request.getParameter("rad-c");
				  procedureInfo.setNewinvoice(newinvoice);
				  String key=request.getParameter("key");
				  procedureInfo.setKey(Integer.parseInt(key));
				  String transfertimes =request.getParameter("numm");
				  procedureInfo.setTransfertimes(Integer.parseInt(transfertimes));
				  String transgerticket =request.getParameter("ghp");
				  procedureInfo.setTransferticket(transgerticket);
				  if(procedureInfoService.addProcedureInfo(procedureInfo)){
					  Sellinfo sellInfo=new Sellinfo();
					 
					  sellInfo.setuId(userInfo.getuId());
					  sellInfo.setcId(_carInfo.getcId());
					  String pricetype=request.getParameter("p-type");
					  sellInfo.setPricetype(pricetype);
					  String transferfee =request.getParameter("rad-d");
					  sellInfo.setTransferfee(transferfee);
					  String stage=request.getParameter("rad-f");
					  sellInfo.setStage(stage);
					  if(sellInfoService.addSellInfo(sellInfo)){
						  Imagesinfo carImagesInfo=new Imagesinfo();
						
						  carImagesInfo.setuId(userInfo.getuId());
						  carImagesInfo.setcId(_carInfo.getcId());
						  String image1=request.getParameter("ftp1");
						  if(image1!=null&&!image1.equals("")){
							  carImagesInfo.setImage1("tepimages/"+image1+"");
						  }
						  String image2=request.getParameter("ftp2");
						  if(image2!=null&&!image2.equals("")){
							  carImagesInfo.setImage2("tepimages/"+image2+"");
						  }
						  String image3=request.getParameter("ftp3");
						  if(image3!=null&&!image3.equals("")){
							  carImagesInfo.setImage3("tepimages/"+image3+"");
						  }
						  String image4=request.getParameter("ftp4");
						  if(image4!=null&&!image4.equals("")){
							  carImagesInfo.setImage4("tepimages/"+image4+"");
						  }
						  String image5=request.getParameter("ftp5");
						  if(image5!=null&&!image5.equals("")){
							  carImagesInfo.setImage5("tepimages/"+image5+"");
						  }
						  String image6=request.getParameter("ftp6");
						  if(image6!=null&&!image6.equals("")){
							  carImagesInfo.setImage6("tepimages/"+image6+"");
						  }
						  String image7=request.getParameter("ftp7");
						  if(image7!=null&&!image7.equals("")){
							  carImagesInfo.setImage7("tepimages/"+image7+"");
						  }
						  String image8=request.getParameter("ftp8");
						  if(image8!=null&&!image8.equals("")){
							  carImagesInfo.setImage8("tepimages/"+image8+"");
						  }
						  String image9=request.getParameter("ftp9");
						  if(image9!=null&&!image9.equals("")){
							  carImagesInfo.setImage9("tepimages/"+image9+"");
						  }
						  String image10=request.getParameter("ftp10");
						  if(image10!=null&&!image10.equals("")){
							  carImagesInfo.setImage10("tepimages/"+image10+"");
						  }
						  if(carImagesInfoService.addCarImagesInfo(carImagesInfo)){
							  perSonCar.setpState("审核中");
							  perSonCar.setuId(userInfo.getuId());
							  perSonCar.setcUid(userInfo.getuId());
							  perSonCar.setcId(_carInfo.getcId());
							  if(perSonCarService.addPerSonCar(perSonCar)){
								 
								  request.setAttribute("xiaoxi", "提交成功,我们将会马上对您提供的信息进行审核,可进入<a href='MemberCenter_showmenberSh.action'>会员中心-我的需求-审核中的车进行查看</a>");
								 
							  }
						  }
							 
						  }
					  }
				  }
			  }
			}
		  }
	
		return "redirect:/CarInfo_showshdea.action?uid="+perSonCar.getuId()+"&cid="+perSonCar.getcId()+"";
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "ERROR";
			}

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_uptj.action")
	public String uptj(HttpSession session,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		 Userinfo3 userInfo=chekUser(session);
		if(userInfo!=null){
			try{
			
		
				//carinfo
				Carinfo carInfo=new Carinfo();
				carInfo.setcId(Long.parseLong(request.getParameter("cid")));
				
				
				carInfo.setcCount(new Long(0));
				carInfo.setcSccount(new Long(0));
		String brand=		request.getParameter("brad");
		carInfo.setcBrand(brand);
		String series=request.getParameter("cx");
		carInfo.setcSeries(series);
		String releaseyear=request.getParameter("fxn");
		carInfo.setcReleaseyear(Integer.parseInt(releaseyear));
		String volume=request.getParameter("dis");
		carInfo.setcVolume(Double.parseDouble(volume));
		String geartype=request.getParameter("speed");
		carInfo.setcGeartype(geartype);
		String code=request.getParameter("carbh");
		carInfo.setcCode(code);
		String model=request.getParameter("carxh");
		carInfo.setcModel(model);
		String licencetime=request.getParameter("stime");
		carInfo.setcLicencetime(licencetime);
		String distance=request.getParameter("travel");
		carInfo.setcDistance(Double.parseDouble(distance));
		String emissonstandard=request.getParameter("stan");
		carInfo.setcEmissionstandard(emissonstandard);
		String price=request.getParameter("price");
		carInfo.setcPrice(Double.parseDouble(price));
		String img=request.getParameter("ttp");
		carInfo.setcImg(img);
		String type=request.getParameter("cxi");
		carInfo.setcType(type);
		String czzx=request.getParameter("txta");
		carInfo.setcCzzx(czzx);
		if(carInfoService.updateCarAll(carInfo)){
			//basicinfo

	Basicinfo basicInfo=new Basicinfo();
			basicInfo.setuId(userInfo.getuId());
			basicInfo.setcId(carInfo.getcId());
			String aidd=request.getParameter("ytime");
			basicInfo.setAidd(aidd);
			String srdt=request.getParameter("ytime1");
			basicInfo.setSrdt(srdt);
			String bodycolor=request.getParameter("carcolor");
			basicInfo.setBodycolor(bodycolor);
			String interiorcolor=request.getParameter("carincolor");
			basicInfo.setInteriorcolor(interiorcolor);
			String domf=request.getParameter("data");
			basicInfo.setDomf(domf);
			String orgin=request.getParameter("area");
			basicInfo.setOrgin(orgin);
			String cimd=request.getParameter("duedate");
			basicInfo.setCimd(cimd);
		  if(	basicInfoService.updateBasicInfo(basicInfo)){
			  //hardware
			  
			  Hardwareconfig hardwareConfig=new Hardwareconfig();
			  hardwareConfig.setuId(userInfo.getuId());
			  hardwareConfig.setcId(carInfo.getcId());
			  String  consolelcdscreen=request.getParameter("rad1");
			  hardwareConfig.setConsolelcdscreen(consolelcdscreen);
			  String   autolight=request.getParameter("rad2");
			  hardwareConfig.setAutolight(autolight);
			  String   headlights=request.getParameter("rad8");
			  hardwareConfig.setHeadlights(headlights);
			  String  lightwash=request.getParameter("rad-2");
			  hardwareConfig.setLightwash(lightwash);
			  String  efgv=request.getParameter("rad-3");
			  hardwareConfig.setEfgv(efgv);
			  String   seatnumber=request.getParameter("sate");
			  hardwareConfig.setSeatnumber(Integer.parseInt(seatnumber));
			  String   fuelform=request.getParameter("fuel");
			  hardwareConfig.setFuelform(fuelform);
			  String  cvt=request.getParameter("speed");
			  hardwareConfig.setCvt(cvt);
			  String   drivingmethod=request.getParameter("method");
			  hardwareConfig.setDrivingmethod(drivingmethod);
			  String  pke=request.getParameter("rad-key");
			  hardwareConfig.setPke(pke);
			  String  keylessgo=request.getParameter("rad-5");
			  hardwareConfig.setKeylessgo(keylessgo);
			  String  sunroof=request.getParameter("rad-6");
			  hardwareConfig.setSunroof(sunroof);
			  String  leatherseat=request.getParameter("rad-7");
			  hardwareConfig.setLeatherseat(leatherseat);
			if(  hardwareConfigService.updateHardwareConfig(hardwareConfig)){
				Systemconfig systemConfig=new Systemconfig();
				
				systemConfig.setuId(userInfo.getuId());
				systemConfig.setcId(carInfo.getcId());
				String  guidancesystem=request.getParameter("rad");
				systemConfig.setGuidancesystem(guidancesystem);
				String alb=request.getParameter("rad5");
				systemConfig.setAlb(alb);
				String fpg=request.getParameter("rad6");
				systemConfig.setFpg(fpg);
				String rpg=request.getParameter("rad7");
				systemConfig.setRpg(rpg);
				String rcpa=request.getParameter("rad9");
				systemConfig.setRcpa(rcpa);
				String dsea=request.getParameter("rad0");
				systemConfig.setDsea(dsea);
				String fsea=request.getParameter("rad-1");
				systemConfig.setFsea(fsea);
				String dlcc=request.getParameter("rad-4");
				systemConfig.setDlcc(dlcc);
				String hfs=request.getParameter("rad-8");
				systemConfig.setHfs(hfs);
				String hrs=request.getParameter("rad-9");
				systemConfig.setHrs(hrs);
				String fsv=request.getParameter("rad-qtf");
				systemConfig.setFsv(fsv);
				String rsv=request.getParameter("rad-htf");
				systemConfig.setRsv(rsv);
				String fsm=request.getParameter("rad-0");
				systemConfig.setFsm(fsm);
				String rsm=request.getParameter("rad-hjy");
				systemConfig.setRsm(rsm);
				String rvmh=request.getParameter("rad3");
				systemConfig.setRvmh(rvmh);
				String ess=request.getParameter("rad4");
			    systemConfig.setEss(ess);
			  if(  systemConfigService.updateSystemConfig(systemConfig)){
				  Procedureinfo procedureInfo=new Procedureinfo();
				
				  procedureInfo.setuId(userInfo.getuId());
				  procedureInfo.setcId(carInfo.getcId());
				  String purchasetax=request.getParameter("buy");
				  procedureInfo.setPurchasetax(purchasetax);
				  String drivinglicense =request.getParameter("rad-a");
				  procedureInfo.setDrivinglicense(drivinglicense);
				  String ncw=request.getParameter("xczb");
				  procedureInfo.setNcw(ncw);
				  String registration =request.getParameter("rad-b");
				  procedureInfo.setRegistration(registration);
				  String newinvoice =request.getParameter("rad-c");
				  procedureInfo.setNewinvoice(newinvoice);
				  String key=request.getParameter("key");
				  procedureInfo.setKey(Integer.parseInt(key));
				  String transfertimes =request.getParameter("numm");
				  procedureInfo.setTransfertimes(Integer.parseInt(transfertimes));
				  String transgerticket =request.getParameter("ghp");
				  procedureInfo.setTransferticket(transgerticket);
				  if(procedureInfoService.updateProcedureInfo(procedureInfo)){
					  Sellinfo sellInfo=new Sellinfo();
					
					  sellInfo.setuId(userInfo.getuId());
					  sellInfo.setcId(carInfo.getcId());
					  String pricetype=request.getParameter("p-type");
					  sellInfo.setPricetype(pricetype);
					  String transferfee =request.getParameter("rad-d");
					  sellInfo.setTransferfee(transferfee);
					  String stage=request.getParameter("rad-f");
					  sellInfo.setStage(stage);
					  if(sellInfoService.updateSellInfo(sellInfo)){
						Imagesinfo carImagesInfo=new Imagesinfo();
						 
						  carImagesInfo.setuId(userInfo.getuId());
						  carImagesInfo.setcId(carInfo.getcId());
						  String image1=request.getParameter("ftp1");
						  if(image1!=null&&!image1.equals("")){
							  carImagesInfo.setImage1(image1);
						  }
						  String image2=request.getParameter("ftp2");
						  if(image2!=null&&!image2.equals("")){
							  carImagesInfo.setImage2(image2);
						  }
						  String image3=request.getParameter("ftp3");
						  if(image3!=null&&!image3.equals("")){
							  carImagesInfo.setImage3(image3);
						  }
						  String image4=request.getParameter("ftp4");
						  if(image4!=null&&!image4.equals("")){
							  carImagesInfo.setImage4(image4);
						  }
						  String image5=request.getParameter("ftp5");
						  if(image5!=null&&!image5.equals("")){
							  carImagesInfo.setImage5(image5);
						  }
						  String image6=request.getParameter("ftp6");
						  if(image6!=null&&!image6.equals("")){
							  carImagesInfo.setImage6(image6);
						  }
						  String image7=request.getParameter("ftp7");
						  if(image7!=null&&!image7.equals("")){
							  carImagesInfo.setImage7(image7);
						  }
						  String image8=request.getParameter("ftp8");
						  if(image8!=null&&!image8.equals("")){
							  carImagesInfo.setImage8(image8);
						  }
						  String image9=request.getParameter("ftp9");
						  if(image9!=null&&!image9.equals("")){
							  carImagesInfo.setImage9(image9);
						  }
						  String image10=request.getParameter("ftp10");
						  if(image10!=null&&!image10.equals("")){
							  carImagesInfo.setImage10(image10);
						  }
						  if(carImagesInfoService.updateCarImagesInfo(carImagesInfo)){
							  request.setAttribute("xiaoxi", "修改成功,请进入<a href='MemberCenter_showmenberbjj.action'>会员中心-我的车-审核未通过的车再次提交吧</a>");
							
							
								
						  }
					  }
				  }
			  }
			}
		  }
		}
		
		 return "redirect:/CarInfo_showshdea.action?uid="+userInfo.getuId()+"&cid="+carInfo.getcId()+"";
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "ERROR";
			}
		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showdea.action")
	public String showdea(HttpSession session,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			String cid=		request.getParameter("cid");
			String uid=		request.getParameter("uid");
			
				
	        return "redirect:/CarInfo_showshdea.action?uid="+uid+"&cid="+cid+"";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_upmc.action")
	public String upmc(HttpSession session,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Carinfo carInfo=new Carinfo();
			carInfo.setuId(chekUser(session).getuId());
			carInfo.setcId(Long.parseLong(request.getParameter("cid")));
			
			Carinfo _carInfo=carInfoService.getCarByWhere(carInfo).get(carInfo.getcId());
			request.setAttribute("car", _carInfo);

	Basicinfo basicInfo= basicInfoService.getAllBasicById(carInfo);
	request.setAttribute("bas", basicInfo); 

	 Hardwareconfig hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
	 request.setAttribute("hard", hardwareConfig); 
	 
	 
	 Systemconfig systemConfig= systemConfigService.getSystemConfigById(carInfo);
	 request.setAttribute("sys", systemConfig);

	 Sellinfo sellInfo= sellInfoService.getSellInfoById(carInfo);
	 request.setAttribute("sell", sellInfo); 

	 Procedureinfo procedureInfo=  procedureInfoService.getProcedureInfoById(carInfo);
	 request.setAttribute("proce", procedureInfo); 
	 
	Map<Integer, String> imgMap= carImagesInfoService.getCarImagesInfoByID(carInfo); 
	for(Integer key:imgMap.keySet()){
		request.setAttribute("k"+key.toString(), imgMap.get(key));
	}


	        return "admin/upcarinfo";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_comment.action")
	public String comment(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			
			Personneed personNeed=new Personneed();
			personNeed.setuId(chekUser(session).getuId());
			String p_brand=new String(request.getParameter("sel1").getBytes("ISO8859-1"),"UTF-8");
			String p_series=new String(request.getParameter("ccx").getBytes("ISO8859-1"),"UTF-8");
			String p_age=new String(request.getParameter("ccxi").getBytes("ISO8859-1"),"UTF-8");
			String p_price=new String(request.getParameter("cprice").getBytes("ISO8859-1"),"UTF-8");
			String p_time=new String(request.getParameter("buytime").getBytes("ISO8859-1"),"UTF-8");
			String p_miaoshu=new String(request.getParameter("content").getBytes("ISO8859-1"),"UTF-8");
			personNeed.setpAge(p_age);
			personNeed.setpBrand(p_brand);
	        personNeed.setpMiaoshu(p_miaoshu);
	        personNeed.setpPrice(p_price);
	     
	        personNeed.setpTime(p_time);
	        personNeed.setpSeries(p_series);
	        personNeed.setpState("处理中");
	      
	        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    Date date=new Date();
		   personNeed.setpTjtime( dateFormat.format(date));
		  String message=null;
		 
		  if(personNeedService.getPerSonNeed(personNeed)==null){
		  if(personNeedService.addPersonNeed(personNeed)){
			  message="恭喜：提交成功,进入会员中心—我的需求-私人定制看看吧";
		  }
		  else{
			  message="抱歉：发生了一个错误";
		  }
		}
		  else{
			  message="请不要重复提交";
		  }
		  response.getWriter().print(message);
		  response.getWriter().flush();//清空缓存,刷新
		  response.getWriter().close();
	        return null;

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_showsrdz.action")
	public String showsrdz(HttpSession session,HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Personneed personNeed=new Personneed();
			personNeed.setuId(chekUser(session).getuId());
			this.fenyepn(request,  personNeed);
			DbUtil.closeAll();
			
	        return "admin/memberMySr";

		}
		else{
			return "forward:/CarInfo.action";
		}
	}
	@RequestMapping("/MemberCenter_liuyan.action")
	public String liuyan(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(chekUser(session)!=null){
			Comment1 comment=new Comment1();
			comment.setuId(chekUser(session).getuId());
			comment.setcText(new String(request.getParameter("text").getBytes("iso8859-1"),"UTF-8"));
			DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    Date date=new Date();
		  comment.setcDate( dateFormat.format(date));
		    if(commentServiceImpl.addComment(comment)){
		    	response.setContentType("text/html;charset=utf-8");
				 response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				 response.getWriter().close();
		    
		    }
	        return null;

		}
		else{
			return "forward:/CarInfo.action";
		}
	}


	   private Userinfo3 chekUser(HttpSession session){
		   Userinfo3 userinfo=null;
			Object object = session.getAttribute("userinfo");
			if(object!=null){
				userinfo=(Userinfo3) object;
			}
		   return userinfo;
	   }
	   private void fenye(HttpServletRequest req, Personcar perSonCar){
			
			
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	  
		 long maxRowsCount=personCarPage.queryPersonCarCount(perSonCar);
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
			
			
			Map<Long, Object> carMap=personCarPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), perSonCar);
			DbUtil.closeAll();
			Map<Long, Carinfo> _carMap=new HashMap<Long, Carinfo>();
			for(Long key:carMap.keySet()){
				Carinfo _carInfo=(Carinfo) carMap.get(key);
			_carMap.put(_carInfo.getcId() ,_carInfo);
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
	private void fenyepn(HttpServletRequest req, Personneed personNeed){
			
			
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	  
		 long maxRowsCount=personNeedPage.queryPersonCarCount(personNeed);
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
			
			
			Map<Long, Object> carMap=personNeedPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), personNeed);
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
		private void finishop(HttpServletRequest req,Personcar perSonCar,Userinfo3 userInfo,Carinfo carInfo){
			String uid=req.getParameter("uid");
			String cid=req.getParameter("cid");
			
			perSonCar.setuId(userInfo.getuId());
			perSonCar.setcUid(Long.parseLong(uid));
			perSonCar.setcId(Long.parseLong(cid));
			if(carInfo!=null){
			carInfo.setcId(Long.parseLong(cid));
			carInfo.setuId(Long.parseLong(uid));
			}
		}

		

}
