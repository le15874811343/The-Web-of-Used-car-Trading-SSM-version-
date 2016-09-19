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
public class CarTypeServiceImpl  implements ICarTypeService,IPageDao{
	@Resource
   private ICarTypeDao carTypeDao=null; //车型操作接口的引用
	@Resource(name="carTypeDaoImpl")
 private IPageDao  cartypePage=null;  //分页处理操作接口的引用

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
	 * @return  Map<Integer,CarType>
	 */
@Override
public Map<Integer, Cartype> getAllCarType() {
	// TODO Auto-generated method stub
	return carTypeDao.getAllCarType();
}
/**
 * 添加车型的服务
 * @return boolean
 */
@Override
public boolean addCarType(Cartype carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.addCarType(carType)>0){
		flag=true;
	}
	return flag;
}
/**
 * 删除车型的服务
 * @return boolean
 */
@Override
public boolean deleteCarType(Cartype carType) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carTypeDao.deleteCarType(carType)>0){
		flag=true;
	}
	return flag;
}
/**
 * 修改车型的服务
 * @return boolean
 */
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

    /**
     * 获取车型信息的记录总条数的服务
     * @return int
     */	
@Override
public Long queryPersonCarCount(Object object) {
	// TODO Auto-generated method stub
	return cartypePage.queryPersonCarCount(object);
}

/**
 * 分页获取车型信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
@Override
public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
		Object object) {
	// TODO Auto-generated method stub
	return cartypePage.showPersonCarList(curPage, rowsPrePage, object);
}

/**
 * 获取车型的服务
 * @return CarType
 */
@Override
public Cartype getCarType(Cartype carType) {
	// TODO Auto-generated method stub
	return carTypeDao.getCarType(carType);
}
}
