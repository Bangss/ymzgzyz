package com.lingnan.ymzgzyz.service;

import com.lingnan.ymzgzyz.mapper.ChildMapper;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface IChildService extends IService<Child> {
    @Select("select * from child where name = ${name}")
    Child getByName (String name);
}
