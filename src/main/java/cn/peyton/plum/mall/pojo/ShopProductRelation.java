package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 商品点赞和收藏 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopProductRelation implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 用户Id(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shareId;
    /**
     * 商品Id
     */
    private Long productId;
    /**
     * 用户类型 0 会员、1 供应商、2 员工
     */
    private Integer shareType;
    /**
     * 类型(0 收藏(collect）、1 点赞(like))
     */
    private Integer relationType;
    /**
     * 某种类型的商品(普通商品、秒杀商品)
     */
    private String category;
    /**
     * 是否删除: 默认1(1 可用;0 已删除)
     */
    private Boolean isDel;
    /**
     * 添加时间
     */
    private Integer createTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param shareId 用户Id(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    /**
     * @return 用户Id(包含 : 会员Id 、 供应商Id 、 员工Id等, 配合share_type一起使用)
     */
    public Long getShareId() {
        return shareId;
    }

    /**
     * @param productId 商品Id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return 商品Id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param shareType 用户类型 0 会员、1 供应商、2 员工
     */
    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    /**
     * @return 用户类型 0 会员、1 供应商、2 员工
     */
    public Integer getShareType() {
        return shareType;
    }

    /**
     * @param relationType 类型(0 收藏(collect）、1 点赞(like))
     */
    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }

    /**
     * @return 类型(0 收藏 ( collect ） 、 1 点赞 ( like))
     */
    public Integer getRelationType() {
        return relationType;
    }

    /**
     * @param category 某种类型的商品(普通商品、秒杀商品)
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return 某种类型的商品(普通商品 、 秒杀商品)
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param isDel 是否删除: 默认1(1 可用;0 已删除)
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1 可用;0 已删除)
     */
    public Boolean getIsDel() {
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
