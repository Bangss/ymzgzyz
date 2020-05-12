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

    /**
     * 其他条件查询
     */

    //born
    @PostMapping("/getByBorn")
    public List<Volunteer> getByBorn (String born) {
        return iVolunteerService.getByBorn(born);
    }

    //card
    @PostMapping("/getByCard")
    public Volunteer getVolByCard (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByCard(volunteer.getAvatar());
    }

    //school 模糊查询
    @PostMapping("/getBySchool")
    public List<Volunteer> getBySchool (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getBySchool(volunteer.getSchool());
    }

    //address 模糊查询
    @PostMapping("/getByAddress")
    public List<Volunteer> getByAddress (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByAddress(volunteer.getAddress());
    }

    //place 模糊查询
    @PostMapping("/getByPlace")
    public List<Volunteer> getByPlace (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByPlace(volunteer.getPlace());
    }

    //organization
    @PostMapping("/getByOrg")
    public List<Volunteer> getByOrg (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByOrg(volunteer.getOrganization());
    }

    //publish_power
    @PostMapping("/getByPP")
    public List<Volunteer> getByPP (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByPP(volunteer.getPublishPower());
    }

    //view_power
    @PostMapping("/getByVP")
    public List<Volunteer> getByVP (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByVP(volunteer.getViewPower());
    }
}
