package cn.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.service.*;
import cn.com.dao.*;

@Service
public class PersonNeedServiceImpl implements IPersonNeedService,IPageDao{
	@Resource
private IPersonNeedDao personNeedDao=null;
	@Resource(name="personNeedDaoImpl")
private IPageDao personneedPage=null;

	public IPersonNeedDao getPersonNeedDao() {
	return personNeedDao;
}
public void setPersonNeedDao(IPersonNeedDao personNeedDao) {
	this.personNeedDao = personNeedDao;
}
public IPageDao getPersonneedPage() {
	return personneedPage;
}
public void setPersonneedPage(IPageDao personneedPage) {
	this.personneedPage = personneedPage;
}
	@Override
	public boolean addPersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.addPersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deletePersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.deletePersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public Personneed getPerSonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		return personNeedDao.getPerSonNeed(personNeed);
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
		return personneedPage.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personneedPage.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean updatePersonNeed(Personneed personNeed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.updatePersonNeed(personNeed)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean chekUidPerson(Personneed personneed) {
		// TODO Auto-generated method stub
		return personNeedDao.chekUidPerson(personneed);
	}
	@Override
	public boolean deleteUidPerson(Personneed personneed) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personNeedDao.deleteUidPerson(personneed)>0){
			flag=true;
		}
		return flag;
	}

}
