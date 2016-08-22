package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
@Service
public class CarBrandServiceImpl implements ICarBrandService,IPageDao {
	@Resource
  private ICarBrandDao brandDao= null;
	@Resource(name="carBrandDaoImpl")
  private IPageDao brandPage=null;
  
	public ICarBrandDao getBrandDao() {
	return brandDao;
}

public void setBrandDao(ICarBrandDao brandDao) {
	this.brandDao = brandDao;
}

public IPageDao getBrandPage() {
	return brandPage;
}

public void setBrandPage(IPageDao brandPage) {
	this.brandPage = brandPage;
}

	@Override
	public Map<Integer, Carbrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
		return brandDao.getCarBrandByCount();
	}
	
	@Override
	public Map<Integer, Carbrand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandDao.getAllBrand();
	}
	
	@Override
	public Carbrand getBrandByID(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return brandDao.getBrandByID(carBrand);
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
		return brandPage.queryPersonCarCount(object);
	}
	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return brandPage.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.addCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.updateCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.deleteCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return brandDao.getBrandByName(carBrand);
	}

}
