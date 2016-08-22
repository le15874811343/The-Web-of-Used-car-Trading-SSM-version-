package cn.com.service;

import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IModelService {
	public List<Model> getModelByWhere(Model model);
}
