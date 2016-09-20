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
public class DistanceDaoImpl extends BaseDao implements IDistanceDao,IPageDao {
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
     * 获取行驶距离信息的记录总条数
     * @return Long
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=(long) 0;
		List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.DistanceMapper.queryPersonCarCount");
		if(clist.size()>0){
			count=clist.get(0);
		}
			return count;
	}
/**
 * 分页获取行驶距离信息
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
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.DistanceMapper.showPersonCarList", parmas, "dId");
		return brandMap;
	}
          /**
           * 添加行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int addDistance(Distance distance) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.DistanceMapper.insertSelective", distance);
	}
          /**
           * 删除行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int deleteDistance(Distance distance) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.DistanceMapper.deleteDistance", distance);
	}
          /**
           * 修改行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int updateDistance(Distance distance) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().update("cn.com.pojo.DistanceMapper.updateDistance", distance);
	}
   /**
    * 
    * 按编号获取行驶距离信息的方法
    *@return Distance
    */
	@Override
	public Distance getDistanceById(Distance distance) {
		// TODO Auto-generated method stub
		Distance _Distance=null;
		
	List<Distance> dlist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.DistanceMapper.getDistanceById", distance);
	if(dlist.size()>0){
		_Distance=dlist.get(0);
	}
		return _Distance;
	}

}
