package cn.com.dao;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IPersonNeedDao {
public int addPersonNeed(Personneed personNeed);
public int deletePersonNeed(Personneed personNeed);
public Personneed getPerSonNeed(Personneed personNeed);
}
