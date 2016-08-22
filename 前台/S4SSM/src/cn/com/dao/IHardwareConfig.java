package cn.com.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.pojo.*;
@Repository
public interface IHardwareConfig {
public Map<Long, Hardwareconfig> getAllHardwareConfig();
public Hardwareconfig getHardwareConfigById(Carinfo carInfo);
public int addHardwareConfig(Hardwareconfig hardwareConfig);
public int updateHardwareConfig(Hardwareconfig hardwareConfig);
}
