package cn.com.service;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IEmissionstandardService {
	public Map<Integer, Emissionstandard> getEmissionstandardByCount();
}
