/*
 Navicat Premium Data Transfer

 Source Server         : mySQL
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : huoa

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 11/07/2020 20:06:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auditing
-- ----------------------------
DROP TABLE IF EXISTS `auditing`;
CREATE TABLE `auditing`  (
  `auditid` int(10) NOT NULL AUTO_INCREMENT,
  `expid` int(10) NULL DEFAULT NULL,
  `empid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `auditdesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`auditid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auditing
-- ----------------------------
INSERT INTO `auditing` VALUES (1, 3, 'hu', '通过', NULL, '2020-07-11');
INSERT INTO `auditing` VALUES (2, 3, 'hu', '通过', NULL, '2020-07-11');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptno` int(3) NOT NULL,
  `deptname` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '总裁处', '301');
INSERT INTO `dept` VALUES (2, '顾问', '302');
INSERT INTO `dept` VALUES (3, '人事处', '303');
INSERT INTO `dept` VALUES (4, '财经处', '304');
INSERT INTO `dept` VALUES (5, '技术处', '305');
INSERT INTO `dept` VALUES (6, '行政处', '306');

-- ----------------------------
-- Table structure for duty
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty`  (
  `dtid` int(10) NOT NULL AUTO_INCREMENT,
  `empid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dtdate` date NULL DEFAULT NULL,
  `signintime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `signouttime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dtid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of duty
-- ----------------------------
INSERT INTO `duty` VALUES (1, 'yue', '2019-12-13', '11:02:18', '11:04:19');
INSERT INTO `duty` VALUES (2, 'yue', '2020-01-01', '12:00:00', '12:00:00');
INSERT INTO `duty` VALUES (3, 'hu', '2020-06-02', '12:00:00', NULL);
INSERT INTO `duty` VALUES (4, '张三丰', '2020-06-11', '07:31:24', '07:43:05');
INSERT INTO `duty` VALUES (5, '张三丰', '2020-06-15', '18:23:39', '18:23:42');
INSERT INTO `duty` VALUES (6, '张三丰', '2020-06-27', '08:51:47', NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `empid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deptno` int(3) NULL DEFAULT NULL,
  `posid` int(5) NULL DEFAULT NULL,
  `mgrid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realname` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthdate` date NULL DEFAULT NULL,
  `hiredate` date NULL DEFAULT NULL,
  `leavedate` date NULL DEFAULT NULL,
  `onduty` int(1) NULL DEFAULT NULL,
  `emptype` int(1) NULL DEFAULT NULL,
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emercontactperson` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`empid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('hu', '63330605a7649608bcf3936fbaaed778', 2, 2, 'yue', '胡某', '男', '1999-01-01', '2019-12-01', NULL, 1, 2, '17615587653', '213438989', '父亲，电话17786743210', '410521199901010202');
INSERT INTO `employee` VALUES ('wang', '63330605a7649608bcf3936fbaaed778', 2, 2, 'hu', '王飞', '男', '1999-01-01', '2020-01-01', NULL, 1, 1, '17615587643', '543437743', '家人，电话17786743211', '410521199901010109');
INSERT INTO `employee` VALUES ('yue', '63330605a7649608bcf3936fbaaed778', 1, 1, NULL, '岳菲', '男', '1999-01-01', '2020-01-01', NULL, 1, 2, '17615587653', '213437743', '父亲，电话17786743211', '410521199901010303');
INSERT INTO `employee` VALUES ('张三丰', '63330605a7649608bcf3936fbaaed778', 3, 3, 'hu', '张三', '女', '2020-05-30', '2020-07-10', NULL, 1, 1, '17629531827', '2440181011', '<p>qqq<br></p>', '4105211990888');
INSERT INTO `employee` VALUES ('张麻子', '63330605a7649608bcf3936fbaaed778', 3, 1, 'hu', '姜茶', '男', '2020-05-30', '2020-07-10', NULL, 1, 1, '17629531314', '233023712', '<p>确认<br></p>', '4105211990888');

-- ----------------------------
-- Table structure for expense
-- ----------------------------
DROP TABLE IF EXISTS `expense`;
CREATE TABLE `expense`  (
  `expid` int(11) NOT NULL AUTO_INCREMENT,
  `empid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报销人编号',
  `totalamount` double(10, 2) NULL DEFAULT NULL,
  `exptime` date NULL DEFAULT NULL,
  `expdesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nextauditor` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastResult` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0：新创建  1：审核中   2 审核结束通过  3 审核拒绝  4 审核打回   5.已打款',
  PRIMARY KEY (`expid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expense
-- ----------------------------
INSERT INTO `expense` VALUES (1, '张三丰', 1110.00, '2019-01-01', '总备注信息', 'hu', '处理完', '5');
INSERT INTO `expense` VALUES (2, 'wang', 4220.00, '2020-05-31', '京东购物快乐618', 'hu', '通过', '1');
INSERT INTO `expense` VALUES (3, '张三丰', 1222.00, '2020-06-29', '没有', 'hu', '通过', '2');

-- ----------------------------
-- Table structure for expenseitem
-- ----------------------------
DROP TABLE IF EXISTS `expenseitem`;
CREATE TABLE `expenseitem`  (
  `itemid` int(10) NOT NULL AUTO_INCREMENT,
  `expid` int(10) NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amount` double(7, 2) NULL DEFAULT NULL,
  `itemdesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`itemid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expenseitem
-- ----------------------------
INSERT INTO `expenseitem` VALUES (1, 1, '2', 1000.00, '费用描述一');
INSERT INTO `expenseitem` VALUES (2, 1, '2', 10.00, '费用描述二');
INSERT INTO `expenseitem` VALUES (3, 1, '4', 10.00, '说明描述二');
INSERT INTO `expenseitem` VALUES (4, 2, '2', 220.00, '买了一个MP3花了220');
INSERT INTO `expenseitem` VALUES (5, 2, '3', 2000.00, '公司新进一批手套');
INSERT INTO `expenseitem` VALUES (6, 2, '5', 2000.00, '你猜');
INSERT INTO `expenseitem` VALUES (7, 3, '1', 1110.00, '没有');

-- ----------------------------
-- Table structure for expimage
-- ----------------------------
DROP TABLE IF EXISTS `expimage`;
CREATE TABLE `expimage`  (
  `imgid` int(10) NOT NULL AUTO_INCREMENT,
  `expid` int(10) NULL DEFAULT NULL,
  `realname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filetype` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`imgid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of expimage
-- ----------------------------
INSERT INTO `expimage` VALUES (1, 1, 'SVN3.jpg', '41cef505-384d-47b3-8dd5-1614f024eb0b.jpg', 'image/jpeg');
INSERT INTO `expimage` VALUES (2, 2, 'SVN1.jpg', '065b4854-6e78-4002-8d92-855691c5cf41.jpg', 'image/jpeg');
INSERT INTO `expimage` VALUES (7, 3, 'SVN3.jpg', '4ad854ed-c56e-4ee3-8b41-bb7c6efbd3fc.jpg', 'image/jpeg');

-- ----------------------------
-- Table structure for income
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income`  (
  `icid` int(10) NOT NULL,
  `amount` int(10) NULL DEFAULT NULL,
  `icdate` date NULL DEFAULT NULL,
  `ictype` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `indesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`icid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES (1, 1000, '2020-07-09', '科研', '11', 'hu');
INSERT INTO `income` VALUES (2, 1293, '2020-05-08', '项目开发', '12', 'hu');
INSERT INTO `income` VALUES (3, 1203, '2019-07-01', '外包', '12', 'hu');
INSERT INTO `income` VALUES (4, 2383, '2020-06-07', '出厂唱片', '21', 'yue');
INSERT INTO `income` VALUES (5, 2232, '2020-02-09', '合作投资', '22', 'yue');
INSERT INTO `income` VALUES (6, 1212, '2020-02-09', '小本惠利', '23', 'yue');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `pid` int(10) NOT NULL,
  `payempid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amount` float(10, 2) NULL DEFAULT NULL,
  `paytime` date NULL DEFAULT NULL,
  `expid` int(10) NULL DEFAULT NULL,
  `empid` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (1, 'wang', 2220.00, '2020-07-09', 1, 'yue');
INSERT INTO `payment` VALUES (2, '张三丰', 1110.00, '2020-07-10', 2, 'hu');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `posid` int(5) NOT NULL,
  `pname` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pdesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`posid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '总裁', '公司最大的boss');
INSERT INTO `position` VALUES (2, '总裁助理', '协助总裁工作，工作的重点包括参谋、建议、 执行、协调、辅助管理等。 总裁助理岗位职责');
INSERT INTO `position` VALUES (3, '人力资源总监', '根据公司发展战略，组织制定人力资源战略规划\r\n，\r\n参与公司重大人事决策。\r\n根据公司发展战略，组织制定人力资源战略规划\r\n，\r\n参与公司重大人事决策。\r\n');
INSERT INTO `position` VALUES (4, '销售总监', '依据公司发展战略，以公司年度工作计划为标准，制定本部门年度工作计划及实施方案，整合部门现有资源进行年度目标分解，并监督跟踪完成进度，确保部门年度工作计划的完成');
INSERT INTO `position` VALUES (5, '技术总监', '负责组织和领导公司的产品开发、技术改良，建立公司质量管理体系并组织实施，确保公司产品开发满足市场需求，并保证公司产品达到目标质量水平');
INSERT INTO `position` VALUES (6, '总裁办主任', '为了给集团的发展提供良好的支持与保障，在集团公司相关政策和规范的指引下，领导本部门人员建立健全为经营活动服务的支持和保障体系，完成集团下达的各项管理工作目标。');
INSERT INTO `position` VALUES (7, '财务总监', '依据集团发展战略，健全集团各项财务管理制度和内控制度，建设符合上市公司合规要求的内控体系。组织领导集团的各项财务管理工作');
INSERT INTO `position` VALUES (8, '生产总监', '协助总经理组织、制定并执行公司生产战略计划，组织、管理、控制和监督生产系统，以实现公司生产目标。');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `typeid` int(11) NOT NULL,
  `typedesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`typeid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '通信费用');
INSERT INTO `type` VALUES (2, '办公室耗材');
INSERT INTO `type` VALUES (3, '住宿费用');
INSERT INTO `type` VALUES (4, '房租水电');
INSERT INTO `type` VALUES (5, '其他');



SET FOREIGN_KEY_CHECKS = 1;
