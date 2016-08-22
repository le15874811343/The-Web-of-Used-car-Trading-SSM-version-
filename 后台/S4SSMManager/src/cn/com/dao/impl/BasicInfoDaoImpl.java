package cn.com.dao.impl;
import java.util.*;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;
import cn.com.dao.*;

@Repository
public class BasicInfoDaoImpl extends BaseDao implements IBasicInfoDao{

	@Override
	public Map<Long, Basicinfo> getAllBasic() {
		// TODO Auto-generated method stub
		Map<Long, Basicinfo> mapBasicInfo=new HashMap<Long, Basicinfo>();
		
		mapBasicInfo=    super.getSqlSessionTemplate().selectMap("cn.com.pojo.BasicinfoMapper.getAllBasic", "cId");
		
		return mapBasicInfo;
	}

	@Override
	public Basicinfo getAllBasicById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Basicinfo basicInfo2=null;
	try{
		basicInfo2=(Basicinfo) super.getSqlSessionTemplate().selectMap("cn.com.pojo.BasicinfoMapper.getAllBasicById",carInfo, "cId").get(carInfo.getcId());
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return basicInfo2;
	}

	@Override
	public int addBasicInfo(Basicinfo basicInfo) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
			super.getSqlSessionTemplate().insert("cn.com.pojo.BasicinfoMapper.insertSelective", basicInfo);
		count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	@Override
	public int updateBasicInfo(Basicinfo basicInfo) {
		// TODO Auto-generated method stub
	
	
	
		return  super.getSqlSessionTemplate().update("cn.com.pojo.BasicinfoMapper.updateBasicInfo", basicInfo);
	}

	@Override
	public int deletebasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.BasicinfoMapper.deletebasicinfo", b);
	}

	@Override
	public int deletecidbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.BasicinfoMapper.deletecidbasicinfo", b);
	}

	@Override
	public boolean checkbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		boolean flag=false;
	
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.BasicinfoMapper.checkbasicinfo", b, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}

	@Override
	public boolean checkcidbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.BasicinfoMapper.checkcidbasicinfo", b, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}

}
