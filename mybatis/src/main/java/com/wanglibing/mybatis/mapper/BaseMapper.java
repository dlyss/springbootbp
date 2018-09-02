package com.wanglibing.mybatis.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import java.util.List;

//@RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

    /**
     * 查询全部结果（扩展测试Demo）
     *
     * @return
     */
    @SelectProvider(type = ExtensionProvider.class, method = "dynamicSQL")
    List<T> extensionSelectAll();
}