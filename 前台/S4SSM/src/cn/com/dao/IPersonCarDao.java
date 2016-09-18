package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 个人汽车订单信息操作接口
 * @author lej
 */
@Repository
public interface IPersonCarDao {
       /**
        * 根据条件获取用户订单信息数量
        * @return int
        */
       public Long getCarCountByWhere(Personcar perSonCar);
       /**
        * 根据条件获取用户订单信息集合
        * @return  Map<Long, Personcar>
        */
       public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar);
       /**
        *  添加用户订单信息
        * @return int
        */
       public int addPerSonCar(Personcar perSonCar);
       /**
        *  删除用户订单信息
        * @return int
        */
       public int deletePerSoncar(Personcar perSonCar);
       /**
        *  修改用户订单信息
        * @return int
        */
       public int updatePerSoncar(Personcar perSonCar,String state);
       /**
        * 根据订单状态修改订单信息的方法
        * @return int
        */
       public int updatePerSonCarByState(Personcar perSonCar,String state);
       /**
        * 获取用户订单信息的方法
        * @return Personcar
        */
       public Personcar getPersoncar(Personcar personcar);
}
