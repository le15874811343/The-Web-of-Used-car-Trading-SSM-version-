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
public class EmissionstandardDaoImpl extends BaseDao implements IEmissionstandardDao,IPageDao {
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
          /**
           * 添加排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int addEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.EmissionstandardMapper.insertSelective",emissionstandard);
	}
          /**
           * 删除排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int deleteEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		return  super.getSqlSessionTemplate().delete("cn.com.pojo.EmissionstandardMapper.deleteEmissionstandard",emissionstandard);
	}
          /**
           * 修改排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int updateEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().update("cn.com.pojo.EmissionstandardMapper.updateEmissionstandard",emissionstandard);
	}
        /**
	 * 获取排放标准信息的方法
	 * @return Emissionstandard
	 */
	@Override
	public Emissionstandard getEmissionstandard(
			Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		Emissionstandard _Emissionstandard=null;
	List<Emissionstandard> elist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.EmissionstandardMapper.getEmissionstandard",emissionstandard);
	if(elist.size()>0){
		_Emissionstandard=elist.get(0);
	}
		return _Emissionstandard;
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
    /**
     * 获取排放标准信息的记录总条数
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=(long) 0;
		List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.EmissionstandardMapper.queryPersonCarCount");
		if(clist.size()>0){
			count=clist.get(0);
		}
			return count;
	}
/**
 * 分页获取排放标准信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
Map<String, Object> parmas=new HashMap<String, Object>();
		
		parmas.put("curPage", curPage);
		parmas.put("rowsPrePage", rowsPrePage);
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.EmissionstandardMapper.showPersonCarList", parmas, "eId");
		return brandMap;
	}

}
