package cn.com.service;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IEmissionstandardService {
	public Map<Integer, Emissionstandard> getEmissionstandardByCount();
	public boolean addEmissionstandard(Emissionstandard emissionstandard);
	public boolean updateEmissionstandard(Emissionstandard emissionstandard);
	public boolean deleteEmissionstandard(Emissionstandard emissionstandard);
	public Emissionstandard getEmissionstandard(Emissionstandard emissionstandard);
			
}
