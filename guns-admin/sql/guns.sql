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
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('24', '1', '0', '[0],', '总公司', '总公司', '', null);
INSERT INTO `dept` VALUES ('25', '2', '24', '[0],[24],', '开发部', '开发部', '', null);
INSERT INTO `dept` VALUES ('26', '3', '24', '[0],[24],', '运营部', '运营部', '', null);
INSERT INTO `dept` VALUES ('27', '4', '24', '[0],[24],', '战略部', '战略部', '', null);

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('16', '0', '0', '状态', null);
INSERT INTO `dict` VALUES ('17', '1', '16', '启用', null);
INSERT INTO `dict` VALUES ('18', '2', '16', '禁用', null);
INSERT INTO `dict` VALUES ('29', '0', '0', '性别', null);
INSERT INTO `dict` VALUES ('30', '1', '29', '男', null);
INSERT INTO `dict` VALUES ('31', '2', '29', '女', null);
INSERT INTO `dict` VALUES ('35', '0', '0', '账号状态', null);
INSERT INTO `dict` VALUES ('36', '1', '35', '启用', null);
INSERT INTO `dict` VALUES ('37', '2', '35', '冻结', null);
INSERT INTO `dict` VALUES ('38', '3', '35', '已删除', null);

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 COMMENT='登录记录';

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES ('126', '退出日志', '1', '2017-06-04 10:21:55', '成功', null, '127.0.0.1');
INSERT INTO `login_log` VALUES ('127', '登录日志', '1', '2017-06-04 10:21:59', '成功', null, '127.0.0.1');
INSERT INTO `login_log` VALUES ('128', '退出日志', '1', '2017-06-04 10:22:59', '成功', null, '127.0.0.1');
INSERT INTO `login_log` VALUES ('129', '登录日志', '1', '2017-06-04 10:23:01', '成功', null, '127.0.0.1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`)  VALUES ( 'system', '0', '[0],', '系统管理', 'fa-user', '', '9', '1', '1', null, '1', '1');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', '1', '2', '1', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', null, '/mgr/add', '1', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', null, '/mgr/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', null, '/mgr/delete', '3', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', null, '/mgr/reset', '4', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', null, '/mgr/freeze', '5', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', null, '/mgr/unfreeze', '6', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', null, '/mgr/setRole', '7', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('role', 'system', '[0],[system],', '角色管理', null, '/role', '2', '2', '1', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'role_add', 'role', '[0],[system],[role],', '添加角色', null, '/role/add', '1', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'role_edit', 'role', '[0],[system],[role],', '修改角色', null, '/role/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'role_remove', 'role', '[0],[system],[role],', '删除角色', null, '/role/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', null, '/role/setAuthority', '4', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'menu', 'system', '[0],[system],', '菜单管理', null, '/menu', '4', '2', '1', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', null, '/menu/add', '1', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', null, '/menu/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', null, '/menu/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('log', 'system', '[0],[system],', '业务日志', null, '/log', '6', '2', '1', null, '1', '0');
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'druid', 'system', '[0],[system],', '监控管理', null, '/druid', '7', '2', '1', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'dept', 'system', '[0],[system],', '部门管理', null, '/dept', '3', '2', '1', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'dict', 'system', '[0],[system],', '字典管理', null, '/dict', '4', '2', '1', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'loginLog', 'system', '[0],[system],', '登录日志', null, '/loginLog', '6', '2', '1', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'log_clean', 'log', '[0],[system],[log],', '清空日志', null, '/log/delLog', '3', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('dept_add', 'dept', '[0],[system],[dept],', '添加部门', null, '/dept/add', '1', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('dept_update', 'dept', '[0],[system],[dept],', '修改部门', null, '/dept/update', '1', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', null, '/dept/delete', '1', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', null, '/dict/add', '1', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('dict_update', 'dict', '[0],[system],[dict],', '修改字典', null, '/dict/update', '1', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('dict_delete', 'dict', '[0],[system],[dict],', '删除字典', null, '/dict/delete', '1', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'notice', 'system', '[0],[system],', '通知管理', null, '/notice', '9', '2', '1', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('notice_add', 'notice', '[0],[system],[notice],', '添加通知', null, '/notice/add', '1', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', null, '/notice/update', '2', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', null, '/notice/delete', '3', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'code', 'system', '[0],[system],', '代码生成', 'fa-user', '/code', '10', '2', '1', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'api_mgr', '0', '[0],', '接口文档', 'fa-leaf', '/doc.html', '11', '1', '1', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', '4', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', '5', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', '4', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', '5', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', '6', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', '4', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', '5', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', '6', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', '2', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', '3', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', '1', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ('login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', '2', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', '5', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', '6', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', '7', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', '8', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', '9', '3', '0', null, '1', null);
INSERT INTO `menu`(`code`,`pcode`,`pcodes`,`name`,`icon`,`url`,`num`,`levels`,`ismenu`,`tips`,`status`,`isopen`) VALUES ( 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', '10', '3', '0', null, '1', null);


-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='通知表';

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('6', '世界', '10', '欢迎使用Guns管理系统', '2017-01-11 08:53:20', '1');
INSERT INTO `notice` VALUES ('8', '你好', null, '你好', '2017-05-10 19:28:57', '1');

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=483 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of operation_log
-- ----------------------------
INSERT INTO `operation_log` VALUES ('480', '业务日志', '清空业务日志', '1', 'com.stylefeng.guns.modular.system.controller.LogController', 'delLog', '2017-06-03 23:04:22', '成功', '主键id=null');
INSERT INTO `operation_log` VALUES ('481', '业务日志', '清空登录日志', '1', 'com.stylefeng.guns.modular.system.controller.LoginLogController', 'delLog', '2017-06-03 23:04:25', '成功', '主键id=null');
INSERT INTO `operation_log` VALUES ('482', '业务日志', '修改菜单', '1', 'com.stylefeng.guns.modular.system.controller.MenuController', 'edit', '2017-06-04 10:22:58', '成功', '菜单名称=分配角色跳转;;;字段名称:url地址,旧值:/role/role_assign,新值:/mgr/role_assign');

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of relation
-- ----------------------------
INSERT INTO `relation` VALUES ('21', '1', '1');
INSERT INTO `relation` VALUES ('22', '2', '1');
INSERT INTO `relation` VALUES ('23', '3', '1');
INSERT INTO `relation` VALUES ('24', '4', '1');
INSERT INTO `relation` VALUES ('25', '5', '1');
INSERT INTO `relation` VALUES ('26', '6', '1');
INSERT INTO `relation` VALUES ('27', '7', '1');
INSERT INTO `relation` VALUES ('28', '8', '1');
INSERT INTO `relation` VALUES ('29', '9', '1');
INSERT INTO `relation` VALUES ('30', '52', '1');
INSERT INTO `relation` VALUES ('31', '53', '1');
INSERT INTO `relation` VALUES ('32', '54', '1');
INSERT INTO `relation` VALUES ('33', '10', '1');
INSERT INTO `relation` VALUES ('34', '11', '1');
INSERT INTO `relation` VALUES ('35', '12', '1');
INSERT INTO `relation` VALUES ('36', '13', '1');
INSERT INTO `relation` VALUES ('37', '14', '1');
INSERT INTO `relation` VALUES ('38', '49', '1');
INSERT INTO `relation` VALUES ('39', '50', '1');
INSERT INTO `relation` VALUES ('40', '51', '1');
INSERT INTO `relation` VALUES ('41', '15', '1');
INSERT INTO `relation` VALUES ('42', '16', '1');
INSERT INTO `relation` VALUES ('43', '17', '1');
INSERT INTO `relation` VALUES ('44', '18', '1');
INSERT INTO `relation` VALUES ('45', '37', '1');
INSERT INTO `relation` VALUES ('46', '38', '1');
INSERT INTO `relation` VALUES ('47', '19', '1');
INSERT INTO `relation` VALUES ('48', '24', '1');
INSERT INTO `relation` VALUES ('49', '45', '1');
INSERT INTO `relation` VALUES ('50', '46', '1');
INSERT INTO `relation` VALUES ('51', '20', '1');
INSERT INTO `relation` VALUES ('52', '21', '1');
INSERT INTO `relation` VALUES ('53', '25', '1');
INSERT INTO `relation` VALUES ('54', '26', '1');
INSERT INTO `relation` VALUES ('55', '27', '1');
INSERT INTO `relation` VALUES ('56', '39', '1');
INSERT INTO `relation` VALUES ('57', '40', '1');
INSERT INTO `relation` VALUES ('58', '41', '1');
INSERT INTO `relation` VALUES ('59', '22', '1');
INSERT INTO `relation` VALUES ('60', '28', '1');
INSERT INTO `relation` VALUES ('61', '29', '1');
INSERT INTO `relation` VALUES ('62', '30', '1');
INSERT INTO `relation` VALUES ('63', '42', '1');
INSERT INTO `relation` VALUES ('64', '43', '1');
INSERT INTO `relation` VALUES ('65', '44', '1');
INSERT INTO `relation` VALUES ('66', '23', '1');
INSERT INTO `relation` VALUES ('67', '47', '1');
INSERT INTO `relation` VALUES ('68', '48', '1');
INSERT INTO `relation` VALUES ('69', '31', '1');
INSERT INTO `relation` VALUES ('70', '32', '1');
INSERT INTO `relation` VALUES ('71', '33', '1');
INSERT INTO `relation` VALUES ('72', '34', '1');
INSERT INTO `relation` VALUES ('73', '35', '1');
INSERT INTO `relation` VALUES ('74', '36', '1');
INSERT INTO `relation` VALUES ('75', '55', '1');
INSERT INTO `relation` VALUES ('76', '56', '1');
INSERT INTO `relation` VALUES ('77', '57', '1');
INSERT INTO `relation` VALUES ('78', '58', '1');
INSERT INTO `relation` VALUES ('79', '59', '1');
-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1', '0', '超级管理员', '24', 'administrator', '1');
INSERT INTO `role` VALUES ('5', '2', '1', '临时', '26', 'temp', null);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'girl.gif', 'admin', 'ecfadcde9305f8891bcfe5a1e28c253e', '8pgby', '张三', '2017-05-05 00:00:00', '2', 'sn93@qq.com', '18200000000', '1', '27', '1', '2016-01-29 08:49:53', '25');
INSERT INTO `user` VALUES ('44', null, 'test', '45abb7879f6a8268f1ef600e6038ac73', 'ssts3', 'test', '2017-05-01 00:00:00', '1', 'abc@123.com', '', '5', '26', '1', '2017-05-16 20:33:37', null);
