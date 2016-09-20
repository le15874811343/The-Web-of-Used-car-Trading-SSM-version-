package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;

import java.util.*;

import org.springframework.stereotype.Repository;

/**
 * 汽车概要信息操作实现类
 * @author lej
 */
@Repository
public class CarInfoDaoImpl extends BaseDao implements ICarInfoDao,IPageDao{

	
/**
 * 按热度获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */	
	public Map<Long, Carinfo> getCarInfoByCountDesc(Carinfo _carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		//获取结果集
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByCountDesc", _carInfo,"cId");
       
		
		 return carInfoMap;
	}
/**
 * 按热度和品牌获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */		
	public Map<Long, Carinfo> getCarInfoByBrandCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		//获取结果集
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByBrandCountDesc", carInfo,"cId");

		
		 return carInfoMap;
	}

/**
 * 按上架时间获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		//获取结果集
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoBySjTime", carInfo,"cId");
		 return carInfoMap;
	}

/**
 * 获取四辆最新上架的汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */		
	public Map<Long, Carinfo> getFourthCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		//获取结果集
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getFourthCarInfoBySjTime", carInfo,"cId");

		 return carInfoMap;
	}

 /**
 * 按热度和车型获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	public Map<Long, Carinfo> getCarInfoByTypeCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
	
		//获取结果集
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByTypeCountDesc", carInfo,"cId");

		 return carInfoMap;
	}

/**
 * 按品牌获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */	
	public Map<Long, Carinfo> getCarInfoByBrand(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
	//获取结果集
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByBrand", carInfo,"cId");

		 return carInfoMap;
	}

/**
 * 按车型获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */		
	public Map<Long, Carinfo> getCarInfoByType(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		//获取结果集
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByType", carInfo,"cId");

		 return carInfoMap;
	}

/**
 * 按条件获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */	
	public Map<Long, Carinfo> getCarByWhere(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();

		//获取结果集
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarByWhere", carInfo,"cId");

		
		 return carInfoMap;
	}

/**
 * 获取符合条件的汽车概要信息记录条数
 * @parma minPrice   最小价格
 * @parma maxPrice  最大价格
 * @parma minDis   最小距离
 * @parma maxDis  最大距离
 * @parma minAge  最小车龄
 * @parma maxAge  最大车龄
 * @return   Map<Long, CarInfo>
 */
	public Long queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		Long count=null;
		Carinfo carInfo=(Carinfo)object;
		//参数准备
		Map<String,Object> params=new HashMap<String, Object>();
		if(carInfo.getcBrand()!=null){
		
			params.put("cBrand", carInfo.getcBrand());
		}
		if(carInfo.getcSeries()!=null){
			
			params.put("cSeries",carInfo.getcSeries());
		}
		if(carInfo.getcType()!=null){
			
			params.put("cType",carInfo.getcType());
		}
		if(carInfo.getcState()!=null){
		
			params.put("cState",carInfo.getcState());
		}
		if(carInfo.getcEmissionstandard()!=null){
			
			params.put("cEmissionstandard",carInfo.getcEmissionstandard());
		}
		if(minPrice!=0){
		
			params.put("minPrice", minPrice);
		}
		if(maxPrice!=0){
		
			params.put("maxPrice", maxPrice);
		}
		if(minDis!=0){
		
			params.put("minDis", minDis);
		}
		if(maxDis!=0){
		
			params.put("maxDis", maxDis);
		}
		if(minAge!=0){
	
			params.put("minAge", minAge);
		}
		if(maxAge!=0){
		
			params.put("maxAge", maxAge);
		}
	count=    (Long) super.getSqlSessionTemplate().selectList("cn.com.pojo.CarinfoMapper.queryMsgCount", params).get(0);
	return count;
	}

