package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;


import cn.com.pojo.*;
@Repository
public interface ICarImagesInfoService {
	public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo);
	public boolean addCarImagesInfo(Imagesinfo carImagesInfo);
	public boolean updateCarImagesInfo(Imagesinfo carImagesInfo);
	 public boolean deleteimagesinfouser(Imagesinfo c);
	 public boolean deletecidimagesinfouser(Imagesinfo c);
	 public boolean checkimageinfouser(Imagesinfo c);
	 public boolean checkcidimageinfouser(Imagesinfo c);
	
}
