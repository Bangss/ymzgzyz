package com.lingnan.ymzgzyz.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingnan.ymzgzyz.model.entity.ActiveSign;
import com.lingnan.ymzgzyz.mapper.ActiveSignMapper;
import com.lingnan.ymzgzyz.service.IActiveSignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.sql.Time;
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
public class ActiveSignServiceImpl extends ServiceImpl<ActiveSignMapper, ActiveSign> implements IActiveSignService {

    @Override
    public List<ActiveSign> getByActiveId ( Integer activeId ) {
        return baseMapper.selectList(Wrappers.<ActiveSign>lambdaQuery().eq(ActiveSign::getActiveId,activeId));
    }

    @Override
    public List<ActiveSign> getByVId ( Integer vId ) {
        return baseMapper.selectList(Wrappers.<ActiveSign>lambdaQuery().eq(ActiveSign::getVId,vId));
    }

    @Override
    public List<ActiveSign> getByTime ( String time ) {
        return baseMapper.selectList(Wrappers.<ActiveSign>lambdaQuery().like(ActiveSign::getTime,time));

    }
}
