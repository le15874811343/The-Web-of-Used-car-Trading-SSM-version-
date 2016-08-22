package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.ISellInfoDao;

import cn.com.service.ISellInfoService;
@Service
public class SellInfoServiceImpl implements ISellInfoService{
	@Resource
private ISellInfoDao sellInfoDao=null;

	public ISellInfoDao getSellInfoDao() {
	return sellInfoDao;
}

public void setSellInfoDao(ISellInfoDao sellInfoDao) {
	this.sellInfoDao = sellInfoDao;
}

	@Override
	/**
	 * 获取所有销售信息业务
	 */
	public Map<Long, Sellinfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		return sellInfoDao.getAllSellInfo();
	}

	@Override
	/**
	 * 根据车编号获取销售情况业务
	 */
	public Sellinfo getSellInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.getSellInfoById(carInfo);
	}
	/**
	 * 增加销售情况业务
	 */
	@Override
	public boolean addSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.addSellInfo(sellInfo)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 删除销售情况业务
	 */
	@Override
	public int deleteSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.deleteSellInfo(sellInfo);
	}

	@Override
	public boolean updateSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.updateSellInfo(sellInfo)>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deletesellinfouser(Sellinfo s) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.deletesellinfouser(s)>0	)
		{
			flag=true;
		}
		
		return flag;
	}

	@Override
	public boolean deletecidsellinfouser(Sellinfo s) {
		// TODO Auto-generated method stub\
		boolean flag=false;
		if(sellInfoDao.deletecidsellinfouser(s)>0	)
		{
			flag=true;
		}
		
		return flag;
	}

	@Override
	public boolean checksellinfouser(Sellinfo s) {
		// TODO Auto-generated method stub
		return sellInfoDao.checksellinfouser(s);
	}

	@Override
	public boolean checkcidsellinfouser(Sellinfo s) {
		// TODO Auto-generated method stub
		return sellInfoDao.checkcidsellinfouser(s);
	}

}
