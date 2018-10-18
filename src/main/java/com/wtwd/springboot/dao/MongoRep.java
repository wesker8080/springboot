package com.wtwd.springboot.dao;

import com.wtwd.springboot.model.MongoBean;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoDB操作数据库接口
 *
 * @author MR.ZHANG
 * @create 2018-08-14 17:22
 */
public interface MongoRep extends MongoRepository<MongoBean,String> {
    MongoBean findByAge(int age);
    MongoBean findByName(String name);
}
