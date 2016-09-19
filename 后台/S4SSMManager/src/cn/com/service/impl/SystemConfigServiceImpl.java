package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.ISystemConfigDao;

import cn.com.service.ISystemConfigService;
/**
 * 汽车系统配置信息服务实现类
 * @author lej
 */
@Service
public class SystemConfigServiceImpl implements ISystemConfigService{
	@Resource
	private ISystemConfigDao systemConfigDao=null; //汽车系统配置操作接口的引用
	
	public ISystemConfigDao getSystemConfigDao() {
		return systemConfigDao;
	}
	public void setSystemConfigDao(ISystemConfigDao systemConfigDao) {
		this.systemConfigDao = systemConfigDao;
	}
        /**
	 * 获取所有系统信息的服务
	 * @return Map<Long, SystemConfig>
	 */
	@Override
	public Map<Long, Systemconfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
		return systemConfigDao.getAllSystemConfig();
	}
/**
 * 通过Id获取系统销售信息的服务
 * @param carInfo
 * @return SystemConfig
 */
	@Override
	public Systemconfig getSystemConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return systemConfigDao.getSystemConfigById(carInfo);
	}
/**
 * 添加汽车系统配置信息的服务
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
 * 修改汽车系统配置信息的服务
 * @param systemConfig
 *@return boolean 
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
/**
 * 根据车主编号删除汽车系统配置信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletesystemconfiguser(Systemconfig s) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(systemConfigDao.deletesystemconfiguser(s)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 根据车编号删除汽车系统配置信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecidsystemconfiguser(Systemconfig s) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(systemConfigDao.deletecidsystemconfiguser(s)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 
 * 检查是否还有与某车主编号关联的汽车系统配置信息的服务
 * @return boolean
 */
	@Override
	public boolean checksystemconfiguser(Systemconfig s) {
		// TODO Auto-generated method stub
		return systemConfigDao.checksystemconfiguser(s);
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车系统配置信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidsystemconfiguser(Systemconfig s) {
		// TODO Auto-generated method stub
		return systemConfigDao.checkcidsystemconfiguser(s);
	}

}
