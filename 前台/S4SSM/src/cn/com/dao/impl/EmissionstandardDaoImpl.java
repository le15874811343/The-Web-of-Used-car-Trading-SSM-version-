package cn.com.dao.impl;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;
/**
 * 
 * 排放标准操作实现类
 *@author  lej
 */
@Repository
public class EmissionstandardDaoImpl extends BaseDao implements IEmissionstandardDao {
        /**
	 * 按热度获取排放标准信息的方法
	 * @Map<Integer,Emissionstandard>
	 */
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Emissionstandard> emissionstandardMap=new HashMap<Integer, Emissionstandard>();
		
		emissionstandardMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.EmissionstandardMapper.getEmissionstandardByCount", "eId");
		return emissionstandardMap;
	}

}
