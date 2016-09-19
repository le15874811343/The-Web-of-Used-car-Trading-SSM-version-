package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 行驶距离服务接口
 *@author lej 
 */
@Repository
public interface IDistanceService {
   /**
    * 
    * 按热度获取行驶距离信息的服务
    *@return Map<Integer,Distance> 
    */
	public Map<Integer, Distance> getDistanceByCount();
	 /**
           * 添加行驶距离的服务
           * @parma distance
           * @return boolean
           */
	 public boolean addDistance(Distance distance);
	  /**
           * 删除行驶距离的服务
           * @parma distance
           * @return boolean
           */
	   public boolean deleteDistance(Distance distance);
	    /**
           * 修改行驶距离的服务
           * @parma distance
           * @return boolean
           */
	   public boolean updateDistance(Distance distance);
   /**
    * 
    * 按编号获取行驶距离信息的服务
    *@return Distance
    */
	   public Distance getDistanceById(Distance distance);
}
