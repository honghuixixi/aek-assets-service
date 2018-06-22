/*
Navicat MySQL Data Transfer

Source Server         : 135
Source Server Version : 50718
Source Host           : 192.168.1.135:3306
Source Database       : assets_feat

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-12-19 09:26:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ass_assets_discard_detail
-- ----------------------------
DROP TABLE IF EXISTS `ass_assets_discard_detail`;
CREATE TABLE `ass_assets_discard_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `discard_id` bigint(20) DEFAULT NULL COMMENT '关联报损单号',
  `assets_id` bigint(20) DEFAULT NULL,
  `assets_name` varchar(50) DEFAULT NULL COMMENT '资产名称',
  `assets_num` varchar(50) DEFAULT NULL COMMENT '设备编号',
  `spl_name` varchar(200) DEFAULT NULL COMMENT '供货单位名称',
  `factory_name` varchar(50) DEFAULT NULL COMMENT '生产商',
  `assets_spec` varchar(50) DEFAULT NULL COMMENT '设备型号',
  `assets_dept_id` bigint(20) DEFAULT NULL COMMENT '设备所在科室id',
  `assets_dept_name` varchar(50) DEFAULT NULL COMMENT '设备所在科室名称',
  `status` int(1) DEFAULT NULL COMMENT '状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货',
  `start_use_date` datetime DEFAULT NULL COMMENT '启用日期',
  `unit_name` varchar(10) DEFAULT NULL COMMENT '计数单位名称',
  `assets_img` varchar(300) DEFAULT NULL COMMENT '设备图片',
  `type` int(1) DEFAULT NULL COMMENT '状态（1，未撤销 2，已撤销）',
  `verify_status` int(1) DEFAULT NULL COMMENT '状态 1:待审核 2:审核通过 3:审核不通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报损设备';

-- ----------------------------
-- Table structure for ass_assets_discard
-- ----------------------------
DROP TABLE IF EXISTS `ass_assets_discard`;
CREATE TABLE `ass_assets_discard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `tenant_name` varchar(50) DEFAULT NULL COMMENT '机构名称',
  `discard_no` char(14) DEFAULT NULL COMMENT '报损单号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `apply_id` bigint(20) DEFAULT NULL COMMENT '申请人id',
  `apply_name` varchar(50) DEFAULT NULL COMMENT '申请人姓名',
  `verify_id` bigint(20) DEFAULT NULL COMMENT '审核人ID',
  `verify_name` varchar(50) DEFAULT NULL COMMENT '审核人姓名',
  `verify_time` datetime DEFAULT NULL COMMENT '审核时间',
  `type` int(1) DEFAULT NULL COMMENT '报损类型（1，在用 2，在库 3，附件）',
  `apply_instruction` varchar(300) DEFAULT NULL COMMENT '申请说明',
  `status` int(1) DEFAULT NULL COMMENT '状态 1:待审核、2:审核通过 3:审核不通过',
  `verify_opinion` varchar(300) DEFAULT NULL COMMENT '审核意见',
  `remarks` varchar(300) DEFAULT NULL COMMENT '审核备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='设备报损单';
