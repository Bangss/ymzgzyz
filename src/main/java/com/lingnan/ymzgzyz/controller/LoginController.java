package com.lingnan.ymzgzyz.controller;

import com.lingnan.ymzgzyz.pojo.Login;
import com.lingnan.ymzgzyz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/getAll")
    public String getAll()
    {
        List<Login> l = new ArrayList<Login>();
        l = loginService.getAll();
        for (Login x: l
             ) {
            System.out.println(x);
        }
        return loginService.toString();
    }

}
