package com.wtwd.springboot.model;

import java.io.Serializable;

/**
 * 每个用户所对应的位置信息
 *
 * @author MR.ZHANG
 * @create 2018-07-28 11:46
 */
public class DeviceUserLocation implements Serializable {
    private static final long serialVersionUID = -8475539191932498813L;
    private Integer devUserid;
    private String devData;

    public Integer getDevUserid() {
        return devUserid;
    }

    public void setDevUserid(Integer devUserid) {
        this.devUserid = devUserid;
    }

    public String getDevData() {
        return devData;
    }

    public void setDevData(String devData) {
        this.devData = devData;
    }

    @Override
    public String toString() {
        return "DeviceUserLocation{" +
                "devUserid=" + devUserid +
                ", devData='" + devData + '\'' +
                '}';
    }
    public static class DevLocation {
        private Double latitude;
        private Double longitude;

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "DevLocation{" +
                    "latitude='" + latitude + '\'' +
                    ", longitude='" + longitude + '\'' +
                    '}';
        }
    }
}
