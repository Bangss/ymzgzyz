package com.lingnan.ymzgzyz.mapper;

import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface VolunteerMapper extends BaseMapper<Volunteer> {
    @Select("select * from volunteer where name = ${name}")
    Volunteer getByName(String name);
}
