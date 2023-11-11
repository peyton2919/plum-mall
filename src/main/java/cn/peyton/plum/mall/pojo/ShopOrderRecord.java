package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 订单操作记录 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShopOrderRecord implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 订单id
     */
    private Long oId;
    /**
     * 操作类型
     */
    private String operateType;
    /**
     * 操作信息{json格式}
     */
    private String operateMessage;
    /**
     * 操作者IP地址
     */
    private String operateIp;
    /**
     * 创建时间
     */
    private Integer createTime;
    /**
     * 更新时间
     */
    private Integer updateTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param oId 订单id
     */
    public void setOId(Long oId) {
        this.oId = oId;
    }

    /**
     * @return 订单id
     */
    public Long getOId() {
        return oId;
    }

    /**
     * @param operateType 操作类型
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    /**
     * @return 操作类型
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * @param operateMessage 操作信息{json格式}
     */
    public void setOperateMessage(String operateMessage) {
        this.operateMessage = operateMessage;
    }

    /**
     * @return 操作信息{json格式}
     */
    public String getOperateMessage() {
        return operateMessage;
    }

    /**
     * @param operateIp 操作者IP地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    /**
     * @return 操作者IP地址
     */
    public String getOperateIp() {
        return operateIp;
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

    /**
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 更新时间
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

}
