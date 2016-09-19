package cn.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.Price;
import cn.com.dao.IPriceDao;
import cn.com.dao.impl.PriceDaoImpl;
import cn.com.service.IPriceService;
/**
 * 营业额查询服务实现类
 * 
 */
@Service
public class PriceServiceImpl implements IPriceService {
    @Resource(name="priceDaoImpl")
	private IPriceDao priceDao=null; //营业额查询操作接口的引用
   

	public IPriceDao getPriceDao() {
		return priceDao;
	}

	public void setPriceDao(IPriceDao priceDao) {
		this.priceDao = priceDao;
	}
        /**
	 * 按年月日查询的服务
	 * 
	 */
	@Override
	public  List<Price> getsellinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year, month, day);
	}
        /**
 	 * 按年月查询的服务
	 * 
	 */
	@Override
	public List<Price> getsellinfo(int year, int month) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year, month);
	}
        /**
	 * 按年查询的服务
	 * 
	 */
	@Override
	public  List<Price> getsellinfo(int year) {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo(year);
	}
        /**
	 * 查询不同年营业额的服务
	 * 
	 */
	@Override
	public List<Price> getsellinfo() {
		// TODO Auto-generated method stub
		return priceDao.getsellinfo();
	}

}
