package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.service.IHardwareConfigService;
import cn.com.dao.IHardwareConfig;
/**
 * 汽车硬件配置信息服务实现类
 *@author lej 
 */
@Service
public class HardwareConfigServiceImpl implements IHardwareConfigService{
	@Resource
	private IHardwareConfig hardwareConfigDaoImpl=null; //汽车硬件配置操作接口的引用
	 
	public IHardwareConfig getHardwareConfigDaoImpl() {
		return hardwareConfigDaoImpl;
	}

	public void setHardwareConfigDaoImpl(IHardwareConfig hardwareConfigDaoImpl) {
		this.hardwareConfigDaoImpl = hardwareConfigDaoImpl;
	}
 /**
   * 
   * 获取所有汽车硬件配置信息的服务
   *@return Map<Long,HardwareConfig> 
   */
	@Override
	public Map<Long, Hardwareconfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.getAllHardwareConfig();
	}
/**
 * 按编号获取汽车硬件配置信息的服务
 * @parma carInfo
 * @return HardwareConfig 
 */
	@Override
	public Hardwareconfig getHardwareConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.getHardwareConfigById(carInfo);
	}
/**
 * 添加汽车硬件配置信息的服务
 * @parma hardwareConfig
 * @return boolean
 */
	@Override
	public boolean addHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.addHardwareConfig(hardwareConfig)>0){
			flag=true;
		}
		return flag;
	}
/**
 * 修改汽车硬件配置信息的服务
 * @parma hardwareConfig
 * @return boolean
 */
	@Override
	public boolean updateHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.updateHardwareConfig(hardwareConfig)>0){
			flag=true;
		}
		return flag;
	}

}
