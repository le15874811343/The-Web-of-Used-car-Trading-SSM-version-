package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;


public interface ISystemConfigDao {
	/**
	 * 获取所有系统信息
	 * @return
	 */
public Map<Long, Systemconfig> getAllSystemConfig();
/**
 * 通过Id获取系统销售信息
 * @param systemConfig
 * @return
 */
public Systemconfig getSystemConfigById(Carinfo carInfo);
public int addSystemConfig(Systemconfig systemConfig);
public int updateSystemConfig(Systemconfig systemConfig);
public int deletesystemconfiguser(Systemconfig s);
public int deletecidsystemconfiguser(Systemconfig s);
public boolean checksystemconfiguser(Systemconfig s);
public boolean checkcidsystemconfiguser(Systemconfig s);


}
