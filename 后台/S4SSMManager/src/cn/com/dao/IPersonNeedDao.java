package cn.com.dao;

import cn.com.pojo.*;

public interface IPersonNeedDao {
public int addPersonNeed(Personneed personNeed);
public int deletePersonNeed(Personneed personNeed);
public Personneed getPerSonNeed(Personneed personNeed);
public int updatePersonNeed(Personneed personNeed);
public boolean chekUidPerson(Personneed personneed);
public int deleteUidPerson(Personneed personneed);
}
