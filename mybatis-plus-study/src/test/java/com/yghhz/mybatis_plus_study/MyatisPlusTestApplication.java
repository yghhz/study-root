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
}
