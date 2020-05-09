package com.lingnan.ymzgzyz.controller.api;


import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.lingnan.ymzgzyz.service.IVolunteerService;
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
@RequestMapping("/ymzgzyz/volunteer")
public class VolunteerController {

    @Autowired
    IVolunteerService iVolunteerService;

    //查询全部，返回list
    @PostMapping("/list")
    public List<Volunteer> getVolunteerInfList () {
        List<Volunteer> list = new ArrayList<>();
        list = iVolunteerService.list();
        return list;
    }

    //根据id查询，返回Volunteer对象
    @PostMapping("/get-one")
    public Volunteer getVolunteerById ( @RequestBody Volunteer volunteer) {
        Integer id = volunteer.getId();
        return iVolunteerService.getById(id);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    public boolean updateVolunteer (@RequestBody Volunteer volunteer) {
        return iVolunteerService.updateById(volunteer);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    public boolean insertVolunteer (@RequestBody Volunteer volunteer) {
        return iVolunteerService.save(volunteer);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    public boolean deleteVolunteer ( @RequestBody Volunteer volunteer) {
        Integer id = volunteer.getId();
        return iVolunteerService.removeById(id);
    }
}
