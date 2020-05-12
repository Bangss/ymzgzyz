package com.lingnan.ymzgzyz.service;

import com.lingnan.ymzgzyz.model.entity.ArticleInf;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 推文信息表 服务类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface IArticleInfService extends IService<ArticleInf> {

    List<ArticleInf> getByUserRole (Integer userRole);

    List<ArticleInf> getByUserId (Integer userId);

    List<ArticleInf> getByRole (Integer role);

    List<ArticleInf> getByStates (Integer states);

    List<ArticleInf> getByStartTime ( String time );

    List<ArticleInf> getByTitle (String str);

    List<ArticleInf> getByContent (String str);
}
