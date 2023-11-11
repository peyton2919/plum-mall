package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.mall.bo.ExpressCompanyBo;
import cn.peyton.plum.mall.mapper.ExpressCompanyMapper;
import cn.peyton.plum.mall.param.ExpressCompanyParam;
import cn.peyton.plum.mall.pojo.ExpressCompany;
import cn.peyton.plum.mall.service.ExpressCompanyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 快递公司 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("expressCompanyService")
public class ExpressCompanyServiceImpl extends AbstractAppRealizeService<Integer, ExpressCompany, ExpressCompanyParam> implements ExpressCompanyService {
    @Resource
    private ExpressCompanyMapper expressCompanyMapper;

    @Override
    public BaseConvertBo<ExpressCompany, ExpressCompanyParam> initBo() {
        return new ExpressCompanyBo();
    }

    @Override
    public IBaseMapper<Integer, ExpressCompany> initMapper() {
        return expressCompanyMapper;
    }

}