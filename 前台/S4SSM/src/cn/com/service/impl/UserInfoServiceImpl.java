package cn.com.service.impl;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.IPageDao;
import cn.com.dao.IUserInfoDao;
import cn.com.service.*;
/**
 * 用户信息服务实现类
 * @author
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService,IPageDao{
	@Resource
   private IUserInfoDao userInfoDao=null; //用户信息操作接口的引用
	@Resource(name = "userInfoDaoImpl" )
   private IPageDao pageUser=null;   //分页处理操作接口的引用
	public IUserInfoDao getUserInfoDao() {
	return userInfoDao;
}
public void setUserInfoDao(IUserInfoDao userInfoDao) {
	this.userInfoDao = userInfoDao;
}
public IPageDao getPageUser() {
	return pageUser;
}
public void setPageUser(IPageDao pageUser) {
	this.pageUser = pageUser;
}
  /**
   * 登录的服务
   * @return UserInfo
   */
	@Override
	public Userinfo3 login(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		
		
		
		return userInfoDao.login(userInfo);
	}
  /**
   * 按唯一条件获取用户信息的服务
   *@return UserInfo 
   */
	@Override
	public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserInfoByUnique(userInfo);
	}
  /**
   * 添加用户信息的服务
   *@return boolean 
   */
	@Override
	public boolean addUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub4
		boolean flag=false;
		if( userInfoDao.addUserInfo(userInfo)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 修改用户信息的服务
   *@return boolean 
   */
	@Override
	public boolean updateUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(userInfoDao.updateUserInfo(userInfo)>0){
			flag=true;
		}
		return flag;
	}
  /**
   * 修改用户密码的服务
   *@return boolean 
   */
	@Override
	public boolean updateUserPwd(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(userInfoDao.updateUserPwd(userInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public Long queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
        /**
	 *获取用户信息总记录数
	 * 
	 * @return int
	 */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return pageUser.queryPersonCarCount(object);
	}
	/**
	 * 分页获取用户信息
	 * @param curPage 当前页
	 * @param rowsPrePage 每页显示记录条数
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return pageUser.showPersonCarList(curPage, rowsPrePage, object);
	}

}
