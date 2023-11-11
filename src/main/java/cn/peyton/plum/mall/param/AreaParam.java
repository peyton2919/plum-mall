package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.Area;

import java.io.Serializable;

/**
 * <h3> 全部区域 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class AreaParam implements Serializable {
    /**
     *
     */
    private Long id;
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
     * <h4>对象转成Area对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq]
     * </pre>
     */
    public Area convert() {
        Area area = new Area();
        area.setId(id);
        area.setName(name);
        area.setSeq(seq);
        return area;
    }

    /**
     * <h4>Area对象转成AreaParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,seq]
     * </pre>
     */
    public AreaParam compat(Area area) {
        if (null == area) {
            return new AreaParam();
        }
        this.setId(area.getId());
        this.setName(area.getName());
        this.setSeq(area.getSeq());
        return this;
    }
}
