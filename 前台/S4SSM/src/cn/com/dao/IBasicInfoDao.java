package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IBasicInfoDao {
	/**
	 * 获取车辆信息
	 * @return
	 */
public Map<Long, Basicinfo> getAllBasic();
public Basicinfo getAllBasicById(Carinfo carInfo);
public int addBasicInfo(Basicinfo basicInfo);
public int updateBasicInfo( Basicinfo basicInfo);
}
