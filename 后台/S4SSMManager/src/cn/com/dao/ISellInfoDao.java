package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;
/**
  * 
  * 销售信息操作接口
  * @author lej
  */
public interface ISellInfoDao {
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
/**
 * 根据车主编号删除销售信息的方法
 *@return int  
 */
public int deletesellinfouser(Sellinfo s);
/**
 * 根据车编号删除销售信息的方法
 *@return int  
 */
public int deletecidsellinfouser(Sellinfo s);
/**
 * 
 * 检查是否还有与某车主编号关联的销售信息
 * @return boolean
 */
public boolean checksellinfouser(Sellinfo s);
/**
 * 
 * 检查是否还有与某车编号关联的销售信息
 * @return boolean
 */
public boolean checkcidsellinfouser(Sellinfo s);

}
