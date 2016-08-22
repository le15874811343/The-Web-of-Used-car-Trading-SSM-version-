package cn.com.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;



import cn.com.pojo.Carchart;
@Repository
public interface ICarchartService {
	public List<Carchart> chartinfo(int year,int month);
	public List<Carchart> chartinfo();
	public Map<String, Carchart> chartinfo(int year, int month, int day);
	public Map<String, Carchart> chartinfo(int year);
}
