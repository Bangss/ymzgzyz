//package com.lingnan.ymzgzyz.config;
//
//import com.lingnan.ymzgzyz.interceptor.MyInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class LoginConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors ( InterceptorRegistry registry ) {
//        List<String> list = new ArrayList<>();
//        list.add("/ymzgzyz/login/**");
//        list.add("/**/*.*");
//        //注册拦截器
//        InterceptorRegistration registration = registry.addInterceptor(new MyInterceptor());
//        registration.addPathPatterns("/**");
//        registration.excludePathPatterns(list);
//    }
//}
