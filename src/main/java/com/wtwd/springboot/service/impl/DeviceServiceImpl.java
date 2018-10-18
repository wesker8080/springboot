package com.wtwd.springboot.service.impl;

import com.wtwd.springboot.mapper.DeviceMapper;
import com.wtwd.springboot.model.Device;
import com.wtwd.springboot.model.DeviceUserLocation;
import com.wtwd.springboot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MR.ZHANG
 * @create 2018-07-25 16:22
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Override
    @Transactional
    public int addDevice(Device device) {
        return deviceMapper.insert(device);
    }

    @Override
    public List<Device> getAllDeviceInfo() {
        return deviceMapper.selectByNoneParam();
    }


    @Override
    public List<DeviceUserLocation> getLocationDataByParam(String param, List<String> list) {
        return deviceMapper.selectByTwoParam(param,list);
    }

    @Override
    public List<DeviceUserLocation> getLocationDataByParam(String param, String id) {
        return deviceMapper.selectByTwoParamMob(param,id);
    }
}
