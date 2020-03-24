package com.lingnan.ymzgzyz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author PonKing
 * @since 2020-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 0为超级管理员，1为普通管理员
     */
    private Integer role;

    /**
     * 管理员用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 管理员电话
     */
    private String mobile;

    /**
     * 头像
     */
    private String avatar;


}
