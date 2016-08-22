package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class CarBrandDaoImpl extends BaseDao implements ICarBrandDao {

	@Override
	public Map<Integer, Carbrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
	   Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
	   carBrandMap= super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.getCarBrandByCount", "bId");
	  return carBrandMap;
	}

	@Override
	public Map<Integer, Carbrand> getAllBrand() {
		// TODO Auto-generated method stub
		 Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
		 carBrandMap=	 super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.getAllBrand", "bId");
		  return carBrandMap;
	}

	@Override
	public Carbrand getBrandByID(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		try{
		_carBrand=	 (Carbrand) super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.getBrandByID", "bId").get(carBrand.getbId());
		}  
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return _carBrand;
	}

	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		try{
		
		_carBrand=	 (Carbrand) super.getSqlSessionTemplate().selectList("cn.com.pojo.CarbrandMapper.getBrandByName",carBrand).get(0);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  return _carBrand;
	}
 
}
