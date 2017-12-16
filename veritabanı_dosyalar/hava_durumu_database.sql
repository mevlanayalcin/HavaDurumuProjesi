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

 Date: 15/12/2017 00:01:57
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
  `zaman` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 981 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for log_tablosu
-- ----------------------------
DROP TABLE IF EXISTS `log_tablosu`;
CREATE TABLE `log_tablosu`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IP` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DATE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUEST_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sicaklik_tablosu
-- ----------------------------
DROP TABLE IF EXISTS `sicaklik_tablosu`;
CREATE TABLE `sicaklik_tablosu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sehir` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ocak` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subat` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mart` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nisan` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mayis` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `haziran` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `temmuz` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `agustos` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eylul` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ekim` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `kasim` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `aralik` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `yillik` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
