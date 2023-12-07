package cn.peyton.plum.mall.pojo.party;


import java.io.Serializable;

/**
 * <h3> 第三方用户绑定信息{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class ShareBind implements Serializable {
    /**
     * 编号
     */
    private Long id;
    /**
     * 类型{sinaweibo、qq、weixin等}与open_id配合使用
     */
    private String openType;
    /**
     * 开放编号
     */
    private String openId;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shaerId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    private Integer shaerType;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 说明
     */
    private String explain;
    /**
     * 创建时间
     */
    private Integer createTime;

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
     * @param openType 类型{sinaweibo、qq、weixin等}与open_id配合使用
     */
    public void setOpenType(String openType) {
        this.openType = openType;
    }

    /**
     * @return 类型{sinaweibo、qq、weixin等}与open_id配合使用
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * @param openId 开放编号
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return 开放编号
     */
    public String getOpenId() {
        return openId;
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
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param avatar 头像地址
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return 头像地址
     */
    public String getAvatar() {
        return avatar;
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
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

}
