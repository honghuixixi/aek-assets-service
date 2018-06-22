#设备档案表
CREATE TABLE `ass_archive` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `assets_id` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `archive_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '档案名称',
  `archive_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '档案编号',
  `limit_storage_time` int(11) DEFAULT NULL COMMENT '保管期限(1=永久，2=长期(16~50年)，3=短期(15年以下))',
  `secret_level` int(11) DEFAULT NULL COMMENT '保密级别(1=公开级,2=内部级,3=秘密级,4=机密级,5=绝密级)',
  `filing_user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '立卷人',
  `filing_time` datetime DEFAULT NULL COMMENT '立卷时间',
  `check_user_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '检查人',
  `check_time` datetime DEFAULT NULL COMMENT '检查日期',
  `start_time` datetime DEFAULT NULL COMMENT '起止开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '起止结束时间',
  `filing_department` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '立卷单位',
  `create_time` datetime DEFAULT NULL COMMENT '新建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='设备档案表';

#资产档案证件信息表
CREATE TABLE `ass_archive_certificate_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `archive_id` bigint(20) DEFAULT NULL COMMENT '档案ID',
  `assets_id` bigint(20) DEFAULT NULL COMMENT '资产ID',
  `certificate_num` varchar(50) DEFAULT NULL COMMENT '证件编号',
  `certificate_register_num` varchar(50) DEFAULT NULL COMMENT '证件注册号',
  `certificate_type` tinyint(8) DEFAULT NULL COMMENT '证件类型：1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证、5=自定义证件',
  `name` text COMMENT '证件名称',
  `valid_date` datetime DEFAULT NULL COMMENT '有效期至',
  `expire_time` varchar(50) DEFAULT NULL COMMENT '有效期(有效时间长度，如1年，24个月等)',
  `product_date` datetime DEFAULT NULL COMMENT '生产日期',
  `image_url` text COMMENT '图片保存路径',
  `del_flag` bit(1) DEFAULT b'0' COMMENT '删除标识(0=未删除，1=已删除)',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `assets_id` (`assets_id`,`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资产档案证件信息表';

#资产档案合同信息表
CREATE TABLE `ass_archive_contract_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '合同ID',
  `archive_id` bigint(20) DEFAULT NULL COMMENT '档案ID',
  `assets_id` bigint(20) DEFAULT NULL COMMENT '资产ID',
  `contract_num` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '合同编号',
  `contract_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '合同名称',
  `supplier_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '供应商单位名称',
  `sign_date` datetime DEFAULT NULL COMMENT '签订日期',
  `contract_price` double DEFAULT NULL COMMENT '合同金额',
  `end_date` datetime DEFAULT NULL COMMENT '合同截止时间',
  `partyb_contact_person` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '乙方联系人',
  `partyb_contact_phone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '乙方联系电话',
  `contract_archive_num` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '档案编号',
  `contract_archive_administrator` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '档案管理员',
  `contract_content` varchar(1024) COLLATE utf8_bin DEFAULT NULL COMMENT '合同内容',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产档案合同信息表';

#资产档案合同信息附件表
CREATE TABLE `ass_archive_contract_info_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `contract_id` bigint(20) DEFAULT NULL COMMENT '合同id',
  `file_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文件名称',
  `file_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产档案合同信息附件表';

#资产档案合同信息发票表
CREATE TABLE `ass_archive_contract_info_invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `contract_id` bigint(20) DEFAULT NULL COMMENT '合同ID',
  `invoice_no` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '发票号',
  `invoice_money` double DEFAULT NULL COMMENT '发票金额',
  `invoice_date` datetime DEFAULT NULL COMMENT '发票日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产档案合同信息发票表';

#资产档案文件夹表
CREATE TABLE `ass_archive_folder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `archive_id` bigint(20) DEFAULT NULL COMMENT '档案ID',
  `assets_id` bigint(20) DEFAULT NULL COMMENT '资产ID',
  `folder_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文件名称',
  `file_num` int(20) DEFAULT NULL COMMENT '文件个数',
  `folder_date` datetime DEFAULT NULL COMMENT '文件日期',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime DEFAULT NULL COMMENT '编辑日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产档案文件夹表';

#资产档案文件夹附件表
CREATE TABLE `ass_archive_folder_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `folder_id` bigint(20) DEFAULT NULL COMMENT '文件夹id',
  `file_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文件夹附件名称',
  `file_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文件夹附件地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产档案文件夹附件表';

#资产档案采购信息表
CREATE TABLE `ass_archive_purchase_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `archive_id` bigint(20) DEFAULT NULL COMMENT '档案ID',
  `assets_id` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `purchase_type` tinyint(8) DEFAULT NULL COMMENT '购置类别:1=新增、2=添置、3=报废更新',
  `apply_date` datetime DEFAULT NULL COMMENT '申购日期',
  `apply_dept_id` int(11) DEFAULT NULL COMMENT '申购科室ID',
  `prove_date` datetime DEFAULT NULL COMMENT '论证日期',
  `preview_arrive_date` datetime DEFAULT NULL COMMENT '预到时间',
  `apply_reason` text COLLATE utf8_bin COMMENT '申购理由',
  `acceptor` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '验收人员',
  `acceptor_dept_name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '验收部门',
  `acceptor_time` datetime DEFAULT NULL COMMENT '验收时间',
  `purchase_mode` tinyint(8) DEFAULT NULL COMMENT '采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他',
  `tender_form` tinyint(8) DEFAULT NULL COMMENT '招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他',
  `single_budget` double DEFAULT NULL COMMENT '单项预算',
  `tender_date` datetime DEFAULT NULL COMMENT '中标时间',
  `build_item_basis` text COLLATE utf8_bin COMMENT '立项依据',
  `arrival_time` datetime DEFAULT NULL COMMENT '到货时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产档案采购信息表';

#资产档案采购信息附件表
CREATE TABLE `ass_archive_purchase_info_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `purchase_id` bigint(20) DEFAULT NULL COMMENT '采购信息id',
  `type` int(10) DEFAULT NULL COMMENT '类型1=招标、2=验收',
  `file_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '采购信息附件文件名',
  `file_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '采购信息附件文件地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产档案采购信息附件表';

#资产档案采购信息资金来源表
CREATE TABLE `ass_archive_purchase_info_fund_sources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `purchase_id` bigint(20) DEFAULT NULL COMMENT '采购信息ID',
  `type` int(11) DEFAULT NULL COMMENT '资金来源类型(1=财政资金,2=自筹资金,3=捐赠,4=混合(财政资金+自筹资金）,5=其他)',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '资金来源名称',
  `money` double DEFAULT NULL COMMENT '资金来源金额',
  `sub_type` int(11) DEFAULT NULL COMMENT '混合子分类(1=财政资金，2=自筹资金)',
  `sub_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '混合子分类名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产档案采购信息资金来源表';