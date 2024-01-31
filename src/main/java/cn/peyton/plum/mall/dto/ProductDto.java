package cn.peyton.plum.mall.dto;

import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * <h4>商品 Dto</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.vo.
 * @date 2024年01月25日 22:22
 * @version 1.0.0
 * </pre>
 */
public class ProductDto implements Serializable {
    /** 主键 */
    private Long id;
    /** 分类主键 */
    private Integer categoryId;
    /** 品牌主键 */
    private Long brandId;
    /** 标签 */
    private String tab;
    /** 类型 keyword, categoryId, brandId*/
    private String type;

    /** 筛选  */
    private String rule;
    /** 最小金额  */
    private Integer min;
    /** 最大金额  */
    private Integer max;
    /** 排序  */
    private String orderBy;
    /** 条件  */
    private String condition;
    /** 关键字  */
    private String keyword;
    /** 当前页码 */
    @NotBlank(message = "页码不能为空")
    @Min(value = 1, message = "当前页码不合法")
    private Integer pageNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
