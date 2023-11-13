DROP TABLE IF EXISTS `tb_supplier`;
CREATE TABLE `tb_supplier`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`        varchar(50)  NOT NULL COMMENT '名称',
    `login_name`  varchar(50)  NOT NULL COMMENT '登录名',
    `avatar`      varchar(250) NULL COMMENT '头像地址',
    `pwd`         varchar(150) NOT NULL COMMENT '密码',
    `phone`       varchar(50)  not NULL COMMENT '手机',
    `loc`         int(11)      NULL DEFAULT 0 COMMENT '登录次数,每登录一次加1',
    `is_del`      tinyint(4)   NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `encrypted`   varchar(50)  NULL COMMENT '加密串',
    `last_ip`     varchar(50)  NULL COMMENT '最后登录IP',
    `create_time` int(11)      NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '供应商信息';

DROP TABLE IF EXISTS `tb_supplier_info`;
CREATE TABLE `tb_supplier_info`
(
    `id`       bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `sup_id`   bigint(20)   NULL COMMENT '供应商Id',
    `address`  varchar(150) NULL COMMENT '地址',
    `email`    varchar(150) NULL COMMENT '邮箱',
    `tel`      varchar(20)  NULL COMMENT '电话',
    `qq`       varchar(20)  NULL COMMENT 'QQ号',
    `fax`      varchar(20)  NULL COMMENT '传真',
    `sex`      tinyint(4)   NULL DEFAULT 0 COMMENT '性别：默认 0{0 保密 1 男 2 女}',
    `birthday` varchar(20)  NULL COMMENT '生日',
    `explain`  varchar(250) NULL COMMENT '说明',
    `web_site` varchar(250) NULL COMMENT '外接网址',
    `web_code` varchar(250) NULL COMMENT '连接外网标识码',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '供应商基础信息';


DROP TABLE IF EXISTS `tb_member_level`;
CREATE TABLE `tb_member_level`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `name`        varchar(30) NULL DEFAULT NULL COMMENT '等级名称',
    `seq`         int(11)     NULL DEFAULT 0 COMMENT '等级权重',
    `member_type` tinyint(4)  null default 0 comment '会员类型, 默认 0 零售 1 批发',
    `is_del`      tinyint(4)  NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `discount`    int(11)     NULL DEFAULT 0 COMMENT '折扣',
    `max_price`   int(11)     NULL DEFAULT 0 COMMENT '消费满元',
    `max_times`   int(11)     NULL DEFAULT 0 COMMENT '消费满次数',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '会员等级';


DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member`
(
    `id`              bigint(20)   NOT NULL AUTO_INCREMENT,
    `level_id`        int(11)      NULL COMMENT '会员级别',
    `username`        varchar(50)  not NULL COMMENT '会员名称',
    `pwd`             varchar(150) not NULL COMMENT '会员密码',
    `avatar`          varchar(250) NULL COMMENT '会员头像',
    `nickname`        varchar(50)  not NULL COMMENT '会员昵称',
    `phone`           varchar(20)  not NULL COMMENT '会员手机',
    `email`           varchar(150) NULL COMMENT '会员邮箱',
    `last_ip`         varchar(50)  NULL COMMENT '最后登录IP',
    `loc`             int(11)      NULL DEFAULT 0 COMMENT '每登录一次加1',
    `last_login_time` int(11)      NULL COMMENT '最后登录时间',
    `sex`             tinyint(4)   NULL DEFAULT 0 COMMENT '性别：默认 0{0 保密 1 男 2 女}',
    `birthday`        varchar(50)  NULL COMMENT '生日',
    `encrypted`       varchar(50)  NULL COMMENT '加密串',
    `is_del`          tinyint(4)   NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time`     int(11)      NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '会员';

DROP TABLE IF EXISTS `tb_user_address`;
CREATE TABLE `tb_user_address`
(
    `id`             bigint(20)   NOT NULL AUTO_INCREMENT,
    `shaer_id`       bigint(20)   NULL comment '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `shaer_type`     tinyint(4)   NULL default 0 comment '用户类型 默认: 0 会员、1 供应商、2 员工',
    `province`       varchar(50)  NULL COMMENT '省',
    `city`           varchar(50)  NULL COMMENT '市',
    `district`       varchar(50)  NULL COMMENT '区',
    `address`        varchar(150) NULL COMMENT '具体地址',
    `zip`            varchar(6)   NULL COMMENT '邮编',
    `name`           varchar(30)  NULL COMMENT '联系人',
    `phone`          varchar(11)  NULL COMMENT '联系电话',
    `last_used_time` int(11)      NULL COMMENT '最后一次使用',
    `create_time`    int(11)      NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '用户地址{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)}';

DROP TABLE IF EXISTS `tb_user_commission_bill`;
CREATE TABLE `tb_user_commission_bill`
(
    `id`          bigint(20)    NOT NULL AUTO_INCREMENT,
    `shaer_id`    bigint(20)    NULL comment '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `shaer_type`  tinyint(4)    NULL comment '用户类型 0 会员、1 供应商、2 员工',
    `level`       tinyint(1)    NOT NULL DEFAULT '1' COMMENT '等级：1一级佣金，2二级佣金',
    `order_id`    int(11)       NULL COMMENT '订单ID',
    `commission`  decimal(8, 2) NOT NULL DEFAULT '0.00' COMMENT '佣金',
    `status`      tinyint(1)    NOT NULL DEFAULT '0' COMMENT '状态 0冻结中，1生效，-1失效',
    `explain`     varchar(250)  NULL COMMENT '说明',
    `create_time` int(11)       NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='用户分佣账单{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)}';

DROP TABLE IF EXISTS `tb_user_bill`;
CREATE TABLE `tb_user_bill`
(
    `id`          bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '用户账单id',
    `shaer_id`    bigint(20)    NULL comment '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `shaer_type`  tinyint(4)    NULL     default 0 comment '用户类型 默认: 0 会员、1 供应商、2 员工',
    `link_id`     varchar(32)   NOT NULL DEFAULT '0' COMMENT '关联id',
    `pm`          tinyint(4)    NOT NULL DEFAULT 0 COMMENT '0 = 支出 1 = 获得',
    `title`       varchar(64)   NOT NULL DEFAULT '' COMMENT '账单标题',
    `category`    varchar(64)   NOT NULL DEFAULT '' COMMENT '明细种类',
    `bill_type`   varchar(64)   NOT NULL DEFAULT '' COMMENT '明细类型(佣金等)',
    `num`         decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '明细数字',
    `balance`     decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '剩余',
    `explain`     varchar(512)  NOT NULL DEFAULT '' COMMENT '说明',
    `status`      tinyint(4)    NOT NULL DEFAULT 1 COMMENT '0 = 带确定 1 = 有效 -1 = 无效',
    `is_del`      tinyint(4)    NULL     DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time` int(11)       NULL     DEFAULT NULL COMMENT '添加时间',
    `update_time` int(11)       NULL     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '会员账单{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)}';

DROP TABLE IF EXISTS `tb_user_extract`;
CREATE TABLE `tb_user_extract`
(
    `id`            bigint(20)    NOT NULL AUTO_INCREMENT,
    `shaer_id`      bigint(20)    NULL comment '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `shaer_type`    tinyint(4)    NULL default 0 comment '用户类型 默认: 0 会员、1 供应商、2 员工',
    `real_name`     varchar(64)   NULL DEFAULT NULL COMMENT '真实姓名名称',
    `extract_type`  varchar(32)   NULL DEFAULT 'bank' COMMENT '提现类型: 默认： bank {bank=银行卡 alipay=支付宝 wx=微信}',
    `bank_code`     varchar(32)   NULL DEFAULT '0' COMMENT '银行卡',
    `bank_address`  varchar(256)  NULL DEFAULT '' COMMENT '开户地址',
    `alipay_code`   varchar(64)   NULL DEFAULT '' COMMENT '支付宝账号',
    `extract_price` decimal(8, 2) NULL DEFAULT 0.00 COMMENT '提现金额',
    `explain`       varchar(512)  NULL DEFAULT NULL COMMENT '说明',
    `balance`       decimal(8, 2) NULL DEFAULT 0.00 COMMENT '账目',
    `fail_msg`      varchar(128)  NULL DEFAULT NULL COMMENT '无效原因',
    `fail_time`     int(11)       NULL DEFAULT NULL COMMENT '无效发生的时间',
    `status`        tinyint(4)    NULL DEFAULT 0 COMMENT '-1 未通过 0 审核中 1 已提现',
    `wechat`        varchar(32)   NULL DEFAULT NULL COMMENT '微信号',
    `is_del`        tinyint(4)    NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time`   int(11)       NULL DEFAULT NULL COMMENT '添加时间',
    `update_time`   int(11)       NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '用户提现';

DROP TABLE IF EXISTS `tb_share_bind`;
CREATE TABLE `tb_share_bind`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `open_type`   varchar(50)  NOT NULL COMMENT '类型{sinaweibo、qq、weixin等}与open_id配合使用',
    `open_id`     varchar(255) NOT NULL COMMENT '开放编号',
    `shaer_id`    bigint(20)   NULL comment '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `shaer_type`  tinyint(4)   NULL default 0 comment '用户类型 默认: 0 会员、1 供应商、2 员工',
    `nick_name`   varchar(50)  NULL COMMENT '昵称',
    `avatar`      varchar(200) NULL COMMENT '头像地址',
    `explain`     varchar(255) NULL COMMENT '说明',
    `create_time` int(11)      NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '第三方用户绑定信息{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)}';

DROP TABLE IF EXISTS `tb_distribution_setting`;
CREATE TABLE `tb_distribution_setting`
(
    `id`               bigint(20)  NOT NULL AUTO_INCREMENT,
    `status`           tinyint(4)  NOT NULL DEFAULT '1' COMMENT '分销启用:0禁用1启用',
    `first_rebate`     tinyint(4)  NOT NULL COMMENT '一级返佣比例',
    `second_rebate`    tinyint(4)  NOT NULL COMMENT '二级返佣比例',
    `spread_banners`   text        NOT NULL COMMENT '分销海报图',
    `brokerage`        tinyint(1)  NOT NULL DEFAULT '0' COMMENT '自购返佣:0否1是',
    `settlement_days`  smallint(6) NOT NULL COMMENT '结算时间（单位：天）',
    `brokerage_method` varchar(20) NOT NULL DEFAULT 'hand' COMMENT '佣金到账方式:hand手动,wx微信',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT ='分销设置';

DROP TABLE IF EXISTS `tb_user_distribution`;
CREATE TABLE `tb_user_distribution`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `dist_id`    bigint(20) NOT NULL COMMENT '分销Id',
    `shaer_id`   bigint(20) NULL comment '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `shaer_type` tinyint(4) NULL default 0 comment '用户类型 默认: 0 会员、1 供应商、2 员工',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '用户分销关联(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)';



