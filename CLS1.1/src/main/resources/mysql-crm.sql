/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2016-04-06 15:12:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `lxr` varchar(255) DEFAULT NULL,
  `zylxr` varchar(255) DEFAULT NULL,
  `cz` varchar(255) DEFAULT NULL COMMENT '转诊',
  `telphone` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `classes` varchar(255) DEFAULT NULL,
  `ly` varchar(255) DEFAULT NULL,
  `czsj` varchar(255) DEFAULT NULL COMMENT '最近操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` int(11) DEFAULT NULL,
  `lb` varchar(255) DEFAULT NULL,
  `lbmc` varchar(255) DEFAULT NULL,
  `parentlb` varchar(255) DEFAULT NULL,
  `lbvalue` varchar(255) DEFAULT NULL,
  `xh` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` varchar(60) DEFAULT NULL,
  `clientname` varchar(500) DEFAULT NULL COMMENT '客户名称（公司或者个人）',
  `qyzy` varchar(255) NOT NULL COMMENT '签约专员',
  `jhjd` varchar(255) NOT NULL COMMENT '机会阶段',
  `fzr` varchar(255) DEFAULT NULL COMMENT '负责人',
  `yjcgl` varchar(255) DEFAULT NULL COMMENT '预计成功率',
  `zt` varchar(255) DEFAULT NULL COMMENT '状态 进行中，已签约等',
  `xqms` varchar(255) DEFAULT NULL COMMENT '需求描述',
  `jhlx` varchar(255) DEFAULT NULL COMMENT '机会类型',
  `yjcje` varchar(255) DEFAULT NULL COMMENT '预计成交额',
  `bmrq` varchar(255) DEFAULT NULL COMMENT '报名日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menubs` varchar(100) NOT NULL,
  `menuname` varchar(255) NOT NULL,
  `menuid` varchar(60) NOT NULL,
  `parentid` varchar(60) NOT NULL,
  `url` varchar(200) NOT NULL,
  `level` int(1) NOT NULL,
  `rank` int(1) NOT NULL,
  `path` varchar(100) DEFAULT NULL,
  `createtime` varchar(14) DEFAULT NULL,
  `isleaf` int(1) NOT NULL,
  `bz` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `roleid` int(11) DEFAULT NULL,
  `menuid` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `userid` varchar(60) NOT NULL,
  `menuid` varchar(500) NOT NULL,
  `url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`userid`,`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userid` varchar(60) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_type`;
CREATE TABLE `sys_user_type` (
  `groupid` int(11) NOT NULL,
  `groupname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_type
-- ----------------------------
INSERT INTO `sys_user_type` VALUES ('1', 'superadmin');
INSERT INTO `sys_user_type` VALUES ('2', 'admin');
INSERT INTO `sys_user_type` VALUES ('3', 'comuser');

-- ----------------------------
-- Table structure for usr
-- ----------------------------
DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr` (
  `id` varchar(60) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `zt` int(11) DEFAULT NULL,
  `czsj` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usr
-- ----------------------------
INSERT INTO `usr` VALUES ('123', 'chenyb', null, '1', '1', null);
