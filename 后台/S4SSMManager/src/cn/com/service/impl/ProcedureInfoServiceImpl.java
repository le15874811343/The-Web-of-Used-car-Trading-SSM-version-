package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.IProcedureInfoDao;

import cn.com.service.IProcedureInfoService;
/**
 * 手续信息服务实现类
 * @author lej
 */
@Service
public class ProcedureInfoServiceImpl implements IProcedureInfoService{
	@Resource
private IProcedureInfoDao procedureInfoDaoImpl=null; //手续信息操作接口的引用

	public IProcedureInfoDao getProcedureInfoDaoImpl() {
	return procedureInfoDaoImpl;
}

public void setProcedureInfoDaoImpl(IProcedureInfoDao procedureInfoDaoImpl) {
	this.procedureInfoDaoImpl = procedureInfoDaoImpl;
}
 /**
   * 
   * 获取所有手续信息的服务
   *@return Map<Long,ProcedureInfo> 
   */
	@Override
	public Map<Long, Procedureinfo> getAllProcedureInfo() {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getAllProcedureInfo();
	}
  /**
   * 
   * 根据编号获取手续信息的服务
   *@return ProcedureInfo
   */
	@Override
	public Procedureinfo getProcedureInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.getProcedureInfoById(carInfo);
	}
  /**
   * 
   * 添加手续信息的服务
   *@return boolean
   */
	@Override
	public boolean addProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.addProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 
   * 修改手续信息的服务
   *@return  boolean
   */

	@Override
	public boolean updateProcedureInfo(Procedureinfo procedureInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(procedureInfoDaoImpl.updateProcedureInfo(procedureInfo)>0){
			flag=true;
		}
		
		return flag;
	}
/**
 * 根据车主编号删除手续信息的服务
 *@return boolean  
 */
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
/**
 * 根据车编号删除手续信息的服务
 *@return boolean  
 */
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
/**
 * 
 * 检查是否还有与某车主编号关联的手续信息的服务
 * @return boolean
 */
	@Override
	public boolean checkprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.checkprocedureinfouser(p);
	}
/**
 * 
 * 检查是否还有与某车编号关联的手续信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidprocedureinfouser(Procedureinfo p) {
		// TODO Auto-generated method stub
		return procedureInfoDaoImpl.checkcidprocedureinfouser(p);
	}

}
