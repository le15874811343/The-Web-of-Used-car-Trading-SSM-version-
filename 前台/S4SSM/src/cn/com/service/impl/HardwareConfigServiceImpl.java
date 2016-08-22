package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.service.IHardwareConfigService;
import cn.com.dao.IHardwareConfig;
@Service
public class HardwareConfigServiceImpl implements IHardwareConfigService{
	@Resource
	private IHardwareConfig hardwareConfigDaoImpl=null;
	
	public IHardwareConfig getHardwareConfigDaoImpl() {
		return hardwareConfigDaoImpl;
	}

	public void setHardwareConfigDaoImpl(IHardwareConfig hardwareConfigDaoImpl) {
		this.hardwareConfigDaoImpl = hardwareConfigDaoImpl;
	}

	@Override
	public Map<Long, Hardwareconfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.getAllHardwareConfig();
	}

	@Override
	public Hardwareconfig getHardwareConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return hardwareConfigDaoImpl.getHardwareConfigById(carInfo);
	}

	@Override
	public boolean addHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(hardwareConfigDaoImpl.addHardwareConfig(hardwareConfig)>0){
			flag=true;
		}
		return flag;
	}

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
