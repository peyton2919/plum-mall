package cn.peyton.plum.mall.param.party;


import cn.peyton.plum.core.anno.img.ImageHostPath;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Datetime;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.pojo.party.ShareBind;

import java.io.Serializable;

/**
 * <h3> 第三方用户绑定信息{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
@ImageHostPath(name = "avatar")
public class ShareBindParam implements Serializable {
    /**
     * 编号
     */
    private Long id;
    /**
     * 类型{sinaweibo、qq、weixin等}与open_id配合使用
     */
    @NotBlank(message = "绑定类型不能为空")
    @Length(min=1,max = 45)
    private String openType;
    /**
     * 开放编号
     */
    @NotBlank(message = "绑定Id不能为空")
    @Length(min=1,max = 250)
    private String openId;
    /**
     * 用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)
     */
    private Long shareId;
    /**
     * 用户类型 默认: 0 会员、1 顾客 2 供应商、3 用户 4 员工 5 超级管理员
     */
    @Size(min = 0,max = 5)
    private Integer shareType;
    /**
     * 昵称
     */
    @Length(min = 1,max = 40)
    private String nickName;
    /**
     * 头像地址
     */
    @Length(min = 0,max = 200)
    private String avatar;
    /**
     * 说明
     */
    @Length(min = 1,max = 250)
    private String explain;
    /**
     * 创建时间
     */
    @Length(max = 40)
    @Datetime
    private String  createTime;

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
     * <h4>对象转成ShareBind对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,openType,openId,shareId,shareType,nickName,avatar,explain,createTime]
     * </pre>
     */
    public ShareBind convert() {
        ShareBind shareBind = new ShareBind();
        shareBind.setId(id);
        shareBind.setOpenType(openType);
        shareBind.setOpenId(openId);
        shareBind.setShareId(shareId);
        shareBind.setShareType(shareType);
        shareBind.setNickName(nickName);
        shareBind.setAvatar(avatar);
        shareBind.setExplain(explain);
        shareBind.setCreateTime(DateUtils.dateToTimestamp(createTime));
        return shareBind;
    }

    /**
     * <h4>ShareBind对象转成ShareBindParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,openType,openId,shareId,shareType,nickName,avatar,explain,createTime]
     * </pre>
     */
    public ShareBindParam compat(ShareBind shareBind) {
        if (null == shareBind) {
            return new ShareBindParam();
        }
        this.setId(shareBind.getId());
        this.setOpenType(shareBind.getOpenType());
        this.setOpenId(shareBind.getOpenId());
        this.setShareId(shareBind.getShareId());
        this.setShareType(shareBind.getShareType());
        this.setNickName(shareBind.getNickName());
        this.setAvatar(shareBind.getAvatar());
        this.setExplain(shareBind.getExplain());
        this.setCreateTime(DateUtils.timestampToStrDate(shareBind.getCreateTime()));
        return this;
    }
}
