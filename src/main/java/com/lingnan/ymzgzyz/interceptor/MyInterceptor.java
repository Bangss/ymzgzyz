//package com.lingnan.ymzgzyz.interceptor;
//
//import com.lingnan.ymzgzyz.model.entity.Child;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author Bangss
// * @since 2020-5-11
// * 拦截器
// */
//
//public class MyInterceptor implements HandlerInterceptor {
//
//    /**
//     * 在请求处理之前调用（controller方法调用之前）
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     * @throws Exception
//     */
//
//    @Override
//    public boolean preHandle ( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
//            System.out.println("执行了preHandle");
//            String name =  (String) request.getSession().getAttribute("name");
//            String id =  (String) request.getSession().getAttribute("id");
//            String password = (String) request.getSession().getAttribute("password");
//            if (password != null) {
//                return name != null || id != null;
//            }
//            else {
//                return false;
//            }
//    }
//
//    /**
//     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
//     * @param request
//     * @param response
//     * @param handler
//     * @param modelAndView
//     * @throws Exception
//     */
//    @Override
//    public void postHandle ( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception {
//        System.out.println("执行了postHandle");
//
//    }
//
//    /**
//     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
//     * @param request
//     * @param response
//     * @param handler
//     * @param ex
//     * @throws Exception
//     */
//
//    @Override
//    public void afterCompletion ( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex ) throws Exception {
//        System.out.println("执行了afterCompletion");
//    }
//}
