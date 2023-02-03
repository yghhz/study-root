package com.yghhz.resttemplate.study.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author wanghongwei
 * @Title:
 * @Description:
 * @date 2022/9/30 17:45
 */
@Component
@Slf4j
public class HttpUtils {

    @Autowired
    private RestTemplate restTemplate;

    private static HttpUtils httpUtil;

    @PostConstruct
    public void init(){
        httpUtil = this;
        httpUtil.restTemplate = this.restTemplate;
    }

    /**
     * 携带json请求体的请求
     * @return
     */
    public static String jsonRequest(String url, HttpMethod method, HttpHeaders headers, Map<String, Object> requestBody){
        try{
            if (headers == null){
                headers = new HttpHeaders();
            }
            headers.setContentType(MediaType.APPLICATION_JSON);
            // 封装请求头和请求体，注意json一定要转化未String,否则有可能出现调用失败问题
            HttpEntity entity = new HttpEntity<>(JSON.toJSONString(requestBody), headers);
            log.info(String.format("RPC远程调用-入参, url: %s, method: %s, entity: %s",url, method.name(), JSON.toJSONString(entity)));
            ResponseEntity<String> result = httpUtil.restTemplate.exchange(url, method, entity, String.class);
            log.info(String.format("RPC远程调用-出参, url: %s, method: %s, result: %s",url, method.name(),result.getBody()));
            return result.getBody();
        }catch (Exception e){
            log.error(String.format("RPC远程调用-异常, 异常信息: %s",e.getMessage()));
        }
        return StringUtils.EMPTY;
    }

    /**
     * 携带json数组的请求
     */
    public static <T> String jsonRequest(String url, HttpMethod method, HttpHeaders headers, List<T> list){
        try{
            if (headers == null){
                headers = new HttpHeaders();
            }
            headers.setContentType(MediaType.APPLICATION_JSON);
            // 封装请求头和请求体，注意json一定要转化未String,否则有可能出现调用失败问题
            HttpEntity entity = new HttpEntity<>(JSON.toJSONString(list), headers);
            log.info(String.format("RPC远程调用-入参, url: %s, method: %s, entity: %s",url, method.name(), JSON.toJSONString(entity)));
            ResponseEntity<String> result = httpUtil.restTemplate.exchange(url, method, entity, String.class);
            log.info(String.format("RPC远程调用-出参, url: %s, method: %s, result: %s",url, method.name(),result.getBody()));
            return result.getBody();
        }catch (Exception e){
            log.error(String.format("RPC远程调用-异常, 异常信息: %s",e.getMessage()));
        }
        return StringUtils.EMPTY;
    }

    /**
     * 携带form表单请求
     */
    public static String formRequest(String url,HttpMethod method, HttpHeaders headers, Map<String, Object> params){
        try{
            if (headers == null){
                headers = new HttpHeaders();
            }
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            // 封装请求头和请求体
            HttpEntity entity = new HttpEntity<>(null, headers);
            log.info(String.format("RPC远程调用-入参, url: %s, entity: %s, params: %s",url, JSON.toJSONString(entity), JSON.toJSONString(params)));
            ResponseEntity<String> result = httpUtil.restTemplate.exchange(url,method,entity,String.class,params);
            log.info(String.format("RPC远程调用-出参, url: %s, entity: %s, params: %s, result: %s",url, JSON.toJSONString(entity),JSON.toJSONString(params), result.getBody()));
            return result.getBody();
        }catch (Exception e){
            log.error(String.format("RPC远程调用-异常, 异常信息: %s",e.getMessage()));
        }
        return StringUtils.EMPTY;
    }

}
