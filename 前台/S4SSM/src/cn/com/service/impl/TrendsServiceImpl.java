package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.Trends;

import cn.com.dao.*;
import cn.com.service.*;
/**
 * 公司动态消息服务实现类
 * @author
 */
@Service
public class TrendsServiceImpl implements ITrendsService,IPageDao{
	@Resource
 private  ITrendsDao trendsDao=null; //公司动态消息操作接口的引用
	@Resource(name = "trendsDaoImpl" )
 private IPageDao pageTrends=null; //分页处理操作接口的引用
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
       /**
        * 获取指定条数的最新的动态消息集合
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
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
	/**
	 * 获取公司动态消息总记录数
	 * @return Long
	 */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return pageTrends.queryPersonCarCount(object);
	}
	/**
	 * 分页获取公司动态消息
	 * @param curPage 当前页
	 *@param rowsPrePage
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return pageTrends.showPersonCarList(curPage, rowsPrePage, object);
	}
       /**
        * 按条件获取动态消息
        * 
        * Trends
        */
	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		return trendsDao.getTrendsByWhere(trends);
	}

}
