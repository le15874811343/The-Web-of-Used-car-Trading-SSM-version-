package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.dao.IPageDao;
import cn.com.dao.IPriceIntervalDao;

import cn.com.service.IPriceIntervalService;
@Service
public class PriceIntervalServiceImpl implements IPriceIntervalService,IPageDao{
	@Resource
   private IPriceIntervalDao intervalDao=null;
	@Resource(name="priceIntervalDaoImpl")
   private IPageDao  priceIntPage=null;
	
	public IPriceIntervalDao getIntervalDao() {
	return intervalDao;
}

public void setIntervalDao(IPriceIntervalDao intervalDao) {
	this.intervalDao = intervalDao;
}

public IPageDao getPriceIntPage() {
	return priceIntPage;
}

public void setPriceIntPage(IPageDao priceIntPage) {
	this.priceIntPage = priceIntPage;
}

	@Override
	public Map<Integer, Priceinterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalByCount();
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
		return priceIntPage.queryPersonCarCount(object);
	}
	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return priceIntPage.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addPriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.addPriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deletePriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.deletePriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updatePriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(intervalDao.updatePriceInterval(priceInterval)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public Priceinterval getPriceIntervalById(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalById(priceInterval);
	}

}
