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
	 * 获取所有系统信息
	 * @return Map<Long, SystemConfig>
	 */
	public Map<Long, Systemconfig> getAllSystemConfig();
/**
 * 通过Id获取系统销售信息
 * @param systemConfig
 * @return carInfo
 */
	public Systemconfig getSystemConfigById(Carinfo carInfo);
/**
 * 添加汽车系统配置信息的方法
 * @param systemConfig
 *@return boolean 
 */
	public boolean addSystemConfig(Systemconfig systemConfig);
/**
 * 修改汽车系统配置信息的方法
 *  @param systemConfig
 * @return boolean 
 */
	public boolean updateSystemConfig(Systemconfig systemConfig);
}
