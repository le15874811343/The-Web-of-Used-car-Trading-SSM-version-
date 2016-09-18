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
public class DistanceServiceImpl implements IDistanceService {
	@Resource
   private IDistanceDao distanceDao=null; //行驶距离操作接口的引用
	public IDistanceDao getDistanceDao() {
	return distanceDao;
}
public void setDistanceDao(IDistanceDao distanceDao) {
	this.distanceDao = distanceDao;
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

}
