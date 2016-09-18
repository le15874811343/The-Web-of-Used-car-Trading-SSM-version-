package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.ISellInfoDao;
import cn.com.service.ISellInfoService;
/**
  * 
  * 销售信息服务实现类
  * @author lej
  */
@Service
public class SellInfoServiceImpl implements ISellInfoService{
	@Resource
private ISellInfoDao sellInfoDao=null;//销售信息操作接口的引用

	public ISellInfoDao getSellInfoDao() {
	return sellInfoDao;
}

public void setSellInfoDao(ISellInfoDao sellInfoDao) {
	this.sellInfoDao = sellInfoDao;
}
        /**
	 * 获取所有销售信息
	 * @return   Map<Long, SellInfo>
	 */
	@Override
	public Map<Long, Sellinfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		return sellInfoDao.getAllSellInfo();
	}
/**
 * 根据车编号获取销售信息
 * @return SellInfo
 */
	@Override
	public Sellinfo getSellInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.getSellInfoById(carInfo);
	}
/**
 * 增加销售信息
 * @param sellInfo
 * @return boolean
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
 * 删除销售信息
 * @param sellInfo
 * @return int
 */
	@Override
	public int deleteSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.deleteSellInfo(sellInfo);
	}
/**
 * 修改销售信息
 * @param sellInfo
 * @return boolean
 */
	@Override
	public boolean updateSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(sellInfoDao.updateSellInfo(sellInfo)>0){
			flag=true;
		}
		return flag;
	}

}
