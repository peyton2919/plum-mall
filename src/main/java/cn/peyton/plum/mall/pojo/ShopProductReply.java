package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 商品评论 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopProductReply implements Serializable {
    /**
     * 评论Id
     */
    private Long id;
    /**
     * 会员Id
     */
    private Long uId;
    /**
     * 订单Id
     */
    private Long oId;
    /**
     * 唯一Id
     */
    private String uniqueCode;
    /**
     * 产品Id
     */
    private Long productId;
    /**
     * 评论商品类型(0 普通销售、1 秒杀、2 砍价、3 拼团）
     */
    private Integer replyType;
    /**
     * 商品分数（1-10）
     */
    private Integer productScore;
    /**
     * 服务分数（1-10）
     */
    private Integer serviceScore;
    /**
     * 评论内容
     */
    private String replyComment;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 评论时间
     */
    private Integer createTime;
    /**
     * 是否回复, 默认:0 {0 未回复 1 已回复}
     */
    private Integer isReply;
    /**
     * 管理员回复内容
     */
    private String merchantReplyContent;
    /**
     * 管理员回复时间
     */
    private Integer merchantReplyTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 评论Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 评论Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param uId 会员Id
     */
    public void setUId(Long uId) {
        this.uId = uId;
    }

    /**
     * @return 会员Id
     */
    public Long getUId() {
        return uId;
    }

    /**
     * @param oId 订单Id
     */
    public void setOId(Long oId) {
        this.oId = oId;
    }

    /**
     * @return 订单Id
     */
    public Long getOId() {
        return oId;
    }

    /**
     * @param uniqueCode 唯一Id
     */
    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    /**
     * @return 唯一Id
     */
    public String getUniqueCode() {
        return uniqueCode;
    }

    /**
     * @param productId 产品Id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return 产品Id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param replyType 评论商品类型(0 普通销售、1 秒杀、2 砍价、3 拼团）
     */
    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    /**
     * @return 评论商品类型(0 普通销售 、 1 秒杀 、 2 砍价 、 3 拼团 ）
     */
    public Integer getReplyType() {
        return replyType;
    }

    /**
     * @param productScore 商品分数（1-10）
     */
    public void setProductScore(Integer productScore) {
        this.productScore = productScore;
    }

    /**
     * @return 商品分数（1-10）
     */
    public Integer getProductScore() {
        return productScore;
    }

    /**
     * @param serviceScore 服务分数（1-10）
     */
    public void setServiceScore(Integer serviceScore) {
        this.serviceScore = serviceScore;
    }

    /**
     * @return 服务分数（1-10）
     */
    public Integer getServiceScore() {
        return serviceScore;
    }

    /**
     * @param replyComment 评论内容
     */
    public void setReplyComment(String replyComment) {
        this.replyComment = replyComment;
    }

    /**
     * @return 评论内容
     */
    public String getReplyComment() {
        return replyComment;
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
     * @param createTime 评论时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 评论时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * @param isReply 是否回复, 默认:0 {0 未回复 1 已回复}
     */
    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }

    /**
     * @return 是否回复, 默认:0 {0 未回复 1 已回复}
     */
    public Integer getIsReply() {
        return isReply;
    }

    /**
     * @param merchantReplyContent 管理员回复内容
     */
    public void setMerchantReplyContent(String merchantReplyContent) {
        this.merchantReplyContent = merchantReplyContent;
    }

    /**
     * @return 管理员回复内容
     */
    public String getMerchantReplyContent() {
        return merchantReplyContent;
    }

    /**
     * @param merchantReplyTime 管理员回复时间
     */
    public void setMerchantReplyTime(Integer merchantReplyTime) {
        this.merchantReplyTime = merchantReplyTime;
    }

    /**
     * @return 管理员回复时间
     */
    public Integer getMerchantReplyTime() {
        return merchantReplyTime;
    }

}
