package cn.com.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;



import cn.com.pojo.Carchart;
/**
 * 品牌销量服务接口
 * 
 */
@Repository
public interface ICarchartService {
  /**
   * 按年月查询的服务
   * 
   */
	public List<Carchart> chartinfo(int year,int month);
/**
 * 查询不同年的服务
 * 
 */
	public List<Carchart> chartinfo();
/**
 * 按年月日查询的服务
 * 
 */
	public Map<String, Carchart> chartinfo(int year, int month, int day);
/**
 * 按年查询的服务
 * 
 */
	public Map<String, Carchart> chartinfo(int year);
}
