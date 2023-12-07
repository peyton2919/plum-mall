package cn.peyton.plum.mall.param.sys;


import cn.peyton.plum.mall.pojo.sys.Job;

import java.io.Serializable;

/**
 * <h3> 岗位 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class JobParam implements Serializable {
    /**
     * ID
     */
    private Integer id;
    /**
     * 岗位名称
     */
    private String name;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;
    /**
     * 部门ID
     */
    private Integer deptId;
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
     * @param name 岗位名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 岗位名称
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
     * @param deptId 部门ID
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * @return 部门ID
     */
    public Integer getDeptId() {
        return deptId;
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

    /**
     * <h4>对象转成Job对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq,deptId,createTime,isDel]
     * </pre>
     */
    public Job convert() {
        Job job = new Job();
        job.setId(id);
        job.setName(name);
        job.setSeq(seq);
        job.setDeptId(deptId);
        job.setCreateTime(createTime);
        job.setIsDel(isDel);
        return job;
    }

    /**
     * <h4>Job对象转成JobParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq,deptId,createTime,isDel]
     * </pre>
     */
    public JobParam compat(Job job) {
        if (null == job) {
            return new JobParam();
        }
        this.setId(job.getId());
        this.setName(job.getName());
        this.setSeq(job.getSeq());
        this.setDeptId(job.getDeptId());
        this.setCreateTime(job.getCreateTime());
        this.setIsDel(job.getIsDel());
        return this;
    }
}
