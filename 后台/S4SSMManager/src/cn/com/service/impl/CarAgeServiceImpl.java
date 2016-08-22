package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
@Service
public class CarAgeServiceImpl implements ICarAgeService,IPageDao {
	@Resource
  private ICarAgeDao carAgeDao=null;
	@Resource(name="carAgeDaoImpl")
	private IPageDao caragePage=null;
	
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
	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return caragePage.queryPersonCarCount(object);
	}
	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		
		return caragePage.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.addCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.deleteCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(carAgeDao.updateCarAge(carAge)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public Carage getCarAgeById(Carage carAge) {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeById(carAge);
	}

}
