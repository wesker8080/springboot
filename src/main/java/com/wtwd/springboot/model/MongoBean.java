package com.wtwd.springboot.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB 测试Bean
 *
 * @author MR.ZHANG
 * @create 2018-08-14 17:14
 */
@Document(collection="student")
public class MongoBean {
    private String name;
    private Integer age;
    private String sex;
    private String address;
    public MongoBean() {
    }

    public MongoBean(String name, Integer age, String sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MongoBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
