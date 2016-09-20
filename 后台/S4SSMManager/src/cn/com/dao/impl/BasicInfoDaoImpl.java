package cn.com.dao.impl;
import java.util.*;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;
import cn.com.dao.*;
/**
 * 汽车基本信息操作实现类
 * @author lej
 */
@Repository
public class BasicInfoDaoImpl extends BaseDao implements IBasicInfoDao{
/**
 * 获取所有基本信息的方法
 * @return Map<Long, Basicinfo>
*/
	@Override
	public Map<Long, Basicinfo> getAllBasic() {
		// TODO Auto-generated method stub
		Map<Long, Basicinfo> mapBasicInfo=new HashMap<Long, Basicinfo>();
		 //获取结果集
		mapBasicInfo=    super.getSqlSessionTemplate().selectMap("cn.com.pojo.BasicinfoMapper.getAllBasic", "cId");
		
		return mapBasicInfo;
	}
/**
 *根据编号获取汽车基本信息的方法 
 *@return Basicinfo
 */
	@Override
	public Basicinfo getAllBasicById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Basicinfo basicInfo2=null;
	try{
		//获取结果
		basicInfo2=(Basicinfo) super.getSqlSessionTemplate().selectMap("cn.com.pojo.BasicinfoMapper.getAllBasicById",carInfo, "cId").get(carInfo.getcId());
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return basicInfo2;
	}
/**
 * 添加汽车基本信息的方法
 * @return int
 */
	@Override
	public int addBasicInfo(Basicinfo basicInfo) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
			//添加进数据库中
			super.getSqlSessionTemplate().insert("cn.com.pojo.BasicinfoMapper.insertSelective", basicInfo);
		count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
/**
 * 修改汽车基本信息的方法
 * @return int
 */
	@Override
	public int updateBasicInfo(Basicinfo basicInfo) {
		// TODO Auto-generated method stub
	
	
	     //返回受影响的行数
		return  super.getSqlSessionTemplate().update("cn.com.pojo.BasicinfoMapper.updateBasicInfo", basicInfo);
	}
/**
 * 根据车主编号删除汽车基本信息的方法
 *@return int  
 */
	@Override
	public int deletebasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().delete("cn.com.pojo.BasicinfoMapper.deletebasicinfo", b);
	}
/**
 * 根据车编号删除汽车基本信息的方法
 *@return int  
 */
	@Override
	public int deletecidbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().delete("cn.com.pojo.BasicinfoMapper.deletecidbasicinfo", b);
	}
/**
 * 
 * 检查是否还有与某车主编号关联的汽车基本信息
 * @return boolean
 */	
	@Override
	public boolean checkbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		boolean flag=false;
	
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.BasicinfoMapper.checkbasicinfo", b, "cId").size()>0){
			   flag=true; //若结果集大于0，则返回为真
		   }
		return flag;
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车基本信息
 * @return boolean
 */
	@Override
	public boolean checkcidbasicinfo(Basicinfo b) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.BasicinfoMapper.checkcidbasicinfo", b, "cId").size()>0){
			   flag=true; //若结果集大于0，则返回为真
		   }
		return flag;
	}

}
