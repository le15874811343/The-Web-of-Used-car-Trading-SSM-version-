package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

/**
 * 汽车硬件配置信息服务接口
 *@author lej 
 */
@Repository
public interface IHardwareConfigService {
  /**
   * 
   * 获取所有汽车硬件配置信息的服务
   *@return Map<Long,HardwareConfig> 
   */
	public Map<Long, Hardwareconfig> getAllHardwareConfig();
/**
 * 按编号获取汽车硬件配置信息的服务
 * @parma carInfo
 * @return HardwareConfig 
 */
	public Hardwareconfig getHardwareConfigById(Carinfo carInfo);
/**
 * 添加汽车硬件配置信息的服务
 * @parma hardwareConfig
 * @return boolean
 */
	public boolean addHardwareConfig(Hardwareconfig hardwareConfig);
/**
 * 修改汽车硬件配置信息的服务
 * @parma hardwareConfig
 * @return boolean
 */
	public boolean updateHardwareConfig(Hardwareconfig hardwareConfig);
/**
 * 根据车主编号删除汽车硬件配置信息的服务
 *@return boolean  
 */
	public boolean deletehardwareconfiguser(Hardwareconfig h);
/**
 * 根据车编号删除汽车硬件配置信息的服务
 *@return boolean  
 */
	 public boolean deletecidhardwareconfiguser(Hardwareconfig h);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车硬件配置信息的服务
 * @return boolean
 */
	 public boolean checkhardwareconfig(Hardwareconfig h);
/**
 * 
 * 检查是否还有与某车编号关联的汽车硬件配置信息的服务
 * @return boolean
 */
	 public boolean checkcidhardwareconfig(Hardwareconfig h);
}
