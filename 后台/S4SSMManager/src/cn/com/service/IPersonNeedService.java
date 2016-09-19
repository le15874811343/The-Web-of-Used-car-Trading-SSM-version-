package cn.com.service;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;;
/**
 * 个人需求信息服务接口
 *@author 
 */
@Repository
public interface IPersonNeedService {
  /**
   * 
   * 添加个人需求信息的服务
   *@return boolean 
   */
	public boolean addPersonNeed(Personneed personNeed);
  /**
   * 
   * 删除个人需求信息的服务
   *@return boolean 
   */
	public boolean deletePersonNeed(Personneed personNeed);
  /**
   * 
   * 获取个人需求信息的服务
   *@return PersonNeed
   */
	public Personneed getPerSonNeed(Personneed personNeed);
  /**
   * 
   * 修改个人需求信息的服务
   *@return boolean 
   */
	public boolean updatePersonNeed(Personneed personNeed);
/**
 * 
 * 检查是否还有与某用户编号关联的个人需求的服务
 * @return boolean
 */
	public boolean chekUidPerson(Personneed personneed);
/**
 * 根据用户编号删除个人需求信息的服务
 *@return boolean  
 */
	public boolean deleteUidPerson(Personneed personneed);
}
