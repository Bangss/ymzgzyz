package com.lingnan.ymzgzyz.shiro;

import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;


import java.util.*;

/**
 * @author Ponking
 * @ClassName ShiroConfig
 * @date 2020/3/28--19:28
 **/
@Configuration
public class ShiroConfig {
    /**
     * 装配Realm
     *
     * @return
     */
    @Bean(name = "childRealm")
    public ChildRealm childRealm() {
        return new ChildRealm();
    }

    @Bean(name = "volunteerRealm")
    public VolunteerRealm volunteerRealm() {
        return new VolunteerRealm();
    }

    @Bean
    public Authenticator authenticator() {
        LoginModularRealmAuthenticator authenticator = new LoginModularRealmAuthenticator();
        // 单一认证策略
        authenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
        Map<String, Object> definedRealms = new HashMap<>();
        definedRealms.put("child", "childRealm");
        definedRealms.put("volunteer", "volunteerRealm");
        List<Realm> realms = new ArrayList<>();
        realms.add(childRealm());
        realms.add(volunteerRealm());
        authenticator.setRealms(realms);
        return authenticator;
    }

    /**
     * 配置安全管理器
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入自定义Realm
        List<Realm> realms = new ArrayList<>();
        realms.add(childRealm());
        realms.add(volunteerRealm());
        securityManager.setRealms(realms);
        securityManager.setAuthenticator(authenticator());
        return securityManager;
    }

    /**
     * 配置权限权限过滤器
     *
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        // 注入安全管理器
        filter.setSecurityManager(securityManager());
        // 未认证的跳转地址
        filter.setLoginUrl("**/login");
        Map<String, String> chain = new LinkedHashMap<>();
        // 登录链接不拦截
        chain.put("**/login", "anon");
        filter.setFilterChainDefinitionMap(chain);
        return filter;
    }

    /**
     * 启用Shiro内部Bean生命周期管理
     *
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启aop对shiro的bean的动态代理
     *
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        return creator;
    }

    /**
     * 启用Shiro注解
     *
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        // 注入安全管理器
        advisor.setSecurityManager(securityManager());
        return advisor;
    }


}
