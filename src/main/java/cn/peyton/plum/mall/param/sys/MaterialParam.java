package cn.peyton.plum.mall.param.sys;


import cn.peyton.plum.core.anno.img.ImageHostPath;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.pojo.sys.Material;

import java.io.Serializable;

/**
 * <h3> 素材库 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
@ImageHostPath(name = "url")
public class MaterialParam implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 创建者ID
     */
    private Long createId;
    /**
     * 类型1、图片；2、视频
     */
    private Integer type;
    /**
     * 分组ID
     */
    private Long groupId;
    /**
     * 素材名
     */
    @NotBlank(message = "名称不能为空")
    @Length(min = 2,max = 180)
    private String name;
    /**
     * 素材图片路径
     */
    private String src;

    /**
     * 素材链接
     */

    private String url;
    /**
     * 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}
     */
    private Integer createType;
    /**
     * 创建时间
     */
    private String createTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param createId 创建者ID
     */
    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    /**
     * @return 创建者ID
     */
    public Long getCreateId() {
        return createId;
    }

    /**
     * @param type 类型1、图片；2、视频
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 类型1、图片；2、视频
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param groupId 分组ID
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * @return 分组ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * @param name 素材名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 素材名
     */
    public String getName() {
        return name;
    }

    /**
     * @return 素材图片路径
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param src 素材图片路径
     */
    public void setSrc(String src) {
        this.src = src;
    }
    /**
     * @param url 素材链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return 素材链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param createType 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}
     */
    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    /**
     * @return 创建者类型:默认 0 {0: 员工, 1: 供应商, 2: 管理员, 3: 会员}
     */
    public Integer getCreateType() {
        return createType;
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
     * <h4>对象转成Material对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,createId,type,groupId,name,url,createType,createTime]
     * </pre>
     */
    public Material convert() {
        Material material = new Material();
        material.setId(id);
        material.setCreateId(createId);
        material.setType(type);
        material.setGroupId(groupId);
        material.setName(name);
        material.setSrc(src);
        material.setUrl(url);
        material.setCreateType(createType);
        material.setCreateTime(DateUtils.dateToTimestamp(createTime));
        return material;
    }

    /**
     * <h4>Material对象转成MaterialParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,createId,type,groupId,name,url,createType,createTime]
     * </pre>
     */
    public MaterialParam compat(Material material) {
        if (null == material) {
            return new MaterialParam();
        }
        this.setId(material.getId());
        this.setCreateId(material.getCreateId());
        this.setType(material.getType());
        this.setGroupId(material.getGroupId());
        this.setName(material.getName());
        this.setSrc(material.getSrc());
        this.setUrl(material.getUrl());
        this.setCreateType(material.getCreateType());
        this.setCreateTime(DateUtils.timestampToStrDate(material.getCreateTime()));
        return this;
    }
}
