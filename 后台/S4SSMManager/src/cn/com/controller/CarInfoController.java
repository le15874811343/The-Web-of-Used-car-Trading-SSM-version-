package cn.com.controller;

import java.util.*;
import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.dao.*;
import cn.com.pojo.*;
import cn.com.service.*;
import cn.com.util.*;
/**
 * 汽车信息操作控制器
 * @author lej
 */
@Controller
public class CarInfoController {
	private Map<Integer, Priceinterval> priceMap = null; //车价区间集合
	private Map<Integer, Carbrand> showBrandMap = null; //名牌集合
	private Map<Integer, Cartype> showType = null; //热门车型集合
	private Map<Integer, Carage> ageMap = null;   //热门车龄集合
	public Map<Integer, Priceinterval> getPriceMap() {
		return priceMap;
	}
	public void setPriceMap(Map<Integer, Priceinterval> priceMap) {
		this.priceMap = priceMap;
	}
	public Map<Integer, Carbrand> getShowBrandMap() {
		return showBrandMap;
	}
	public void setShowBrandMap(Map<Integer, Carbrand> showBrandMap) {
		this.showBrandMap = showBrandMap;
	}
	public Map<Integer, Cartype> getShowType() {
		return showType;
	}
	public void setShowType(Map<Integer, Cartype> showType) {
		this.showType = showType;
	}
	public Map<Integer, Carage> getAgeMap() {
		return ageMap;
	}
	public void setAgeMap(Map<Integer, Carage> ageMap) {
		this.ageMap = ageMap;
	}
	@Resource
	private IDistanceService distanceService=null; //行驶距离服务接口的引用
	@Resource
	private   IEmissionstandardService emissionstandardService=null;  //排放标准服务接口的引用
	@Resource
	private IBasicInfoService basicInfoService=null;  //汽车基础信息服务的引用
	@Resource
	private   ICarImagesInfoService carImagesInfoService=null; //汽车图片信息服务接口的引用
	@Resource 
	private   IHardwareConfigService hardwareConfigService=null; //汽车硬件配置信息服务接口的引用
	@Resource
	private	IProcedureInfoService procedureInfoService=null; //手续服务接口的引用
	@Resource
	private	ISellInfoService sellInfoService=null; //销售信息服务接口的引用
	@Resource
	private	ISystemConfigService systemConfigService=null; //汽车系统配置服务接口的引用
	@Resource
	private ICarInfoService carInfoService = null;  //汽车概要信息服务接口的引用
	@Resource(name = "carInfoDaoImpl" )
	private IPageDao carPage = null; //分页处理操作接口引用
	@Resource
	private ICarBrandService carBrandService = null;  //品服务接口的引用
	@Resource
	private ICarTypeService carTypeService = null;  //车型服务接口的引用
	@Resource
	private ITrendsService trendsService = null; //公司动态消息服务接口的引用
	@Resource
	private IPriceIntervalService priceIntervalService = null; //价格区间消息服务接口的引用
	@Resource
	private ICarAgeService carAgeService = null; //车龄服务接口的引用
	@Resource
	private ICommentService commentService=null; //品牌服务接口的引用
	private Map<Integer, Carbrand> allBrandMap = null; //所有品牌集合
  /**
   *展示首页的请求
   */
	@RequestMapping("/CarInfo.action")
   public String show(HttpServletRequest request,HttpSession session){
	
		setOverAllUse(request);
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("在售");
		// 今日推荐
		Map<Long, Carinfo> showCarMap = carInfoService
				.getCarInfoByCountDesc(carInfo);
		DbUtil.closeAll();
		session.setAttribute("showcar", showCarMap);
		// 热销品牌下的热销车辆
		Map<Long, Carinfo> carMap = new HashMap<Long, Carinfo>();
		for (Integer key : showBrandMap.keySet()) {
			clerCarAtr(carInfo);
			carInfo.setcBrand(showBrandMap.get(key).getbName());
			Map<Long, Carinfo> brandCar = carInfoService
					.getCarInfoByBrandCountDesc(carInfo);

			DbUtil.closeAll();

			for (Long key1 : brandCar.keySet()) {
				carMap.put(key1, brandCar.get(key1));
			}
		}
	request.setAttribute("brandcar", carMap);
		// 最新到店
		Map<Long, Carinfo> newCarMap = carInfoService
				.getCarInfoBySjTime(carInfo);
		DbUtil.closeAll();
		request.setAttribute("newcar", newCarMap);
		Map<Long, Carinfo> fourthCarMap = carInfoService
				.getFourthCarInfoBySjTime(carInfo);
		DbUtil.closeAll();
		request.setAttribute("fourthcar", fourthCarMap);
//首字母菜单数据处理
		List<String> leftszm = new ArrayList<String>();
		List<String> rightszm = new ArrayList<String>();
		for (Integer key : allBrandMap.keySet()) {
			if (leftszm.size() < 9) {
				if (!leftszm.contains(allBrandMap.get(key).getbSzm())) {
					leftszm.add(allBrandMap.get(key).getbSzm());

				}
			} else {
				if (!leftszm.contains(allBrandMap.get(key).getbSzm())) {
					if (!rightszm.contains(allBrandMap.get(key).getbSzm())) {
						rightszm.add(allBrandMap.get(key).getbSzm());
					}

				}
			}
		}
		Collections.sort(leftszm);
		Collections.sort(rightszm);
		request.setAttribute("leftszm", leftszm);
	  request.setAttribute("rightszm", rightszm);
//热销车型下的车
		Map<Long, Carinfo> typeCarMap = new HashMap<Long, Carinfo>();
		for (Integer key : showType.keySet()) {
			clerCarAtr(carInfo);
			carInfo.setcType(showType.get(key).gettName());

			Map<Long, Carinfo> typeCar = carInfoService
					.getCarInfoByTypeCountDesc(carInfo);

			DbUtil.closeAll();
			for (Long key1 : typeCar.keySet()) {
				typeCarMap.put(key1, typeCar.get(key1));
			}
		}
		//评论信息
		Comment1 comment = new Comment1();
		comment.setcAdmin("首页展示");
	
	request.setAttribute("com1",
				commentService.getTheTowComment(comment, 0, 2));
	request.setAttribute("com2",
				commentService.getTheTowComment(comment, 2, 4));
	request.setAttribute("com3",
				commentService.getTheTowComment(comment,4, 6));
				//公司动态消息展示
		Trends trends = new Trends();
		trends.setTrType("指南");
		List<Trends> trendsList1 = trendsService.getITrendsByTime(trends, 6);
		session.setAttribute("zhinan", trendsList1);
		trends.setTrType("承诺");
		List<Trends> trendsList2 = trendsService.getITrendsByTime(trends, 6);
	  session.setAttribute("chennuo", trendsList2);
		trends.setTrType("活动");

		List<Trends> trendsList = trendsService.getITrendsByTime(trends, 5);
		for (int i = 0; i < trendsList.size(); i++) {
			request.setAttribute("active" + (i + 1) + "",
					trendsList.get(i));
		}
		trends.setTrType("新闻");

		List<Trends> newsList = trendsService.getITrendsByTime(trends, 11);
		List<Trends> news1 = new ArrayList<Trends>();
		List<Trends> news2 = new ArrayList<Trends>();
		for (int i = 0; i < newsList.size(); i++) {
			if (i < 5) {
				if (i == 0) {
					request.setAttribute("new1", newsList.get(i));
				}
				news1.add(newsList.get(i));
			} else {
				if (i == 5) {
			request.setAttribute("new6", newsList.get(i));
				}
				news2.add(newsList.get(i));
			}
		}
		request.setAttribute("news1", news1);
		request.setAttribute("news2", news2);
		request.setAttribute("typecar", typeCarMap);

	   return "index";
   }
        /**
	 * 展示买车菜单action
	 * 
	 */
	@RequestMapping("/CarInfo_showList.action")
	public String showList(HttpServletRequest request) {
		  Carinfo carInfo=new Carinfo();
		
		  setOverAllUse(request);
			clerCarAtr(carInfo);
			bindWhere(request);
			fenye(request,  carInfo);
		
		
		   return "maiche_list";
	   }
	    /**
	    * 车辆详情展示action
	    * 
	    */
	@RequestMapping("/CarInfo_showDetails.action")
	public String showDetails(HttpServletRequest request){
		 setOverAllUse(request);
		Carinfo carInfo=new Carinfo();
		Map<Long, Carinfo> detailsMap=getdea(request,  carInfo);
		Carinfo _carInfo=detailsMap.get(carInfo.getcId());
	
	  Map<Long, Carinfo> bcar=   carInfoService.getCarInfoByBrandCountDesc(_carInfo);
	  bcar.remove(_carInfo.getcId());
	  request.setAttribute("bcar", bcar);
	     _carInfo.setcCount(_carInfo.getcCount()+1);
	    if(carInfoService.updateCarInfo(_carInfo)){
	      return "maiche_show";
			}
	    else{
	    	return "error";
	    }
	
	}
	        /**
		 *审核中的车详情展示action
		 */
	@RequestMapping("/CarInfo_showshdea.action")
	public String showshdea(HttpServletRequest request){
		 setOverAllUse(request);
		Carinfo carInfo=new Carinfo();
		
		getdea(request, carInfo);
		return "admin/maiche_show";
	}
	        /**
		 *展示私人定制页面的action
		 */
	@RequestMapping("/CarInfo_showsrdz.action")
	public String showsrdz(HttpServletRequest request){
		setOverAllUse(request);
		return "admin/srdz";
	}
	        /**
		 * 进行车辆比较的action
		 * 
		 */
	@RequestMapping("/CarInfo_showCompare.action")
	public String showCompare(HttpServletRequest request,HttpSession session){
		 setOverAllUse(request);
		 Carinfo carInfo=new Carinfo();
			this.setID(request,  carInfo);
			Map<Long, Carinfo> detailsMap=carInfoService.getCarByWhere(carInfo);
			 DbUtil.closeAll();
		
				Basicinfo    basicInfo=   basicInfoService.getAllBasicById(carInfo);
	     DbUtil.closeAll();
	     Hardwareconfig   hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
	 DbUtil.closeAll();
	 Procedureinfo   procedureInfo= procedureInfoService.getProcedureInfoById(carInfo);
	 DbUtil.closeAll();
	 Systemconfig  systemConfig= systemConfigService.getSystemConfigById(carInfo);
	 DbUtil.closeAll();
	 Sellinfo sellInfo=sellInfoService.getSellInfoById(carInfo);
	 DbUtil.closeAll();
	 //从session中获取比较过的车的集合
       Object pareCar=   session.getAttribute("pareCarInfo");
       Object pareSys=   session.getAttribute("pareSystemConfig");
       Object pareSell=   session.getAttribute("pareSellInfo");
       Object pareHar=   session.getAttribute("pareHardwareConfig");
       Object parePro=   session.getAttribute("pareProcedureInfo");
       Object pareBas=   session.getAttribute("pareBasic");
        //创建进行比较的车的各种信息的集合，指向空引用
       Map<Integer, Carinfo> pareCarInfo=null;
       Map<Integer, Systemconfig> pareSystemConfig=null;
       Map<Integer, Sellinfo> pareSellInfo=null;
       Map<Integer, Hardwareconfig> pareHardwareConfig=null;
       Map<Integer, Procedureinfo> pareProcedureInfo=null;
       Map<Integer, Basicinfo> pareBasic=null;
       boolean flag=false;
       //如果之前没有进行比较，则直接将该车加入进比较集合
       if(pareCar==null){
           pareCarInfo=new HashMap<Integer, Carinfo>();
           pareCarInfo.put(1, detailsMap.get(carInfo.getcId()));
       }
       //如果之前进行过比较
       if(pareCar!=null){
       	       //新的比较集合指向之前比较的集合
           pareCarInfo=(Map<Integer, Carinfo>) pareCar;
       //判断集合中是否存在现在选中的车
         flag=  pareCarInfo.containsValue(detailsMap.get(carInfo.getcId()));
       //如果不存在，则按照不同的条件在比较集合中加入这辆车
         if(flag==false){
           if(pareCarInfo.size()==1){
           	 pareCarInfo.put(2, detailsMap.get(carInfo.getcId()));
           }
           else if(pareCarInfo.size()==2){
           	 pareCarInfo.put(3, detailsMap.get(carInfo.getcId()));
           }
           else{
           	pareCarInfo.put(1, pareCarInfo.get(2));
           	pareCarInfo.put(2, pareCarInfo.get(3));
           	 pareCarInfo.put(3, detailsMap.get(carInfo.getcId()));
           }
       }
       }
        //之后的操作与pareCar处相同
       if(pareSys==null){
           pareSystemConfig=new HashMap<Integer, Systemconfig>();
          pareSystemConfig.put(1, systemConfig);
       }
       if(pareSys!=null){
       	
       	pareSystemConfig=(Map<Integer, Systemconfig>) pareSys;
       	if(flag==false){
           if(pareSystemConfig.size()==1){
           	pareSystemConfig.put(2, systemConfig);
           }
           else if(pareSystemConfig.size()==2){
           	pareSystemConfig.put(3,systemConfig);
           }
           else{
           	pareSystemConfig.put(1, pareSystemConfig.get(2));
           	pareSystemConfig.put(2, pareSystemConfig.get(3));
           	pareSystemConfig.put(3, systemConfig);
           }
       	}
       }
       if(pareSell==null){
            pareSellInfo=new HashMap<Integer, Sellinfo>();
           pareSellInfo.put(1,sellInfo );
       }
       if(pareSell!=null){
       	
        pareSellInfo=(Map<Integer, Sellinfo>) pareSell;
        if(flag==false){
           if(pareSellInfo.size()==1){
           	pareSellInfo.put(2, sellInfo);
           }
           else if(pareSellInfo.size()==2){
           	pareSellInfo.put(3,sellInfo);
           }
           else{
           	pareSellInfo.put(1, pareSellInfo.get(2));
           	pareSellInfo.put(2, pareSellInfo.get(3));
           	pareSellInfo.put(3, sellInfo);
           }
       	}
       }
       if(pareHar==null){
          pareHardwareConfig=new HashMap<Integer, Hardwareconfig>();
           pareHardwareConfig.put(1, hardwareConfig);
       }
       if(pareHar!=null){
       
       	 pareHardwareConfig=(Map<Integer, Hardwareconfig>) pareHar;
       	 if(flag==false){
           if(pareHardwareConfig.size()==1){
           	pareHardwareConfig.put(2, hardwareConfig);
           }
           else if(pareHardwareConfig.size()==2){
           	pareHardwareConfig.put(3,hardwareConfig);
           }
           else{
           	pareHardwareConfig.put(1, pareHardwareConfig.get(2));
           	pareHardwareConfig.put(2, pareHardwareConfig.get(3));
           	pareHardwareConfig.put(3, hardwareConfig);
           
       	 }
       	}
       }
       if(parePro==null){
            pareProcedureInfo=new HashMap<Integer, Procedureinfo>();
           pareProcedureInfo.put(1, procedureInfo);
       }
       if(parePro!=null){
       	
       	 pareProcedureInfo=(Map<Integer, Procedureinfo>) parePro;
       	 if(flag==false){
           if(pareProcedureInfo.size()==1){
           	pareProcedureInfo.put(2, procedureInfo);
           }
           else if(pareProcedureInfo.size()==2){
           	pareProcedureInfo.put(3,procedureInfo);
           }
           else{
           	pareProcedureInfo.put(1, pareProcedureInfo.get(2));
           	pareProcedureInfo.put(2, pareProcedureInfo.get(3));
           	pareProcedureInfo.put(3, procedureInfo);
           
       	 }
       	}
       }
       if(pareBas==null){
            pareBasic=new HashMap<Integer, Basicinfo>();
           pareBasic.put(1, basicInfo);
       }
       if(pareBas!=null){
       	
       	 pareBasic=(Map<Integer, Basicinfo>) pareBas;
       	 if(flag==false){
           if(pareBasic.size()==1){
           	pareBasic.put(2, basicInfo);
           }
           else if(pareBasic.size()==2){
           	pareBasic.put(3,basicInfo);
           }
           else{
           	pareBasic.put(1, pareBasic.get(2));
           	pareBasic.put(2, pareBasic.get(3));
           	pareBasic.put(3, basicInfo);
           
       	 }
       	}
       }
       request.setAttribute("cid", carInfo.getcId());
       request.setAttribute("uid", carInfo.getuId());
       
       session.setAttribute("pareCarInfo", pareCarInfo);
       session.setAttribute("pareSystemConfig", pareSystemConfig);
       session.setAttribute("pareSellInfo", pareSellInfo);
       session.setAttribute("pareHardwareConfig", pareHardwareConfig);
       session.setAttribute("pareProcedureInfo", pareProcedureInfo);
       session.setAttribute("pareBasic", pareBasic);
    
		return "compareCar";
	}
	        /**
		 * 会员操作栏中的直接比较action，即获取session中的比较集合
		 * 
		 */
	@RequestMapping("/CarInfo_zjbj.action")
	public String zjbj(HttpServletRequest request,HttpSession session){
		 setOverAllUse(request);
		 Object pareCar=   session.getAttribute("pareCarInfo");
	        Object pareSys=   session.getAttribute("pareSystemConfig");
	        Object pareSell=   session.getAttribute("pareSellInfo");
	        Object pareHar=   session.getAttribute("pareHardwareConfig");
	        Object parePro=   session.getAttribute("pareProcedureInfo");
	        Object pareBas=   session.getAttribute("pareBasic");
	        Map<Long, Carinfo> car=(Map<Long, Carinfo>) pareCar;
	 Object[] cars=     car.values().toArray();
	 Carinfo _carInfo=(Carinfo) cars[cars.length-1];
	 
	 request.setAttribute("cid",_carInfo.getcId());
	 request.setAttribute("uid", _carInfo.getuId());
	        session.setAttribute("pareCarInfo", pareCar);
	         session.setAttribute("pareSystemConfig", pareSys);
	         session.setAttribute("pareSellInfo", pareSell);
	         session.setAttribute("pareHardwareConfig", pareHar);
	         session.setAttribute("pareProcedureInfo", parePro);
	         session.setAttribute("pareBasic", pareBas);
	    
		return "compareCar";
	}
	        /**
		 * /展示点击榜单的action
		 * 
		 */
	@RequestMapping("/CarInfo_djbd.action")
	public String djbd(HttpServletRequest request){
		 setOverAllUse(request);
		Carinfo carInfo=new Carinfo();
		carInfo.setcState("在售");
		 List<Carinfo>	tencar=	carInfoService.getTenCount(carInfo);
		 request.setAttribute("trends", tencar);
		
		return "count_list";
	}
	        /**
		 * 展示交易榜单的action
		 */
	@RequestMapping("/CarInfo_jybd.action")
	public String jybd(HttpServletRequest request){
		 setOverAllUse(request);
		Carinfo carinfo=new Carinfo();
		List<Carinfo>	tencar=	carInfoService.getTenBrandCar(carinfo);
		List<Carbrand> tenBrand=new ArrayList<Carbrand>();
		for(Carinfo c:tencar){
			Carbrand brand=new Carbrand();
		
			brand.setbName(c.getcBrand());
			tenBrand.add(carBrandService.getBrandByName(brand));
			
		}
		request.setAttribute("trends", tencar);
	request.setAttribute("tenBrand", tenBrand);
		
		return "jy_list";
	}
	
