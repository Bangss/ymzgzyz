package com.lingnan.ymzgzyz.controller.api;


import com.lingnan.ymzgzyz.annotation.LoginToken;
import com.lingnan.ymzgzyz.annotation.PassToken;
import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.entity.Volunteer;

import com.lingnan.ymzgzyz.service.IVolunteerService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @LoginToken
    public List<Volunteer> getVolunteerInfList () {
        List<Volunteer> list = new ArrayList<>();
        list = iVolunteerService.list();
        return list;
    }

    //根据id查询，返回Volunteer对象
    @PostMapping("/get-one")
    @LoginToken
    public Volunteer getVolunteerById ( @RequestBody Volunteer volunteer) {
        Integer id = volunteer.getId();
        return iVolunteerService.getById(id);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    @LoginToken
    public boolean updateVolunteer (@RequestBody Volunteer volunteer) {
        return iVolunteerService.updateById(volunteer);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    @PassToken
    public boolean insertVolunteer (@RequestBody Volunteer volunteer) {
        return iVolunteerService.save(volunteer);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    @LoginToken
    public boolean deleteVolunteer ( @RequestBody Volunteer volunteer) {
        Integer id = volunteer.getId();
        return iVolunteerService.removeById(id);
    }

    /**
     * 其他条件查询
     */

    //born
    @PostMapping("/getByBorn")
    @LoginToken
    public List<Volunteer> getByBorn (String born) {
        return iVolunteerService.getByBorn(born);
    }

    //card
    @PostMapping("/getByCard")
    @LoginToken
    public Volunteer getVolByCard (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByCard(volunteer.getAvatar());
    }

    //school 模糊查询
    @PostMapping("/getBySchool")
    @LoginToken
    public List<Volunteer> getBySchool (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getBySchool(volunteer.getSchool());
    }

    //address 模糊查询
    @PostMapping("/getByAddress")
    @LoginToken
    public List<Volunteer> getByAddress (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByAddress(volunteer.getAddress());
    }

    //place 模糊查询
    @PostMapping("/getByPlace")
    @LoginToken
    public List<Volunteer> getByPlace (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByPlace(volunteer.getPlace());
    }

    //organization
    @PostMapping("/getByOrg")
    @LoginToken
    public List<Volunteer> getByOrg (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByOrg(volunteer.getOrganization());
    }

    //publish_power
    @PostMapping("/getByPP")
    @LoginToken
    public List<Volunteer> getByPP (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByPP(volunteer.getPublishPower());
    }

    //view_power
    @PostMapping("/getByVP")
    @LoginToken
    public List<Volunteer> getByVP (@RequestBody Volunteer volunteer) {
        return iVolunteerService.getByVP(volunteer.getViewPower());
    }

    //批量删除
    @PostMapping("/listDelete")
    @LoginToken
    public R listDelete (@RequestBody List<Integer> idList ) {
        if (iVolunteerService.removeByIds(idList)) {
            return R.success(true);
        }
        return R.failed();
    }

    //批量插入
    @PostMapping("/listInsert")
    @LoginToken
    public R listInsert (@RequestBody List<Volunteer> list ) {
        if (iVolunteerService.saveBatch(list)) {
            return R.success(true);
        }
        return R.failed();
    }

    //忘记密码 邮箱
    @PostMapping("/updatePassByEmail")
    @PassToken
    public R updatePasswordByEmail( @RequestParam String email , HttpSession session ) {
        Volunteer volunteer = iVolunteerService.getByEmail(email);
        if (volunteer == null) {
            return R.message("该邮箱的用户不存在");
        }
        else {
            session.setAttribute("id" , volunteer.getId());
            return R.success(volunteer);
        }
    }

    //忘记密码 手机
    @PostMapping("/updatePassByMobile")
    @PassToken
    public R updatePasswordByMobile(@RequestParam String mobile , HttpSession session) {
        Volunteer volunteer = iVolunteerService.getByMobile(mobile);
        if (volunteer == null) {
            return R.message("该邮箱的用户不存在");
        }
        else {
            session.setAttribute("id" , volunteer.getId());
            return R.success(volunteer);
        }
    }

    //修改密码
    @PostMapping("/updatePassword")
    @PassToken
    public R updatePassword(@RequestParam String password , @RequestParam String confirmPW , HttpSession session) {
        if (!password.equals(confirmPW)) {
            return R.message("两次密码不一致");
        }
        Integer id = (Integer) session.getAttribute("id");
        boolean flag = iVolunteerService.updatePassword( id , password );
        if (flag) {
            return R.success();
        }
        else {
            return R.failed();
        }
    }
}
