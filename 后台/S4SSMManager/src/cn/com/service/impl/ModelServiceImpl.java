package cn.com.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.com.pojo.*;


import cn.com.dao.*;
import cn.com.service.*;
@Service
public class ModelServiceImpl implements IModelService{
	@Resource
  private IModelDao modelDao=null;
  

public IModelDao getModelDao() {
	return modelDao;
}

public void setModelDao(IModelDao modelDao) {
	this.modelDao = modelDao;
}

@Override
public List<Model> getModelByWhere(Model model) {
	// TODO Auto-generated method stub
	return modelDao.getModelByWhere(model);
}

@Override
public boolean addModel(Model model) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(modelDao.addModel(model)>0){
		flag=true;
	}
	return flag;
}

@Override
public boolean updateModel(Model model) {
	// TODO Auto-generated method stub
	boolean flag=false;
	if(modelDao.updateModel(model)>0){
		flag=true;
	}
	return flag;
}

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
