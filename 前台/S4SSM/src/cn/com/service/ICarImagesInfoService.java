package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 汽车图片信息服务接口
 * @author lej
 */
@Repository
public interface ICarImagesInfoService {
  /**
   * 根据编号获取汽车照片的服务
   * @parma carInfo
   * @return Map<Integer,String>
   */
	public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo);
/**
 * 添加照片信息的服务
 * @parma carImagesInfo
 *@reutn boolean 
 */
	public boolean addCarImagesInfo(Imagesinfo carImagesInfo);
/**
 *修改照片信息的服务
 * @parmas
 * @return boolean
 */
	public boolean updateCarImagesInfo(Imagesinfo carImagesInfo);
	
}
