package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 汽车系统配置信息操作接口
 * @author lej
 * /
@Repository
public interface ISystemConfigDao {
        /**
	 * 获取所有系统信息
	 * @return Map<Long, Systemconfig>
	 */
public Map<Long, Systemconfig> getAllSystemConfig();
/**
 * 通过Id获取系统销售信息
 * @param carInfo
 * @return Systemconfig
 */
public Systemconfig getSystemConfigById(Carinfo carInfo);
/**
 * 添加汽车系统配置信息的方法
 * @param systemConfig
 *@return int 
 */
public int addSystemConfig(Systemconfig systemConfig);
/**
 * 修改汽车系统配置信息的方法
 *  @param systemConfig
 * @return int 
 */
public int updateSystemConfig(Systemconfig systemConfig);

}
