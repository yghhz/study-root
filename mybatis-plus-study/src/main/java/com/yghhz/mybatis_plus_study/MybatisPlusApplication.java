package com.yghhz.mybatis_plus_study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wanghongwei
 * @Title:
 * @Description:
 * @date 2022/7/23 20:07
 */
@SpringBootApplication
@MapperScan("com.yghhz.mybatis_plus_study.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}
