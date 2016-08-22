package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.Carchart;
import cn.com.dao.ICarchartDao;

import cn.com.service.ICarchartService;
@Service
public class CarchartServiceImpl implements ICarchartService{
	@Resource
private ICarchartDao carchartDao=null;
	
	public ICarchartDao getCarchartDao() {
		return carchartDao;
	}
	public void setCarchartDao(ICarchartDao carchartDao) {
		this.carchartDao = carchartDao;
	}
	@Override
	public List<Carchart> chartinfo(int year, int month) {
		
		// TODO Auto-generated method stub
		return carchartDao.chartinfo(year, month);
	}
	@Override
	public List<Carchart> chartinfo() {
		// TODO Auto-generated method stub
		
		return carchartDao.chartinfo();
	}
	@Override
	public Map<String, Carchart> chartinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		
		return carchartDao.chartinfo(year, month, day);
	}
	@Override
	public Map<String, Carchart> chartinfo(int year) {
		// TODO Auto-generated method stub
		return carchartDao.chartinfo(year);
	}

}
