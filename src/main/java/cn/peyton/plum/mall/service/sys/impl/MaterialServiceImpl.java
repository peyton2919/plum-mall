package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.MaterialBo;
import cn.peyton.plum.mall.mapper.sys.MaterialMapper;
import cn.peyton.plum.mall.param.sys.MaterialParam;
import cn.peyton.plum.mall.pojo.sys.Material;
import cn.peyton.plum.mall.service.sys.MaterialService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 素材库 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("materialService")
public class MaterialServiceImpl extends AbstractRealizeService<Long, Material, MaterialParam> implements MaterialService {
    @Resource
    private MaterialMapper materialMapper;

    @Override
    public BaseConvertBo<Material, MaterialParam> initBo() {
        return new MaterialBo();
    }

    @Override
    public IBaseMapper<Long, Material> initMapper() {
        return materialMapper;
    }

    public MaterialServiceImpl() {
        // 开启缓存
        enabledCache = true;
        //设置缓存 key 的前缀
        keyPrefix = this.getClass().getName();
    }

    @Override
    public Boolean joinGroup(Long groupId) {
        return materialMapper.joinGroup(groupId) > 0;
    }
}