                /**
		 * 置空carinfo的属性
		 * 
		 * @param carInfo
		 */
	private void clerCarAtr(Carinfo carInfo) {
		carInfo.setcBrand(null);
		carInfo.setcType(null);
	}
      /**
       * 分页处理的方法
       * 
       * 
       */
		private void fenye(HttpServletRequest req, Carinfo carInfo){
			try {
				carInfo.setcState("在售");
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
		long maxRowsCount=carPage.queryMsgCount(carInfo,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
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
			
			List<Object> carMap=carPage.showMsgInfoList(pageUtil.getCurPage(), pageUtil.getRowsPrePage(), carInfo,order,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
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
		  /**
	        * 设置距离参数的方法
	        * @param distance
	        * @return
	        */
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
	       /**
	        * 设置两个ID的方法的方法
	        * @param req
	        * @param resp
	        * @param carInfo
	        */
	       private void setID(HttpServletRequest req,Carinfo carInfo){
	    	   long c_id=Long.parseLong(req.getParameter("cid"));
	    	   long u_id=Long.parseLong(req.getParameter("uid"));
	    		clerCarAtr(carInfo);
	    		carInfo.setcId(c_id);
	    		carInfo.setuId(u_id);
	       }
	 /**
	  * 绑定几个页面需要用到条件参数
	  * 
	  */
	       private  void bindWhere(HttpServletRequest req){
	    	   
	    	   Map<Integer, Distance> distanceMap= distanceService.getDistanceByCount();
	          DbUtil.closeAll();  
	    	  req.setAttribute("distanceMap", distanceMap);
	  Map<Integer,Emissionstandard> emisMap=emissionstandardService.getEmissionstandardByCount();
	    DbUtil.closeAll();
	    req.setAttribute("emisMap", emisMap);
	       }
      /**
       * 获取车辆详细信息的方法
       * @return Map<Long,CarInfo>
       */
	       private Map<Long, Carinfo> getdea(HttpServletRequest req,Carinfo carInfo){
	    		 
	    		    this.setID(req, carInfo);
	    	 
	    	 Map<Integer, String> carImagesInfo=      carImagesInfoService.getCarImagesInfoByID(carInfo);
	    	DbUtil.closeAll();
	    	req.setAttribute("carImagesInfo", carImagesInfo);
	    	Map<Long, Carinfo> detailsMap=carInfoService.getCarByWhere(carInfo);
	    	DbUtil.closeAll();
	    	req.setAttribute("detailsMap", detailsMap);
	    		Basicinfo    basicInfo=   basicInfoService.getAllBasicById(carInfo);
	    	DbUtil.closeAll();
	    	Hardwareconfig   hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
	    	DbUtil.closeAll();
	    	Procedureinfo   procedureInfo= procedureInfoService.getProcedureInfoById(carInfo);
	    	DbUtil.closeAll();
	    	Systemconfig  systemConfig= systemConfigService.getSystemConfigById(carInfo);
	    	DbUtil.closeAll();
	    	Sellinfo sellInfo=sellInfoService.getSellInfoById(carInfo);
	    	DbUtil.closeAll();
	    	req.setAttribute("cid", carInfo.getcId());
	    	req.setAttribute("uid", carInfo.getuId());
	    	req.setAttribute("sellInfo", sellInfo);
	    	 req.setAttribute("systemConfig", systemConfig);
	    	 req.setAttribute("procedureInfo", procedureInfo);
	    	  req.setAttribute("hardwareConfig", hardwareConfig);
	    	  req.setAttribute("basicInfo", basicInfo);
	    		  return detailsMap;
	    	  }
/**
 * 注入多个页面需要用到的条件数据
 * 
 */
	       private void setOverAllUse(HttpServletRequest request) {
	    	   this.setPriceMap(priceIntervalService.getPriceIntervalByCount());

	   		// 热销品牌
	   		this.setShowBrandMap(carBrandService.getCarBrandByCount());

	   		// 热销车型
	   		this.setShowType(carTypeService.getCarTypeByCount());

	   		// 热销车龄
	   		this.setAgeMap(carAgeService.getCarAgeByCount());
	   		// 热销价格
	    	   request.setAttribute("priceMap", this.priceMap);
	   		
	   		request.setAttribute("showType", this.showType);
	   	request.setAttribute("showBrandMap",this.showBrandMap);
	   	request.setAttribute("ageMap", this.ageMap);
	   		// 热销品牌
	  allBrandMap = carBrandService.getAllBrand();
	   	HttpSession session=request.getSession();
		DbUtil.closeAll();
		session.setAttribute("allbrand", allBrandMap);
	   	}

}
