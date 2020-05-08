package com.lingnan.ymzgzyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 活动信息
 * </p>
 *
 * @author PonKing
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActiveInf implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 消息发布者身份,0志愿者,
     * 1儿童,
     * 2管理员
     */
    private Integer userRole;

    /**
     * 活动发布者id
     */
    private Integer userId;

    /**
     * 活动发布单位
     */
    private String company;

    /**
     * 活动发布单位
     */
    private String boss;

    /**
     * 负责人电话
     */
    private String mobile;

    /**
     * 负责人QQ
     */
    private Integer qq;

    /**
     * 负责人邮箱
     */
    private String email;

    /**
     * 负责人微信
     */
    private String wechat;

    /**
     * 活动状态
     * 0为报名未开始
     * 1为报名进行中
     * 2为报名结束
     */
    private Integer states;

    /**
     * 活动发布时间
     */
    private LocalDate attendTime;

    /**
     * 活动结束报名时间，管理员或活动发布者可编辑
     */
    private LocalDate closeTime;

    /**
     * 活动开始时间
     */
    private LocalDate startTime;

    /**
     * 活动结束时间
     */
    private LocalDate endTime;

    /**
     * 活动图片
     */
    private String image;

    /**
     * 活动标题限制为20字
     */
    private String title;

    /**
     * 活动内容
     */
    private String content;

    /**
     * 报名人数上限
     */
    private Integer peopleNum;


}
