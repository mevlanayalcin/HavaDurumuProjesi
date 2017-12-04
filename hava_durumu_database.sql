/*
 Navicat Premium Data Transfer

 Source Server         : HavaDurumu
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : hava_durumu_database

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 04/12/2017 22:20:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hava_durumu
-- ----------------------------
DROP TABLE IF EXISTS `hava_durumu`;
CREATE TABLE `hava_durumu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sehir` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `durum` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `sicaklik` mediumtext CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `basinc` mediumtext CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  `nem_orani` mediumtext CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hava_durumu
-- ----------------------------
INSERT INTO `hava_durumu` VALUES (1, 'Ankara', 'broken clouds', '12', '1021', '54');
INSERT INTO `hava_durumu` VALUES (2, 'Istanbul', 'light intensity shower rain', '13', '1018', '82');
INSERT INTO `hava_durumu` VALUES (3, 'Konya', 'mist', '6', '1025', '87');
INSERT INTO `hava_durumu` VALUES (4, 'Yozgat', 'few clouds', '13', '893', '82');
INSERT INTO `hava_durumu` VALUES (5, 'London', 'fog', '7', '1033', '81');
INSERT INTO `hava_durumu` VALUES (6, 'Adana', 'clear sky', '21', '1021', '35');

SET FOREIGN_KEY_CHECKS = 1;
