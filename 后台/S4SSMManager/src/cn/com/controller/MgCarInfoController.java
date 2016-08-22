package cn.com.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dao.*;
import cn.com.pojo.*;

import cn.com.service.*;

import cn.com.service.impl.*;

import cn.com.util.*;

@Controller
public class MgCarInfoController {
	@Resource
	private ICarInfoService carInfoService=null;
	@Resource(name="carInfoServiceImpl")
	private IPageDao carInfoPage=null;
	@Resource
	private ICarBrandService  brandServiceImpl=null;
	@Resource
  private	IPerSonCarService personCarServiceImpl=null;
	@Resource
  private HardwareConfigServiceImpl hardwareConfigServiceImpl=null;
	@Resource
  private	ProcedureInfoServiceImpl procedureInfoServiceImpl=null;
	@Resource
  private	SystemConfigServiceImpl systemConfigServiceImpl=null;
	@Resource
  private	SellInfoServiceImpl sellInfoServiceImpl=null;
	@Resource
  private	CarImagesInfoServiceImpl carImagesInfoServiceImpl=null;
	@Resource
  private	BasicInfoServiceImpl basicInfoServiceImpl=null;
	public ICarInfoService getCarInfoService() {
		return carInfoService;
	}
	public void setCarInfoService(ICarInfoService carInfoService) {
		this.carInfoService = carInfoService;
	}
	public IPageDao getCarInfoPage() {
		return carInfoPage;
	}
	public void setCarInfoPage(IPageDao carInfoPage) {
		this.carInfoPage = carInfoPage;
	}
	public ICarBrandService getBrandServiceImpl() {
		return brandServiceImpl;
	}
	public void setBrandServiceImpl(ICarBrandService brandServiceImpl) {
		this.brandServiceImpl = brandServiceImpl;
	}
	public IPerSonCarService getPersonCarServiceImpl() {
		return personCarServiceImpl;
	}
	public void setPersonCarServiceImpl(IPerSonCarService personCarServiceImpl) {
		this.personCarServiceImpl = personCarServiceImpl;
	}
	public HardwareConfigServiceImpl getHardwareConfigServiceImpl() {
		return hardwareConfigServiceImpl;
	}
	public void setHardwareConfigServiceImpl(
			HardwareConfigServiceImpl hardwareConfigServiceImpl) {
		this.hardwareConfigServiceImpl = hardwareConfigServiceImpl;
	}
	public ProcedureInfoServiceImpl getProcedureInfoServiceImpl() {
		return procedureInfoServiceImpl;
	}
	public void setProcedureInfoServiceImpl(
			ProcedureInfoServiceImpl procedureInfoServiceImpl) {
		this.procedureInfoServiceImpl = procedureInfoServiceImpl;
	}
	public SystemConfigServiceImpl getSystemConfigServiceImpl() {
		return systemConfigServiceImpl;
	}
	public void setSystemConfigServiceImpl(
			SystemConfigServiceImpl systemConfigServiceImpl) {
		this.systemConfigServiceImpl = systemConfigServiceImpl;
	}
	public SellInfoServiceImpl getSellInfoServiceImpl() {
		return sellInfoServiceImpl;
	}
	public void setSellInfoServiceImpl(SellInfoServiceImpl sellInfoServiceImpl) {
		this.sellInfoServiceImpl = sellInfoServiceImpl;
	}
	public CarImagesInfoServiceImpl getCarImagesInfoServiceImpl() {
		return carImagesInfoServiceImpl;
	}
	public void setCarImagesInfoServiceImpl(
			CarImagesInfoServiceImpl carImagesInfoServiceImpl) {
		this.carImagesInfoServiceImpl = carImagesInfoServiceImpl;
	}
	public BasicInfoServiceImpl getBasicInfoServiceImpl() {
		return basicInfoServiceImpl;
	}
	public void setBasicInfoServiceImpl(BasicInfoServiceImpl basicInfoServiceImpl) {
		this.basicInfoServiceImpl = basicInfoServiceImpl;
	}
	@RequestMapping("/MgCar_showlist.action")
	public String showlist(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		fenye(request,  carInfo);
	
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		
		return "admin/allproduct";
	}
	@RequestMapping("/MgCar_showzs.action")
	public String showzs(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("在售");
		fenye(request, carInfo);
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		
		return "admin/zaishouproduct";
	}
	@RequestMapping("/MgCar_showsh.action")
	public String showsh(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("审核中");
		fenye(request,carInfo);
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
	
	
		return "admin/shproduct";
	}
	@RequestMapping("/MgCar_showxj.action")
	public String showxj(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("下架");
		fenye(request, carInfo);
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		
		return "admin/xjproduct";
	}
	@RequestMapping("/MgCar_showwtg.action")
	public String showwtg(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("未通过");
		fenye(request, carInfo);
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		
		return "admin/wtgproduct";
	}
	@RequestMapping("/MgCar_showwhere.action")
	public String showwhere(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		if(cx!=null&&!cx.equals("")){
			carInfo.setcSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setcBrand(pp);
		}
		
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
		
		return "admin/allproduct";
	}
	@RequestMapping("/MgCar_showzswhere.action")
	public String showzswhere(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("在售");
		if(cx!=null&&!cx.equals("")){
			carInfo.setcSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setcBrand(pp);
		}
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
	
		return "admin/zaishouproduct";
	}
	@RequestMapping("/MgCar_showshwhere.action")
	public String showshwhere(HttpServletRequest request) throws Exception {
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("审核中");
		if(cx!=null&&!cx.equals("")){
			carInfo.setcSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setcBrand(pp);
		}
		
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
	

		
		return "admin/shproduct";
	}
	@RequestMapping("/MgCar_showxjwhere.action")
	public String showxjwhere(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("下架");
		if(cx!=null&&!cx.equals("")){
			carInfo.setcSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setcBrand(pp);
		}
		
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
		

		return "admin/xjproduct";
	}
	@RequestMapping("/MgCar_showwtgwhere.action")
	public String showwtgwhere(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("未通过");
		if(cx!=null&&!cx.equals("")){
			carInfo.setcSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setcBrand(pp);
		}
		
	
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
	

		return "admin/wtgproduct";
	}
	@RequestMapping("/MgCar_jjtg.action")
	public void jjtg(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String cid=request.getParameter("cid");
		String uid=request.getParameter("uid");
		
		
		Personcar perSonCar=new Personcar();
		perSonCar.setcId(Long.parseLong(cid));
		perSonCar.setuId(Long.parseLong(uid));
		perSonCar.setcUid(Long.parseLong(uid));
		perSonCar.setpState("审核中");
	
		
		Carinfo carInfo=new Carinfo();
		carInfo.setcId(Long.parseLong(cid));
		carInfo.setcState("未通过");
		
		if(personCarServiceImpl.updatePerSoncar(perSonCar, "未通过")&&carInfoService.updateCarInfo(carInfo)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		
	}
	@RequestMapping("/MgCar_yxtg.action")
	public void yxtg(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String cid=request.getParameter("cid");
		String uid=request.getParameter("uid");
		
		
		Personcar perSonCar=new Personcar();
		perSonCar.setcId(Long.parseLong(cid));
		perSonCar.setuId(Long.parseLong(uid));
		perSonCar.setcUid(Long.parseLong(uid));
		perSonCar.setpState("审核中");
		
	
		String newprice=request.getParameter("newprice");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setcId(Long.parseLong(cid));
		carInfo.setcState("在售");
		carInfo.setNewprice(Double.parseDouble(newprice));
		
		if(personCarServiceImpl.updatePerSoncar(perSonCar, "出售")&&carInfoService.updateCarInfo(carInfo)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		
	}
	@RequestMapping("/MgCar_dellcar.action")
	public void dellcar(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String cid=request.getParameter("cid");
	
		
		Hardwareconfig hardwareConfig=new Hardwareconfig();
		hardwareConfig.setcId(Long.parseLong(cid));
		if(hardwareConfigServiceImpl.deletecidhardwareconfiguser(hardwareConfig)){
			Procedureinfo procedureInfo=new Procedureinfo();
			procedureInfo.setcId(Long.parseLong(cid));
			
			if(procedureInfoServiceImpl.deletecidprocedureinfouser(procedureInfo)){
				Systemconfig systemConfig=new Systemconfig();
				systemConfig.setcId(Long.parseLong(cid));
			
				if(systemConfigServiceImpl.deletecidsystemconfiguser(systemConfig)){
					Sellinfo sellInfo=new Sellinfo();
					sellInfo.setcId(Long.parseLong(cid));
				
					if(sellInfoServiceImpl.deletecidsellinfouser(sellInfo)){
						Imagesinfo carImagesInfo=new Imagesinfo();
						carImagesInfo.setcId(Long.parseLong(cid));
					
						if(carImagesInfoServiceImpl.deletecidimagesinfouser(carImagesInfo)){
							Basicinfo basicInfo=new Basicinfo();
							basicInfo.setcId(Long.parseLong(cid));
							
							if(basicInfoServiceImpl.deletecidbasicinfo(basicInfo)){
								Carinfo carInfo=new Carinfo();
								carInfo.setcId(Long.parseLong(cid));
							
								if(carInfoService.deletecarinfo(carInfo)){
									Personcar perSonCar=new Personcar();
									perSonCar.setcId(Long.parseLong(cid));
								
									if(personCarServiceImpl.deletecidpersoncaruser(perSonCar)){
										 response.setContentType("text/html;charset=utf-8");
											response.getWriter().print(1);
											 response.getWriter().flush();//清空缓存,刷新
											   response.getWriter().close();
									}
								}
							}
						}
					}
				}
			}
		}
		
		
		
		
		
	
		
	}
	
	private void fenye(HttpServletRequest req,Carinfo carInfo){
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		//设置距离参数
		String distance=null;
		if(req.getParameter("distance")!=null){
			distance = new String(req.getParameter("distance").getBytes("ISO8859-1"),"utf-8");
			}
	   Map<String, Integer> distanceMap=setDistance(distance);
		//设置价格参数
	   String price = null;
		if(req.getParameter("price")!=null){
			price = new String(req.getParameter("price").getBytes("ISO8859-1"),"utf-8");
		}
      Map<String, Integer> priceMap=setPrice(price);
      //设置车龄参数
      String age = null;
		if(req.getParameter("age")!=null){
			age = new String(req.getParameter("age").getBytes("ISO8859-1"),"utf-8");
		}
		
    Map<String, Integer> ageMap=setAge(age);
    if(req.getParameter("bname")!=null&&!req.getParameter("bname").equals("")){
    	carInfo.setcBrand(new String(req.getParameter("bname").getBytes("ISO8859-1"),"utf-8"));
    }	
	 if(req.getParameter("cser")!=null&&!req.getParameter("cser").equals("")){
		 carInfo.setcSeries(new String(req.getParameter("cser").getBytes("ISO8859-1"),"utf-8"));
	 }	
	 if(req.getParameter("tname")!=null&&!req.getParameter("tname").equals("")){
		 carInfo.setcType(new String(req.getParameter("tname").getBytes("ISO8859-1"),"utf-8"));
	 }
	 if(req.getParameter("emsi")!=null&&!req.getParameter("emsi").equals("")){
		 carInfo.setcEmissionstandard(new String(req.getParameter("emsi").getBytes("ISO8859-1"),"utf-8"));
	 }
	 long maxRowsCount=carInfoPage.queryMsgCount(carInfo,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(7, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		String order=null;
		String _order=req.getParameter("order");
		if(_order!=null&&!_order.equals("")){
			order=_order;
		}
		
		List<Object> carMap=carInfoPage.showMsgInfoList(pageUtil.getCurPage(), pageUtil.getRowsPrePage(), carInfo,order,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
		DbUtil.closeAll();
		List<Object> _carMap=new ArrayList<Object>();
		for(Object o:carMap){
		Carinfo _carInfo=(Carinfo) o;
		_carMap.add( _carInfo);
		}
		req.setAttribute("bname", carInfo.getcBrand());
		req.setAttribute("tname", carInfo.getcType());
		req.setAttribute("cser", carInfo.getcSeries());
		req.setAttribute("order", order);
		req.setAttribute("age", age);
		req.setAttribute("price", price);
		req.setAttribute("distance", distance);
		req.setAttribute("emsi", carInfo.getcEmissionstandard());
		req.setAttribute("carMap", _carMap);
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
	 private Map<String, Integer> setDistance(String distance){
		   Map<String, Integer> distanceMap=new HashMap<String, Integer>();
	    DistanceUtil distanceUtil=null;
	    int minDis=0;
	    int maxDis=0;
		if(distance!=null&&!distance.equals("")){
			 distanceUtil=new DistanceUtil(distance);
			 minDis=distanceUtil.getMinDis();
			 maxDis=distanceUtil.getMaxDis();
		}
		  distanceMap.put("minDis", Integer.valueOf(minDis));
		  distanceMap.put("maxDis", Integer.valueOf(maxDis));
  	   return distanceMap;
     }
     /**
      * 设置价格参数的方法
      * @param price
      * @return
      */
     private Map<String, Integer> setPrice(String price){
		   Map<String, Integer> priceMap=new HashMap<String, Integer>();
  	   PriceUtil priceUtil=null;
  	    int minPrice=0;
  	    int maxPrice=0;
  		
  		if(price!=null&&!price.equals("")){
  			priceUtil=new PriceUtil(price);
  			minPrice=priceUtil.getMinPrice();
  			maxPrice=priceUtil.getMaxPrice();
  		}
  		priceMap.put("minPrice", Integer.valueOf(minPrice));
  		priceMap.put("maxPrice", Integer.valueOf(maxPrice));
  		return priceMap;
     }
     /**
      * 设置车龄参数的方法
      * @param age
      * @return
      */
     private Map<String, Integer> setAge(String age){
  	   Map<String, Integer> ageMap=new HashMap<String, Integer>();
  	   CarAgeUtil ageUtil=null;
  	    int minAge=0;
  	    int maxAge=0;
  		
  		if(age!=null&&!age.equals("")){
  			ageUtil=new CarAgeUtil(age);
  			minAge=ageUtil.getMinAge();
  			maxAge=ageUtil.getMaxAge();
  		}
  		ageMap.put("minAge", Integer.valueOf(minAge));
  		ageMap.put("maxAge", Integer.valueOf(maxAge));
  		return ageMap;
     }

}
