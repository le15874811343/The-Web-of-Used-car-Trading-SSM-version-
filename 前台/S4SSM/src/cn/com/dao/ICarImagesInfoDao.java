package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

@Repository
public interface ICarImagesInfoDao {
public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo);
public int addCarImagesInfo(Imagesinfo carImagesInfo);
public int updateCarImagesInfo(Imagesinfo carImagesInfo);

}
