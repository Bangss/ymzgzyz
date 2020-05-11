package com.lingnan.ymzgzyz.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.mapper.AdminMapper;
import com.lingnan.ymzgzyz.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getByName ( String name ) {
        return adminMapper.getByName(name);
    }

    @Override
    public List<Admin> getByRole ( Integer role ) {
        return adminMapper.getByRole(role);
    }

}

