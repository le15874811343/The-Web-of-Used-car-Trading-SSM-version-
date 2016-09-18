package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
 /**
  * 
  * 销售信息操作接口
  * @author lej
  */
@Repository
public interface ISellInfoDao {
        /**
	 * 获取所有销售信息
	 * @return   Map<Long, Sellinfo>
	 */
public Map<Long, Sellinfo> getAllSellInfo();
/**
 * 根据车编号获取销售信息
 * @return Sellinfo
 */
public Sellinfo getSellInfoById(Carinfo carInfo);
/**
 * 增加销售信息
 * @param sellInfo
 * @return int
 */
public int addSellInfo(Sellinfo sellInfo);
/**
 * 删除销售信息
 * @param sellInfo
 * @return int
 */
public int deleteSellInfo(Sellinfo sellInfo);
/**
 * 修改销售信息
 * @param sellInfo
 * @return int
 */
public int updateSellInfo(Sellinfo sellInfo);

}
