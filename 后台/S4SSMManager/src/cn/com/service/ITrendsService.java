package cn.com.service;
import java.util.*;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;
/**
 * 公司动态消息服务接口
 * @author
 */
@Repository
public interface ITrendsService {
	 /**
        * 获取指定条数的最新的动态消息集合的的服务
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
	public List<Trends> getITrendsByTime(Trends trends,int rows);
	 /**
        * 按条件获取动态消息的服务
        * @return Trends 
        */
	public Trends getTrendsByWhere(Trends trends);
	 /**
        * 添加动态消息的服务
        * @return boolean 
        */
	public boolean addTrends(Trends trends);
	 /**
        * 删除动态消息的服务
        * @return boolean 
        */
	public boolean deleteTrends(Trends trends);
	 /**
        * 修改动态消息的服务
        * @return boolean 
        */
	public boolean updateTrends(Trends trends);
}
