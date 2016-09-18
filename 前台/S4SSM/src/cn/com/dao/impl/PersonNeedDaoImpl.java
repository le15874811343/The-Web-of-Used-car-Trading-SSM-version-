package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;
import cn.com.dao.*;
/**
 * 个人需求信息操作实现类
 *@author 
 */
@Repository
public class PersonNeedDaoImpl extends BaseDao implements IPersonNeedDao,IPageDao{
  /**
   * 
   * 添加个人需求信息的方法
   *@return int 
   */
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
  /**
   * 
   * 删除个人需求信息的方法
   *@return int 
   */
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
  /**
   * 
   * 获取个人需求信息的方法
   *@return PersonNeed
   */
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
        /**
         * 获取个人需求记录总条数
         * 
         * @return int
         */
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
      /**
       * 分页获取个人需求信息
       * @param curPage 当前页
       * @param rowsPrePage 每页显示记录条数
       * @return Map<Long,Object>
       */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Personneed personNeed=(Personneed) object;
	   //加入参数集合
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
