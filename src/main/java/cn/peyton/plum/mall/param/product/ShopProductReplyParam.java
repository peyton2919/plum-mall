package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.bo.MemberBo;
import cn.peyton.plum.mall.bo.ShopProductBo;
import cn.peyton.plum.mall.bo.ShopProductReplyImgBo;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.pojo.product.ShopProductReply;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 商品评论 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopProductReplyParam implements Serializable {
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
    private String createTime;
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
    private String merchantReplyTime;
    /** 会员对象 */
    private MemberParam member;
    /** 商品对象 */
    private ShopProductParam product;
    /**
     * 回复图片集合
     */
    private List<ShopProductReplyImgParam> replyImgs;


    //================================== Constructor =======================================//
    public ShopProductReplyParam(){
        if(null == member){member = new MemberParam(); }
        if(null == product){ product = new ShopProductParam();}
        if (null == replyImgs) { replyImgs = new ArrayList<>(); }
    }
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
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 评论时间
     */
    public String getCreateTime() {
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
    public void setMerchantReplyTime(String merchantReplyTime) {
        this.merchantReplyTime = merchantReplyTime;
    }

    /**
     * @return 管理员回复时间
     */
    public String getMerchantReplyTime() {
        return merchantReplyTime;
    }

    /**
     * @return 会员对象
     */
    public MemberParam getMember() {
        return member;
    }

    /**
     * @param member 会员对象
     */
    public void setMember(MemberParam member) {
        this.member = member;
    }

    /**
     * @return 商品对象
     */
    public ShopProductParam getProduct() {
        return product;
    }

    /**
     * @param product 商品对象
     */
    public void setProduct(ShopProductParam product) {
        this.product = product;
    }

    /**
     * @return 回复图片集合
     */
    public List<ShopProductReplyImgParam> getReplyImgs() {
        return replyImgs;
    }

    /**
     * @param replyImgs 回复图片集合
     */
    public void setReplyImgs(List<ShopProductReplyImgParam> replyImgs) {
        this.replyImgs = replyImgs;
    }

    /**
     * <h4>对象转成ShopProductReply对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,uId,oId,uniqueCode,productId,replyType,productScore,serviceScore,replyComment,isDel,createTime,isReply,merchantReplyContent,merchantReplyTime]
     * </pre>
     */
    public ShopProductReply convert() {
        ShopProductReply shopProductReply = new ShopProductReply();
        shopProductReply.setId(id);
        shopProductReply.setUId(uId);
        shopProductReply.setOId(oId);
        shopProductReply.setUniqueCode(uniqueCode);
        shopProductReply.setProductId(productId);
        shopProductReply.setReplyType(replyType);
        shopProductReply.setProductScore(productScore);
        shopProductReply.setServiceScore(serviceScore);
        shopProductReply.setReplyComment(replyComment);
        shopProductReply.setIsDel(isDel);
        shopProductReply.setCreateTime(DateUtils.dateToTimestamp(createTime));
        shopProductReply.setIsReply(isReply);
        shopProductReply.setMerchantReplyContent(merchantReplyContent);
        shopProductReply.setMerchantReplyTime(DateUtils.dateToTimestamp(merchantReplyTime));
        shopProductReply.setMember(member.convert());
        shopProductReply.setProduct(product.convert());
        shopProductReply.setReplyImgs(new ShopProductReplyImgBo().reverse(replyImgs));
        return shopProductReply;
    }

    /**
     * <h4>ShopProductReply对象转成ShopProductReplyParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,uId,oId,uniqueCode,productId,replyType,productScore,serviceScore,replyComment,isDel,createTime,isReply,merchantReplyContent,merchantReplyTime]
     * </pre>
     */
    public ShopProductReplyParam compat(ShopProductReply shopProductReply) {
        if (null == shopProductReply) {
            return new ShopProductReplyParam();
        }
        this.setId(shopProductReply.getId());
        this.setUId(shopProductReply.getUId());
        this.setOId(shopProductReply.getOId());
        this.setUniqueCode(shopProductReply.getUniqueCode());
        this.setProductId(shopProductReply.getProductId());
        this.setReplyType(shopProductReply.getReplyType());
        this.setProductScore(shopProductReply.getProductScore());
        this.setServiceScore(shopProductReply.getServiceScore());
        this.setReplyComment(shopProductReply.getReplyComment());
        this.setIsDel(shopProductReply.getIsDel());
        this.setCreateTime(DateUtils.timestampToStrDate(shopProductReply.getCreateTime()));
        this.setIsReply(shopProductReply.getIsReply());
        this.setMerchantReplyContent(shopProductReply.getMerchantReplyContent());
        this.setMerchantReplyTime(DateUtils.timestampToStrDate(shopProductReply.getMerchantReplyTime()));
        this.setMember(new MemberBo().compat(shopProductReply.getMember()));
        this.setProduct(new ShopProductBo().compat(shopProductReply.getProduct()));
        this.setReplyImgs(new ShopProductReplyImgBo().adapter(shopProductReply.getReplyImgs()));
        return this;
    }
}
