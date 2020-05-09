package com.lingnan.ymzgzyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 推文信息表
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticleInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消息发布者身份,
0志愿者
,1儿童
,2管理员

     */
    private Integer userRole;

    /**
     * 消息发布者id

     */
    private Integer userId;

    /**
     * 0为志愿风采;
1为媒体报道
;
2为政策公布
;
3为志愿者活动

     */
    private Integer role;

    /**
     * 活动状态:

0为报名未开始
;
1为报名进行中
;
2为报名结束

     */
    private Integer states;

    /**
     * 推文发布时间
     */
    private LocalDateTime startTime;

    /**
     * 活动结束报名时间，管理员或活动发布者可编辑

     */
    private LocalDateTime endTime;

    /**
     * 推文图片

     */
    private String image;

    /**
     * 推文标题限制为20字

     */
    private String title;

    /**
     * 推文内容

     */
    private String content;

    /**
     * 软删状态位，1为被逻辑删除，0为未被软删除
     */
    private Integer flag;


}
