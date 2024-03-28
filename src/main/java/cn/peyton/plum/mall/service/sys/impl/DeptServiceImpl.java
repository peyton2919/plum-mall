package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.DeptBo;
import cn.peyton.plum.mall.mapper.sys.DeptMapper;
import cn.peyton.plum.mall.param.sys.DeptParam;
import cn.peyton.plum.mall.pojo.sys.Dept;
import cn.peyton.plum.mall.service.sys.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 部门 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("deptService")
public class DeptServiceImpl extends RealizeService<Integer, Dept, DeptParam> implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Override
    public BaseConvertBo<Dept, DeptParam> bo() {
        return new DeptBo();
    }

    @Override
    public IBaseMapper<Integer, Dept> mapper() {
        return deptMapper;
    }

    public DeptServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
