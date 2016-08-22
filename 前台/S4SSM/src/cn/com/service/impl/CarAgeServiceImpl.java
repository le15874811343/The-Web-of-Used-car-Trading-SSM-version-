package cn.com.service.impl;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
@Service
public class CarAgeServiceImpl implements ICarAgeService {
	@Resource
  private ICarAgeDao carAgeDao=null;
  
	public ICarAgeDao getCarAgeDao() {
	return carAgeDao;
}

public void setCarAgeDao(ICarAgeDao carAgeDao) {
	this.carAgeDao = carAgeDao;
}

	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		return carAgeDao.getCarAgeByCount();
	}

}
