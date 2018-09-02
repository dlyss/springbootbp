package com.wanglibing.webapi.service;

import com.github.pagehelper.PageInfo;
import com.wanglibing.webapi.pojo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserService {

    @CachePut(key="#p0.id")
    User insert(User user);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param user
     * @return
     */
    @CachePut(key="#p0.id")
    User updateAll(User user);

    /**
     * 根据主键更新属性不为null的值
     * @param user
     * @return
     */
    @CachePut(key="#p0.id")
    User updateNotNull(User user);

    @CacheEvict(key="#p0.id")
    int deleteByPrimaryKey(User user);

    @Cacheable(key="#p0.id")
    User selectByPrimaryKey(User user);

    @Cacheable
    List<User> selectAll();

    List<User> selectByExample(Object example);

    @Cacheable
    PageInfo<User> selectByPages(Integer page, Integer size);
}