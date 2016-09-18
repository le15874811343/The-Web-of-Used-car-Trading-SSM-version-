package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 手续信息操作接口
 * @author lej
 */
@Repository
public interface IProcedureInfoDao {
   /**
   * 
   * 获取所有手续信息的方法
   *@return Map<Long,Procedureinfo> 
   */
public Map<Long, Procedureinfo> getAllProcedureInfo();
  /**
   * 
   * 根据编号获取手续信息的方法
   *@return Procedureinfo
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
}
