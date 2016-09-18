package cn.com.dao.impl;

import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 车型操作实现类
 * @author
 */
@Repository
public class CarTypeDaoImpl extends BaseDao implements ICarTypeDao {
        /**
	 * 按热度获取车型信息的方法
	 * @return Map<Integer,CarType>
	 */
	@Override
	public Map<Integer, Cartype> getCarTypeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		
  carTypeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CartypeMapper.getCarTypeByCount", "tId");
		return carTypeMap;
	}
        /**
	 * 获取所有车型信息的方法
	 * @return  Map<Integer,CarType>
	 */
	@Override
	public Map<Integer, Cartype> getAllCarType() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		carTypeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CartypeMapper.getAllCarType", "tId");
		return carTypeMap;
	}

}
