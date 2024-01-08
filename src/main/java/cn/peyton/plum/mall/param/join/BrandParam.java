package cn.peyton.plum.mall.param.join;


import cn.peyton.plum.core.anno.img.ImageHostPath;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.bo.SupplierBo;
import cn.peyton.plum.mall.param.party.SupplierParam;
import cn.peyton.plum.mall.pojo.join.Brand;

import java.io.Serializable;

/**
 * <h3> 品牌 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
@ImageHostPath(name = "logo")
public class BrandParam implements Serializable {
    /**
     * 编号
     */
    private Long id;
    /**
     * 供应商编号
     */
    private Long supId;
    /**
     * 品牌LOGO 图片大小120px*120px
     */
    @Length(min = 0,max = 145)
    private String logo;
    /**
     * 品牌名称
     */
    @NotBlank(message = "品牌名称不能为空;")
    @Length(min = 2,max = 29)
    private String name;
    /**
     * 所属地区
     */
    @Length(max = 99)
    private String area;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    @Size(min = 0,max = 9999)
    private Short seq;
    /**
     * 品牌描述
     */
    @Length(max = 249)
    private String explain;
    /**
     * 创建时间
     */
    private String  createTime;
    /**
     * 供应商对象
     */
    private SupplierParam supplier;

    //================================== Constructor =======================================//
    public BrandParam() {
        if (null == supplier) { supplier = new SupplierParam(); }
    }
    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * @param supId 供应商编号
     */
    public void setSupId(Long supId) {
        this.supId = supId;
    }

    /**
     * @return 供应商编号
     */
    public Long getSupId() {
        return supId;
    }

    /**
     * @param logo 品牌LOGO 图片大小120px*120px
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return 品牌LOGO 图片大小120px*120px
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param name 品牌名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 品牌名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param area 所属地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return 所属地区
     */
    public String getArea() {
        return area;
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
     * @param explain 品牌描述
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

    /**
     * @return 品牌描述
     */
    public String getExplain() {
        return explain;
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
     * @return 供应商对象
     */
    public SupplierParam getSupplier() {
        return supplier;
    }

    /**
     * @param supplier 供应商对象
     */
    public void setSupplier(SupplierParam supplier) {
        this.supplier = supplier;
    }

    /**
     * <h4>对象转成Brand对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,supId,logo,name,area,seq,explain,createTime]
     * </pre>
     */
    public Brand convert() {
        Brand brand = new Brand();
        brand.setId(id);
        brand.setSupId(supId);
        brand.setLogo(logo);
        brand.setName(name);
        brand.setArea(area);
        brand.setSeq(seq);
        brand.setExplain(explain);
        brand.setCreateTime(DateUtils.dateToTimestamp(createTime));
        brand.setSupplier(supplier.convert());
        return brand;
    }

    /**
     * <h4>Brand对象转成BrandParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,supId,logo,name,area,seq,explain,createTime]
     * </pre>
     */
    public BrandParam compat(Brand brand) {
        if (null == brand) {
            return new BrandParam();
        }
        this.setId(brand.getId());
        this.setSupId(brand.getSupId());
        this.setLogo(brand.getLogo());
        this.setName(brand.getName());
        this.setArea(brand.getArea());
        this.setSeq(brand.getSeq());
        this.setExplain(brand.getExplain());
        this.setCreateTime(DateUtils.timestampToStrDate(brand.getCreateTime()));
        this.setSupplier(new SupplierBo().compat(brand.getSupplier()));
        return this;
    }
}
