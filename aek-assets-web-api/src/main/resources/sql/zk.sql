#资产台账标记转科状态
ALTER TABLE `ass_assets_info` 
ADD COLUMN `transfer_status` INT(1) DEFAULT NULL COMMENT '转科状态:1=申请中、2=未申请' AFTER `made_in`;
commit;

#资产转科表主表
CREATE TABLE `ass_assets_transfer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `transfer_num` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '转科单号',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构id',
  `tenant_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '机构名称',
  `assets_names` longtext COLLATE utf8_bin COMMENT '转科单关联所有设备名称',
  `from_dept_id` bigint(20) DEFAULT NULL COMMENT '来源科室id',
  `to_dept_id` bigint(20) DEFAULT NULL COMMENT '转入科室id',
  `to_dept_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '转入科室名称',
  `applyer_id` bigint(20) DEFAULT NULL COMMENT '申请人id',
  `applyer_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '申请人姓名',
  `auditer_id` bigint(20) DEFAULT NULL COMMENT '审核人id',
  `auditer_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人姓名',
  `dept_manage_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '科室负责人姓名',
  `apply_desc` text COLLATE utf8_bin COMMENT '申请说明',
  `audit_opinion` text COLLATE utf8_bin COMMENT '审核意见',
  `audit_remark` text COLLATE utf8_bin COMMENT '审核备注',
  `status` tinyint(8) DEFAULT NULL COMMENT '转科单状态(0:全部 1:审核通过 2:待审核 3:审核未通过)',
  `creat_time` datetime DEFAULT NULL COMMENT '转科单创建时间',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `del_flag` bit(1) DEFAULT b'0' COMMENT '删除状态（0=未删除、1=删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产转科表主表';

#资产转科明细表
CREATE TABLE `ass_assets_transfer_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `transfer_id` bigint(20) NOT NULL COMMENT '转科单id',
  `assets_id` bigint(20) DEFAULT NULL COMMENT '设备id',
  `assets_num` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '资产编号',
  `assets_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '资产名称',
  `assets_spec` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '资产规格',
  `assets_img_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '台账图片',
  `factory_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '厂家名称',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '所在科室id',
  `dept_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '所在科室名称',
  `operate` tinyint(8) DEFAULT NULL COMMENT '操作(1：未撤销 2：已撤销 )',
  `unit_id` int(11) DEFAULT NULL COMMENT '计数单位',
  `unit_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '计数单位名称',
  `del_flag` bit(1) DEFAULT b'0' COMMENT '删除标志0=未删除，1=删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产转科明细表';