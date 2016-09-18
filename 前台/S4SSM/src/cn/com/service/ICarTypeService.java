package cn.com.service;

import cn.com.pojo.*;

import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 车型服务接口
 * @author
 */
@Repository
public interface ICarTypeService {
	/**
	 * 按热度获取车型信息的服务
	 * @return Map<Integer,CarType>
	 */
	public Map<Integer, Cartype> getCarTypeByCount();
	/**
	 * 获取所有车型信息的服务
	 * @return Map<Integer,CarType>
	 */
	public Map<Integer, Cartype> getAllCarType();
}
