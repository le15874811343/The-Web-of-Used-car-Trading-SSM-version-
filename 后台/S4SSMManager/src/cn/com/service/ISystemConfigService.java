package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface ISystemConfigService {
	/**
	 * 获取所有SystemConfig结合的业务
	 * @return
	 */
	public Map<Long, Systemconfig> getAllSystemConfig();
	/**
	 * 通过u—ID获取SystemConfig
	 * @param systemConfig
	 * @return
	 */
	public Systemconfig getSystemConfigById(Carinfo carInfo);
	public boolean addSystemConfig(Systemconfig systemConfig);
	public boolean updateSystemConfig(Systemconfig systemConfig);
	 public boolean deletesystemconfiguser(Systemconfig s);
	 public boolean deletecidsystemconfiguser(Systemconfig s);
	 public boolean checksystemconfiguser(Systemconfig s);
	 public boolean checkcidsystemconfiguser(Systemconfig s);
}
