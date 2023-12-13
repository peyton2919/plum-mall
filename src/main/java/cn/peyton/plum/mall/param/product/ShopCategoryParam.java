package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.bo.ShopCategoryBo;
import cn.peyton.plum.mall.pojo.product.ShopCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 商品分类 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopCategoryParam implements Serializable {
    /**
     * 商品分类表Id
     */
    private Integer id;
    /**
     * 父Id,默认0最高级别Id
     */
    private Integer pid;
    /**
     * 分类名称
     */
    @NotBlank(message = "分类名称不能为空;")
    @Length(min = 2,max = 40)
    private String name;

    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    @Size(min = 0,max = 9999)
    private Short seq;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否推荐,默认1 {1为推荐 0 不推荐}
     */
    @Size(min = 0,max = 1)
    private Integer isShow;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    @Size(min = 0,max = 1)
    private Integer isDel;
    /**
     * 添加时间
     */
    private Integer createTime;
    /** 分类子类 */
    private List<ShopCategoryParam> childrens;

    //================================== Constructor =======================================//
    public ShopCategoryParam() {
        if (null == childrens) { childrens = new ArrayList<>(); }
    }
    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 商品分类表Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 商品分类表Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param pid 父Id,默认0最高级别Id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return 父Id, 默认0最高级别Id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public void setSeq(Short seq) {
        this.seq = seq;
    }

    /**
     * @return 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public Short getSeq() {
        return seq;
    }

    /**
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param isShow 是否推荐,默认1 {1为推荐 0 不推荐}
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * @return 是否推荐, 默认1 {1为推荐 0 不推荐}
     */
    public Integer getIsShow() {
        return isShow;
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
     * @return 分类子类
     */
    public List<ShopCategoryParam> getChildrens() {
        return childrens;
    }

    /**
     * @param childrens 分类子类
     */
    public void setChildrens(List<ShopCategoryParam> childrens) {
        this.childrens = childrens;
    }

    /**
     * <h4>对象转成ShopCategory对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,pid,name,seq,icon,isShow,isDel,createTime]
     * </pre>
     */
    public ShopCategory convert() {
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setId(id);
        shopCategory.setPid(pid);
        shopCategory.setName(name);
        shopCategory.setSeq(seq);
        shopCategory.setIcon(icon);
        shopCategory.setIsShow(isShow);
        shopCategory.setIsDel(isDel);
        shopCategory.setCreateTime(createTime);
        shopCategory.setChildrens(new ShopCategoryBo().reverse(childrens));
        return shopCategory;
    }

    /**
     * <h4>ShopCategory对象转成ShopCategoryParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,pid,name,seq,icon,isShow,isDel,createTime]
     * </pre>
     */
    public ShopCategoryParam compat(ShopCategory shopCategory) {
        if (null == shopCategory) {
            return new ShopCategoryParam();
        }
        this.setId(shopCategory.getId());
        this.setPid(shopCategory.getPid());
        this.setName(shopCategory.getName());
        this.setSeq(shopCategory.getSeq());
        this.setIcon(shopCategory.getIcon());
        this.setIsShow(shopCategory.getIsShow());
        this.setIsDel(shopCategory.getIsDel());
        this.setCreateTime(shopCategory.getCreateTime());
        this.setChildrens(new ShopCategoryBo().adapter(shopCategory.getChildrens()));
        return this;
    }
}
