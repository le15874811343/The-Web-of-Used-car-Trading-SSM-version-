package cn.com.service;

import java.util.List;

import org.springframework.stereotype.Repository;



import cn.com.pojo.Price;
/**
 * 营业额查询服务接口
 * 
 */
@Repository
public interface IPriceService {
	/**
	 * 按年月日查询的服务
	 * 
	 */
	public   List<Price> getsellinfo(int year,int month,int day);
	/**
	 * 按年月查询的服务
	 * 
	 */
	public List<Price> getsellinfo(int year,int month);
	/**
	 * 按年查询的服务
	 * 
	 */
	public  List<Price> getsellinfo(int year);
	/**
	 * 查询不同年营业额的服务
	 * 
	 */
	public List<Price> getsellinfo();
}
