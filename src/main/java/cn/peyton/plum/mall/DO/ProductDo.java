package cn.peyton.plum.mall.DO;

import java.io.Serializable;

/**
 * <h4>商品 DO类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.DO.
 * @date 2024年01月25日 17:48
 * @version 1.0.0
 * </pre>
 */
public class ProductDo implements Serializable {
    /** 商品主键 */
    private Long id;
    /** 销售量 */
    private Integer saleCount;
    /** 标签 */
    private String tab;
    /** 规则  */
    private String rule;
    /** 最小金额  */
    private Integer min;
    /** 最大金额  */
    private Integer max;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
