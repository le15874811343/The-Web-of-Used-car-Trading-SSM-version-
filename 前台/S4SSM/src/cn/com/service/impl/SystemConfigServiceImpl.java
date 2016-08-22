package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.dao.ISystemConfigDao;
import cn.com.service.ISystemConfigService;
@Service
public class SystemConfigServiceImpl implements ISystemConfigService{
	@Resource
	private ISystemConfigDao systemConfigDao=null;
	
	public ISystemConfigDao getSystemConfigDao() {
		return systemConfigDao;
	}
	public void setSystemConfigDao(ISystemConfigDao systemConfigDao) {
		this.systemConfigDao = systemConfigDao;
	}
	/**
	 * 获取所有SystemConfig结合的业务
	 * @return
	 */
	@Override
	public Map<Long, Systemconfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
		return systemConfigDao.getAllSystemConfig();
	}
	/**
	 * 通过u—ID获取SystemConfig
	 * @param systemConfig
	 * @return
	 */
	@Override
	public Systemconfig getSystemConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return systemConfigDao.getSystemConfigById(carInfo);
	}
	@Override
	public boolean addSystemConfig(Systemconfig systemConfig) {
		// TODO Auto-generated method stub
		 boolean flag=false;
		 if(systemConfigDao.addSystemConfig(systemConfig)>0){
			 flag=true;
		 }
		return flag;
	}
	@Override
	public boolean updateSystemConfig(Systemconfig systemConfig) {
		// TODO Auto-generated method stub
		 boolean flag=false;
		 if(systemConfigDao.updateSystemConfig(systemConfig)>0){
			 flag=true;
		 }
		return flag;
	}

}
