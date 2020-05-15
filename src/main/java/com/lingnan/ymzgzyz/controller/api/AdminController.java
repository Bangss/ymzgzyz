package com.lingnan.ymzgzyz.controller.api;


import com.lingnan.ymzgzyz.annotation.LoginToken;
import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.entity.ActiveSign;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @LoginToken
    public List<Admin> getAdminList() {
        List<Admin> list = new ArrayList<>();
        list = iAdminService.list();
        return list;
    }

    //根据id查询，返回Admin对象
    @PostMapping("/get-one-id")
    @LoginToken
    public Admin getAdminById( @RequestBody Admin admin ) {
        Integer id = admin.getId();
        return iAdminService.getById(id);
    }

    @PostMapping("/get-list-role")
    @LoginToken
    public List<Admin> getAdminByRole( @RequestParam Integer role ) {
        return iAdminService.getByRole(role);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    @LoginToken
    public boolean updateAdmin (@RequestBody Admin admin) {
        return iAdminService.updateById(admin);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    @LoginToken
    public boolean insertAdmin (@RequestBody Admin admin) {
        return iAdminService.saveOrUpdate(admin);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    @LoginToken
    public boolean deleteAdmin (@RequestBody Admin admin) {
        Integer id = admin.getId();
        return iAdminService.removeById(id);
    }

    //批量删除
    @PostMapping("/listDelete")
    @LoginToken
    public R listDelete (@RequestBody List<Integer> idList ) {
        if (iAdminService.removeByIds(idList)) {
            return R.success(true);
        }
        return R.failed();
    }

    //批量插入
    @PostMapping("/listInsert")
    @LoginToken
    public R listInsert (@RequestBody List<Admin> list ) {
        if (iAdminService.saveBatch(list)) {
            return R.success(true);
        }
        return R.failed();
    }
}
