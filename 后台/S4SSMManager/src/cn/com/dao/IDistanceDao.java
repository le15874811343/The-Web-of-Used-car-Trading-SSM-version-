package cn.com.dao;
import java.util.*;
import cn.com.pojo.*;
/**
 * 行驶距离操作接口
 *@author lej 
 */
public interface IDistanceDao {
   /**
    * 
    * 按热度获取行驶距离信息的方法
    *@return Map<Integer,Distance> 
    */
   public Map<Integer, Distance> getDistanceByCount();
          /**
           * 添加行驶距离的方法
           * @parma distance
           * @return int
           */
   public int addDistance(Distance distance);
          /**
           * 删除行驶距离的方法
           * @parma distance
           * @return int
           */
   public int deleteDistance(Distance distance);
          /**
           * 修改行驶距离的方法
           * @parma distance
           * @return int
           */
   public int updateDistance(Distance distance);
     /**
    * 
    * 按编号获取行驶距离信息的方法
    *@return Distance
    */
   public Distance getDistanceById(Distance distance);
}
