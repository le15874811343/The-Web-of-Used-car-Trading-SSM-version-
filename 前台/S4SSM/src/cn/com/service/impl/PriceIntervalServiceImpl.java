package cn.com.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.dao.IPriceIntervalDao;
import cn.com.service.IPriceIntervalService;
@Service
public class PriceIntervalServiceImpl implements IPriceIntervalService{
	@Resource
   private IPriceIntervalDao intervalDao=null;
   
	public IPriceIntervalDao getIntervalDao() {
	return intervalDao;
}

public void setIntervalDao(IPriceIntervalDao intervalDao) {
	this.intervalDao = intervalDao;
}

	@Override
	public Map<Integer, Priceinterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		return intervalDao.getPriceIntervalByCount();
	}

}
