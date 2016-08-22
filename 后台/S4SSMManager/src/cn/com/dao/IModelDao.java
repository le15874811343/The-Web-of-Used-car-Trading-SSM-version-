package cn.com.dao;
import java.util.*;

import cn.com.pojo.*;
public interface IModelDao {
      public List<Model> getModelByWhere(Model model);
      public int addModel(Model model);
      public int updateModel(Model model);
      public int deleteModel(Model model);
}
