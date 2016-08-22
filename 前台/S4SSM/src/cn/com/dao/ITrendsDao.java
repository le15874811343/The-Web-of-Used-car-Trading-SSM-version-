package cn.com.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface ITrendsDao {
       public List<Trends>  getITrendsByTime(Trends trends,int rows);
       public Trends getTrendsByWhere(Trends trends);
}
