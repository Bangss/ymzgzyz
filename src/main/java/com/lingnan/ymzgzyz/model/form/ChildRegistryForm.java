package com.lingnan.ymzgzyz.model.form;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Ponking
 * @ClassName ChildRegistryForm
 * @date 2020/3/28--21:30
 * @Des 儿童注册表单
 **/
@Data
public class ChildRegistryForm {
    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

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
