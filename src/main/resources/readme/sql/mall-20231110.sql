DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting`
(
    `id`                 int(11)      NOT NULL AUTO_INCREMENT,
    `open_reg`           tinyint(4)   NOT NULL DEFAULT 1 COMMENT '开启注册，0关闭1开启',
    `reg_method`         varchar(30)  NOT NULL DEFAULT 'username' COMMENT '注册方式，username普通phone手机',
    `password_min`       tinyint(4)   NOT NULL DEFAULT 6 COMMENT '密码最小长度;默认6',
    `password_encrypt`   varchar(100) NOT NULL DEFAULT '' COMMENT '强制密码复杂度',
    `upload_method`      varchar(10)  NOT NULL COMMENT '上传方式',
    `upload_config`      text         NULL COMMENT '上传配置',
    `api_safe`           tinyint(4)   NOT NULL DEFAULT 0 COMMENT '是否开启API安全，0否1是',
    `api_secret`         varchar(255) NOT NULL COMMENT 'api秘钥',
    `close_order_minute` int(11)      NOT NULL DEFAULT 30 COMMENT '自动取消订单，分钟',
    `auto_received_day`  int(11)      NOT NULL DEFAULT 7 COMMENT '自动收货时间，天',
    `after_sale_day`     int(11)      NOT NULL DEFAULT 7 COMMENT '允许申请售后，天',
    `alipay`             text         NOT NULL COMMENT '支付宝支付配置',
    `wxpay`              text         NOT NULL COMMENT '微信支付配置',
    `ship`               text         NOT NULL COMMENT '物流相关配置',
    `status`             tinyint(4)   NOT NULL DEFAULT 1 COMMENT '系统状态，默认0 系统关闭，1 系统开启',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '系统设置';

DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `id`           bigint(20)  NOT NULL AUTO_INCREMENT,
    `type`         tinyint(4)  NOT NULL DEFAULT 0 COMMENT '类型 0：异常',
    `target_id`    bigint(20)  NOT NULL COMMENT '基于type后指定的对象id，比如用户、权限、角色等表的主键',
    `old_value`    text        NULL COMMENT '旧值',
    `new_value`    text        NULL COMMENT '新值',
    `operator`     varchar(50) NOT NULL DEFAULT '' COMMENT '操作者',
    `operate_time` int(11)     NULL     DEFAULT NULL COMMENT '最后一次更新的时间',
    `operate_ip`   varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
    `status`       tinyint(4)  NOT NULL DEFAULT 0 COMMENT '当前是否复原过，默认 0：没有，1：复原过',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '日志信息';

DROP TABLE IF EXISTS `sys_user_log`;
CREATE TABLE `sys_user_log`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `user_id`     bigint(20)  NOT NULL COMMENT '会员编号',
    `old_value`   text        NULL COMMENT '旧值',
    `new_value`   text        NULL COMMENT '新值',
    `operate_ip`  varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
    `create_time` int(11)     NULL     DEFAULT NULL COMMENT '创建时间',
    `status`      tinyint(4)  NOT NULL DEFAULT 0 COMMENT '当前是否复原过，默认 0：没有，1：复原过',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '用户日志';

DROP TABLE IF EXISTS `sys_member_log`;
CREATE TABLE `sys_member_log`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `member_id`   bigint(20)  NOT NULL COMMENT '会员编号',
    `old_value`   text        NULL COMMENT '旧值',
    `new_value`   text        NULL COMMENT '新值',
    `operate_ip`  varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
    `create_time` int(11)     NULL     DEFAULT NULL COMMENT '创建时间',
    `status`      tinyint(4)  NOT NULL DEFAULT 0 COMMENT '当前是否复原过，默认 0：没有，1：复原过',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '会员日志';

DROP TABLE IF EXISTS `sys_supplier_log`;
CREATE TABLE `sys_supplier_log`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `supplier_id` bigint(20)  NOT NULL COMMENT '供应商编号',
    `old_value`   text        NULL COMMENT '旧值',
    `new_value`   text        NULL COMMENT '新值',
    `operate_ip`  varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
    `create_time` int(11)     NULL     DEFAULT NULL COMMENT '创建时间',
    `status`      tinyint(4)  NOT NULL DEFAULT 0 COMMENT '当前是否复原过，默认 0：没有，1：复原过',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '供应商日志';

DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`
(
    `id`      bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`    varchar(255) NOT NULL COMMENT '字典名称',
    `explain` varchar(255) NULL DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '数据字典';

DROP TABLE IF EXISTS `sys_dict_detail`;
CREATE TABLE `sys_dict_detail`
(
    `id`         bigint(20)   NOT NULL AUTO_INCREMENT,
    `dict_id`    bigint(20)   NULL DEFAULT NULL COMMENT '字典id',
    `label`      varchar(255) NOT NULL COMMENT '字典标签',
    `dict_value` varchar(255) NOT NULL COMMENT '字典值',
    `seq`        smallint(6)  NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '数据字典详情';

DROP TABLE IF EXISTS `sys_material_group`;
CREATE TABLE `sys_material_group`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `create_id`   bigint(20)   NULL DEFAULT NULL COMMENT '创建者ID',
    `name`        varchar(200) NOT NULL COMMENT '分组名',
    `create_type` tinyint(4)   NULL DEFAULT 0 COMMENT '创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}',
    `create_time` int(11)      NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '素材分组';

DROP TABLE IF EXISTS `sys_material`;
CREATE TABLE `sys_material`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `create_id`   bigint(20)   NULL     DEFAULT NULL COMMENT '创建者ID',
    `type`        tinyint(4)   NOT NULL DEFAULT 1 COMMENT '类型1、图片；2、视频',
    `group_id`    bigint(20)   NULL     DEFAULT NULL COMMENT '分组ID',
    `name`        varchar(200) NOT NULL COMMENT '素材名',
    `url`         varchar(500) NULL     DEFAULT '' COMMENT '素材链接',
    `create_type` tinyint(4)   NULL     DEFAULT 0 COMMENT '创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}',
    `create_time` int(11)      NULL     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '素材库';

DROP TABLE IF EXISTS `sys_area_all`;
CREATE TABLE `sys_area_all`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT,
    `city_id`     int(11)      NOT NULL DEFAULT 0 COMMENT '城市id',
    `level`       int(11)      NOT NULL DEFAULT 0 COMMENT '省市级别,0省1市2县3区4镇5乡6村',
    `parent_id`   int(11)      NOT NULL DEFAULT 0 COMMENT '父级id',
    `area_code`   varchar(30)  NOT NULL DEFAULT '' COMMENT '区号',
    `name`        varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
    `merger_name` varchar(255) NOT NULL DEFAULT '' COMMENT '合并名称,如：省名,市名,县名...',
    `lng`         varchar(50)  NOT NULL DEFAULT '' COMMENT '经度',
    `lat`         varchar(50)  NOT NULL DEFAULT '' COMMENT '纬度',
    `is_show`     tinyint(1)   NOT NULL DEFAULT 1 COMMENT '是否展示',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '城市';


DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        varchar(50) NOT NULL COMMENT '名称',
    `pid`         int(11)     NOT NULL DEFAULT 0 COMMENT '上级部门',
    `seq`         smallint(6) NULL     DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `create_time` int(11)     NULL     DEFAULT NULL COMMENT '创建日期',
    `is_del`      tinyint(4)  NULL     DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '部门';

DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        varchar(100) NOT NULL COMMENT '岗位名称',
    `seq`         smallint(6)  NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `dept_id`     int(11)      NULL DEFAULT NULL COMMENT '部门ID',
    `create_time` int(11)      NULL DEFAULT NULL COMMENT '创建日期',
    `is_del`      tinyint(4)   NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '岗位';

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`             bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `i_frame`        tinyint(4)   NULL     DEFAULT 0 COMMENT '是否外链,默认0没有外链接,1外链接',
    `name`           varchar(50)  NULL     DEFAULT NULL COMMENT '菜单名称',
    `component`      varchar(255) NULL     DEFAULT NULL COMMENT '组件',
    `pid`            bigint(20)   NOT NULL DEFAULT 0 COMMENT '上级菜单ID',
    `seq`            smallint(6)  NULL     DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `icon`           varchar(255) NULL     DEFAULT NULL COMMENT '图标',
    `path`           varchar(255) NULL     DEFAULT NULL COMMENT '链接地址',
    `cache`          tinyint(4)   NULL     DEFAULT 0 COMMENT '是否缓存; 默认 0不缓存, 1缓存',
    `hidden`         tinyint(4)   NULL     DEFAULT 0 COMMENT '是否隐藏; 默认0不隐藏, 1隐藏',
    `component_name` varchar(20)  NULL     DEFAULT '-' COMMENT '组件名称',
    `create_time`    int(11)      NULL     DEFAULT NULL COMMENT '创建日期',
    `permission`     varchar(255) NULL     DEFAULT NULL COMMENT '权限',
    `type`           tinyint(4)   NULL     DEFAULT 0 COMMENT '类型: 默认 0 {0 文字1 图片2 按钮3 ICON}',
    `is_del`         tinyint(4)   NULL     DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `router`         varchar(255) NULL     DEFAULT NULL COMMENT '操作的路由',
    `router_method`  varchar(255) NULL     DEFAULT '' COMMENT '路由动作',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '菜单';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        varchar(50)  NOT NULL COMMENT '名称',
    `remark`      varchar(255) NULL DEFAULT NULL COMMENT '备注',
    `data_scope`  varchar(255) NULL DEFAULT NULL COMMENT '数据权限',
    `level`       int(11)      NULL DEFAULT NULL COMMENT '角色级别',
    `create_time` int(11)      NULL DEFAULT NULL COMMENT '创建日期',
    `permission`  varchar(255) NULL DEFAULT NULL COMMENT '功能权限',
    `update_time` int(11)      NULL DEFAULT NULL COMMENT '更新时间',
    `is_del`      tinyint(4)   NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '角色';

DROP TABLE IF EXISTS `sys_roles_depts`;
CREATE TABLE `sys_roles_depts`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id` bigint(20) NOT NULL,
    `dept_id` int(11)    NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '角色部门关联';

DROP TABLE IF EXISTS `sys_roles_menus`;
CREATE TABLE `sys_roles_menus`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '角色菜单关联';

DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) NOT NULL COMMENT '用户ID',
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '用户角色关联';

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `avatar`      varchar(200) NULL DEFAULT NULL COMMENT '头像',
    `email`       varchar(255) NULL DEFAULT NULL COMMENT '邮箱',
    `enabled`     tinyint(4)   NULL DEFAULT NULL COMMENT '状态：1启用、0禁用',
    `password`    varchar(255) NULL DEFAULT NULL COMMENT '密码',
    `username`    varchar(255) NULL DEFAULT NULL COMMENT '用户名',
    `dept_id`     bigint(20)   NULL DEFAULT NULL COMMENT '部门名称',
    `phone`       varchar(255) NULL DEFAULT NULL COMMENT '手机号码',
    `job_id`      bigint(20)   NULL DEFAULT NULL COMMENT '岗位名称',
    `create_time` int(11)      NULL DEFAULT NULL COMMENT '创建日期',
    `nick_name`   varchar(255) NULL DEFAULT NULL COMMENT '昵称',
    `sex`         tinyint(4)   NULL DEFAULT 0 COMMENT '性别：默认 0{0 保密 1 男 2 女}',
    `is_del`      tinyint(4)   NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '系统用户';

DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area`
(
    `id`   bigint(20)  NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL COMMENT '名称',
    `seq`  smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '全部区域';

DROP TABLE IF EXISTS `sys_province`;
CREATE TABLE `sys_province`
(
    `id`      int(11)     NOT NULL AUTO_INCREMENT,
    `area_id` int(11)     null comment '地区Id',
    `name`    varchar(50) NOT NULL COMMENT '名称',
    `seq`     smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '省份';


DROP TABLE IF EXISTS `sys_city`;
CREATE TABLE `sys_city`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `province_id` int(11)     null comment '省份Id',
    `name`        varchar(50) NOT NULL COMMENT '名称',
    `seq`         smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '城市';

DROP TABLE IF EXISTS `sys_district`;
CREATE TABLE `sys_district`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT,
    `province_id` int(11)     null comment '省份Id',
    `name`        varchar(50) NOT NULL COMMENT '名称',
    `seq`         smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '行政区';

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

DROP TABLE IF EXISTS `tb_shop_canvas`;
CREATE TABLE `tb_shop_canvas`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '画布id',
    `terminal`    tinyint(4)   NOT NULL COMMENT '终端 1-小程序 2-H5 3-APP 4-PC',
    `json`        text         NULL COMMENT '画布json数据',
    `type`        tinyint(4)   NULL DEFAULT 1 COMMENT '类型 1-系统画布 2-自定义页面 3-商家店铺装修',
    `name`        varchar(150) NULL COMMENT '名称',
    `is_del`      tinyint(4)   NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time` int(11)      NULL COMMENT '创建时间',
    `update_time` int(11)      NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '画布信息';

DROP TABLE IF EXISTS `tb_advert`;
CREATE TABLE `tb_advert`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `title`       varchar(50)  NULL COMMENT '标题: 可用于导航栏',
    `src`         varchar(255) NULL COMMENT ' 广告图片地址',
    `url`         varchar(255) NULL COMMENT '广告图片点击跳转链接',
    `img_type`    tinyint(4)   NOT NULL DEFAULT 0 COMMENT '类型: 0:one 单图; 1:three 三图; 2:swiper: 轮播图; 3:导航：nav;',
    `location`    tinyint(4)   NULL     DEFAULT 1 COMMENT '图片位置默认: 0; 类型为三图用：0: 左边: left; 1:上边: up; 2:下边: down;',
    `hot`         int(11)      NULL     DEFAULT 0 COMMENT '热度: 值越大越靠前',
    `click_count` int(11)      NULL     DEFAULT 0 COMMENT '点击数,每点击一次加1',
    `is_del`      tinyint(4)   NULL     DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time` int(11)      NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '广告信息';

DROP TABLE IF EXISTS `tb_notice_category`;
CREATE TABLE `tb_notice_category`
(
    `id`   int(11)     NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL COMMENT '名称',
    `seq`  smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '公告类型';

DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT,
    `category_id` int(11)     null comment '分类id',
    `create_id`   bigint(20)  NULL DEFAULT NULL COMMENT '创建者ID',
    `create_type` tinyint(4)  NULL DEFAULT NULL COMMENT '创建者类型:默认 0 {0 管理员 1 员工 2 供应商}',
    `title`       varchar(50) NOT NULL COMMENT '公告标题',
    `content`     text        NOT NULL COMMENT '公告内容',
    `seq`         smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `is_del`      tinyint(4)  NULL DEFAULT 1 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time` int(11)     NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '公告';

DROP TABLE IF EXISTS `tb_article_category`;
CREATE TABLE `tb_article_category`
(
    `id`   int(11)     NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL COMMENT '名称',
    `seq`  smallint(6) NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '文章类型';

DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '文章管理ID',
    `category_id` int(11)      null comment '分类id',
    `title`       varchar(100) NOT NULL COMMENT '文章标题',
    `author`      varchar(100) NULL DEFAULT NULL COMMENT '文章作者',
    `image`       varchar(255) NULL DEFAULT NULL COMMENT '文章图片',
    `synopsis`    varchar(255) NULL DEFAULT NULL COMMENT '文章简介',
    `content`     text         NULL COMMENT '文章内容',
    `visit`       int(11)      NULL DEFAULT 0 COMMENT '浏览次数,每点击一次加1',
    `seq`         smallint(6)  NULL DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `url`         varchar(255) NULL DEFAULT NULL COMMENT '原文链接',
    `product_id`  bigint(20)   NULL DEFAULT 0 COMMENT '产品关联id,默认0为没关联产品',
    `media_id`    varchar(255) NULL DEFAULT '' COMMENT '素材id,多个用 `,` 分开',
    `is_pub`      tinyint(4)   NULL DEFAULT 0 COMMENT '是否发布 1-已发布 0-未发布',
    `is_del`      tinyint(4)   NULL DEFAULT 0 COMMENT '是否删除: 默认1(1：可用;0已删除)',
    `create_time` int(11)      NULL DEFAULT NULL COMMENT '添加时间',
    `update_time` int(11)      NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB COMMENT = '文章';

DROP TABLE IF EXISTS `tb_wechat_cache`;
CREATE TABLE `tb_wechat_cache`
(
    `key`         varchar(36) NOT NULL,
    `result`      text        NULL COMMENT '缓存数据',
    `create_time` int(11)     NULL COMMENT '缓存时间',
    PRIMARY KEY (`key`)
) ENGINE = InnoDB COMMENT = '微信缓存';

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










