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

-- 表名:灌区基本信息表
-- 表主题:存储灌区基本信息
-- 表表示:IrrBase
-- 表编号:101
DROP TABLE
IF EXISTS `irr_base`;

CREATE TABLE `irr_base` (
  `irr_id` int (11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `irr_code` CHAR (7) NOT NULL COMMENT '灌区编码',
  `source_id` int(11) NOT NULL COMMENT '水源编码',
  `irr_name` VARCHAR (50) COMMENT '灌区名称',
  `irr_type` CHAR (1) COMMENT '灌区类型',
  `upper_manageunit` VARCHAR (50) COMMENT '上级管理单位',
  `design_irrigate_area` NUMERIC (10, 3) COMMENT '设计灌溉面积',
  `chead_site` VARCHAR (50) COMMENT '渠首取水位置',
  `chead_flux` NUMERIC (8, 2) COMMENT '渠首设计流量',
  `trunk_legth` NUMERIC (10, 3) COMMENT '总干渠长度',
  `irrigation_area` TEXT COMMENT '灌溉范围',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`irr_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '灌区基本信息';


-- 表名:渠道基本信息表
-- 表主题:存储渠道基本信息
-- 表表示:IrrCanal
-- 表编号:101
DROP TABLE
IF EXISTS `canal_base`;

CREATE TABLE `canal_base` (
  `canal_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `canal_code` CHAR (7) NOT NULL COMMENT '渠道编码',
  `irr_id` int(11) NOT NULL COMMENT '灌区编码',
  `canal_name` VARCHAR (50) COMMENT '渠道名称',
  `canal_type` CHAR (1) COMMENT '渠道类型',
  `canal_length` NUMERIC (13, 2) COMMENT '渠道长度（公里）',
  `canal_control_area` NUMERIC (13, 2) COMMENT '控制面积（万亩）',
  `canal_plan_area` NUMERIC (13, 2) COMMENT '规划供水面积（万亩）',
  `upper_canal_id` VARCHAR (50) NOT NULL COMMENT '上级渠道标识符',
  `upper_canal_stake` NUMERIC (13, 2) COMMENT '上级渠道桩号',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`canal_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '渠道基本信息';



-- ----------------------------
-- 水源信息管理
-- ----------------------------

-- 表名:水源信息表
-- 表主题:水源信息表用来存储灌区所有的水源，包括水库、河流、井等。它描述灌区水源工程情况和水源的类型情况
-- 表表示:IrrBFSource
-- 表编号:101
DROP TABLE
IF EXISTS `source_base`;

CREATE TABLE `source_base` (
  `source_id` CHAR (11) NOT NULL AUTO_INCREMENT COMMENT '水源编码',
  `source_code` CHAR (11) NOT NULL COMMENT '水源编码',
  `source_name` VARCHAR (50) COMMENT '水源名称',
  `source_type_b` CHAR (1) COMMENT '水源工程类型',
  `Source_type_s` CHAR (1) COMMENT '水源类型',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`source_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '水源信息';

-- ----------------------------
-- 灌区建筑物
-- ----------------------------
-- 表名:水闸信息
-- 表主题:描述水闸基本信息
-- 表表示:IrrBAWaterGate
-- 表编号:140
DROP TABLE
IF EXISTS `sluice_base`;

CREATE TABLE `sluice_base` (
  `sluice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sluice_code` CHAR (11) NOT NULL COMMENT '水闸编码',
  `sluice_name` VARCHAR (50) COMMENT '工程简称',
  `sluice_full_name` VARCHAR (50) COMMENT '工程全称',
  `sluice_alias_name` VARCHAR (50) COMMENT '工程别名',
  `sluice_type` VARCHAR (50) COMMENT '水闸类别',
  `canal_id` int (11) COMMENT '所属渠段',
  `sluice_flow` NUMERIC (7, 2) COMMENT '流量(m^3/s)',
  `strobe_number` int(6) COMMENT '闸门孔数',
  `strobe_type` CHAR (2) COMMENT '闸门型式',
  `strobe_height` NUMERIC (7, 2) COMMENT '闸门高度',
  `strobe_width` NUMERIC (7, 2) COMMENT '闸门宽度',
  `strobe_thickness` NUMERIC (7, 2) COMMENT '闸门厚度',
  `motivity_type` CHAR (2) COMMENT '启闭机样式',
  `motivity_power` NUMERIC (6, 2) COMMENT '启闭机动力',
  `motivity_velocity` NUMERIC (6, 2) COMMENT '启闭速度',
  `dissipation_type` CHAR (2) COMMENT '消能工型式',
  `dissipation_length` NUMERIC (7, 2) COMMENT '退水渠长(m)',
  `dissipation_slope_upper_limit` NUMERIC (7, 2) COMMENT '坡降(上限)',
  `dissipation_slope_lower_limit` NUMERIC (7, 2) COMMENT '坡降(下限)',
  `construction_time_upper_limit` NUMERIC (7, 2) COMMENT '施工时间(天)上限',
  `construction_time_lower_limit` NUMERIC (7, 2) COMMENT '施工时间(天)下限',
  `stake` CHAR (1) COMMENT '桩号',
  PRIMARY KEY (`sluice_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '水闸信息';


















-- 表名:取水设施基本信息表
-- 表主题:存储某灌区所有的取水设施，包括坝、泵站、引水闸等
-- 表表示:IrrBFStructure
-- 表编号:102
DROP TABLE
IF EXISTS `IrrBFStructure`;

CREATE TABLE `IrrBFStructure` (
  `FStructure_Code` CHAR (11) NOT NULL COMMENT '取水设施编码',
  `FStructure_Name` VARCHAR (50) COMMENT '取水设施名称',
  `FStructure_Type` CHAR (1) COMMENT '取水设施类别 1:水闸 2:坝 3:泵站 9:其他',
  `Fetch_Mode` CHAR (1) COMMENT '取水方式 1:蓄水 2:引水 3:提水 4:混合 9:其他',
  `SourceE_code` CHAR (11) NOT NULL COMMENT '水源工程编码',
  PRIMARY KEY (`FStructure_Code`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '取水设施基本信息表';

-- 表名:河段基本情况表
-- 表主题:描述灌区取水设施所在河段的具体情况
-- 表表示:IrrBFSource_Reach
-- 表编号:103
DROP TABLE
IF EXISTS `IrrBFSource_Reach`;

CREATE TABLE `IrrBFSource_Reach` (
  `River_Code` CHAR (8) NOT NULL COMMENT '河流编码',
  `Reach_Name` VARCHAR (50) COMMENT '河段名称',
  `River_Width` NUMERIC (10, 2) COMMENT '河槽平均宽度(m)',
  `River_flux` NUMERIC (10, 2) COMMENT '河槽平槽流量(m^3/s)',
  PRIMARY KEY (`River_Code`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '河段基本情况表';

-- ----------------------------
-- 输水系统
-- ----------------------------

-- 表名:输水渠道系统表
-- 表主题:描述输水渠道系统基本信息
-- 表表示:IrrBTCanal
-- 表编号:140
DROP TABLE
IF EXISTS `Irrb_t_canal_system`;

CREATE TABLE `Irrb_t_canal_system` (
  `canal_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `canal_code` CHAR (11) NOT NULL COMMENT '渠道编码',
  `irr_code` CHAR (7) NOT NULL COMMENT '灌区编码',
  `canal_name` VARCHAR (50) NOT NULL COMMENT '渠道名称',
  `canal_py` VARCHAR (20) COMMENT '拼音',
  `canal_length` NUMERIC (13, 2) COMMENT '渠道长度（公里）',
  `canal_control_area` NUMERIC (13, 2) COMMENT '控制面积（万亩）',
  `canal_plan_area` NUMERIC (13, 2) COMMENT '规划供水面积（万亩）',
  `upper_canal_id` VARCHAR (50) NOT NULL COMMENT '上级渠道标识符',
  `upper_canal_stake` NUMERIC (13, 2) COMMENT '上级渠道桩号',

  PRIMARY KEY (`canal_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '输水渠道系统表';

-- ----------------------------
-- 配水系统
-- ----------------------------

-- 表名:水闸信息表
-- 表主题:描述水闸基本信息
-- 表表示:IrrBAWaterGate
-- 表编号:140
DROP TABLE
IF EXISTS `IrrBAWaterGate`;

CREATE TABLE `IrrBAWaterGate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `code` CHAR (11) NOT NULL COMMENT '水闸编码',
  `name` VARCHAR (50) COMMENT '工程简称',
  `fullname` VARCHAR (50) COMMENT '工程全称',
  `aliasname` VARCHAR (50) COMMENT '工程别名',
  `type` VARCHAR (50) COMMENT '水闸类别',
  `canal_code` CHAR (11) COMMENT '所属渠段',
  `flow` NUMERIC (7, 2) COMMENT '流量(m^3/s)',
  `strobe_number` int(6) COMMENT '闸门孔数',
  `strobe_type` CHAR (2) COMMENT '闸门型式',
  `strobe_height` NUMERIC (7, 2) COMMENT '闸门高度',
  `strobe_width` NUMERIC (7, 2) COMMENT '闸门宽度',
  `strobe_thickness` NUMERIC (7, 2) COMMENT '闸门厚度',
  `motivity_type` CHAR (2) COMMENT '启闭机样式',
  `motivity_power` NUMERIC (6, 2) COMMENT '启闭机动力',
  `motivity_velocity` NUMERIC (6, 2) COMMENT '启闭速度',
  `dissipation_type` CHAR (2) COMMENT '消能工型式',
  `dissipation_length` NUMERIC (7, 2) COMMENT '退水渠长(m)',
  `dissipation_slope_upper_limit` NUMERIC (7, 2) COMMENT '坡降(上限)',
  `dissipation_slope_lower_limit` NUMERIC (7, 2) COMMENT '坡降(下限)',
  `construction_time_upper_limit` NUMERIC (7, 2) COMMENT '施工时间(天)上限',
  `construction_time_lower_limit` NUMERIC (7, 2) COMMENT '施工时间(天)下限',
  `stake` CHAR (1) COMMENT '桩号',
  PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '水闸信息表';