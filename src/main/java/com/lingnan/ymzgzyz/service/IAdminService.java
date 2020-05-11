package com.lingnan.ymzgzyz.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface IAdminService extends IService<Admin> {
    @Select("select * from admin where name = ${name}")
    Admin getByName (String name);

    @Select("select * from admin where role = ${role}")
    List<Admin> getByRole ( Integer role);

}

