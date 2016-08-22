package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;
import cn.com.dao.*;

@Repository
public class PersonNeedDaoImpl extends BaseDao implements IPersonNeedDao,IPageDao{

//	 private long p_id;
//	 private long u_id;
//	 private String p_brand;
//	 private String p_series;
//	 private String p_age;
//	 private String p_price;
//	 private String p_time;
//	 private String p_miaoshu;
	public int addPersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
	
		int count=0;
		try{
			super.getSqlSessionTemplate().insert("cn.com.pojo.PersonneedMapper.insertSelective",personNeed);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	public int deletePersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getSqlSessionTemplate().delete("cn.com.pojo.PersonneedMapper.deletePersonNeed",personNeed);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Personneed getPerSonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		Personneed _PersonNeed=null;
	
	
       
		try {
	List<Personneed>	plist	= super.getSqlSessionTemplate().selectList("cn.com.pojo.PersonneedMapper.getPerSonNeed",personNeed);
			if(plist.size()>0){
				_PersonNeed=plist.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return _PersonNeed;
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
		Long count=null;
		Personneed personNeed=(Personneed) object;
		

	try {
		 count= (Long) super.getSqlSessionTemplate().selectList("cn.com.pojo.PersonneedMapper.queryPersonCarCount",personNeed).listIterator().next();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Personneed personNeed=(Personneed) object;
	
		 Map<Long, Object> personNeedMap=new HashMap<Long, Object>();
		 Map<String, Object> parmas=new HashMap<String, Object>();
		 parmas.put("uId", personNeed.getuId());
		 parmas.put("curPage", curPage);
		 parmas.put("rowsPrePage", rowsPrePage);
		
		    try {
		 personNeedMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.PersonneedMapper.showPersonCarList", parmas,"pId");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return personNeedMap;
	}

}
