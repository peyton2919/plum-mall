package cn.peyton.plum.mall.pojo;


import java.io.Serializable;

/**
 * <h3> 数据字典 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public class Dict implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 字典名称
     */
    private String name;
    /**
     * 描述
     */
    private String explain;

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
     * @param name 字典名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 字典名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param explain 描述
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

    /**
     * @return 描述
     */
    public String getExplain() {
        return explain;
    }

}
