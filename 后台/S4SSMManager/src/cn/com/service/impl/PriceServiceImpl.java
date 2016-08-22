package cn.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.Price;
import cn.com.dao.IPriceDao;
import cn.com.dao.impl.PriceDaoImpl;
import cn.com.service.IPriceService;
@Service
public class PriceServiceImpl implements IPriceService {
    @Resource(name="priceDaoImpl")
	private IPriceDao priceDao=null;
   

	public IPriceDao getPriceDao() {
		return priceDao;
	}

	public void setPriceDao(IPriceDao priceDao) {
		this.priceDao = priceDao;
	}

	@Override
	public  List<Price> getsellinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year, month, day);
	}

	@Override
	public List<Price> getsellinfo(int year, int month) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year, month);
	}

	@Override
	public  List<Price> getsellinfo(int year) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year);
	}

	@Override
	public List<Price> getsellinfo() {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo();
	}

}
