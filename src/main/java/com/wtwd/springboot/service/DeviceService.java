package com.wtwd.springboot.service;

import com.wtwd.springboot.model.Device;
import com.wtwd.springboot.model.DeviceUserLocation;

import java.util.List;

public interface DeviceService {
    int addDevice(Device device);

    List<Device> getAllDeviceInfo();

    List<DeviceUserLocation> getLocationDataByParam(String param, List<String> list);
    List<DeviceUserLocation> getLocationDataByParam(String param, String id);

}
