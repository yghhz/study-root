package com.yghhz.resttemplate.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wanghongwei
 * @Title:
 * @Description: exchange相关操作
 * @date 2022/9/29 21:15
 */
@RestController
public class ExchangeController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("exchange/exchange")
    public String exchange(){

        return "";
    }
}
