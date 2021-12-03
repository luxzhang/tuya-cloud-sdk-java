package com.tuya.api.common;

import org.apache.commons.lang.StringUtils;

import java.util.Objects;

/**
 * 涂鸦云各地区服务url
 */
public enum RegionEnum {
    /**
     * 中国区 - CHINA
     */
    URL_CN("https://openapi.tuyacn.com"),

    /**
     * 美洲区 - USA
     */
    URL_US("https://openapi.tuyaus.com"),

    /**
     * 欧洲区 - EUROPE
     */
    URL_EU("https://openapi.tuyaeu.com"),

    /**
     * 印度区 - INDIA
     */
    URL_IN("https://openapi.tuyain.com");

    private String endpoint;

    RegionEnum(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * @description: getRegion，默认返回中国区
     * @param key
     * @return: com.tuya.api.common.RegionEnum
     * @author: lux
     * @time: 2021/10/21 11:35
    */
    public static RegionEnum getRegion(String key) {
        if (StringUtils.isBlank(key)) {
            return URL_CN;
        }

        // 匹配区域，返回区域服务url
        for (RegionEnum regionEnum : values()) {
            if (Objects.equals(regionEnum.name(), key)) {
                return regionEnum;
            }
        }

        return URL_CN;
    }
}
