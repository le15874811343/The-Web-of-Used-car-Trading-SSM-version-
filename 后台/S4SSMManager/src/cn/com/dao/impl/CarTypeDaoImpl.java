package cn.com.dao.impl;

import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class CarTypeDaoImpl extends BaseDao implements ICarTypeDao,IPageDao {

	@Override
	public Map<Integer, Cartype> getCarTypeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		
  carTypeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CartypeMapper.getCarTypeByCount", "tId");
		return carTypeMap;
	}

	@Override
	public Map<Integer, Cartype> getAllCarType() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		carTypeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CartypeMapper.getAllCarType", "tId");
		return carTypeMap;
	}

	@Override
	public int addCarType(Cartype carType) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.CartypeMapper.insertSelective", carType);
	}

	@Override
	public int deleteCarType(Cartype carType) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.CartypeMapper.deleteCarType", carType);
	}

	@Override
	public int updateType(Cartype carType) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().update("cn.com.pojo.CartypeMapper.updateType", carType);
	}

	@Override
	public Cartype getCarType(Cartype carType) {
		// TODO Auto-generated method stub
		Cartype _Cartype=null;
	List<Cartype> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.CartypeMapper.getCarType",carType);
	if(clist.size()>0){
		_Cartype=clist.get(0);
	}
		return _Cartype;
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
		List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.CartypeMapper.queryPersonCarCount");
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
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CartypeMapper.showPersonCarList", parmas, "tId");
		return brandMap;
	}

}
