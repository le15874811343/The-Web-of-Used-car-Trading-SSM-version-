package cn.com.dao.impl;

import java.util.*;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;

import cn.com.dao.ISystemConfigDao;
/**
 * 
 * 
 * 汽车系统配置信息操作实现类
 * @author lej
 */ 
@Repository
public class SystemConfigDaoImpl extends BaseDao implements ISystemConfigDao{
        /**
	 * 获取所有系统信息
	 * @return Map<Long, SystemConfig>
	 */
	@Override
	public Map<Long, Systemconfig> getAllSystemConfig() {
		// TODO Auto-generated method stub

		Map<Long, Systemconfig> systemConfigMap=new HashMap<Long, Systemconfig>();
	
		try {
	systemConfigMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.SystemconfigMapper.getAllSystemConfig", "cId");
	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return systemConfigMap;
	}
/**
 * 通过Id获取系统信息
 * @param systemConfig
 * @return carInfo
 */
	@Override
	public Systemconfig getSystemConfigById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Systemconfig systemConfig2=null;
	
		
		try {
			systemConfig2=	 (Systemconfig) super.getSqlSessionTemplate().selectList("cn.com.pojo.SystemconfigMapper.getSystemConfigById", carInfo).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemConfig2;
	}
/**
 * 添加汽车系统配置信息的方法
 * @param systemConfig
 *@return int 
 */
@Override
public int addSystemConfig(Systemconfig systemConfig) {
	// TODO Auto-generated method stub
	 int count=0;
	 try{
		  super.getSqlSessionTemplate().insert("cn.com.pojo.SystemconfigMapper.insertSelective", systemConfig);
		  count=1;
	 }
	 catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	 }
	return count;
}
/**
 * 修改汽车系统配置信息的方法
 *  @param systemConfig
 * @return int 
 */
@Override
public int updateSystemConfig(Systemconfig systemConfig) {
	// TODO Auto-generated method stub
	//返回受影响的行数
	return super.getSqlSessionTemplate().update("cn.com.pojo.SystemconfigMapper.updateSystemConfig", systemConfig);
}

}
