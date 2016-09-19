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
	/**
	 * 添加车龄信息的服务
	 * @return   boolean
	 */
	public boolean addCarAge(Carage carAge);
	/**
	 * 删除车龄信息的服务
	 * @return   boolean
	 */
	public boolean deleteCarAge(Carage carAge);
	/**
	 * 修改车龄信息的服务
	 * @return   boolean
	 */
	public boolean updateCarAge(Carage carAge);
	/**
	 * 获取车龄信息的服务
	 * @return CarAge
	 */
	public Carage getCarAgeById(Carage carAge);
}
