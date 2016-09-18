package cn.com.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.pojo.*;
import cn.com.dao.IPageDao;
import cn.com.dao.IPersonCarDao;
import cn.com.service.*;
/**
 * 个人汽车订单信息服务实现类
 * @author lej
 */
@Service
public class PersonCarServiceImpl implements IPerSonCarService,IPageDao {
	@Resource
   private IPersonCarDao personCarDao=null; //个人汽车订单操作接口的引用
	@Resource(name = "personCarDaoImpl" )
   private IPageDao pagePersc=null;   //分页操作接口的引用
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
       /**
        * 根据条件获取用户订单信息数量
        * @return int
        */
	@Override
	public Long getCarCountByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getCarCountByWhere(perSonCar);
	}
       /**
        * 根据条件获取用户订单信息集合
        * @return  Map<Long, PerSonCar>
        */
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
	/**
	 * 获取个人汽车订单的总记录数
	 *@return int 
	 */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return pagePersc.queryPersonCarCount(object);
	}
	/**
	 * 分页获取个人汽车订单信息
	 *@param curPage
	 * @param rowsPrePage
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return pagePersc.showPersonCarList(curPage, rowsPrePage, object);
	}
       /**
        *  添加用户订单信息
        * @return boolean
        */
	@Override
	public boolean addPerSonCar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		
		if(personCarDao.addPerSonCar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
       /**
        *  删除用户订单信息
        * @return boolean
        */
	@Override
	public boolean deletePerSoncar(Personcar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletePerSoncar(perSonCar)>0){
			flag=true;
		}
		return flag;
	}
       /**
        *  修改用户订单信息
        * @return boolean
        */
	@Override
	public boolean updatePerSoncar(Personcar perSonCar, String state) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.updatePerSoncar(perSonCar, state)>0){
			flag=true;
		}
		return flag;
	}
       /**
        *  修改用户订单信息（订单状态作为条件）
        * @return boolean
        */
	@Override
	public boolean updatePerSonCarByState(Personcar perSonCar, String state) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.updatePerSonCarByState(perSonCar, state)>0){
			flag=true;
		}
		return flag;
	}
	/**
	 * 获取用户个人汽车订单信息
	 * 
	 */
	@Override
	public Personcar getPersoncar(Personcar personcar) {
		// TODO Auto-generated method stub
		return personCarDao.getPersoncar(personcar);
	}

}
