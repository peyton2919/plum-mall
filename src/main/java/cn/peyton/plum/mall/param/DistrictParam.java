package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.District;

import java.io.Serializable;

/**
 * <h3> 行政区 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class DistrictParam implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     * 省份Id
     */
    private Integer provinceId;
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
     * @param provinceId 省份Id
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return 省份Id
     */
    public Integer getProvinceId() {
        return provinceId;
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
     * <h4>对象转成District对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,provinceId,name,seq]
     * </pre>
     */
    public District convert() {
        District district = new District();
        district.setId(id);
        district.setProvinceId(provinceId);
        district.setName(name);
        district.setSeq(seq);
        return district;
    }

    /**
     * <h4>District对象转成DistrictParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,provinceId,name,seq]
     * </pre>
     */
    public DistrictParam compat(District district) {
        if (null == district) {
            return new DistrictParam();
        }
        this.setId(district.getId());
        this.setProvinceId(district.getProvinceId());
        this.setName(district.getName());
        this.setSeq(district.getSeq());
        return this;
    }
}
