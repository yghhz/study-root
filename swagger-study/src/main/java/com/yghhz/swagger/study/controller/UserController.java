package com.yghhz.swagger.study.controller;

import com.alibaba.fastjson.JSONObject;
import com.yghhz.swagger.study.entity.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghongwei
 * @Title:
 * @Description: 用户
 * @date 2022/9/27 14:40
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户控制器")
public class UserController {

    @GetMapping("getUserInfo/{username}/{address}")
    public String getUserInfo(@PathVariable(value = "username") String name,@PathVariable String address) {
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        return JSONObject.toJSONString(user);
    }

}
