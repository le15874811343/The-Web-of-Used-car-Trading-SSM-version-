package cn.com.dao;
import java.util.Map;

import cn.com.pojo.*;
public interface ICarAgeDao {
	public Map<Integer,Carage> getCarAgeByCount();
	public int addCarAge(Carage carAge);
	public int deleteCarAge(Carage carAge);
	public int updateCarAge(Carage carAge);
	public Carage getCarAgeById(Carage carAge);
}
