package cn.peyton.plum.mall.param.party;


import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.pojo.party.MemberLevel;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 会员等级 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class MemberLevelParam implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 等级名称
     */
    @NotBlank(message = "名称不能为空")
    @Length(min = 2,max = 28)
    private String name;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    @Size(min = 0,max = 9999)
    private Integer seq;
    /**
     * 会员类型, 默认 0 零售 1 批发
     */
    //@Size(min = 0,max = 1)
    //private Integer memberType;
    /**
     * 是否启用, 默认 1 启用 0 禁用
     */
    @Size(min = 0,max = 1)
    private Integer status;
    /**
     * 折扣(50~100) /100,默认: 100
     */
    @Size(min=50,max = 100)
    private Integer discount;
    /**
     * 消费满元
     */
    @MinDecimal(value = 0.01,message = "最小消费为0.01元")
    private BigDecimal maxPrice;
    /**
     * 消费满次数
     */
    @Min(message = "消费次数最小为0")
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
     * @param status 是否启用, 默认 1 启用 0 禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 是否启用, 默认 1 启用 0 禁用
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

    /**
     * <h4>对象转成MemberLevel对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq,memberType,isDel,discount,maxPrice,maxTimes]
     * </pre>
     */
    public MemberLevel convert() {
        MemberLevel memberLevel = new MemberLevel();
        memberLevel.setId(id);
        memberLevel.setName(name);
        memberLevel.setSeq(seq);
        //memberLevel.setMemberType(memberType);
        memberLevel.setStatus(status);
        memberLevel.setDiscount(discount);
        memberLevel.setMaxPrice(maxPrice);
        memberLevel.setMaxCount(maxCount);
        return memberLevel;
    }

    /**
     * <h4>MemberLevel对象转成MemberLevelParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq,memberType,isDel,discount,maxPrice,maxTimes]
     * </pre>
     */
    public MemberLevelParam compat(MemberLevel memberLevel) {
        if (null == memberLevel) {
            return new MemberLevelParam();
        }
        this.setId(memberLevel.getId());
        this.setName(memberLevel.getName());
        this.setSeq(memberLevel.getSeq());
        //this.setMemberType(memberLevel.getMemberType());
        this.setStatus(memberLevel.getStatus());
        this.setDiscount(memberLevel.getDiscount());
        this.setMaxPrice(memberLevel.getMaxPrice());
        this.setMaxCount(memberLevel.getMaxCount());
        return this;
    }
}
