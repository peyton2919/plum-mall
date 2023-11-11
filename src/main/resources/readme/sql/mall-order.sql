DROP TABLE IF EXISTS `tb_shop_cart`;
CREATE TABLE `tb_shop_cart`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车Id',
    `share_id`    bigint(20) NULL COMMENT '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `share_type`  tinyint(4) NULL     DEFAULT 0 COMMENT '用户类型 ,默认 0 会员、1 供应商、2 员工',
    `num`         int(11)    NULL     DEFAULT 0 COMMENT '商品数量,默认: 0',
    `is_pay`      tinyint(4) NOT NULL DEFAULT 0 COMMENT '0 = 未购买 1 = 已购买',
    `is_del`      tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `is_new`      tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否为立即购买,默认0 未立即购买 1购买',
    `pink_id`     bigint(20) NULL     DEFAULT 0 COMMENT '拼团id',
    `seckill_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '秒杀产品ID',
    `bargain_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '砍价id',
    `create_time` int(11)    NULL     DEFAULT NULL COMMENT '添加时间',
    `update_time` int(11)    NULL     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '购物车';

DROP TABLE IF EXISTS `tb_shop_order`;
CREATE TABLE `tb_shop_order`
(
    `id`              bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    `order_no`        varchar(40)   NOT NULL COMMENT '订单号',
    `extend_order_no` varchar(40)   NULL COMMENT '额外订单号',
    `share_id`        bigint(20)    NOT NULL COMMENT '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `share_type`      tinyint(4)    NOT NULL DEFAULT 0 COMMENT '用户类型 ,默认 0 会员、1 供应商、2 员工',
    `explain`         varchar(512)  NULL COMMENT '备注',
    `closed`          tinyint(4)    null     default 0 comment '是否关闭 默认 0 开,1 为关闭, 后端用定时器处理, 关闭后 商品数量返原',
    `cart_id`         bigint(20)    NULL COMMENT '购物车id',
    `freight_price`   decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '运费金额',
    `total_num`       int(11)       NOT NULL DEFAULT 0 COMMENT '订单商品总数',
    `total_price`     decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '订单总价',
    `total_postage`   decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '邮费',
    `pay_price`       decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '实际支付金额',
    `pay_postage`     decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '支付邮费',
    `deduction_price` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '抵扣金额',
    `coupon_id`       bigint(20)    NOT NULL DEFAULT 0 COMMENT '优惠券id',
    `coupon_price`    decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '优惠券金额',
    `paid`            tinyint(4)    NOT NULL DEFAULT 0 COMMENT '支付状态,默认0 未支付 1已支付',
    `pay_time`        int(11)       NULL COMMENT '支付时间',
    `pay_type`        varchar(32)   NOT NULL DEFAULT 'bank' COMMENT '支付类型: 默认：bank {bank=银行卡 alipay=支付宝 wx=微信 cash=现金}',
    `create_time`     int(11)       NULL COMMENT '创建时间',
    `update_time`     int(11)       NULL COMMENT '更新时间',
    `status`          tinyint(4)    NOT NULL DEFAULT 0 COMMENT '订单状态（-1 : 申请退款 -2 : 退货成功 0：待发货；1：待收货；2：已收货；3：已完成；-1：已退款）',
    `refund_status`   tinyint(4)    NOT NULL DEFAULT 0 COMMENT '0 未退款 1 申请中 2 已退款',
    `refund_id`       bigint(20)    NOT NULL DEFAULT 0 COMMENT '退款Id',
    `gain_integral`   int(11)       NOT NULL DEFAULT 0 COMMENT '消费赚取积分',
    `use_integral`    int(11)       NOT NULL DEFAULT 0 COMMENT '使用积分',
    `pay_integral`    int(11)       NOT NULL DEFAULT 0 COMMENT '实际支付积分',
    `back_integral`   int(11)       NOT NULL DEFAULT 0 COMMENT '给用户退了多少积分',
    `is_del`          tinyint(4)    NOT NULL DEFAULT 1 COMMENT '是否删除,默认: 1 可用;0 已删除',
    `admin_remark`    varchar(512)  NULL COMMENT '管理员备注',
    `pink_id`         bigint(20)    NOT NULL DEFAULT 0 COMMENT '拼团Id, 默认 0 不是拼团',
    `seckill_id`      bigint(20)    NOT NULL DEFAULT 0 COMMENT '秒杀产品Id, 默认 0 不是秒杀产品',
    `bargain_id`      bigint(20)    NOT NULL DEFAULT 0 COMMENT '砍价Id, 默认 0 不是砍价产品',
    `verify_code`     varchar(50)   NULL COMMENT '核销码',
    `shop_id`         bigint(20)    NOT NULL DEFAULT 0 COMMENT '门店id',
    `shipping_type`   tinyint(4)    NOT NULL DEFAULT 1 COMMENT '配送方式 1=快递 ，2=门店自提',
    `delivery_sn`     varchar(100)  NULL COMMENT '快递公司编号',
    `delivery_name`   varchar(64)   NULL COMMENT '快递名称/送货人姓名',
    `delivery_type`   varchar(32)   NULL COMMENT '发货类型',
    `delivery_id`     varchar(64)   NULL COMMENT '快递单号/手机号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '订单';

DROP TABLE IF EXISTS `tb_shop_order_item`;
CREATE TABLE `tb_shop_order_item`
(
    `id`             bigint(20)    NOT NULL AUTO_INCREMENT,
    `o_id`           bigint(20)    NULL COMMENT '订单id',
    `order_no`       varchar(40)   NULL     DEFAULT NULL COMMENT '订单号',
    `cart_id`        bigint(20)    NOT NULL DEFAULT 0 COMMENT '购物车id',
    `psd_id`         bigint(20)    NOT NULL DEFAULT 0 COMMENT '商品规格详细Id(shop_product_detail)',
    `num`            int(11)       NOT NULL DEFAULT 0 COMMENT '数量',
    `price`          decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '单价',
    `is_after_sales` tinyint(4)    NULL     DEFAULT 1 COMMENT '是否能售后, 默认 1 {0不能 1 能}',
    `is_show`        tinyint(4)    NULL     DEFAULT 1 COMMENT '是否显示, 默认: 1 显示, 0 不显示',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '订单--项';

DROP TABLE IF EXISTS `tb_shop_order_refund`;
CREATE TABLE `tb_shop_order_refund`
(
    `id`           bigint(20)    NOT NULL AUTO_INCREMENT,
    `imgs`         varchar(512)  NULL COMMENT '退款图片{json格式}',
    `explain`      varchar(255)  NULL COMMENT '退款用户说明',
    `reason`       varchar(255)  NULL COMMENT '退款原因',
    `no_reason`    varchar(512)  NULL COMMENT '不退款理由{json格式}',
    `refund_price` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '退款金额',
    `create_time`  int(11)       NULL COMMENT '创建时间',
    `update_time`  int(11)       NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '订单退款';

DROP TABLE IF EXISTS `tb_shop_order_record`;
CREATE TABLE `tb_shop_order_record`
(
    `id`              bigint(20)   NOT NULL AUTO_INCREMENT,
    `o_id`            bigint(20)   NULL COMMENT '订单id',
    `operate_type`    varchar(32)  NULL COMMENT '操作类型',
    `operate_message` varchar(512) NULL COMMENT '操作信息{json格式}',
    `operate_ip`      varchar(64)  NULL COMMENT '操作者IP地址',
    `create_time`     int(11)      NULL COMMENT '创建时间',
    `update_time`     int(11)      NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '订单操作记录';

DROP TABLE IF EXISTS `tb_shop_coupon`;
CREATE TABLE `tb_shop_coupon`
(
    `id`          bigint(20)     NOT NULL AUTO_INCREMENT,
    `name`        varchar(50)    NULL COMMENT '优惠券名称',
    `type`        tinyint(4)     NULL DEFAULT 0 COMMENT '类型, 默认: 0 固定金额 1 百分比(与value配合使用)',
    `value`       decimal(10, 2) NULL DEFAULT 0.00 COMMENT '折扣值，根据 type 不同 含义不同',
    `remark`      varchar(255)   NULL COMMENT '备注',
    `total`       int(11)        NULL DEFAULT 0 COMMENT '总数',
    `used`        int(11)        NULL DEFAULT 0 COMMENT '已使用数量',
    `min_price`   decimal(10, 2) NULL DEFAULT 0.00 COMMENT '最低价格',
    `max_price`   decimal(10, 2) NULL DEFAULT 0.00 COMMENT '最低价格',
    `start_time`  int(11)        NULL DEFAULT NULL COMMENT '开始时间',
    `end_time`    int(11)        NULL DEFAULT NULL COMMENT '结束时间',
    `status`      tinyint(4)     NULL DEFAULT 1 COMMENT '优惠券是否生效:默认 1 {0不生效 1生效 2删除}',
    `seq`         smallint(6)    NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `create_time` int(11)        NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '优惠券';

DROP TABLE IF EXISTS `tb_shop_coupon_member`;
CREATE TABLE `tb_shop_coupon_member`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `coupon_id`   bigint(20) NULL     DEFAULT NULL COMMENT '优惠券id',
    `share_id`    bigint(20) NULL COMMENT '用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)',
    `share_type`  tinyint(4) NULL     DEFAULT 0 COMMENT '用户类型 ,默认 0 会员、1 供应商、2 员工',
    `used`        tinyint(4) NULL     DEFAULT 0 COMMENT '是否已使用 默认: 0未使用 1已使用',
    `status`      tinyint(4) NOT NULL DEFAULT 1 COMMENT '是否可用,默认: 1 可用;0 不可用;2 删除;',
    `create_time` int(11)    NULL     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '优惠券会员(关联优惠券与会员)';


