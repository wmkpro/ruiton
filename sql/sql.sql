CREATE TABLE `t_sysAccount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主见',
  `userName` varchar(50) NOT NULL,
  `pwd` varchar(64) NOT NULL COMMENT '密码',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统账号';

INSERT INTO `t_sysAccount` (`id`, `userName`, `pwd`, `createTime`, `updateTime`, `remark`) VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '2019-03-20 14:29:49', '2019-03-20 15:12:15', NULL);

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主见',
  `no` varchar(30) DEFAULT NULL COMMENT '序号',
  `area` varchar(30) DEFAULT NULL COMMENT '区域',
  `address` varchar(200) DEFAULT NULL COMMENT '国家/单位地址',
  `customerName` varchar(30) DEFAULT NULL COMMENT '客户',
  `weight` int(10) DEFAULT NULL COMMENT '重量',
  `patient` varchar(30) DEFAULT NULL COMMENT '患者',
  `orderNo` varchar(50) DEFAULT NULL COMMENT '订单号',
  `paymentUnit` varchar(80) DEFAULT NULL COMMENT '付款单位',
  `receiptTime` datetime DEFAULT NULL COMMENT '接单日期',
  `shipmentTime` datetime DEFAULT NULL COMMENT '出货日期',
  `effectiveTime` datetime DEFAULT NULL COMMENT '有效日期',
  `model` varchar(50) DEFAULT NULL COMMENT '型号',
  `singlejaw` varchar(50) DEFAULT NULL COMMENT '全口/单颌',
  `material` varchar(100) DEFAULT NULL COMMENT '材料',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `paymentDesc` varchar(50) DEFAULT NULL COMMENT '付款情况',
  `paymentTime` datetime DEFAULT NULL COMMENT '付款日期',
  `remark` varchar(250) DEFAULT NULL COMMENT '备注',
  `eBrace` varchar(150) DEFAULT NULL COMMENT 'eBrace/eLoc',
  `followPerson` varchar(30) DEFAULT NULL COMMENT '跟单员',
  `salePerson` varchar(255) DEFAULT NULL COMMENT '销售员',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='国内订单';

