package cn.com.service;

import java.util.List;

import org.springframework.stereotype.Repository;



import cn.com.pojo.Price;
@Repository
public interface IPriceService {
	public   List<Price> getsellinfo(int year,int month,int day);
	public List<Price> getsellinfo(int year,int month);
	public  List<Price> getsellinfo(int year);
	public List<Price> getsellinfo();
}
