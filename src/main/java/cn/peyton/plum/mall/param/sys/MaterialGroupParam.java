package cn.peyton.plum.mall.param.sys;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.pojo.sys.MaterialGroup;

import java.io.Serializable;

/**
 * <h3> 素材分组 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class MaterialGroupParam implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 创建者ID
     */
    private Long createId;
    /**
     * 分组名
     */
    @NotBlank(message = "素材分组名称不能为空")
    @Length(min = 4,max=30,message = "素材分组名称长度为6~30个字符！")
    private String name;
    /** 排序取值范围0~9999，默认为0; 按大到小排序  */
    @Size(min = 0,max = 9999)
    private Short seq;
    /**
     * 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}
     */
    private Integer createType;
    /**
     * 创建时间
     */
    private String createTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param createId 创建者ID
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * @return 创建者ID
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * @param name 分组名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 分组名
     */
    public String getName() {
        return name;
    }
    /**
     * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public void setSeq(Short seq){
        this.seq = seq;
    }

    /**
     * @return 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public Short getSeq(){
        return seq;
    }
    /**
     * @param createType 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}
     */
    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    /**
     * @return 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}
     */
    public Integer getCreateType() {
        return createType;
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
     * <h4>对象转成MaterialGroup对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,createId,name,createType,createTime]
     * </pre>
     */
    public MaterialGroup convert() {
        MaterialGroup materialGroup = new MaterialGroup();
        materialGroup.setId(id);
        materialGroup.setCreateId(createId);
        materialGroup.setName(name);
        materialGroup.setSeq(seq);
        materialGroup.setCreateType(createType);
        materialGroup.setCreateTime(DateUtils.dateToTimestamp(createTime));
        return materialGroup;
    }

    /**
     * <h4>MaterialGroup对象转成MaterialGroupParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,createId,name,createType,createTime]
     * </pre>
     */
    public MaterialGroupParam compat(MaterialGroup materialGroup) {
        if (null == materialGroup) {
            return new MaterialGroupParam();
        }
        this.setId(materialGroup.getId());
        this.setCreateId(materialGroup.getCreateId());
        this.setName(materialGroup.getName());
        this.setSeq(materialGroup.getSeq());
        this.setCreateType(materialGroup.getCreateType());
        this.setCreateTime(DateUtils.timestampToStrDate(materialGroup.getCreateTime()));
        return this;
    }
}
