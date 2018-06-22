
#将设备来源，0：入库新增，1：批量导入 2:新建===>0：入库新增，1：批量导入 2:验收录入 3：清查录入
alter table ass_assets_info modify column assets_source int(11) DEFAULT NULL comment '来源，0：入库新增，1：批量导入 2:验收录入 3：清查录入'; 
commit;

#以上已更新到生产库
##############################################################################################

#将乙方联系电话类型从vachar(16)改为varchar(50)
alter table ass_contract modify column contract_contact_phone varchar(50) DEFAULT NULL comment '乙方联系电话'; 
commit;

#以上已更新到生产库
##############################################################################################

#将状态status从"1"改为null
alter table ass_assets_info modify column status int(1) DEFAULT NULL comment '状态：1=在库、2=在用、3=预登、4=待报损、5=报损、6=退货'; 
commit;