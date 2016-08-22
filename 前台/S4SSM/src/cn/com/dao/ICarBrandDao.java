package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface ICarBrandDao {
  public Map<Integer, Carbrand> getCarBrandByCount();
  public Map<Integer, Carbrand> getAllBrand();
  public Carbrand getBrandByID(Carbrand carBrand);
  public Carbrand getBrandByName(Carbrand carBrand);
}
