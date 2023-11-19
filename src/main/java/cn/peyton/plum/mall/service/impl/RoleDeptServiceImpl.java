package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.RoleDeptBo;
import cn.peyton.plum.mall.mapper.RoleDeptMapper;
import cn.peyton.plum.mall.param.RoleDeptParam;
import cn.peyton.plum.mall.pojo.RoleDept;
import cn.peyton.plum.mall.service.RoleDeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 角色部门关联 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("roleDeptService")
public class RoleDeptServiceImpl extends AbstractRealizeService<Long, RoleDept, RoleDeptParam> implements RoleDeptService {
    @Resource
    private RoleDeptMapper roleDeptMapper;

    @Override
    public BaseConvertBo<RoleDept, RoleDeptParam> initBo() {
        return new RoleDeptBo();
    }

    @Override
    public IBaseMapper<Long, RoleDept> initMapper() {
        return roleDeptMapper;
    }

}
