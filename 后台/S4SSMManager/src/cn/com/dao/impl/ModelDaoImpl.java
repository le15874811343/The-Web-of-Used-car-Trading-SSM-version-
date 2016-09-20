package cn.com.dao.impl;
import cn.com.pojo.*;

import cn.com.dao.*;
import java.util.*;

import org.springframework.stereotype.Repository;
/**
 * 车系信息操作实现类
 * @author lej
 */
@Repository
public class ModelDaoImpl extends BaseDao implements IModelDao {
      /**
       * 按条件获取车系信息的方法
       * @parma model
       *@return List<Model> 
       */
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
      /**
       * 添加车系信息的方法
       * @parma model
       *@return int
       */
	@Override
	public int addModel(Model model) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().insert("cn.com.pojo.ModelMapper.insertSelective", model);
	}
      /**
       * 修改车系信息的方法
       * @parma model
       *@return int
       */
	@Override
	public int updateModel(Model model) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().update("cn.com.pojo.ModelMapper.updateByPrimaryKeySelective", model);
	}
      /**
       * 删除车系信息的方法
       * @parma model
       *@return int
       */
	@Override
	public int deleteModel(Model model) {
		// TODO Auto-generated method stub
		return super.getSqlSessionTemplate().delete("cn.com.pojo.ModelMapper.deleteModel", model);
	}

}
