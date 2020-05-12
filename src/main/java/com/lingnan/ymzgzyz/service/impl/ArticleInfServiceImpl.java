package com.lingnan.ymzgzyz.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingnan.ymzgzyz.model.entity.ArticleInf;
import com.lingnan.ymzgzyz.mapper.ArticleInfMapper;
import com.lingnan.ymzgzyz.service.IArticleInfService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 推文信息表 服务实现类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@Service
public class ArticleInfServiceImpl extends ServiceImpl<ArticleInfMapper, ArticleInf> implements IArticleInfService {

    @Autowired
    ArticleInfMapper articleInfMapper;

    @Override
    public List<ArticleInf> getByUserRole ( Integer userRole ) {
        return baseMapper.selectList(Wrappers.<ArticleInf>lambdaQuery().eq(ArticleInf::getUserRole,userRole));
    }

    @Override
    public List<ArticleInf> getByUserId ( Integer userId ) {
        return baseMapper.selectList(Wrappers.<ArticleInf>lambdaQuery().eq(ArticleInf::getUserId,userId));
    }

    @Override
    public List<ArticleInf> getByRole ( Integer role ) {
        return baseMapper.selectList(Wrappers.<ArticleInf>lambdaQuery().eq(ArticleInf::getRole,role));
    }

    @Override
    public List<ArticleInf> getByStates ( Integer states ) {
        return baseMapper.selectList(Wrappers.<ArticleInf>lambdaQuery().eq(ArticleInf::getStates,states));
    }

    @Override
    public List<ArticleInf> getByStartTime ( String time ) {
        return baseMapper.selectList(Wrappers.<ArticleInf>lambdaQuery().like(ArticleInf::getStartTime,time));
    }

    @Override
    public List<ArticleInf> getByTitle ( String str ) {
        return baseMapper.selectList(Wrappers.<ArticleInf>lambdaQuery().like(ArticleInf::getTitle,str));
    }

    @Override
    public List<ArticleInf> getByContent ( String str ) {
        return baseMapper.selectList(Wrappers.<ArticleInf>lambdaQuery().like(ArticleInf::getContent,str));
    }
}
