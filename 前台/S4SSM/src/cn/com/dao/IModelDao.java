package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IModelDao {
      public List<Model> getModelByWhere(Model model);
}
