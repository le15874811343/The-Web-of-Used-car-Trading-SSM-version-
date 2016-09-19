package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 手续信息服务接口
 * @author lej
 */
@Repository
public interface IProcedureInfoService {
  /**
   * 
   * 获取所有手续信息的服务
   *@return Map<Long,ProcedureInfo> 
   */
	public Map<Long, Procedureinfo> getAllProcedureInfo();
  /**
   * 
   * 根据编号获取手续信息的服务
   *@return ProcedureInfo
   */
	public Procedureinfo getProcedureInfoById(Carinfo carInfo);
  /**
   * 
   * 添加手续信息的服务
   *@return boolean
   */
	public boolean addProcedureInfo(Procedureinfo procedureInfo);
  /**
   * 
   * 修改手续信息的服务
   *@return  boolean
   */
	public boolean updateProcedureInfo(Procedureinfo procedureInfo);
/**
 * 根据车主编号删除手续信息的服务
 *@return boolean  
 */
	public boolean deleteprocedureinfouser(Procedureinfo p);
/**
 * 根据车编号删除手续信息的服务
 *@return boolean  
 */
	public boolean deletecidprocedureinfouser(Procedureinfo p);
/**
 * 
 * 检查是否还有与某车主编号关联的手续信息的服务
 * @return boolean
 */
	public boolean checkprocedureinfouser(Procedureinfo p);
/**
 * 
 * 检查是否还有与某车编号关联的手续信息的服务
 * @return boolean
 */
	public boolean checkcidprocedureinfouser(Procedureinfo p);
}
