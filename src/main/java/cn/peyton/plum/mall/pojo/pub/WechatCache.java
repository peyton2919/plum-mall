package cn.peyton.plum.mall.pojo.pub;


import java.io.Serializable;

/**
 * <h3> 微信缓存 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class WechatCache implements Serializable {
    /**
     *
     */
    private String key;
    /**
     * 缓存数据
     */
    private String result;
    /**
     * 缓存时间
     */
    private Integer createTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * @param result 缓存数据
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return 缓存数据
     */
    public String getResult() {
        return result;
    }

    /**
     * @param createTime 缓存时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 缓存时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

}
