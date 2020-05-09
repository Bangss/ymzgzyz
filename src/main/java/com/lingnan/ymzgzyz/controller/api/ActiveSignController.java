package com.lingnan.ymzgzyz.controller.api;


import com.lingnan.ymzgzyz.model.entity.ActiveSign;
import com.lingnan.ymzgzyz.service.IActiveSignService;
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
@RequestMapping("/ymzgzyz/active-sign")
public class ActiveSignController {
    @Autowired
    IActiveSignService iActiveSignService;

    //查询全部，返回list
    @PostMapping("/list")
    public List<ActiveSign> getActiveSignList () {
        List<ActiveSign> list = new ArrayList<>();
        list = iActiveSignService.list();
        return list;
    }

    //根据id查询，返回ActiveSign对象
    @PostMapping("/get-one")
    public ActiveSign getActiveSignById( @RequestBody ActiveSign activeSign ) {
        Integer id = activeSign.getId();
        return iActiveSignService.getById(id);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    public boolean updateActiveSignById(@RequestBody ActiveSign activeSign) {
        return iActiveSignService.saveOrUpdate(activeSign);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    public boolean insertActiveSign(@RequestBody ActiveSign activeSign) {
        return iActiveSignService.save(activeSign);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    public boolean deleteActiveSign(@RequestBody ActiveSign activeSign) {
        Integer id = activeSign.getId();
        return iActiveSignService.removeById(id);
    }
}
