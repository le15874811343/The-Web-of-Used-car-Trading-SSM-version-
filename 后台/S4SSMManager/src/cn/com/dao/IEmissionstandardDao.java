package cn.com.dao;

import java.util.*;

import cn.com.pojo.*;
/**
 * 
 * 排放标准操作接口
 *@author  lej
 */
public interface IEmissionstandardDao {
	/**
	 * 按热度获取排放标准信息的方法
	 * @return Map<Integer,Emissionstandard>
	 */
	public Map<Integer,Emissionstandard> getEmissionstandardByCount();
	 /**
           * 添加排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	public int addEmissionstandard(Emissionstandard emissionstandard);
	 /**
           * 删除排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	public int deleteEmissionstandard(Emissionstandard emissionstandard);
	 /**
           * 修改排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	public int updateEmissionstandard(Emissionstandard emissionstandard);
	/**
	 * 获取排放标准信息的方法
	 * @return Emissionstandard
	 */
	public Emissionstandard getEmissionstandard(Emissionstandard emissionstandard);
}
