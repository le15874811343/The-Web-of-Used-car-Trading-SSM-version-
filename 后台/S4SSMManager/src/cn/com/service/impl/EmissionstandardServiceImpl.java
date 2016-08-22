package cn.com.service.impl;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;

import cn.com.dao.IEmissionstandardDao;
import cn.com.dao.IPageDao;

import cn.com.service.*;
@Service
public class EmissionstandardServiceImpl implements IEmissionstandardService,IPageDao {
	@Resource
    private IEmissionstandardDao emissionstandardDao=null;
	@Resource(name="emissionstandardDaoImpl")
    private IPageDao  emisPage=null;
    
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
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return emisPage.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return emisPage.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.addEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updateEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.updateEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deleteEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(emissionstandardDao.deleteEmissionstandard(emissionstandard)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public Emissionstandard getEmissionstandard(
			Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		return emissionstandardDao.getEmissionstandard(emissionstandard);
	}

}
