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
 * @author PonKing
 * @since 2020-03-21
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

    //根据id更新，返回boolean值
    @PostMapping("/update")
    public boolean updateActiveSignById(@RequestBody ActiveSign activeSign) {
        return iActiveSignService.saveOrUpdate(activeSign);
    }

    //插入记录，返回boolean值
    @PostMapping("/insert")
    public boolean insertActiveSign(@RequestBody ActiveSign activeSign) {
        return iActiveSignService.save(activeSign);
    }
}
