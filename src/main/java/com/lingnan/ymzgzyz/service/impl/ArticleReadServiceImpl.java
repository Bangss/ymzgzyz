package com.lingnan.ymzgzyz.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lingnan.ymzgzyz.model.entity.ArticleRead;
import com.lingnan.ymzgzyz.mapper.ArticleReadMapper;
import com.lingnan.ymzgzyz.service.IArticleReadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ArticleReadServiceImpl extends ServiceImpl<ArticleReadMapper, ArticleRead> implements IArticleReadService {

    @Override
    public List<ArticleRead> getByArticleId ( Integer articleId ) {
        return baseMapper.selectList(Wrappers.<ArticleRead>lambdaQuery().eq(ArticleRead::getArticleId,articleId));
    }

    @Override
    public List<ArticleRead> getByUserId ( Integer userId ) {
        return baseMapper.selectList(Wrappers.<ArticleRead>lambdaQuery().eq(ArticleRead::getUserId,userId));
    }

    @Override
    public List<ArticleRead> getByUserRole ( Integer userRole ) {
        return baseMapper.selectList(Wrappers.<ArticleRead>lambdaQuery().eq(ArticleRead::getUserRole,userRole));
    }

    @Override
    public List<ArticleRead> getByReadTime ( String time ) {
        return baseMapper.selectList(Wrappers.<ArticleRead>lambdaQuery().like(ArticleRead::getReadTime,time));
    }
}
