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
        * 获取指定条数的最新的动态消息集合
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
	public List<Trends> getITrendsByTime(Trends trends,int rows);
       /**
        * 按条件获取动态消息
        * 
        * @return Trends
        */
	public Trends getTrendsByWhere(Trends trends);
}
