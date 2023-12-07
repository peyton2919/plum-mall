package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.mall.bo.DictDetailBo;
import cn.peyton.plum.mall.mapper.sys.DictDetailMapper;
import cn.peyton.plum.mall.param.sys.DictDetailParam;
import cn.peyton.plum.mall.pojo.sys.DictDetail;
import cn.peyton.plum.mall.service.sys.DictDetailService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 数据字典详情 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("dictDetailService")
public class DictDetailServiceImpl extends AbstractRealizeService<Long, DictDetail, DictDetailParam> implements DictDetailService {
    @Resource
    private DictDetailMapper dictDetailMapper;

    @Override
    public BaseConvertBo<DictDetail, DictDetailParam> initBo() {
        return new DictDetailBo();
    }

    @Override
    public IBaseMapper<Long, DictDetail> initMapper() {
        return dictDetailMapper;
    }

    public DictDetailServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
