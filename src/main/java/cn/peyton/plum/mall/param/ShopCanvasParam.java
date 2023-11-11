package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopCanvas;

import java.io.Serializable;

/**
 * <h3> 画布信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopCanvasParam implements Serializable {
    /**
     * 画布id
     */
    private Long id;
    /**
     * 终端 1-小程序 2-H5 3-APP 4-PC
     */
    private Integer terminal;
    /**
     * 画布json数据
     */
    private String json;
    /**
     * 类型 1-系统画布 2-自定义页面 3-商家店铺装修
     */
    private Integer type;
    /**
     * 名称
     */
    private String name;
    /**
     * 是否删除: 默认1(1：可用;0已删除)
     */
    private Integer isDel;
    /**
     * 创建时间
     */
    private Integer createTime;
    /**
     * 修改时间
     */
    private Integer updateTime;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 画布id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 画布id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param terminal 终端 1-小程序 2-H5 3-APP 4-PC
     */
    public void setTerminal(Integer terminal) {
        this.terminal = terminal;
    }

    /**
     * @return 终端 1-小程序 2-H5 3-APP 4-PC
     */
    public Integer getTerminal() {
        return terminal;
    }

    /**
     * @param json 画布json数据
     */
    public void setJson(String json) {
        this.json = json;
    }

    /**
     * @return 画布json数据
     */
    public String getJson() {
        return json;
    }

    /**
     * @param type 类型 1-系统画布 2-自定义页面 3-商家店铺装修
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 类型 1-系统画布 2-自定义页面 3-商家店铺装修
     */
    public Integer getType() {
        return type;
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
     * @param isDel 是否删除: 默认1(1：可用;0已删除)
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除: 默认1(1：可用;0已删除)
     */
    public Integer getIsDel() {
        return isDel;
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
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 修改时间
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /**
     * <h4>对象转成ShopCanvas对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,terminal,json,type,name,isDel,createTime,updateTime]
     * </pre>
     */
    public ShopCanvas convert() {
        ShopCanvas shopCanvas = new ShopCanvas();
        shopCanvas.setId(id);
        shopCanvas.setTerminal(terminal);
        shopCanvas.setJson(json);
        shopCanvas.setType(type);
        shopCanvas.setName(name);
        shopCanvas.setIsDel(isDel);
        shopCanvas.setCreateTime(createTime);
        shopCanvas.setUpdateTime(updateTime);
        return shopCanvas;
    }

    /**
     * <h4>ShopCanvas对象转成ShopCanvasParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,terminal,json,type,name,isDel,createTime,updateTime]
     * </pre>
     */
    public ShopCanvasParam compat(ShopCanvas shopCanvas) {
        if (null == shopCanvas) {
            return new ShopCanvasParam();
        }
        this.setId(shopCanvas.getId());
        this.setTerminal(shopCanvas.getTerminal());
        this.setJson(shopCanvas.getJson());
        this.setType(shopCanvas.getType());
        this.setName(shopCanvas.getName());
        this.setIsDel(shopCanvas.getIsDel());
        this.setCreateTime(shopCanvas.getCreateTime());
        this.setUpdateTime(shopCanvas.getUpdateTime());
        return this;
    }
}
