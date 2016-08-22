package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;

import java.util.*;

import org.springframework.stereotype.Repository;


@Repository
public class CarInfoDaoImpl extends BaseDao implements ICarInfoDao,IPageDao{

	
	
	public Map<Long, Carinfo> getCarInfoByCountDesc(Carinfo _carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByCountDesc", _carInfo,"cId");
       
		
		 return carInfoMap;
	}
;
	
	public Map<Long, Carinfo> getCarInfoByBrandCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByBrandCountDesc", carInfo,"cId");

		
		 return carInfoMap;
	}


	public Map<Long, Carinfo> getCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoBySjTime", carInfo,"cId");

		 return carInfoMap;
	}

	
	public Map<Long, Carinfo> getFourthCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getFourthCarInfoBySjTime", carInfo,"cId");

		 return carInfoMap;
	}


	public Map<Long, Carinfo> getCarInfoByTypeCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
	
		
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByTypeCountDesc", carInfo,"cId");

		 return carInfoMap;
	}

	
	public Map<Long, Carinfo> getCarInfoByBrand(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
	
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByBrand", carInfo,"cId");

		 return carInfoMap;
	}

	
	public Map<Long, Carinfo> getCarInfoByType(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();
		
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarInfoByType", carInfo,"cId");

		 return carInfoMap;
	}

	
	public Map<Long, Carinfo> getCarByWhere(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Map<Long, Carinfo> carInfoMap=new HashMap<Long, Carinfo>();

		
		carInfoMap=     super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.getCarByWhere", carInfo,"cId");

		
		 return carInfoMap;
	}


	public Long queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		Long count=null;
		Carinfo carInfo=(Carinfo)object;
		
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

	
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		List<Object>  carMap=new ArrayList<Object>();
		Carinfo carInfo=(Carinfo) object;
		// TODO Auto-generated method stub
		
	
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

	
	public int updateCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
	count=		super.getSqlSessionTemplate().update("cn.com.pojo.CarinfoMapper.updateByPrimaryKeySelective", carInfo);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	
	public int addCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
		int count=0;
	   try{
		 super.getSqlSessionTemplate().insert("cn.com.pojo.CarinfoMapper.insertSelective", carInfo);
		   count=1;
	   }
	   catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
		
		return count;
	}

	
	public Carinfo getCarInfoByUMN(Carinfo carInfo) {
		// TODO Auto-generated method stub
	
		
		Carinfo _carInfo=null;
	_carInfo=	(Carinfo) super.getSqlSessionTemplate().selectList("cn.com.pojo.CarinfoMapper.getCarInfoByUMN", carInfo).get(0);
		return _carInfo;
	}


	public int updateCarAll(Carinfo carInfo) {
		// TODO Auto-generated method stub
		 
		
		return super.getSqlSessionTemplate().update("cn.com.pojo.CarinfoMapper.updateByPrimaryKeySelective", carInfo);
	}

	
	public int deletecarinfouser(Carinfo u) {
		// TODO Auto-generated method stub
		
	 int count=0;
	 try{
		super.getSqlSessionTemplate().delete("cn.com.pojo.CarinfoMapper.deletecarinfouser", u);
		 count=1;
	 }
	 catch (Exception e) {
		// TODO: handle exception
	}
		return count;
	}

	
	public int deletecarinfo(Carinfo c) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			 super.getSqlSessionTemplate().delete("cn.com.pojo.CarinfoMapper.deleteByPrimaryKey", c);
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
			return count;
	}


	public boolean checkcarinfouser(Carinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
	
	 if(	super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarinfoMapper.checkcarinfouser", c, "cId").size()>0){
		 flag=true;
	 }
	 
		return flag;
	}


	
	@Override
	public List<Carinfo> getTenBrandCar(Carinfo carInfo) {
		// TODO Auto-generated method stub
	       List<Carinfo> _carMap=new ArrayList<Carinfo>();
	       _carMap=    super.getSqlSessionTemplate().selectList("cn.com.pojo.CarinfoMapper.getTenBrandCar", carInfo);
			return _carMap;
	}


	@Override
	public List<Carinfo> getTenCount(Carinfo carInfo) {
		// TODO Auto-generated method stub
		 List<Carinfo> _carMap=new ArrayList<Carinfo>();
	       _carMap=    super.getSqlSessionTemplate().selectList("cn.com.pojo.CarinfoMapper.getTenCount", carInfo);
			return _carMap;
	}
  
}
