package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.Trends;

import cn.com.dao.*;
import cn.com.service.*;
@Service
public class TrendsServiceImpl implements ITrendsService,IPageDao{
	@Resource
 private  ITrendsDao trendsDao=null;
	@Resource(name="trendsDaoImpl")
 private IPageDao  trendPage=null;
 
	public IPageDao getTrendPage() {
	return trendPage;
}
public void setTrendPage(IPageDao trendPage) {
	this.trendPage = trendPage;
}
	public ITrendsDao getTrendsDao() {
	return trendsDao;
}
public void setTrendsDao(ITrendsDao trendsDao) {
	this.trendsDao = trendsDao;
}
	@Override
	public List<Trends> getITrendsByTime(Trends trends,int rows) {
		// TODO Auto-generated method stub
		return trendsDao.getITrendsByTime(trends,rows);
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
		return trendPage.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return trendPage.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		return trendsDao.getTrendsByWhere(trends);
	}
	@Override
	public boolean addTrends(Trends trends) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(trendsDao.addTrends(trends)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteTrends(Trends trends) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(trendsDao.deleteTrends(trends)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateTrends(Trends trends) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(trendsDao.updateTrends(trends)>0){
			flag=true;
		}
		return flag;
	}

}
