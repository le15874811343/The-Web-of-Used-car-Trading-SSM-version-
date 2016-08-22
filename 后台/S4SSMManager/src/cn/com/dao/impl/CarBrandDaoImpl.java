package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class CarBrandDaoImpl extends BaseDao implements ICarBrandDao,IPageDao {

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
		_carBrand=	 (Carbrand) super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.getBrandByID", carBrand,"bId").get(carBrand.getbId());
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

	@Override
	public int addCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.CarbrandMapper.insertSelective", carBrand);
	}

	@Override
	public int updateCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().update("cn.com.pojo.CarbrandMapper.updateCarBrand", carBrand);
	}

	@Override
	public int deleteCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.CarbrandMapper.deleteCarBrand", carBrand);
	}

	@Override
	public Long queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=(long) 0;
		List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.CarbrandMapper.queryPersonCarCount");
		if(clist.size()>0){
			count=clist.get(0);
		}
			return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
Map<String, Object> parmas=new HashMap<String, Object>();
		
		parmas.put("curPage", curPage);
		parmas.put("rowsPrePage", rowsPrePage);
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.showPersonCarList", parmas, "bId");
		return brandMap;
	}
 
}
