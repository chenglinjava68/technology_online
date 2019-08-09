package com.learning.techonlineswagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Bean(value = "defaultApi")
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select() // 选择那些路径和api会生成document
                // 对指定api进行监控
                .apis(RequestHandlerSelectors.basePackage("com.learning.techonlineauthority.controller"))
                //不显示错误和测试的接口地址
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .groupName("通用权限框架接口");
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "技术支撑平台基础权限RESTful APIs实例文档",
                "我的博客网站：http://www.nothingistrue.top，欢迎大家访问。",
                "API V1.0",
                " 127.0.0.1:13520",
                new Contact("JayWatson", "https://github.com/WatsonJay", "446725026@qq.com"),
                "Apache", "http://www.apaJayWatsonche.org/", Collections.emptyList());
    }
}
