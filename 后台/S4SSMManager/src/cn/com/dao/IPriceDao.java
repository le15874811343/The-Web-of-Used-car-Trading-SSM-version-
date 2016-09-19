package cn.com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 营业额查询操作接口
 * 
 */
@Repository
public interface IPriceDao {
	/**
	 * 按年月日查询的方法
	 * 
	 */
	public  List<Price> getsellinfo(int year,int month,int day);
	/**
	 * 按年月查询的方法
	 * 
	 */
	public List<Price> getsellinfo(int year,int month);
	/**
	 * 按年查询的方法
	 * 
	 */
	public List<Price> getsellinfo(int year);
	/**
	 * 查询不同年营业额的方法
	 * 
	 */
	public List<Price> getsellinfo();
}
