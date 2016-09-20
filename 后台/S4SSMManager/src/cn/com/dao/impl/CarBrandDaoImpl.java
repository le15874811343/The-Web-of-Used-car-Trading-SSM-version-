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
public class CarBrandDaoImpl extends BaseDao implements ICarBrandDao,IPageDao {
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
		_carBrand=	 (Carbrand) super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.getBrandByID", carBrand,"bId").get(carBrand.getbId());
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
        /**
	 * 添加品牌信息的方法
	 * @return   int
	 */
	@Override
	public int addCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().insert("cn.com.pojo.CarbrandMapper.insertSelective", carBrand);
	}
        /**
	 * 修改品牌信息的方法
	 * @return   int
	 */
	@Override
	public int updateCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().update("cn.com.pojo.CarbrandMapper.updateCarBrand", carBrand);
	}
        /**
	 * 删除品牌信息的方法
	 * @return   int
	 */
	@Override
	public int deleteCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
			//返回受影响的行数
		return super.getSqlSessionTemplate().delete("cn.com.pojo.CarbrandMapper.deleteCarBrand", carBrand);
	}

	@Override
	public Long queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}
    /**
     * 获取品牌信息的记录总条数
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=(long) 0;
		//获取结果集
		List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.CarbrandMapper.queryPersonCarCount");
		if(clist.size()>0){
			count=clist.get(0); //获取结果
		}
			return count;
	}
/**
 * 分页获取品牌信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
Map<String, Object> parmas=new HashMap<String, Object>();
		
		parmas.put("curPage", curPage);
		parmas.put("rowsPrePage", rowsPrePage);
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
		 //获取结果集
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarbrandMapper.showPersonCarList", parmas, "bId");
		return brandMap;
	}
 
}
