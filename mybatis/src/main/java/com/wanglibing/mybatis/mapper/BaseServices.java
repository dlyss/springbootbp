package com.wanglibing.mybatis.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public abstract class BaseServices<T> implements IBaseServices<T> {
    @Autowired
    protected Mapper<T> mapper;
    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    @CachePut(key="#p0.id")
    public T insert(T entity){
        mapper.insert(entity);
        return entity;
    }

    @Override
    @CachePut(key="#p0.id")
    public T updateAll(T entity){
        mapper.updateByPrimaryKey(entity);
        return mapper.selectByPrimaryKey(entity);
    }

    @Override
    @CachePut(key="#p0.id")
    public T updateNotNull(T entity){
        mapper.updateByPrimaryKeySelective(entity);
        return mapper.selectByPrimaryKey(entity);
    }

    @Override
    @CacheEvict(key="#p0.id")
    public int delete(T entity){
        return mapper.deleteByPrimaryKey(entity);
    }

    @Override
    @CacheEvict(key="#p0.id")
    public int deleteByPrimaryKey(T entity){
        return mapper.deleteByPrimaryKey(entity);
    }

    @Override
    @Cacheable(key="#p0.id")
    public T selectByPrimaryKey(T entity){
        return mapper.selectByPrimaryKey(entity);
    }

    @Override
    @Cacheable
    public List<T> selectAll(){
        return mapper.selectAll();
    }

    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    @Override
    @Cacheable
    public PageInfo selectByPages(Integer page,Integer size){
        PageHelper.startPage(page, size);
        List<T> list = mapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
    //TODO 其他...

}
