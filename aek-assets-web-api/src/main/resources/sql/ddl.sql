#1.添加维修单ID字段
ALTER TABLE `ass_assets_info`
ADD COLUMN `repair_id`  bigint NULL COMMENT '维修单id' AFTER `three_level_code`;

#2.添加国产/进口字段
ALTER TABLE `ass_assets_info`
ADD COLUMN `made_in`  int(1) NULL COMMENT '是否国产（1，国产 2，进口）' AFTER `repair_id`;

#以上已更新到生产库
##############################################################################################

#2017-11-03
#1.添加维修状态字段
ALTER TABLE `ass_assets_info`
ADD COLUMN `repair_status`  int(1) NULL COMMENT '维修状态：1=正常，2=维修中' AFTER `status`;

#2.修改设备状态注释
ALTER TABLE `ass_assets_info`  
MODIFY COLUMN `status` int(1) DEFAULT '1' COMMENT '状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货';

#3.修改预台账状态注释
ALTER TABLE `ass_assets_info_ext`  
MODIFY COLUMN `verfy_status` smallint(1) DEFAULT '0' COMMENT '审核状态 ：0=暂存 、1=待验收 、2=验收通过 、3=验收未通过';

#2017-11-06
#资产历史数据处理
#1.历史数据处理，资产台账在库、在用的，调整为在库、在用，维修状态为正常
update ass_assets_info set repair_status=1 where assets_status=1 and status in(1,2);
commit;
#2.历史数据处理，资产台账状态为维修中的，调整为状态在用，维修状态为维修中
update ass_assets_info set status=2,repair_status=2 where assets_status=1 and status = 4 and repair_id is not null;
update ass_assets_info set status=2,repair_status=1 where assets_status=1 and repair_id is  null;
#3.历史数据处理，资产台账状态为已报废的，调整为报损
update ass_assets_info set status=5 where assets_status=1 and status = 6;
commit;
#4.将维修中的设备置为维修中，不是维修中的设备置为正常
update ass_assets_info set repair_status=1 where repair_id is null;
commit;
update ass_assets_info set repair_status=2 where repair_id is not null;
commit;
#以上已更新到生产库
##############################################################################################

