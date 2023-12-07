package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.mall.pojo.product.ShopOrderRecord;

import java.io.Serializable;

/**
 * <h3> 订单操作记录 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopOrderRecordParam implements Serializable {
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

    /**
     * <h4>对象转成ShopOrderRecord对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,oId,operateType,operateMessage,operateIp,createTime,updateTime]
     * </pre>
     */
    public ShopOrderRecord convert() {
        ShopOrderRecord shopOrderRecord = new ShopOrderRecord();
        shopOrderRecord.setId(id);
        shopOrderRecord.setOId(oId);
        shopOrderRecord.setOperateType(operateType);
        shopOrderRecord.setOperateMessage(operateMessage);
        shopOrderRecord.setOperateIp(operateIp);
        shopOrderRecord.setCreateTime(createTime);
        shopOrderRecord.setUpdateTime(updateTime);
        return shopOrderRecord;
    }

    /**
     * <h4>ShopOrderRecord对象转成ShopOrderRecordParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,oId,operateType,operateMessage,operateIp,createTime,updateTime]
     * </pre>
     */
    public ShopOrderRecordParam compat(ShopOrderRecord shopOrderRecord) {
        if (null == shopOrderRecord) {
            return new ShopOrderRecordParam();
        }
        this.setId(shopOrderRecord.getId());
        this.setOId(shopOrderRecord.getOId());
        this.setOperateType(shopOrderRecord.getOperateType());
        this.setOperateMessage(shopOrderRecord.getOperateMessage());
        this.setOperateIp(shopOrderRecord.getOperateIp());
        this.setCreateTime(shopOrderRecord.getCreateTime());
        this.setUpdateTime(shopOrderRecord.getUpdateTime());
        return this;
    }
}
