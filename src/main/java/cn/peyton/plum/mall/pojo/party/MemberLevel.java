package cn.peyton.plum.mall.pojo.party;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 会员等级 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class MemberLevel implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 等级名称
     */
    private String name;
    /**
     * 等级权重
     */
    private Integer seq;
    /**
     * 会员类型, 默认 0 零售 1 批发
     */
    //private Integer memberType;
    /**
     * 是否启用, 默认 1 启用 0 禁用
     */
    private Integer status;
    /**
     * 折扣(50~100) /100,默认: 100 
     */
    private Integer discount;
    /**
     * 消费满元
     */
    private BigDecimal maxPrice;
    /**
     * 消费满次数
     */
    private Integer maxCount;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param name 等级名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 等级名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param seq 等级权重
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * @return 等级权重
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * @param memberType 会员类型, 默认 0 零售 1 批发
     */
    //public void setMemberType(Integer memberType) {
    //    this.memberType = memberType;
    //}

    /**
     * @return 会员类型, 默认 0 零售 1 批发
     */
    //public Integer getMemberType() {
    //    return memberType;
    //}

    /**
     * @param status 是否删除: 默认1(1：可用;0已删除)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param discount 折扣(50~100) /100,默认: 100
     */
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**
     * @return 折扣(50~100) /100,默认: 100
     */
    public Integer getDiscount() {
        return discount;
    }

    /**
     * @param maxPrice 消费满元
     */
    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * @return 消费满元
     */
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    /**
     * @param maxCount 消费满次数
     */
    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * @return 消费满次数
     */
    public Integer getMaxCount() {
        return maxCount;
    }

}
