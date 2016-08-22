package cn.com.dao.impl;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;
@Repository
public class EmissionstandardDaoImpl extends BaseDao implements IEmissionstandardDao {

	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Emissionstandard> emissionstandardMap=new HashMap<Integer, Emissionstandard>();
		
		emissionstandardMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.EmissionstandardMapper.getEmissionstandardByCount", "eId");
		return emissionstandardMap;
	}

}
