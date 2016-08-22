package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;

@Repository
public class UserInfoDaoImpl extends BaseDao implements IUserInfoDao, IPageDao {

	@Override
	public Userinfo3 login(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		Userinfo3 _userInfo = null;
	
		try {
		List<Userinfo3>	_userlist = super.getSqlSessionTemplate().selectList("cn.com.pojo.Userinfo3Mapper.login", userInfo);
		if(_userlist.size()>0){
			_userInfo=_userlist.get(0);
		}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _userInfo;
	}

	@Override
	public Userinfo3 getUserInfoByUnique(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		Userinfo3 _userInfo = null;
		

		try {
			List<Userinfo3> userlist = super.getSqlSessionTemplate()
					.selectList("cn.com.pojo.Userinfo3Mapper.getUserInfoByUnique",userInfo);
			if(userlist.size()>0){
				_userInfo=userlist.get(0);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _userInfo;
	}

	@Override
	public int addUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getSqlSessionTemplate().insert("cn.com.pojo.Userinfo3Mapper.insertSelective", userInfo);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int updateUserInfo(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
	

		return super.getSqlSessionTemplate().update("cn.com.pojo.Userinfo3Mapper.updateByPrimaryKeySelective", userInfo);
	}

	@Override
	public int updateUserPwd(Userinfo3 userInfo) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().update("cn.com.pojo.Userinfo3Mapper.updateUserPwd", userInfo);
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
		Long count = null;
		Userinfo3 userInfo = (Userinfo3) object;
		
		try {
			count =(Long) super.getSqlSessionTemplate().selectList("cn.com.pojo.Userinfo3Mapper.queryPersonCarCount",userInfo).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Userinfo3 userInfo = (Userinfo3) object;
		
		Map<Long, Object> userMap = new HashMap<Long, Object>();
		Map<String, Object> parmas=new HashMap<String, Object>();
		parmas.put("uAdmin", userInfo.getuAdmin());
		parmas.put("curPage", curPage);
		parmas.put("rowsPrePage", rowsPrePage);
		
		try {
			
   userMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.Userinfo3Mapper.showPersonCarList", userInfo,"uId");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userMap;
	}

}
