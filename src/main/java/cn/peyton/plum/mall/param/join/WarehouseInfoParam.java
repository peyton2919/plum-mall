package cn.peyton.plum.mall.param.join;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Phone;
import cn.peyton.plum.mall.pojo.join.WarehouseInfo;

import java.io.Serializable;

/**
 * <h3> 仓库信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class WarehouseInfoParam implements Serializable {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空;")
    @Length(min = 1,max = 30)
    private String name;
    /**
     * 手机号
     */
    @Phone
    private String phone;
    /**
     * 地址
     */
    @Length(min = 1,max = 120)
    private String address;
    /**
     * 位置
     */
    @Length(max = 40)
    private String loaction;
    /**
     * 说明
     */
    @Length(max = 90)
    private String explain;
    /**
     * 创建时间
     */
    private String createTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 编号
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
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param loaction 位置
     */
    public void setLoaction(String loaction) {
        this.loaction = loaction;
    }

    /**
     * @return 位置
     */
    public String getLoaction() {
        return loaction;
    }

    /**
     * @param explain 说明
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

    /**
     * @return 说明
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
     * <h4>对象转成WarehouseInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,phone,address,loaction,explain,createTime]
     * </pre>
     */
    public WarehouseInfo convert() {
        WarehouseInfo warehouseInfo = new WarehouseInfo();
        warehouseInfo.setId(id);
        warehouseInfo.setName(name);
        warehouseInfo.setPhone(phone);
        warehouseInfo.setAddress(address);
        warehouseInfo.setLoaction(loaction);
        warehouseInfo.setExplain(explain);
        warehouseInfo.setCreateTime(DateUtils.dateToTimestamp(createTime));
        return warehouseInfo;
    }

    /**
     * <h4>WarehouseInfo对象转成WarehouseInfoParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,phone,address,loaction,explain,createTime]
     * </pre>
     */
    public WarehouseInfoParam compat(WarehouseInfo warehouseInfo) {
        if (null == warehouseInfo) {
            return new WarehouseInfoParam();
        }
        this.setId(warehouseInfo.getId());
        this.setName(warehouseInfo.getName());
        this.setPhone(warehouseInfo.getPhone());
        this.setAddress(warehouseInfo.getAddress());
        this.setLoaction(warehouseInfo.getLoaction());
        this.setExplain(warehouseInfo.getExplain());
        this.setCreateTime(DateUtils.timestampToStrDate(warehouseInfo.getCreateTime()));
        return this;
    }
}