/**
 * 获取符合条件的汽车概要信息
 * @parma minPrice   最小价格
 * @parma maxPrice  最大价格
 * @parma minDis   最小距离
 * @parma maxDis  最大距离
 * @parma minAge  最小车龄
 * @parma maxAge  最大车龄
 * @parma curPage   当前页
 * @parma rowsPrePage   页面展示条数
 * @return   Map<Long, CarInfo>
 */		
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		List<Object>  carMap=new ArrayList<Object>();
		Carinfo carInfo=(Carinfo) object;
		// TODO Auto-generated method stub
		
	        //参数准备
		Map<String,Object> params=new HashMap<String, Object>();
		if(carInfo.getcBrand()!=null){
		
			params.put("cBrand", carInfo.getcBrand());
		}
		if(carInfo.getcSeries()!=null){
			
			params.put("cSeries",carInfo.getcSeries());
		}
		if(carInfo.getcType()!=null){
			
			params.put("cType",carInfo.getcType());
		}
		if(carInfo.getcState()!=null){
		
			params.put("cState",carInfo.getcState());
		}
		if(carInfo.getcEmissionstandard()!=null){
			
			params.put("cEmissionstandard",carInfo.getcEmissionstandard());
		}
		if(minPrice!=0){
		
			params.put("minPrice", minPrice);
		}
		if(maxPrice!=0){
		
			params.put("maxPrice", maxPrice);
		}
		if(minDis!=0){
		
			params.put("minDis", minDis);
		}
		if(maxDis!=0){
		
			params.put("maxDis", maxDis);
		}
		if(minAge!=0){
	
			params.put("minAge", minAge);
		}
		if(maxAge!=0){
		
			params.put("maxAge", maxAge);
		}
		if(order!=null){
			params.put("order", order);
			
			
		}
		params.put("curPage", curPage);
		params.put("rowsPrePage", rowsPrePage);
	 
		carMap= super.getSqlSessionTemplate().selectList("cn.com.pojo.CarinfoMapper.showMsgInfoList", params);
	
		return carMap;
	}

	
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}

  /**
   * 修改汽车概要信息的方法
   * @parma carInfo
   * @return int
   */	
	public int updateCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
			//修改
	count=		super.getSqlSessionTemplate().update("cn.com.pojo.CarinfoMapper.updateByPrimaryKeySelective", carInfo);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

 /**
   * 添加汽车概要信息的方法
   * @parma carInfo
   * @return int
   */	
	public int addCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
		int count=0;
	   try{
	   	//添加
		 super.getSqlSessionTemplate().insert("cn.com.pojo.CarinfoMapper.insertSelective", carInfo);
		   count=1;
	   }
	   catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
		
		return count;
	}

/**
 * 按唯一条件获取汽车概要信息的方法
 * @parma carInfo
 * @return   CarInfo
 */	
	public Carinfo getCarInfoByUMN(Carinfo carInfo) {
		// TODO Auto-generated method stub
	
		
		Carinfo _carInfo=null;
		//获取结果
	_carInfo=	(Carinfo) super.getSqlSessionTemplate().selectList("cn.com.pojo.CarinfoMapper.getCarInfoByUMN", carInfo).get(0);
		return _carInfo;
	}

  /**
   * 修改汽车所有概要信息的方法
   * @parma carInfo
   * @return int
   */
	public int updateCarAll(Carinfo carInfo) {
		// TODO Auto-generated method stub
		 
		//返回受影响的行数
		return super.getSqlSessionTemplate().update("cn.com.pojo.CarinfoMapper.updateByPrimaryKeySelective", carInfo);
	}

  /**
   * 根据用户编号删除汽车概要信息
   * @parma carInfo
   * @return int
   */	
	public int deletecarinfouser(Carinfo u) {
		// TODO Auto-generated method stub
		
	 int count=0;
	 try{
		super.getSqlSessionTemplate().delete("cn.com.pojo.CarinfoMapper.deletecarinfouser", u);//删除
		 count=1;
	 }
	 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
		return count;
	}

  /**
   * 根据汽车编号删除汽车概要信息
   * @parma carInfo
   * @return int
   */		
	public int deletecarinfo(Carinfo c) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			 super.getSqlSessionTemplate().delete("cn.com.pojo.CarinfoMapper.deleteByPrimaryKey", c);//删除
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
			return count;
	}

  /**
   * 检查某用户编号是否有与其相关的汽车概要信息
   * @parma carInfo
   * @return int
   */
	public boolean checkcarinfouser(Carinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
	
	 if(	super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.checkcarinfouser", c, "cId").size()>0){
		 flag=true; //若返回结果集合size大于0.则返回为真
	 }
	 
		return flag;
	}


  /**
   * 获取热度最高的10辆车
   * @parma carInfo
   * @return List<CarInfo>
   */	
	@Override
	public List<Carinfo> getTenBrandCar(Carinfo carInfo) {
		// TODO Auto-generated method stub
	       List<Carinfo> _carMap=new ArrayList<Carinfo>();
	        //获取结果集
	       _carMap=    super.getSqlSessionTemplate().selectList("cn.com.pojo.CarinfoMapper.getTenBrandCar", carInfo);
			return _carMap;
	}

  /**
   * 获取销量最高10个品牌
   * @parma carInfo
   * @return List<CarInfo>
   */
	@Override
	public List<Carinfo> getTenCount(Carinfo carInfo) {
		// TODO Auto-generated method stub
		 List<Carinfo> _carMap=new ArrayList<Carinfo>();
		 //获取结果集
	       _carMap=    super.getSqlSessionTemplate().selectList("cn.com.pojo.CarinfoMapper.getTenCount", carInfo);
			return _carMap;
	}
  
}
