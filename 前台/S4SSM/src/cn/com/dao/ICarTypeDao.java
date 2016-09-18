package cn.com.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 车型操作接口
 * @author
 */
@Repository
public interface ICarTypeDao {
	/**
	 * 按热度获取车型信息的方法
	 * @return Map<Integer,Cartype>
	 */
	public Map<Integer, Cartype> getCarTypeByCount();
	/**
	 * 获取所有车型信息的方法
	 * @return  Map<Integer,Cartype>
	 */
	public Map<Integer, Cartype> getAllCarType();
}
