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
/**
 * 根据车主编号删除汽车基本信息的服务
 *@return boolean  
 */
	 public boolean deletebasicinfo(Basicinfo b);
/**
 * 根据车编号删除汽车基本信息的服务
 *@return boolean  
 */
	 public boolean deletecidbasicinfo(Basicinfo b);
/**
 * 检查是否还有与某车主编号关联的汽车基本信息的服务
 * @return boolean
 */
	 public boolean checkbasicinfo(Basicinfo b);
/**
 * 检查是否还有与某车编号关联的汽车基本信息的服务
 * @return boolean
 */
	 public boolean checkcidbasicinfo(Basicinfo b);
}
