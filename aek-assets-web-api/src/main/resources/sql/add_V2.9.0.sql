#转科增加院内编码
ALTER TABLE `ass_assets_transfer_detail` 
ADD COLUMN `serial_num` varchar(50) DEFAULT NULL COMMENT '院内编码' AFTER `assets_num`;
COMMIT;

#报损增加院内编码
ALTER TABLE `ass_assets_discard_detail` 
ADD COLUMN `serial_num` varchar(50) DEFAULT NULL COMMENT '院内编码' AFTER `assets_num`;
COMMIT;