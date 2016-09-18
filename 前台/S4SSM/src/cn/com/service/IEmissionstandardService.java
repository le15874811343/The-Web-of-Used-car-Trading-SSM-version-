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
	 * @Map<Integer,Emissionstandard>
	 */
	public Map<Integer, Emissionstandard> getEmissionstandardByCount();
}
