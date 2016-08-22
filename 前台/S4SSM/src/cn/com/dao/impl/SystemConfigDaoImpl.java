package cn.com.dao.impl;

import java.util.*;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;

import cn.com.dao.ISystemConfigDao;

@Repository
public class SystemConfigDaoImpl extends BaseDao implements ISystemConfigDao{
	/**
	 * 获取所有系统信息
	 * @return
	 */
	@Override
	public Map<Long, Systemconfig> getAllSystemConfig() {
		// TODO Auto-generated method stub
//		 private long u_id;
//		 private long c_id;
//		 private String guidanceSystem;
//		 private String alb;
//		 private String fpg;
//		 private String rpg;
//		 private String rcpa;
//		 private String dsea;
//		 private String fsea;
//		 private String dlcc;
//		 private String hfs;
//		 private String hrs;
//		 private String fsv;
//		 private String rsv;
//		 private String fsm;
//		 private String rsm;
//		 private String rvmh;
//		 private String ess;
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
 * 通过编号获取SystemConfig信息
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
@Override
public int updateSystemConfig(Systemconfig systemConfig) {
	// TODO Auto-generated method stub

	
	
	return super.getSqlSessionTemplate().update("cn.com.pojo.SystemconfigMapper.updateSystemConfig", systemConfig);
}

}
