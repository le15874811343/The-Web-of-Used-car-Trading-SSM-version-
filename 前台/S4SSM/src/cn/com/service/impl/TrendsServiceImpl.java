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
	@Resource(name = "trendsDaoImpl" )
 private IPageDao pageTrends=null;
	public ITrendsDao getTrendsDao() {
	return trendsDao;
}
public void setTrendsDao(ITrendsDao trendsDao) {
	this.trendsDao = trendsDao;
}
public IPageDao getPageTrends() {
	return pageTrends;
}
public void setPageTrends(IPageDao pageTrends) {
	this.pageTrends = pageTrends;
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
		return pageTrends.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return pageTrends.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		return trendsDao.getTrendsByWhere(trends);
	}

}
