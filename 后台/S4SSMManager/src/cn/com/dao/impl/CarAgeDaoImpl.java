package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class CarAgeDaoImpl extends BaseDao implements ICarAgeDao,IPageDao{
  
	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Carage> carAgeMap=new HashMap<Integer, Carage>();
	
	  carAgeMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarageMapper.getCarAgeByCount",  "aId");
	
		return carAgeMap;
	}

	@Override
	public int addCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.CarageMapper.insertSelective",carAge);
	}

	@Override
	public int deleteCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.CarageMapper.deleteCarAge",carAge);
	}

	@Override
	public int updateCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().update("cn.com.pojo.CarageMapper.updateCarAge",carAge);
	}

	@Override
	public Carage getCarAgeById(Carage carAge) {
		// TODO Auto-generated method stub
		Carage _carage=null;
  List<Carage> cList=		super.getSqlSessionTemplate().selectList("cn.com.pojo.CarageMapper.getCarAgeById", carAge);
  if(cList.size()>0){
	  _carage=cList.get(0);
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

	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=(long) 0;
	List<Long> clist=	super.getSqlSessionTemplate().selectList("cn.com.pojo.CarageMapper.queryPersonCarCount");
	if(clist.size()>0){
		count=clist.get(0);
	}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Map<String, Object> parmas=new HashMap<String, Object>();
		
		parmas.put("curPage", curPage);
		parmas.put("rowsPrePage", rowsPrePage);
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
		 brandMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.CarageMapper.showPersonCarList", parmas, "aId");
		return brandMap;
	}

}
