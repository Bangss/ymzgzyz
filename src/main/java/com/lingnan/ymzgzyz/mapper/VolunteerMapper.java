package com.lingnan.ymzgzyz.mapper;

import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface VolunteerMapper extends BaseMapper<Volunteer> {
    @Update("update volunteer set password = ${password} where id = ${id}")
    boolean updatePassword ( Integer id , String password);
}
