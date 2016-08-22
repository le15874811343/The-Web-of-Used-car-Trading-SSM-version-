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

}
