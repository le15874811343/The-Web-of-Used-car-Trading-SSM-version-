package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 车龄信息操作实现类
 *@author  lej 
 */
@Repository
public class CarAgeDaoImpl extends BaseDao implements ICarAgeDao{
        /**
	 * 按热度获取车龄信息的方法
	 * @return Map<Integer,Carage>
	 */
	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Carage> carAgeMap=new HashMap<Integer, Carage>();
	//获取结果集
	  carAgeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarageMapper.getCarAgeByCount",  "aId");
	
		return carAgeMap;
	}

}
