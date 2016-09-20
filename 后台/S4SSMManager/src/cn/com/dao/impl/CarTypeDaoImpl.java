package cn.com.dao.impl;

import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 车型操作实现类
 * @author
 */
@Repository
public class CarTypeDaoImpl extends BaseDao implements ICarTypeDao,IPageDao {
        /**
	 * 按热度获取车型信息的方法
	 * @return Map<Integer,CarType>
	 */
	@Override
	public Map<Integer, Cartype> getCarTypeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		
  carTypeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CartypeMapper.getCarTypeByCount", "tId");//获取结果集
		return carTypeMap;
	}
        /**
	 * 获取所有车型信息的方法
	 * @return  Map<Integer,CarType>
	 */
	@Override
	public Map<Integer, Cartype> getAllCarType() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		carTypeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CartypeMapper.getAllCarType", "tId");//获取结果集
		return carTypeMap;
	}
/**
 * 添加车型的方法
 * @return int
 */
	@Override
	public int addCarType(Cartype carType) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().insert("cn.com.pojo.CartypeMapper.insertSelective", carType);
	}
/**
 * 删除车型的方法
 * @return int
 */
	@Override
	public int deleteCarType(Cartype carType) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().delete("cn.com.pojo.CartypeMapper.deleteCarType", carType);
	}
/**
 * 修改车型的方法
 * @return int
 */
	@Override
	public int updateType(Cartype carType) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().update("cn.com.pojo.CartypeMapper.updateType", carType);
	}
/**
 * 获取车型的方法
 * @return CarType
 */
	@Override
	public Cartype getCarType(Cartype carType) {
		// TODO Auto-generated method stub
		Cartype _Cartype=null;
	List<Cartype> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.CartypeMapper.getCarType",carType);
	if(clist.size()>0){
		_Cartype=clist.get(0);//获取结果
	}
		return _Cartype;
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
     * 获取车型信息的记录总条数
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=(long) 0;
		List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.CartypeMapper.queryPersonCarCount");
		if(clist.size()>0){
			count=clist.get(0);//获取结果
		}
			return count;
	}
/**
 * 分页获取车型信息
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
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CartypeMapper.showPersonCarList", parmas, "tId");
		return brandMap;
	}

}
