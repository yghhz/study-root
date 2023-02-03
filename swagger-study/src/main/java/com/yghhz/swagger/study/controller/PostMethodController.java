package com.yghhz.swagger.study.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author wanghongwei
 * @Title:
 * @Description: 这里的方法对应resttemplate-study中方法调用，这里相当于服务端
 * @date 2022/9/29 15:16
 */
@RestController
public class PostMethodController {

    /**
     * @description  普通post请求
     * @author wanghongwei
     * @date 2023/2/3 14:58
     * @param jsonObject
     * @return com.alibaba.fastjson.JSONObject
    **/
    @PostMapping("post/postForObjectJson")
    public JSONObject postForObjectJson(@RequestBody JSONObject jsonObject){
        return jsonObject;
    }

    /**
     * @description form表单
     * @author wanghongwei
     * @date 2023/2/3 14:58
     * @param name
     * @param address
     * @return com.alibaba.fastjson.JSONObject
    **/
    @PostMapping("post/postForObjectForm")
    public JSONObject postForObjectForm(@RequestParam String name,@RequestParam String address){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("address",address);
        return jsonObject;
    }

    /**
     * @description 携带文件的表单
     * @author wanghongwei
     * @date 2023/2/3 14:58
     * @param file
     * @param name
     * @return com.alibaba.fastjson.JSONObject
    **/
    @PostMapping("post/postForObjectFormFile")
    public JSONObject postForObjectFormFile(@RequestParam("file") MultipartFile file,@RequestParam("name") String name){
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }

}
