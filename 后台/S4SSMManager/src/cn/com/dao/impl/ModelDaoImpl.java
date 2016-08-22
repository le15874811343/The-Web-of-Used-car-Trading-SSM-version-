package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
@Repository
public class ModelDaoImpl extends BaseDao implements IModelDao {

	@Override
	public List<Model> getModelByWhere(Model model) {
		// TODO Auto-generated method stub
		
		List<Model> modelMap=new ArrayList<Model>();
		
		

	try {
	
		modelMap=	super.getSqlSessionTemplate().selectList("cn.com.pojo.ModelMapper.getModelByWhere", model);
		

	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return modelMap;
	}

	@Override
	public int addModel(Model model) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.ModelMapper.insertSelective", model);
	}

	@Override
	public int updateModel(Model model) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().update("cn.com.pojo.ModelMapper.updateByPrimaryKeySelective", model);
	}

	@Override
	public int deleteModel(Model model) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ModelMapper.deleteModel", model);
	}

}
