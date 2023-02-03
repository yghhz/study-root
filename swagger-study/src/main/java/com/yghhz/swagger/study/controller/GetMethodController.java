package com.yghhz.swagger.study.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghongwei
 * @Title:
 * @Description: 这里的方法对应resttemplate-study中方法调用，这里相当于服务端
 * @date 2022/9/28 16:39
 */
@RestController
@Api(tags = "get方法测试")
public class GetMethodController {

    /**
     * @description 无参方法
     * @author wanghongwei
     * @date 2023/2/3 14:56
     * @return com.alibaba.fastjson.JSONObject
    **/
    @GetMapping("get/getForObjectNoArgs")
    public JSONObject getForObjectNoArgs(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","hello world!");
        return jsonObject;
    }

    /**
     * @description  url中拼接或者data中传递
     * @author wanghongwei
     * @date 2023/2/3 14:56
     * @param name
     * @param address
     * @return com.alibaba.fastjson.JSONObject
    **/
    @GetMapping("get/getForObject")
    public JSONObject getForObject(@RequestParam(value = "name",required = true) String name,@RequestParam(value = "address",required = true) String address){
        JSONObject jsonObject = new JSONObject();
       jsonObject.put("name",name);
       jsonObject.put("address",address);
        return jsonObject;
    }
    /**
     * @description rest方式
     * @author wanghongwei
     * @date 2023/2/3 14:57
     * @param name
     * @param address
     * @return com.alibaba.fastjson.JSONObject
    **/
    @GetMapping("get/getForObjectMap/{name}/{address}")
    public JSONObject getForObjectMap(@PathVariable(value = "name") String name, @PathVariable(value = "address") String address){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("address",address);
        return jsonObject;
    }
}
