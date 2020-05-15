package com.lingnan.ymzgzyz.controller.api;



import com.lingnan.ymzgzyz.annotation.LoginToken;
import com.lingnan.ymzgzyz.model.R;
import com.lingnan.ymzgzyz.model.entity.ActiveSign;
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
    @LoginToken
    public List<Child> getChildInfList () {
        List<Child> list = new ArrayList<>();
        list = iChildService.list();
        return list;
    }

    //根据id查询，返回Child对象
    @PostMapping("/getOneById")
    @LoginToken
    public Child getChildById ( @RequestBody Child child) {
        Integer id = child.getId();
        return iChildService.getById(id);
    }

    //更新，返回boolean值
    @PostMapping("/update")
    @LoginToken
    public boolean updateChild (@RequestBody Child child) {
        return iChildService.updateById(child);
    }

    //插入，返回boolean值
    @PostMapping("/insert")
    @LoginToken
    public boolean insertChild (@RequestBody Child child) {
        return iChildService.save(child);
    }

    //删除，返回boolean值（逻辑删除，修改flag值）
    @PostMapping("/delete")
    @LoginToken
    public boolean deleteChild ( @RequestBody Child child) {
        Integer id = child.getId();
        return iChildService.removeById(id);
    }

    /**
     * 其他条件查询
     */

    //level
    @PostMapping("getByLevel")
    @LoginToken
    public List<Child> getByLevel (@RequestBody Child child) {
        return iChildService.getByLevel(child.getLevel());
    }

    //born
    @PostMapping("getByBorn")
    @LoginToken
    public List<Child> getByBorn (String born) {
        return iChildService.getByBorn(born);
    }

    //place 模糊查询
    @PostMapping("/getByPlace")
    @LoginToken
    public List<Child> getByPlace (@RequestBody Child child) {
        return iChildService.getByPlace(child.getPlace());
    }

    //address 模糊查询
    @PostMapping("/getByAddress")
    @LoginToken
    public List<Child> getByAddress (@RequestBody Child child) {
        return iChildService.getByAddress(child.getAddress());
    }

    //批量删除
    @PostMapping("/listDelete")
    @LoginToken
    public R listDelete (@RequestBody List<Integer> idList ) {
        if (iChildService.removeByIds(idList)) {
            return R.success(true);
        }
        return R.failed();
    }

    //批量插入
    @PostMapping("/listInsert")
    @LoginToken
    public R listInsert (@RequestBody List<Child> list ) {
        if (iChildService.saveBatch(list)) {
            return R.success(true);
        }
        return R.failed();
    }

}
