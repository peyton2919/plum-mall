package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.pojo.product.ShopProductRule;

import java.io.Serializable;

/**
 * <h3> 商品规格--(规则) 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopProductRuleParam implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 规格名称
     */
    @NotBlank(message = "规格名称不能为空")
    @Length(min = 2,max = 30)
    private String ruleName;
    /**
     * 规格值:[{detail:[黑色,白色],value:颜色},{detail:[111,112],value:尺寸},...]
     */
    @NotBlank(message = "规格值不能为空")
    private String ruleValue;
    /**
     * 使用热度(数值越大越靠前)
     */
    private Integer hot;
    /** 状态;默认: 1启用、0禁用 */
    @Size(min = 0,max = 1)
    private Integer status;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    @Size(min = 0,max = 1)
    private Integer isDel;
    /**
     * 创建时间
     */
    private String createTime;

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
     * @param ruleName 规格名称
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    /**
     * @return 规格名称
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * @param ruleValue 规格值:[{detail:[黑色,白色],value:颜色},{detail:[111,112],value:尺寸},...]
     */
    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }

    /**
     * @return 规格值:[{detail:[黑色,白色],value:颜色},{detail:[111,112],value:尺寸},...]
     */
    public String getRuleValue() {
        return ruleValue;
    }

    /**
     * @param hot 使用热度(数值越大越靠前)
     */
    public void setHot(Integer hot) {
        this.hot = hot;
    }

    /**
     * @return 使用热度(数值越大越靠前)
     */
    public Integer getHot() {
        return hot;
    }

    /**
     * @return 状态;默认: 1启用、0禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 状态;默认: 1启用、0禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * <h4>对象转成ShopProductRule对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,ruleName,ruleValue,hot,isDel,createTime]
     * </pre>
     */
    public ShopProductRule convert() {
        ShopProductRule shopProductRule = new ShopProductRule();
        shopProductRule.setId(id);
        shopProductRule.setRuleName(ruleName);
        shopProductRule.setRuleValue(ruleValue);
        shopProductRule.setHot(hot);
        shopProductRule.setStatus(status);
        shopProductRule.setIsDel(isDel);
        shopProductRule.setCreateTime(DateUtils.dateToTimestamp(createTime));
        return shopProductRule;
    }

    /**
     * <h4>ShopProductRule对象转成ShopProductRuleParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,ruleName,ruleValue,hot,isDel,createTime]
     * </pre>
     */
    public ShopProductRuleParam compat(ShopProductRule shopProductRule) {
        if (null == shopProductRule) {
            return new ShopProductRuleParam();
        }
        this.setId(shopProductRule.getId());
        this.setRuleName(shopProductRule.getRuleName());
        this.setRuleValue(shopProductRule.getRuleValue());
        this.setHot(shopProductRule.getHot());
        this.setStatus(shopProductRule.getStatus());
        this.setIsDel(shopProductRule.getIsDel());
        this.setCreateTime(DateUtils.timestampToStrDate(shopProductRule.getCreateTime()));
        return this;
    }
}
