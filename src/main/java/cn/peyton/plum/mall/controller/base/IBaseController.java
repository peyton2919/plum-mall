package cn.peyton.plum.mall.controller.base;

/**
 * <h4></h4>
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
    String PATH_IMG_AD = getLocation()+"static/images/ad/";
    /** 头像图片 存放位置 */
    String PATH_IMG_AVATAR = getLocation()+"static/images/avatar/";
    /** 头像图片 数据库存放位置 */
    String PATH_IMG_AVATAR_SIMPLE = "/images/avatar/";
    /** 广告图片 数据库存放位置 */
    String PATH_IMG_AD_SIMPLE = "/images/ad/";
    /** 产品图片 数据库存放位置 */
    String PATH_IMG_PRODUCT_SIMPLE = "/images/product/";
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
    /** 用来存储和获取 Token 的 key */
    String KEY_TOKEN = "GETTOKENKEYVALUE20231111";
    /** Token 存放在 header 头部的 key,要与前端约定好 */
    String ACCESS_TOKEN = "token";

}
