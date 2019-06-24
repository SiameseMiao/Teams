/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : sshtutorial

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-06-23 22:06:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `father_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '0', '综合', '0');
INSERT INTO `t_category` VALUES ('2', '0', '理科', '0');
INSERT INTO `t_category` VALUES ('3', '2', '国际', '0');
INSERT INTO `t_category` VALUES ('4', '0', '文科', '0');
INSERT INTO `t_category` VALUES ('5', '0', '工科', '0');
INSERT INTO `t_category` VALUES ('6', '0', '艺术', '0');
INSERT INTO `t_category` VALUES ('7', '0', '其他', '0');
INSERT INTO `t_category` VALUES ('8', '1', '国际', '0');
INSERT INTO `t_category` VALUES ('9', '1', '国家', '1');
INSERT INTO `t_category` VALUES ('10', '1', '省', '1');
INSERT INTO `t_category` VALUES ('11', '2', '国家', '0');
INSERT INTO `t_category` VALUES ('12', '2', '省', '1');
INSERT INTO `t_category` VALUES ('13', '4', '国际', '0');
INSERT INTO `t_category` VALUES ('14', '4', '国家', '0');
INSERT INTO `t_category` VALUES ('15', '4', '省', '0');
INSERT INTO `t_category` VALUES ('16', '5', '国际', '0');
INSERT INTO `t_category` VALUES ('17', '5', '国家', '1');
INSERT INTO `t_category` VALUES ('18', '5', '省', '0');
INSERT INTO `t_category` VALUES ('19', '6', '国际', '0');
INSERT INTO `t_category` VALUES ('20', '6', '国家', '0');
INSERT INTO `t_category` VALUES ('21', '6', '省', '0');

-- ----------------------------
-- Table structure for t_competition
-- ----------------------------
DROP TABLE IF EXISTS `t_competition`;
CREATE TABLE `t_competition` (
  `competition_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `competition_createTime` datetime DEFAULT NULL,
  `competition_title` varchar(255) DEFAULT NULL,
  `competition_status` int(11) DEFAULT NULL,
  `competition_updateTime` datetime DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`competition_id`),
  KEY `FK_rqjhrsdn6cdrnxm4qe0q4d8pt` (`category_id`),
  CONSTRAINT `FK_rqjhrsdn6cdrnxm4qe0q4d8pt` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_competition
-- ----------------------------
INSERT INTO `t_competition` VALUES ('3', '高校参赛预报名：9月1日—9月20日\r\n指导思想\r\n为促进高校工程类及工程管理专业学生全面发展，提升学生解决工程管理领域实际问题的能力，上海市工程管理学会特举办第二届上海市工程管理创新大赛。大赛以工程类行业的实际需求为宗旨，要求参赛者将工程领域和管理领域的技能相结合，取得明显的工程应用效果，体现一定的工程管理能力。\r\n活动组织\r\n主办单位：上海市工程管理学会\r\n承办单位：上海理工大学\r\n赞助单位：中国建设第八工程局有限公司\r\n媒体支持：我爱竞赛网\r\n参赛对象\r\n参赛对象为上海各高校在校工程管理本科生和研究生，MEM专业学位研究生及其他各类工科专业本科生和研究生。每个项目组成员不得多于5人，每组至少有1名指导教师。\r\n形式和内容\r\n参赛形式以实践性报告或论文为主。内容可以是专题研究、工程应用（工程管理模型与方法、工程管理方案设计、管理诊断）、工程案例分析等。只要是应用工程管理技术和方法进行工程项目管理创新的作品均可参赛。\r\n报名方式\r\n高校统一参赛报名', '2019-06-13 22:55:03', '第二届上海市工程管理创新大赛', '2', '2019-06-13 22:55:03', '18');
INSERT INTO `t_competition` VALUES ('12', '111', '2019-06-23 16:03:02', '1', '2', '2019-06-23 16:03:02', '8');
INSERT INTO `t_competition` VALUES ('14', '1', '2019-06-23 16:30:07', '1', '2', '2019-06-23 16:31:35', '8');

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(255) DEFAULT NULL,
  `dict_name` varchar(255) DEFAULT NULL,
  `dict_sort` float DEFAULT NULL,
  `dict_status` int(11) DEFAULT NULL,
  `dict_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('1', '001', '综合', '1', '0', '类别');
INSERT INTO `t_dict` VALUES ('2', '010', '理科', '2', '0', '类别');
INSERT INTO `t_dict` VALUES ('3', '011', '文科', '3', '1', '类别');
INSERT INTO `t_dict` VALUES ('4', '100', '工科', '4', '0', '类别');
INSERT INTO `t_dict` VALUES ('5', '101', '艺术', '5', '1', '类别');
INSERT INTO `t_dict` VALUES ('6', '110', '其他', '6', '0', '类别');

-- ----------------------------
-- Table structure for t_premission
-- ----------------------------
DROP TABLE IF EXISTS `t_premission`;
CREATE TABLE `t_premission` (
  `premission_id` bigint(30) NOT NULL,
  `premission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`premission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_premission
-- ----------------------------
INSERT INTO `t_premission` VALUES ('1', 'user:select');
INSERT INTO `t_premission` VALUES ('2', 'user:read');
INSERT INTO `t_premission` VALUES ('3', 'user:save');
INSERT INTO `t_premission` VALUES ('4', 'user:update');
INSERT INTO `t_premission` VALUES ('5', 'user:delete');
INSERT INTO `t_premission` VALUES ('6', 'file:upload');
INSERT INTO `t_premission` VALUES ('7', 'file:download');
INSERT INTO `t_premission` VALUES ('8', 'competition:select');
INSERT INTO `t_premission` VALUES ('9', 'competition:save');
INSERT INTO `t_premission` VALUES ('10', 'competition:delete');
INSERT INTO `t_premission` VALUES ('11', 'competition:update');
INSERT INTO `t_premission` VALUES ('12', 'dict:select');
INSERT INTO `t_premission` VALUES ('13', 'dict:update');
INSERT INTO `t_premission` VALUES ('14', 'dict:delete');
INSERT INTO `t_premission` VALUES ('15', 'dict:save');
INSERT INTO `t_premission` VALUES ('16', 'file:delete');
INSERT INTO `t_premission` VALUES ('17', 'category:select');
INSERT INTO `t_premission` VALUES ('18', 'category:save');
INSERT INTO `t_premission` VALUES ('19', 'category:update');
INSERT INTO `t_premission` VALUES ('20', 'category:delete');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` bigint(30) DEFAULT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'manager');
INSERT INTO `t_role` VALUES ('2', 'user');

