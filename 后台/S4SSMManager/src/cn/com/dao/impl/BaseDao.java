package cn.com.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

/**
 * 持久化模板基类
 */
@Component
public class BaseDao {
  @Resource
  private  SqlSessionTemplate sqlSessionTemplate;

public SqlSessionTemplate getSqlSessionTemplate() {
	return sqlSessionTemplate;
}

public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	this.sqlSessionTemplate = sqlSessionTemplate;
}
  
}
