
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` varchar(50) NOT NULL,
  `createTime` bigint(20) DEFAULT NULL,
  `cretatePerson` varchar(50) DEFAULT NULL,
  `isLeaf` int(11) DEFAULT NULL,
  `menuDesc` varchar(200) DEFAULT NULL,
  `menuName` varchar(20) DEFAULT NULL,
  `modifyPerson` varchar(50) DEFAULT NULL,
  `modifyTime` bigint(20) DEFAULT NULL,
  `ordor` int(11) DEFAULT NULL,
  `parentId` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `rolename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for t_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_menu`;
CREATE TABLE `t_sys_role_menu` (
  `id` varchar(50) NOT NULL,
  `menuid` varchar(50) NOT NULL,
  `roleid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` varchar(50) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `empno` varchar(200) NOT NULL,
  `idcard` varchar(200) DEFAULT NULL,
  `isEffect` int(11) DEFAULT NULL,
  `lastLoginIp` varchar(30) DEFAULT NULL,
  `lastLoginTime` bigint(20) DEFAULT NULL,
  `loginIp` varchar(30) DEFAULT NULL,
  `loginSum` int(11) DEFAULT NULL,
  `operateID` varchar(255) DEFAULT NULL,
  `password` varchar(36) NOT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `username` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` varchar(50) NOT NULL,
  `roleid` varchar(50) NOT NULL,
  `userid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;