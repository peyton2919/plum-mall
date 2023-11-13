DROP TABLE IF EXISTS `tb_shop_category`;
CREATE TABLE `tb_shop_category`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT COMMENT '商品分类表Id',
    `pid`         int(11)      NOT NULL DEFAULT 0 COMMENT '父Id,默认0最高级别Id',
    `name`        varchar(100) NOT NULL COMMENT '分类名称',
    `seq`         smallint(6)  NULL     DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `icon`        varchar(250) NULL COMMENT '图标',
    `is_show`     tinyint(4)   NULL     DEFAULT 1 COMMENT '是否推荐,默认1 {1为推荐 0 不推荐}',
    `is_del`      tinyint(4)   NULL     DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time` int(11)      NULL     DEFAULT NULL COMMENT '添加时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品分类';

DROP TABLE IF EXISTS `tb_shop_product_category`;
CREATE TABLE `tb_shop_product_category`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `category_id` int(11)    NOT NULL DEFAULT 0 COMMENT '商品分类Id',
    `product_id`  bigint(20) NULL COMMENT '商品Id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品与商品分类关联';

DROP TABLE IF EXISTS `tb_shop_product`;
CREATE TABLE `tb_shop_product`
(
    `id`            bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '商品Id',
    `cover`         varchar(256)  NULL COMMENT '商品图片',
    `name`          varchar(128)  NULL COMMENT '商品名称',
    `info`          varchar(256)  NULL COMMENT '商品简介',
    `keyword`       varchar(256)  NULL COMMENT '关键字',
    `temp_id`       int(11)       NULL DEFAULT NULL COMMENT '运费模板Id',
    `price`         decimal(8, 2) NULL DEFAULT 0.00 COMMENT '商品价格(批发)',
    `vip_price`     decimal(8, 2) NULL DEFAULT 0.00 COMMENT '会员价格',
    `ot_price`      decimal(8, 2) NULL DEFAULT 0.00 COMMENT '市场价',
    `cost_price`    decimal(8, 2) NULL DEFAULT NULL COMMENT '成本价',
    `postage`       decimal(8, 2) NULL DEFAULT 0.00 COMMENT '邮费',
    `unit_name`     varchar(32)   NULL DEFAULT NULL COMMENT '单位名',
    `seq`           smallint(6)   NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `sales`         int(11)       NULL DEFAULT 0 COMMENT '销量, 默认 0',
    `stock`         int(11)       NULL DEFAULT 0 COMMENT '库存, 默认 0',
    `browse`        int(11)       NULL DEFAULT 0 COMMENT '浏览量(每浏览一次加 1)',
    `ficti`         int(11)       NULL DEFAULT 100 COMMENT '虚拟销量',
    `code_path`     varchar(128)  NULL DEFAULT '' COMMENT '产品二维码地址(用户小程序海报)',
    `explain`       text          NULL COMMENT '产品描述',
    `spec_type`     tinyint(4)    NULL DEFAULT 0 COMMENT '规格 0单 1多',
    `is_show`       tinyint(4)    NULL DEFAULT 1 COMMENT '状态（0：未上架，1：上架）',
    `is_hot`        tinyint(4)    NULL DEFAULT 0 COMMENT '是否热卖',
    `is_benefit`    tinyint(4)    NULL DEFAULT 0 COMMENT '是否优惠',
    `is_best`       tinyint(4)    NULL DEFAULT 1 COMMENT '是否精品',
    `is_new`        tinyint(4)    NULL DEFAULT 1 COMMENT '是否新品',
    `is_postage`    tinyint(4)    NULL DEFAULT 0 COMMENT '是否包邮',
    `is_del`        tinyint(4)    NULL DEFAULT 1 COMMENT '是否删除',
    `is_good`       tinyint(4)    NULL DEFAULT 0 COMMENT '是否优品推荐, 默认0 {0 不是 1 是}',
    `is_sub`        tinyint(4)    NULL DEFAULT 0 COMMENT '是否单独分佣, 默认 0 没有 1 有',
    `give_integral` int(11)       NULL DEFAULT NULL COMMENT '获得积分',
    `is_integral`   tinyint(4)    NULL DEFAULT 0 COMMENT '是否开启积分兑换, 默认0 { 0没开启 1 开启}',
    `integral`      int(11)       NULL DEFAULT 0 COMMENT '需要多少积分兑换',
    `create_time`   int(11)       NULL COMMENT '添加时间',
    `update_time`   int(11)       NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品信息';

DROP TABLE IF EXISTS `tb_shop_product_sku`;
CREATE TABLE `tb_shop_product_sku`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT,
    `product_id`     bigint(20) NULL COMMENT '商品Id',
    `sku_id`         bigint(20) NULL COMMENT '规格Id',
    `product_sku_id` bigint(20) NULL COMMENT '商品规格Id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品规格关联';

DROP TABLE IF EXISTS `tb_shop_sku`;
CREATE TABLE `tb_shop_sku`
(
    `id`       bigint(20)  NOT NULL AUTO_INCREMENT,
    `name`     varchar(50) NOT NULL COMMENT '规格名称',
    `sku_type` tinyint(4)       default 0 COMMENT '商品属性卡片属性类型 0无 1颜色 2图片 默认: 0',
    `seq`      smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品规格';

DROP TABLE IF EXISTS `tb_shop_sku_value`;
CREATE TABLE `tb_shop_sku_value`
(
    `id`        bigint(20)  NOT NULL AUTO_INCREMENT,
    `sku_id`    bigint(20)  NOT NULL COMMENT '商品规格Id',
    `sku_value` varchar(50) NOT NULL COMMENT '商品属性参数',
    `seq`       smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品规格 值';

DROP TABLE IF EXISTS `tb_shop_product_sku_detail`;
CREATE TABLE `tb_shop_product_sku_detail`
(
    `id`                bigint(20)     NOT NULL AUTO_INCREMENT COMMENT '编号 { 对应 psd_id }',
    `product_id`        bigint(20)     NULL COMMENT '商品Id',
    `skus`              varchar(128)   NULL COMMENT '商品属性索引值 (attr_value|attr_value[|....])',
    `stock`             int(11)        NULL DEFAULT 0 COMMENT '属性对应的库存,默认0',
    `sales`             int(11)        NULL DEFAULT 0 COMMENT '销量,默认0',
    `cover`             varchar(256)   NULL COMMENT '封面图片',
    `unique_code`       varchar(64)    NULL COMMENT '唯一值',
    `bar_code`          varchar(255)   NULL COMMENT '商品条码',
    `integral`          int(11)             DEFAULT 0 COMMENT '需要多少积分兑换',
    `price`             decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '商品价格(批发)',
    `vip_price`         decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '会员价格',
    `ot_price`          decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '市场价格',
    `cost_price`        decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '成本价格',
    `weight`            decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '重量',
    `volume`            decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '体积',
    `brokerage`         decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '一级返佣',
    `brokerage_two`     decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '二级返佣',
    `pink_price`        decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '拼团价格',
    `pink_stock`        int(11)        NULL DEFAULT 0 COMMENT '拼团库存',
    `bargain_price`     decimal(8, 2)  NULL DEFAULT 0.00 COMMENT '砍价价格',
    `bargain_stock`     int(11)        NULL DEFAULT 0 COMMENT '砍价库存',
    `seckill_price`     decimal(10, 2) NULL DEFAULT 0.00 COMMENT '秒杀价格',
    `seckill_stock`     int(11)        NULL DEFAULT 0 COMMENT '秒杀库存',
    `warehouse_id`      int(11)        NULL COMMENT '仓库Id',
    `warehouse_explain` varchar(150)   NULL COMMENT '仓库说明',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品规格详细';

DROP TABLE IF EXISTS `tb_shop_product_rule`;
CREATE TABLE `tb_shop_product_rule`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `rule_name`   varchar(32) NULL COMMENT '规格名称',
    `rule_value`  text        NULL COMMENT '规格值:[{detail:[黑色,白色],value:颜色},{detail:[111,112],value:尺寸},...]',
    `hot`         int(11)     not null default 0 comment '使用热度(数值越大越靠前)',
    `is_del`      tinyint(4)  NULL     DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time` int(11)     NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品规格--(规则)';

