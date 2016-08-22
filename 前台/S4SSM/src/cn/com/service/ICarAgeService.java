package cn.com.service;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface ICarAgeService {
	public Map<Integer,Carage> getCarAgeByCount();
}
