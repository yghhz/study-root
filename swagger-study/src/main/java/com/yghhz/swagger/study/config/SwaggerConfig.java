package com.yghhz.swagger.study.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wanghongwei
 * @Title:
 * @Description:
 * @date 2022/9/27 10:59
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {
    @Bean
    public Docket docket(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        boolean isEnable = environment.acceptsProfiles(profiles);
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)

                // 配置基本信息
                .apiInfo(apiInfo())
                .groupName("swagger")
                .enable(isEnable)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yghhz.swagger.study"))
                .paths(PathSelectors.any())
                .build();
    }

    // 基本信息设置
    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "yghhz", // 作者姓名
                "https://blog.csdn.net/weixin_44936331?type=blog", // 作者网址
                "793202503@qq.com"); // 作者邮箱
        return new ApiInfoBuilder()
                .title("学习swagger-接口文档") // 标题
                .description("描述") // 描述
                .termsOfServiceUrl("https://www.baidu.com") // 跳转连接
                .version("1.0") // 版本
                .license("Swagger-的使用")
                .licenseUrl("https://blog.csdn.net/weixin_44936331?type=blog")
                .contact(contact)
                .build();
    }

}
