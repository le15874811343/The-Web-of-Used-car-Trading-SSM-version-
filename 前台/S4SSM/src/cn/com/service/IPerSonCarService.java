package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IPerSonCarService {
	public Long getCarCountByWhere(Personcar perSonCar);
	public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar);
	public boolean addPerSonCar(Personcar perSonCar);
	public boolean deletePerSoncar(Personcar perSonCar);
	public boolean updatePerSoncar(Personcar perSonCar,String state);
	public boolean updatePerSonCarByState(Personcar perSonCar, String state);
	public Personcar getPersoncar(Personcar personcar);
}
