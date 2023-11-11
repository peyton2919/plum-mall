package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.City;

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
public class CityParam implements Serializable {
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
     * <h4>对象转成City对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,provinceId,name,seq]
     * </pre>
     */
    public City convert() {
        City city = new City();
        city.setId(id);
        city.setProvinceId(provinceId);
        city.setName(name);
        city.setSeq(seq);
        return city;
    }

    /**
     * <h4>City对象转成CityParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,provinceId,name,seq]
     * </pre>
     */
    public CityParam compat(City city) {
        if (null == city) {
            return new CityParam();
        }
        this.setId(city.getId());
        this.setProvinceId(city.getProvinceId());
        this.setName(city.getName());
        this.setSeq(city.getSeq());
        return this;
    }
}
