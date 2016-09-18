package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 行驶距离操作接口
 *@author lej 
 */
@Repository
public interface IDistanceDao {
   /**
    * 
    * 按热度获取行驶距离信息的方法
    *@return Map<Integer,Distance> 
    */
   public Map<Integer, Distance> getDistanceByCount();
}
