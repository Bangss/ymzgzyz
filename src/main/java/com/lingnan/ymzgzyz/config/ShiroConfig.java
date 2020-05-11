//package com.lingnan.ymzgzyz.config;
//
//import com.lingnan.ymzgzyz.shiro.ChildRealm;
//
//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @author Banagss
// * @since 2020-5-10
// * shiro配置类
// */
//
//@Configuration
//public class ShiroConfig {
//    @Bean
//    @ConditionalOnMissingBean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
//        return defaultAdvisorAutoProxyCreator;
//    }
//
//    //将自己的验证方式加入容器
//    @Bean
//    public ChildRealm childRealm () {
//        return new ChildRealm();
//    }
//
//    //权限管理，配置主要是Realm的管理认证
//    @Bean
//    public DefaultSecurityManager securityManager () {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(childRealm());
//        return securityManager;
//    }
//
//    //Filter工厂 ， 设置对应的过滤条件和跳转条件
////    @Bean
////    public ShiroFilterFactoryBean shiroFilterFactoryBean (DefaultSecurityManager securityManager) {
////        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
////        shiroFilterFactoryBean.setSecurityManager(securityManager);
////        Map<String, String> map = new LinkedHashMap<>();
////        //游客，不需要权限
////        map.put("/guest/**", "anon");
////        //登出
////        map.put("/logout","logout");
////        //对所有儿童用户认证
////        map.put("/child/**", "authc");
////        //对所有志愿者用户认证
////        map.put("/volunteer/**", "authc");
////        //对管理员认证
////        map.put("/admin/**", "authc");
////        //其余接口一律拦截
////        map.put("/**", "authc");
////        //登录
////        shiroFilterFactoryBean.setLoginUrl("/login");
////        //首页
////        shiroFilterFactoryBean.setSuccessUrl("/index");
////        //错误页面，认证不通过跳转
////        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
////        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
////        return shiroFilterFactoryBean;
////    }
//
//    //加入注解的使用，不加入这个注解不生效
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor (DefaultSecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//}
