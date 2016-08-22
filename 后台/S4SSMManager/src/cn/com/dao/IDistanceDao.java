package cn.com.dao;
import java.util.*;
import cn.com.pojo.*;
public interface IDistanceDao {
   public Map<Integer, Distance> getDistanceByCount();
   public int addDistance(Distance distance);
   public int deleteDistance(Distance distance);
   public int updateDistance(Distance distance);
   public Distance getDistanceById(Distance distance);
}
