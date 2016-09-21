package cn.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.dao.*;
import cn.com.pojo.*;

import cn.com.service.*;

import cn.com.util.*;

/**
 * 各项参数管理控制器
 * 
 */
@Controller
public class ModelController {
	@Resource
	 private IModelService modelService=null; //车系信息服务接口的引用
	@Resource
	 private  ICarBrandService brandServiceImpl=null; //汽车品牌服务接口的引用
	@Resource(name="carBrandServiceImpl")
	  private IPageDao brandPage=null;  //分页处理操作接口的引用（指向汽车品牌信息操作实现类）
	  @Resource
	  private  ICarAgeService ageServiceImpl=null; //车龄信息服务接口的引用
	  @Resource(name="carAgeServiceImpl")
	  private IPageDao carAgePage=null;  //分页处理操作接口的引用（指向车龄信息操作实现类）
	  @Resource
	  private IPriceIntervalService priceIntervalServiceImpl=null; //车价信息服务接口的引用
	  @Resource(name="priceIntervalServiceImpl")
	  private  IPageDao  pricePage=null; //分页处理操作接口的引用（指向车价信息操作实现类）
	  @Resource
	  private  IDistanceService distanceService=null; //行驶距离信息服务接口的引用
	  @Resource(name="distanceServiceImpl")
	  private IPageDao distancePage=null; //分页处理操作接口的引用（指向行驶距离信息操作实现类）
	  @Resource
	  private IEmissionstandardService emissionstandardService=null; //排放标准服务接口的引用
	  @Resource(name="emissionstandardServiceImpl")
	  private IPageDao  emisPage=null; //分页处理操作接口的引用（指向排放标准信息操作实现类）
	  @Resource
	  private ICarTypeService carTypeService=null; //车型服务接口的引用
	  @Resource(name="carTypeServiceImpl")
	  private IPageDao carTypePage=null;  //分页处理操作接口的引用（指向车型信息操作实现类）
	public IModelService getModelService() {
		return modelService;
	}
	public void setModelService(IModelService modelService) {
		this.modelService = modelService;
	}
	public ICarBrandService getBrandServiceImpl() {
		return brandServiceImpl;
	}
	public void setBrandServiceImpl(ICarBrandService brandServiceImpl) {
		this.brandServiceImpl = brandServiceImpl;
	}
	public IPageDao getBrandPage() {
		return brandPage;
	}
	public void setBrandPage(IPageDao brandPage) {
		this.brandPage = brandPage;
	}
	public ICarAgeService getAgeServiceImpl() {
		return ageServiceImpl;
	}
	public void setAgeServiceImpl(ICarAgeService ageServiceImpl) {
		this.ageServiceImpl = ageServiceImpl;
	}
	public IPageDao getCarAgePage() {
		return carAgePage;
	}
	public void setCarAgePage(IPageDao carAgePage) {
		this.carAgePage = carAgePage;
	}
	public IPriceIntervalService getPriceIntervalServiceImpl() {
		return priceIntervalServiceImpl;
	}
	public void setPriceIntervalServiceImpl(
			IPriceIntervalService priceIntervalServiceImpl) {
		this.priceIntervalServiceImpl = priceIntervalServiceImpl;
	}
	public IPageDao getPricePage() {
		return pricePage;
	}
	public void setPricePage(IPageDao pricePage) {
		this.pricePage = pricePage;
	}
	public IDistanceService getDistanceService() {
		return distanceService;
	}
	public void setDistanceService(IDistanceService distanceService) {
		this.distanceService = distanceService;
	}
	public IPageDao getDistancePage() {
		return distancePage;
	}
	public void setDistancePage(IPageDao distancePage) {
		this.distancePage = distancePage;
	}
	public IEmissionstandardService getEmissionstandardService() {
		return emissionstandardService;
	}
	public void setEmissionstandardService(
			IEmissionstandardService emissionstandardService) {
		this.emissionstandardService = emissionstandardService;
	}
	public IPageDao getEmisPage() {
		return emisPage;
	}
	public void setEmisPage(IPageDao emisPage) {
		this.emisPage = emisPage;
	}
	public ICarTypeService getCarTypeService() {
		return carTypeService;
	}
	public void setCarTypeService(ICarTypeService carTypeService) {
		this.carTypeService = carTypeService;
	}
	public IPageDao getCarTypePage() {
		return carTypePage;
	}
	public void setCarTypePage(IPageDao carTypePage) {
		this.carTypePage = carTypePage;
	}
   /**
    * 品牌车系二级联动操作action
    */
	@RequestMapping("/Model.action")
	public void execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int b_id=Integer.parseInt(request.getParameter("brand"));
		Model model=new Model();
		model.setbId(b_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	  
	 
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	  response.setContentType("text/html;charset=utf-8");
	  response.getWriter().println(jsonArray);
	  response.getWriter().flush();//清空缓存,刷新
	  response.getWriter().close();
	  
	}
        /**
	 * 展示车系详情操作action
	 */
	@RequestMapping("/Model_getDea.action")
	public void getDea(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		Model model=new Model();
		model.setmId(s_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	  
	 
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	   response.setContentType("text/html;charset=utf-8");
	   response.getWriter().println(jsonArray);
	   response.getWriter().flush();//清空缓存,刷新
	   response.getWriter().close();
		 
	}
	/**
	 * 展示品牌操作action
	 */
	@RequestMapping("/Model_showbrand.action")
	public String showbrand(HttpServletRequest request) throws Exception {
		 Carbrand carBrand=new Carbrand();
		
	        this.fenye(request, carBrand);
	       
		 return "admin/brand";
	}
	/**
	 * 展示车龄信息操作action
	 */
	@RequestMapping("/Model_showage.action")
	public String showage(HttpServletRequest request) throws Exception {
		Carage carAge=new Carage();
		this.fenyeage(request, carAge);
		
		 return "admin/age";
	}
	/**
	 * 展示车型信息操作action
	 */
	@RequestMapping("/Model_showtype.action")
	public String showtype(HttpServletRequest request) throws Exception {
		Cartype carType=new Cartype();
		this.fenyeety(request, carType);
		
		 return "admin/type";
	}
	/**
	 * 展示行驶距离信息操作action
	 */
	@RequestMapping("/Model_showdistance.action")
	public String showdistance(HttpServletRequest request) throws Exception {
		Distance distance=new Distance();
		this.fenyedis(request, distance);
      
		 return "admin/distance";
	}
	/**
	 * 展示排放标准操作action
	 */
	@RequestMapping("/Model_showemsi.action")
	public String showemsi(HttpServletRequest request) throws Exception {
		 Emissionstandard emissionstandard=new Emissionstandard();
		 this.fenyeemsi(request, emissionstandard);
       
		 return "admin/emsi";
	}
	/**
	 * 展示价格区间操作action
	 */
	@RequestMapping("/Model_showprice.action")
	public String showprice(HttpServletRequest request) throws Exception {
		Priceinterval priceInterval=new Priceinterval();
		this.fenyeprice(request, priceInterval);
      
		 return "admin/price";
	}
	/**
	 * 展示车系操作action
	 */
	@RequestMapping("/Model_showseries.action")
	public String showseries(HttpServletRequest request) throws Exception {
		
		Map<Integer, Carbrand> brandMap=	brandServiceImpl.getAllBrand();
		request.setAttribute("allbrand", brandMap);
		
		 return "admin/series";
	}
	/**
	 * 请求增加车系操作action
	 */
	@RequestMapping("/Model_addseries.action")
	public String addseries(HttpServletRequest request) throws Exception {
	
		Map<Integer, Carbrand> brandMap=	brandServiceImpl.getAllBrand();
		request.setAttribute("allbrand", brandMap);
		
		 return "admin/series-add";
	}
	/**
	 * //增加品牌操作action
	 */
	@RequestMapping("/Model_addbrand.action")
	public String addbrand(HttpServletRequest request) throws Exception {
		
        String bname=request.getParameter("maxAge");
        String bcount=request.getParameter("count");
        String bimg=request.getParameter("ttp");
        String zm=request.getParameter("zm");
        Carbrand carBrand=new Carbrand();
           carBrand.setbName(bname);
           carBrand.setbCount(new Long(0));
           carBrand.setbImg("");
           carBrand.setbSzm(zm.toUpperCase());
        if(bimg!=null&&!bimg.equals("")){
          carBrand.setbImg("tepimages/"+bimg);
        }
        if(bcount!=null&&!bcount.equals("")){
            carBrand.setbCount(Long.parseLong(bcount));
          }
        if(brandServiceImpl.addCarBrand(carBrand)){
        	
        	request.setAttribute("meag", "添加成功");
        	
        }
		 return "admin/brand-add";
	}
	/**
	 * 请求修改品牌操作action
	 */
	@RequestMapping("/Model_upbrand.action")
	public String upbrand(HttpServletRequest request,HttpSession session) throws Exception {
		String bid=request.getParameter("bid");
		Carbrand brand=new Carbrand();
		brand.setbId(Long.parseLong(bid));
	
	
 Carbrand carBrand=		brandServiceImpl.getBrandByID(brand);
		
		session.setAttribute("brand", carBrand);

		 return "redirect:/admin/brand-up.jsp";
	}
	/**
	 * 提交修改品牌action
	 */
	@RequestMapping("/Model_tjupbr.action")
	public String tjupbr(HttpServletRequest request,HttpSession session) throws Exception {
		
		String bid=request.getParameter("bid");
        String bname=request.getParameter("maxAge");
        String bcount=request.getParameter("count");
        String bimg=request.getParameter("ttp");
        String zm=request.getParameter("zm");
        Carbrand carBrand=new Carbrand();
           carBrand.setbName(bname);
           carBrand.setbCount(new Long(0));
           carBrand.setbImg(request.getParameter("qtp"));
           carBrand.setbSzm(zm.toUpperCase());
           carBrand.setbId(Long.parseLong(bid));
        if(bimg!=null&&!bimg.equals("")){
    
        	
          carBrand.setbImg("tepimages/"+bimg);
        }
        if(bcount!=null&&!bcount.equals("")){
            carBrand.setbCount(Long.parseLong(bcount));
          }
        if(brandServiceImpl.updateCarBrand(carBrand)){
        	
        	session.setAttribute("upbrand", "修改成功");
        	session.setAttribute("brand", carBrand);
        	
        }
		 return "redirect:/admin/brand-up.jsp";
	}
	/**
	 * 删除品牌操作action
	 */
	@RequestMapping("/Model_delbrand.action")
	public void delbrand(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		String bid=request.getParameter("bid");
		 Carbrand carBrand=new Carbrand();
		 carBrand.setbId(Long.parseLong(bid));
		 if(brandServiceImpl.deleteCarBrand(carBrand)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		 }
		
	}
	/**
	 * 提交增加车系操作action
	 */
	@RequestMapping("/Model_addser.action")
	public String addser(HttpServletRequest request) throws Exception {
		String bid=request.getParameter("cpp");
		String sname=request.getParameter("name");
		Model model=new Model();
		model.setbId(Integer.parseInt(bid));
		model.setmName(sname);
		
		if(modelService.addModel(model)){
			request.setAttribute("mea", "添加成功");
		
		}
		 return "admin/series-add";
	}
	/**
	 * 请求修改车系操作action
	 */
	@RequestMapping("/Model_upser.action")
	public String upser(HttpServletRequest request) throws Exception {
		String mid=request.getParameter("mid");
		Model model=new Model();
		model.setmId(Integer.parseInt(mid));
	List<Model>  m=	modelService.getModelByWhere(model);
	request.setAttribute("model", m.get(0));
	
	Map<Integer, Carbrand> brandMap=	brandServiceImpl.getAllBrand();
	request.setAttribute("allbrand", brandMap);
	
		 return "admin/series-up";
	}
	/**
	 * 提交车系修改action
	 */
	@RequestMapping("/Model_tjupser.action")
	public String tjupser(HttpServletRequest request) throws Exception {
		String mid=request.getParameter("mid");
		String bid=request.getParameter("cpp");
		String sname=request.getParameter("name");
		Model model=new Model();
		model.setbId(Integer.parseInt(bid));
		model.setmName(sname);
		model.setmId(Integer.parseInt(mid.trim()));
		if(modelService.updateModel(model)){
			
			Map<Integer, Carbrand> brandMap=	brandServiceImpl.getAllBrand();
			request.setAttribute("allbrand", brandMap);
			request.setAttribute("model", model);
			request.setAttribute("mea", "修改成功");
			
		}
		 return "admin/series-up";
	}
	/**
	 * 删除车系action
	 */
	@RequestMapping("/Model_delser.action")
	public void delser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String mid=request.getParameter("mid");
		Model model=new Model();
		model.setmId(Integer.parseInt(mid.trim()));
		if(modelService.deleteModel(model)){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(1);
			 response.getWriter().flush();//清空缓存,刷新
			   response.getWriter().close();
		}
		 
	}
	/**
	 * 加车龄信息action
	 */
	@RequestMapping("/Model_addage.action")
	public String addage(HttpServletRequest request) throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		Carage carAge=new Carage();
		carAge.setaName(aname);
		carAge.setaCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 carAge.setaCount(Long.parseLong(acount));
              }
		
		 if(ageServiceImpl.addCarAge(carAge)){
			 request.setAttribute("mea", "添加成功");
				
		 }
		 return "admin/age-add";
	}
	/**
	 *请求修改车龄信息 action
	 */
	@RequestMapping("/Model_upage.action")
	public String upage(HttpServletRequest request) throws Exception {
		String a_id=request.getParameter("aid");
		Carage carAge=new Carage();
		carAge.setaId(Long.parseLong(a_id));
		
	Carage age=	ageServiceImpl.getCarAgeById(carAge);
	request.setAttribute("age", age);
	
		 return "admin/age-up";
	}
	/**
	 * 提交修改车龄信息action
	 */
	@RequestMapping("/Model_tjupage.action")
	public String tjupage(HttpServletRequest request) throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		String a_id=request.getParameter("aid");
		Carage carAge=new Carage();
		carAge.setaId(Long.parseLong(a_id));
		carAge.setaName(aname);
		carAge.setaCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 carAge.setaCount(Long.parseLong(acount));
              }
		

			if(ageServiceImpl.updateCarAge(carAge)){
				request.setAttribute("age", carAge);
				request.setAttribute("mea", "修改成功");
			
			
			}
		 return "admin/age-up";
	}
	/**
	 * 删除车龄信息action
	 */
	@RequestMapping("/Model_delage.action")
	public void delage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String aid=request.getParameter("aid");
		Carage carAge=new Carage();
		carAge.setaId(Long.parseLong(aid.trim()));
	
		if(ageServiceImpl.deleteCarAge(carAge)){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(1);
			 response.getWriter().flush();//清空缓存,刷新
			   response.getWriter().close();
		}
		
	}
	/**
	 * 增加价格区间信息action
	 */
	@RequestMapping("/Model_addprice.action")
	public String addprice(HttpServletRequest request) throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		Priceinterval priceInterval=new Priceinterval();
		priceInterval.setpName(aname);
		priceInterval.setpCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 priceInterval.setpCount(Long.parseLong(acount));
              }
		
		 if(priceIntervalServiceImpl.addPriceInterval(priceInterval)){
			 request.setAttribute("mea", "添加成功");
				
		 }
		 return "admin/price-add";
	}
	/**
	 * 请求修改价格区间信息action
	 */
	@RequestMapping("/Model_upprice.action")
	public String upprice(HttpServletRequest request) throws Exception {
		String pid=request.getParameter("pid");
		Priceinterval priceInterval=new Priceinterval();
		priceInterval.setpId(Long.parseLong(pid));
		

	Priceinterval interval=	 priceIntervalServiceImpl.getPriceIntervalById(priceInterval);
	request.setAttribute("price", interval);

		 return "admin/price-up";
	}
	/**
	 * 提交修改价格区间action
	 */
	@RequestMapping("/Model_tjupprice.action")
	public String tjupprice(HttpServletRequest request) throws Exception {
		String pid=request.getParameter("pid");
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		Priceinterval priceInterval=new Priceinterval();
		priceInterval.setpId(Long.parseLong(pid));
		priceInterval.setpName(aname);
		priceInterval.setpCount((long) 0);
		 if(acount!=null&&!acount.equals("")){
			 priceInterval.setpCount(Long.parseLong(acount));
              }
		
   if(priceIntervalServiceImpl.updatePriceInterval(priceInterval)){
	   request.setAttribute("mea", "修改成功");
	   request.setAttribute("price", priceInterval);
		
   }
		 return "admin/price-up";
	}
	/**
	 * 删除价格区间action
	 */
	@RequestMapping("/Model_delprice.action")
	public void delprice(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String pid=request.getParameter("pid");
		Priceinterval priceInterval=new Priceinterval();
		priceInterval.setpId(Long.parseLong(pid.trim()));
		
if(priceIntervalServiceImpl.deletePriceInterval(priceInterval)){
	response.setContentType("text/html;charset=utf-8");
	response.getWriter().print(1);
	 response.getWriter().flush();//清空缓存,刷新
	   response.getWriter().close();
} 
	
	}
	/**
	 * 添加行驶距离action
	 */
	@RequestMapping("/Model_adddis.action")
	public String adddis(HttpServletRequest request) throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		Distance distance=new Distance();
		distance.setdName(aname);
		distance.setdCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 distance.setdCount(Long.parseLong(acount));
              }
		
		 if(distanceService.addDistance(distance)){
			 request.setAttribute("mea", "添加成功");
			
		 }
		 return "admin/distance-add";
	}
	/**
	 * 请求修改行驶距离action
	 */
	@RequestMapping("/Model_updis.action")
	public String updis(HttpServletRequest request) throws Exception {
		String did=request.getParameter("did");
		Distance distance=new Distance();
		distance.setdId(Long.parseLong(did.trim()));
		
	Distance dis=	distanceService.getDistanceById(distance);
	  request.setAttribute("distance", dis);
	 
		 return "admin/distance-up";
	}
	/**
	 * 提交修改行驶距离action
	 */
	@RequestMapping("/Model_tjupdis.action")
	public String tjupdis(HttpServletRequest request) throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		String did=request.getParameter("did");
		Distance distance=new Distance();
		distance.setdId(Long.parseLong(did.trim()));
		distance.setdName(aname);
		distance.setdCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 distance.setdCount(Long.parseLong(acount));
              }
		
		 if(distanceService.updateDistance(distance)){
			 request.setAttribute("mea", "修改成功");
			 request.setAttribute("distance", distance);
			
		 }
		 return "admin/distance-up";
	}
	/**
	 * 删除行驶距离action
	 */
	@RequestMapping("/Model_deldis.action")
	public void deldis(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String did=request.getParameter("did");
		Distance distance=new Distance();
		distance.setdId(Long.parseLong(did.trim()));
		

		 if(distanceService.deleteDistance(distance)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		 }
		
	}
	/**
	 * 添加排放标准action
	 */
	@RequestMapping("/Model_addemsi.action")
	public String addemsi(HttpServletRequest request) throws Exception {
		String name=request.getParameter("name");
		String acount=request.getParameter("count");
		Emissionstandard emissionstandard=new Emissionstandard();
		emissionstandard.seteName(name);
		emissionstandard.seteCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 emissionstandard.seteCount(Long.parseLong(acount));
              }
		
		 if(emissionstandardService.addEmissionstandard(emissionstandard)){
			 request.setAttribute("mea", "添加成功");
			
		 }
		 return "admin/emsi-add";
	}
	/**
	 * 请求修改排放标准action
	 */
	@RequestMapping("/Model_upemsi.action")
	public String upemsi(HttpServletRequest request) throws Exception {
		String eid=request.getParameter("eid");
		Emissionstandard emissionstandard=new Emissionstandard();
		emissionstandard.seteId(Long.parseLong(eid));
		
   Emissionstandard emsi=   emissionstandardService.getEmissionstandard(emissionstandard);
   request.setAttribute("emsi", emsi);
	
		 return "admin/emsi-up";
	}
	/**
	 * 提交排放标准修改action
	 */
	@RequestMapping("/Model_tjemsi.action")
	public String tjemsi(HttpServletRequest request) throws Exception {
		String eid=request.getParameter("eid");
		String name=request.getParameter("name");
		String acount=request.getParameter("count");
		Emissionstandard emissionstandard=new Emissionstandard();
		emissionstandard.seteId(Long.parseLong(eid));
		emissionstandard.seteName(name);
		emissionstandard.seteCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 emissionstandard.seteCount(Long.parseLong(acount));
              }
		
	if(emissionstandardService.updateEmissionstandard(emissionstandard)){
		request.setAttribute("mea", "修改成功");
		request.setAttribute("emsi", emissionstandard);
	}
		 return "admin/emsi-up";
	}
	/**
	 * 删除排放标准action
	 */
	@RequestMapping("/Model_delemsi.action")
	public void delemsi(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String eid=request.getParameter("eid");
		Emissionstandard emissionstandard=new Emissionstandard();
		emissionstandard.seteId(Long.parseLong(eid));
		
       if(emissionstandardService.deleteEmissionstandard(emissionstandard)){
    	   response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(1);
			 response.getWriter().flush();//清空缓存,刷新
			   response.getWriter().close();
       }
		
	}
	/**
	 * 添加车型action
	 */
	@RequestMapping("/Model_addtype.action")
	public String addtype(HttpServletRequest request) throws Exception {
		 String bname=request.getParameter("maxAge");
         String bcount=request.getParameter("count");
         String bimg=request.getParameter("ttp");
         Cartype carType=new Cartype();
         carType.settName(bname);
         carType.settCount(new Long(0));
         carType.settClass("");
         carType.settImg("");
         if(bimg!=null&&!bimg.equals("")){
         	carType.settClass("tepimages/"+bimg);
           }
           if(bcount!=null&&!bcount.equals("")){
         	  carType.settCount(Long.parseLong(bcount));
          }
        
        if(  carTypeService.addCarType(carType)){
        	request.setAttribute("mea", "添加成功");
     	  
        }
		 return "admin/type-add";
	}
	/**
	 * 请求修改车型action
	 */
	@RequestMapping("/Model_uptype.action")
	public String uptype(HttpServletRequest request,HttpSession session) throws Exception {
		  String tid=request.getParameter("tid");
		   Cartype carType=new Cartype();
		   carType.settId(Long.parseLong(tid));
		  
		  Cartype _cartype=  carTypeService.getCarType(carType);
		  session.setAttribute("upcartype", _cartype);
		 
		 return "redirect:/admin/type-up.jsp";
	}
	/**
	 * 提交修改车型action
	 */
	@RequestMapping("/Model_tjuptype.action")
	public String tjuptype(HttpServletRequest request,HttpSession session) throws Exception {
		 String tid=request.getParameter("tid");
		 String bname=request.getParameter("maxAge");
            String bcount=request.getParameter("count");
            String bimg=request.getParameter("ttp");
		   Cartype carType=new Cartype();
		   carType.settId(Long.parseLong(tid));
		   carType.settName(bname);
            carType.settCount(new Long(0));
            carType.settClass(request.getParameter("qtp"));
            if(bcount!=null&&!bcount.equals("")){
            	  carType.settCount(Long.parseLong(bcount));
             }
            if(bimg!=null&&!bimg.equals("")){
              
                     carType.settClass("tepimages/"+bimg);
                   }
		  
		   if(carTypeService.updateType(carType)){
			   session.setAttribute("upcartype", carType);
			   session.setAttribute("upbrand", "修改成功");
			 
		   }
		   return "redirect:/admin/type-up.jsp";
	}
	/**
	 * 删除车型action
	 */
	@RequestMapping("/Model_deltype.action")
	 public void deltype(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String tid=request.getParameter("tid");
		 Cartype carType=new Cartype();
		   carType.settId(Long.parseLong(tid));
		  
   if(carTypeService.deleteCarType(carType)){
	   response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(1);
		 response.getWriter().flush();//清空缓存,刷新
		   response.getWriter().close();
   }
	 }
        /**
	 * 分页展示品牌的方法
	 * 
	 */
	private void fenye(HttpServletRequest req,Carbrand carBrand){
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	   
		 long maxRowsCount=brandPage.queryPersonCarCount(carBrand);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=brandPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carBrand);
			
			DbUtil.closeAll();
			Map<Long, Carbrand> _brandMap=new HashMap<Long, Carbrand>();
			for(Long key:trendsMap.keySet()){
				Carbrand _carBrand=(Carbrand) trendsMap.get(key);
				_brandMap.put(_carBrand.getbId(),_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示车龄的方法
	 * 
	 */
	private void fenyeage(HttpServletRequest req,Carage carAge){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	  
		 long maxRowsCount=carAgePage.queryPersonCarCount(carAge);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=carAgePage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carAge);
			DbUtil.closeAll();
			Map<Long, Carage> _brandMap=new HashMap<Long, Carage>();
			for(Long key:trendsMap.keySet()){
				Carage _carBrand=(Carage) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getaId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示价格区间的方法
	 * 
	 */
	private void fenyeprice(HttpServletRequest req, Priceinterval priceInterval){
		
	
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	  
		 long maxRowsCount=pricePage.queryPersonCarCount(priceInterval);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=pricePage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), priceInterval);
			DbUtil.closeAll();
			Map<Long, Priceinterval> _brandMap=new HashMap<Long, Priceinterval>();
			for(Long key:trendsMap.keySet()){
				Priceinterval _carBrand=(Priceinterval) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getpId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示行驶距离的方法
	 * 
	 */
	private void fenyedis(HttpServletRequest req,Distance distance){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	 
		 long maxRowsCount=distancePage.queryPersonCarCount(distance);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=distancePage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), distance);
			DbUtil.closeAll();
			Map<Long, Distance> _brandMap=new HashMap<Long, Distance>();
			for(Long key:trendsMap.keySet()){
				Distance _carBrand=(Distance) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getdId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示排放标准的方法
	 * 
	 */
	private void fenyeemsi(HttpServletRequest req, Emissionstandard emissionstandard){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			

		 long maxRowsCount=emisPage.queryPersonCarCount(emissionstandard);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=emisPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), emissionstandard);
			DbUtil.closeAll();
			Map<Long, Emissionstandard> _brandMap=new HashMap<Long, Emissionstandard>();
			for(Long key:trendsMap.keySet()){
				Emissionstandard _carBrand=(Emissionstandard) trendsMap.get(key);
				_brandMap.put((long) _carBrand.geteId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示车型的方法
	 * 
	 */
	private void fenyeety(HttpServletRequest req,Cartype carType){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			

		 long maxRowsCount=carTypePage.queryPersonCarCount(carType);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=carTypePage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carType);
			DbUtil.closeAll();
			Map<Long, Cartype> _brandMap=new HashMap<Long, Cartype>();
			for(Long key:trendsMap.keySet()){
				Cartype _carBrand=(Cartype) trendsMap.get(key);
				_brandMap.put((long) _carBrand.gettId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
