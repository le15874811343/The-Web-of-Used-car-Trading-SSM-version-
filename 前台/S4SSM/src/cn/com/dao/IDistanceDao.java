package cn.com.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IDistanceDao {
   public Map<Integer, Distance> getDistanceByCount();
}
