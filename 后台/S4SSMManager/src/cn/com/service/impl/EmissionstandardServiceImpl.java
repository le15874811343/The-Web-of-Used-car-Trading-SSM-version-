package cn.com.service.impl;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.IEmissionstandardDao;
import cn.com.dao.IPageDao;

import cn.com.service.*;
/**
 * 
 * 排放标准服务实现类
 *@author  lej
 */
@Service
public class EmissionstandardServiceImpl implements IEmissionstandardService,IPageDao {
	@Resource
    private IEmissionstandardDao emissionstandardDao=null; //排放标准操作接口的引用
	@Resource(name="emissionstandardDaoImpl")
    private IPageDao  emisPage=null; //分页处理操作接口的引用
    
	public IEmissionstandardDao getEmissionstandardDao() {
		return emissionstandardDao;
	}
	public void setEmissionstandardDao(IEmissionstandardDao emissionstandardDao) {
		this.emissionstandardDao = emissionstandardDao;
	}
	public IPageDao getEmisPage() {
		return emisPage;
	}
	public void setEmisPage(IPageDao emisPage) {
		this.emisPage = emisPage;
	}
	/**
	 * 按热度获取排放标准信息的服务
	 * @return Map<Integer,Emissionstandard>
	 */
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandardByCount();
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
     * 获取排放标准信息的记录总条数的服务
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return emisPage.queryPersonCarCount(object);
	}
/**
 * 分页获取排放标准信息的服务
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return emisPage.showPersonCarList(curPage, rowsPrePage, object);
	}
          /**
           * 添加排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	@Override
	public boolean addEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.addEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	  /**
           * 修改排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	@Override
	public boolean updateEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.updateEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	  /**
           * 删除排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	@Override
	public boolean deleteEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.deleteEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 获取排放标准信息的服务
	 * @return Emissionstandard
	 */
	@Override
	public Emissionstandard getEmissionstandard(
			Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandard(emissionstandard);
	}

}
