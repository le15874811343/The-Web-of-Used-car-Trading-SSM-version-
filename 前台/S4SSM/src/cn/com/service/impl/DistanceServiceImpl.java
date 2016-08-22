package cn.com.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.service.*;
@Service
public class DistanceServiceImpl implements IDistanceService {
	@Resource
   private IDistanceDao distanceDao=null;
	public IDistanceDao getDistanceDao() {
	return distanceDao;
}
public void setDistanceDao(IDistanceDao distanceDao) {
	this.distanceDao = distanceDao;
}
	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		return distanceDao.getDistanceByCount();
	}

}
