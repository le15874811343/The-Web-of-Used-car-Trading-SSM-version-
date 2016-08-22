package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface ISellInfoDao {
	/**
	 * 获取所有销售信息
	 * @return
	 */
public Map<Long, Sellinfo> getAllSellInfo();
/**
 * 根据车编号获取销售情况
 * @return
 */
public Sellinfo getSellInfoById(Carinfo carInfo);
/**
 * 增加销售情况
 * @param sellInfo
 * @return
 */
public int addSellInfo(Sellinfo sellInfo);
/**
 * 删除销售情况
 * @param sellInfo
 * @return
 */
public int deleteSellInfo(Sellinfo sellInfo);
public int updateSellInfo(Sellinfo sellInfo);

}
