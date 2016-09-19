package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 
 * 
 * 汽车系统配置信息服务接口
 * @author lej
 */
@Repository
public interface ISystemConfigService {
        /**
	 * 获取所有系统信息的服务
	 * @return Map<Long, SystemConfig>
	 */
	public Map<Long, Systemconfig> getAllSystemConfig();
/**
 * 通过Id获取系统销售信息的服务
 * @param carInfo
 * @return SystemConfig
 */
	public Systemconfig getSystemConfigById(Carinfo carInfo);
/**
 * 添加汽车系统配置信息的服务
 * @param systemConfig
 *@return boolean 
 */
	public boolean addSystemConfig(Systemconfig systemConfig);
/**
 * 修改汽车系统配置信息的服务
 * @param systemConfig
 *@return boolean 
 */
	public boolean updateSystemConfig(Systemconfig systemConfig);
/**
 * 根据车主编号删除汽车系统配置信息的服务
 *@return boolean  
 */
	 public boolean deletesystemconfiguser(Systemconfig s);
/**
 * 根据车编号删除汽车系统配置信息的服务
 *@return boolean  
 */
	 public boolean deletecidsystemconfiguser(Systemconfig s);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车系统配置信息的服务
 * @return boolean
 */
	 public boolean checksystemconfiguser(Systemconfig s);
/**
 * 
 * 检查是否还有与某车编号关联的汽车系统配置信息的服务
 * @return boolean
 */
	 public boolean checkcidsystemconfiguser(Systemconfig s);
}
