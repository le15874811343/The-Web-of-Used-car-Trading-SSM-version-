package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 品牌信息操作接口
 * @author lej
 */
@Repository
public interface ICarBrandDao {
   /**
   * 按热度获取品牌信息的方法
   * @return  Map<Integer, Carbrand>
   */
  public Map<Integer, Carbrand> getCarBrandByCount();
   /**
   * 获取所有品牌信息的方法
   * @return Map<Integer,Carbrand>
   */
  public Map<Integer, Carbrand> getAllBrand();
    /**
   * 根据品牌编号获取品牌信息的方法
   * @param carBrand
   * @return Carbrand
   */
  public Carbrand getBrandByID(Carbrand carBrand);
  /**
   * 根据品牌名称获取品牌的方法
   *@return Carbrand 
   */
  public Carbrand getBrandByName(Carbrand carBrand);
}
