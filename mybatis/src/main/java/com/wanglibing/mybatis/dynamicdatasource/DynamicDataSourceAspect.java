package com.wanglibing.mybatis.dynamicdatasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: iamwlb
 * @Date: 2018/8/15 21:29
 * @Description: 使用AOP拦截特定的注解去动态的切换数据源
 */
@Aspect
/**
 * 保证该AOP在@Transactional之前执行
 */
@Order(-1)
@Component
@Slf4j
public class DynamicDataSourceAspect {
    /**
     * 执行方法前更换数据源
     * @within在类上设置
     * @annotation在方法上进行设置
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @Before("@within(targetDataSource) || @annotation(targetDataSource)")
    public void doBefore(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        String dataSourceName = targetDataSource.dataSourceName();
        DynamicDataSourceContextHolder.setDataSource(dataSourceName);
        log.info(String.format("设置数据源为  %s", dataSourceName));
    }

    /**
     * 执行方法后清除数据源设置
     *
     * @param joinPoint        切点
     * @param targetDataSource 动态数据源
     */
    @After("@within(targetDataSource) || @annotation(targetDataSource)")
    public void doAfter(JoinPoint joinPoint, TargetDataSource targetDataSource) {
        log.info(String.format("当前数据源  %s  执行清理方法", targetDataSource.dataSourceName()));
        DynamicDataSourceContextHolder.clearDataSource();
    }
}
