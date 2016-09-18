package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
/**
 * 车系信息操作接口
 * @author lej
 */
@Repository
public interface IModelDao {
      /**
       * 按条件获取车系信息的方法
       * @parma model
       *@return List<Model> 
       */
      public List<Model> getModelByWhere(Model model);
}
