package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 汽车基本信息服务接口
 * @author lej
 */
@Repository
public interface IBasicInfoService {
/**
 * 获取所有基本信息的服务
 * @return Map<Long, BasicInfo>
 */
	public Map<Long, Basicinfo> getAllBasic();
/**
 *根据编号获取汽车基本信息的服务
 *@return BasicInfo
 */
	public Basicinfo getAllBasicById(Carinfo carInfo);
/**
 * 添加汽车基本信息的服务
 * @return boolean
 */
	public boolean addBasicInfo(Basicinfo basicInfo);
/**
 * 修改汽车基本信息的服务
 * @return boolean
 */
	public boolean updateBasicInfo(Basicinfo basicInfo);
}
