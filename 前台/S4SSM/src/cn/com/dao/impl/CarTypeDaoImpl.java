package cn.com.dao.impl;

import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class CarTypeDaoImpl extends BaseDao implements ICarTypeDao {

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

}
