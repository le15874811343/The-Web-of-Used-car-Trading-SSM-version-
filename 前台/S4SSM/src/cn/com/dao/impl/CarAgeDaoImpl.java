package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class CarAgeDaoImpl extends BaseDao implements ICarAgeDao{
  
	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Carage> carAgeMap=new HashMap<Integer, Carage>();
	
	  carAgeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarageMapper.getCarAgeByCount",  "aId");
	
		return carAgeMap;
	}

}
