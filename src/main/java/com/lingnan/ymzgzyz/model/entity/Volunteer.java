package com.lingnan.ymzgzyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 志愿者
 * </p>
 *
 * @author PonKing
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Volunteer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 志愿者编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 电话号码
     */
    private String mobile;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 在读大学
     */
    private String school;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 籍贯
     */
    private String place;

    /**
     * 出生日期
     */
    private LocalDate born;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastTime;

    /**
     * 志愿者证
     */
    private String card;

    /**
     * 归属组织
     */
    private String organization;

    /**
     * 志愿者发布推文权限:
     * <p>
     * 0没有权限
     * ;
     * 1有权限
     */
    private Integer publishPower;

    /**
     * 志愿者发布教学资源权限
     * :
     * 0没有权限;
     * <p>
     * 1有权限
     */
    private Integer viewPower;


}
