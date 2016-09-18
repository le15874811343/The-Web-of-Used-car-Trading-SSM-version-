package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
  * 
  * 销售信息服务接口
  * @author lej
  */
@Repository
public interface ISellInfoService {
        /**
	 * 获取所有销售信息
	 * @return   Map<Long, SellInfo>
	 */
	public Map<Long, Sellinfo> getAllSellInfo();
/**
 * 根据车编号获取销售信息
 * @return SellInfo
 */
	public Sellinfo getSellInfoById(Carinfo carInfo);
/**
 * 增加销售信息
 * @param sellInfo
 * @return boolean
 */
	public boolean addSellInfo(Sellinfo sellInfo);
/**
 * 删除销售信息
 * @param sellInfo
 * @return int
 */
	public int deleteSellInfo(Sellinfo sellInfo);
/**
 * 修改销售信息
 * @param sellInfo
 * @return boolean
 */
	public boolean updateSellInfo(Sellinfo sellInfo);
}
