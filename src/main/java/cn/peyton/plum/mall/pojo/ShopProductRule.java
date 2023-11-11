package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 商品规格--(规则) 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopProductRule implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 规格名称
     */
    private String ruleName;
    /**
     * 规格值:[{detail:[黑色,白色],value:颜色},{detail:[111,112],value:尺寸},...]
     */
    private String ruleValue;
    /**
     * 使用热度(数值越大越靠前)
     */
    private Integer hot;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 创建时间
     */
    private Integer createTime;

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
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

}
