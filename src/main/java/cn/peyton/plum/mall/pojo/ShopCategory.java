package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 商品分类 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopCategory implements Serializable {
    /**
     * 商品分类表Id
     */
    private Integer id;
    /**
     * 父Id,默认0最高级别Id
     */
    private Integer pid;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否推荐,默认1 {1为推荐 0 不推荐}
     */
    private Integer isShow;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 添加时间
     */
    private Integer createTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 商品分类表Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 商品分类表Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param pid 父Id,默认0最高级别Id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return 父Id, 默认0最高级别Id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public void setSeq(Short seq) {
        this.seq = seq;
    }

    /**
     * @return 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public Short getSeq() {
        return seq;
    }

    /**
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param isShow 是否推荐,默认1 {1为推荐 0 不推荐}
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * @return 是否推荐, 默认1 {1为推荐 0 不推荐}
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * @param createTime 添加时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 添加时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

}
