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
