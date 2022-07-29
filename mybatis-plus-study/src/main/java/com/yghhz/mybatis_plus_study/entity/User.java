package com.yghhz.mybatis_plus_study.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wanghongwei
 * @Title:
 * @Description:
 * @date 2022/7/23 20:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;
    @Version
    private Integer version;
}
