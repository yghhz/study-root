package com.yghhz.resttemplate.study.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.net.URI;

/**
 * @author wanghongwei
 * @Title:
 * @Description: post相关使用方法，对应的接收方法在swagger-study中
 * @date 2022/9/29 10:11
 */
@RestController
public class PostMethodController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${resttemplate.study.postForObjectJson.url}")
    private String postForObjectJsonUrl;
    @Value("${resttemplate.study.postForObjectForm.url}")
    private String postForObjectFormUrl;
    @Value("${resttemplate.study.postForObjectFormFile.url}")
    private String postForObjectFormFileUrl;
    
    /** 
     * @description 携带json对象调用
     * @author wanghongwei 
     * @date 2023/2/3 14:49  
     * @return java.lang.String
    **/
    @GetMapping("post/postForObjectJson")
    public String postForObjectJson(){
        JSONObject object = new JSONObject();
        object.put("name","1111");
        object.put("address","address22");
        JSONObject jsonObject = restTemplate.postForObject(postForObjectJsonUrl, object, JSONObject.class);
        return jsonObject.toJSONString();
    }
    /** 
     * @description  采用HttpEntity进行post调用
     * @author wanghongwei 
     * @date 2023/2/3 14:51  
     * @return java.lang.String
    **/
    @GetMapping("post/postForObjectJson2")
    public String postForObjectJson2(){
        JSONObject object = new JSONObject();
        object.put("name","postForObjectJson2");
        object.put("address","address22");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(object,headers);
        JSONObject jsonObject = restTemplate.postForObject(postForObjectJsonUrl, entity, JSONObject.class);
        return jsonObject.toJSONString();
    }

    /** 
     * @description 表单方式 
     * @author wanghongwei 
     * @date 2023/2/3 14:51  
     * @return java.lang.String
    **/
    @GetMapping("post/postForObjectForm")
    public String postForObjectForm(){
        // 请求头设置,x-www-form-urlencoded格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //提交参数设置
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("name", "844072586");
        map.add("address", "844072586");
        // 组装请求体
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        JSONObject result = restTemplate.postForObject(postForObjectFormUrl, request, JSONObject.class);
        return  result.toJSONString();
    }
    
    /** 
     * @description 表单携带文件方式调用 
     * @author wanghongwei 
     * @date 2023/2/3 14:52  
     * @return java.lang.String
    **/
    @GetMapping("post/postForObjectFormFile")
    public String postForObjectFormFile(){
        // 请求头设置,x-www-form-urlencoded格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //提交参数设置
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        File file = new File("D:\\idea_project\\sport.sql");
        map.add("file", new FileSystemResource(file));
        map.add("name", "123");
        // 组装请求体
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        JSONObject result = restTemplate.postForObject(postForObjectFormFileUrl, request, JSONObject.class);
        return  result.toJSONString();
    }
    
    /** 
     * @description entity方式调用
     * @author wanghongwei 
     * @date 2023/2/3 14:52  
     * @return java.lang.String
    **/
    @GetMapping("post/postForEntityJson")
    public String postForEntityJson(){
        JSONObject object = new JSONObject();
        object.put("name","1111");
        object.put("address","address22");
        ResponseEntity<JSONObject> jsonObject = restTemplate.postForEntity(postForObjectJsonUrl, object, JSONObject.class);
        return jsonObject.getBody().toJSONString();
    }

    /**
     * @description entity方式调用指定请求头，可以加额外的信息，比如token
     * @author wanghongwei
     * @date 2023/2/3 14:52
     * @return java.lang.String
     **/
    @GetMapping("post/postForEntityJson2")
    public String postForEntityJson2(){
        JSONObject object = new JSONObject();
        object.put("name","postForObjectJson2");
        object.put("address","address22");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(object,headers);
        ResponseEntity<JSONObject> jsonObject = restTemplate.postForEntity(postForObjectJsonUrl, entity, JSONObject.class);
        return jsonObject.getBody().toJSONString();
    }

    /**
     * @description entity方式调用携带map信息
     * @author wanghongwei
     * @date 2023/2/3 14:52
     * @return java.lang.String
     **/
    @GetMapping("post/postForEntityForm")
    public String postForEntityForm(){
        // 请求头设置,x-www-form-urlencoded格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //提交参数设置
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("name", "1111");
        map.add("address", "2222");
        // 组装请求体
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        ResponseEntity<JSONObject> result = restTemplate.postForEntity(postForObjectFormUrl, request, JSONObject.class);
        return  result.getBody().toJSONString();
    }

    /**
     * @description entity方式调用携带表单文件和其他信息
     * @author wanghongwei
     * @date 2023/2/3 14:52
     * @return java.lang.String
     **/
    @GetMapping("post/postForEntityFormFile")
    public String postForEntityFormFile(){
        // 请求头设置,x-www-form-urlencoded格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //提交参数设置
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        File file = new File("D:\\idea_project\\sport.sql");
        map.add("file", new FileSystemResource(file));
        map.add("name", "123");
        // 组装请求体
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        ResponseEntity<JSONObject> result = restTemplate.postForEntity(postForObjectFormFileUrl, request, JSONObject.class);
        return  result.getBody().toJSONString();
    }

    /**
     * @description location调用
     * @author wanghongwei
     * @date 2023/2/3 14:52
     * @return java.lang.String
     **/
    @GetMapping("post/postForLocation")
    public String postForLocation(){
        JSONObject object = new JSONObject();
        object.put("name","1111");
        object.put("address","address22");
        URI uri = restTemplate.postForLocation(postForObjectJsonUrl, object);
        return JSONObject.toJSONString(uri);
    }
}
