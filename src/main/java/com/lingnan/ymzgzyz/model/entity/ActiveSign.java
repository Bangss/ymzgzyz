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
 * 活动报名
 * </p>
 *
 * @author PonKing
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ActiveSign implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动编号
     */
    private Integer activeId;

    /**
     * 志愿者编号
     */
    private Integer vId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机(联系方式)
     */
    private String mobile;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 邮件
     */
    private String email;

    /**
     * 报名时间
     */
    private LocalDate time;


}
