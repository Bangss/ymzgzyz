package com.lingnan.ymzgzyz.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingnan.ymzgzyz.model.entity.Child;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from admin where name = ${name}")
    Admin getByName ( String name );

    @Select("select * from admin where role = ${role}")
    List<Admin> getByRole ( Integer role);
}

