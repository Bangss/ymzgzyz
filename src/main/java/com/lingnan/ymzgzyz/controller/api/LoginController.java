package com.lingnan.ymzgzyz.controller.api;

import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.lingnan.ymzgzyz.service.IAdminService;
import com.lingnan.ymzgzyz.service.IChildService;
import com.lingnan.ymzgzyz.service.IVolunteerService;
import com.lingnan.ymzgzyz.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 * @author Bangss
 * @since 2020-5-15
 */

@RestController
@RequestMapping("/ymzgzyz/login")
public class LoginController {

    @Autowired
    private IChildService iChildService;
    @Autowired
    private IVolunteerService iVolunteerService;
    @Autowired
    private IAdminService iAdminService;
    @Autowired
    private TokenService tokenService;
    /**
     * 先用着这个简单的登录
     */

    /**
     * 加了token验证
     */

    //child
    @PostMapping("/child")
    public R childLogin( @RequestParam Integer id , @RequestParam String name , @RequestParam String password , HttpServletResponse response ) {
        Map<String,Object> map = new HashMap<>();
        Child childById = iChildService.getById(id);
        if (childById != null) {
//            System.out.println("childById: " + childById);
            if (childById.getPassword().equals(password)) {
                String token = tokenService.getChildToken(childById);
                Cookie cookie = new Cookie("token",token);
                cookie.setPath("/");
                response.addCookie(cookie);
                map.put("token" , token);
                map.put("child" , childById);
                return R.success(map);
            }
            else {
                return R.message("密码错误");
            }
        }
        else {
            Child childByName = iChildService.getByName(name);
//            System.out.println("childById: " + childByName);
            if (childByName != null) {
                if (childByName.getPassword().equals(password)) {
                    String token = tokenService.getChildToken(childByName);
                    Cookie cookie = new Cookie("token",token);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    map.put("token" , token);
                    map.put("child" , childByName);
                    return R.success(map);
                } else {
                    return R.message("密码错误");
                }
            }
            else {
                return R.message("不存在该用户");
            }
        }
    }

    //volunteer
    @PostMapping("/volunteer")
    public R volunteerLogin( @RequestParam String id , @RequestParam String name , @RequestParam String password , HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        Volunteer volById = iVolunteerService.getById(id);
        if (volById != null) {
            if (volById.getPassword().equals(password)) {
                String token = tokenService.getVolunteerToken(volById);
                Cookie cookie = new Cookie("token",token);
                cookie.setPath("/");
                response.addCookie(cookie);
                map.put("token" , token);
                map.put("child" , volById);
                return R.success(map);
            }
            else {
                return R.message("密码错误");
            }
        }
        else {
            Volunteer volByName = iVolunteerService.getByName(name);
            if (volByName != null) {
                if (volByName.getPassword().equals(password)) {
                    String token = tokenService.getVolunteerToken(volByName);
                    Cookie cookie = new Cookie("token",token);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    map.put("token" , token);
                    map.put("child" , volByName);
                    return R.success(map);
                } else {
                    return R.message("密码错误");
                }
            }
            else {
                return R.message("不存在该用户");
            }
        }
    }

    //admin
    @PostMapping("/admin")
    public R adminLogin( @RequestParam String id , @RequestParam String name , @RequestParam String password , HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        Admin adminById  = iAdminService.getById(id);
        if (adminById != null) {
            if (adminById.getPassword().equals(password)) {
                String token = tokenService.getAdminToken(adminById);
                Cookie cookie = new Cookie("token",token);
                cookie.setPath("/");
                response.addCookie(cookie);
                map.put("token" , token);
                map.put("child" , adminById);
                return R.success(map);
            }
            else {
                return R.message("密码错误");
            }
        }
        else {
            Admin adminByName = iAdminService.getByName(name);
            if (adminByName != null) {
                if (adminByName.getPassword().equals(password)) {
                    String token = tokenService.getAdminToken(adminByName);
                    Cookie cookie = new Cookie("token",token);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    map.put("token" , token);
                    map.put("child" , adminByName);
                    return R.success(map);
                } else {
                    return R.message("密码错误");
                }
            }
            else {
                return R.message("不存在该用户");
            }
        }
    }

}
