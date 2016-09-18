package cn.com.dao.impl;


import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

import cn.com.dao.IProcedureInfoDao;
/**
 * 手续信息操作实现类
 * @author lej
 */
@Repository
public class ProcedureInfoDaoImpl extends BaseDao implements IProcedureInfoDao{
 /**
   * 
   * 获取所有手续信息的方法
   *@return Map<Long,ProcedureInfo> 
   */
	@Override
	public Map<Long, Procedureinfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
	
		Map<Long, Procedureinfo> procedureInfoMap=new HashMap<Long, Procedureinfo>();
	
		 procedureInfoMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.ProcedureinfoMapper.getAllProcedureInfo",  "cId");

		return procedureInfoMap;
	}
  /**
   * 
   * 根据编号获取手续信息的方法
   *@return ProcedureInfo
   */
	@Override
	public Procedureinfo getProcedureInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Procedureinfo procedureInfo2=null;
	
		try {
			procedureInfo2=	 (Procedureinfo) super.getSqlSessionTemplate().selectList("cn.com.pojo.ProcedureinfoMapper.getProcedureInfoById", carInfo).get(0);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureInfo2;
	}
  /**
   * 
   * 添加手续信息的方法
   *@return int
   */
	@Override
	public int addProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getSqlSessionTemplate().insert("cn.com.pojo.ProcedureinfoMapper.insertSelective", procedureInfo);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	
		
		return count;
	}
  /**
   * 
   * 修改手续信息的方法
   *@return  int
   */
	@Override
	public int updateProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub

	
		 //返回受影响的行数
		return super.getSqlSessionTemplate().update("cn.com.pojo.ProcedureinfoMapper.updateProcedureInfo", procedureInfo);
	}

}
