package cn.peyton.plum.mall.param.sys;


import cn.peyton.plum.mall.pojo.sys.AreaAll;

import java.io.Serializable;

/**
 * <h3> 城市 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class AreaAllParam implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 城市id
     */
    private Integer cityId;
    /**
     * 省市级别,0省1市2县3区4镇5乡6村
     */
    private Integer level;
    /**
     * 父级id
     */
    private Integer parentId;
    /**
     * 区号
     */
    private String areaCode;
    /**
     * 名称
     */
    private String name;
    /**
     * 合并名称,如：省名,市名,县名...
     */
    private String mergerName;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 是否展示
     */
    private Boolean isShow;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param cityId 城市id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * @return 城市id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * @param level 省市级别,0省1市2县3区4镇5乡6村
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return 省市级别, 0省1市2县3区4镇5乡6村
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param parentId 父级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return 父级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param areaCode 区号
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * @return 区号
     */
    public String getAreaCode() {
        return areaCode;
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
     * @param mergerName 合并名称,如：省名,市名,县名...
     */
    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    /**
     * @return 合并名称, 如：省名,市名,县名...
     */
    public String getMergerName() {
        return mergerName;
    }

    /**
     * @param lng 经度
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return 经度
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return 纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param isShow 是否展示
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * @return 是否展示
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * <h4>对象转成AreaAll对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cityId,level,parentId,areaCode,name,mergerName,lng,lat,isShow]
     * </pre>
     */
    public AreaAll convert() {
        AreaAll areaAll = new AreaAll();
        areaAll.setId(id);
        areaAll.setCityId(cityId);
        areaAll.setLevel(level);
        areaAll.setParentId(parentId);
        areaAll.setAreaCode(areaCode);
        areaAll.setName(name);
        areaAll.setMergerName(mergerName);
        areaAll.setLng(lng);
        areaAll.setLat(lat);
        areaAll.setIsShow(isShow);
        return areaAll;
    }

    /**
     * <h4>AreaAll对象转成AreaAllParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cityId,level,parentId,areaCode,name,mergerName,lng,lat,isShow]
     * </pre>
     */
    public AreaAllParam compat(AreaAll areaAll) {
        if (null == areaAll) {
            return new AreaAllParam();
        }
        this.setId(areaAll.getId());
        this.setCityId(areaAll.getCityId());
        this.setLevel(areaAll.getLevel());
        this.setParentId(areaAll.getParentId());
        this.setAreaCode(areaAll.getAreaCode());
        this.setName(areaAll.getName());
        this.setMergerName(areaAll.getMergerName());
        this.setLng(areaAll.getLng());
        this.setLat(areaAll.getLat());
        this.setIsShow(areaAll.getIsShow());
        return this;
    }
}
