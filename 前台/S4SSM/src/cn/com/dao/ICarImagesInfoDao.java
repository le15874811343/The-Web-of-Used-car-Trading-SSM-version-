package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 汽车图片信息操作接口
 * @author lej
 */
@Repository
public interface ICarImagesInfoDao {
     /**
   * 根据编号获取汽车照片的方法
   * @parma carInfo
   * @return Map<Integer,String>
   */
public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo);
/**
 * 添加照片信息的方法
 * @parma carImagesInfo
 *@reutn int 
 */
public int addCarImagesInfo(Imagesinfo carImagesInfo);
/**
 *修改照片信息的方法 
 * @parmas
 * @return int
 */
public int updateCarImagesInfo(Imagesinfo carImagesInfo);

}
