package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.RolesDeptsBo;
import cn.peyton.plum.mall.mapper.RolesDeptsMapper;
import cn.peyton.plum.mall.param.RolesDeptsParam;
import cn.peyton.plum.mall.pojo.RolesDepts;
import cn.peyton.plum.mall.service.RolesDeptsService;
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
@Service("rolesDeptsService")
public class RolesDeptsServiceImpl extends AbstractAppRealizeService<Long, RolesDepts, RolesDeptsParam> implements RolesDeptsService {
    @Resource
    private RolesDeptsMapper rolesDeptsMapper;

    @Override
    public BaseConvertBo<RolesDepts, RolesDeptsParam> initBo() {
        return new RolesDeptsBo();
    }

    @Override
    public IBaseMapper<Long, RolesDepts> initMapper() {
        return rolesDeptsMapper;
    }

}
