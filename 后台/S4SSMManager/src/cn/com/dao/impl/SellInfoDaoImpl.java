package cn.com.dao.impl;


import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

import cn.com.dao.ISellInfoDao;

@Repository
public class SellInfoDaoImpl extends BaseDao implements ISellInfoDao{
/**
 * 获取所有销售信息
 */
//	private long u_id;
//	 private long c_id;
//	 private String priceType;
//	 private String transferFee;
//	 private String stage;
	@Override
	public Map<Long, Sellinfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		
		Map<Long, Sellinfo> sellInfoMap=new HashMap<Long, Sellinfo>();
		
		 sellInfoMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.SellinfoMapper.getAllSellInfo", "cId");
		return sellInfoMap;
	}
/**
 * 根据车编号获取销售情况
 */
	@Override
	public Sellinfo getSellInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		Sellinfo sellInfo2=null;
		
		
		try {
			sellInfo2=	(Sellinfo) super.getSqlSessionTemplate().selectList("cn.com.pojo.SellinfoMapper.getSellInfoById",carInfo).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellInfo2;
	}
/**
 * 增加销售情况
 */
	@Override
	public int addSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
		 super.getSqlSessionTemplate().insert("cn.com.pojo.SellinfoMapper.insertSelective", sellInfo);
		 count=1;
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		 return count;
	}
/**
 * 删除销售情况
 */
	@Override
	public int deleteSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		int count=0;
		try{
		 super.getSqlSessionTemplate().delete("cn.com.pojo.SellinfoMapper.deleteSellInfo", sellInfo);
		 count=1;
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}
		 return count;
	}
@Override
public int updateSellInfo(Sellinfo sellInfo) {
	// TODO Auto-generated method stub

	
	
	
	
	return super.getSqlSessionTemplate().update("cn.com.pojo.SellinfoMapper.updateSellInfo", sellInfo);
}
@Override
public int deletesellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	return super.getSqlSessionTemplate().delete("cn.com.pojo.SellinfoMapper.deletesellinfouser", s);
}
@Override
public int deletecidsellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	return super.getSqlSessionTemplate().delete("cn.com.pojo.SellinfoMapper.deletecidsellinfouser", s);
}
@Override
public boolean checksellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	boolean flag=false;
	   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.SellinfoMapper.checksellinfouser", s, "cId").size()>0){
		   flag=true;
	   }
	return flag;
}
@Override
public boolean checkcidsellinfouser(Sellinfo s) {
	// TODO Auto-generated method stub
	boolean flag=false;
	   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.SellinfoMapper.checkcidsellinfouser", s, "cId").size()>0){
		   flag=true;
	   }
	return flag;
}

}
