package com.lingnan.ymzgzyz.service;

import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface IVolunteerService extends IService<Volunteer> {
    @Select("select * from volunteer where name = ${name}")
    Volunteer getByName(String name);
}
