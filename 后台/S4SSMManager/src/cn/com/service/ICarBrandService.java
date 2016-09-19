package cn.com.service;
import cn.com.pojo.*;

import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 品牌信息服务接口
 * @author lej
 */
@Repository
public interface ICarBrandService {
 /**
   * 按热度获取品牌信息的服务
   * @return  Map<Integer, CarBrand>
   */
	public Map<Integer, Carbrand> getCarBrandByCount();
  /**
   * 获取所有品牌信息的服务
   * @return Map<Integer,CarBrand>
   */
	public Map<Integer, Carbrand> getAllBrand();
 /**
   * 根据品牌编号获取品牌信息的服务
   * @param carBrand
   * @return CarBrand
   */
	public Carbrand getBrandByID(Carbrand carBrand);
  /**
   * 添加品牌的服务
   *@return boolean
   */
	 public boolean addCarBrand(Carbrand carBrand);
  /**
   * 修改品牌的服务
   *@return boolean
   */
	  public boolean updateCarBrand(Carbrand carBrand);
  /**
   * 删除品牌的服务
   *@return boolean
   */
	  public boolean deleteCarBrand(Carbrand carBrand);
  /**
   * 根据品牌名称获取品牌信息的服务
   * @param carBrand
   * @return CarBrand
   */
	  public Carbrand getBrandByName(Carbrand carBrand);
}
