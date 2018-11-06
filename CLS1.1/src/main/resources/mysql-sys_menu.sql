/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2016-04-12 20:43:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_menu`
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
  `bz` varchar(500) DEFAULT NULL,
  `parentbs` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('MENUROOT', '系统菜单', '7ca93b129c1345da8cb5c4a94c1c2d8e', '-1', '', '1', '1', 'ls', '20160406142342', '0', 'no forget', '-1');
INSERT INTO `sys_menu` VALUES ('KHGL', '客户管理', '402881e7540a36cb01540a3e1cbb0003', '7ca93b129c1345da8cb5c4a94c1c2d8e', 'testurl', '1', '-1', 'ls', '20160412202554', '0', '客户管理', 'MENUROOT');
INSERT INTO `sys_menu` VALUES ('JXGL', '绩效管理', '402881e7540a36cb01540a3e7f610004', '7ca93b129c1345da8cb5c4a94c1c2d8e', 'testurl', '1', '-1', 'ls', '20160412202724', '0', '绩效管理', 'MENUROOT');
INSERT INTO `sys_menu` VALUES ('YHGL', '用户管理', '402881e7540a36cb01540a51980e0007', '7ca93b129c1345da8cb5c4a94c1c2d8e', 'TESTURL', '1', '-1', 'ls', '20160412202812', '0', '系统用户管理，内部员工使用，不对外', 'MENUROOT');
INSERT INTO `sys_menu` VALUES ('BGKH', '客户变更', '402881e7540a6cd801540a6d73790000', '402881e7540a36cb01540a3e1cbb0003', 'URL', '1', '-1', 'ls', '20160412203644', '1', '客户信息变更', 'KHGL');
INSERT INTO `sys_menu` VALUES ('JSGL', '角色管理', '402881e7540a6cd801540a7212100001', '7ca93b129c1345da8cb5c4a94c1c2d8e', 'url', '1', '-1', 'ls', '20160412202943', '0', '角色管理，增加系统角色', 'MENUROOT');
INSERT INTO `sys_menu` VALUES ('BMGL', '部门管理', '402881e7540a6cd801540a72a0360002', '7ca93b129c1345da8cb5c4a94c1c2d8e', 'url', '1', '-1', 'ls', '20160412202952', '0', '部门管理，服务大公司', 'MENUROOT');
INSERT INTO `sys_menu` VALUES ('XZKH', '新增客户', '402881e7540a6cd801540a73d8800003', '402881e7540a36cb01540a3e1cbb0003', 'URL', '1', '2', 'ls', '20160412203044', '1', '新增客户，来源包括外网注册和内网添加', 'KHGL');
INSERT INTO `sys_menu` VALUES ('MKPI', '月度目标', '402881e7540a6cd801540a75dc380004', '402881e7540a36cb01540a3e7f610004', 'URL', '1', '1', 'ls', '20160412203256', '0', '月度目标填写', 'JXGL');
INSERT INTO `sys_menu` VALUES ('WKPI', '周度目标', '402881e7540a6cd801540a769f570005', '402881e7540a36cb01540a3e7f610004', 'URL', '1', '2', 'ls', '20160412203346', '1', '周绩效考核', 'JXGL');
INSERT INTO `sys_menu` VALUES ('SKPI', '季度目标', '402881e7540a6cd801540a7758560006', '402881e7540a36cb01540a3e7f610004', 'URL', '1', '-1', 'ls', '20160412203523', '1', '季度目标设定', 'JXGL');
INSERT INTO `sys_menu` VALUES ('YKPI', '年度目标', '402881e7540a6cd801540a7872cd0007', '402881e7540a36cb01540a3e7f610004', 'URL', '1', '4', 'ls', '20160412203546', '-1', '年度目标', 'JXGL');
INSERT INTO `sys_menu` VALUES ('XZYH', '新增用户', '402881e7540a6cd801540a7906310008', '402881e7540a36cb01540a51980e0007', '', '1', '-1', 'ls', '20160412203658', '1', '', 'YHGL');
INSERT INTO `sys_menu` VALUES ('BGYH', '变更用户', '402881e7540a6cd801540a79d98e0009', '402881e7540a36cb01540a51980e0007', '', '1', '2', 'ls', '20160412203718', '1', '', 'YHGL');
INSERT INTO `sys_menu` VALUES ('XZJS', '新增角色', '402881e7540a6cd801540a7a606f000a', '402881e7540a6cd801540a7212100001', '', '1', '1', 'ls', '20160412203752', '1', '', 'JSGL');
INSERT INTO `sys_menu` VALUES ('XZBM', '新增部门', '402881e7540a6cd801540a7a9592000b', '402881e7540a6cd801540a72a0360002', '', '1', '-1', 'ls', '20160412204205', '-1', '', 'BMGL');
INSERT INTO `sys_menu` VALUES ('QXFP', '权限分配', '402881e7540a6cd801540a7bdb4b000c', '7ca93b129c1345da8cb5c4a94c1c2d8e', 'url', '1', '6', 'ls', '20160412203929', '0', '', 'MENUROOT');
INSERT INTO `sys_menu` VALUES ('JSFP', '角色分配', '402881e7540a6cd801540a7c40fe000d', '402881e7540a6cd801540a7bdb4b000c', 'URL', '1', '-1', 'ls', '20160412204010', '1', '', 'QXFP');
