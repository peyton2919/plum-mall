package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.RoleDeptBo;
import cn.peyton.plum.mall.mapper.sys.RoleDeptMapper;
import cn.peyton.plum.mall.param.sys.RoleDeptParam;
import cn.peyton.plum.mall.pojo.sys.RoleDept;
import cn.peyton.plum.mall.service.sys.RoleDeptService;
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
public class RoleDeptServiceImpl extends RealizeService<Long, RoleDept, RoleDeptParam> implements RoleDeptService {
    @Resource
    private RoleDeptMapper roleDeptMapper;

    @Override
    public BaseConvertBo<RoleDept, RoleDeptParam> bo() {
        return new RoleDeptBo();
    }

    @Override
    public IBaseMapper<Long, RoleDept> mapper() {
        return roleDeptMapper;
    }

    public RoleDeptServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
