#资产中添加保养计划字段
alter table ass_assets_info_ext add mt_plan_flag tinyint(1) DEFAULT '0' COMMENT '是否已经在保养计划中1=在保养计划中,0=不在保养计划中' after pm_plan_flag;
commit;

#创建日志相关表格
CREATE TABLE `ass_assets_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `assets_id` bigint(20) NOT NULL COMMENT '资产ID',
  `module_type` int(1) DEFAULT NULL COMMENT '模块类型(1=设备信息，2=采购信息，3=合同信息，4=证件管理)',
  `operate_type` int(1) DEFAULT NULL COMMENT '操作类型(1=新增，2=编辑)',
  `operate_by` bigint(20) DEFAULT NULL COMMENT '操作人ID',
  `operate_by_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人名称',
  `operate_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作日期',
  `remark` longtext COLLATE utf8_bin COMMENT '操作描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产台账操作记录日志';

CREATE TABLE `ass_assets_log_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `assets_log_id` bigint(20) NOT NULL COMMENT '资产日志主表ID',
  `type` int(1) DEFAULT NULL COMMENT '类型(1=字段新增/修改，2=合同附件，3=招标附件，4=验收附件，5=证件管理)',
  `table_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据库表名称',
  `field` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据库字段名称',
  `field_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '数据库字段中文名称',
  `property_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'Java对象属性名称',
  `old_value` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '旧值',
  `new_value` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '新值',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '日志明细描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产台账操作记录日志明细';