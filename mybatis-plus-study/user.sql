/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : mybatis_plus

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 29/07/2022 21:38:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `gmt_update` datetime(0) NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2222', 18, 'test1@baomidou.com', NULL, '2022-07-29 21:38:03', 2);
INSERT INTO `user` VALUES (2, 'Jack', 20, 'test2@baomidou.com', NULL, NULL, 1);
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', NULL, NULL, 1);
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', NULL, NULL, 1);
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', NULL, NULL, 1);
INSERT INTO `user` VALUES (6, 'test', 2, '123456@qq.com', '2022-07-24 11:16:08', '2022-07-24 11:19:23', 1);
INSERT INTO `user` VALUES (7, '132', NULL, NULL, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
