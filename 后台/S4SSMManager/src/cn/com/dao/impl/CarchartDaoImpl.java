package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.Carchart;
import cn.com.dao.ICarchartDao;
import cn.com.util.DbUtil;
@Repository
public class CarchartDaoImpl extends BaseDao implements ICarchartDao {

	@Override
	public List<Carchart> chartinfo(int year,int month) {
		// TODO Auto-generated method stub
		List<Carchart> list=new ArrayList<Carchart>();
		Map<String, Object> parmas=new HashMap<String, Object>();
		if(month>9)
		{
			parmas.put("time", year+"-"+month);
		}
		else
		{
			parmas.put("time", year+"-0"+month);
		}
	
	
		
	try {
		       list=super.getSqlSessionTemplate().selectList("cn.com.pojo.CarchartMapper.yearmonth",parmas);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public List<Carchart> chartinfo() {
		// TODO Auto-generated method stub
		List<Carchart> list=new ArrayList<Carchart>();
	
	
		
	try {
		
		       list=super.getSqlSessionTemplate().selectList("cn.com.pojo.CarchartMapper.chartinfo");
		       
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public Map<String, Carchart> chartinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		Map<String, Carchart> list=new HashMap<String, Carchart>();
		Map<String, Object> parmas=new HashMap<String, Object>();
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
		       list=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarchartMapper.yearmonthday",parmas,"c_brand");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public Map<String, Carchart> chartinfo(int year) {
		// TODO Auto-generated method stub
		
		Map<String, Carchart> list=new HashMap<String, Carchart>();
		Map<String, Object> parmas=new HashMap<String, Object>();
		
		parmas.put("year", year);
		
	try {
		       list=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarchartMapper.year",parmas,"c_brand");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

}