-- ----------------------------
-- Table structure for t_role_premission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_premission`;
CREATE TABLE `t_role_premission` (
  `id` bigint(30) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `premission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_premission
-- ----------------------------
INSERT INTO `t_role_premission` VALUES ('1', 'manager', 'user:select');
INSERT INTO `t_role_premission` VALUES ('2', 'manager', 'user:read');
INSERT INTO `t_role_premission` VALUES ('3', 'manager', 'user:write');
INSERT INTO `t_role_premission` VALUES ('4', 'manager', 'user:update');
INSERT INTO `t_role_premission` VALUES ('5', 'user', 'user:read');
INSERT INTO `t_role_premission` VALUES ('6', 'manager', 'user:delete');
INSERT INTO `t_role_premission` VALUES ('7', 'manager', 'file:upload');
INSERT INTO `t_role_premission` VALUES ('8', 'manager', 'file:download');
INSERT INTO `t_role_premission` VALUES ('9', 'manager', 'competition:select');
INSERT INTO `t_role_premission` VALUES ('10', 'manager', 'competition:save');
INSERT INTO `t_role_premission` VALUES ('11', 'manager', 'competition:delete');
INSERT INTO `t_role_premission` VALUES ('12', 'manager', 'competition:update');
INSERT INTO `t_role_premission` VALUES ('13', 'manager', 'dict:select');
INSERT INTO `t_role_premission` VALUES ('14', 'manager', 'dict:update');
INSERT INTO `t_role_premission` VALUES ('15', 'manager', 'dict:delete');
INSERT INTO `t_role_premission` VALUES ('16', 'manager', 'dict:save');
INSERT INTO `t_role_premission` VALUES ('17', 'manager', 'file:delete');
INSERT INTO `t_role_premission` VALUES ('18', 'manager', 'category:select');
INSERT INTO `t_role_premission` VALUES ('19', 'manager', 'category:save');
INSERT INTO `t_role_premission` VALUES ('20', 'manager', 'category:delete');
INSERT INTO `t_role_premission` VALUES ('21', 'manager', 'category:update');

-- ----------------------------
-- Table structure for t_store
-- ----------------------------
DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store` (
  `Store_pkID` int(11) NOT NULL AUTO_INCREMENT,
  `Store_desStore` varchar(255) DEFAULT NULL,
  `Store_name` varchar(255) DEFAULT NULL,
  `Store_storageType` int(11) DEFAULT NULL,
  `Store_store` int(11) DEFAULT NULL,
  PRIMARY KEY (`Store_pkID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_store
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `user_phone` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `isRememberMe` bit(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('13', 'root', 'ff9830c42660c1dd1942844f8069b74a', '15720061118', '1114624206@qq.com', '\0');
INSERT INTO `t_user` VALUES ('16', '1', '6512bd43d9caa6e02c990b0a82652dca', '123213', '21312321', '\0');
INSERT INTO `t_user` VALUES ('19', '2', 'b6d767d2f8ed5d21a44b0e5886680cb9', '2', '2', '\0');
INSERT INTO `t_user` VALUES ('20', '3', '182be0c5cdcd5072bb1864cdee4d3d6e', '3', '3', '\0');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(30) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', 'root', 'manager');
INSERT INTO `t_user_role` VALUES ('2', '1', 'user');
INSERT INTO `t_user_role` VALUES ('3', '2', 'user');
INSERT INTO `t_user_role` VALUES ('4', '3', 'user');
