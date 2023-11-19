package cn.peyton.plum.mall.service;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.MaterialParam;
import cn.peyton.plum.mall.pojo.Material;

/**
 * <h3> 素材库 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface MaterialService extends IBaseService<Long, Material, MaterialParam> {

    /**
     * <h4>判断有没有关联分组</h4>
     * @param groupId 分组Id
     * @return 有关联为 true
     */
    Boolean joinGroup(Long groupId);

}
