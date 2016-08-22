package cn.com.dao;

import java.util.Map;

import cn.com.pojo.*;


public interface IHardwareConfig {
public Map<Long, Hardwareconfig> getAllHardwareConfig();
public Hardwareconfig getHardwareConfigById(Carinfo carInfo);
public int addHardwareConfig(Hardwareconfig hardwareConfig);
public int updateHardwareConfig(Hardwareconfig hardwareConfig);
public int deletehardwareconfiguser(Hardwareconfig h);
public int deletecidhardwareconfiguser(Hardwareconfig h);
public boolean checkhardwareconfig(Hardwareconfig h);
public boolean checkcidhardwareconfig(Hardwareconfig h);
}
