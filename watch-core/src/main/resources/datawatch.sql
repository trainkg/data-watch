/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : datawatch

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2015-09-11 17:47:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `alarmtype`
-- ----------------------------
DROP TABLE IF EXISTS `alarmtype`;
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
INSERT INTO `alarmtype` VALUES ('1', '0', '0x0002', '安全门未关');
INSERT INTO `alarmtype` VALUES ('2', '0', '0x0004', '请开安全门');
INSERT INTO `alarmtype` VALUES ('3', '0', '0x0008', '放开手动/急停键');
INSERT INTO `alarmtype` VALUES ('4', '0', '0x0010', '油温偏差');
INSERT INTO `alarmtype` VALUES ('5', '0', '0x0020', '全程未定时完成');
INSERT INTO `alarmtype` VALUES ('6', '0', '0x0040', '加热器电流错误');
INSERT INTO `alarmtype` VALUES ('7', '0', '0x0080', '脱模未到定位');
INSERT INTO `alarmtype` VALUES ('8', '0', '0x0100', '射出监控失败');
INSERT INTO `alarmtype` VALUES ('9', '0', '0x0200', '射出防护罩未关');
INSERT INTO `alarmtype` VALUES ('10', '0', '0x0400', '机械手失败');
INSERT INTO `alarmtype` VALUES ('11', '0', '0x0800', '开模数已到');
INSERT INTO `alarmtype` VALUES ('12', '0', '0x1000', '开模未到定位');
INSERT INTO `alarmtype` VALUES ('13', '0', '0x2000', '脱模失败');
INSERT INTO `alarmtype` VALUES ('14', '0', '0x4000', '储料未定时完成');
INSERT INTO `alarmtype` VALUES ('15', '0', '0x8000', '关模未到定位');
INSERT INTO `alarmtype` VALUES ('16', '1', '0x0001', '位置设定不良');
INSERT INTO `alarmtype` VALUES ('17', '1', '0x0002', '完成自动调模');
INSERT INTO `alarmtype` VALUES ('18', '1', '0x0004', '润滑油位偏差');
INSERT INTO `alarmtype` VALUES ('19', '1', '0x0008', '射出启位置偏差');
INSERT INTO `alarmtype` VALUES ('20', '1', '0x0010', '储料转数偏差');
INSERT INTO `alarmtype` VALUES ('21', '1', '0x0020', '射出时间偏差');
INSERT INTO `alarmtype` VALUES ('22', '1', '0x0040', '开模一慢未定位');
INSERT INTO `alarmtype` VALUES ('23', '1', '0x0080', '关模保护失败');
INSERT INTO `alarmtype` VALUES ('24', '1', '0x0100', '射退终未到定位');
INSERT INTO `alarmtype` VALUES ('25', '1', '0x0200', '储料终未到定位');
INSERT INTO `alarmtype` VALUES ('26', '1', '0x0400', '开模装数己到');
INSERT INTO `alarmtype` VALUES ('27', '1', '0x0800', '中子未到定位');
INSERT INTO `alarmtype` VALUES ('28', '1', '0x1000', '机械安全异常');
INSERT INTO `alarmtype` VALUES ('29', '1', '0x2000', '润滑检出失败');
INSERT INTO `alarmtype` VALUES ('30', '1', '0x4000', '油量检出失败');
INSERT INTO `alarmtype` VALUES ('31', '1', '0x8000', '滤网检出失败');
INSERT INTO `alarmtype` VALUES ('32', '0', '0x0001', '温度偏差');

-- ----------------------------
-- Table structure for `machinfor`
-- ----------------------------
DROP TABLE IF EXISTS `machinfor`;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of machinfor
-- ----------------------------
INSERT INTO `machinfor` VALUES ('1', null, '00:e0:a0:00:25:8d', '192.168.199.253', '7514', null, '65535', '65535', '1', '0', '0', '3', '1', '3', '1', '3', '1', '3', '0', '0', '305', '41', '305', '41', '305', '41', '305', '41', '0', '41', '2243', '1745', '1745', '0', '0', '0', '0', '0', null, null, null, null, null, null, null);
INSERT INTO `machinfor` VALUES ('2', null, '00:0c:29:bf:6b:9b', '192.168.199.111', '7514', null, '4', '5', '1', '2', '3', '0', '51201', '0', '51201', '0', '51201', '0', '0', '1247', '306', '42', '306', '42', '306', '42', '306', '0', '0', '51201', '2741', '0', '0', '0', '0', '0', '0', '0', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `opermode`
-- ----------------------------
DROP TABLE IF EXISTS `opermode`;
CREATE TABLE `opermode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` char(255) CHARACTER SET gbk COLLATE gbk_bin DEFAULT NULL,
  `name` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of opermode
-- ----------------------------
INSERT INTO `opermode` VALUES ('1', '0x0001', '自动');
INSERT INTO `opermode` VALUES ('2', '0x0002', '半自动');
INSERT INTO `opermode` VALUES ('3', '0x0004', '电眼自动');
INSERT INTO `opermode` VALUES ('4', '0x0008', '时间自动');
INSERT INTO `opermode` VALUES ('5', '0x0010', '粗调模');
INSERT INTO `opermode` VALUES ('6', '0x0020', '微动调模');
INSERT INTO `opermode` VALUES ('7', '0x0040', '位置设定');
INSERT INTO `opermode` VALUES ('8', '0x0080', '自动清料');
INSERT INTO `opermode` VALUES ('9', '0x0800', '自动调模');
INSERT INTO `opermode` VALUES ('10', '0x0000', '手动');

-- ----------------------------
-- Table structure for `operstepmode`
-- ----------------------------
DROP TABLE IF EXISTS `operstepmode`;
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
INSERT INTO `operstepmode` VALUES ('1', '0', '0x0002', '压模');
INSERT INTO `operstepmode` VALUES ('2', '0', '0x0004', '开模');
INSERT INTO `operstepmode` VALUES ('3', '0', '0x0008', '射出');
INSERT INTO `operstepmode` VALUES ('4', '0', '0x0010', '射退');
INSERT INTO `operstepmode` VALUES ('5', '0', '0x0020', '储料');
INSERT INTO `operstepmode` VALUES ('6', '0', '0x0040', '座台进');
INSERT INTO `operstepmode` VALUES ('7', '0', '0x0080', '座台退');
INSERT INTO `operstepmode` VALUES ('8', '0', '0x0100', '脱模进');
INSERT INTO `operstepmode` VALUES ('9', '0', '0x0200', '脱模退');
INSERT INTO `operstepmode` VALUES ('10', '0', '0x0400', '中子进');
INSERT INTO `operstepmode` VALUES ('11', '0', '0x0800', '中子退');
INSERT INTO `operstepmode` VALUES ('12', '0', '0x1000', '调模进');
INSERT INTO `operstepmode` VALUES ('13', '0', '0x2000', '调模退');
INSERT INTO `operstepmode` VALUES ('14', '0', '0x4000', '保压');
INSERT INTO `operstepmode` VALUES ('15', '0', '0x0001', '关模');

-- ----------------------------
-- Table structure for `pctype`
-- ----------------------------
DROP TABLE IF EXISTS `pctype`;
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
