package cn.com.dao;


import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IUserInfoDao {
  public Userinfo3 login(Userinfo3 userInfo);
  public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo);
  public int addUserInfo(Userinfo3 userInfo);
  public int updateUserInfo(Userinfo3 userInfo);
  public int updateUserPwd(Userinfo3 userInfo);
}
