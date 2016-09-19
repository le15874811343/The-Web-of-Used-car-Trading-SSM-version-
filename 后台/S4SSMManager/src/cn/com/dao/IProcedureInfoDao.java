package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;
/**
 * 手续信息操作接口
 * @author lej
 */
public interface IProcedureInfoDao {
  /**
   * 
   * 获取所有手续信息的方法
   *@return Map<Long,ProcedureInfo> 
   */
public Map<Long, Procedureinfo> getAllProcedureInfo();
 /**
   * 
   * 根据编号获取手续信息的方法
   *@return ProcedureInfo
   */
public Procedureinfo getProcedureInfoById(Carinfo carInfo);
/**
   * 
   * 添加手续信息的方法
   *@return int
   */
public int addProcedureInfo(Procedureinfo procedureInfo);
  /**
   * 
   * 修改手续信息的方法
   *@return  int
   */
public int updateProcedureInfo(Procedureinfo procedureInfo);
/**
 * 根据车主编号删除手续信息的方法
 *@return int  
 */
public int deleteprocedureinfouser(Procedureinfo p);
/**
 * 根据车编号删除手续信息的方法
 *@return int  
 */
public int deletecidprocedureinfouser(Procedureinfo p);
/**
 * 
 * 检查是否还有与某车主编号关联的手续信息
 * @return boolean
 */
public boolean checkprocedureinfouser(Procedureinfo p);
/**
 * 
 * 检查是否还有与某车编号关联的手续信息
 * @return boolean
 */
public boolean checkcidprocedureinfouser(Procedureinfo p);
}
