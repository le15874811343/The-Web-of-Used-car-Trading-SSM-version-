package cn.com.service.impl;
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
public class CarBrandServiceImpl implements ICarBrandService {
	@Resource
  private ICarBrandDao brandDao= null; //品牌信息操作接口的引用
	public ICarBrandDao getBrandDao() {
	return brandDao;
}
public void setBrandDao(ICarBrandDao brandDao) {
	this.brandDao = brandDao;
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
  /**
   * 根据品牌名称获取品牌的服务
   *@return CarBrand 
   */
	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		return  brandDao.getBrandByName(carBrand);
	}

}
