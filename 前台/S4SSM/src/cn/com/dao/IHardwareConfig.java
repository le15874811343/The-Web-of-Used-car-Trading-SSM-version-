package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 汽车硬件配置信息操作接口
 *@author lej 
 */
@Repository
public interface IHardwareConfig {
  /**
   * 
   * 获取所有汽车硬件配置信息的方法
   *@return Map<Long,Hardwareconfig> 
   */
public Map<Long, Hardwareconfig> getAllHardwareConfig();
/**
 * 按编号获取汽车硬件配置信息的方法
 * @parma carInfo
 * @return Hardwareconfig 
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
}
