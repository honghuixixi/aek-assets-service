#资产详情表添加字段
ALTER TABLE `ass_assets_info` 
ADD COLUMN `apply_type` TINYINT(8) DEFAULT NULL COMMENT '购置类别:1=新增、2=添置、3=报废更新' AFTER `apply_dept_id`, 
ADD COLUMN apply_date datetime DEFAULT NULL COMMENT '申购日期' AFTER apply_type,
ADD COLUMN proof_date datetime DEFAULT NULL COMMENT '论证日期' AFTER apply_date,
ADD COLUMN `expect_date` datetime DEFAULT NULL COMMENT '预到时间' AFTER `proof_date`,
ADD COLUMN apply_reason text DEFAULT NULL COMMENT '申购理由' AFTER expect_date,
ADD COLUMN `acceptance_person_name` varchar(200) DEFAULT NULL COMMENT '验收人员' AFTER `acceptance_date`, 
ADD COLUMN acceptance_dept_name varchar(200) DEFAULT NULL COMMENT '验收部门' AFTER acceptance_person_name;

#资产详情扩展表添加字段
ALTER TABLE `ass_assets_info_ext` 
ADD COLUMN `purchase_way` TINYINT(8) DEFAULT NULL COMMENT '采购方式:1=国际招标、2=政府采购、3=院内采购、4=分散采购、5=自行采购、6=其他' AFTER `purchase_date`, 
ADD COLUMN tender_form TINYINT(8) DEFAULT NULL COMMENT '招标形式:1=公开招标、2=邀请招标、3=竞争性谈判、4=单一来源采购、5=询价采购、6=其他' AFTER purchase_way,
ADD COLUMN single_budget bigint(20) DEFAULT NULL COMMENT '单项预算' AFTER tender_form,
ADD COLUMN win_tender_date datetime DEFAULT NULL COMMENT '中标时间' AFTER single_budget,
ADD COLUMN approve_project_accord text DEFAULT NULL COMMENT '立项依据' AFTER win_tender_date;

commit;

#新建资产附件表（招标、验收、合同）
CREATE TABLE `ass_assets_annex` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `assets_id` bigint(20) DEFAULT NULL COMMENT '资产ID',
  `contract_id` bigint(20) DEFAULT NULL COMMENT '合同id',
  `annex_type` tinyint(8) DEFAULT NULL COMMENT '附件类型:1=招标、2=验收、3=合同',
  `annex_url` json DEFAULT NULL COMMENT '附件保存路径',
  `sys_id` bigint(20) DEFAULT NULL COMMENT '系统ID',
  `del_flag` bit(1) DEFAULT b'0' COMMENT '作废标识0启用1作废',
  PRIMARY KEY (`id`),
  KEY `assets_id` (`assets_id`,`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='资产招标、验收、合同附件表';

#新建资产证件表
CREATE TABLE `ass_assets_certificate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `certificate_num` varchar(50) DEFAULT NULL COMMENT '证件编号',
  `certificate_register_num` varchar(50) DEFAULT NULL COMMENT '证件注册号',
  `certificate_type` tinyint(8) DEFAULT NULL COMMENT '证件类型：1=医疗器械生产企业许可证、2=医疗器械注册证、3=医疗器械经营企业许可证、4=产品合格证、5=自定义证件',
  `name` text COMMENT '证件名称',
  `assets_id` bigint(20) DEFAULT NULL COMMENT '资产ID',
  `valid_date` datetime DEFAULT NULL COMMENT '有效期至',
  `valid_date_str` varchar(50) DEFAULT NULL COMMENT '有效期',
  `product_date` datetime DEFAULT NULL COMMENT '生产日期',
  `image_url` text COMMENT '图片保存路径',
  `sys_id` bigint(20) DEFAULT NULL COMMENT '系统ID',
  `del_flag` bit(1) DEFAULT b'0' COMMENT '作废标识0启用1作废',
  PRIMARY KEY (`id`),
  KEY `assets_id` (`assets_id`,`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='资产证件表';

#clear assets source
update ass_assets_info_ext set purchase_type_id =1 WHERE purchase_type_id in(2,3);
update ass_assets_info_ext set purchase_type_id =2 WHERE purchase_type_id =4;
update ass_assets_info_ext set purchase_type_id =3 WHERE purchase_type_id =5;
update ass_assets_info_ext set purchase_type_id =4 WHERE purchase_type_id =6;
update ass_assets_info_ext set purchase_type_id =5 WHERE purchase_type_id =7;
commit;

#clear ass_code_info
update ass_code_info set code_text='采购' WHERE code_index=1 AND type_id=8;
update ass_code_info set code_text='租用' WHERE code_index=2 AND type_id=8;
update ass_code_info set code_text='捐赠' WHERE code_index=3 AND type_id=8;
update ass_code_info set code_text='调入' WHERE code_index=4 AND type_id=8;
update ass_code_info set code_text='其它',code_text_py='QT' WHERE code_index=5 AND type_id=8;
DELETE FROM ass_code_info WHERE id in(127,133);
COMMIT;