DROP TABLE IF EXISTS `tb_shop_slideshow`;
CREATE TABLE `tb_shop_slideshow`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `product_id`  bigint(20)   NULL COMMENT '商品Id',
    `src`         varchar(150) NULL COMMENT '轮播图地址',
    `url`         varchar(255) NULL COMMENT '轮播图链接地址(超链接跳转)',
    `create_time` int(11)      NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品轮播图';

DROP TABLE IF EXISTS `tb_shop_product_attrs`;
CREATE TABLE `tb_shop_product_attrs`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT,
    `product_id` bigint(20) NULL COMMENT '商品Id',
    `attr_id`    bigint(20) NULL COMMENT '属性Id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品属性关联';

DROP TABLE IF EXISTS `tb_shop_attrs`;
CREATE TABLE `tb_shop_attrs`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
    `product_id`  bigint(20)        DEFAULT '0' COMMENT '商品Id',
    `seq`         smallint(6)  NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `attr_value`  varchar(100) NULL COMMENT '属性值',
    `attr_name`   varchar(100) NULL COMMENT '商品类型属性名称',
    `attr_icon`   varchar(100) NULL COMMENT '商品类型属性icon',
    `explain`     varchar(255) NULL COMMENT '说明',
    `method_type` tinyint(4)        DEFAULT '0' COMMENT '表单提交类型;默认: 0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品属性';

