package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface ISellInfoService {
	/**
	 * 获取所有销售信息业务
	 */
	public Map<Long, Sellinfo> getAllSellInfo();
	/**
	 * 根据车编号获取销售情况业务
	 */
	public Sellinfo getSellInfoById(Carinfo carInfo);
	/**
	 * 增加销售情况业务
	 */
	public boolean addSellInfo(Sellinfo sellInfo);
	/**
	 * 删除销售情况业务
	 */
	public int deleteSellInfo(Sellinfo sellInfo);
	public boolean updateSellInfo(Sellinfo sellInfo);
}
