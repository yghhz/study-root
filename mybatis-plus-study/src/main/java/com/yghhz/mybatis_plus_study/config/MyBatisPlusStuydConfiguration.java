package com.yghhz.mybatis_plus_study.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wanghongwei
 * @Title:
 * @Description:
 * @date 2022/7/29 21:25
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.yghhz.mybatis_plus_study.mapper")
public class MyBatisPlusStuydConfiguration {
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
