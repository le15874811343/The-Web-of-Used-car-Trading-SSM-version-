package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.ICarImagesInfoDao;

import cn.com.service.ICarImagesInfoService;
/**
 * 汽车图片信息服务实现类
 * @author lej
 */
@Service
public class CarImagesInfoServiceImpl implements ICarImagesInfoService{
	@Resource
private ICarImagesInfoDao carImagesInfoDao=null; //汽车图片操作接口的引用

public ICarImagesInfoDao getCarImagesInfoDao() {
	return carImagesInfoDao;
}
public void setCarImagesInfoDao(ICarImagesInfoDao carImagesInfoDao) {
	this.carImagesInfoDao = carImagesInfoDao;
}
 /**
   * 根据编号获取汽车照片的服务
   * @parma carInfo
   * @return Map<Integer,String>
   */		
@Override
	public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carImagesInfoDao.getCarImagesInfoByID( carInfo);
	}
/**
 * 添加照片信息的服务
 * @parma carImagesInfo
 *@reutn boolean 
 */
@Override
public boolean addCarImagesInfo(Imagesinfo carImagesInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.addCarImagesInfo(carImagesInfo)>0){
		flag=true;
	}
	return flag;
}
/**
 *修改照片信息的服务
 * @parmas
 * @return boolean
 */
@Override
public boolean updateCarImagesInfo(Imagesinfo carImagesInfo) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(carImagesInfoDao.updateCarImagesInfo(carImagesInfo)>0){
		flag=true;
	}
	return flag;
}
/**
 * 根据车主编号删除汽车照片信息的服务
 *@return boolean  
 */
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
/**
 * 根据车编号删除汽车照片信息的服务
 *@return boolean  
 */
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
/**
 * 
 * 检查是否还有与某车主编号关联的汽车照片信息的服务
 * @return boolean
 */
@Override
public boolean checkimageinfouser(Imagesinfo c) {
	// TODO Auto-generated method stub
	return carImagesInfoDao.checkimageinfouser(c);
}
/**
 * 
 * 检查是否还有与某车编号关联的汽车照片信息的服务
 * @return boolean
 */
@Override
public boolean checkcidimageinfouser(Imagesinfo c) {
	// TODO Auto-generated method stub
	return carImagesInfoDao.checkcidimageinfouser(c);
}

}
