package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
/**
 * 汽车概要信息服务实现类
 * @author lej
 */
@Service
public class CarInfoServiceImpl implements ICarInfoService,IPageDao  {
	@Resource
   private ICarInfoDao carInfoDao=null; //汽车概要信息操作接口的引用
	@Resource(name="carInfoDaoImpl")
   private IPageDao carInfoPage=null;  //分页处理操作接口的引用
   
	public ICarInfoDao getCarInfoDao() {
	return carInfoDao;
}
public void setCarInfoDao(ICarInfoDao carInfoDao) {
	this.carInfoDao = carInfoDao;
}
public IPageDao getCarInfoPage() {
	return carInfoPage;
}
public void setCarInfoPage(IPageDao carInfoPage) {
	this.carInfoPage = carInfoPage;
}
/**
 * 按热度获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Map<Long, Carinfo> getCarInfoByCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByCountDesc(carInfo);
	}
/**
 * 按热度和品牌获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Map<Long, Carinfo> getCarInfoByBrandCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByBrandCountDesc(carInfo);
	}
/**
 * 按上架时间获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Map<Long, Carinfo> getCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoBySjTime(carInfo);
	}
/**
 * 获取四辆最新上架的汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Map<Long, Carinfo> getFourthCarInfoBySjTime(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getFourthCarInfoBySjTime(carInfo);
	}
/**
 * 按热度和车型获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Map<Long, Carinfo> getCarInfoByTypeCountDesc(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByTypeCountDesc(carInfo);
	}
/**
 * 按品牌获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Map<Long, Carinfo> getCarInfoByBrand(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByBrand(carInfo);
	}
/**
 * 按车型获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Map<Long, Carinfo> getCarInfoByType(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByType(carInfo);
	}
/**
 * 按条件获取汽车概要信息的服务
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Map<Long, Carinfo> getCarByWhere(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarByWhere(carInfo);
	}
/**
 * 获取符合条件的汽车概要信息记录条数的服务
 * @parma minPrice   最小价格
 * @parma maxPrice  最大价格
 * @parma minDis   最小距离
 * @parma maxDis  最大距离
 * @parma minAge  最小车龄
 * @parma maxAge  最大车龄
 * @return   Map<Long, CarInfo>
 */
	@Override
	public Long queryMsgCount(Object object,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		return carInfoPage.queryMsgCount(object,minPrice,maxPrice,minDis,maxDis,minAge,maxAge);
	}
/**
 * 获取符合条件的汽车概要信息的服务
 * @parma minPrice   最小价格
 * @parma maxPrice  最大价格
 * @parma minDis   最小距离
 * @parma maxDis  最大距离
 * @parma minAge  最小车龄
 * @parma maxAge  最大车龄
 * @parma curPage   当前页
 * @parma rowsPrePage   页面展示条数
 * @return   Map<Long, CarInfo>
 */	
	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,Object object,String order,int minPrice,int maxPrice,int minDis,int maxDis,int minAge,int maxAge) {
		// TODO Auto-generated method stub
		return carInfoPage.showMsgInfoList(curPage, rowsPrePage, object,order,minPrice,maxPrice,minDis,maxDis,minAge,maxAge);
	}
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return null;
	}
 /**
   * 修改汽车概要信息的服务
   * @parma carInfo
   * @return boolean
   */	
	@Override
	public boolean updateCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.updateCarInfo(carInfo)>0){
			flag=true;
		}
		return flag;
	}
 /**
   * 添加汽车概要信息的服务
   * @parma carInfo
   * @return boolean
   */
	@Override
	public boolean addCarInfo(Carinfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.addCarInfo(carInfo)>0){
			flag=true;
		}
		return flag;
	}
/**
 * 按唯一条件获取汽车概要信息的服务
 * @parma carInfo
 * @return   CarInfo
 */	
	@Override
	public Carinfo getCarInfoByUMN(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getCarInfoByUMN(carInfo);
	}
 /**
   * 修改汽车所有概要信息的服务
   * @parma carInfo
   * @return boolean
   */	
	@Override
	public boolean updateCarAll(Carinfo carInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.updateCarAll(carInfo)>0){
			flag=true;
		}
		return flag;
	}
/**
 * 根据车主编号删除汽车概要信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecarinfouser(Carinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.deletecarinfouser(c)>0)
		{
			flag=true;
		}
		return flag;
	}
/**
 * 
 * 检查是否还有与某车主编号关联的汽车概要信息的服务
 * @return boolean
 */	
	@Override
	public boolean checkcarinfouser(Carinfo c) {
		// TODO Auto-generated method stub
		return carInfoDao.checkcarinfouser(c);
	}
/**
 * 根据车编号删除汽车概要信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecarinfo(Carinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carInfoDao.deletecarinfo(c)>0)
		{
			flag=true;
		}
		
		
		return flag;
	}
 /**
   * 获取热度最高的10辆车
   * @parma carInfo
   * @return List<CarInfo>
   */
	@Override
	public List<Carinfo> getTenCount(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getTenCount(carInfo);
	}
 /**
   * 获取热度最高10个品牌的车
   * @parma carInfo
   * @return List<CarInfo>
   */
	@Override
	public List<Carinfo> getTenBrandCar(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return carInfoDao.getTenBrandCar(carInfo);
	}
}
