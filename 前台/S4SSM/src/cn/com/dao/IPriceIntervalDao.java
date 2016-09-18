package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 价格区间操作接口
 * @author lej
 */
@Repository
public interface IPriceIntervalDao {
   /**
   * 
   * 按热度获取价格区间信息的方法
   * @return Map<Integer,Priceinterval>
   */
  public Map<Integer,Priceinterval> getPriceIntervalByCount();
}
