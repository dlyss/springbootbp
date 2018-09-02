package com.wanglibing.mybatis.mapper;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBaseServices<T> {

    T insert(T entity);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param entity
     * @return
     */
    T updateAll(T entity);

    /**
     * 根据主键更新属性不为null的值
     * @param entity
     * @return
     */
    T updateNotNull(T entity);

    int delete(T entity);

    int deleteByPrimaryKey(T entity);

    T selectByPrimaryKey(T entity);


    List<T> selectAll();

    List<T> selectByExample(Object example);

    PageInfo<T> selectByPages(Integer page, Integer size);
}
