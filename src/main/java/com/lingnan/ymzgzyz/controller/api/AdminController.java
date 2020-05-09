package com.lingnan.ymzgzyz.controller.api;


import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/ymzgzyz/admin")
public class AdminController {
    @Autowired
    IAdminService iAdminService;

    //查询全部，返回list
    @PostMapping("/list")
    public List<Admin> getAdminList() {
        List<Admin> list = new ArrayList<>();
        list = iAdminService.list();
        return list;
    }

    //根据id查询，返回Admin对象
    @PostMapping("/get-one")
    public Admin getAdminById( @RequestBody Admin admin ) {
        Integer id = admin.getId();
        return iAdminService.getById(id);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    public boolean updateAdmin (@RequestBody Admin admin) {
        return iAdminService.updateById(admin);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    public boolean insertAdmin (@RequestBody Admin admin) {
        return iAdminService.saveOrUpdate(admin);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    public boolean deleteAdmin (@RequestBody Admin admin) {
        Integer id = admin.getId();
        return iAdminService.removeById(id);
    }
}
