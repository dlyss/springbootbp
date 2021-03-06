package com.wanglibing.mybatis.dynamicdatasource;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据源操作
 * @author iamwlb
 */
public class DynamicDataSourceContextHolder {
    /**
     * 线程本地环境
     */
    private static final ThreadLocal<String> contextHolders = new ThreadLocal<String>();
    /**
     * 数据源列表
     */
    public static List<String> dataSourceIds = new ArrayList<>();

    /**
     * 设置数据源
     * @param customerType
     */
    public static void setDataSource(String customerType) {
        contextHolders.set(customerType);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSource() {
        return (String) contextHolders.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource() {
        contextHolders.remove();
    }
    /**
     * 判断指定DataSrouce当前是否存在
     * @param dataSourceId
     * @return
     * @author iamwlb
     * @create  2016年1月24日
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}