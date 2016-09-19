package cn.com.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.com.pojo.*;


import cn.com.dao.*;
import cn.com.service.*;
/**
 * 车系信息服务实现类
 * @author lej
 */
@Service
public class ModelServiceImpl implements IModelService{
	@Resource
  private IModelDao modelDao=null; //车系信息服务接口的引用
  

public IModelDao getModelDao() {
	return modelDao;
}

public void setModelDao(IModelDao modelDao) {
	this.modelDao = modelDao;
}
      /**
       * 按条件获取车系信息的服务
       * @parma model
       *@return List<Model> 
       */
@Override
public List<Model> getModelByWhere(Model model) {
	// TODO Auto-generated method stub
	return modelDao.getModelByWhere(model);
}
      /**
       * 添加车系信息的服务
       * @parma model
       *@return boolean
       */
@Override
public boolean addModel(Model model) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(modelDao.addModel(model)>0){
		flag=true;
	}
	return flag;
}
      /**
       * 修改车系信息的服务
       * @parma model
       *@return boolean
       */
@Override
public boolean updateModel(Model model) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(modelDao.updateModel(model)>0){
		flag=true;
	}
	return flag;
}
      /**
       * 删除车系信息的服务
       * @parma model
       *@return boolean
       */
@Override
public boolean deleteModel(Model model) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(modelDao.deleteModel(model)>0){
		flag=true;
	}
	return flag;
}
}
