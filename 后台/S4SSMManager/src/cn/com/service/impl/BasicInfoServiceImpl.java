package cn.com.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.IBasicInfoDao;

import cn.com.service.*;
@Service
public class BasicInfoServiceImpl implements IBasicInfoService{
	@Resource
private IBasicInfoDao basicInfoDaoImpl=null;

public IBasicInfoDao getBasicInfoDaoImpl() {
	return basicInfoDaoImpl;
}

public void setBasicInfoDaoImpl(IBasicInfoDao basicInfoDaoImpl) {
	this.basicInfoDaoImpl = basicInfoDaoImpl;
}

@Override
public Map<Long, Basicinfo> getAllBasic() {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasic();
}

@Override
public Basicinfo getAllBasicById(Carinfo carInfo) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasicById(carInfo);
}

@Override
public boolean addBasicInfo(Basicinfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.addBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean updateBasicInfo(Basicinfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.updateBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean deletebasicinfo(Basicinfo b) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.deletebasicinfo(b)>0)
	{
		flag=true;
	}
	
	return flag;
}

@Override
public boolean deletecidbasicinfo(Basicinfo b) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.deletecidbasicinfo(b)>0)
	{
		flag=true;
	}
	
	return flag;
}

@Override
public boolean checkbasicinfo(Basicinfo b) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.checkbasicinfo(b);
}

@Override
public boolean checkcidbasicinfo(Basicinfo b) {
	// TODO Auto-generated method stub
	return  basicInfoDaoImpl.checkcidbasicinfo(b);
}
	
	
}
