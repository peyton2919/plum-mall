package cn.peyton.plum.mall.controller.base;

/**
 * <h4>基础的controller 接口</h4>
 * <pre>
 *     定义一些基础属性与字段
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.base.
 * @date 2023年11月11日 22:09
 * @version 1.0.0
 * </pre>
 */
public interface IBaseController {
    /**
     * @return 获取 class目录
     */
    static String getLocation() {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }
    /** 产品图片 存放位置 */
    String PATH_IMG_PRODUCT = getLocation()+"static/images/product/";
    /** 广告图片 存放位置 */
    String PATH_IMG_ADVERT = getLocation()+"static/images/advert/";
    /** 头像图片 存放位置 */
    String PATH_IMG_AVATAR = getLocation()+"static/images/avatar/";
    /** 其他图片 存放位置 */
    String PATH_IMG_OTHER = getLocation()+"static/images/other/";
    /** LOGO图片 存放位置 */
    String PATH_IMG_LOGO = getLocation()+"static/images/logo/";

    /** 产品图片 数据库存放位置 */
    String PATH_IMG_PRODUCT_SIMPLE = "/images/product/";
    /** 广告图片 数据库存放位置 */
    String PATH_IMG_ADVERT_SIMPLE = "/images/advert/";
    /** 头像图片 数据库存放位置 */
    String PATH_IMG_AVATAR_SIMPLE = "/images/avatar/";
    /** 其他图片 数据库存放位置 */
    String PATH_IMG_OTHER_SIMPLE = "/images/other/";
    /** LOGO图片 数据库存放位置 */
    String PATH_IMG_LOGO_SIMPLE = "/images/logo/";

    /** 设置产品 图片宽度 */
    Integer IMG_PRODUCT_WIDTH = 800;
    /** 设置产品 广告宽度 */
    Integer IMG_ADVERT_WIDTH = 1080;
    /** 设置产品 头像宽度 */
    Integer IMG_AVATAR_WIDTH = 300;
    /** 设置产品 LOGO宽度 */
    Integer IMG_LOGO_WIDTH = 400;
    /** 状态 为 -1 */
    Integer STATUS_MINUS = -1;
    /** 状态 为 0 */
    Integer STATUS_0 = 0;
    /** 状态 为 1 */
    Integer STATUS_1 = 1;
    /** 状态 为 2 */
    Integer STATUS_2 = 2;
    /** 状态 为 3 */
    Integer STATUS_3 = 3;
    /** 状态 为 4 */
    Integer STATUS_4 = 4;
    /** 状态 为 5 */
    Integer STATUS_5 = 5;
    /** 是否删除  0 为删除  */
    Integer IS_DEL_0 = 0;
    /** 是否删除  1 为可用  */
    Integer IS_DEL_1 = 1;

    /** 用来存储和获取 Token 的 key */
    String KEY_TOKEN = "GETTOKENKEYVALUE20231111";

    /** 用来存储和获取 Token 的 key */
    String KEY_TOKEN_ANDROID = "GETTOKENKEYVALUE2024202401250919ANDROID";

    /** Token 存放在 header 头部的 key,要与前端约定好 */
    String ACCESS_TOKEN = "token";
    /** is_del 值 `可用的` */
    Integer USABLE = 1;
    /** is_del 值 `不可用的` */
    Integer DISABLED = 0;
    /** 排序字段 默认: seq */
    String ORDER_BY_FILED = "seq";
}
