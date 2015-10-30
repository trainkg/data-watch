/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : datawatch

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2015-10-30 09:46:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `alarmtype`
-- ----------------------------
-- DROP TABLE IF EXISTS `alarmtype`;
CREATE TABLE `alarmtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` int(11) DEFAULT NULL,
  `value` varchar(12) DEFAULT NULL,
  `name` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of alarmtype
-- ----------------------------
INSERT INTO `alarmtype` VALUES ('1', '0', '2', '安全门未关');
INSERT INTO `alarmtype` VALUES ('2', '0', '4', '请开安全门');
INSERT INTO `alarmtype` VALUES ('3', '0', '8', '放开手动/急停键');
INSERT INTO `alarmtype` VALUES ('4', '0', '16', '油温偏差');
INSERT INTO `alarmtype` VALUES ('5', '0', '32', '全程未定时完成');
INSERT INTO `alarmtype` VALUES ('6', '0', '64', '加热器电流错误');
INSERT INTO `alarmtype` VALUES ('7', '0', '128', '脱模未到定位');
INSERT INTO `alarmtype` VALUES ('8', '0', '216', '射出监控失败');
INSERT INTO `alarmtype` VALUES ('9', '0', '512', '射出防护罩未关');
INSERT INTO `alarmtype` VALUES ('10', '0', '1024', '机械手失败');
INSERT INTO `alarmtype` VALUES ('11', '0', '2048', '开模数已到');
INSERT INTO `alarmtype` VALUES ('12', '0', '4096', '开模未到定位');
INSERT INTO `alarmtype` VALUES ('13', '0', '8192', '脱模失败');
INSERT INTO `alarmtype` VALUES ('14', '0', '16384', '储料未定时完成');
INSERT INTO `alarmtype` VALUES ('15', '0', '32768', '关模未到定位');
INSERT INTO `alarmtype` VALUES ('16', '1', '1', '位置设定不良');
INSERT INTO `alarmtype` VALUES ('17', '1', '2', '完成自动调模');
INSERT INTO `alarmtype` VALUES ('18', '1', '4', '润滑油位偏差');
INSERT INTO `alarmtype` VALUES ('19', '1', '8', '射出启位置偏差');
INSERT INTO `alarmtype` VALUES ('20', '1', '16', '储料转数偏差');
INSERT INTO `alarmtype` VALUES ('21', '1', '32', '射出时间偏差');
INSERT INTO `alarmtype` VALUES ('22', '1', '64', '开模一慢未定位');
INSERT INTO `alarmtype` VALUES ('23', '1', '128', '关模保护失败');
INSERT INTO `alarmtype` VALUES ('24', '1', '216', '射退终未到定位');
INSERT INTO `alarmtype` VALUES ('25', '1', '512', '储料终未到定位');
INSERT INTO `alarmtype` VALUES ('26', '1', '1024', '开模装数己到');
INSERT INTO `alarmtype` VALUES ('27', '1', '2048', '中子未到定位');
INSERT INTO `alarmtype` VALUES ('28', '1', '4096', '机械安全异常');
INSERT INTO `alarmtype` VALUES ('29', '1', '8192', '润滑检出失败');
INSERT INTO `alarmtype` VALUES ('30', '1', '16384', '油量检出失败');
INSERT INTO `alarmtype` VALUES ('31', '1', '32768', '滤网检出失败');
INSERT INTO `alarmtype` VALUES ('32', '0', '1', '温度偏差');

