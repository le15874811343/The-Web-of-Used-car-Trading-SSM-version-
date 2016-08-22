package cn.com.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.Price;
import cn.com.dao.IPriceDao;

@Repository
public class PriceDaoImpl extends BaseDao implements IPriceDao {

	@Override
	public List<Price>  getsellinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		List<Price> map=new ArrayList<Price>();
		Map<String, Object> parmas=new HashMap<String,Object>();
		if(month>9)
		{
			parmas.put("month", month);
		}
		else
		{
			parmas.put("month", "0"+month);
		}
		if(day>9)
		{
			parmas.put("day", day);
		}
		else
		{
			parmas.put("day",  "0"+day);
		}
		parmas.put("time", year+"-"+parmas.get("month")+"-"+parmas.get("day"));
		
		
		try {
			
		map=super.getSqlSessionTemplate().selectList("cn.com.pojo.PriceMapper.yearmonthday", parmas);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Price> getsellinfo(int year, int month) {
		// TODO Auto-generated method stub
		List<Price> list=new ArrayList<Price>();
		Map<String, Object> parmas=new HashMap<String,Object>();
		if(month>9)
		{
			parmas.put("time", year+"-"+month);
		}
		else
		{
			parmas.put("time", year+"-0"+month);
		}
		
	try {
	
			list=super.getSqlSessionTemplate().selectList("cn.com.pojo.PriceMapper.yearmonth",parmas);
			
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public List<Price> getsellinfo(int year) {
		// TODO Auto-generated method stub
		List<Price> map=new ArrayList<Price>();
		Map<String, Object> parmas=new HashMap<String,Object>();
		 parmas.put("year", year);
		
		try {
			map=super.getSqlSessionTemplate().selectList("cn.com.pojo.PriceMapper.year",parmas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Price> getsellinfo() {
		// TODO Auto-generated method stub
		List<Price> list=new ArrayList<Price>();
		
		try {
			list=super.getSqlSessionTemplate().selectList("cn.com.pojo.PriceMapper.getsellinfo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
