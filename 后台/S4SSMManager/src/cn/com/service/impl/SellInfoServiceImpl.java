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
private ISellInfoDao sellInfoDao=null; //销售信息操作接口的引用

	public ISellInfoDao getSellInfoDao() {
	return sellInfoDao;
}

public void setSellInfoDao(ISellInfoDao sellInfoDao) {
	this.sellInfoDao = sellInfoDao;
}
        /**
 	 * 获取所有销售信息的服务
	 * @return   Map<Long, SellInfo>
	 */
	@Override
	public Map<Long, Sellinfo> getAllSellInfo() {
		// TODO Auto-generated method stub
		return sellInfoDao.getAllSellInfo();
	}
/**
 * 根据车编号获取销售信息的服务
 * @return SellInfo
 */
	@Override
	public Sellinfo getSellInfoById(Carinfo carInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.getSellInfoById(carInfo);
	}
/**
 * 增加销售信息的服务
 * @param sellInfo
 * @return int
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
 * 删除销售信息的服务
 * @param sellInfo
 * @return int 成功返回1 否则返回0
 */
	@Override
	public int deleteSellInfo(Sellinfo sellInfo) {
		// TODO Auto-generated method stub
		return sellInfoDao.deleteSellInfo(sellInfo);
	}
/**
 * 修改销售信息的服务
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
/**
 * 根据车主编号删除销售信息的服务
 *@return boolean  
 */
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
/**
 * 根据车编号删除销售信息的服务
 *@return boolean  
 */
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
/**
 * 
 * 检查是否还有与某车主编号关联的销售信息的服务
 * @return boolean
 */
	@Override
	public boolean checksellinfouser(Sellinfo s) {
		// TODO Auto-generated method stub
		return sellInfoDao.checksellinfouser(s);
	}
/**
 * 
 * 检查是否还有与某车编号关联的销售信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidsellinfouser(Sellinfo s) {
		// TODO Auto-generated method stub
		return sellInfoDao.checkcidsellinfouser(s);
	}

}
