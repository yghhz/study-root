package com.yghhz.resttemplate.study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author wanghongwei
 * @Title:
 * @Description: get相关操作，对应的接收方法在swagger-study中
 * @date 2022/9/27 17:47
 */
@RestController
public class GetMethodController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${resttemplate.study.getForObjectNoArgs.url}")
    private String getForObjectNoArgsUrl;
    @Value("${resttemplate.study.getForObject.url}")
    private String getForObject;
    @Value("${resttemplate.study.getForObjectMap.url}")
    private String getForObjectMap;
    
    /** 
     * @description 无参get方法 
     * @author wanghongwei 
     * @date 2023/2/2 19:54  
     * @return java.lang.String
    **/
    @GetMapping("get/getForObjectNoArgs")
    public String getForObjectNoArgs(){
        JSONObject object = restTemplate.getForObject(getForObjectNoArgsUrl, JSONObject.class);
        return JSON.toJSONString(object);
    }

    /** 
     * @description url拼接参数 
     * @author wanghongwei 
     * @date 2023/2/2 19:55  
     * @return java.lang.String
    **/
    @GetMapping("get/getForObjectUrl")
    public String getForObjectUrl(){
        String url = getForObject +"?name="+213+"&address="+"test";
        JSONObject object = restTemplate.getForObject(url, JSONObject.class);
        return JSON.toJSONString(object);
    }
    
    /** 
     * @description map方式携带参数
     * @author wanghongwei 
     * @date 2023/2/2 19:55  
     * @return java.lang.String
    **/
    @GetMapping("get/getForObjectMap")
    public String getForObjectMap(){
        HashMap<String,String> map = new HashMap();
        String url = getForObjectMap+"/{name}/{address}";
        map.put("name","name111");
        map.put("address","address111");
        JSONObject object = restTemplate.getForObject(url,JSONObject.class,map);
        return JSON.toJSONString(object);
    }
    
    /** 
     * @description uri方式携带参数 
     * @author wanghongwei 
     * @date 2023/2/2 19:56  
     * @return java.lang.String
    **/
    @GetMapping("get/getForObjectUri")
    public String getForObjectUri(){
        HashMap<String,String> map = new HashMap();
        String url = getForObjectMap+"/{name}/{address}";
        JSONObject object = restTemplate.getForObject(url,JSONObject.class,"test111","addr");
        return JSON.toJSONString(object);
    }
    
    /** 
     * @description  Entity无参调用
     * @author wanghongwei 
     * @date 2023/2/2 19:56  
     * @return java.lang.String
    **/
    @GetMapping("get/getForEntityNoArgs")
    public String getForEntityNoArgs(){
        ResponseEntity<JSONObject> entity = restTemplate.getForEntity(getForObjectNoArgsUrl, JSONObject.class);
        return JSON.toJSONString(entity.getBody());
    }
    
    /** 
     * @description  entity拼接url调用
     * @author wanghongwei 
     * @date 2023/2/2 19:56  
     * @return java.lang.String
    **/
    @GetMapping("get/getForEntityUrl")
    public String getForEntityUrl(){
        String url = getForObject +"?name="+213+"&address="+"test";
        ResponseEntity<JSONObject> entity = restTemplate.getForEntity(url, JSONObject.class);
        return JSON.toJSONString(entity.getBody());
    }

    /**
     * @description  entity使用map携带参数
     * @author wanghongwei
     * @date 2023/2/2 19:56
     * @return java.lang.String
     **/
    @GetMapping("get/getForEntityMap")
    public String getForEntityMap(){
        HashMap<String,String> map = new HashMap();
        String url = getForObjectMap+"/{name}/{address}";
        map.put("name","name111");
        map.put("address","address111");
        ResponseEntity<JSONObject> entity = restTemplate.getForEntity(url,JSONObject.class,map);
        return JSON.toJSONString(entity.getBody());
    }

    /**
     * @description  entity使用uri方式调用
     * @author wanghongwei
     * @date 2023/2/2 19:56
     * @return java.lang.String
     **/
    @GetMapping("get/getForEntityUri")
    public String getForEntityUri(){
        HashMap<String,String> map = new HashMap();
        String url = getForObjectMap+"/{name}/{address}";
        ResponseEntity<JSONObject> entity  = restTemplate.getForEntity(url,JSONObject.class,"test111","addr");
        return JSON.toJSONString(entity.getBody());
    }
}
