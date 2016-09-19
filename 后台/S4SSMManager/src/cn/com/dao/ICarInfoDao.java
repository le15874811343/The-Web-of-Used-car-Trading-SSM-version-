package cn.com.dao;
import java.util.*;

import cn.com.pojo.*;
/**
 * 汽车概要信息操作接口
 * @author lej
 */
public interface ICarInfoDao {
  /**
 * 按热度获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
  public Map<Long, Carinfo> getCarInfoByCountDesc(Carinfo carInfo);
  /**
 * 按热度和品牌获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
  public Map<Long, Carinfo>  getCarInfoByBrandCountDesc(Carinfo carInfo);
  /**
 * 按上架时间获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
  public Map<Long, Carinfo> getCarInfoBySjTime(Carinfo carInfo);
  /**
 * 获取四辆最新上架的汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
  public Map<Long, Carinfo> getFourthCarInfoBySjTime(Carinfo carInfo);
  /**
 * 按热度和车型获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */

  public Map<Long, Carinfo>  getCarInfoByTypeCountDesc(Carinfo carInfo);
  /**
 * 按品牌获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
  public Map<Long, Carinfo> getCarInfoByBrand(Carinfo carInfo);
  /**
 * 按车型获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
  public Map<Long,Carinfo>   getCarInfoByType(Carinfo carInfo);
  /**
 * 按条件获取汽车概要信息的方法
 * @parma carInfo
 * @return   Map<Long, CarInfo>
 */
  public Map<Long, Carinfo> getCarByWhere(Carinfo carInfo);
   /**
   * 修改汽车概要信息的方法
   * @parma carInfo
   * @return int
   */
  public int updateCarInfo(Carinfo carInfo);
   /**
   * 添加汽车概要信息的方法
   * @parma carInfo
   * @return int
   */
  public int addCarInfo(Carinfo carInfo);
  /**
 * 按唯一条件获取汽车概要信息的方法
 * @parma carInfo
 * @return   CarInfo
 */
  public Carinfo getCarInfoByUMN(Carinfo carInfo);
  /**
   * 修改汽车所有概要信息的方法
   * @parma carInfo
   * @return int
   */
  public int updateCarAll(Carinfo carInfo);
  /**
 * 根据车主编号删除汽车概要信息的方法
 *@return int  
 */
  public int deletecarinfouser(Carinfo u);
  /**
 * 根据车编号删除汽车概要信息的方法
 *@return int  
 */
  public int deletecarinfo(Carinfo c);
  /**
 * 
 * 检查是否还有与某车主编号关联的汽车概要信息
 * @return boolean
 */
  public boolean checkcarinfouser(Carinfo c);
  /**
   * 获取热度最高的10辆车
   * @parma carInfo
   * @return List<CarInfo>
   */
  public List<Carinfo> getTenCount(Carinfo carInfo);
    /**
   * 获取热度最高10个品牌的车
   * @parma carInfo
   * @return List<CarInfo>
   */
  public List<Carinfo> getTenBrandCar(Carinfo carInfo);
}
