#�ʲ�����ӱ����ƻ��ֶ�
alter table ass_assets_info_ext add mt_plan_flag tinyint(1) DEFAULT '0' COMMENT '�Ƿ��Ѿ��ڱ����ƻ���1=�ڱ����ƻ���,0=���ڱ����ƻ���' after pm_plan_flag;
commit;

#������־��ر��
CREATE TABLE `ass_assets_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '����ID',
  `assets_id` bigint(20) NOT NULL COMMENT '�ʲ�ID',
  `module_type` int(1) DEFAULT NULL COMMENT 'ģ������(1=�豸��Ϣ��2=�ɹ���Ϣ��3=��ͬ��Ϣ��4=֤������)',
  `operate_type` int(1) DEFAULT NULL COMMENT '��������(1=������2=�༭)',
  `operate_by` bigint(20) DEFAULT NULL COMMENT '������ID',
  `operate_by_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '����������',
  `operate_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '��������',
  `remark` longtext COLLATE utf8_bin COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='�ʲ�̨�˲�����¼��־';

CREATE TABLE `ass_assets_log_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '����ID',
  `assets_log_id` bigint(20) NOT NULL COMMENT '�ʲ���־����ID',
  `type` int(1) DEFAULT NULL COMMENT '����(1=�ֶ�����/�޸ģ�2=��ͬ������3=�б긽����4=���ո�����5=֤������)',
  `table_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '���ݿ������',
  `field` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '���ݿ��ֶ�����',
  `field_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '���ݿ��ֶ���������',
  `property_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'Java������������',
  `old_value` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '��ֵ',
  `new_value` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '��ֵ',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '����ʱ��',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '��־��ϸ����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='�ʲ�̨�˲�����¼��־��ϸ';