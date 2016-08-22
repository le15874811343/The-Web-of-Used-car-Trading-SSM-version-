package cn.com.dao;

import java.util.*;

import cn.com.pojo.*;

public interface IEmissionstandardDao {
	public Map<Integer,Emissionstandard> getEmissionstandardByCount();
	public int addEmissionstandard(Emissionstandard emissionstandard);
	public int deleteEmissionstandard(Emissionstandard emissionstandard);
	public int updateEmissionstandard(Emissionstandard emissionstandard);
	public Emissionstandard getEmissionstandard(Emissionstandard emissionstandard);
}
