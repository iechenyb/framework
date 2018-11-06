/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2016-04-14 16:51:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for usr
-- ----------------------------
DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr` (
  `id` varchar(60) NOT NULL,
  `username` varchar(100) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL COMMENT '转诊',
  `telphone` varchar(20) DEFAULT NULL,
  `mobphone` varchar(11) DEFAULT NULL,
  `degree` int(2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `createtime` varchar(14) DEFAULT NULL COMMENT '最近操作时间',
  PRIMARY KEY (`id`,`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
