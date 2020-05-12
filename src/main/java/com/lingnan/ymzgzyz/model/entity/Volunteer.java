package com.lingnan.ymzgzyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;
import java.sql.Time;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
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
     * 用户名
     */
    private String name;

    /**
     * 私盐
     */
    private String salt;

    /**
     * 密码
     */
    private String password;

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
    private Date born;

    /**
     * 注册时间

     */
    private Time createTime;

    /**
     * 上次登录时间
     */
    private Time lastTime;

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

0没有权限
;
1有权限

     */
    private Integer publishPower;

    /**
     * 志愿者发布教学资源权限
:
0没有权限;

1有权限

     */
    private Integer viewPower;

    /**
     * 软删状态位，1为被逻辑删除，0为未被软删除
     */
    private Integer flag;


}
