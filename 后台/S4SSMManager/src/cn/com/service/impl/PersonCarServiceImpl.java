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
	@Resource(name="personCarDaoImpl")
   private IPageDao  personcarPage=null;  //分页处理操作接口的引用
   
	public IPersonCarDao getPersonCarDao() {
	return personCarDao;
}
public void setPersonCarDao(IPersonCarDao personCarDao) {
	this.personCarDao = personCarDao;
}
public IPageDao getPersoncarPage() {
	return personcarPage;
}
public void setPersoncarPage(IPageDao personcarPage) {
	this.personcarPage = personcarPage;
}
       /**
        * 根据条件获取用户订单信息数量的服务
        * @return int
        */
	@Override
	public Long getCarCountByWhere(Personcar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getCarCountByWhere(perSonCar);
	}
	/**
        * 根据条件获取用户订单信息集合的服务
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
        * 根据条件获取用户订单信息数量的服务
        * @return int
        */
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		return personcarPage.queryPersonCarCount(object);
	}
	/**
	 * 根据条件分页获取用户订车详情集合的服务
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,Object>
	 */
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		return personcarPage.showPersonCarList(curPage, rowsPrePage, object);
	}
	  /**
        *  添加用户订单信息的服务
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
        *  删除用户订单信息的服务
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
        *  修改用户订单信息的服务
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
	 * 根据条件分页获取记录集合的服务
	 * @param curPage 当前页
	 * @param rowsPrePage 每页面记录数
	 * @return Map<Long,PerSonCar>
	 */
	@Override
	public Map<Long, Personcar> getPersonList(int curPage, int rowsPrePage,
			Personcar perSonCar) {
		// TODO Auto-generated method stub
		return personCarDao.getPersonList(curPage, rowsPrePage, perSonCar);
	}
/**
 * 根据用户编号删除用户订单信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletepersoncaruser(Personcar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletepersoncaruser(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 根据车编号删除用户订单信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecidpersoncaruser(Personcar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletecidpersoncaruser(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 
 * 检查是否还有与某用户编号关联的用户订单信息的服务
 * @return boolean
 */
	@Override
	public boolean checkipersoncaruser(Personcar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkipersonuser(p);
	}
/**
 * 
 * 检查是否还有与某车编号关联的用户订单信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcidipersoncaruser(Personcar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkcidipersonuser(p);
	}
/**
 * 根据所有字段删除用户订单信息的方法的服务
 *@return boolean  
 */
	@Override
	public boolean deletePersonByAll(Personcar perSonCar) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletePersonByAll(perSonCar)>0)
		{
			flag=true;
		}
		
		return flag;
	}
/**
 * 
 * 获取用户订单信息的服务
 * @return Personcar
 */
	@Override
	public Personcar getPersoncar(Personcar personcar) {
		// TODO Auto-generated method stub
		return personCarDao.getPersoncar(personcar);
	}
/**
 * 
 * 检查是否还有与某车主编号关联的用户订单信息的服务
 * @return boolean
 */
	@Override
	public boolean checkcuidperson(Personcar p) {
		// TODO Auto-generated method stub
		return personCarDao.checkcuidperson(p);
	}
 /**
 * 根据车主编号删除用户订单信息的服务
 *@return boolean  
 */
	@Override
	public boolean deletecuidperson(Personcar p) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(personCarDao.deletecuidperson(p)>0)
		{
			flag=true;
		}
		
		return flag;
	}
}
