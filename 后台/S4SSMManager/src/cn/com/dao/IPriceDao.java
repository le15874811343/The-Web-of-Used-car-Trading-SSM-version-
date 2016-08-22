package cn.com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IPriceDao {
	public  List<Price> getsellinfo(int year,int month,int day);
	public List<Price> getsellinfo(int year,int month);
	public List<Price> getsellinfo(int year);
	public List<Price> getsellinfo();
}
