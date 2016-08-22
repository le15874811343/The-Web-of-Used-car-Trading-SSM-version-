package cn.com.service.impl;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;


import cn.com.dao.*;
import cn.com.service.*;
@Service
public class CarTypeServiceImpl  implements ICarTypeService,IPageDao{
	@Resource
   private ICarTypeDao carTypeDao=null;
	@Resource(name="carTypeDaoImpl")
 private IPageDao  cartypePage=null;

public ICarTypeDao getCarTypeDao() {
	return carTypeDao;
}


public void setCarTypeDao(ICarTypeDao carTypeDao) {
	this.carTypeDao = carTypeDao;
}


public IPageDao getCartypePage() {
	return cartypePage;
}


public void setCartypePage(IPageDao cartypePage) {
	this.cartypePage = cartypePage;
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

@Override
public boolean addCarType(Cartype carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.addCarType(carType)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean deleteCarType(Cartype carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.deleteCarType(carType)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean updateType(Cartype carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.updateType(carType)>0){
		flag=true;
	}
	return flag;
}


@Override
public Long queryMsgCount(Object object, int minPrice, int maxPrice, int minDis,
		int maxDis, int minAge, int maxAge) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
		Object object, String order, int minPrice, int maxPrice, int minDis,
		int maxDis, int minAge, int maxAge) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Long queryPersonCarCount(Object object) {
	// TODO Auto-generated method stub
	return cartypePage.queryPersonCarCount(object);
}


@Override
public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
		Object object) {
	// TODO Auto-generated method stub
	return cartypePage.showPersonCarList(curPage, rowsPrePage, object);
}


@Override
public Cartype getCarType(Cartype carType) {
	// TODO Auto-generated method stub
	return carTypeDao.getCarType(carType);
}
}
