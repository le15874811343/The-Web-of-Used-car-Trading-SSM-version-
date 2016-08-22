package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.IProcedureInfoDao;

import cn.com.service.IProcedureInfoService;
@Service
public class ProcedureInfoServiceImpl implements IProcedureInfoService{
	@Resource
private IProcedureInfoDao procedureInfoDaoImpl=null;

	public IProcedureInfoDao getProcedureInfoDaoImpl() {
	return procedureInfoDaoImpl;
}

public void setProcedureInfoDaoImpl(IProcedureInfoDao procedureInfoDaoImpl) {
	this.procedureInfoDaoImpl = procedureInfoDaoImpl;
}

	@Override
	public Map<Long, Procedureinfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getAllProcedureInfo();
	}

	@Override
	public Procedureinfo getProcedureInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getProcedureInfoById(carInfo);
	}

	@Override
	public boolean addProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.addProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.updateProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		
		return flag;
	}

	@Override
	public boolean deleteprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.deleteprocedureinfouser(p)>0)
		{
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deletecidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.deletecidprocedureinfouser(p)>0)
		{
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean checkprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.checkprocedureinfouser(p);
	}

	@Override
	public boolean checkcidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.checkcidprocedureinfouser(p);
	}

}
