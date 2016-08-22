package cn.com.service;

import cn.com.pojo.*;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public interface ICarTypeService {
	public Map<Integer, Cartype> getCarTypeByCount();
	public Map<Integer, Cartype> getAllCarType();
}
