package com.lingnan.ymzgzyz.controller;

import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.form.LoginForm;
import com.lingnan.ymzgzyz.shiro.LoginToken;
import com.lingnan.ymzgzyz.shiro.LoginType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;



/**
 * @author Ponking
 * @ClassName LoginController
 * @date 2020/3/28--20:00
 **/
@RestController
@RequestMapping
public class LoginController {

    @PostMapping("/student/login")
    public R studentLogin(@RequestBody LoginForm form){
        LoginToken token =
                new LoginToken(form.getUsername(),form.getPassword(), LoginType.getChild());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return R.message("登录成功");
    }

    @PostMapping("/volunteer/login")
    public R volunteerLogin(@RequestBody LoginForm form){
        LoginToken token =
                new LoginToken(form.getUsername(),form.getPassword(), LoginType.getVolunteer());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return R.message("登录成功");
    }

    @GetMapping("/test")
    public R test(){
        return R.success("test");
    }
}
