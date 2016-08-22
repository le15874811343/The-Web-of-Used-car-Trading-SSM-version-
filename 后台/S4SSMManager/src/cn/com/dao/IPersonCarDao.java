package cn.com.dao;
import java.util.*;

import cn.com.pojo.*;

public interface IPersonCarDao {
       public Long getCarCountByWhere(Personcar perSonCar);
       public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar);
       public int addPerSonCar(Personcar perSonCar);
       public int deletePerSoncar(Personcar perSonCar);
       public int updatePerSoncar(Personcar perSonCar,String state);
       public Map<Long, Personcar> getPersonList(int curPage, int rowsPrePage,Personcar perSonCar);
       public int deletepersoncaruser(Personcar u);
  	 public int deletecidpersoncaruser(Personcar u);
  	 public boolean checkipersonuser(Personcar p);
  	 public boolean checkcidipersonuser(Personcar p);
  	 public int deletePersonByAll(Personcar perSonCar);
  	 public Personcar getPersoncar(Personcar personcar);
  	public boolean checkcuidperson(Personcar p);
  	public int deletecuidperson(Personcar p);
}
