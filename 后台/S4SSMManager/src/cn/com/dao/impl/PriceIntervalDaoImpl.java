package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;

@Repository
public class PriceIntervalDaoImpl extends BaseDao implements IPriceIntervalDao,IPageDao{

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

	@Override
	public int addPriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.PriceintervalMapper.insertSelective",priceInterval);
	}

	@Override
	public int deletePriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.PriceintervalMapper.deletePriceInterval",priceInterval);
	}

	@Override
	public int updatePriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.PriceintervalMapper.updatePriceInterval",priceInterval);
	}

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
