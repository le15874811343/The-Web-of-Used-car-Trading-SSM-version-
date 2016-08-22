package cn.com.service.impl;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
@Service
public class CarTypeServiceImpl  implements ICarTypeService{
	@Resource
   private ICarTypeDao carTypeDao=null;

public ICarTypeDao getCarTypeDao() {
	return carTypeDao;
}

public void setCarTypeDao(ICarTypeDao carTypeDao) {
	this.carTypeDao = carTypeDao;
}

@Override
public Map<Integer, Cartype> getCarTypeByCount() {
	// TODO Auto-generated method stub
	return carTypeDao.getCarTypeByCount();
}

@Override
public Map<Integer, Cartype> getAllCarType() {
	// TODO Auto-generated method stub
	return carTypeDao.getAllCarType();
}
}
