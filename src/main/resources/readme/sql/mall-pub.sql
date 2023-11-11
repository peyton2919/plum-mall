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







