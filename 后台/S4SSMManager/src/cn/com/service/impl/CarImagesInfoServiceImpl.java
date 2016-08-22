package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.ICarImagesInfoDao;

import cn.com.service.ICarImagesInfoService;
@Service
public class CarImagesInfoServiceImpl implements ICarImagesInfoService{
	@Resource
private ICarImagesInfoDao carImagesInfoDao=null;

public ICarImagesInfoDao getCarImagesInfoDao() {
	return carImagesInfoDao;
}
public void setCarImagesInfoDao(ICarImagesInfoDao carImagesInfoDao) {
	this.carImagesInfoDao = carImagesInfoDao;
}
/**
 * 通过c_id来查询车辆照片信息的业务
 */	
@Override
	public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carImagesInfoDao.getCarImagesInfoByID( carInfo);
	}
@Override
public boolean addCarImagesInfo(Imagesinfo carImagesInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.addCarImagesInfo(carImagesInfo)>0){
		flag=true;
	}
	return flag;
}
@Override
public boolean updateCarImagesInfo(Imagesinfo carImagesInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.updateCarImagesInfo(carImagesInfo)>0){
		flag=true;
	}
	return flag;
}
@Override
public boolean deleteimagesinfouser(Imagesinfo c) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.deleteimagesinfouser(c)>0)
	{
		flag=true;
	}
	
	return flag;
}
@Override
public boolean deletecidimagesinfouser(Imagesinfo c) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.deletecidimagesinfouser(c)>0)
	{
		flag=true;
	}
	
	return flag;
}
@Override
public boolean checkimageinfouser(Imagesinfo c) {
	// TODO Auto-generated method stub
	return carImagesInfoDao.checkimageinfouser(c);
}
@Override
public boolean checkcidimageinfouser(Imagesinfo c) {
	// TODO Auto-generated method stub
	return carImagesInfoDao.checkcidimageinfouser(c);
}

}
