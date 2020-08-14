/*
 Navicat Premium Data Transfer

 Source Server         : LuckyMoney
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : interact

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 09/08/2020 18:53:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for anonymous
-- ----------------------------
DROP TABLE IF EXISTS `anonymous`;
CREATE TABLE `anonymous`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `lesson_id` int(11) NOT NULL COMMENT '课程id',
  `created_at` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '匿名评价表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
