package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;

@Repository
public class DistanceDaoImpl extends BaseDao implements IDistanceDao {

	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Distance> distanceMap = new HashMap<Integer, Distance>();

	 distanceMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.DistanceMapper.getDistanceByCount", "dId");
		return distanceMap;
	}

}
