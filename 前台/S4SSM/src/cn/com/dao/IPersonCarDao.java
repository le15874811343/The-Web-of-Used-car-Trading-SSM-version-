package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IPersonCarDao {
       public Long getCarCountByWhere(Personcar perSonCar);
       public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar);
       public int addPerSonCar(Personcar perSonCar);
       public int deletePerSoncar(Personcar perSonCar);
       public int updatePerSoncar(Personcar perSonCar,String state);
       public int updatePerSonCarByState(Personcar perSonCar,String state);
       public Personcar getPersoncar(Personcar personcar);
}
