package cn.com.service;

import cn.com.pojo.*;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public interface ICarInfoService {
	public Map<Long, Carinfo> getCarInfoByCountDesc(Carinfo carInfo);
	public Map<Long, Carinfo> getCarInfoByBrandCountDesc(Carinfo carInfo);
	public Map<Long, Carinfo> getCarInfoBySjTime(Carinfo carInfo);
	public Map<Long, Carinfo> getFourthCarInfoBySjTime(Carinfo carInfo);
	public Map<Long, Carinfo>  getCarInfoByTypeCountDesc(Carinfo carInfo);
	public Map<Long, Carinfo> getCarInfoByBrand(Carinfo carInfo);
	public Map<Long, Carinfo> getCarInfoByType(Carinfo carInfo);
	public Map<Long, Carinfo> getCarByWhere(Carinfo carInfo);
	public boolean updateCarInfo(Carinfo carInfo);
	public boolean addCarInfo(Carinfo carInfo);
	public Carinfo getCarInfoByUMN(Carinfo carInfo);
	public boolean updateCarAll(Carinfo carInfo);
	 public boolean deletecarinfouser(Carinfo c);
	 public boolean checkcarinfouser(Carinfo c);
	 public boolean deletecarinfo(Carinfo c) ;
	 public List<Carinfo> getTenCount(Carinfo carInfo);
		public List<Carinfo> getTenBrandCar(Carinfo carInfo);
}
