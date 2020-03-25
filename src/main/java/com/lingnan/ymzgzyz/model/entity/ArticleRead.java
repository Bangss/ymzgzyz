package com.lingnan.ymzgzyz.model.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 推文查阅
 * </p>
 *
 * @author PonKing
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticleRead implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 推文id
     */
    private Integer articleId;

    /**
     * 查阅者id
     */
    private Integer userId;

    /**
     * 查阅者身份
     * 0志愿者
     * 1儿童
     * 2管理员
     */
    private Integer userRole;

    /**
     * 查阅时间
     */
    private LocalDateTime readTime;


}
