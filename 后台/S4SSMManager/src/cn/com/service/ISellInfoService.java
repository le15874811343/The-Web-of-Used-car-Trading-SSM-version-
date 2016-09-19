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
	 * 获取所有销售信息的服务
	 * @return   Map<Long, SellInfo>
	 */
	public Map<Long, Sellinfo> getAllSellInfo();
/**
 * 根据车编号获取销售信息的服务
 * @return SellInfo
 */
	public Sellinfo getSellInfoById(Carinfo carInfo);
/**
 * 增加销售信息的服务
 * @param sellInfo
 * @return int
 */
	public boolean addSellInfo(Sellinfo sellInfo);
/**
 * 删除销售信息的服务
 * @param sellInfo
 * @return int 成功返回1 否则返回0
 */
	public int deleteSellInfo(Sellinfo sellInfo);
/**
 * 修改销售信息的服务
 * @param sellInfo
 * @return boolean
 */
	public boolean updateSellInfo(Sellinfo sellInfo);
/**
 * 根据车主编号删除销售信息的服务
 *@return boolean  
 */
	public boolean deletesellinfouser(Sellinfo s);
/**
 * 根据车编号删除销售信息的服务
 *@return boolean  
 */
	 public boolean deletecidsellinfouser(Sellinfo s);
/**
 * 
 * 检查是否还有与某车主编号关联的销售信息的服务
 * @return boolean
 */
	 public boolean checksellinfouser(Sellinfo s);
/**
 * 
 * 检查是否还有与某车编号关联的销售信息的服务
 * @return boolean
 */
	 public boolean checkcidsellinfouser(Sellinfo s);
}
