package cn.com.service.impl;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
/**
 * 车型服务实现类
 * @author
 */
@Service
public class CarTypeServiceImpl  implements ICarTypeService{
	@Resource
   private ICarTypeDao carTypeDao=null; //车型操作接口的引用

public ICarTypeDao getCarTypeDao() {
	return carTypeDao;
}

public void setCarTypeDao(ICarTypeDao carTypeDao) {
	this.carTypeDao = carTypeDao;
}
        /**
	 * 按热度获取车型信息的服务
	 * @return Map<Integer,CarType>
	 */
@Override
public Map<Integer, Cartype> getCarTypeByCount() {
	// TODO Auto-generated method stub
	return carTypeDao.getCarTypeByCount();
}
        /**
	 * 获取所有车型信息的服务
	 * @return Map<Integer,CarType>
	 */
@Override
public Map<Integer, Cartype> getAllCarType() {
	// TODO Auto-generated method stub
	return carTypeDao.getAllCarType();
}
}
