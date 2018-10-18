package com.wtwd.springboot.controller;

import com.wtwd.springboot.model.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MR.ZHANG
 * @create 2018-08-09 10:21
 */
@RestController
@RequestMapping("/api/v1.1/test")
//EnableConfigurationProperties是配置文件的属性赋给实体类需要加入的注解
@EnableConfigurationProperties(ConfigBean.class)
public class TestController {
    @Autowired
    ConfigBean configBean;

    @GetMapping("bean")
    public String testConfigBean() {
        return configBean.toString();
    }
    @GetMapping("/websocket")
    public String websocket() {return "websocket";}
}
