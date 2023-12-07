package cn.peyton.plum.mall.pojo.sys;


import java.io.Serializable;

/**
 * <h3> 素材分组 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class MaterialGroup implements Serializable {
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
    private String name;
    /** 排序取值范围0~9999，默认为0; 按大到小排序  */
    private Short seq;
    /**
     * 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}
     */
    private Integer createType;
    /**
     * 创建时间
     */
    private Integer createTime;

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
