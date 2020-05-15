package com.lingnan.ymzgzyz.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lingnan.ymzgzyz.annotation.LoginToken;
import com.lingnan.ymzgzyz.annotation.PassToken;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.lingnan.ymzgzyz.service.IAdminService;
import com.lingnan.ymzgzyz.service.IChildService;
import com.lingnan.ymzgzyz.service.IVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Bangss
 * @since 2020-5-11
 * 拦截器
 */

public class MyInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前调用（controller方法调用之前）
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Autowired
    private IAdminService iAdminService;
    @Autowired
    private IChildService iChildService;
    @Autowired
    private IVolunteerService iVolunteerService;

    @Override
    public boolean preHandle ( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        System.out.println("执行了preHandle");
        String token = request.getHeader("token"); //从http 请求头中取出token
        //如果不是映射方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有PassToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注释
        if (method.isAnnotationPresent(LoginToken.class)) {
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if (loginToken.required()) {
                //执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                //获取token中的role和id
                String key;
                Integer id;
                String role;
                System.out.println(JWT.decode(token).getAudience().get(0));
                try {
                    key = JWT.decode(token).getAudience().get(0);
                    //拆分字符串，获得角色和id
                    String[] str = key.split(":");
                    id = Integer.parseInt(str[1]);
                    role = str[0];
                }catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                System.out.println(id);
                String password;
                //判断角色，获得该id用户的密码
                if (role.equals("child"))
                {
                    Child child = iChildService.getById(id);
                    password = child.getPassword();
                }
                else if (role.equals("volunteer"))
                {
                    Volunteer volunteer = iVolunteerService.getById(id);
                    password = volunteer.getPassword();
                }
                else if (role.equals("admin"))
                {
                    Admin admin = iAdminService.getById(id);
                    password = admin.getPassword();
                }
                else {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
               //验证token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(password)).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle ( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception {
        System.out.println("执行了postHandle");

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */

    @Override
    public void afterCompletion ( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex ) throws Exception {
        System.out.println("执行了afterCompletion");
    }
}
