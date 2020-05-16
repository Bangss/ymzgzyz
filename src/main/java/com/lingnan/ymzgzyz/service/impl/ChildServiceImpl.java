package com.lingnan.ymzgzyz.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.mapper.ChildMapper;
import com.lingnan.ymzgzyz.service.IChildService;
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
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements IChildService {

    @Autowired
    private ChildMapper childMapper;
    @Override
    public Child getByName ( String name ) {
        return baseMapper.selectOne(Wrappers.<Child>lambdaQuery().eq(Child::getName,name));
    }

    @Override
    public List<Child> getByLevel ( String level)  {
         return baseMapper.selectList(Wrappers.<Child>lambdaQuery().eq(Child::getLevel,level));
    }

    @Override
    public List<Child> getByBorn ( String born ) {
        return baseMapper.selectList(Wrappers.<Child>lambdaQuery().like(Child::getBorn,born));
    }

    @Override
    public List<Child> getByPlace ( String place ) {
        return baseMapper.selectList(Wrappers.<Child>lambdaQuery().like(Child::getPlace,place));
    }

    @Override
    public List<Child> getByAddress ( String address ) {
        return baseMapper.selectList(Wrappers.<Child>lambdaQuery().like(Child::getAddress,address));
    }

    @Override
    public Child getByEmail ( String email ) {
        return baseMapper.selectOne(Wrappers.<Child>lambdaQuery().eq(Child::getEmail,email));
    }

    @Override
    public Child getByMobile ( String mobile ) {
        return baseMapper.selectOne(Wrappers.<Child>lambdaQuery().eq(Child::getMobile,mobile));
    }

    @Override
    public boolean updatePassword ( Integer id , String password ) {
        return childMapper.updatePassword(id , password);
    }
}
