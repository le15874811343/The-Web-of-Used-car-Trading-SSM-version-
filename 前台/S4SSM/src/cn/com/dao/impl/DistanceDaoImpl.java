package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;
/**
 * 行驶距离操作实现类
 *@author lej 
 */
@Repository
public class DistanceDaoImpl extends BaseDao implements IDistanceDao {
   /**
    * 
    * 按热度获取行驶距离信息的方法
    *@return Map<Integer,Distance> 
    */
	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Distance> distanceMap = new HashMap<Integer, Distance>();

	 distanceMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.DistanceMapper.getDistanceByCount", "dId");
		return distanceMap;
	}

}
