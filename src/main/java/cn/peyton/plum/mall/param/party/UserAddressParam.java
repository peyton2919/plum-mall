package cn.peyton.plum.mall.param.party;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;

import java.io.Serializable;

/**
 * <h3> 用户地址{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class UserAddressParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    @NotBlank(message = "当前用户ID不能为空;")
    private Long shareId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    @NotBlank(message = "类型不能为空;")
    @Size(min = 0,max = 5)
    private Integer shareType;
    /**
     * 省
     */
    @Length(max = 50)
    private String province;
    /**
     * 市
     */
    @Length(max = 50)
    private String city;
    /**
     * 区
     */
    @Length(max = 50)
    private String district;
    /**
     * 具体地址
     */
    @Length(max = 150)
    private String address;
    /**
     * 邮编
     */
    @Length(max = 6)
    private String zip;
    /**
     * 联系人
     */
    @Length(max = 30)
    private String name;
    /**
     * 联系电话
     */
    @Phone
    private String phone;
    /**
     * 最后一次使用
     */
    @Date
    private String lastUsedTime;
    /**
     * 创建时间
     */
    @Date
    private String createTime;

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
     * @param shareId 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }

    /**
     * @return 用户ID(包含 : 会员Id 、 供应商Id 、 员工Id等, 配合share_type一起使用)
     */
    public Long getShareId() {
        return shareId;
    }

    /**
     * @param shareType 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    /**
     * @return 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public Integer getShareType() {
        return shareType;
    }

    /**
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return 市
     */
    public String getCity() {
        return city;
    }

    /**
     * @param district 区
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return 区
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param address 具体地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return 具体地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param zip 邮编
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return 邮编
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param name 联系人
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 联系人
     */
    public String getName() {
        return name;
    }

    /**
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param lastUsedTime 最后一次使用
     */
    public void setLastUsedTime(String lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    /**
     * @return 最后一次使用
     */
    public String getLastUsedTime() {
        return lastUsedTime;
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
     * <h4>对象转成MemberAddress对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,shareId,shareType,province,city,district,address,zip,name,phone,lastUsedTime,createTime]
     * </pre>
     */
    public cn.peyton.plum.mall.pojo.party.UserAddress convert() {
        cn.peyton.plum.mall.pojo.party.UserAddress userAddress = new cn.peyton.plum.mall.pojo.party.UserAddress();
        userAddress.setId(id);
        userAddress.setShareId(shareId);
        userAddress.setShareType(shareType);
        userAddress.setProvince(province);
        userAddress.setCity(city);
        userAddress.setDistrict(district);
        userAddress.setAddress(address);
        userAddress.setZip(zip);
        userAddress.setName(name);
        userAddress.setPhone(phone);
        userAddress.setLastUsedTime(DateUtils.dateToTimestamp(lastUsedTime));
        userAddress.setCreateTime(DateUtils.dateToTimestamp(createTime));
        return userAddress;
    }

    /**
     * <h4>MemberAddress对象转成MemberAddressParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,shareId,shareType,province,city,district,address,zip,name,phone,lastUsedTime,createTime]
     * </pre>
     */
    public UserAddressParam compat(cn.peyton.plum.mall.pojo.party.UserAddress userAddress) {
        if (null == userAddress) {
            return new UserAddressParam();
        }
        this.setId(userAddress.getId());
        this.setShareId(userAddress.getShareId());
        this.setShareType(userAddress.getShareType());
        this.setProvince(userAddress.getProvince());
        this.setCity(userAddress.getCity());
        this.setDistrict(userAddress.getDistrict());
        this.setAddress(userAddress.getAddress());
        this.setZip(userAddress.getZip());
        this.setName(userAddress.getName());
        this.setPhone(userAddress.getPhone());
        this.setLastUsedTime(DateUtils.timestampToStrDate(userAddress.getLastUsedTime()));
        this.setCreateTime(DateUtils.timestampToStrDate(userAddress.getCreateTime()));
        return this;
    }
}
