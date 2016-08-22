package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

import cn.com.dao.IHardwareConfig;

@Repository
public class HardwareConfigDaoImpl extends BaseDao implements IHardwareConfig {

	@Override
	public Map<Long, Hardwareconfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
	
		Map<Long, Hardwareconfig> hardMap = new HashMap<Long, Hardwareconfig>();
	hardMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.HardwareconfigMapper.getAllHardwareConfig","cId");
		return hardMap;
	}

	@Override
	public Hardwareconfig getHardwareConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Hardwareconfig hardwareConfig2 = null;
		try{
		hardwareConfig2=(Hardwareconfig) super.getSqlSessionTemplate().selectMap("cn.com.pojo.HardwareconfigMapper.getHardwareConfigById", carInfo, "cId").get(carInfo.getcId());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hardwareConfig2;
	}

	@Override
	public int addHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getSqlSessionTemplate().insert("cn.com.pojo.HardwareconfigMapper.insertSelective", hardwareConfig);
			count=1;
			}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		
		return  super.getSqlSessionTemplate().update("cn.com.pojo.HardwareconfigMapper.updateHardwareConfig", hardwareConfig);

	}

}