DROP TABLE IF EXISTS `tb_shop_product_relation`;
CREATE TABLE `tb_shop_product_relation`
(
    `id`            bigint(20)  NOT NULL AUTO_INCREMENT,
    `share_id`      bigint(20)  NULL COMMENT '用户Id(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `product_id`    bigint(20)  NULL COMMENT '商品Id',
    `share_type`    tinyint(4)  NULL DEFAULT 0 COMMENT '用户类型 0 会员、1 供应商、2 员工',
    `relation_type` tinyint(4)  NULL DEFAULT 0 COMMENT '类型(0 收藏(collect）、1 点赞(like))',
    `category`      varchar(32) NULL COMMENT '某种类型的商品(普通商品、秒杀商品)',
    `is_del`        tinyint(1)  NULL DEFAULT 1 COMMENT '是否删除: 默认1(1 可用;0 已删除)',
    `create_time`   int(11)     NULL COMMENT '添加时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品点赞和收藏';

DROP TABLE IF EXISTS `tb_shop_product_reply`;
CREATE TABLE `tb_shop_product_reply`
(
    `id`                     bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '评论Id',
    `u_id`                   bigint(20)   NULL COMMENT '会员Id',
    `o_id`                   bigint(20)   NULL COMMENT '订单Id',
    `unique_code`            varchar(64)  NULL COMMENT '唯一Id',
    `product_id`             bigint(20)   NULL COMMENT '产品Id',
    `reply_type`             tinyint(4)   NULL DEFAULT 0 COMMENT '评论商品类型(0 普通销售、1 秒杀、2 砍价、3 拼团）',
    `product_score`          tinyint(4)   NULL DEFAULT 10 COMMENT '商品分数（1-10）',
    `service_score`          tinyint(4)   NULL DEFAULT 10 COMMENT '服务分数（1-10）',
    `reply_comment`          varchar(512) NULL COMMENT '评论内容',
    `is_del`                 tinyint(4)   NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time`            int(11)      NULL COMMENT '评论时间',
    `is_reply`               tinyint(4)   NULL DEFAULT 0 COMMENT '是否回复, 默认:0 {0 未回复 1 已回复}',
    `merchant_reply_content` varchar(300) NULL DEFAULT NULL COMMENT '管理员回复内容',
    `merchant_reply_time`    int(11)      NULL COMMENT '管理员回复时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品评论';

DROP TABLE IF EXISTS `tb_shop_product_reply_img`;
CREATE TABLE `tb_shop_product_reply_img`
(
    `id`         bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '评论Id',
    `product_id` bigint(20)   NULL COMMENT '产品Id',
    `src`        varchar(150) NULL COMMENT '图片地址',
    `is_show`    tinyint(4)   NULL DEFAULT 1 COMMENT '是否显示, 默认: 1 显示, 0 不显示',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '商品评论';
