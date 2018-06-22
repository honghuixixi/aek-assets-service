
#给资产添加是否在PM计划中标记pm_plan_flag字段
ALTER TABLE `ass_assets_info_ext` ADD COLUMN `pm_plan_flag` TINYINT(1) DEFAULT 0 COMMENT '是否已经在PM计划中1=在PM计划中,0=不在PM计划中' AFTER `pm_flag`;