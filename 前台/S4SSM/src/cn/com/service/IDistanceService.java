package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IDistanceService {
	public Map<Integer, Distance> getDistanceByCount();
}
