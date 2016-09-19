package cn.com.dao;

import java.util.*;

import cn.com.pojo.*;
/**
 * 公司动态消息操作接口
 * @author
 */
public interface ITrendsDao {
         /**
        * 获取指定条数的最新的动态消息集合
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
       public List<Trends>  getITrendsByTime(Trends trends,int rows);
       /**
        * 按条件获取动态消息
        * @return Trends 
        */
       public Trends getTrendsByWhere(Trends trends);
        /**
        * 添加动态消息
        * @return int 
        */
       public int addTrends(Trends trends);
       /**
        * 删除动态消息
        * @return int 
        */
       public int deleteTrends(Trends trends);
        /**
        * 修改动态消息
        * @return int 
        */
       public int updateTrends(Trends trends);
}
