package cn.com.service;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;

@Repository
public interface IHardwareConfigService {
	public Map<Long, Hardwareconfig> getAllHardwareConfig();
	public Hardwareconfig getHardwareConfigById(Carinfo carInfo);
	public boolean addHardwareConfig(Hardwareconfig hardwareConfig);
	public boolean updateHardwareConfig(Hardwareconfig hardwareConfig);
	public boolean deletehardwareconfiguser(Hardwareconfig h);
	 public boolean deletecidhardwareconfiguser(Hardwareconfig h);
	 public boolean checkhardwareconfig(Hardwareconfig h);
	 public boolean checkcidhardwareconfig(Hardwareconfig h);
}
