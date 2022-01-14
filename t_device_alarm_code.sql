/*
 Navicat Premium Data Transfer

 Source Server         : 114.116.203.108_3333
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 114.116.203.108:3333
 Source Schema         : lot_cloud_platform

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 13/01/2022 16:44:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_device_alarm_code
-- ----------------------------
DROP TABLE IF EXISTS `t_device_alarm_code`;
CREATE TABLE `t_device_alarm_code`  (
  `dac_code` int(50) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dac_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件描述',
  `dac_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '级别',
  `dac_type` int(10) NULL DEFAULT NULL COMMENT '0-资源告警 1-安全事件 2-设备故障',
  `dac_createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`dac_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1025 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '告警事件对照表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_device_alarm_code
-- ----------------------------
INSERT INTO `t_device_alarm_code` VALUES (1001, 'cpu 利用率超过阀值', '一般', 0, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (1002, 'cpu 利用率超过阀值恢复', '一般', 0, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (1003, '内存使用率超过阀值', '一般', 0, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (1004, '内存使用率超过阀值恢复', '一般', 0, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (1005, '磁盘空间使用率超过阀值', '一般', 0, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (2001, '开放非法端口', '紧急', 1, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (2002, '网络外联事件', '紧急', 1, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (2003, 'USB 存储设备非法插入', '紧急', 1, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (2004, '串口占用', '一般', 1, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3001, '散热风扇停止运行', '一般', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3002, '外接装置异常', '一般', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3003, '超高温', '紧急', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3004, '超高温恢复', '一般', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3005, '超低温', '紧急', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3006, '超低温恢复', '一般', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3007, '掉电', '紧急', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3008, ' 上盖开盖', '紧急', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3009, '端盖开盖', '紧急', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3010, '重要组件异常重启（在 msg 中填写组件名称）', '紧急', 2, '2022-01-13 16:42:22');
INSERT INTO `t_device_alarm_code` VALUES (3011, '终端重启上报', '紧急', 2, '2022-01-13 16:42:22');

SET FOREIGN_KEY_CHECKS = 1;