-- ----------------------------
-- Table structure for `machinfor`
-- ----------------------------
-- DROP TABLE IF EXISTS `machinfor`;
CREATE TABLE `machinfor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `machnum` char(32) DEFAULT NULL,
  `machmac` char(32) NOT NULL,
  `machip` char(32) DEFAULT NULL,
  `machport` int(16) DEFAULT NULL,
  `machmode` varchar(16) DEFAULT NULL,
  `machmotorstatue` varchar(16) DEFAULT NULL,
  `machheartstatue` varchar(16) DEFAULT NULL,
  `com1statue` int(16) DEFAULT NULL,
  `com2statue` int(16) DEFAULT NULL,
  `auststatue` int(16) DEFAULT NULL,
  `temper1statue` varchar(16) DEFAULT NULL,
  `temper2statue` varchar(16) DEFAULT NULL,
  `temper3statue` varchar(16) DEFAULT NULL,
  `temper4statue` varchar(16) DEFAULT NULL,
  `temper5statue` varchar(16) DEFAULT NULL,
  `temper6statue` varchar(16) DEFAULT NULL,
  `temper7statue` varchar(16) DEFAULT NULL,
  `temper8statue` varchar(16) DEFAULT NULL,
  `temper9statue` varchar(16) DEFAULT NULL,
  `temper1value` int(11) DEFAULT NULL,
  `temper2value` int(11) DEFAULT NULL,
  `temper3value` int(11) DEFAULT NULL,
  `temper4value` int(11) DEFAULT NULL,
  `temper5value` int(11) DEFAULT NULL,
  `temper6value` int(11) DEFAULT NULL,
  `temper7value` int(11) DEFAULT NULL,
  `temper8value` int(11) DEFAULT NULL,
  `temper9value` int(11) DEFAULT NULL,
  `oiltempervalue` int(11) DEFAULT NULL,
  `ruler1value` int(11) DEFAULT NULL,
  `ruler2value` int(11) DEFAULT NULL,
  `ruler3value` int(11) DEFAULT NULL,
  `ruler4value` int(11) DEFAULT NULL,
  `ruler5value` int(11) DEFAULT NULL,
  `ruler6value` int(11) DEFAULT NULL,
  `ruler7value` int(11) DEFAULT NULL,
  `ruler8value` int(11) DEFAULT NULL,
  `oper1value` int(11) DEFAULT NULL,
  `oper2value` int(11) DEFAULT NULL,
  `oper3value` int(11) DEFAULT NULL,
  `oper4value` int(11) DEFAULT NULL,
  `oper5value` int(11) DEFAULT NULL,
  `oper6value` int(11) DEFAULT NULL,
  `oper7value` int(11) DEFAULT NULL,
  `minorVer` varchar(255) DEFAULT NULL,
  `msgType` varchar(255) DEFAULT NULL,
  `contentLength` varchar(255) DEFAULT NULL,
  `oper8value` int(11) DEFAULT NULL,
  `oper9value` int(11) DEFAULT NULL,
  `reciverDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=gbk;


-- ----------------------------
-- Table structure for `opermode`
-- ----------------------------
-- DROP TABLE IF EXISTS `opermode`;
CREATE TABLE `opermode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` char(255) CHARACTER SET gbk COLLATE gbk_bin DEFAULT NULL,
  `name` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of opermode
-- ----------------------------
INSERT INTO `opermode` VALUES ('1', '1', '自动');
INSERT INTO `opermode` VALUES ('2', '2', '半自动');
INSERT INTO `opermode` VALUES ('3', '4', '电眼自动');
INSERT INTO `opermode` VALUES ('4', '8', '时间自动');
INSERT INTO `opermode` VALUES ('5', '16', '粗调模');
INSERT INTO `opermode` VALUES ('6', '32', '微动调模');
INSERT INTO `opermode` VALUES ('7', '64', '位置设定');
INSERT INTO `opermode` VALUES ('8', '128', '自动清料');
INSERT INTO `opermode` VALUES ('9', '2048', '自动调模');
INSERT INTO `opermode` VALUES ('10', '0', '手动');

-- ----------------------------
-- Table structure for `operstepmode`
-- ----------------------------
-- DROP TABLE IF EXISTS `operstepmode`;
CREATE TABLE `operstepmode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` smallint(6) DEFAULT NULL,
  `value` varchar(12) CHARACTER SET gbk COLLATE gbk_bin DEFAULT NULL,
  `name` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of operstepmode
