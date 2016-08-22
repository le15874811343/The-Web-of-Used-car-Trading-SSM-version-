package cn.com.dao;

import java.util.*;
import cn.com.pojo.*;

public interface ICarTypeDao {
	public Map<Integer, Cartype> getCarTypeByCount();
	public Map<Integer, Cartype> getAllCarType();
	public int addCarType(Cartype carType);
	public int deleteCarType(Cartype carType);
	public int updateType(Cartype carType);
	public Cartype getCarType(Cartype carType);
}
