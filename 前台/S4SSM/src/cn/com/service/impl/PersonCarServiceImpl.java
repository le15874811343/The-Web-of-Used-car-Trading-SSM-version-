package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.dao.IPageDao;
import cn.com.dao.IPersonCarDao;
import cn.com.service.*;
@Service
public class PersonCarServiceImpl implements IPerSonCarService,IPageDao {
	@Resource
   private IPersonCarDao personCarDao=null;
	@Resource(name = "personCarDaoImpl" )
   private IPageDao pagePersc=null;
	public IPersonCarDao getPersonCarDao() {
	return personCarDao;
}
public void setPersonCarDao(IPersonCarDao personCarDao) {
	this.personCarDao = personCarDao;
}
public IPageDao getPagePersc() {
	return pagePersc;
}
public void setPagePersc(IPageDao pagePersc) {
	this.pagePersc = pagePersc;
}
	@Override
	public Long getCarCountByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getCarCountByWhere(perSonCar);
	}
	@Override
	public Map<Long, Personcar> getPerSonCarMapByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getPerSonCarMapByWhere(perSonCar);
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
		return pagePersc.queryPersonCarCount(object);
	}
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return pagePersc.showPersonCarList(curPage, rowsPrePage, object);
	}
	@Override
	public boolean addPerSonCar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
		if(personCarDao.addPerSonCar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean deletePerSoncar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletePerSoncar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updatePerSoncar(Personcar perSonCar, String state) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.updatePerSoncar(perSonCar, state)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updatePerSonCarByState(Personcar perSonCar, String state) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.updatePerSonCarByState(perSonCar, state)>0){
			flag=true;
		}
		return flag;
	}
	@Override
	public Personcar getPersoncar(Personcar personcar) {
		// TODO Auto-generated method stub
		return personCarDao.getPersoncar(personcar);
	}

}
