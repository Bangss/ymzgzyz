package com.lingnan.ymzgzyz.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.lingnan.ymzgzyz.mapper.VolunteerMapper;
import com.lingnan.ymzgzyz.service.IVolunteerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, Volunteer> implements IVolunteerService {



    @Override
    public Volunteer getByName ( String name ) {
        return baseMapper.selectOne(Wrappers.<Volunteer>lambdaQuery().eq(Volunteer::getName,name));
    }

    @Override
    public List<Volunteer> getByBorn ( String born ) {
        return baseMapper.selectList(Wrappers.<Volunteer>lambdaQuery().like(Volunteer::getBorn,born));
    }

    @Override
    public Volunteer getByCard ( String card ) {
        return baseMapper.selectOne(Wrappers.<Volunteer>lambdaQuery().eq(Volunteer::getAvatar,card));
    }

    @Override
    public List<Volunteer> getBySchool ( String school ) {
        return baseMapper.selectList(Wrappers.<Volunteer>lambdaQuery().like(Volunteer::getSchool,school));
    }

    @Override
    public List<Volunteer> getByAddress ( String address ) {
        return baseMapper.selectList(Wrappers.<Volunteer>lambdaQuery().like(Volunteer::getAddress,address));
    }

    @Override
    public List<Volunteer> getByPlace ( String place ) {
        return baseMapper.selectList(Wrappers.<Volunteer>lambdaQuery().like(Volunteer::getPlace,place));
    }

    @Override
    public List<Volunteer> getByOrg ( String org ) {
        return baseMapper.selectList(Wrappers.<Volunteer>lambdaQuery().like(Volunteer::getOrganization,org));
    }

    @Override
    public List<Volunteer> getByPP ( Integer pp ) {
        return baseMapper.selectList(Wrappers.<Volunteer>lambdaQuery().eq(Volunteer::getPublishPower,pp));
    }

    @Override
    public List<Volunteer> getByVP ( Integer vp ) {
        return baseMapper.selectList(Wrappers.<Volunteer>lambdaQuery().eq(Volunteer::getViewPower,vp));
    }
}
