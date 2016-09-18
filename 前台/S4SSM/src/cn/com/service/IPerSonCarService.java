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
        * 根据条件获取用户订单信息数量
        * @return int
        */
	public Long getCarCountByWhere(Personcar perSonCar);
       /**
        * 根据条件获取用户订单信息集合
        * @return  Map<Long, PerSonCar>
        */
	public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar);
       /**
        *  添加用户订单信息
        * @return boolean
        */
	public boolean addPerSonCar(Personcar perSonCar);
       /**
        *  删除用户订单信息
        * @return boolean
        */
	public boolean deletePerSoncar(Personcar perSonCar);
       /**
        *  修改用户订单信息
        * @return boolean
        */
	public boolean updatePerSoncar(Personcar perSonCar,String state);
       /**
        *  修改用户订单信息（状态作为条件）
        * @return boolean
        */
	public boolean updatePerSonCarByState(Personcar perSonCar, String state);
	/**
	 * 获取个人汽车订单信息
	 * @return Personcar
	 */
	public Personcar getPersoncar(Personcar personcar);
}
