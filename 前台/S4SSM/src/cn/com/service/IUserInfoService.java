package cn.com.service;


import org.springframework.stereotype.Repository;

import cn.com.pojo.*;


/**
 * 用户信息服务接口
 * @author
 */
@Repository
public interface IUserInfoService {
  /**
   * 登录的服务
   * @return UserInfo
   */
	public Userinfo3 login(Userinfo3 userInfo);
  /**
   * 按唯一条件获取用户信息的服务
   *@return UserInfo 
   */
	public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo);
  /**
   * 添加用户信息的服务
   *@return boolean 
   */
	public boolean addUserInfo(Userinfo3 userInfo);
  /**
   * 修改用户信息的服务
   *@return boolean 
   */
	public boolean updateUserInfo(Userinfo3 userInfo);
  /**
   * 修改用户密码的服务
   *@return boolean 
   */
	public boolean updateUserPwd(Userinfo3 userInfo);
}
