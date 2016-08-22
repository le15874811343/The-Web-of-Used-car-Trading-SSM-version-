package cn.com.service.impl;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.IPageDao;
import cn.com.dao.IUserInfoDao;
import cn.com.service.*;
@Service
public class UserInfoServiceImpl implements IUserInfoService,IPageDao{
	@Resource
   private IUserInfoDao userInfoDao=null;
	@Resource(name = "userInfoDaoImpl" )
   private IPageDao pageUser=null;
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
	@Override
	public Userinfo3 login(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		
		
		
		return userInfoDao.login(userInfo);
	}
	@Override
	public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserInfoByUnique(userInfo);
	}
	@Override
	public boolean addUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub4
		boolean flag=false;
		if( userInfoDao.addUserInfo(userInfo)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(userInfoDao.updateUserInfo(userInfo)>0){
			flag=true;
		}
		return flag;
	}
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
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return pageUser.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return pageUser.showPersonCarList(curPage, rowsPrePage, object);
	}

}
