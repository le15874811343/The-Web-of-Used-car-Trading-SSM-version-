package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
/**
 * 品牌信息服务实现类
 * @author lej
 */
@Service
public class CarBrandServiceImpl implements ICarBrandService,IPageDao {
	@Resource
  private ICarBrandDao brandDao= null; //品牌信息操作接口的引用
	@Resource(name="carBrandDaoImpl")
  private IPageDao brandPage=null; //分页处理操作接口的引用
  
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
  /**
   * 按热度获取品牌信息的服务
   * @return  Map<Integer, CarBrand>
   */
	@Override
	public Map<Integer, Carbrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
		return brandDao.getCarBrandByCount();
	}
  /**
   * 获取所有品牌信息的服务
   * @return Map<Integer,CarBrand>
   */
	@Override
	public Map<Integer, Carbrand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandDao.getAllBrand();
	}
  /**
   * 根据品牌编号获取品牌信息的服务
   * @param carBrand
   * @return CarBrand
   */
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
    /**
     * 获取品牌信息的记录总条数的服务
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return brandPage.queryPersonCarCount(object);
	}
/**
 * 分页获取品牌信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */		
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return brandPage.showPersonCarList(curPage, rowsPrePage, object);
	}
 /**
   * 添加品牌的服务
   *@return boolean
   */
	@Override
	public boolean addCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.addCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
 /**
   * 修改品牌的服务
   *@return boolean
   */
	@Override
	public boolean updateCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.updateCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 删除品牌的服务
   *@return boolean
   */
	@Override
	public boolean deleteCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(brandDao.deleteCarBrand(carBrand)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 根据品牌名称获取品牌信息的服务
   * @param carBrand
   * @return CarBrand
   */
	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return brandDao.getBrandByName(carBrand);
	}

}
