package com.wtwd.springboot.mapper;

import com.wtwd.springboot.model.Device;
import com.wtwd.springboot.model.DeviceUserLocation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(Integer devId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Integer devId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> selectByNoneParam();

    List<DeviceUserLocation> selectByOneParam(String param);

    List<DeviceUserLocation> selectByTwoParam(@Param("param")String param, @Param("userlist")List<String> list);
    List<DeviceUserLocation> selectByTwoParamMob(@Param("param")String param, @Param("id")String id);

}