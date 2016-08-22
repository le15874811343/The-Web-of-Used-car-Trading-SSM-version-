package cn.com.dao;
import cn.com.pojo.*;

public interface IUserInfoDao {
  public Userinfo3 login(Userinfo3 userInfo);
  public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo);
  public int addUserInfo(Userinfo3 userInfo);
  public int updateUserInfo(Userinfo3 userInfo);
  public int updateUserPwd(Userinfo3 userInfo);
  public int deleteuserinfouser(Userinfo3 u);
}
