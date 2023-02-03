package com.yghhz.swagger.study.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wanghongwei
 * @Title:
 * @Description: 用户
 * @date 2022/9/27 10:56
 */
@Data
@ApiModel(value = "用户实体类")
public class User {
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "地址")
    private String address;
}
