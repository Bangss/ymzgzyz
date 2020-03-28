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
 * 儿童
 * </p>
 *
 * @author PonKing
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Child implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;


    /**
     * 私盐
     */
    private String salt;

    /**
     * 头像
     */
    private String image;

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
     * 学习阶段
     */
    private String level;

    /**
     * 注册时间(自动读取系统时间)
     */
    private LocalDateTime createTime;

    /**
     * 上次登录时间(自动读取系统时间)
     */
    private LocalDateTime lastTime;

    /**
     * 监护人电话,多个用，隔开
     */
    private String parentPhone;

    /**
     * 监护人姓名,多个用，隔开
     */
    private String parentName;

    /**
     * 监护人1姓名（必填）
     */
    private String parentName1;

    /**
     * 监护人1电话（必填）
     */
    private String parentTel1;

    /**
     * 监护人2姓名（非必填）
     */
    private String parentName2;

    /**
     * 监护人2电话（非必填）
     */
    private String parentTel2;


}
