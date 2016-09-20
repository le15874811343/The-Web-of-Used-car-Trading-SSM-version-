package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;
/**
 * 价格区间操作实现类
 * @author lej
 */
@Repository
public class PriceIntervalDaoImpl extends BaseDao implements IPriceIntervalDao,IPageDao{
 /**
   * 
   * 按热度获取价格区间信息的方法
   * @return Map<Integer,PriceInterval>
   */
	@Override
	public Map<Integer, Priceinterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Priceinterval> priceIntervalMap=new HashMap<Integer, Priceinterval>();
	
	    try{
	    	priceIntervalMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.PriceintervalMapper.getPriceIntervalByCount", "pId");
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return priceIntervalMap;
	}
  /**
   * 
   * 添加价格区间信息的方法
   * @return int
   */
	@Override
	public int addPriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.PriceintervalMapper.insertSelective",priceInterval);
	}
  /**
   * 
   * 删除价格区间信息的方法
   * @return int
   */
	@Override
	public int deletePriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.PriceintervalMapper.deletePriceInterval",priceInterval);
	}
  /**
   * 
   * 修改价格区间信息的方法
   * @return int
   */
	@Override
	public int updatePriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.PriceintervalMapper.updatePriceInterval",priceInterval);
	}
  /**
   * 
   * 获取价格区间信息的方法
   * @return PriceInterval
   */
	@Override
	public Priceinterval getPriceIntervalById(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		Priceinterval _Priceinterval=null;
	List<Priceinterval> plist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.PriceintervalMapper.getPriceIntervalById", priceInterval);
	if(plist.size()>0){
		_Priceinterval=plist.get(0);
	}
		return _Priceinterval;
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
     * 获取价格区间信息的记录总条数
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=(long) 0;
		List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.PriceintervalMapper.queryPersonCarCount");
		if(clist.size()>0){
			count=clist.get(0);
		}
			return count;
	}
/**
 * 分页获取价格区间信息
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
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.PriceintervalMapper.showPersonCarList", parmas, "pId");
		return brandMap;
	}

}
