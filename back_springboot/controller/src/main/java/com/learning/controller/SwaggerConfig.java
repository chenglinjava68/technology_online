package com.learning.controller;

import com.google.common.base.Predicates;
import com.sun.xml.internal.ws.api.pipe.helper.AbstractPipeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
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
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any())// 对所有api进行监控
                //不显示错误和测试的接口地址
                .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/test/showAll.*")))//测试路径不监控
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "技术支撑平台RESTful APIs实例文档",
                "我的博客网站：http://www.nothingistrue.top，欢迎大家访问。",
                "API V1.0",
                "NO terms of service",
                new Contact("JayWatson", "https://github.com/WatsonJay", "446725026@qq.com"),
                "Apache", "http://www.apaJayWatsonche.org/", Collections.emptyList());
    }
}