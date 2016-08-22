package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;

@Repository
public class CarImagesInfoDaoImpl extends BaseDao implements ICarImagesInfoDao {
	/**
	 * 通过c_id来查询车辆照片信息
	 */
	@Override
	public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> imgMap = new HashMap<Integer, String>();
		
	
		
		try {
		Imagesinfo carImagesInfo=	  (Imagesinfo) super.getSqlSessionTemplate().selectMap("cn.com.pojo.ImagesinfoMapper.getCarImagesInfoByID", carInfo, "cId").get(carInfo.getcId());
				if (carImagesInfo.getImage1() != null
						&& !carImagesInfo.getImage1().equals("")) {
					imgMap.put(1, carImagesInfo.getImage1());
				}
				if (carImagesInfo.getImage2() != null
						&& !carImagesInfo.getImage2().equals("")) {
					imgMap.put(2, carImagesInfo.getImage2());
				}
				if (carImagesInfo.getImage3() != null
						&& !carImagesInfo.getImage3().equals("")) {
					imgMap.put(3, carImagesInfo.getImage3());
				}
				if (carImagesInfo.getImage4() != null
						&& !carImagesInfo.getImage4().equals("")) {
					imgMap.put(4, carImagesInfo.getImage4());
				}
				if (carImagesInfo.getImage5() != null
						&& !carImagesInfo.getImage5().equals("")) {
					imgMap.put(5, carImagesInfo.getImage5());
				}
				if (carImagesInfo.getImage6() != null
						&& !carImagesInfo.getImage6().equals("")) {
					imgMap.put(6, carImagesInfo.getImage6());
				}
				if (carImagesInfo.getImage7() != null
						&& !carImagesInfo.getImage7().equals("")) {
					imgMap.put(7, carImagesInfo.getImage7());
				}
				if (carImagesInfo.getImage8() != null
						&& !carImagesInfo.getImage8().equals("")) {
					imgMap.put(8, carImagesInfo.getImage8());
				}
				if (carImagesInfo.getImage9() != null
						&& !carImagesInfo.getImage9().equals("")) {
					imgMap.put(9, carImagesInfo.getImage9());
				}
				if (carImagesInfo.getImage10() != null
						&& !carImagesInfo.getImage10().equals("")) {
					imgMap.put(10, carImagesInfo.getImage10());
				}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgMap;
	}

	@Override
	public int addCarImagesInfo(Imagesinfo carImagesInfo) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
		super.getSqlSessionTemplate().insert("cn.com.pojo.ImagesinfoMapper.insertSelective", carImagesInfo);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateCarImagesInfo(Imagesinfo carImagesInfo) {
		// TODO Auto-generated method stub

		
		return super.getSqlSessionTemplate().update("cn.com.pojo.ImagesinfoMapper.updateCarImagesInfo", carImagesInfo);
	}

	@Override
	public int deleteimagesinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ImagesinfoMapper.deleteimagesinfouser", c);
	}

	@Override
	public int deletecidimagesinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ImagesinfoMapper.deletecidimagesinfouser", c);
	}

	@Override
	public boolean checkimageinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.ImagesinfoMapper.checkimageinfouser",c, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}

	@Override
	public boolean checkcidimageinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.ImagesinfoMapper.checkcidimageinfouser", c, "cId").size()>0){
			   flag=true;
		   }
		return flag;
	}

}
