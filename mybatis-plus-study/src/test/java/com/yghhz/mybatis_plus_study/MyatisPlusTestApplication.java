package com.yghhz.mybatis_plus_study;

import com.yghhz.mybatis_plus_study.entity.User;
import com.yghhz.mybatis_plus_study.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wanghongwei
 * @Title:
 * @Description:
 * @date 2022/7/23 20:57
 */
@SpringBootTest
public class MyatisPlusTestApplication {
    @Autowired
    UserMapper userMapper;

    @Test
    public void findUserList(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setName("test");
        user.setAge(1);
        user.setEmail("123456@qq.com");
        userMapper.insert(user);
    }
    @Test
    public void updateUser(){
        User user = new User();
        user.setName("test");
        user.setAge(2);
        user.setEmail("123456@qq.com");
        user.setId(6l);
        userMapper.updateById(user);
    }
    @Test
    public void testVersion(){
        User user = userMapper.selectById(1);
        Integer version = user.getVersion();
        user.setName("1111");
        User user1 = userMapper.selectById(1);
        user1.setName("2222");
        Integer version1 = user1.getVersion();
        userMapper.updateById(user1);
        userMapper.updateById(user);
    }
}
