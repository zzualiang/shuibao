/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : guns

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-07-11 22:39:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 灌区信息管理
-- ----------------------------

-- 表名:水保项目的基本信息
-- 表主题:存储项目基本信息
-- 表表示:IrrBase
-- 表编号:101
DROP TABLE
IF EXISTS `project_base`;

CREATE TABLE `irr_base` (
  `project_id` int (11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project_code` CHAR (7) NOT NULL COMMENT '项目编码',
  `project_name` VARCHAR (50) COMMENT '项目名称',
  `project_type` CHAR (1) COMMENT '项目类型',------重点项目、试点项目、其他
  `upper_manageunit` VARCHAR (50) COMMENT '管理单位',
  `design_irrigate_area` NUMERIC (10, 3) COMMENT '项目的所在地',
  `project_img` VARCHAR (200) COMMENT '项目图片',
  PRIMARY KEY (`project_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '项目基本信息';


