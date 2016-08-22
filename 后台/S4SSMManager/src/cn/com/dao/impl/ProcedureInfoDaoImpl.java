package cn.com.dao.impl;


import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

import cn.com.dao.IProcedureInfoDao;

@Repository
public class ProcedureInfoDaoImpl extends BaseDao implements IProcedureInfoDao{

	@Override
	public Map<Long, Procedureinfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
//		private long u_id;
//		 private long c_id;
//		 private String purchaseTax;
//		 private String drivingLicense;
//		 private String ncw;
//		 private String registration;
//		 private String newInvoice;
//		 private int key;
//		 private int transferTimes;
//		 private String transferTicket;
	
		Map<Long, Procedureinfo> procedureInfoMap=new HashMap<Long, Procedureinfo>();
	
		 procedureInfoMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.ProcedureinfoMapper.getAllProcedureInfo",  "cId");

		return procedureInfoMap;
	}

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

	@Override
	public int updateProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub

	
		
		return super.getSqlSessionTemplate().update("cn.com.pojo.ProcedureinfoMapper.updateProcedureInfo", procedureInfo);
	}

	@Override
	public int deleteprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ProcedureinfoMapper.deleteprocedureinfouser", p);
	}

	@Override
	public int deletecidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ProcedureinfoMapper.deletecidprocedureinfouser", p);
	}

	@Override
	public boolean checkprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.ProcedureinfoMapper.checkprocedureinfouser", p, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}

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
