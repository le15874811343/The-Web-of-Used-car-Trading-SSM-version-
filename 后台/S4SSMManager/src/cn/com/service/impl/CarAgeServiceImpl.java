package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
/**
 * 车龄信息服务实现类
 *@author  lej 
 */
@Service
public class CarAgeServiceImpl implements ICarAgeService,IPageDao {
	@Resource
  private ICarAgeDao carAgeDao=null; //车辆信息操作接口的引用
	@Resource(name="carAgeDaoImpl")
	private IPageDao caragePage=null; //分页处理操作接口的引用
	
	public ICarAgeDao getCarAgeDao() {
		return carAgeDao;
	}

	public void setCarAgeDao(ICarAgeDao carAgeDao) {
		this.carAgeDao = carAgeDao;
	}

	public IPageDao getCaragePage() {
		return caragePage;
	}

	public void setCaragePage(IPageDao caragePage) {
		this.caragePage = caragePage;
	}
        /**
	 * 按热度获取车龄信息的服务
	 * @return Map<Integer,CarAge>
	 */
	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeByCount();
	}
	
	@Override
	public Long queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * 获取车龄信息的记录总条数的服务
     * @return int
     */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return caragePage.queryPersonCarCount(object);
	}
/**
 * 分页获取车龄信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		
		return caragePage.showPersonCarList(curPage, rowsPrePage, object);
	}
	/**
	 * 添加车龄信息的服务
	 * @return   boolean
	 */
	@Override
	public boolean addCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.addCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 删除车龄信息的服务
	 * @return   boolean
	 */
	@Override
	public boolean deleteCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.deleteCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 修改车龄信息的服务
	 * @return   boolean
	 */
	@Override
	public boolean updateCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.updateCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
        /**
	 * 获取车龄信息的服务
	 * @return CarAge
	 */
	@Override
	public Carage getCarAgeById(Carage carAge) {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeById(carAge);
	}

}
