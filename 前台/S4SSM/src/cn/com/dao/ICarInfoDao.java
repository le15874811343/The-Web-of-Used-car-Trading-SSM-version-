package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface ICarInfoDao {
  public Map<Long, Carinfo> getCarInfoByCountDesc(Carinfo carInfo);
  public Map<Long, Carinfo>  getCarInfoByBrandCountDesc(Carinfo carInfo);
  public Map<Long, Carinfo> getCarInfoBySjTime(Carinfo carInfo);
  public Map<Long, Carinfo> getFourthCarInfoBySjTime(Carinfo carInfo);
  public Map<Long, Carinfo>  getCarInfoByTypeCountDesc(Carinfo carInfo);
  public Map<Long, Carinfo> getCarInfoByBrand(Carinfo carInfo);
  public Map<Long,Carinfo>   getCarInfoByType(Carinfo carInfo);
  public Map<Long, Carinfo> getCarByWhere(Carinfo carInfo);
  public int updateCarInfo(Carinfo carInfo);
  public int addCarInfo(Carinfo carInfo);
  public Carinfo getCarInfoByUMN(Carinfo carInfo);
  public int updateCarAll(Carinfo carInfo);
  public List<Carinfo> getTenCount(Carinfo carInfo);
  public List<Carinfo> getTenBrandCar(Carinfo carInfo);
}
