package cn.com.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
@Service
public class DistanceServiceImpl implements IDistanceService,IPageDao {
	@Resource
   private IDistanceDao distanceDao=null;
	@Resource(name="distanceDaoImpl")
	private IPageDao distancePage=null;
	
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
	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return distancePage.queryPersonCarCount(object);
	}
	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return distancePage.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.addDistance(distance)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.deleteDistance(distance)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateDistance(Distance distance) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(distanceDao.updateDistance(distance)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public Distance getDistanceById(Distance distance) {
		// TODO Auto-generated method stub
		return distanceDao.getDistanceById(distance);
	}

}
