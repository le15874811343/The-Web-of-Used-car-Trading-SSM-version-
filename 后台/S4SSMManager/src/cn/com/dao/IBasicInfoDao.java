package cn.com.dao;

import java.util.Map;
import cn.com.pojo.*;

public interface IBasicInfoDao {
	/**
	 * 获取车辆信息
	 * @return
	 */
public Map<Long, Basicinfo> getAllBasic();
public Basicinfo getAllBasicById(Carinfo carInfo);
public int addBasicInfo(Basicinfo basicInfo);
public int updateBasicInfo( Basicinfo basicInfo);
public int deletebasicinfo(Basicinfo b);
public int deletecidbasicinfo(Basicinfo b);
public boolean checkbasicinfo(Basicinfo b);
public boolean checkcidbasicinfo(Basicinfo b);
}
