package cn.peyton.plum.mall.param.join;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.pojo.join.Invoice;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <h3> 发票 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class InvoiceParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 名称/公司名称
     */
    @NotBlank(message = "名称/公司名称不能为空;")
    @Length(min = 1,max = 90)
    private String name;
    /**
     * 手机
     */
    @NotBlank(message = "手机号不能为空;")
    @Phone
    private String phone;
    /**
     * 邮箱
     */
    @Email
    private String email;

    /** 开票金额 */
    @MinDecimal(value = 0.01, message = "开票金额要大于0.01元")
    private BigDecimal money;

    /**
     * 税号
     */
    @NotBlank(message = "税号不能为空;")
    @Length(max = 90)
    private String code;
    /**
     * 单位地址
     */
    @Length(max = 140)
    private String path;
    /**
     * 开户行
     */
    @Length(max = 49)
    private String bankname;
    /**
     * 银行账号
     */
    @Length(max = 49)
    private String bankno;
    /**
     * 开票状态: 默认0 {0未开票1已开票}
     */
    @Size(min = 0,max = 1)
    private Integer status;
    /**
     * 类型：0个人1企业
     */
    @Size(min = 0,max = 1)
    private Integer type;
    /**
     * 创建时间
     */
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
     * @return 开票金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @param money 开票金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
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
     * <h4>对象转成Invoice对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,orderId,shaerId,shaerType,name,phone,email,code,path,bankname,bankno,status,type,createTime]
     * </pre>
     */
    public Invoice convert() {
        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setOrderId(orderId);
        invoice.setName(name);
        invoice.setPhone(phone);
        invoice.setEmail(email);
        invoice.setMoney(money);
        invoice.setCode(code);
        invoice.setPath(path);
        invoice.setBankname(bankname);
        invoice.setBankno(bankno);
        invoice.setStatus(status);
        invoice.setType(type);
        invoice.setCreateTime(DateUtils.dateToTimestamp(createTime));
        return invoice;
    }

    /**
     * <h4>Invoice对象转成InvoiceParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,orderId,shaerId,shaerType,name,phone,email,code,path,bankname,bankno,status,type,createTime]
     * </pre>
     */
    public InvoiceParam compat(Invoice invoice) {
        if (null == invoice) {
            return new InvoiceParam();
        }
        this.setId(invoice.getId());
        this.setOrderId(invoice.getOrderId());
        this.setName(invoice.getName());
        this.setPhone(invoice.getPhone());
        this.setEmail(invoice.getEmail());
        this.setMoney(invoice.getMoney());
        this.setCode(invoice.getCode());
        this.setPath(invoice.getPath());
        this.setBankname(invoice.getBankname());
        this.setBankno(invoice.getBankno());
        this.setStatus(invoice.getStatus());
        this.setType(invoice.getType());
        this.setCreateTime(DateUtils.timestampToStrDate(invoice.getCreateTime()));
        return this;
    }
}
