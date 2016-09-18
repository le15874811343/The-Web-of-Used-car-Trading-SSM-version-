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
  private IModelDao modelDao=null; //车系操作接口的引用

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
}
