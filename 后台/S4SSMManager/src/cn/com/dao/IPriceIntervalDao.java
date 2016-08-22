package cn.com.dao;

import java.util.Map;
import cn.com.pojo.*;
public interface IPriceIntervalDao {
  public Map<Integer,Priceinterval> getPriceIntervalByCount();
  public int addPriceInterval(Priceinterval priceInterval);
  public int deletePriceInterval(Priceinterval priceInterval);
  public int updatePriceInterval(Priceinterval priceInterval);
  public Priceinterval getPriceIntervalById(Priceinterval priceInterval);
  
}
