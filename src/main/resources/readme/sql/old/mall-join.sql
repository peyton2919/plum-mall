DROP TABLE IF EXISTS `tb_warehouse_info`;
CREATE TABLE `tb_warehouse_info`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`        varchar(50)  not NULL COMMENT '名称',
    `phone`       varchar(50)  NULL COMMENT '手机号',
    `address`     varchar(150) NULL COMMENT '地址',
    `loaction`    varchar(50)  NULL COMMENT '位置',
    `explain`     varchar(100) NULL COMMENT '说明',
    `create_time` int(11)      NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '仓库信息';

DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `sup_id`      bigint(20)   NULL DEFAULT 0 COMMENT '供应商编号',
    `logo`        varchar(150) NULL COMMENT '品牌LOGO 图片大小120px*120px',
    `name`        varchar(30)  NULL COMMENT '品牌名称',
    `area`        varchar(100) NULL COMMENT '所属地区',
    `seq`         smallint(6)  NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `is_del`      tinyint(4)   NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `explain`     varchar(250) NULL DEFAULT NULL COMMENT '品牌描述',
    `create_time` int(11)      NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '品牌';

DROP TABLE IF EXISTS `sys_invoice`;
CREATE TABLE `sys_invoice`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `order_id`    bigint(20)   NOT NULL COMMENT '订单id',
    `shaer_id`    bigint(20)   NULL comment '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `shaer_type`  tinyint(4)   NULL     default 0 comment '用户类型 默认: 0 会员、1 供应商、2 员工',
    `name`        varchar(100) NOT NULL COMMENT '名称/公司名称',
    `phone`       varchar(11)  NULL     DEFAULT NULL COMMENT '手机',
    `email`       varchar(100) NULL     DEFAULT NULL COMMENT '邮箱',
    `code`        varchar(100) NOT NULL COMMENT '税号',
    `path`        varchar(150) NULL     DEFAULT NULL COMMENT '单位地址',
    `bankname`    varchar(50)  NULL     DEFAULT NULL COMMENT '开户行',
    `bankno`      varchar(50)  NULL     DEFAULT NULL COMMENT '银行账号',
    `status`      tinyint(4)   NULL     DEFAULT 0 COMMENT '开票状态: 默认0 {0未开票1已开票}',
    `type`        tinyint(4)   NOT NULL DEFAULT 0 COMMENT '类型：0个人1企业',
    `create_time` int(11)      NULL     DEFAULT NULL COMMENT '创建时间',
    `is_del`      tinyint(1)   NULL     DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '发票';

DROP TABLE IF EXISTS `tb_express_company`;
CREATE TABLE `tb_express_company`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT COMMENT '快递公司id',
    `code`        varchar(50) NOT NULL COMMENT '快递公司简称',
    `name`        varchar(50) NOT NULL COMMENT '快递公司全称',
    `seq`         smallint(6) NULL     DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `is_show`     tinyint(4)  NOT NULL DEFAULT 1 COMMENT '是否显示: 默认：1{1 显示 0 不显示}',
    `create_time` int(11)     NULL COMMENT '创建时间',
    `is_del`      tinyint(4)  NULL     DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '快递公司';

DROP TABLE IF EXISTS `tb_shipping_templates`;
CREATE TABLE `tb_shipping_templates`
(
    `id`           int(11)     NOT NULL AUTO_INCREMENT COMMENT '模板ID',
    `name`         varchar(50) NULL DEFAULT NULL COMMENT '模板名称',
    `calc_type`    tinyint(4)  NULL default 0 COMMENT '计费方式; 默认 0 件数 1 重量',
    `region_info`  text        NULL COMMENT '地域以及费用',
    `appoint`      tinyint(4)  NULL COMMENT '指定包邮开关',
    `appoint_info` text        NULL COMMENT '指定包邮内容',
    `is_del`       tinyint(1)  NULL DEFAULT 0 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `seq`          smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `create_time`  int(11)     NULL DEFAULT NULL COMMENT '添加时间',
    `update_time`  int(11)     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '运费模板';

DROP TABLE IF EXISTS `tb_shipping_templates_value`;
CREATE TABLE `tb_shipping_templates_value`
(
    `id`          int(11)       NOT NULL AUTO_INCREMENT COMMENT '编号',
    `province_id` int(11)       NULL DEFAULT 0 COMMENT '省ID',
    `temp_id`     int(11)       NULL DEFAULT 0 COMMENT '模板ID',
    `city_id`     int(11)       NULL DEFAULT 0 COMMENT '城市ID',
    `num`         decimal(8, 2) NULL DEFAULT 0.00 COMMENT '包邮件数',
    `price`       decimal(8, 2) NULL DEFAULT 0.00 COMMENT '包邮金额',
    `calc_type`   tinyint(4)    NULL DEFAULT 0 COMMENT '计费方式; 默认 0 件数 1 重量',
    `uniqid`      varchar(36)   NULL COMMENT '分组唯一值',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '运费';

DROP TABLE IF EXISTS `tb_shipping_templates_region`;
CREATE TABLE `tb_shipping_templates_region`
(
    `id`             int(11)       NOT NULL AUTO_INCREMENT COMMENT '编号',
    `province_id`    int(11)       NULL DEFAULT 0 COMMENT '省ID',
    `temp_id`        int(11)       NULL DEFAULT 0 COMMENT '模板ID',
    `city_id`        int(11)       NULL DEFAULT 0 COMMENT '城市ID',
    `first`          decimal(8, 2) NULL DEFAULT 0.00 COMMENT '首件',
    `first_price`    decimal(8, 2) NULL DEFAULT 0.00 COMMENT '首件运费',
    `continues`      decimal(8, 2) NULL DEFAULT 0.00 COMMENT '续件',
    `continue_price` decimal(8, 2) NULL DEFAULT 0.00 COMMENT '续件运费',
    `calc_type`      tinyint(4)    NULL DEFAULT 1 COMMENT '计费方式; 默认 0 件数 1 重量',
    `uniqid`         varchar(36)   NULL DEFAULT '' COMMENT '分组唯一值',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '运费地区模板';





