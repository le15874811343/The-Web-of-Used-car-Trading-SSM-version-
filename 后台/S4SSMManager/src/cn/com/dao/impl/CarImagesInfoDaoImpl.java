package cn.com.dao.impl;


import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
import cn.com.dao.*;
/**
 * 汽车图片信息操作实现类
 * @author lej
 */
@Repository
public class CarImagesInfoDaoImpl extends BaseDao implements ICarImagesInfoDao {
 /**
   * 根据编号获取汽车照片的方法
   * @parma carInfo
   * @return Map<Integer,String>
   */
	@Override
	public Map<Integer, String> getCarImagesInfoByID(Carinfo carInfo) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> imgMap = new HashMap<Integer, String>();
		
	
		
		try {
			 //获取结果
		Imagesinfo carImagesInfo=	  (Imagesinfo) super.getSqlSessionTemplate().selectMap("cn.com.pojo.ImagesinfoMapper.getCarImagesInfoByID", carInfo, "cId").get(carInfo.getcId());
				//将对象的非空文件地址压入map中
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
/**
 * 添加照片信息的方法
 * @parma carImagesInfo
 *@reutn int 
 */
	@Override
	public int addCarImagesInfo(Imagesinfo carImagesInfo) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
		super.getSqlSessionTemplate().insert("cn.com.pojo.ImagesinfoMapper.insertSelective", carImagesInfo);//添加
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
/**
 *修改照片信息的方法 
 * @parmas
 * @return int
 */
	@Override
	public int updateCarImagesInfo(Imagesinfo carImagesInfo) {
		// TODO Auto-generated method stub

			//返回受影响的行数
		return super.getSqlSessionTemplate().update("cn.com.pojo.ImagesinfoMapper.updateCarImagesInfo", carImagesInfo);
	}
/**
 * 根据车主编号删除汽车照片信息的方法
 *@return int  
 */
	@Override
	public int deleteimagesinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
			//返回受影响的行数
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ImagesinfoMapper.deleteimagesinfouser", c);
	}
/**
 * 根据车编号删除汽车照片信息的方法
 *@return int  
 */
	@Override
	public int deletecidimagesinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		//返回受影响的行数
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ImagesinfoMapper.deletecidimagesinfouser", c);
	}
/**
 * 
 * 检查是否还有与某车主编号关联的汽车照片信息
 * @return boolean
 */
	@Override
	public boolean checkimageinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.ImagesinfoMapper.checkimageinfouser",c, "cId").size()>0){
			   flag=true; //若结果集元素个数大于0,则返回为真
		   }
		return flag;
	}
/**
 * 
 * 检查是否还有与某车编号关联的汽车照片信息
 * @return boolean
 */
	@Override
	public boolean checkcidimageinfouser(Imagesinfo c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		   if(super.getSqlSessionTemplate().selectMap("cn.com.pojo.ImagesinfoMapper.checkcidimageinfouser", c, "cId").size()>0){
			   flag=true; //若结果集元素个数大于0,则返回为真
		   }
		return flag;
	}

}
