package com.lingnan.ymzgzyz.service;

import com.lingnan.ymzgzyz.model.entity.ArticleRead;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface IArticleReadService extends IService<ArticleRead> {

    List<ArticleRead> getByArticleId ( Integer articleId);

    List<ArticleRead> getByUserId (Integer userId);

    List<ArticleRead> getByUserRole (Integer userRole);

    List<ArticleRead> getByReadTime (String time);
}