-- ----------------------------
INSERT INTO `operstepmode` VALUES ('1', '0', '2', '压模');
INSERT INTO `operstepmode` VALUES ('2', '0', '4', '开模');
INSERT INTO `operstepmode` VALUES ('3', '0', '8', '射出');
INSERT INTO `operstepmode` VALUES ('4', '0', '16', '射退');
INSERT INTO `operstepmode` VALUES ('5', '0', '32', '储料');
INSERT INTO `operstepmode` VALUES ('6', '0', '64', '座台进');
INSERT INTO `operstepmode` VALUES ('7', '0', '128', '座台退');
INSERT INTO `operstepmode` VALUES ('8', '0', '256', '脱模进');
INSERT INTO `operstepmode` VALUES ('9', '0', '512', '脱模退');
INSERT INTO `operstepmode` VALUES ('10', '0', '1024', '中子进');
INSERT INTO `operstepmode` VALUES ('11', '0', '2048', '中子退');
INSERT INTO `operstepmode` VALUES ('12', '0', '4096', '调模进');
INSERT INTO `operstepmode` VALUES ('13', '0', '8192', '调模退');
INSERT INTO `operstepmode` VALUES ('14', '0', '16384', '保压');
INSERT INTO `operstepmode` VALUES ('15', '0', '1', '关模');

-- ----------------------------
-- Table structure for `pctype`
-- ----------------------------
-- DROP TABLE IF EXISTS `pctype`;
CREATE TABLE `pctype` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of pctype
-- ----------------------------
INSERT INTO `pctype` VALUES ('1', 'PLC');
INSERT INTO `pctype` VALUES ('2', 'TM');

-- ----------------------------
-- Table structure for `zq_permission`
-- ----------------------------
-- DROP TABLE IF EXISTS `zq_permission`;
CREATE TABLE `zq_permission` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(10) NOT NULL,
  `dict_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_3` (`dict_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`dict_id`) REFERENCES `zq_user_dict` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='包含系统所有的权限资源';

-- ----------------------------
-- Records of zq_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `zq_role`
-- ----------------------------
-- DROP TABLE IF EXISTS `zq_role`;
CREATE TABLE `zq_role` (
  `ID` varchar(32) NOT NULL,
  `group_name` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色列表';

-- ----------------------------
-- Records of zq_role
-- ----------------------------

-- ----------------------------
-- Table structure for `zq_user`
-- ----------------------------
-- DROP TABLE IF EXISTS `zq_user`;
CREATE TABLE `zq_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `homeAddress` varchar(200) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员基本信息表';

-- ----------------------------
-- Records of zq_user
-- ----------------------------
INSERT INTO `zq_user` VALUES ('1', 'admin', 'admin', 'MAN', null, null, null, 'ACTIVE');

-- ----------------------------
-- Table structure for `zq_user_dict`
-- ----------------------------
-- DROP TABLE IF EXISTS `zq_user_dict`;
CREATE TABLE `zq_user_dict` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` smallint(6) NOT NULL COMMENT '字典数据类型 ： 记录字典数据使用对象类型  可扩展\n            0： 权限资源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户模块数据字典';

-- ----------------------------
-- Records of zq_user_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `zq_user_permission`
-- ----------------------------
-- DROP TABLE IF EXISTS `zq_user_permission`;
CREATE TABLE `zq_user_permission` (
  `role_id` varchar(32) NOT NULL,
  `perm_id` varchar(32) NOT NULL,
  `id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_4` (`role_id`),
  KEY `FK_Reference_5` (`perm_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`role_id`) REFERENCES `zq_role` (`ID`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`perm_id`) REFERENCES `zq_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='描述角色拥有的权限列表信息';

-- ----------------------------
-- Records of zq_user_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `zq_user_role`
-- ----------------------------
-- DROP TABLE IF EXISTS `zq_user_role`;
CREATE TABLE `zq_user_role` (
  `id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`role_id`),
  KEY `FK_Reference_2` (`user_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`role_id`) REFERENCES `zq_role` (`ID`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_id`) REFERENCES `zq_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zq_user_role
-- ----------------------------
