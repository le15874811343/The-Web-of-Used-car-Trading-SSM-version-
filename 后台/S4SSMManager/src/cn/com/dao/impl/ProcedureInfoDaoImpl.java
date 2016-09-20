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

	
		
		return super.getSqlSessionTemplate().update("cn.com.pojo.ProcedureinfoMapper.updateProcedureInfo", procedureInfo);
	}
/**
 * 根据车主编号删除手续信息的方法
 *@return int  
 */
	@Override
	public int deleteprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ProcedureinfoMapper.deleteprocedureinfouser", p);
	}
/**
 * 根据车编号删除手续信息的方法
 *@return int  
 */
	@Override
	public int deletecidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ProcedureinfoMapper.deletecidprocedureinfouser", p);
	}
/**
 * 
 * 检查是否还有与某车主编号关联的手续信息
 * @return boolean
 */
	@Override
	public boolean checkprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.ProcedureinfoMapper.checkprocedureinfouser", p, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}
/**
 * 
 * 检查是否还有与某车编号关联的手续信息
 * @return boolean
 */
	@Override
	public boolean checkcidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.ProcedureinfoMapper.checkcidprocedureinfouser", p, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}

}
