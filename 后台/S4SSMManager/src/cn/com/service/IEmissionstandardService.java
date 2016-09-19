package cn.com.service;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 
 * 排放标准服务接口
 *@author  lej
 */
@Repository
public interface IEmissionstandardService {
	/**
	 * 按热度获取排放标准信息的服务
	 * @return Map<Integer,Emissionstandard>
	 */
	public Map<Integer, Emissionstandard> getEmissionstandardByCount();
	 /**
           * 添加排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	public boolean addEmissionstandard(Emissionstandard emissionstandard);
	  /**
           * 修改排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	public boolean updateEmissionstandard(Emissionstandard emissionstandard);
	 /**
           * 删除排放标准信息的服务
           * @parma emissionstandard
           * @return boolean
           */
	public boolean deleteEmissionstandard(Emissionstandard emissionstandard);
	/**
	 * 获取排放标准信息的服务
	 * @return Emissionstandard
	 */
	public Emissionstandard getEmissionstandard(Emissionstandard emissionstandard);
			
}
