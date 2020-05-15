package com.lingnan.ymzgzyz.config;

import com.lingnan.ymzgzyz.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors ( InterceptorRegistry registry ) {
        List<String> list = new ArrayList<>();
//        list.add("/ymzgzyz/login/**");
        list.add("/**/*.*");
        //拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(myInterceptor()).excludePathPatterns(list);
    }

    @Bean
    public MyInterceptor  myInterceptor() {
        return new MyInterceptor();
    }
}
