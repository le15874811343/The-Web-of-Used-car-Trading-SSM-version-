package cn.com.dao;

import java.util.Map;
import cn.com.pojo.*;
/**
 * 汽车基本信息操作接口
 * @author lej
 */
public interface IBasicInfoDao {
/**
 * 获取所有基本信息的方法
 * @return Map<Long, BasicInfo>
*/
public Map<Long, Basicinfo> getAllBasic();
/**
 *根据编号获取汽车基本信息的方法 
 *@return BasicInfo
 */
public Basicinfo getAllBasicById(Carinfo carInfo);
/**
 * 添加汽车基本信息的方法
 * @return int
 */
public int addBasicInfo(Basicinfo basicInfo);
/**
 * 修改汽车基本信息的方法
 * @return int
 */
public int updateBasicInfo( Basicinfo basicInfo);
/**
 * 根据车主编号删除汽车基本信息的方法
 *@return int  
 */
public int deletebasicinfo(Basicinfo b);
/**
 * 根据车编号删除汽车基本信息的方法
 *@return int  
 */
public int deletecidbasicinfo(Basicinfo b);
/**
 * 
 * 检查是否还有与某车主编号关联的汽车基本信息
 * @return boolean
 */
public boolean checkbasicinfo(Basicinfo b);
/**
 * 
 * 检查是否还有与某车编号关联的汽车基本信息
 * @return boolean
 */
public boolean checkcidbasicinfo(Basicinfo b);
}
