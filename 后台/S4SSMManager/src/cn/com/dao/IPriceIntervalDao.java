package cn.com.dao;

import java.util.Map;
import cn.com.pojo.*;
/**
 * 价格区间操作接口
 * @author lej
 */
public interface IPriceIntervalDao {
   /**
   * 
   * 按热度获取价格区间信息的方法
   * @return Map<Integer,PriceInterval>
   */
  public Map<Integer,Priceinterval> getPriceIntervalByCount();
    /**
   * 
   * 添加价格区间信息的方法
   * @return int
   */
  public int addPriceInterval(Priceinterval priceInterval);
   /**
   * 
   * 删除价格区间信息的方法
   * @return int
   */
  public int deletePriceInterval(Priceinterval priceInterval);
  /**
   * 
   * 修改价格区间信息的方法
   * @return int
   */
  public int updatePriceInterval(Priceinterval priceInterval);
  /**
   * 
   * 获取价格区间信息的方法
   * @return PriceInterval
   */
  public Priceinterval getPriceIntervalById(Priceinterval priceInterval);
  
}
