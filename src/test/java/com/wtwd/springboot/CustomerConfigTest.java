package com.wtwd.springboot;

import com.wtwd.springboot.model.ConfigBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试Spring Boot配置
 * @author MR.ZHANG
 * @create 2018-08-09 11:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//EnableConfigurationProperties是配置文件的属性赋给实体类需要加入的注解
@EnableConfigurationProperties(ConfigBean.class)
public class CustomerConfigTest {

    @Value("${customer.name}")
    private String name;

    @Value("${customer.age}")
    private String  age;

    @Test
    public void test1() {
        System.out.println("name : " + name + "--- age : " + age);
    }

    @Autowired
    ConfigBean configBean;
    @Test
    public void test2() {
        System.out.println(configBean.toString());
    }

}
