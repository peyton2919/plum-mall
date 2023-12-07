package cn.peyton.plum.mall.param.sys;


import cn.peyton.plum.mall.pojo.sys.Province;

import java.io.Serializable;

/**
 * <h3> 省份 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ProvinceParam implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 地区Id
     */
    private Integer areaId;
    /**
     * 名称
     */
    private String name;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;

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
     * @param areaId 地区Id
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * @return 地区Id
     */
    public Integer getAreaId() {
        return areaId;
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
     * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public void setSeq(Short seq) {
        this.seq = seq;
    }

    /**
     * @return 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public Short getSeq() {
        return seq;
    }

    /**
     * <h4>对象转成Province对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,areaId,name,seq]
     * </pre>
     */
    public Province convert() {
        Province province = new Province();
        province.setId(id);
        province.setAreaId(areaId);
        province.setName(name);
        province.setSeq(seq);
        return province;
    }

    /**
     * <h4>Province对象转成ProvinceParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,areaId,name,seq]
     * </pre>
     */
    public ProvinceParam compat(Province province) {
        if (null == province) {
            return new ProvinceParam();
        }
        this.setId(province.getId());
        this.setAreaId(province.getAreaId());
        this.setName(province.getName());
        this.setSeq(province.getSeq());
        return this;
    }
}
