package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 公司动态消息操作实现类
 * @author
 */
@Repository
public class TrendsDaoImpl extends BaseDao  implements ITrendsDao,IPageDao {
       /**
        * 获取指定条数的最新的动态消息集合
        * @param  rows 获取记录的条数
        * @return List<Trends> 
        */
	@Override
	public List<Trends> getITrendsByTime(Trends trends,int rows) {
		// TODO Auto-generated method stub
		List<Trends> trendsMap=new ArrayList<Trends>();
	Map<String, Object> parmas=new HashMap<String, Object>();

	parmas.put("trType", trends.getTrType());
	parmas.put("rows", rows);
	
		trendsMap=super.getSqlSessionTemplate().selectList("cn.com.pojo.TrendsMapper.getITrendsByTime", parmas);
		
	
	
		 return trendsMap;
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
 * 获取公司动态消息记录的总条数
 * 
 * @return Long
 */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count=null;
		Trends trends=(Trends) object;
		List<Object> parmas=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer("select count(*) from Trends where 1=1");
		if(trends.getTrType()!=null){
			sql.append(" and trType=?");
			parmas.add(trends.getTrType());
		}
		Object[] o=new Object[parmas.size()];
		for(int i=0;i<parmas.size();i++){
			o[i]=parmas.get(i);		
			}
	
	try {
		count= (Long) super.getSqlSessionTemplate().selectList("cn.com.pojo.TrendsMapper.queryPersonCarCount",trends).get(0);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return count;
	}
  /**
   * 分页获取公司动态消息
   * @param curPage 当前页
   * @param rowsPrePage 每页显示记录条数
   * @return Map<Long,Object>
   */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Trends trends=(Trends) object;
		
		 Map<Long, Object> trendsMap=new HashMap<Long, Object>();
		
 Map<String, Object> parmas=new HashMap<String, Object>();
 parmas.put("trType", trends.getTrType());
	parmas.put("curPage", curPage);
	parmas.put("rowsPrePage", rowsPrePage);
		
		
			
		    try {
		   trendsMap=super.getSqlSessionTemplate().selectMap("cn.com.pojo.TrendsMapper.showPersonCarList", parmas,"trId");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return trendsMap;
	}
       /**
        * 按条件获取动态消息
        * @return Trends
        */
	@Override
	public Trends getTrendsByWhere(Trends trends) {
		// TODO Auto-generated method stub
		Trends _Trends=null;
		
	
	
		try {
		_Trends=	(Trends) super.getSqlSessionTemplate().selectList("cn.com.pojo.TrendsMapper.getTrendsByWhere", trends).get(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return _Trends;
	}

} 
