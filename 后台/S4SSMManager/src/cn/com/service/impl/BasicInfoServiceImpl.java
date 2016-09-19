package cn.com.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.IBasicInfoDao;

import cn.com.service.*;
/**
 * 汽车基本信息服务实现类
 * @author lej
 */
@Service
public class BasicInfoServiceImpl implements IBasicInfoService{
	@Resource
private IBasicInfoDao basicInfoDaoImpl=null; //汽车基础信息操作接口的引用

public IBasicInfoDao getBasicInfoDaoImpl() {
	return basicInfoDaoImpl;
}

public void setBasicInfoDaoImpl(IBasicInfoDao basicInfoDaoImpl) {
	this.basicInfoDaoImpl = basicInfoDaoImpl;
}
/**
 * 获取所有基本信息的服务
 * @return Map<Long, BasicInfo>
 */
@Override
public Map<Long, Basicinfo> getAllBasic() {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasic();
}
/**
 *根据编号获取汽车基本信息的服务
 *@return BasicInfo
 */
@Override
public Basicinfo getAllBasicById(Carinfo carInfo) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.getAllBasicById(carInfo);
}
/**
 * 添加汽车基本信息的服务
 * @return boolean
 */
@Override
public boolean addBasicInfo(Basicinfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.addBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}
/**
 * 修改汽车基本信息的服务
 * @return boolean
 */
@Override
public boolean updateBasicInfo(Basicinfo basicInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(basicInfoDaoImpl.updateBasicInfo(basicInfo)>0){
		flag=true;
	}
	return flag;
}
/**
 * 根据车主编号删除汽车基本信息的服务
 *@return boolean  
 */
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
/**
 * 根据车编号删除汽车基本信息的服务
 *@return boolean  
 */
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
/**
 * 检查是否还有与某车主编号关联的汽车基本信息的服务
 * @return boolean
 */
@Override
public boolean checkbasicinfo(Basicinfo b) {
	// TODO Auto-generated method stub
	return basicInfoDaoImpl.checkbasicinfo(b);
}
/**
 * 检查是否还有与某车编号关联的汽车基本信息的服务
 * @return boolean
 */
@Override
public boolean checkcidbasicinfo(Basicinfo b) {
	// TODO Auto-generated method stub
	return  basicInfoDaoImpl.checkcidbasicinfo(b);
}
	
	
}
