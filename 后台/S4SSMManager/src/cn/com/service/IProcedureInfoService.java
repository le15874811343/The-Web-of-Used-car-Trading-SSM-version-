package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

@Repository
public interface IProcedureInfoService {
	public Map<Long, Procedureinfo> getAllProcedureInfo();
	public Procedureinfo getProcedureInfoById(Carinfo carInfo);
	public boolean addProcedureInfo(Procedureinfo procedureInfo);
	public boolean updateProcedureInfo(Procedureinfo procedureInfo);
	public boolean deleteprocedureinfouser(Procedureinfo p);
	public boolean deletecidprocedureinfouser(Procedureinfo p);
	public boolean checkprocedureinfouser(Procedureinfo p);
	public boolean checkcidprocedureinfouser(Procedureinfo p);
}
