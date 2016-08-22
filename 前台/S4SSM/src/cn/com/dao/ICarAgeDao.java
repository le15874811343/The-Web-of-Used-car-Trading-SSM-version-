package cn.com.dao;
import java.util.Map;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;
@Repository
public interface ICarAgeDao {
	public Map<Integer,Carage> getCarAgeByCount();
}
