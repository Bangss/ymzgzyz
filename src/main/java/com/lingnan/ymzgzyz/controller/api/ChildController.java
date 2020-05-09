package com.lingnan.ymzgzyz.controller.api;


import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.service.IChildService;
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
@RequestMapping("/ymzgzyz/child")
public class ChildController {

    @Autowired
    IChildService iChildService;

    //查询全部，返回list
    @PostMapping("/list")
    public List<Child> getChildInfList () {
        List<Child> list = new ArrayList<>();
        list = iChildService.list();
        return list;
    }

    //根据id查询，返回Child对象
    @PostMapping("/get-one")
    public Child getChildById ( @RequestBody Child child) {
        Integer id = child.getId();
        return iChildService.getById(id);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    public boolean updateChild (@RequestBody Child child) {
        return iChildService.updateById(child);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    public boolean insertChild (@RequestBody Child child) {
        return iChildService.save(child);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    public boolean deleteChild ( @RequestBody Child child) {
        Integer id = child.getId();
        return iChildService.removeById(id);
    }
}
