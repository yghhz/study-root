package com.yghhz.mybatis_plus_study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yghhz.mybatis_plus_study.entity.User;
import com.yghhz.mybatis_plus_study.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author wanghongwei
 * @Title:
 * @Description:
 * @date 2022/7/31 10:21
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testQueryWrapper(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNotNull("gmt_update")
                        .ge("age",12);
        userMapper.selectList(userQueryWrapper);
    }
    @Test
    public void testQueryWrapper1(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNotNull("gmt_update")
                .ge("age",12).
                eq("name","2222");
        userMapper.selectOne(userQueryWrapper);
    }

    @Test
    public void testQueryWrapper2(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.between("age",0,10);
        userMapper.selectOne(userQueryWrapper);
    }
    @Test
    public void testQueryWrapper4(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name","22");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
    }
    @Test
    public void testQueryWrapper5(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("id","select id from user where id <=3");
        List<Object> objectList = userMapper.selectObjs(userQueryWrapper);
        objectList.forEach(System.out::println);
    }
    @Test
    public void testQueryWrapper6(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("id");
        List<Object> objectList = userMapper.selectObjs(userQueryWrapper);
        objectList.forEach(System.out::println);
    }
}
