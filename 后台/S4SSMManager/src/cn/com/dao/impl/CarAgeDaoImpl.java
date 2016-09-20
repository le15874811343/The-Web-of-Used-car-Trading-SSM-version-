package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 车龄信息操作实现类
 *@author  lej 
 */
@Repository
public class CarAgeDaoImpl extends BaseDao implements ICarAgeDao,IPageDao{
        /**
	 * 按热度获取车龄信息的方法
	 * @return Map<Integer,CarAge>
	 */
	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Carage> carAgeMap=new HashMap<Integer, Carage>();
	   //获取结果集
	  carAgeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarageMapper.getCarAgeByCount",  "aId");
	
		return carAgeMap;
	}
        /**
	 * 添加车龄信息的方法
	 * @return   int
	 */
	@Override
	public int addCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().insert("cn.com.pojo.CarageMapper.insertSelective",carAge);
	}
	/**
	 * 删除车龄信息的方法
	 * @return   int
	 */
	@Override
	public int deleteCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().delete("cn.com.pojo.CarageMapper.deleteCarAge",carAge);
	}
        /**
	 * 修改车龄信息的方法
	 * @return   int
	 */
	@Override
	public int updateCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().update("cn.com.pojo.CarageMapper.updateCarAge",carAge);
	}
        /**
	 * 获取车龄信息的方法
	 * @return CarAge
	 */
	@Override
	public Carage getCarAgeById(Carage carAge) {
		// TODO Auto-generated method stub
		Carage _carage=null;
			//获取结果集
  List<Carage> cList=		super.getSqlSessionTemplate().selectList("cn.com.pojo.CarageMapper.getCarAgeById", carAge);
  if(cList.size()>0){
	  _carage=cList.get(0);//获取结果
  }
		return _carage;
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
     * 获取车龄信息的记录总条数
     * @return Long
     */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=(long) 0;
		//获取结果集
	List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.CarageMapper.queryPersonCarCount");
	if(clist.size()>0){
		count=clist.get(0);    //获取结果
	}
		return count;
	}
/**
 * 分页获取车龄信息
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
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarageMapper.showPersonCarList", parmas, "aId");
		return brandMap;
	}

}
