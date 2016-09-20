package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

import cn.com.dao.IHardwareConfig;
/**
 * 汽车硬件配置信息操作实现类
 *@author lej 
 */
@Repository
public class HardwareConfigDaoImpl extends BaseDao implements IHardwareConfig {
  /**
   * 
   * 获取所有汽车硬件配置信息的方法
   *@return Map<Long,HardwareConfig> 
   */
	@Override
	public Map<Long, Hardwareconfig> getAllHardwareConfig() {
		// TODO Auto-generated method stub
	
		Map<Long, Hardwareconfig> hardMap = new HashMap<Long, Hardwareconfig>();
	hardMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.HardwareconfigMapper.getAllHardwareConfig","cId");
		return hardMap;
	}
/**
 * 按编号获取汽车硬件配置信息的方法
 * @parma carInfo
 * @return HardwareConfig 
 */
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
/**
 * 添加汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
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
/**
 * 修改汽车硬件配置信息的方法
 * @parma hardwareConfig
 * @return int
 */
	@Override
	public int updateHardwareConfig(Hardwareconfig hardwareConfig) {
		// TODO Auto-generated method stub
		
		return  super.getSqlSessionTemplate().update("cn.com.pojo.HardwareconfigMapper.updateHardwareConfig", hardwareConfig);

	}
/**
 * 根据车主编号删除汽车硬件配置信息的方法
 *@return int  
 */
	@Override
	public int deletehardwareconfiguser(Hardwareconfig h) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.HardwareconfigMapper.deletehardwareconfiguser", h);
	}
/**
 * 根据车编号删除汽车硬件配置信息的方法
 *@return int  
 */
	@Override
	public int deletecidhardwareconfiguser(Hardwareconfig h) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.HardwareconfigMapper.deletecidhardwareconfiguser", h);
	}
/**
 * 
 * 检查是否还有与某车主编号关联的汽车硬件配置信息
 * @return boolean
 */
	@Override
	public boolean checkhardwareconfig(Hardwareconfig h) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.HardwareconfigMapper.checkhardwareconfig", h, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车硬件配置信息
 * @return boolean
 */
	@Override
	public boolean checkcidhardwareconfig(Hardwareconfig h) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.HardwareconfigMapper.checkcidhardwareconfig", h, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}

}
