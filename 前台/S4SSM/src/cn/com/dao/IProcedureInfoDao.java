package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IProcedureInfoDao {
public Map<Long, Procedureinfo> getAllProcedureInfo();
public Procedureinfo getProcedureInfoById(Carinfo carInfo);
public int addProcedureInfo(Procedureinfo procedureInfo);
public int updateProcedureInfo(Procedureinfo procedureInfo);
}
