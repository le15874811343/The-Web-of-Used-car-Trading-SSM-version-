package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
@Repository
public class PersonCarDaoImpl extends BaseDao  implements IPersonCarDao,IPageDao {
	@Resource
    private ICarInfoDao carInfoDao=null;
    
	public ICarInfoDao getCarInfoDao() {
		return carInfoDao;
	}

	public void setCarInfoDao(ICarInfoDao carInfoDao) {
		this.carInfoDao = carInfoDao;
	}

	@Override
	public Long getCarCountByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		Long count=null;
		
		try {
      count=(Long) super.getSqlSessionTemplate().selectList("cn.com.pojo.PersoncarMapper.getCarCountByWhere",perSonCar).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
	
		Map<Long, Personcar> perSonMap=new HashMap<Long, Personcar>();
		perSonMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.PersoncarMapper.getPerSonCarMapByWhere", perSonCar, "pId");
	return perSonMap;
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
		Personcar perSonCar=(Personcar) object;
		return getCarCountByWhere(perSonCar);
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		
		// TODO Auto-generated method stub
		Personcar perSonCar=(Personcar) object;
		Map<Long, Object> carMap=new HashMap<Long, Object>();
   Map<Long, Personcar>	perSonMap=	getPersonList(curPage,rowsPrePage,perSonCar);
   for(Long key:perSonMap.keySet()){
	   Carinfo carInfo=new Carinfo();
	 
	   carInfo.setcId(perSonMap.get(key).getcId());
	  
	   carInfo.setuId(perSonMap.get(key).getcUid());
	 
	   carMap.put(carInfo.getcId(), carInfoDao.getCarByWhere(carInfo).get(carInfo.getcId()));
   }
  
		return carMap;
	}

	private Map<Long, Personcar> getPersonList(int curPage, int rowsPrePage,Personcar perSonCar){
		
		 Map<Long, Personcar> perSonMap=new HashMap<Long, Personcar>();
		
Map<String, Object> params=new HashMap<String, Object>();

		
			
				params.put("uId",perSonCar.getuId());
			
			
			
				params.put("pState",perSonCar.getpState());
			
		   params.put("curPage", curPage);
		 params.put("rowsPrePage", rowsPrePage);
		  perSonMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.PersoncarMapper.getPersonList", params, "pId");
		 
			return perSonMap;
	}

	@Override
	public int addPerSonCar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			
			 super.getSqlSessionTemplate().insert("cn.com.pojo.PersoncarMapper.insertSelective",perSonCar);
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deletePerSoncar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		 int count=0;
		 try{
			 super.getSqlSessionTemplate().delete("cn.com.pojo.PersoncarMapper.deletePerSoncar", perSonCar);
			 count=1;
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updatePerSoncar(Personcar perSonCar,String state) {
		// TODO Auto-generated method stub
		
		Map<String, Object> parmas=new HashMap<String, Object>();
		parmas.put("state", state);
		parmas.put("uId", perSonCar.getuId());
		parmas.put("cId", perSonCar.getcId());
		parmas.put("cUid", perSonCar.getcUid());
		parmas.put("pState", perSonCar.getpState());
		return super.getSqlSessionTemplate().update("cn.com.pojo.PersoncarMapper.updatePerSoncar", parmas);
	}

	@Override
	public int updatePerSonCarByState(Personcar perSonCar, String state) {
		// TODO Auto-generated method stub
	
		Map<String, Object> parmas=new HashMap<String, Object>();
		parmas.put("state", state);
		parmas.put("cId", perSonCar.getcId());
		parmas.put("pState", perSonCar.getpState());
		return super.getSqlSessionTemplate().update("cn.com.pojo.PersoncarMapper.updatePerSonCarByState", parmas);	}

	@Override
	public Personcar getPersoncar(Personcar personcar) {
		// TODO Auto-generated method stub
		
		Personcar _Personcar=null;
		
    try {
	
	_Personcar=(Personcar) super.getSqlSessionTemplate().selectList("cn.com.pojo.PersoncarMapper.getPersoncar", personcar).get(0);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return _Personcar;
	}

}
