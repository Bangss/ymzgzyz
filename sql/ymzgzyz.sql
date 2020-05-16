/*
Navicat MySQL Data Transfer

Source Server         : DESKTOP-RD3SK04_MYSQL
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : ymzgzyz

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-03-28 21:34:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for active_inf
-- ----------------------------
DROP TABLE IF EXISTS `active_inf`;
CREATE TABLE `active_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role` int(11) NOT NULL COMMENT '消息发布者身份,0志愿者,\n1儿童,\n2管理员',
  `user_id` int(11) NOT NULL COMMENT '活动发布者id',
  `company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动发布单位',
  `boss` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动发布单位',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '负责人电话\n',
  `qq` int(11) NOT NULL COMMENT '负责人QQ',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '负责人邮箱',
  `wechat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '负责人微信',
  `states` int(11) NOT NULL COMMENT '活动状态\n:0为报名未开始\n,1为报名进行中\n,2为报名结束',
  `attend_time` date NOT NULL COMMENT '活动发布时间',
  `close_time` date NOT NULL COMMENT '活动结束报名时间，管理员或活动发布者可编辑',
  `start_time` date NOT NULL COMMENT '活动开始时间',
  `end_time` date NOT NULL COMMENT '活动结束时间',
  `image` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '活动图片',
  `title` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动标题限制为20字\n',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '活动内容',
  `people_num` int(11) DEFAULT NULL COMMENT '报名人数上限\n',
  `flag` int(11) DEFAULT 0 COMMENT '软删状态位，1为被逻辑删除，0为未被软删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='活动信息';

-- ----------------------------
-- Records of active_inf
-- ----------------------------

-- ----------------------------
-- Table structure for active_sign
-- ----------------------------
DROP TABLE IF EXISTS `active_sign`;
CREATE TABLE `active_sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active_id` int(11) NOT NULL COMMENT '活动编号\n',
  `v_id` int(11) NOT NULL COMMENT '志愿者编号',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机(联系方式)',
  `wechat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '微信',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮件',
  `time` date NOT NULL COMMENT '报名时间',
  `flag` int(11) DEFAULT 0 COMMENT '软删状态位，1为被逻辑删除，0为未被软删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of active_sign
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) NOT NULL COMMENT '0为超级管理员，1为普通管理员\n',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员用户名\n',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '管理员电话\n',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像',
  `flag` int(11) DEFAULT 0 COMMENT '软删状态位，1为被逻辑删除，0为未被软删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1', 'admin', '123456', '10010', 'http://xxx.xxx.jpg','0');

-- ----------------------------
-- Table structure for article_inf
-- ----------------------------
DROP TABLE IF EXISTS `article_inf`;
CREATE TABLE `article_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role` int(11) NOT NULL COMMENT '消息发布者身份,\n0志愿者\n,1儿童\n,2管理员\n',
  `user_id` int(11) NOT NULL COMMENT '消息发布者id\n',
  `role` int(11) NOT NULL COMMENT '0为志愿风采;\r\n1为媒体报道\n;\r\n2为政策公布\n;\r\n3为志愿者活动\n',
  `states` int(11) NOT NULL COMMENT '活动状态:\r\n\n0为报名未开始\n;\r\n1为报名进行中\n;\r\n2为报名结束\n',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '推文发布时间',
  `end_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动结束报名时间，管理员或活动发布者可编辑\n',
  `image` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '推文图片\n',
  `title` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '推文标题限制为20字\n',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '推文内容\n',
  `flag` int(11) DEFAULT 0 COMMENT '软删状态位，1为被逻辑删除，0为未被软删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='推文信息表';

-- ----------------------------
-- Records of article_inf
-- ----------------------------

-- ----------------------------
-- Table structure for article_read
-- ----------------------------
DROP TABLE IF EXISTS `article_read`;
CREATE TABLE `article_read` (
  `id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL COMMENT '推文id\n',
  `user_id` int(11) NOT NULL COMMENT '查阅者id\n',
  `user_role` int(11) NOT NULL COMMENT '查阅者身份\n0志愿者\n1儿童\n2管理员\n',
  `read_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '查阅时间\n',
  `flag` int(11) DEFAULT 0 COMMENT '软删状态位，1为被逻辑删除，0为未被软删除',
  PRIMARY KEY (`id`),
  KEY `article_read_article_inf_article_id_fk` (`id`),
  CONSTRAINT `article_read_article_inf_article_id_fk` FOREIGN KEY (`id`) REFERENCES `article_inf` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of article_read
-- ----------------------------

-- ----------------------------
-- Table structure for child
-- ----------------------------
DROP TABLE IF EXISTS `child`;
CREATE TABLE `child` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名\n',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码\n',
  `salt` varchar(255) DEFAULT NULL COMMENT '私盐',
  `image` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像\n',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '真实姓名\n',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话号码\n',
  `wechat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '微信号\n',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱\n',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '家庭住址\n',
  `place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '籍贯\n',
  `born` date NOT NULL COMMENT '出生日期\n',
  `level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学习阶段\n',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间(自动读取系统时间)\n',
  `last_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次登录时间(自动读取系统时间)\n',
  `parent_phone` varchar(50) NOT NULL COMMENT '监护人电话,多个用，隔开',
  `parent_name` varchar(50) NOT NULL COMMENT '监护人姓名,多个用，隔开',
  `parent_name1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '监护人1姓名（必填）\n',
  `parent_tel1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '监护人1电话（必填）\n',
  `parent_name2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '监护人2姓名（非必填）\n',
  `parent_tel2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '监护人2电话（非必填）\n',
  `flag` int(11) DEFAULT 0 COMMENT '软删状态位，1为被逻辑删除，0为未被软删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of child
-- ----------------------------
INSERT INTO `child` VALUES ('1', '10010', 'a23c64a3da4a79dec5c22276e393e9cb', 'bf1e459bfd44427b863cbf00b8a2db95', 'xxx', '张三', '13211144888', '13211144888', 'zhangshan@123.com', 'xxx', 'xxx', '2020-03-28', '1', '2020-03-28 19:26:11', '2020-03-28 19:26:11', '13211144888', '张思', '神罗天正', '13211144888', null, null,'0');

-- ----------------------------
-- Table structure for volunteer
-- ----------------------------
DROP TABLE IF EXISTS `volunteer`;
CREATE TABLE `volunteer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '志愿者编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '私盐',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `avatar` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '头像\n',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '真实姓名\n',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话号码\n',
  `wechat` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '微信号\n',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱\n',
  `school` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '在读大学\n',
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '家庭住址\n',
  `place` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '籍贯\n',
  `born` date NOT NULL COMMENT '出生日期\n',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间\n',
  `last_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次登录时间',
  `card` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '志愿者证\n',
  `organization` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '归属组织\n',
  `publish_power` int(11) DEFAULT NULL COMMENT '志愿者发布推文权限:\r\n\n0没有权限\n;\r\n1有权限\n',
  `view_power` int(11) DEFAULT NULL COMMENT '志愿者发布教学资源权限\n:\r\n0没有权限;\r\n\n1有权限\n',
  `flag` int(11) DEFAULT 0 COMMENT '软删状态位，1为被逻辑删除，0为未被软删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of volunteer
-- ----------------------------
INSERT INTO `volunteer` VALUES ('1', '90010', 'bf1e459bfd44427b863cbf00b8a2db95', 'a23c64a3da4a79dec5c22276e393e9cb', 'xxx', '李四', '1324448881', '1324448881', '1324448881@qq.com', '圣地亚哥大学', '神帝阿哥', 'xxx', '2020-03-28', '2020-03-28 21:09:03', '2020-03-28 21:09:05', '2312397423214', '圣地亚哥大学艺术学院', '1', '1','0');
