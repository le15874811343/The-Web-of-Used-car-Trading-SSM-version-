package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IPriceIntervalDao {
  public Map<Integer,Priceinterval> getPriceIntervalByCount();
}
