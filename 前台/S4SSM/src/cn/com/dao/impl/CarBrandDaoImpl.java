package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 品牌信息操作实现类
 * @author lej
 */
@Repository
public class CarBrandDaoImpl extends BaseDao implements ICarBrandDao {
  /**
   * 按热度获取品牌信息的方法
   * @return  Map<Integer, Carbrand>
   */
	@Override
	public Map<Integer, Carbrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
	   Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
	   //获取结果集
	   carBrandMap= super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.getCarBrandByCount", "bId");
	  return carBrandMap;
	}
  /**
   * 获取所有品牌信息的方法
   * @return Map<Integer,Carbrand>
   */
	@Override
	public Map<Integer, Carbrand> getAllBrand() {
		// TODO Auto-generated method stub
		 Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
		 //获取结果集
		 carBrandMap=	 super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.getAllBrand", "bId");
		  return carBrandMap;
	}
 /**
   * 根据品牌编号获取品牌信息的方法
   * @param carBrand
   * @return Carbrand
   */
	@Override
	public Carbrand getBrandByID(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		try{
			 //获取结果
		_carBrand=	 (Carbrand) super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.getBrandByID", "bId").get(carBrand.getbId());
		}  
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return _carBrand;
	}
 /**
   * 根据品牌名称获取品牌的方法
   *@return Carbrand 
   */
	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		try{
			 //获取结果
		_carBrand=	 (Carbrand) super.getSqlSessionTemplate().selectList("cn.com.pojo.CarbrandMapper.getBrandByName",carBrand).get(0);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  return _carBrand;
	}
 
}
