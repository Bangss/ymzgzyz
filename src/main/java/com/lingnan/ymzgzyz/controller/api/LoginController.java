package com.lingnan.ymzgzyz.controller.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.lingnan.ymzgzyz.service.IAdminService;
import com.lingnan.ymzgzyz.service.IChildService;
import com.lingnan.ymzgzyz.service.IVolunteerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ymzgzyz/login")
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
    @PostMapping("/child")
    public R childLogin( @RequestParam String id , @RequestParam String  name , @RequestParam String password) {
        Child childById = iChildService.getById(id);
        if (childById != null) {
//            System.out.println("childById: " + childById);
            if (childById.getPassword().equals(password)) {
                return R.success(childById);
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
                    return R.success(childByName);
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
    public R volunteerLogin( @RequestParam String id , @RequestParam String name , @RequestParam String password) {
        Volunteer volById = iVolunteerService.getById(id);
        if (volById != null) {
            if (volById.getPassword().equals(password)) {
                return R.success(volById);
            }
            else {
                return R.message("密码错误");
            }
        }
        else {
            Volunteer volByName = iVolunteerService.getByName(name);
            if (volByName != null) {
                if (volByName.getPassword().equals(password)) {
                    return R.success(volByName);
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
    public R adminLogin( @RequestParam String id , @RequestParam String name , @RequestParam String password) {
        Admin adminById  = iAdminService.getById(id);
        if (adminById != null) {
            if (adminById.getPassword().equals(password)) {
                return R.success(adminById);
            }
            else {
                return R.message("密码错误");
            }
        }
        else {
            Admin adminByName = iAdminService.getByName(name);
            if (adminByName != null) {
                if (adminByName.getPassword().equals(password)) {
                    return R.success(adminByName);
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
