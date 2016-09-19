package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 价格区间服务接口
 * @author lej
 */
@Repository
public interface IPriceIntervalService {
  /**
   * 
   * 按热度获取价格区间信息的服务
   * @return Map<Integer,PriceInterval>
   */
	public Map<Integer, Priceinterval> getPriceIntervalByCount();
  /**
   * 
   * 添加价格区间信息的服务
   * @return boolean
   */
	public boolean addPriceInterval(Priceinterval priceInterval);
  /**
   * 
   * 删除价格区间信息的服务
   * @return boolean
   */
	  public boolean deletePriceInterval(Priceinterval priceInterval);
  /**
   * 
   * 修改价格区间信息的服务
   * @return boolean
   */
	  public boolean updatePriceInterval(Priceinterval priceInterval);
  /**
   * 
   * 获取价格区间信息的服务
   * @return PriceInterval
   */
	  public Priceinterval getPriceIntervalById(Priceinterval priceInterval);
}
