package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 购物车 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopCart implements Serializable {
    /**
     * 购物车Id
     */
    private Long id;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shareId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    private Integer shareType;
    /**
     * 商品数量,默认: 0
     */
    private Integer num;
    /**
     * 0 = 未购买 1 = 已购买
     */
    private Integer isPay;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 是否为立即购买,默认0 未立即购买 1购买
     */
    private Integer isNew;
    /**
     * 拼团id
     */
    private Long pinkId;
    /**
     * 秒杀产品ID
     */
    private Long seckillId;
    /**
     * 砍价id
     */
    private Long bargainId;
    /**
     * 添加时间
     */
    private Integer createTime;
    /**
     * 更新时间
     */
    private Integer updateTime;


    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 购物车Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 购物车Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param shareId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    /**
     * @return 用户ID(包含 : 会员Id 、 供应商Id 、 员工Id等, 配合share_type一起使用)
     */
    public Long getShareId() {
        return shareId;
    }

    /**
     * @param shareType 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    /**
     * @return 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public Integer getShareType() {
        return shareType;
    }

    /**
     * @param num 商品数量,默认: 0
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return 商品数量, 默认: 0
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param isPay 0 = 未购买 1 = 已购买
     */
    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    /**
     * @return 0 = 未购买 1 = 已购买
     */
    public Integer getIsPay() {
        return isPay;
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
     * @param isNew 是否为立即购买,默认0 未立即购买 1购买
     */
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    /**
     * @return 是否为立即购买, 默认0 未立即购买 1购买
     */
    public Integer getIsNew() {
        return isNew;
    }

    /**
     * @param pinkId 拼团id
     */
    public void setPinkId(Long pinkId) {
        this.pinkId = pinkId;
    }

    /**
     * @return 拼团id
     */
    public Long getPinkId() {
        return pinkId;
    }

    /**
     * @param seckillId 秒杀产品ID
     */
    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    /**
     * @return 秒杀产品ID
     */
    public Long getSeckillId() {
        return seckillId;
    }

    /**
     * @param bargainId 砍价id
     */
    public void setBargainId(Long bargainId) {
        this.bargainId = bargainId;
    }

    /**
     * @return 砍价id
     */
    public Long getBargainId() {
        return bargainId;
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

    /**
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 更新时间
     */
    public Integer getUpdateTime() {
        return updateTime;
    }


}
