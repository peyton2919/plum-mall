package cn.peyton.plum.mall.pojo.sys;


import java.io.Serializable;

/**
 * <h3> 部门 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class Dept implements Serializable {
    /**
     * ID
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 上级部门
     */
    private Integer pid;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;
    /**
     * 创建日期
     */
    private Integer createTime;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param pid 上级部门
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return 上级部门
     */
    public Integer getPid() {
        return pid;
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
     * @param createTime 创建日期
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建日期
     */
    public Integer getCreateTime() {
        return createTime;
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

}
