package com.lingnan.ymzgzyz.controller.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.lingnan.ymzgzyz.service.IAdminService;
import com.lingnan.ymzgzyz.service.IChildService;
import com.lingnan.ymzgzyz.service.IVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ymzgzyz")
public class LoginController {

    @Autowired
    private IChildService iChildService;
    @Autowired
    private IVolunteerService iVolunteerService;
    @Autowired
    private IAdminService iAdminService;
    /**
     * 先用着这个简单的登录
     */

    //child
    //id登录
    @PostMapping("/child/loginById")
    public R childLoginById( @RequestParam String id , @RequestParam String password) {
        Child flag  = iChildService.getById(id);
        if (flag != null) {
            if (flag.getPassword().equals(password)) {
                return R.success(flag);
            }
            else {
                return R.failed();
            }
        }
        else
        {
            return R.failed();
        }
    }

    //用户名登录
    @PostMapping("/child/loginByName")
    public R childLoginByName( @RequestParam String name , @RequestParam String password) {
        Child flag  = iChildService.getByName(name);
        if (flag != null) {
            if (flag.getPassword().equals(password)) {
                return R.success(flag);
            }
            else {
                return R.failed();
            }
        }
        else
        {
            return R.failed();
        }
    }

    //volunteer
    @PostMapping("/volunteer/loginById")
    public R volunteerLoginById( @RequestParam String id , @RequestParam String password) {
        Volunteer flag  = iVolunteerService.getById(id);
        if (flag != null) {
            if (flag.getPassword().equals(password)) {
                return R.success(flag);
            }
            else {
                return R.failed();
            }
        }
        else
        {
            return R.failed();
        }
    }

    @PostMapping("/volunteer/loginByName")
    public R volunteerLoginByName( @RequestParam String name , @RequestParam String password) {
        Volunteer flag  = iVolunteerService.getByName(name);
        if (flag != null) {
            if (flag.getPassword().equals(password)) {
                return R.success(flag);
            }
            else {
                return R.failed();
            }
        }
        else
        {
            return R.failed();
        }
    }

    //admin
    @PostMapping("/admin/loginById")
    public R adminLoginById( @RequestParam String id , @RequestParam String password) {
        Admin flag  = iAdminService.getById(id);
        if (flag != null) {
            if (flag.getPassword().equals(password)) {
                return R.success(flag);
            }
            else {
                return R.failed();
            }
        }
        else
        {
            return R.failed();
        }
    }

    @PostMapping("/admin/loginByName")
    public R adminLoginByName( @RequestParam String name , @RequestParam String password) {
        Admin flag  = iAdminService.getByName(name);
        if (flag != null) {
            if (flag.getPassword().equals(password)) {
                return R.success(flag);
            }
            else {
                return R.failed();
            }
        }
        else
        {
            return R.failed();
        }
    }


}
