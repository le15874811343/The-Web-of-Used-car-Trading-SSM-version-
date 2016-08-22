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
	public Map<Long, Personcar> getPersonList(int curPage, int rowsPrePage,Personcar perSonCar);
	 public boolean deletepersoncaruser(Personcar p);
	 public boolean deletecidpersoncaruser(Personcar p);
	 public boolean checkipersoncaruser(Personcar p);
	 public boolean checkcidipersoncaruser(Personcar p);
	 public boolean deletePersonByAll(Personcar perSonCar);
	 public Personcar getPersoncar(Personcar personcar);
	 public boolean checkcuidperson(Personcar p);
	  	public boolean deletecuidperson(Personcar p);
}
