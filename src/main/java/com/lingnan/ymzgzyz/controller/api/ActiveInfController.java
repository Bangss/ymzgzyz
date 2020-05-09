package com.lingnan.ymzgzyz.controller.api;


import com.lingnan.ymzgzyz.model.entity.ActiveInf;
import com.lingnan.ymzgzyz.service.IActiveInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 活动信息 前端控制器
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/ymzgzyz/active-inf")
public class ActiveInfController {
    @Autowired
    IActiveInfService iActiveInfService;

    @PostMapping("/test")
    public String test(){
        return "test";
    }

    //    返回全部活动详细信息
    @PostMapping("/list")
    public List<ActiveInf> getActiveInfList(){
        List<ActiveInf> list = new ArrayList<>();
        list = iActiveInfService.list();
        return list;
    }

    //    根据id查询，返回ActiveInf对象
    @PostMapping("/get-one")
    public ActiveInf getActiveInfById( @RequestBody ActiveInf activeInf )
    {
        Integer id = activeInf.getId();
        return iActiveInfService.getById(id);
    }

    //    根据id更新,返回boolean值
    @PostMapping("/update")
    public boolean updateActiveInfById(@RequestBody ActiveInf activeInf)
    {
        return iActiveInfService.saveOrUpdate(activeInf);
    }

    //    插入记录
    @PostMapping("/insert")
    public boolean insertActiveInf(@RequestBody ActiveInf activeInf)
    {
        return iActiveInfService.save(activeInf);
    }

    //    删除记录
    @PostMapping("/delete")
    public boolean deleteActiveInf(@RequestBody ActiveInf activeInf)
    {
        Integer id = activeInf.getId();
        return iActiveInfService.removeById(id);
    }
}
