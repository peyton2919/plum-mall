package cn.peyton.plum.mall.pojo.join;


import java.io.Serializable;

/**
 * <h3> 发票 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class Invoice implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shaerId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    private Integer shaerType;
    /**
     * 名称/公司名称
     */
    private String name;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 税号
     */
    private String code;
    /**
     * 单位地址
     */
    private String path;
    /**
     * 开户行
     */
    private String bankname;
    /**
     * 银行账号
     */
    private String bankno;
    /**
     * 开票状态: 默认0 {0未开票1已开票}
     */
    private Integer status;
    /**
     * 类型：0个人1企业
     */
    private Integer type;
    /**
     * 创建时间
     */
    private Integer createTime;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Boolean isDel;

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
     * @param orderId 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return 订单id
     */
    public Long getOrderId() {
        return orderId;
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
     * @param shaerType 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public void setShaerType(Integer shaerType) {
        this.shaerType = shaerType;
    }

    /**
     * @return 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    public Integer getShaerType() {
        return shaerType;
    }

    /**
     * @param name 名称/公司名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 名称/公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param code 税号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return 税号
     */
    public String getCode() {
        return code;
    }

    /**
     * @param path 单位地址
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return 单位地址
     */
    public String getPath() {
        return path;
    }

    /**
     * @param bankname 开户行
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    /**
     * @return 开户行
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * @param bankno 银行账号
     */
    public void setBankno(String bankno) {
        this.bankno = bankno;
    }

    /**
     * @return 银行账号
     */
    public String getBankno() {
        return bankno;
    }

    /**
     * @param status 开票状态: 默认0 {0未开票1已开票}
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 开票状态: 默认0 {0未开票1已开票}
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param type 类型：0个人1企业
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 类型：0个人1企业
     */
    public Integer getType() {
        return type;
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
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Boolean getIsDel() {
        return isDel;
    }

}
