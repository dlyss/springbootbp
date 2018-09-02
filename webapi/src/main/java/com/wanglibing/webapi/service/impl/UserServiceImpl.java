package com.wanglibing.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanglibing.webapi.mapper.UserMapper;
import com.wanglibing.webapi.pojo.User;
import com.wanglibing.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public User updateAll(User user) {
        userMapper.updateByPrimaryKey(user);
        return userMapper.selectByPrimaryKey(user);
    }

    @Override
    public User updateNotNull(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return userMapper.selectByPrimaryKey(user);
    }

    @Override
    public int deleteByPrimaryKey(User user) {
        return userMapper.deleteByPrimaryKey(user);
    }

    @Override
    public User selectByPrimaryKey(User user) {
        return userMapper.selectByPrimaryKey(user);
    }

    @Override
    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    @Override
    public List<User> selectByExample(Object example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public PageInfo selectByPages(Integer page, Integer size){
        PageHelper.startPage(page, size);
        List<User> list = userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
