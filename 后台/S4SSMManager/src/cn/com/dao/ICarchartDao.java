package cn.com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 品牌销量操作接口
 * 
 */
@Repository
public interface ICarchartDao {
  /**
   * 按年月查询的方法
   * 
   */
public List<Carchart> chartinfo(int year,int month);
/**
 * 查询不同年的方法
 * 
 */
public List<Carchart> chartinfo( );
/**
 * 按年月日查询的方法
 * 
 */
public Map<String, Carchart> chartinfo(int year,int month,int day);
/**
 * 按年查询的方法
 * 
 */
public Map<String, Carchart> chartinfo(int year);
}
