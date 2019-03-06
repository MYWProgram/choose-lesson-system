/*
Navicat MySQL Data Transfer

Source Server         : Connect
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : ten

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2017-06-16 12:01:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CNo` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(30) NOT NULL,
  `Ccredit` float(5,1) DEFAULT '0.0',
  PRIMARY KEY (`CNo`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '离散数学', '5.5');
INSERT INTO `course` VALUES ('4', '大学英语', '4.0');
INSERT INTO `course` VALUES ('5', '编译原理', '5.0');
INSERT INTO `course` VALUES ('6', '计算机网络', '2.5');
INSERT INTO `course` VALUES ('7', '数据结构', '3.0');
INSERT INTO `course` VALUES ('11', '大学物理', '3.5');
INSERT INTO `course` VALUES ('14', '人机交互', '3.0');
INSERT INTO `course` VALUES ('15', '网页设计', '2.0');
INSERT INTO `course` VALUES ('16', '物联网', '2.5');
INSERT INTO `course` VALUES ('18', '生物制药', '2.0');

-- ----------------------------
-- Table structure for `sc`
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `SNo` int(11) NOT NULL,
  `CNo` int(11) NOT NULL,
  `classroom` varchar(11) DEFAULT '0.0',
  PRIMARY KEY (`SNo`,`CNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('1', '2', '0.0');
INSERT INTO `sc` VALUES ('1', '3', '0.0');
INSERT INTO `sc` VALUES ('1', '5', '0');
INSERT INTO `sc` VALUES ('1', '6', '0');
INSERT INTO `sc` VALUES ('1', '7', '0');
INSERT INTO `sc` VALUES ('1514010918', '1', '0.0');
INSERT INTO `sc` VALUES ('1514010918', '7', '0.0');
INSERT INTO `sc` VALUES ('1514010919', '6', '11505H');
INSERT INTO `sc` VALUES ('1514010924', '1', '0.0');
INSERT INTO `sc` VALUES ('1514010924', '6', '0.0');
INSERT INTO `sc` VALUES ('1514010924', '7', '0.0');
INSERT INTO `sc` VALUES ('1514010924', '11', '0.0');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `SNo` int(11) NOT NULL AUTO_INCREMENT,
  `Sname` varchar(30) NOT NULL,
  `Spassword` varchar(30) NOT NULL,
  `Sclass` varchar(30) DEFAULT '',
  `Ssex` varchar(10) DEFAULT '',
  PRIMARY KEY (`SNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1514010926 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '呆呆', '0', '1', '1');
INSERT INTO `student` VALUES ('1514010918', '闫宇浩', '000000', '15140X04', '男');
INSERT INTO `student` VALUES ('1514010919', '刘琪', '123456', '15140X04', '男');
INSERT INTO `student` VALUES ('1514010924', '于强', '456253', '15140X04', '男');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `TNo` int(11) NOT NULL AUTO_INCREMENT,
  `Tname` varchar(30) DEFAULT NULL,
  `Tpassword` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '张森玮', '0');
