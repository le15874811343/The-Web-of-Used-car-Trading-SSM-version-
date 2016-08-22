package cn.com.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface ICarTypeDao {
	public Map<Integer, Cartype> getCarTypeByCount();
	public Map<Integer, Cartype> getAllCarType();
}
