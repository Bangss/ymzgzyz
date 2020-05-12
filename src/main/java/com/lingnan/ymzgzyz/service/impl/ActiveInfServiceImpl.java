package com.lingnan.ymzgzyz.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingnan.ymzgzyz.model.entity.ActiveInf;
import com.lingnan.ymzgzyz.mapper.ActiveInfMapper;
import com.lingnan.ymzgzyz.service.IActiveInfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 活动信息 服务实现类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@Service
public class ActiveInfServiceImpl extends ServiceImpl<ActiveInfMapper, ActiveInf> implements IActiveInfService {

    @Override
    public List<ActiveInf> getByUserRole ( Integer userRole ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getUserRole,userRole));
    }

    @Override
    public List<ActiveInf> getByUserId ( Integer userId ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getUserRole,userId));
    }

    @Override
    public List<ActiveInf> getByCompany ( String company ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getCompany,company));
    }

    @Override
    public List<ActiveInf> getByBoss ( String boss ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getBoss,boss));
    }

    @Override
    public List<ActiveInf> getByStates ( Integer states ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getStates,states));
    }

    @Override
    public List<ActiveInf> getByAttendTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getAttendTime,date));
    }

    @Override
    public List<ActiveInf> getByBeforeAttendTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().gt(ActiveInf::getAttendTime,date));
    }

    @Override
    public List<ActiveInf> getByAfterAttendTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().lt(ActiveInf::getAttendTime,date));
    }

    @Override
    public List<ActiveInf> getByCloseTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getCloseTime,date));
    }

    @Override
    public List<ActiveInf> getByBeforeCloseTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().gt(ActiveInf::getCloseTime,date));
    }

    @Override
    public List<ActiveInf> getByAfterCloseTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().lt(ActiveInf::getCloseTime,date));
    }

    @Override
    public List<ActiveInf> getByStartTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getStartTime,date));
    }

    @Override
    public List<ActiveInf> getByBeforeStartTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().gt(ActiveInf::getStartTime,date));
    }

    @Override
    public List<ActiveInf> getByAfterStarTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().lt(ActiveInf::getStartTime,date));
    }

    @Override
    public List<ActiveInf> getByEndTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getEndTime,date));
    }

    @Override
    public List<ActiveInf> getByBeforeEndTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().gt(ActiveInf::getEndTime,date));
    }

    @Override
    public List<ActiveInf> getByAfterEndTime ( Date date ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().lt(ActiveInf::getEndTime,date));
    }

    @Override
    public List<ActiveInf> getByTitle ( String title ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().like(ActiveInf::getTitle,title));
    }

    @Override
    public List<ActiveInf> getByContent ( String content ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().like(ActiveInf::getContent,content));
    }

    @Override
    public List<ActiveInf> getByPN ( Integer pn ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().eq(ActiveInf::getPeopleNum,pn));
    }

    @Override
    public List<ActiveInf> getByGreaterThanPN ( Integer num ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().gt(ActiveInf::getPeopleNum,num));
    }

    @Override
    public List<ActiveInf> getByLessThanPN ( Integer num ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().lt(ActiveInf::getPeopleNum,num));
    }

    @Override
    public List<ActiveInf> getByExtent ( Integer num1, Integer num2 ) {
        return baseMapper.selectList(Wrappers.<ActiveInf>lambdaQuery().between(ActiveInf::getPeopleNum,num1,num2));
    }

}
