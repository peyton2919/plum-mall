package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 用户分销关联(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用) 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class UserDistribution implements Serializable {
    /**
     * 编号
     */
    private Long id;
    /**
     * 分销Id
     */
    private Long distId;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shaerId;
    /**
     * 用户类型 默认: 0 会员、1 供应商、2 员工
     */
    private Integer shaerType;

    //================================== Constructor =======================================//

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
     * @param distId 分销Id
     */
    public void setDistId(Long distId) {
        this.distId = distId;
    }

    /**
     * @return 分销Id
     */
    public Long getDistId() {
        return distId;
    }

    /**
     * @param shaerId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    public void setShaerId(Long shaerId) {
        this.shaerId = shaerId;
    }

    /**
     * @return 用户ID(包含 : 会员Id 、 供应商Id 、 员工Id等, 配合share_type一起使用)
     */
    public Long getShaerId() {
        return shaerId;
    }

    /**
     * @param shaerType 用户类型 默认: 0 会员、1 供应商、2 员工
     */
    public void setShaerType(Integer shaerType) {
        this.shaerType = shaerType;
    }

    /**
     * @return 用户类型 默认: 0 会员、1 供应商、2 员工
     */
    public Integer getShaerType() {
        return shaerType;
    }

}
