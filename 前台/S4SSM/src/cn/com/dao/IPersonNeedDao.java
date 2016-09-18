package cn.com.dao;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 个人需求信息操作接口
 *@author 
 */
@Repository
public interface IPersonNeedDao {
  /**
   * 
   * 添加个人需求信息的方法
   *@return int 
   */
public int addPersonNeed(Personneed personNeed);
  /**
   * 
   * 删除个人需求信息的方法
   *@return int 
   */
public int deletePersonNeed(Personneed personNeed);
  /**
   * 
   * 获取个人需求信息的方法
   *@return Personneed
   */
public Personneed getPerSonNeed(Personneed personNeed);
}
