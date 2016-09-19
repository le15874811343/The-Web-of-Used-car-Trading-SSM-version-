package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;


/**
 * 汽车硬件配置信息操作接口
 *@author lej 
 */
public interface IHardwareConfig {
    /**
   * 
   * 获取所有汽车硬件配置信息的方法
   *@return Map<Long,HardwareConfig> 
   */
public Map<Long, Hardwareconfig> getAllHardwareConfig();
/**
 * 按编号获取汽车硬件配置信息的方法
 * @parma carInfo
 * @return HardwareConfig 
 */
public Hardwareconfig getHardwareConfigById(Carinfo carInfo);
/**
 * 添加汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
public int addHardwareConfig(Hardwareconfig hardwareConfig);
/**
 * 修改汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
public int updateHardwareConfig(Hardwareconfig hardwareConfig);
/**
 * 根据车主编号删除汽车硬件配置信息的方法
 *@return int  
 */
public int deletehardwareconfiguser(Hardwareconfig h);
/**
 * 根据车编号删除汽车硬件配置信息的方法
 *@return int  
 */
public int deletecidhardwareconfiguser(Hardwareconfig h);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车硬件配置信息
 * @return boolean
 */
public boolean checkhardwareconfig(Hardwareconfig h);
/**
 * 
 * 检查是否还有与某车编号关联的汽车硬件配置信息
 * @return boolean
 */
public boolean checkcidhardwareconfig(Hardwareconfig h);
}
