/*
 Navicat Premium Data Transfer

 Source Server         : home
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : peopleboot

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 02/02/2023 23:14:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checking
-- ----------------------------
DROP TABLE IF EXISTS `checking`;
CREATE TABLE `checking`  (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  `start_time` datetime(0) NULL DEFAULT NULL,
  `close_time` datetime(0) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否签到',
  `e_id` int NULL DEFAULT NULL COMMENT '员工',
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `c_e_fk`(`e_id`) USING BTREE,
  CONSTRAINT `c_e_fk` FOREIGN KEY (`e_id`) REFERENCES `employee` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checking
-- ----------------------------
INSERT INTO `checking` VALUES (7, '日常考勤1212', '2023-01-03 00:00:00', '2023-01-03 00:00:00', NULL, 9);
INSERT INTO `checking` VALUES (8, 'test2', '2023-01-03 00:00:00', '2023-01-03 00:00:00', NULL, 11);
INSERT INTO `checking` VALUES (9, '测试', '2023-01-03 00:00:00', '2023-01-03 00:00:00', NULL, 8);
INSERT INTO `checking` VALUES (10, '普通打卡', '2023-01-05 00:00:00', '2023-01-05 00:00:00', NULL, 7);
INSERT INTO `checking` VALUES (13, 'daily', '2023-01-05 00:00:00', '2023-01-05 00:00:00', NULL, 6);
INSERT INTO `checking` VALUES (14, 'kqr', '2023-01-05 00:00:00', '2023-01-05 00:00:00', NULL, 9);

-- ----------------------------
-- Table structure for emolument
-- ----------------------------
DROP TABLE IF EXISTS `emolument`;
CREATE TABLE `emolument`  (
  `em_id` int NOT NULL AUTO_INCREMENT,
  `e_id` int NULL DEFAULT NULL,
  `should_pay` decimal(10, 0) NULL DEFAULT NULL,
  `take_home_pay` decimal(10, 0) NULL DEFAULT NULL,
  `tech_ability_pay` decimal(10, 0) NULL DEFAULT NULL,
  `seniority_pay` decimal(10, 0) NULL DEFAULT NULL,
  `skills_pay` decimal(10, 0) NULL DEFAULT NULL,
  `apprentice_pay` decimal(10, 0) NULL DEFAULT NULL,
  `off_duty_pay` decimal(10, 0) NULL DEFAULT NULL,
  `living_pay` decimal(10, 0) NULL DEFAULT NULL,
  `endowment_insurance_pay` decimal(10, 0) NULL DEFAULT NULL,
  `medical_insurance_pay` decimal(10, 0) NULL DEFAULT NULL,
  `large_ill_medical_pay` decimal(10, 0) NULL DEFAULT NULL,
  `enter_price_pay` decimal(10, 0) NULL DEFAULT NULL,
  `accumulation_pay` decimal(10, 0) NULL DEFAULT NULL,
  `personal_pay` decimal(10, 0) NULL DEFAULT NULL,
  `water_power_pay` decimal(10, 0) NULL DEFAULT NULL,
  `additation_pay` decimal(10, 0) NULL DEFAULT NULL,
  `deduct_pay` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`em_id`) USING BTREE,
  INDEX `fk_eid`(`e_id`) USING BTREE,
  CONSTRAINT `fk_eid` FOREIGN KEY (`e_id`) REFERENCES `employee` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emolument
-- ----------------------------
INSERT INTO `emolument` VALUES (3, 3, 1231, 132, 1200, 2001, 1331, 23, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200);
INSERT INTO `emolument` VALUES (5, 6, 300, 300, 300, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200);
INSERT INTO `emolument` VALUES (6, 11, 1000, 2000, 100, 4, 4, 5, 5, 66, 77, 88, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `emolument` VALUES (9, 7, 10000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `emolument` VALUES (10, 8, 2000, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `e_id` int NOT NULL AUTO_INCREMENT,
  `e_name` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `nation` varchar(8) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `politics_status` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `native_place` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `iden_num` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `phone_num` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `e_password` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `archives_place` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `r_id` int NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`e_id`) USING BTREE,
  INDEX `fk_emp_role`(`r_id`) USING BTREE,
  CONSTRAINT `fk_emp_role` FOREIGN KEY (`r_id`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (3, 'lihua', '男', 'https://edu-avatar2.oss-cn-hangzhou.aliyuncs.com/2022/11/11/10a0382354cc4257bb1efd5b4005cee5file.png', '汉', '2001-10-20', '共青团员', '上海浦东', '120223200110203452', '16762666162', '121212', '公司人事部', 2, '33@qq.com');
INSERT INTO `employee` VALUES (4, 'dragon', '女', 'https://edu-avatar2.oss-cn-hangzhou.aliyuncs.com/2022/11/11/10a0382354cc4257bb1efd5b4005cee5file.png', '汉', '1990-10-20', '群众', '浙江绍兴', '320112199010203423', '15517266723', '202020', '公司人事部', 4, '44@qq.com');
INSERT INTO `employee` VALUES (6, '1', '1', 'https://hangsbucket.oss-cn-hangzhou.aliyuncs.com/2022/11/18/58f1efa239a146849bf19918fdd38014file.png', '汉', '2005-01-04', '共青团员', '河南郑州', '122223333', '1', NULL, NULL, NULL, '1');
INSERT INTO `employee` VALUES (7, 'dragon', '女', 'https://edu-avatar2.oss-cn-hangzhou.aliyuncs.com/2022/11/11/10a0382354cc4257bb1efd5b4005cee5file.png', '汉', '1990-10-20', '群众', '广东广州', '320112199010203423', '15517266723', '202020', '公司人事部', NULL, '44@qq.com');
INSERT INTO `employee` VALUES (8, 'zhangfei', '男', 'https://edu-avatar2.oss-cn-hangzhou.aliyuncs.com/2022/11/11/10a0382354cc4257bb1efd5b4005cee5file.png', '汉', '1998-10-20', '中共党员', '北京', '11021219981020111111', '15122312261', '111111', '朝阳区人才市场', NULL, '22@qq.com');
INSERT INTO `employee` VALUES (9, '新员工', '男', 'https://hangsbucket.oss-cn-hangzhou.aliyuncs.com/2022/11/18/a340092931f3448481f20dc94ba00e53file.png', '汉', '2023-01-11', 'test11', '深圳', '2615527373', '17662532551', NULL, NULL, NULL, '555@qq.com');
INSERT INTO `employee` VALUES (11, '陈奕迅', '男', 'https://hangsbucket.oss-cn-hangzhou.aliyuncs.com/2023/01/02/81714007c90f4a128d44390984e4a0eafile.png', '汉', '2015-01-06', 'test32', '汉', '1234', '1234', NULL, NULL, NULL, '1234');
INSERT INTO `employee` VALUES (12, 'ceshi', '男', 'https://hangsbucket.oss-cn-hangzhou.aliyuncs.com/2023/01/08/092c5657046140419ae5b8b8ff414513file.png', '汉', '2016-01-03', 'test44', 'hn', '653356', '21147475', NULL, NULL, NULL, '3664');
INSERT INTO `employee` VALUES (14, '123', '11', 'https://hangsbucket.oss-cn-hangzhou.aliyuncs.com/2023/01/09/d5e61c8da67d42dfb746540557f3ac65file.png', '122', '2000-08-08', '12', '111', '11', '122', '12334', NULL, NULL, '12');

-- ----------------------------
-- Table structure for jlevel
-- ----------------------------
DROP TABLE IF EXISTS `jlevel`;
CREATE TABLE `jlevel`  (
  `jlevel_id` int NOT NULL AUTO_INCREMENT,
  `jlevel_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `jdescription` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jlevel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jlevel
-- ----------------------------
INSERT INTO `jlevel` VALUES (1, 'P14', '资深科学家');
INSERT INTO `jlevel` VALUES (2, 'P13', '科学家');
INSERT INTO `jlevel` VALUES (3, 'P12', '资深研究员');
INSERT INTO `jlevel` VALUES (4, 'P11', '高级研究员');
INSERT INTO `jlevel` VALUES (5, 'P10', '研究员');
INSERT INTO `jlevel` VALUES (6, 'P9', '资深专家');
INSERT INTO `jlevel` VALUES (7, 'P8', '高级专家');
INSERT INTO `jlevel` VALUES (8, 'P7', '专家');
INSERT INTO `jlevel` VALUES (9, 'P6', '高级工程师');
INSERT INTO `jlevel` VALUES (10, 'P5', '中级工程师');
INSERT INTO `jlevel` VALUES (11, 'P4', '初级工程师');
INSERT INTO `jlevel` VALUES (12, 'M10', '董事长');
INSERT INTO `jlevel` VALUES (13, 'M9', '副董事长');
INSERT INTO `jlevel` VALUES (14, 'M8', '执行副总裁');
INSERT INTO `jlevel` VALUES (15, 'M7', '资深副总裁');
INSERT INTO `jlevel` VALUES (16, 'M6', '副总裁');
INSERT INTO `jlevel` VALUES (17, 'M5', '资深总管');
INSERT INTO `jlevel` VALUES (18, 'M4', '总监');
INSERT INTO `jlevel` VALUES (19, 'M3', '资深经理');
INSERT INTO `jlevel` VALUES (20, 'M2', '经理');
INSERT INTO `jlevel` VALUES (21, 'M1', '主管');

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance`  (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `e_id` int NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE,
  INDEX `p_e_id_fk`(`e_id`) USING BTREE,
  CONSTRAINT `p_e_id_fk` FOREIGN KEY (`e_id`) REFERENCES `employee` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of performance
-- ----------------------------
INSERT INTO `performance` VALUES (2, 9, '工作绩效22', '2023-01-04 00:00:00');
INSERT INTO `performance` VALUES (3, 11, '日常績效', '2023-01-05 00:00:00');
INSERT INTO `performance` VALUES (4, 7, '績效測試數據', '2023-01-07 00:00:00');
INSERT INTO `performance` VALUES (6, 11, '优秀员工', '2023-01-09 00:00:00');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `r_id` int NOT NULL AUTO_INCREMENT,
  `r_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `func` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `jlevel_id` int NULL DEFAULT NULL,
  `unit_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`r_id`) USING BTREE,
  INDEX `fk_role_jlevel`(`jlevel_id`) USING BTREE,
  INDEX `fk_role_unit`(`unit_id`) USING BTREE,
  CONSTRAINT `fk_role_jlevel` FOREIGN KEY (`jlevel_id`) REFERENCES `jlevel` (`jlevel_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_role_unit` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`unit_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '总经理', '制定和实施公司总体战略与年度经营计划；建立良好的沟通渠道；建立和健全公司的管理体系与组织结构，建设高效的组织团队；主持公司的日常经营管理工作，实现公司经营管理目标和发展目标', 1, 1);
INSERT INTO `role` VALUES (2, '副总经理', '协助总经理制定并实施公司发展战略、经营计划等，完成公司的经营管理目标及发展目标。', 2, 1);
INSERT INTO `role` VALUES (3, '总经理助理', '协助总经理制定、贯彻、落实各项经营发展战略、计划，实现企业经营管理目标', 3, 1);
INSERT INTO `role` VALUES (4, '财务总监', '负责公司财务战略的制定、财务管理以及内部控制工作，筹集公司运营所需资金，完成企业财务计划。', 4, 1);
INSERT INTO `role` VALUES (5, '人资总监', '规划、指导、协调公司的人力资源管理与组织建设，保证公司人力资源供给和人力资源高效利用，促进公司经营目标的实现和长远发展。', 4, 1);
INSERT INTO `role` VALUES (6, '市场总监', '规划制定公司的市场战略与策略，并推进实施，完成市场发展目标；维护公司品牌，提升品牌知名度与美誉度。', 4, 1);
INSERT INTO `role` VALUES (7, '销售总监', '规划并推进实施全面的销售战略、销售规划方案，有效管理客户，实现公司下达销售业务指标。', 5, 1);
INSERT INTO `role` VALUES (8, '营销总监', '规划并推进市场营销战略与策略，实现公司各项年度经营指标。', 5, 1);
INSERT INTO `role` VALUES (9, '运营总监', '策划推进公司的业务运营战略、流程与计划，组织协调公司各部门执行、实现公司的运营目标。', 5, 1);
INSERT INTO `role` VALUES (10, '技术总监', '全面主持公司研发与技术管理工作，规划公司的技术发展路线与新产品开发，实现公司的技术创新目标。', 5, 1);
INSERT INTO `role` VALUES (11, '生产总监', '组织制定并执行公司生产战略计划，组织、管理、控制和监督生产系统，以完成公司生产目标。', 5, 1);
INSERT INTO `role` VALUES (12, '财务经理', '主持公司财务预决算、财务核算、会计监督和财务管理工作；组织协调、指导监督财务部日常管理工作，监督执行财务计划，完成公司财务目标。', 6, 2);
INSERT INTO `role` VALUES (13, '会计总管', '分析、研究会计数据，准备财务报告，向管理层提供财务信息；具体执行资金预算及控制预算内的经费支出、财务会计档案管理、工资及管理费用核算与管理、固定资产管理、社保基金管理等。', 6, 2);
INSERT INTO `role` VALUES (14, '预算总管', '建立完善全面的预算计划并协助控制计划的执行，完成预算指标。', 6, 2);
INSERT INTO `role` VALUES (15, '成本控制主管', '制定全面的成本控制计划，实现成本控制目标，向管理层提供成本信息和改进意见。', 6, 2);
INSERT INTO `role` VALUES (16, '出纳', '负责现金收支、银行存款、票据结算、税款的收付及记账、结账等业务的处理，并确保业务操作的规范性、合法性。', 6, 2);
INSERT INTO `role` VALUES (17, '人力资源经理', '协助制定、组织实施公司人力资源战略，建设发展人力资源各项构成体系，最大限度地开发人力资源，为实现公司经营发展战略目标提供人力保障。', 6, 3);
INSERT INTO `role` VALUES (18, '绩效考核主管', '组织实施公司全员绩效评价制度及年度评价工作，保证评价工作的及时性和质量。', 7, 3);
INSERT INTO `role` VALUES (19, '薪资与福利主管', '健全完善薪酬制度和福利规划方案，并具体执行薪酬管理工作。', 7, 3);
INSERT INTO `role` VALUES (20, '员工培训与发展主管', '制定实施员工培训与发展计划，提升员工队伍素质，提高组织学习能力。', 7, 3);
INSERT INTO `role` VALUES (21, '招聘主管', '制定并实施公司各项招聘计划，完成招聘目标。', 7, 3);
INSERT INTO `role` VALUES (22, '人力资源专员', '协助上级制定实施人力资源目标及计划，以实现人力资源最优配置。', 8, 3);
INSERT INTO `role` VALUES (23, '行政经理', '规划、指导、协调公司行政服务支持等各项工作，组织管理下属人员完成本职工作。', 8, 4);
INSERT INTO `role` VALUES (24, '行政主管', '协助行政经理安排、落实行政服务支持工作。', 8, 4);
INSERT INTO `role` VALUES (25, '法律事务主管', '指导公司法务实践，处理公司法律问题，以维护公司法律权利和利益。', 9, 4);
INSERT INTO `role` VALUES (26, '行政专员', '落实公司日常办公的行政服务工作，管理公司的后勤服务工作，提供行政服务支持以及后勤保障。', 9, 4);
INSERT INTO `role` VALUES (27, '前台', '做好公司日常行政事务工作，保证公司信息通讯顺畅，提高公司运作效率。', 9, 4);
INSERT INTO `role` VALUES (28, '市场部经理', '组织部门人员完成市场推广及营销计划，推进实施公司的市场战略与策略，完成市场发展目标；维护公司品牌，提升品牌知名度与美誉度。', 10, 5);
INSERT INTO `role` VALUES (29, '公共关系主管', '主持制定与执行市场公关计划，监督实施公关活动，并建立良好的市场关系网络。', 10, 5);
INSERT INTO `role` VALUES (30, '客户关系主管', '规划、组织、推进客户服务，维护良好的客户关系。', 10, 5);
INSERT INTO `role` VALUES (31, '客户关系代表', '解决客户咨询、提供售后服务、办理客户投诉、进行客户关怀，维护良好的客户关系。', 11, 5);
INSERT INTO `role` VALUES (32, '市场策划主管专员', '组织制定市场营销规划、市场营销策略并协助开展市场拓展工作。', 11, 5);
INSERT INTO `role` VALUES (33, '市场拓展主管专员', '制定并组织实施市场拓展的整体计划及策略，建立良好的市场关系网络，实现公司的市场拓展目标。侧重于渠道开发与关系维护、促销活动方案拟定与实施、市场关系网络建立以及市场拓展业务体系的完善。', 11, 5);
INSERT INTO `role` VALUES (34, '市场研究主管专员', '制定、实施各项市场调研计划以及市场调研项目，为相关部门人员提供所需的市场信息支持。', 12, 5);
INSERT INTO `role` VALUES (35, '销售部经理', '协助管理公司的销售运作，带领销售团队完成公司的销售计划和销售目标。', 12, 6);
INSERT INTO `role` VALUES (36, '销售主管', '带领销售团队完成公司下达的销售任务和目标。', 12, 6);
INSERT INTO `role` VALUES (37, '销售代表', '建立和维护良好的客户关系，并完成公司下达的销售任务和目标。', 12, 6);
INSERT INTO `role` VALUES (38, '电话销售代表', '通过电话直销方式进行客户开发以及关系维护（客户拓展为主），并完成公司下达的销售任务和目标。', 13, 6);
INSERT INTO `role` VALUES (39, '技术研发部经理', '全面主持部门研发与技术管理工作，配合规划公司的技术发展路线与新产品开发，实现技术创新目标。', 13, 7);
INSERT INTO `role` VALUES (40, '技术支持主管', '组织制定、实施技术方案和产品质量管理制度，负责产品售后技术支持以及技术问题解决。', 13, 7);
INSERT INTO `role` VALUES (41, '研发主管', '主持新产品的研究开发，实现公司的产品开发目标。（与技术支持的最大区别是侧重于后台研发）', 13, 7);
INSERT INTO `role` VALUES (42, '技术支持人员', '贯彻实施公司的技术方案和产品质量管理制度，重点负责产品售后技术支持以及技术问题解决。', 13, 7);
INSERT INTO `role` VALUES (43, '研发人员', '参与新产品的研究开发，实现公司的产品开发目标。（与技术支持的最大区别是侧重于后台研发）', 14, 7);
INSERT INTO `role` VALUES (44, '生产部经理', '指导生产主管，全面负责生产组织、计划及现场作业管理，按时、按质、按量完成公司生产目标，并实现成本、质量、交期的最优化。', 14, 8);
INSERT INTO `role` VALUES (45, '设备工程师', '管理公司所有生产设备，以确保其正常运行，并发挥设备使用价值的最大化，为完成生产任务目标提供保障。', 14, 8);
INSERT INTO `role` VALUES (46, '生产主管', '组织下属并指导其完成生产计划，实现生产目标，按时、按质、按量完成公司生产目标，并实现成本、质量、交期的最优化。', 14, 8);
INSERT INTO `role` VALUES (47, '生产计划员', '编制生产计划，跟踪生产进度，安排订单生产任务，统计分析生产数据和信息。', 14, 8);
INSERT INTO `role` VALUES (48, '生产物料员', '负责与生产相关物料的请购、配备与调节，确保生产流畅，协助制定和调整生产计划。', 15, 8);
INSERT INTO `role` VALUES (49, '车间主任', '组织、协调、指挥车间各项工作，完成车间工作计划、车间各项工作指标，并实现成本、质量、交期的最优化。', 15, 8);
INSERT INTO `role` VALUES (50, '生产班组长', '班组内生产任务分配、物料控制、班组现场生产作业管理、安全管理、生产小组人员管理、班组文化建设，确保按时、按质、按量完成班组生产任务。', 15, 8);
INSERT INTO `role` VALUES (51, '生产车间员工', '通过生产车间本机台的日常工作，按时、按质、按量完成上级下达的考核指标和各项工作任务，并协助班组长完成本班组承担的工作任务。', 15, 8);
INSERT INTO `role` VALUES (52, '生产跟单员', '主动进行业务开拓生产，对准客户实施推销跟进，以达成订单为目标；通过监控产品生产流程确保产品交货期与质量。', 16, 8);
INSERT INTO `role` VALUES (53, '品质经理', '全面负责企业所有产品的品质管理工作，保证产品质量，追求零缺陷，降低成本，完成公司产品品质方面的工作指标及任务。', 16, 9);
INSERT INTO `role` VALUES (54, '品质主管', '组织下属并指导其完成企业品质控制计划，实现企业品质目标，保证产品质量，追求零缺陷，降低成本，协助品质经理完成公司产品品质方面的工作指标及任务。', 16, 9);
INSERT INTO `role` VALUES (55, '品质工程师', '制定产品质量检验标准及质量管理体系，指导检验员检验产品，确保公司产品品质达标；并就产品质量存在的问题严格把关、持续改进。', 17, 9);
INSERT INTO `role` VALUES (56, '质检员', '完成日常质量检验、质量监控及结果上报工作，协助完成部门工作指标与任务。', 17, 9);
INSERT INTO `role` VALUES (57, '质量安全技工', '对零部件或产品进行测试、分析，以确保质量标准的执行。', 17, 9);
INSERT INTO `role` VALUES (58, '采购经理', '全面负责公司各项采购任务，保证生产物料的质量以及及时供应，并有效控制成本，完成上级下达的工作指标与任务。', 18, 10);
INSERT INTO `role` VALUES (59, '采购主管', '协助采购经理负责执行公司各项采购任务，保证生产物料的质量以及及时供应，并有效控制成本，完成上级下达的工作指标与任务。', 18, 10);
INSERT INTO `role` VALUES (60, '采购员', '负责日常物料采购工作和原料的接收、托运工作，完成部门下达的工作指标与任务，并保证所负责采购生产物料的质量以及及时供应，并有效控制成本。', 18, 10);
INSERT INTO `role` VALUES (61, '物流经理', '全面负责管理公司的物流与仓储工作，保证物流顺畅，不断优化物流解决方案，提升客户满意度，并有效控制物流与仓储成本，完成上级下达的工作指标与任务。', 19, 11);
INSERT INTO `role` VALUES (62, '仓储主管', '负责仓库管理规范化建设以及物料的仓储管理，确保库存产品或物料的材质不变，保证生产用原材料的库存供给和市场部发送产品所需的库存供给，完成部门下达的指标及任务。', 19, 11);
INSERT INTO `role` VALUES (63, '货运主管', '负责规划最佳的货物配送路线与方式，组织订单货物及时、完好、精准地送达，完成部门下达的指标与任务。', 20, 11);
INSERT INTO `role` VALUES (64, '物流规划专员', '负责规划、设计物流方案并予以实施，达成及时、按质、按量供应产品开发过程中所需物料，并确保公司产品及时有效精准的送达客户。', 20, 11);
INSERT INTO `role` VALUES (65, '仓库管理员', '负责原材料及产品的出、入库流程管理，确保存放物料及产品的品质与安全，为原料供给及产品配送提供保障，完成部门下达的指标及任务。', 21, 11);
INSERT INTO `role` VALUES (71, '销售代表', 'test34', 7, 5);

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train`  (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `close_time` datetime(0) NULL DEFAULT NULL,
  `e_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE,
  INDEX `t_e_id_fk`(`e_id`) USING BTREE,
  CONSTRAINT `t_e_id_fk` FOREIGN KEY (`e_id`) REFERENCES `employee` (`e_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES (1, '日常工作培训', '普通培训', '2022-12-06 16:08:09', '2022-12-06 16:08:11', 3);
INSERT INTO `train` VALUES (2, '办公培训', '普通培训', '2022-12-12 16:08:44', '2022-12-13 16:08:49', 4);
INSERT INTO `train` VALUES (3, '办公培训', '普通培训', '2022-12-07 16:34:42', '2022-12-07 16:34:45', 6);
INSERT INTO `train` VALUES (7, '22', '22', '2023-01-09 00:00:00', '2023-01-10 00:00:00', 8);
INSERT INTO `train` VALUES (9, '能力提升', '能力提升', '2023-01-09 00:00:00', '2023-01-09 00:00:00', 3);
INSERT INTO `train` VALUES (10, '日常办公能力提升', '日常办公能力提升', '2023-01-03 00:00:00', '2023-01-10 00:00:00', 8);

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `unit_id` int NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `upper_id` int NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`unit_id`) USING BTREE,
  INDEX `upper_id_fk`(`upper_id`) USING BTREE,
  CONSTRAINT `upper_id_fk` FOREIGN KEY (`upper_id`) REFERENCES `unit` (`unit_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES (1, '高管', 1, NULL);
INSERT INTO `unit` VALUES (2, '财务部', 1, NULL);
INSERT INTO `unit` VALUES (3, '人资部', 2, NULL);
INSERT INTO `unit` VALUES (4, '行政部', 3, NULL);
INSERT INTO `unit` VALUES (5, '市场营销部', 4, NULL);
INSERT INTO `unit` VALUES (6, '销售部', 5, NULL);
INSERT INTO `unit` VALUES (7, '技术研发部', 6, NULL);
INSERT INTO `unit` VALUES (8, '生产部', 7, NULL);
INSERT INTO `unit` VALUES (9, '品控部', 8, NULL);
INSERT INTO `unit` VALUES (10, '采购部', 9, NULL);
INSERT INTO `unit` VALUES (11, '仓储部', 10, NULL);

SET FOREIGN_KEY_CHECKS = 1;
