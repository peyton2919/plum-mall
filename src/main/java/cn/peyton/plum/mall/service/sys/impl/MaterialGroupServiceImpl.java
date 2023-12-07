package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.MaterialGroupBo;
import cn.peyton.plum.mall.mapper.sys.MaterialGroupMapper;
import cn.peyton.plum.mall.param.sys.MaterialGroupParam;
import cn.peyton.plum.mall.pojo.sys.MaterialGroup;
import cn.peyton.plum.mall.service.sys.MaterialGroupService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 素材分组 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("materialGroupService")
public class MaterialGroupServiceImpl extends AbstractRealizeService<Long, MaterialGroup, MaterialGroupParam> implements MaterialGroupService {
    @Resource
    private MaterialGroupMapper materialGroupMapper;

    @Override
    public BaseConvertBo<MaterialGroup, MaterialGroupParam> initBo() {
        return new MaterialGroupBo();
    }

    @Override
    public IBaseMapper<Long, MaterialGroup> initMapper() {
        return materialGroupMapper;
    }

    public MaterialGroupServiceImpl(){
        // 开启缓存
        enabledCache = true;
        //设置缓存 key 的前缀
        keyPrefix = this.getClass().getName();
    }

}
