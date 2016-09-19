package cn.com.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
/**
 * 行驶距离服务实现类
 *@author lej 
 */
@Service
public class DistanceServiceImpl implements IDistanceService,IPageDao {
	@Resource
   private IDistanceDao distanceDao=null; //行驶距离操作接口的引用
	@Resource(name="distanceDaoImpl")
	private IPageDao distancePage=null; //分页处理操作接口的引用
	
	public IDistanceDao getDistanceDao() {
		return distanceDao;
	}

	public void setDistanceDao(IDistanceDao distanceDao) {
		this.distanceDao = distanceDao;
	}

	public IPageDao getDistancePage() {
		return distancePage;
	}

	public void setDistancePage(IPageDao distancePage) {
		this.distancePage = distancePage;
	}
  /**
    * 
    * 按热度获取行驶距离信息的服务
    *@return Map<Integer,Distance> 
    */
	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		return distanceDao.getDistanceByCount();
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
     * 获取行驶距离信息的记录总条数的服务
     * @return int
     */		
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return distancePage.queryPersonCarCount(object);
	}
/**
 * 分页获取行驶距离信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */		
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return distancePage.showPersonCarList(curPage, rowsPrePage, object);
	}
	 /**
           * 添加行驶距离的服务
           * @parma distance
           * @return boolean
           */
	@Override
	public boolean addDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.addDistance(distance)>0){
			flag=true;
		}
		return flag;
	}
	 /**
           * 删除行驶距离的服务
           * @parma distance
           * @return boolean
           */
	@Override
	public boolean deleteDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.deleteDistance(distance)>0){
			flag=true;
		}
		return flag;
	}
	 /**
           * 修改行驶距离的服务
           * @parma distance
           * @return boolean
           */
	@Override
	public boolean updateDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.updateDistance(distance)>0){
			flag=true;
		}
		return flag;
	}
   /**
    * 
    * 按编号获取行驶距离信息的服务
    *@return Distance
    */
	@Override
	public Distance getDistanceById(Distance distance) {
		// TODO Auto-generated method stub
		return distanceDao.getDistanceById(distance);
	}

}
