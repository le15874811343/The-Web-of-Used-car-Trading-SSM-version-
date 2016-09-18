package cn.com.service;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 车龄信息服务接口
 *@author  lej 
 */
@Repository
public interface ICarAgeService {
	/**
	 * 按热度获取车龄信息的服务
	 * @return Map<Integer,CarAge>
	 */
	public Map<Integer,Carage> getCarAgeByCount();
}
