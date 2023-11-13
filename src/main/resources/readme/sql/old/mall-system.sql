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
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`pid` bigint(20) NOT NULL DEFAULT 0 COMMENT '上级菜单ID',
	`name` varchar(50)  NULL  COMMENT '菜单名称',
	`is_menu` tinyint(4) NULL DEFAULT 0 COMMENT '是否是菜单，默认 0否 1是',
	`condition` varchar(100) NULL comment '后端规则，由后端提供的接口别名（menu为0时必填）',
	`front_path` varchar(150) DEFAULT NULL COMMENT '前台路由注册路径',
	`router_method`  varchar(50) NULL     DEFAULT '' COMMENT '路由动作',
	`seq`            smallint(6)  NULL     DEFAULT 0 COMMENT '排序取值范围0~9999，默认为0; 按大到小排序',
    `icon`           varchar(255) NULL     DEFAULT NULL COMMENT '图标',
	`status` tinyint(4) DEFAULT '1' COMMENT '是否启用, 默认 1 启用 0 禁用',
    `i_frame` tinyint(4)   NULL     DEFAULT 0 COMMENT '是否外链,默认0没有外链接,1外链接',
    `menu_type` tinyint(4)   NULL DEFAULT 0 COMMENT '类型: 默认 0 {0 文字1 图片2 按钮3 ICON}',
    `path`           varchar(255) NULL     DEFAULT NULL COMMENT '链接地址',
	`permission`     varchar(255) NULL     DEFAULT NULL COMMENT '权限',
	`cache`          tinyint(4)   NULL     DEFAULT 0 COMMENT '是否缓存; 默认 0不缓存, 1缓存',
    `hidden`         tinyint(4)   NULL     DEFAULT 0 COMMENT '是否隐藏; 默认0不隐藏, 1隐藏',
	`component`      varchar(255) NULL     DEFAULT NULL COMMENT '组件',
    `component_name` varchar(20)  NULL     DEFAULT '-' COMMENT '组件名称',
    `create_time`    int(11)      NULL     DEFAULT NULL COMMENT '创建日期',
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
    `avatar`      varchar(200) NULL COMMENT '头像',
    `email`       varchar(255) NULL COMMENT '邮箱',
    `status`      tinyint(4)    NOT NULL DEFAULT '1' COMMENT '状态 0冻结中，1生效，-1失效',
    `password`    varchar(255) NULL COMMENT '密码',
    `username`    varchar(255) NULL COMMENT '用户名',
    `dept_id`     bigint(20)   NULL COMMENT '部门名称',
    `phone`       varchar(255) NULL COMMENT '手机号码',
    `job_id`      bigint(20)   NULL COMMENT '岗位名称',
    `create_time` int(11)      NULL COMMENT '创建日期',
    `nick_name`   varchar(255) NULL COMMENT '昵称',
	`last_ip`   varchar(50) NULL COMMENT '昵称',
	`last_login_time` int(11) NULL COMMENT '最后登录IP',
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
