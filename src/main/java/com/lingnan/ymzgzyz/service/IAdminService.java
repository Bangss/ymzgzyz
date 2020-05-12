package com.lingnan.ymzgzyz.service;


import com.lingnan.ymzgzyz.model.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
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

    Admin getByName (String name);

    Admin getByMobile (String mobile);

    List<Admin> getByRole ( Integer role);

}

