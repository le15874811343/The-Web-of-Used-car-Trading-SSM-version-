package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 个人汽车订单信息服务接口
 * @author lej
 */
@Repository
public interface IPerSonCarService {
	/**
        * 根据条件获取用户订单信息数量的服务
        * @return int
        */
	public Long getCarCountByWhere(Personcar perSonCar);
	  /**
        * 根据条件获取用户订单信息集合的服务
        * @return  Map<Long, PerSonCar>
        */
	public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar);
	 /**
        *  添加用户订单信息的服务
        * @return boolean
        */
	public boolean addPerSonCar(Personcar perSonCar);
	 /**
        *  删除用户订单信息的服务
        * @return boolean
        */
	public boolean deletePerSoncar(Personcar perSonCar);
	 /**
        *  修改用户订单信息的服务
        * @return boolean
        */
	public boolean updatePerSoncar(Personcar perSonCar,String state);
	/**
	 * 根据条件分页获取记录集合的服务
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,PerSonCar>
	 */
	public Map<Long, Personcar> getPersonList(int curPage, int rowsPrePage,Personcar perSonCar);
/**
 * 根据用户编号删除用户订单信息的服务
 *@return boolean  
 */
	 public boolean deletepersoncaruser(Personcar p);
/**
 * 根据车编号删除用户订单信息的服务
 *@return boolean  
 */
	 public boolean deletecidpersoncaruser(Personcar p);
/**
 * 
 * 检查是否还有与某用户编号关联的用户订单信息的服务
 * @return boolean
 */
	 public boolean checkipersoncaruser(Personcar p);
/**
 * 
 * 检查是否还有与某车编号关联的用户订单信息的服务
 * @return boolean
 */
	 public boolean checkcidipersoncaruser(Personcar p);
/**
 * 根据所有字段删除用户订单信息的方法的服务
 *@return boolean  
 */
	 public boolean deletePersonByAll(Personcar perSonCar);
/**
 * 
 * 获取用户订单信息的服务
 * @return Personcar
 */
	 public Personcar getPersoncar(Personcar personcar);
/**
 * 
 * 检查是否还有与某车主编号关联的用户订单信息的服务
 * @return boolean
 */
	 public boolean checkcuidperson(Personcar p);
/**
 * 根据车主编号删除用户订单信息的服务
 *@return boolean  
 */
	  	public boolean deletecuidperson(Personcar p);
}
