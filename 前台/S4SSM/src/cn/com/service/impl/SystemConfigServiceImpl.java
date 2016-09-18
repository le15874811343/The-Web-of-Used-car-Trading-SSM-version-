package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.dao.ISystemConfigDao;
import cn.com.service.ISystemConfigService;
/**
 * 
 * 
 * 汽车系统配置信息服务实现类
 * @author lej
 */
@Service
public class SystemConfigServiceImpl implements ISystemConfigService{
	@Resource
	private ISystemConfigDao systemConfigDao=null; //汽车系统配置信息操作接口的引用
	
	public ISystemConfigDao getSystemConfigDao() {
		return systemConfigDao;
	}
	public void setSystemConfigDao(ISystemConfigDao systemConfigDao) {
		this.systemConfigDao = systemConfigDao;
	}
        /**
	 * 获取所有系统信息
	 * @return Map<Long, SystemConfig>
	 */
	@Override
	public Map<Long, Systemconfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
		return systemConfigDao.getAllSystemConfig();
	}
/**
 * 通过Id获取系统销售信息
 * @param systemConfig
 * @return carInfo
 */
	@Override
	public Systemconfig getSystemConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return systemConfigDao.getSystemConfigById(carInfo);
	}
/**
 * 添加汽车系统配置信息的方法
 * @param systemConfig
 *@return boolean 
 */
	@Override
	public boolean addSystemConfig(Systemconfig systemConfig) {
		// TODO Auto-generated method stub
		 boolean flag=false;
		 if(systemConfigDao.addSystemConfig(systemConfig)>0){
			 flag=true;
		 }
		return flag;
	}
/**
 * 修改汽车系统配置信息的方法
 *  @param systemConfig
 * @return boolean 
 */
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
